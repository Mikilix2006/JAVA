package utilidades;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import clases.Carta;

public class FuncBlackJack {
	
	// Dibuja el fondo
	public static void dibujarFondo(int valorApuesta) {
		// ** FONDO **
		// Mantel verde
		StdDraw.setPenColor(0, 120,0);
		StdDraw.filledSquare(0, 0, 552.5);
		// Cuadrado marron
		StdDraw.setPenColor(180,120,60);
		StdDraw.setPenRadius(0.01);
		StdDraw.line(-487.5, -520, 487.5, -520);
		StdDraw.line(487.5, -520, 487.5, 520);
		StdDraw.line(-487.5, -520, -487.5, 520);
		StdDraw.line(-487.5, 520, 487.5, 520);
		// Indicaciones parte superior
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0, 617.5, "Click en la baraja para sacar otra carta.");
		// Agujero para apuestas
		StdDraw.setPenColor(0, 60,0);
		StdDraw.filledCircle(260, -390, 110.5);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(260, -370, "APUESTA");
		StdDraw.text(260, -430, Integer.toString(valorApuesta));
		// Boton para 'quedarse'
		StdDraw.setPenColor(0, 100,0);
		StdDraw.setPenRadius(0.01);
		StdDraw.rectangle(-338, -195, 117, 65);
		StdDraw.setPenColor(0, 140,0);
		StdDraw.filledRectangle(-338, -195, 117, 65);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(-338, -162.5, "Terminar");
		StdDraw.text(-338, -227.5, "turno");
		// Detectar si el raton esta encima del boton
		if (StdDraw.mouseX()<-221 &&
			StdDraw.mouseX()>-455 &&
			StdDraw.mouseY()<-130 &&
			StdDraw.mouseY()>-260) {
			StdDraw.setPenColor(Color.YELLOW);
			StdDraw.setPenRadius(0.01);
			StdDraw.rectangle(-338, -195, 130, 78);
		}
		// Mazo de cartas
		StdDraw.picture(390, 0, "imagenesBaraja/dorso.png", 130, 195); // relacion de 1:1.5
		// Detectar si el raton esta encima del mazo
		if (StdDraw.mouseX()<455 &&
			StdDraw.mouseX()>325 &&
			StdDraw.mouseY()<97.5 &&
			StdDraw.mouseY()>-97.5) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(390, 0, 71.5, 104);
			}
	}
	
	public static void dibujarPuntuacion(List<Carta> cartasJugador, List<Carta> cartasIA) {
		// ** PUNTUACION JUGADOR**
		// Contraste con el texto
		StdDraw.setPenColor(0, 100,0);
		StdDraw.setPenRadius(0.01);
		StdDraw.rectangle(-338, -390, 117, 65);
		StdDraw.setPenColor(0, 140,0);
		StdDraw.filledRectangle(-338, -390, 117, 65);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(-338, -357.5, "Tus puntos:"); 
		// Devuelve las suma de la mano del jugador y la muestra
		if (sumar(cartasJugador)==21) {
			StdDraw.text(-338, -422.5, "BLACKJACK"); 
		} else {
			StdDraw.text(-338, -422.5, Integer.toString(sumar(cartasJugador)));
		}
		// ** PUNTUACION IA**
		// Contraste con el texto
		StdDraw.setPenColor(0, 100,0);
		StdDraw.setPenRadius(0.01);
		StdDraw.rectangle(-338, 390, 117, 65);
		StdDraw.setPenColor(0, 140,0);
		StdDraw.filledRectangle(-338, 390, 117, 65);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(-338, 422.5, "Puntos dealer:"); 
		// Devuelve las suma de la mano de la IA y la muestra
		if (sumar(cartasIA)==21) {
			StdDraw.text(-338, 380.5, "BLACKJACK"); 
		} else {
			StdDraw.text(-338, 357.5, Integer.toString(sumar(cartasIA)));
		}
	}
	
	// Suma las cartas de una mano por su valor
	public static int sumar(List<Carta> cartas) {
		int suma=0;
		
		// for each carta en cartas
		for (Carta c:cartas) {
			if (c.getValor()!=1) {
				if (c.getValor()==11 ||
					c.getValor()==12 ||
					c.getValor()==13) {
					suma = suma + 10;
				} else {
					suma = suma + c.getValor();
				}
			} else {
				suma = suma + c.getValorAs();
			}
		}
		return suma;
	}
	
	// Comprueba si hay dos cartas iguales en la mano
	public static boolean comprobarCartasRepetidas(List<Carta> cartasJugador, List<Carta> cartasIA) {
		for (Carta c:cartasJugador) {
			// Si hay coincidencia elimina la ultima carta añadida
			// Sin compararla consigo misma
			if (cartasJugador.indexOf(c)!= cartasJugador.size()-1) {
				if (c.esIgualA(cartasJugador.getLast())) {
					return true;
				}
			}
			if (c.esIgualA(cartasIA.getLast())) {
				return true;
			}
		}
		return false; // No hay cartas repetidas
	}

	public static void seleccionarValorDeAs(List<Carta> cartasJugador) {
		// Ha respondido a la pregunta de la valencia del As o no
		boolean respondido = false;
		
		// Si la ultima carta añadida es un As, va aseleccionar su valor (1 u 11)
		if (cartasJugador.getLast().getValor()==1) {
			do {
				// Mensaje de aviso por As
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0, 0, 325, 195);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.rectangle(0, 0, 305.5, 175.5);
				StdDraw.text(0, 97.5, "Te ha tocado un As");
				StdDraw.text(0, 32.5, "¿Que valor quieres que tenga?");
				StdDraw.text(0, -32.5, "Flecha arriba: 1");
				StdDraw.text(0, -97.5, "Flecha abajo: 11");
				// Muestra el mensaje
				StdDraw.show();
				// Si pulsa la flecha arriba, valor de As actual es 1
				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
					cartasJugador.getLast().setValorAs(1);
					respondido = true;
				}
				// Si pulsa la flecha abajo, valor de As actual es 11
				if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
					cartasJugador.getLast().setValorAs(11);
					respondido = true;
				}
			} while (!respondido);
		}
	}
	
	// Indica si el raton esta sobre el mazo
	public static boolean ratonSobreMazo() {
		if (StdDraw.mouseX()<455 &&
			StdDraw.mouseX()>325 &&
			StdDraw.mouseY()<97.5 &&
			StdDraw.mouseY()>-97.5) {
			return true;
		}
		return false;
	}

	// Indica si el raton esta sobre el boton
	public static boolean ratonSobreBoton() {
		if (StdDraw.mouseX()<-221 &&
			StdDraw.mouseX()>-455 &&
			StdDraw.mouseY()<-130 &&
			StdDraw.mouseY()>-260) {
			return true;
		}
		return false;
	}

	public static void dibujarCartas(List<Carta> cartasJugador, List<Carta> cartasIA) {
		// Dibuja las cartas
		for (Carta c:cartasJugador) {
			c.dibujar(cartasJugador.indexOf(c), c.isCartaDeJugador());
		}
		for (Carta c:cartasIA) {
			c.dibujar(cartasIA.indexOf(c), c.isCartaDeJugador());
		}
	}
	
	public static List<Carta> turnoIA(List<Carta> manoIA, List<Carta> manoJugador) {
		if ((sumar(manoIA)<18 || sumar(manoIA)<sumar(manoJugador)) && sumar(manoIA)<sumar(manoJugador) && sumar(manoJugador)<22) {
			manoIA.add(Carta.crearCartaAleatoria(false));
			if (manoIA.getLast().getValor()==1) {
				if (sumar(manoIA)==10 || sumar(manoIA)<11) {
					manoIA.getLast().setValorAs(11);
				}
				if (sumar(manoIA)==20 || sumar(manoIA)>=11) {
					manoIA.getLast().setValorAs(1);
				}
			}
		} else {
			manoIA.add(null);
		}
		return manoIA;
	}

	public static void finalDePartida(List<Carta> cartasJugador, List<Carta> cartasIA) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(0, 0, 500, 250);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setPenRadius(0.005);
		StdDraw.rectangle(0, 0, 480, 230);
		if (partidaGanada(cartasJugador, cartasIA)) {
			StdDraw.text(0, 150, "HAS GANADO");
			StdDraw.text(0, 0, "HAS GANADO FICHAS DE APUESTA");
		} else {
			StdDraw.text(0, 150, "HA GANADO EL DEALER");
			StdDraw.text(0, 0, "HAS PERDIDO LAS FICHAS DE LA APUESTA");
		}
		StdDraw.text(-200, -150, "VOLVER A JUGAR");
		StdDraw.text(200, -150, "FINALIZAR JUEGO");
	}

	public static boolean partidaGanada(List<Carta> cartasJugador, List<Carta> cartasIA) {
		if ((sumar(cartasJugador)>sumar(cartasIA) || sumar(cartasIA)>21) && sumar(cartasJugador)<22) {
			return true;
		}
		return false;
	}
	
	public static boolean partidaPerdida(int monedas) {
		if (monedas<10) {
			return true;
		}
		return false;
	}
	
	public static void pantallaPartidaPerdida() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(0, 0, 500, 250);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setPenRadius(0.005);
		StdDraw.rectangle(0, 0, 480, 230);
		StdDraw.text(0, 150, "HAS PERDIDO TODAS LAS FICHAS");
		StdDraw.text(0, 0, "ESTÁS EN BANCARROTA, LUDÓPATA");
		StdDraw.text(0, -150, "FINALIZAR JUEGO");
		if (StdDraw.mouseX()<150 &&
			StdDraw.mouseX()>-150 &&
			StdDraw.mouseY()<-100 &&
			StdDraw.mouseY()>-200) {
			StdDraw.setPenColor(Color.YELLOW);
			StdDraw.setPenRadius(0.005);
			StdDraw.rectangle(0, -150, 160, 40);
			}
		if (StdDraw.mouseX()<150 &&
			StdDraw.mouseX()>-150 &&
			StdDraw.mouseY()<-100 &&
			StdDraw.mouseY()>-200 &&
			StdDraw.isMousePressed()) {
				System.exit(0);
			}
	}
	
	public static boolean reiniciarPartida() {
		if (StdDraw.mouseX()<-50 &&
			StdDraw.mouseX()>-350 &&
			StdDraw.mouseY()<-100 &&
			StdDraw.mouseY()>-200 &&
			StdDraw.isMousePressed()) {
			return false;
		} else if (StdDraw.mouseX()<350 &&
					StdDraw.mouseX()>50 &&
					StdDraw.mouseY()<-100 &&
					StdDraw.mouseY()>-200 &&
					StdDraw.isMousePressed()) {
					System.exit(0);
				}
		return true;
	}

	public static void deteccionRaton() {
		// Detectar si el raton esta encima de "volver a jugar"
		if (StdDraw.mouseX()<-50 &&
			StdDraw.mouseX()>-350 &&
			StdDraw.mouseY()<-100 &&
			StdDraw.mouseY()>-200) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(-200, -150, 150, 50);
		}
		// Detectar si el raton esta encima de "finalizar juego"
		if (StdDraw.mouseX()<350 &&
			StdDraw.mouseX()>50 &&
			StdDraw.mouseY()<-100 &&
			StdDraw.mouseY()>-200) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(200, -150, 150, 50);
		}
	}

	public static void dibujarMonedas(int cantidadMonedas) {
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(-338, 182.5, 40);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(-338, 102.5, Integer.toString(cantidadMonedas)+"€");
	}

	public static void pedirApuesta(int monedas) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(0, 0, 500, 250);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setPenRadius(0.005);
		StdDraw.rectangle(0, 0, 480, 230);
		StdDraw.text(0, 150, "HAZ TU APUESTA");
		StdDraw.text(-300, 50, "10€");
		StdDraw.text(-100, 50, "20€");
		StdDraw.text(100, 50, "30€");
		StdDraw.text(300, 50, "50€");
		StdDraw.text(-300, -50, "100€");
		StdDraw.text(-100, -50, "150€");
		StdDraw.text(100, -50, "300€");
		StdDraw.text(300, -50, "500€");
		StdDraw.text(0, -150, "ALL IN");
		StdDraw.text(300, -200, "Tienes "+Integer.toString(monedas)+"€");
		detectarApuesta();
	}

	private static void detectarApuesta() {
		// Apuesta de 10€
		if (StdDraw.mouseX()<-250 &&
			StdDraw.mouseX()>-350 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(-300, 50, 50, 30);
		}
		// Apuesta de 20€
		if (StdDraw.mouseX()<-50 &&
			StdDraw.mouseX()>-150 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(-100, 50, 50, 30);
		} 
		// Apuesta de 30€
		if (StdDraw.mouseX()<150 &&
			StdDraw.mouseX()>50 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(100, 50, 50, 30);
		} 
		// Apuesta de 50€
		if (StdDraw.mouseX()<350 &&
			StdDraw.mouseX()>250 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(300, 50, 50, 30);
		} 
		// Apuesta de 100€
		if (StdDraw.mouseX()<-250 &&
			StdDraw.mouseX()>-350 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(-300, -50, 50, 30);
		} 
		// Apuesta de 150€
		if (StdDraw.mouseX()<-50 &&
			StdDraw.mouseX()>-150 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(-100, -50, 50, 30);
		} 
		// Apuesta de 300€
		if (StdDraw.mouseX()<150 &&
			StdDraw.mouseX()>50 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(100, -50, 50, 30);
		} 
		// Apuesta de 500€
		if (StdDraw.mouseX()<350 &&
			StdDraw.mouseX()>250 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(300, -50, 50, 30);
		} 
		// Apuesta de ALL IN
		if (StdDraw.mouseX()<50 &&
			StdDraw.mouseX()>-60 &&
			StdDraw.mouseY()<-120 &&
			StdDraw.mouseY()>-160) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.setPenRadius(0.005);
				StdDraw.rectangle(0, -145, 60, 30);
		} 
	}

	public static int setearApuesta(int cantidadMonedas) {
		int valorApuesta=0;
		
		// Apuesta de 10€
		if (StdDraw.mouseX()<-250 &&
			StdDraw.mouseX()>-350 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30 &&
			StdDraw.isMousePressed()) {
				if (cantidadMonedas>10) {
					valorApuesta=10;
				}
		}
		// Apuesta de 20€
		if (StdDraw.mouseX()<-50 &&
			StdDraw.mouseX()>-150 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=20) {
				valorApuesta=20;
			}
		} 
		// Apuesta de 30€
		if (StdDraw.mouseX()<150 &&
			StdDraw.mouseX()>50 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=30) {
				valorApuesta=30;
			}
		} 
		// Apuesta de 50€
		if (StdDraw.mouseX()<350 &&
			StdDraw.mouseX()>250 &&
			StdDraw.mouseY()<90 &&
			StdDraw.mouseY()>30 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=50) {
				valorApuesta=50;
			}
		} 
		// Apuesta de 100€
		if (StdDraw.mouseX()<-250 &&
			StdDraw.mouseX()>-350 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=100) {
				valorApuesta=100;
			}
		} 
		// Apuesta de 150€
		if (StdDraw.mouseX()<-50 &&
			StdDraw.mouseX()>-150 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=150) {
				valorApuesta=150;
			}
		} 
		// Apuesta de 300€
		if (StdDraw.mouseX()<150 &&
			StdDraw.mouseX()>50 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=300) {
				valorApuesta=300;
			}
		} 
		// Apuesta de 500€
		if (StdDraw.mouseX()<350 &&
			StdDraw.mouseX()>250 &&
			StdDraw.mouseY()<-20 &&
			StdDraw.mouseY()>-80 &&
			StdDraw.isMousePressed()) {
			if (cantidadMonedas>=500) {
				valorApuesta=500;
			}
		} 
		// Apuesta de ALL IN
		if (StdDraw.mouseX()<50 &&
			StdDraw.mouseX()>-60 &&
			StdDraw.mouseY()<-120 &&
			StdDraw.mouseY()>-160 &&
			StdDraw.isMousePressed()) {
				valorApuesta=cantidadMonedas;
		}
		
		return valorApuesta;
	}

}
