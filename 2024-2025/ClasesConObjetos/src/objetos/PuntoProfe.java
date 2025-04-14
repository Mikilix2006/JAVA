package objetos;

import java.awt.Color;

import utilidades.StdDraw;

public class PuntoProfe {
	private double x;
	private double y;
	private Color color;
	private double movX; // Variación de x al llamar a mover
	private double movY; // Variación de y al llamar a mover

	public void mover() {
		x = x + movX;
		y = y + movY;
	}

	public PuntoProfe(double x, double y) {
		this.x = x;
		this.y = y;
		this.color = Color.BLACK;
	}

	public PuntoProfe(double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getMovX() {
		return movX;
	}

	public void setMovX(double movX) {
		this.movX = movX;
	}

	public double getMovY() {
		return movY;
	}

	public void setMovY(double movY) {
		this.movY = movY;
	}

	public String toString() {
		return "Punto [x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	public static void main(String[] args) {
		PuntoProfe p = new PuntoProfe(3, 7, Color.GREEN);
		PuntoProfe p2 = new PuntoProfe(5, 1);

		System.out.println(p);
		System.out.println(p2);
	}

	public void dibujar() {
		StdDraw.setPenRadius(0.02);
		StdDraw.setPenColor(color);
		StdDraw.point(x, y);
	}

	public double distancia(PuntoProfe otro) {

		return Math.sqrt(Math.pow(x - otro.x, 2) + Math.pow(y - otro.y, 2));
	}

	public PuntoProfe puntoMedio(PuntoProfe otro) {
		PuntoProfe m = new PuntoProfe((x + otro.x) / 2, (y + otro.y) / 2);
		return m;
	}
}
