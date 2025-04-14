package geometria2D;

import java.awt.Color;

import utilidades.StdDraw;

public class Punto {
	private double x;
	private double y;
	private Color color;
	private double movX;
	private double movY;
	
	public Punto(double x, double y, Color c) {
		this.x=x; // THIS.X SE REFIERE AL ATRIBUTO ORIGINAL DEL OBJETO
		this.y=y;
		color=c;
	}
	
	public Punto(double x, double y) {
		this.x=x; // THIS.X SE REFIERE AL ATRIBUTO ORIGINAL DEL OBJETO
		this.y=y;
		this.color=Color.BLACK;
	}

	public double distanciaHasta(Punto p2) {
		return Math.sqrt(Math.pow((this.x-p2.x), 2)+Math.pow((this.y-p2.y), 2));
	}
	
	public Punto puntoMedioHasta(Punto p2) {
		Punto p3 = new Punto((this.x+p2.x)/2,(this.y+p2.y)/2, Color.RED);
		return p3;
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

	public String toString() {
		return "Punto [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
	
	public static void main(String[] args) {
		Punto p1 = new Punto(4,2,Color.YELLOW);
		Punto p2 = new Punto(3,7);
		
		System.out.println(p1);
		System.out.println(p2);
	}

	// AL NO TENER 'STATIC', SE LE LLAMA CON .DUBIJAR
	public void dibujar() {
		StdDraw.setPenRadius(0.015);
		StdDraw.setPenColor(color);
		StdDraw.point(x, y);
	}
	
}
