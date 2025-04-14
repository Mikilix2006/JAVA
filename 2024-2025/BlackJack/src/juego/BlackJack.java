package juego;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import clases.Carta;
import utilidades.FuncBlackJack;
import utilidades.StdDraw;

public class BlackJack {

//	============= BLACK JACK =============
//
//			VOLVER A CREAR LAS CARTAS PARA HACER QUE SU NÚMERO SE VEA CLARAMENTE
//	
//	DONE	0. Crear y mostrar cartas ademas de colocarlas correctamente.
//	DONE	1. Hacer método "sumar" para sumar las cartas de una mano.
//	DONE	2. Añadir la puntuacion alterna del As.
//	DONE	3. Añadir que a partir de 22 puntos no se puedan sacar mas cartas.
//	DONE		3.1. Añadir botón para 'quedarte'.
//	DONE	4. Hacer turno de la IA.
//	DONE	5. Condicionar IA para que sepa jugar bien.
//	DONE		5.1 Enseñar estrategias para el As.
//	DONE		5.2 Enseñar estrategias para saber cuando dejar de arriesgar.
//	DONE	6. Dejar un tiempo entre carta y carta de la IA.
//	DONE	7. Comparar puntuaciones y determinar ganador.
	
//			== FUTURAS UPGRADES == 
//	DONE	· Añadir sistema de apuestas.
//			· Mejorar aspecto de mesa.
//			· Añadir sonidos
//			· Añadir imágenes a los objetos

	public static void main(String[] args) {
		// Crea el espacio para las cartas de los jugadores
		List<Carta> cartasJugador=new ArrayList<Carta>();
		List<Carta> cartasIA=new ArrayList<Carta>();
		
		// Permite o no sacar mas cartas al jugador
		boolean cartaDisponible = true;
		// Deteccion de carta nueva repetida
		boolean cartaRepetida = false;
		// Define el turno de la partida
		boolean turnoJugador = true;
		// Define si la partida ha terminado
		boolean partidaTerminada = false;
		// Cada nueva partida realiza una apuesta
		boolean apuestaHecha = false;
		// Define cuando no puede jugar mas partidas el jugador
		boolean bancarrota = false;
		
		// Monedas iniciales
		int cantidadMonedas = 50;
		// Valor de la apuesta
		int valorApuesta=0;
	
		// Pantalla
		StdDraw.setCanvasSize(650, 650);
		StdDraw.setXscale(-650, 650);
		StdDraw.setYscale(-650, 650);
		
		StdDraw.enableDoubleBuffering();
		cartasIA.add(Carta.crearCartaAleatoria(false));
		// Si la primera carta de la IA es 
		if (cartasIA.getLast().getValor()==1) {
			cartasIA.getLast().setValorAs(11);
		}
		
		// Bucle de animacion
		for(;;) {
			// Condiciones iniciales obligatorias
			StdDraw.clear();
			FuncBlackJack.dibujarFondo(valorApuesta);
			FuncBlackJack.dibujarPuntuacion(cartasJugador, cartasIA);
			FuncBlackJack.dibujarCartas(cartasJugador, cartasIA);
			FuncBlackJack.dibujarMonedas(cantidadMonedas);

			// Muestra de quien es el turno actual
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(-357.5, 0, "Turno:");
			if (turnoJugador) {
				StdDraw.text(-357.5, -39, "Jugador");
			} else {
				StdDraw.text(-357.5, -39, "DEALER");
			}

			// Si tiene más de 10 monedas, continuar partida
			if (!bancarrota) {
				// Turno del jugador
				if (!partidaTerminada) {
					// Si no ha hecho apuesta, obliga a hacerla
					if (!apuestaHecha) {
						FuncBlackJack.pedirApuesta(cantidadMonedas);
						valorApuesta = FuncBlackJack.setearApuesta(cantidadMonedas);
						if (valorApuesta!=0) {
							apuestaHecha=true;
							cantidadMonedas -= valorApuesta;
						}
					}
					if (apuestaHecha) {
						if (FuncBlackJack.sumar(cartasJugador)<22 && turnoJugador) {
							// Solo sale una carta por cada vez que le das click a la baraja
							if (cartaDisponible && StdDraw.isMousePressed() && FuncBlackJack.ratonSobreMazo()) {
								do {
									// Añade carta aleatoria a la mano
									cartasJugador.add(Carta.crearCartaAleatoria(true));
									// Comprobar cartas que tiene la mano
									cartaRepetida=FuncBlackJack.comprobarCartasRepetidas(cartasJugador, cartasIA);
									if (cartaRepetida) {
										cartasJugador.removeLast();
									}
								} while (cartaRepetida); // Vuelve a ejecutarlo si ha habido una coincidencia
								cartaDisponible=false;
								// Si la ultima carta añadida es un As, permite eleccion de valor
								FuncBlackJack.seleccionarValorDeAs(cartasJugador);
							}
							// Cuando suelte el raton, desbloqueara la variable
							if (!cartaDisponible && !StdDraw.isMousePressed()) {
								cartaDisponible=true;
							}
							// Click en terminar turno
							if (StdDraw.isMousePressed() && FuncBlackJack.ratonSobreBoton()) {
									turnoJugador = false;
							}
						} else {
							// Setea el turno a la IA
							turnoJugador = false;
						}
					}
		
					if (!turnoJugador) {
						cartasIA=FuncBlackJack.turnoIA(cartasIA, cartasJugador);
						StdDraw.show();
						StdDraw.pause(2000);
						if (cartasIA.getLast()==null) {
							partidaTerminada = true;
							cartasIA.removeLast();
						}
					}
				} else {
					FuncBlackJack.finalDePartida(cartasJugador, cartasIA);
					FuncBlackJack.deteccionRaton();
					partidaTerminada = FuncBlackJack.reiniciarPartida();
					if (!partidaTerminada) {
						if (FuncBlackJack.partidaGanada(cartasJugador, cartasIA)) {
							cantidadMonedas+=valorApuesta*1.5;
						}
						cartasJugador.clear();
						cartasIA.clear();
						cartasIA.add(Carta.crearCartaAleatoria(false));
						if (FuncBlackJack.partidaPerdida(cantidadMonedas)) {
							bancarrota = true;
						}
						// Si la primera carta de la IA es 
						if (cartasIA.getLast().getValor()==1) {
							cartasIA.getLast().setValorAs(11);
						}
						cartaDisponible = true;
						turnoJugador = true;
						apuestaHecha = false;
						valorApuesta = 0;
					}
				}
			} else {
				if (bancarrota) {
					FuncBlackJack.pantallaPartidaPerdida();
				}
			}
			
			// Condiciones finales obligatorias
			StdDraw.show();
			StdDraw.pause(16); // 60 fps
		}
		
	}
	
}
