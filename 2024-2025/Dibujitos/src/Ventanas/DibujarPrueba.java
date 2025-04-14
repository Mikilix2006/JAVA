package Ventanas;

import java.awt.event.KeyEvent;

import utilidades.StdDraw;

public class DibujarPrueba {

	public static void main(String[] args) {
		int xNube=-160;
		StdDraw.enableDoubleBuffering();
		for (;;) {
			StdDraw.setXscale(-100, 100);
			StdDraw.setYscale(-100, 100);
			StdDraw.setPenRadius(0.05);
			StdDraw.setPenRadius(0.01);
	        StdDraw.setPenColor(StdDraw.BLUE);
	        StdDraw.filledRectangle(0, 0, 100, 100);
	        StdDraw.setPenColor(StdDraw.GREEN);
	        StdDraw.filledRectangle(0, -70, 100, 40);
	        StdDraw.setPenRadius(0.05);
	        StdDraw.setPenColor(StdDraw.RED);
	        StdDraw.line(-50, 50, 50, 50);
	        StdDraw.setPenColor(StdDraw.YELLOW); // Bandas amarillas
	        StdDraw.line(-50, 40, 50, 40);
	        StdDraw.line(-50, 30, 50, 30);
	        StdDraw.setPenColor(StdDraw.RED);
	        StdDraw.line(-50, 20, 50, 20);
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.line(-50, 60, -50, -40); // Palo de bandera
	        StdDraw.rectangle(0, 35, 50, 25); // Recuadro de la bandera
	        StdDraw.setPenColor(StdDraw.YELLOW);
	        StdDraw.filledCircle(100, 100, 40); // El sol
	        StdDraw.setPenColor(StdDraw.WHITE); // Nubes
	        xNube = xNube + 1;
	        if (xNube==140)
	        	xNube = -160;
	        StdDraw.filledCircle(xNube+40, 100, 20);
	        StdDraw.filledCircle(xNube+20, 100, 25);
	        StdDraw.filledCircle(xNube, 100, 20);
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.rectangle(0, 0, 100, 100); // Recuadro de la ventana
	        StdDraw.text(0, 35, "VIVA ESPAÑA");
	        
	        // Detecta si el ratón está pulsado
	        if (StdDraw.isMousePressed())
	        	System.exit(0);
	        // Detecta si una tecla está pulsada
	        if (StdDraw.isKeyPressed(KeyEvent.VK_C))
	        	System.exit(0);
	        
	        StdDraw.show(); // muestra el fotograma
	        StdDraw.pause(50); // hace una pausa en milesimas
		}
	}

}
