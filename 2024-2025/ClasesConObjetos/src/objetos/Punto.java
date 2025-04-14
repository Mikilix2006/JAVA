package objetos;

import java.awt.Color;

import utilidades.StdDraw;

public class Punto {
	private double x;
	private double y;
	private Color color;
	private double movX; //Variación de x al llamar a mover
	private double movY; //Variación de y al llamar a mover
	
	
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
		this.color = Color.BLACK;
	}
	
	public Punto(double x, double y, Color color) {
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

//	public static void main(String[] args) {
//		Punto p=new Punto(3,7,Color.GREEN);
//		Punto p2=new Punto(5,1);
//		
//		System.out.println(p);
//		System.out.println(p2);
//	}

	public void dibujar() {
		StdDraw.setPenRadius(0.02);
		StdDraw.setPenColor(color);
		StdDraw.point(x,y);
	}

	public double distancia(Punto otro) {
		return Math.sqrt(Math.pow(x-otro.x,2)+Math.pow(y-otro.y,2));
	}

	public Punto puntoMedio(Punto otro) {
		Punto m=new Punto((x+otro.x)/2,(y+otro.y)/2);
		return m;
	}

	public void mover() {
		x=x+movX;
		y=y+movY;
	}

	public void controlarRebote() {
		// Detectar límites de la ventana
		if (Math.abs(getX()) >= 100) { // izq. o drecha
			setMovX(-getMovX());
		}
		if (Math.abs(getY()) >= 100) { // arriba o derecha
			setMovY(-getMovY());
		}

	}
}
