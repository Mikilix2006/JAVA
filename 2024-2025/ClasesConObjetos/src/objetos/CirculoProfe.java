package objetos;

import java.awt.Color;

import utilidades.StdDraw;

public class CirculoProfe {
	private PuntoProfe centro;
	private double radio;

	public CirculoProfe(PuntoProfe p, double radio) {
		centro = p;
		setRadio(radio);
	}

	public CirculoProfe(double xCentro, double yCentro, double radio) {
		PuntoProfe p = new PuntoProfe(xCentro, yCentro);
		centro = p;
		setRadio(radio);
	}

	public PuntoProfe getCentro() {
		return centro;
	}

	public void setCentro(PuntoProfe centro) {
		this.centro = centro;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		if (radio <= 0)
			throw new RuntimeException("Un círculo debe tener radio positivo");

		this.radio = radio;
	}

	public String toString() {
		return "Circulo [centro=" + centro + ", radio=" + radio + "]";
	}

	public void dibujar() {
		dibujar(true); // Dibujar sin parámetros dibuja un círculo macizo

	}

	public void dibujar(boolean relleno) {
		StdDraw.setPenColor(centro.getColor());
		if (relleno)
			StdDraw.filledCircle(centro.getX(), centro.getY(), radio);
		else { // SOLO CONTORNO
			StdDraw.setPenRadius(0.005);

			StdDraw.circle(centro.getX(), centro.getY(), radio);
		}

	}

	public static void main(String[] args) {
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		PuntoProfe p = new PuntoProfe(0, 0);
		CirculoProfe c = new CirculoProfe(p, 10);
		// La doy color asignandolo a su punto central
		c.getCentro().setColor(Color.GREEN);
		System.out.println(c);
		c.dibujar(false);

		CirculoProfe c2 = new CirculoProfe(25, 40, 15);
		c2.dibujar(false);
	}

	public boolean seSuperpone(CirculoProfe c) {
		// true si el círculo(this) se superpone con otro círculo c.
		// Se superponen si la distancia entre sus centros es menor que la suma de sus
		// radios.
		return this.centro.distancia(c.getCentro()) < this.radio + c.getRadio();
	}

	public boolean contiene(PuntoProfe p) {
		return centro.distancia(p) < radio;
	}

}
