package graficos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import utilidades.Func;
import utilidades.StdAudio;
import utilidades.StdDraw;

public class CazadorDePuntos {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Random r = new Random();

		List<Punto> puntos = new ArrayList<Punto>();
		for (int i = 0; i < 20; i++) {
			Punto p = Func.crearPuntoAleatorio(r.nextDouble(-100, 100), r.nextDouble(-100, 100));
			puntos.add(p);
		}
		
		Circulo lazo=new Circulo(0,0,20,Color.GREEN);

		long inicio=System.currentTimeMillis();
		boolean tiempoTomado = false;
		Long fin = null;
		
		while (true) {
			StdDraw.clear();
			
			lazo.getCentro().setX(StdDraw.mouseX());			
			lazo.getCentro().setY(StdDraw.mouseY());
			
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(0, 95, "Cantidad de puntos: "+puntos.size());
			if (tiempoTomado) {
				StdDraw.text(0, 90, "Has cogido todos los puntos en: "+((fin-inicio))+" milisegundos");
			}
			
			for (int i = 0; i < puntos.size(); i++) {
				puntos.get(i).controlarRebote();
				puntos.get(i).mover(); // Se desplaza el punto según la x e y
				puntos.get(i).dibujar();
				if (lazo.contiene(puntos.get(i))) {
					puntos.remove(i);
					StdAudio.playInBackground("soniquete.wav");
				}
			}
			
			if (puntos.size()==0 && !tiempoTomado) {
				fin=System.currentTimeMillis();
				tiempoTomado = true;
			}
			
			lazo.dibujar(false);
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

}
