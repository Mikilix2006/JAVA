package Ventanas;

// para que ambos funcionen, tiene que estar el java compiler en la version 17

import java.util.Random;
import utilidades.StdDraw;

public class Bolitas {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Random r = new Random();
		double x = 0;
		double dx = r.nextDouble(-4, 4);
		double y = 0;
		double dy = r.nextDouble(-4, 4);

		double x2 = 0;
		double dx2 = r.nextDouble(-4, 4);
		double y2 = 0;
		double dy2 = r.nextDouble(-4, 4);

		for (;;) {
			StdDraw.clear();

			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(x, y, 10);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledCircle(x, y, 5);

			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(x2, y2, 10);

			x = x + dx;
			y = y + dy;
			if (x >= 90 || x <= -90)
				dx = -dx;
			if (y >= 90 || y <= -90)
				dy = -dy;
			
			x2 = x2 + dx2;
			y2 = y2 + dy2;
			if (x2 >= 90 || x2 <= -90)
				dx2 = -dx2;
			if (y2 >= 90 || y2 <= -90)
				dy2 = -dy2;

			StdDraw.show();
			StdDraw.pause(10);

		}

	}
}
