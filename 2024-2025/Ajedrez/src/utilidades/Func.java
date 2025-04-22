package utilidades;

import java.awt.Color;

import clases.Ficha;

public class Func {

	/**
	 *  Matriz tablero que guarda las posiciones de cada ficha
	 */
	public static Ficha[][] tablero = new Ficha[8][8];
	
	/**
	 *  Define el tamaño de las casillas
	 */
	public static int tamañoCasilla = 100;
	
	/**
	 *  Define que turno se juega
	 *  true: blancas
	 *  false: negras
	 */
	public static boolean turnoBlancas = true;
	
	/**
	 *  Variable para controlar click
	 *  NO TOCAR
	 */
	public static boolean estadoAnteriorDeClick = false;
	
	/**
	 *  true: se ha seleccionado alguna casilla
	 *  false: no se ha seleccionado alguna casilla
	 */
	public static boolean casillaSeleccionada = false;
	
	/**
	 *  true: se ha seleccionado alguna ficha valida
	 *  false: no se ha seleccionado alguna ficha valida
	 */
	public static boolean fichaSeleccionada = false;
	
	/**
	 *  Almacena el numero de fila de la casilla seleccionada
	 */
	public static Integer filaCasillaSeleccionada;
	
	/**
	 *  Almacena el numero de columna de la casilla seleccionada
	 */
	public static Integer columnaCasillaSeleccionada;
	
	/**
	 *  Almacena el numero de fila de la ficha seleccionada
	 */
	public static Integer filaFichaSeleccionada;
	
	/**
	 *  Almacena el numero de columna de la ficha seleccionada
	 */
	public static Integer columnaFichaSeleccionada;

	/**
	 *  Método que dibuja el lienzo fijo, como el tablero o el fondo
	 */
	public static void dibujarTablero() {
		StdDraw.setPenColor(166, 215, 222);
		StdDraw.filledRectangle(400, 400, 2000, 2000);

		for (int y = 0; y < tablero.length; y++) {
			for (int x = 0; x < tablero[0].length; x++) {
				if (y % 2 == 0) {
					if (x % 2 == 0) {
						StdDraw.setPenColor(Color.BLACK);
						StdDraw.filledSquare(tamañoCasilla / 2 + x * tamañoCasilla,
								tamañoCasilla / 2 + y * tamañoCasilla, tamañoCasilla / 2);
					} else {
						StdDraw.setPenColor(Color.WHITE);
						StdDraw.filledSquare(tamañoCasilla / 2 + x * tamañoCasilla,
								tamañoCasilla / 2 + y * tamañoCasilla, tamañoCasilla / 2);
					}
				} else {
					if (x % 2 == 1) {
						StdDraw.setPenColor(Color.BLACK);
						StdDraw.filledSquare(tamañoCasilla / 2 + x * tamañoCasilla,
								tamañoCasilla / 2 + y * tamañoCasilla, tamañoCasilla / 2);
					} else {
						StdDraw.setPenColor(Color.WHITE);
						StdDraw.filledSquare(tamañoCasilla / 2 + x * tamañoCasilla,
								tamañoCasilla / 2 + y * tamañoCasilla, tamañoCasilla / 2);
					}
				}
			}
		}
		// Detalles marrones
		StdDraw.setPenColor(80, 40, 0);
		StdDraw.filledRectangle(810, 400, 10, 400);
		StdDraw.setPenColor(160, 80, 0);
		StdDraw.filledRectangle(810, 400, 5, 400);
	}

