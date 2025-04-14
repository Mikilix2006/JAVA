package juego;

import utilidades.FuncCasino;
import utilidades.StdDraw;

public class Casino {

	public static void main(String[] args) {
		
		// Pantalla
		StdDraw.setCanvasSize(650, 650);
		StdDraw.setXscale(-650, 650);
		StdDraw.setYscale(-650, 650);
		
		StdDraw.enableDoubleBuffering();
				
		for (;;) {
			StdDraw.clear();
			
			FuncCasino.menu();
			
			// Seleccionar modo de juego
			switch (FuncCasino.detectarClick()) {
			case 1:
				BlackJack.main(args);
				break;
			default:
				break;
			}
			
			// Condiciones finales obligatorias
			StdDraw.show();
			StdDraw.pause(16); // 60 fps
		}
		
	}

}
