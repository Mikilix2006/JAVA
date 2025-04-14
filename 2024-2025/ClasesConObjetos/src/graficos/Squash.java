package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import objetos.Raqueta;
import utilidades.StdDraw;

public class Squash {

	public static void main(String[] args) {
		StdDraw.setXscale(-100,100);
		StdDraw.setYscale(-100,100);
		StdDraw.enableDoubleBuffering();
		
		List <Circulo> pelotas = new ArrayList <Circulo>();
		
		Random r=new Random();
		Raqueta raq=new Raqueta(-20,-95,40);
		Circulo pelota=new Circulo(0,95,7,-9,2,Color.CYAN);
		pelotas.add(pelota);
		
		boolean released=true;
		
		for (;;) {
			StdDraw.clear();
			
			StdDraw.text(0, 95, "Cant. pelotas: "+pelotas.size());
			
			for (int i=0; i<pelotas.size(); i++) {
				pelotas.get(i).mover();
				pelotas.get(i).controlarRebote();
				pelotas.get(i).reboteRaqueta(raq);
				pelotas.get(i).dibujar();
				// Quitar la pelota si rebota con el borde inferior
				if (pelotas.get(i).getRadio()-100>pelotas.get(i).getCentro().getY()) {
					pelotas.remove(i);
					i--;
				}
			}
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && released) {
				Color colorAleat = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
				if (r.nextBoolean()) {
					Circulo nueva=new Circulo(0,95,r.nextDouble(5,7),-r.nextDouble(4,9),2,colorAleat);
					pelotas.add(nueva);
				} else {
					Circulo nueva=new Circulo(0,95,r.nextDouble(-7,-5),-r.nextDouble(4,9),2,colorAleat);
					pelotas.add(nueva);
				}
				released=false;
			}
			
			if (!(StdDraw.isKeyPressed(KeyEvent.VK_SPACE))) {
				released = true;
			}
			
			raq.movimiento();
			raq.controlarLimites();
			raq.dibujar();
			
			StdDraw.show();
			StdDraw.pause(50);
		}
	}
	
}
