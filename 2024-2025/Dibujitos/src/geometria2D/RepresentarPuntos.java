package geometria2D;

import java.awt.Color;

import utilidades.StdDraw;

public class RepresentarPuntos {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Punto p1 = new Punto(50,50,Color.YELLOW);
		Punto p2 = new Punto(0,0);
		
		
		for (;;) {
			Punto puntoMedio = p1.puntoMedioHasta(p2);
			double dist = p1.distanciaHasta(p2);
			double distMedio = p1.distanciaHasta(puntoMedio);
			
			StdDraw.clear();

			p1.setX(StdDraw.mouseX());
			p1.setY(StdDraw.mouseY());
			
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.setPenRadius(0.005);
			StdDraw.line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			
			if (p1.getX()>0 && p1.getY()>0) {
				p1.setColor(new Color(160, 80, 0));
			}
			if (p1.getX()<0 && p1.getY()>0) {
				p1.setColor(Color.CYAN);
			}
			if (p1.getX()>0 && p1.getY()<0) {
				p1.setColor(Color.MAGENTA);
			}
			if (p1.getX()<0 && p1.getY()<0) {
				p1.setColor(Color.GREEN);
			}
			
			
			StdDraw.text(0,90,"Distancia al punto negro: "+dist);
			StdDraw.text(0,80,"Distancia al punto medio: "+distMedio);
			p1.dibujar();
			p2.dibujar();
			puntoMedio.dibujar();
			
			StdDraw.show();
			StdDraw.pause(1);

		}

	}

}
