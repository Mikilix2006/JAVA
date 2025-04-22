package juego;

import utilidades.Func;
import utilidades.StdDraw;

public class Ajedrez {

	public static void main(String[] args) {
		/**
		 *  Preparación de lienzo
		 */
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1500, 800);
		StdDraw.setXscale(0, 1500);
		StdDraw.setYscale(0, 800);

		/**
		 *  Asigna las fichas en una matriz en sus posiciones correspondientes
		 */
		Func.colocarFichas();

		// Inicio de bucle de animación
		for (;;) {
			StdDraw.clear();

			// Ejecuta las funciones básicas del juego
			Func.funcionesBasicas();

			StdDraw.show();
			StdDraw.pause(16); // 60 fps
		}
	}

}
