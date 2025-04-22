package clases;

import java.awt.Color;

public class Ficha {
	int x;
	int y;
	Color color;
	String ruta; // Ruta a la imagen
	
	public Ficha(int x, int y, Color c, String ruta) {
		this.x=x;
		this.y=y;
		this.color=c;
		this.ruta=ruta;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
