package graficos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import utilidades.Func;
import utilidades.StdDraw;

public class CirculosEnMovimientoLista {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Random r = new Random();

		List<Circulo> circulos = new ArrayList<Circulo>();
		for (int i = 0; i < 20; i++) {
			Punto p = Func.crearPuntoAleatorio(r.nextDouble(-95, 95), r.nextDouble(-95, 95));
			Circulo c=new Circulo(p, r.nextDouble(1,5));
			circulos.add(c);
		}

		while (true) {
			StdDraw.clear();
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(0, 95, "Cantidad de circulos: "+circulos.size());
			StdDraw.text(0, 85, "Pulse el ratón para crear circulos");

			for (int i = 0; i < circulos.size(); i++) {
				circulos.get(i).controlarRebote();
				circulos.get(i).mover(); // Se desplaza el circulo según la x e y del punto
				circulos.get(i).dibujar(r.nextBoolean());
			}

			// Creamos puntos cuando el ratón está pulsado
			if (StdDraw.isMousePressed()) {
				Circulo p = Func.crearCirculoAleatorio(StdDraw.mouseX(), StdDraw.mouseY());
				circulos.add(p);
			}

			if (circulos.size()<50) {
				// Comprobar si hay dos circulos cerca
				List<Circulo> nuevos = new ArrayList<Circulo>();
				for (int i = 0; i < circulos.size()-1; i++) {
					for (int otro = i + 1; otro < circulos.size(); otro++) {
						if (circulos.get(i).distancia(circulos.get(otro)) < circulos.get(i).getRadio()+circulos.get(otro).getRadio()) {
							// Añadimos nuevo punto por colision de dos puntos
							Punto medio=circulos.get(i).puntoMedio(circulos.get(otro));
							nuevos.add(Func.crearCirculoAleatorio(medio.getX(), medio.getY()));
							System.out.println(nuevos.size()+circulos.size());
						}
					}
				}
			// Añadimos los puntos que se han creado por colision al resto de puntos
			circulos.addAll(nuevos);
			}
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	
}