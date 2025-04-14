package graficos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Punto;
import utilidades.Func;
import utilidades.StdDraw;

public class PuntosEnMovimientoLista {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Random r = new Random();

		List<Punto> puntos = new ArrayList<Punto>();
		for (int i = 0; i < 10; i++) {
			Punto p = Func.crearPuntoAleatorio(r.nextDouble(-100, 100), r.nextDouble(-100, 100));
			puntos.add(p);
		}

		while (true) {
			StdDraw.clear();
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(0, 95, "Cantidad de puntos: "+puntos.size());
			StdDraw.text(0, 85, "Pulse el ratón para crear puntos");

			for (int i = 0; i < puntos.size(); i++) {
				puntos.get(i).controlarRebote();
				puntos.get(i).mover(); // Se desplaza el punto según movX y MovY
				puntos.get(i).dibujar();
			}

			// Creamos puntos cuando el ratón está pulsado
			if (StdDraw.isMousePressed()) {
				Punto p = Func.crearPuntoAleatorio(StdDraw.mouseX(), StdDraw.mouseY());
				puntos.add(p);
			}

			if (puntos.size()<400) {
				// Comprobar si hay dos puntos cerca
				List<Punto> nuevos = new ArrayList<Punto>();
				for (int i = 0; i < puntos.size()-1; i++) {
					for (int otro = i + 1; otro < puntos.size(); otro++) {
						if (puntos.get(i).distancia(puntos.get(otro)) < 2) {
							// Añadimos nuevo punto por colision de dos puntos
							Punto medio=puntos.get(i).puntoMedio(puntos.get(otro));
							nuevos.add(Func.crearPuntoAleatorio(medio.getX(), medio.getY()));
							System.out.println(nuevos.size()+puntos.size());
						}
					}
				}
			// Añadimos los puntos que se han creado por colision al resto de puntos
			puntos.addAll(nuevos);
			}
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	
}