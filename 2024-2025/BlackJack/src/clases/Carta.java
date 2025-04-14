package clases;

import java.util.Random;

import utilidades.StdDraw;

public class Carta implements Comparable<Carta>{
	private Palo palo; 
	private int valor;
	// Permite la decisión entre As = 1 u 11
	private int valorAs;
	// Dice si la carta es de la Ia o del jugador
	private boolean cartaDeJugador;
	// Coordenadas de la carta
	private double x;
	private double y;
	
	// Para crear una carta a tu gusto
	public Carta(int palo, int valor, boolean esCartaDeJugador) {
		
		if (palo<1 || palo > 4)
			throw new RuntimeException("El palo debe estar comprendido entre 1 y 4");
		if (valor<1 || valor > 13)
			throw new RuntimeException("El valor de la carta debe estar comprendido entre 1 y 13");
		
		if (palo==1)
			setPalo(Palo.PICA);
		if (palo==2)
			setPalo(Palo.DIAMANTE);
		if (palo==3)
			setPalo(Palo.TREBOL);
		if (palo==4)
			setPalo(Palo.CORAZON);
		setValor(valor);
		setCartaDeJugador(esCartaDeJugador);
		if (esCartaDeJugador) {
			setX(-97.5);
			setY(-370.5);
		} else {
			setX(97.5);
			setY(370.5);
		}
	}

	public Carta(boolean esCartaDeJugador) {
		Random r=new Random();
		
		// Palo aleatorio
		int paloAleat = r.nextInt(1,5);
		switch (paloAleat) {
			case 1:
				setPalo(Palo.PICA);
				break;
			case 2:
				setPalo(Palo.DIAMANTE);
				break;
			case 3:
				setPalo(Palo.TREBOL);
				break;
			case 4:
				setPalo(Palo.CORAZON);
				break;
			default:
				throw new RuntimeException("Debe indicarse un palo existente");
		}
		// Valor aleatorio
		setValor(r.nextInt(1, 14));
		// Define si esta carta es o no del jugador
		setCartaDeJugador(esCartaDeJugador);
		if (esCartaDeJugador) {
			setX(-97.5);
			setY(-370.5);
		} else {
			setX(97.5);
			setY(370.5);
		}
	}

	// Crea una carta aleatoria
	public static Carta crearCartaAleatoria(boolean esCartaDeJugador) {
		Carta c=new Carta(esCartaDeJugador);
		return c;
	}
	
	public void setPalo(Palo palo) {
		this.palo = palo;
	}
	public Palo getPalo() {
		return this.palo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		if (valor>13 || valor<1)
			throw new RuntimeException("El valor de la carta no está entre 1 y 13");
		this.valor = valor;
	}
	public boolean isCartaDeJugador() {
		return cartaDeJugador;
	}
	public void setCartaDeJugador(boolean cartaDeJugador) {
		this.cartaDeJugador = cartaDeJugador;
	}
	public int getValorAs() {
		return valorAs;
	}
	public void setValorAs(int valorAs) {
		this.valorAs = valorAs;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", valor=" + valor + ", valorAs=" + valorAs + ", cartaDeJugador="
				+ cartaDeJugador + ", x=" + x + ", y=" + y + "]";
	}

	public void dibujar(int numCarta, boolean esCartaDeJugador) {
		String rutaImagen = "imagenesBaraja/";
		
		if (this.palo.equals(Palo.PICA))
			rutaImagen += "p";
		if (this.palo.equals(Palo.DIAMANTE))
			rutaImagen += "d";
		if (this.palo.equals(Palo.TREBOL))
			rutaImagen += "t";
		if (this.palo.equals(Palo.CORAZON))
			rutaImagen += "c";

		if (this.valor==1)
			rutaImagen += "1.png";
		if (this.valor==2)
			rutaImagen += "2.png";
		if (this.valor==3)
			rutaImagen += "3.png";
		if (this.valor==4)
			rutaImagen += "4.png";
		if (this.valor==5)
			rutaImagen += "5.png";
		if (this.valor==6)
			rutaImagen += "6.png";
		if (this.valor==7)
			rutaImagen += "7.png";
		if (this.valor==8)
			rutaImagen += "8.png";
		if (this.valor==9)
			rutaImagen += "9.png";
		if (this.valor==10)
			rutaImagen += "10.png";
		if (this.valor==11)
			rutaImagen += "11.png";
		if (this.valor==12)
			rutaImagen += "12.png";
		if (this.valor==13)
			rutaImagen += "13.png";
		
		if (esCartaDeJugador)
			StdDraw.picture(this.getX()+numCarta*32.5, this.getY()+numCarta*65, rutaImagen, 162.5, 227.5);
		else
			StdDraw.picture(this.getX()-numCarta*32.5, this.getY()-numCarta*65, rutaImagen, 162.5, 227.5);
	}
	
	public boolean esIgualA(Carta otro) {
		if (this.palo==otro.palo &&
			this.valor==otro.valor) {
			return true;
		}
		return false;
	}

	// Compara dos cartas para ordenarlas en una lista o array de cartas
	public int compareTo(Carta o) {
		int comp = this.getPalo().compareTo(o.getPalo());
		if (comp==0) {
			return this.getValor()-o.getValor();
		} 
		return comp;
	}
	
}
