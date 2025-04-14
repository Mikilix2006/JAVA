package utilidades;

import java.awt.Color;

public class FuncCasino {
		
	public static void menu() {
		StdDraw.setPenColor(0,110,0);
		StdDraw.filledRectangle(0, 0, 900, 900);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0, 500, "CASINO MIKILIX");
		StdDraw.text(0, 200, "BLACKJACK");
		detectarRaton();
	}
	
	public static int detectarClick() {
		if (StdDraw.mouseX()<100 &&
				StdDraw.mouseX()>-100 &&
				StdDraw.mouseY()<300 &&
				StdDraw.mouseY()>100 &&
				StdDraw.isMousePressed()) {
					return 1;
			}
		return 0;
	}

	private static void detectarRaton() {
		if (StdDraw.mouseX()<100 &&
			StdDraw.mouseX()>-100 &&
			StdDraw.mouseY()<300 &&
			StdDraw.mouseY()>100) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.01);
				StdDraw.rectangle(0, 200, 100, 50);
		}
	}

}
