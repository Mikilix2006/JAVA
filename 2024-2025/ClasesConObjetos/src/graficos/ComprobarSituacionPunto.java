package graficos;

import java.awt.Color;

import objetos.Circulo;
import objetos.Punto;
import utilidades.StdDraw;

public class ComprobarSituacionPunto {
	
	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Punto p=new Punto(-50,60,Color.RED);
		Circulo c=new Circulo(50,40,15);
		c.getCentro().setColor(Color.GREEN);
		
		Circulo c2=new Circulo(0,0,50);
		c2.getCentro().setColor(Color.BLUE);
		
		while (true) {
			StdDraw.clear();
			if (c2.contiene(p))
				StdDraw.text(0, 90, "Punto dentro");
			else
				StdDraw.text(0, 90, "Punto fuera");
			if (c2.seSuperpone(c))
				StdDraw.text(0, 80, "Circulo superpuesto");
			else
				StdDraw.text(0, 80, "Circulo no superpuesto");
			
			p.dibujar();
			c.dibujar();
			c2.dibujar(false);

			c2.getCentro().setX(StdDraw.mouseX());
			c2.getCentro().setY(StdDraw.mouseY());

			StdDraw.show();
			StdDraw.pause(50);
		}

	}
}