	/**
	 *  Método que asigna cada ficha a su posicion correspondiente de la matriz tablero
	 */
	public static void colocarFichas() {
		String inicioRuta = "images/";
		String extension = ".png";
		tablero[0][0] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 0, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "TB" + extension);
		tablero[0][7] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 7, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "TB" + extension);
		tablero[0][1] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 1, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "CB" + extension);
		tablero[0][6] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 6, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "CB" + extension);
		tablero[0][2] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 2, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "AB" + extension);
		tablero[0][5] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 5, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "AB" + extension);
		tablero[0][3] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 3, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "REINAB" + extension);
		tablero[0][4] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 4, tamañoCasilla / 2 + tamañoCasilla * 0,
				Color.WHITE, inicioRuta + "REYB" + extension);
		for (int i = 0; i < 8; i++) {
			tablero[1][i] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * i, tamañoCasilla / 2 + tamañoCasilla * 1,
					Color.WHITE, inicioRuta + "PB" + extension);
			tablero[6][i] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * i, tamañoCasilla / 2 + tamañoCasilla * 6,
					Color.BLACK, inicioRuta + "PN" + extension);
		}
		tablero[7][0] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 0, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "TN" + extension);
		tablero[7][7] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 7, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "TN" + extension);
		tablero[7][1] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 1, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "CN" + extension);
		tablero[7][6] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 6, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "CN" + extension);
		tablero[7][2] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 2, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "AN" + extension);
		tablero[7][5] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 5, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "AN" + extension);
		tablero[7][4] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 4, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "REYN" + extension);
		tablero[7][3] = new Ficha(tamañoCasilla / 2 + tamañoCasilla * 3, tamañoCasilla / 2 + tamañoCasilla * 7,
				Color.BLACK, inicioRuta + "REINAN" + extension);
	}

	/**
	 *  Método que dibuja las fichas que hay en la matriz tablero
	 */
	public static void dibujarFichas() {
		for (int i = 0; i < tablero.length; i++)
			for (int j = 0; j < tablero[0].length; j++)
				if (tablero[i][j] != null)
					StdDraw.picture(tablero[i][j].getX(), tablero[i][j].getY(), tablero[i][j].getRuta(), 70, 70);
	}

	/**
	 *  Método que resalta de amarillo la casilla en la que se encuentra el raton
	 */
	public static void detectarCasilla() {
		if (detectarColumna() != null && detectarFila() != null) {
			Integer col = detectarFila();
			Integer fila = detectarColumna();
			StdDraw.setPenColor(Color.YELLOW);
			StdDraw.setPenRadius(0.01);
			StdDraw.rectangle(tamañoCasilla / 2 + fila * tamañoCasilla, tamañoCasilla / 2 + col * tamañoCasilla,
					tamañoCasilla / 2, tamañoCasilla / 2);
		}
	}

	/**
	 * Método que devuelve numero de columna
	 * @return Integer que contiene el numero de columna en el que esta el raton
	 */
	public static Integer detectarColumna() {
		Integer res = (int) Math.floor(StdDraw.mouseX() / tamañoCasilla);
		if (res < 8)
			return res;
		return null;
	}

	/**
	 * Método que devuelve numero de fila
	 * @return Integer que contiene el numero de fila en el que esta el raton
	 */
	public static Integer detectarFila() {
		Integer res = (int) Math.floor(StdDraw.mouseY() / tamañoCasilla);
		if (res < 8 && detectarColumna() != null)
			return res;
		return null;
	}

	/**
	 * Método que devuelve el estado del turno
	 * @return boolean asignado a la variable turnoBlancas
	 */
	public static boolean getTurno() {
		return turnoBlancas; // true --> blancas. false --> negras
	}

	/**
	 * Método para actualizar valor de turnoBlancas
	 * @param nuevo boolean que actualiza valor del turno
	 */
	public static void setTurno(boolean nuevo) {
		turnoBlancas = nuevo; // true --> blancas. false --> negras
	}

	/**
	 * Método que dibuja información sobre el estado de la partida
	 */
	public static void dibujarInfo() {
		StdDraw.setPenColor(Color.BLACK);

		StdDraw.text(950, 750, "SEÑALANDO");
		StdDraw.rectangle(950, 700, 110, 40);
		StdDraw.text(950, 725, "FILA: " + detectarFila());
		StdDraw.text(950, 700, "COLUMNA: " + detectarColumna());
		StdDraw.text(950, 675, "FICHA: " + detectarFicha());

		StdDraw.text(950, 625, "CASILLA");
		StdDraw.rectangle(950, 575, 110, 40);
		StdDraw.text(950, 600, "FILA SELEC: " + filaCasillaSeleccionada);
		StdDraw.text(950, 575, "COLUMNA SELEC: " + columnaCasillaSeleccionada);
		StdDraw.text(950, 550, "SELECCIONADA: " + casillaSeleccionada);

		StdDraw.text(950, 500, "FICHA");
		StdDraw.rectangle(950, 450, 110, 40);
		StdDraw.text(950, 475, "FILA SELEC: " + filaFichaSeleccionada);
		StdDraw.text(950, 450, "COLUM SELEC: " + columnaFichaSeleccionada);
		StdDraw.text(950, 425, "SELECCIONADA: " + fichaSeleccionada);

		StdDraw.text(1250, 750, "CLICK: " + detectarClick());
		StdDraw.text(1250, 725, "TURNO BLANCAS: " + turnoBlancas);
	}

	/**
	 * Método que resalta la casilla seleccionada
	 */
	public static void dibujarCasillaSeleccionada() {
		if (casillaSeleccionada) {
			StdDraw.setPenColor(Color.GREEN);
			StdDraw.rectangle(tamañoCasilla / 2 + columnaCasillaSeleccionada * tamañoCasilla,
					tamañoCasilla / 2 + filaCasillaSeleccionada * tamañoCasilla, tamañoCasilla / 2, tamañoCasilla / 2);
		}
	}

	/**
	 * Método que detecta fichas de la matriz tablero
	 * @return String nombre de la ficha
	 */
	public static String detectarFicha() {
		if (detectarColumna() != null && detectarFila() != null) {
			if (tablero[detectarFila()][detectarColumna()] != null) {
				String ruta = tablero[detectarFila()][detectarColumna()].getRuta();
				String[] rutaPartida = ruta.split("[./]");
				String ficha = rutaPartida[1];
				return ficha;
			}
		}
		return null;
	}

	/**
	 * Método que actualiza variables para la selección de casillas
	 */
	public static void seleccionarCasilla() {
		if (detectarClick()) {
			filaCasillaSeleccionada = detectarFila();
			columnaCasillaSeleccionada = detectarColumna();
		}
		if (filaCasillaSeleccionada != null && columnaCasillaSeleccionada != null) {
			casillaSeleccionada = true;
		} else {
			casillaSeleccionada = false;
		}
	}

	/**
	 * Método que actualiza variables para la selección de fichas válidas
	 */
	public static void seleccionarFicha() {
		if (casillaSeleccionada && tablero[filaCasillaSeleccionada][columnaCasillaSeleccionada] != null) {
			if (turnoBlancas
					&& tablero[filaCasillaSeleccionada][columnaCasillaSeleccionada].getColor().equals(Color.WHITE)) {
				fichaSeleccionada = true;
				filaFichaSeleccionada = filaCasillaSeleccionada;
				columnaFichaSeleccionada = columnaCasillaSeleccionada;
			} else { // turno de negras y ficha seleccionada negra
				if (!turnoBlancas && tablero[filaCasillaSeleccionada][columnaCasillaSeleccionada].getColor()
						.equals(Color.BLACK)) {
					fichaSeleccionada = true;
					filaFichaSeleccionada = filaCasillaSeleccionada;
					columnaFichaSeleccionada = columnaCasillaSeleccionada;
				}
			}
		} else {
			fichaSeleccionada = false;
			filaFichaSeleccionada = null;
			columnaFichaSeleccionada = null;
		}
	}

	/**
	 * Método que ejecuta todas las funciones básicas en paquete para ejecutar en el main
	 */
	public static void funcionesBasicas() {
		// Métodos de selección
		seleccionarCasilla();
		seleccionarFicha();
		// Métodos que dibujan lo fundamental
		dibujarTablero();
		dibujarFichas();
		detectarCasilla();
		dibujarInfo();
		dibujarCasillaSeleccionada();
	}

	/**
	 * Método especializado en detectar clicks del ratón
	 * @return boolean true si ha habido click, false si no
	 */
	public static boolean detectarClick() {
		if (StdDraw.isMousePressed() && !estadoAnteriorDeClick) {
			estadoAnteriorDeClick = true;
			return true;
		} else {
			if (!StdDraw.isMousePressed()) {
				estadoAnteriorDeClick = false;
			}
		}
		return false;
	}

}
