package objetos;

import java.awt.event.KeyEvent;

import utilidades.StdDraw;

public class Raqueta {

	private Punto extIzq;
	private double largo;
	private double velocidad;
	
	public Raqueta(double x, double y, double largo) {
		extIzq=new Punto(x,y);
		this.largo=largo;
		velocidad = 5;
	}

	public Punto getExtIzq() {
		return extIzq;
	}
	public void setExtIzq(Punto extIzq) {
		this.extIzq = extIzq;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		if (largo<10)
			throw new RuntimeException("No se admiten longitudes menores a 10");
		this.velocidad = velocidad;
	}

	public String toString() {
		return "Raqueta [extIzq=" + extIzq + ", largo=" + largo + ", velocidad=" + velocidad + "]";
	}

	public void movimiento() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
			extIzq.setX(extIzq.getX()+velocidad);
		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
			extIzq.setX(extIzq.getX()-velocidad);
	}

	public void dibujar() {
		StdDraw.setPenColor(extIzq.getColor());
		StdDraw.setPenRadius(0.01);
		StdDraw.line(extIzq.getX(), extIzq.getY(), extIzq.getX()+largo, extIzq.getY());
	}

	public void controlarLimites() {
		if (extIzq.getX()>100-largo)
			extIzq.setX(100-largo);
		if (extIzq.getX()<-100)
			extIzq.setX(-100);
	}
	
//	public static void main(String[] args) {
//		Raqueta r =new Raqueta(-98,0,10);
//	}
}
