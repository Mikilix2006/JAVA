package Ventanas;

import java.awt.Color;
import java.awt.event.KeyEvent;

import utilidades.StdDraw;

public class PintarEnLienzo {

	public static void main(String[] args) {
		int color = 1;
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.03);
		StdDraw.setXscale(-200, 200);
		StdDraw.setYscale(-200, 200);
		;
		for (;;) {
//			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(-100, -190, "Borrar lienzo: Barra espaciadora");
			StdDraw.text(-100, -180, "Rojo: 'R'");
			StdDraw.text(-100, -170, "Verde: 'V'");
			StdDraw.text(-100, -160, "Azul: 'A'");
			StdDraw.text(-100, -150, "Negro: 'N'");
			StdDraw.text(-100, -140, "Borrador: 'B'");
			if (StdDraw.isKeyPressed(KeyEvent.VK_R))
				color = 2;
			else {
				if (StdDraw.isKeyPressed(KeyEvent.VK_V))
					color = 3;
				else {
					if (StdDraw.isKeyPressed(KeyEvent.VK_A))
						color = 4;
					else {
						if (StdDraw.isKeyPressed(KeyEvent.VK_N))
							color = 1;
						else {
							if (StdDraw.isKeyPressed(KeyEvent.VK_B))
								color = 5;
							else {
								if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
									StdDraw.setPenColor(Color.WHITE);
									StdDraw.filledRectangle(0, 0, 200, 200);
									StdDraw.setPenColor(Color.BLACK);
								}
							}
						}
					}
				}
			}
			switch (color) {
			case 1:
				StdDraw.setPenColor(Color.BLACK);
				break;
			case 2:
				StdDraw.setPenColor(Color.RED);
				break;
			case 3:
				StdDraw.setPenColor(Color.GREEN);
				break;
			case 4:
				StdDraw.setPenColor(Color.BLUE);
				break;
			case 5:
				StdDraw.setPenColor(Color.WHITE);
				break;
			}
			if (StdDraw.isMousePressed())
				StdDraw.point(StdDraw.mouseX(), StdDraw.mouseY());
			StdDraw.setPenColor(Color.BLACK);
		}
	}

}
