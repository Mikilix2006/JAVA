package objetos;

import utilidades.StdDraw;

public class RaquetaProfe {
	private PuntoProfe extIzq;
	private double largo;
	private double velocidad; // Variación de x al llamar a los métodos mover

	public RaquetaProfe(double x, double y, double largo) {
		extIzq = new PuntoProfe(x, y);
		setLargo(largo);
		velocidad = 5;
	}

	public PuntoProfe getExtIzq() {
		return extIzq;
	}

	public void setExtIzq(PuntoProfe extIzq) {
		this.extIzq = extIzq;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		if (largo < 10)
			throw new RuntimeException("No se admiten raquetas de longitud menor a 10");
		this.largo = largo;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String toString() {
		return "Raqueta [extIzq=" + extIzq + ", largo=" + largo + ", velocidad=" + velocidad + "]";
	}

	public static void main(String[] args) {
		RaquetaProfe r = new RaquetaProfe(-98, 0, 10);
		System.out.println(r);
	}

	public void dibujar() {
		StdDraw.setPenColor(extIzq.getColor());
		StdDraw.setPenRadius(0.01);
		StdDraw.line(extIzq.getX(), extIzq.getY(), extIzq.getX() + largo, extIzq.getY());

	}

	public void moverDerecha(int limiteDerecho) {
		double nuevaX = extIzq.getX() + velocidad;
		if (nuevaX + largo > limiteDerecho)
			nuevaX = limiteDerecho - largo;
		extIzq.setX(nuevaX);

	}

	public void moverIzquierda(int limiteIzquierdo) {
		double nuevaX = extIzq.getX() - velocidad;
		if (nuevaX < limiteIzquierdo)
			nuevaX = limiteIzquierdo;
		extIzq.setX(nuevaX);

	}

}
