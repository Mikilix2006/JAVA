package objetos;

import java.awt.Color;

import utilidades.StdAudio;
import utilidades.StdDraw;

public class Circulo {
	private Punto centro;
	private double radio;
	private double xCirculo;
	private double yCirculo;

	public Circulo(Punto p, double radio) {
		centro = p;
		setRadio(radio);
	}
	
	public Circulo(Punto p, double radio, double  x, double y) {
		centro = p;
		setRadio(radio);
		p.setMovX(x);
		p.setMovY(y);
	}
	
	public Circulo(Punto p, double radio, double  x, double y, Color color) {
		centro = p;
		setRadio(radio);
		p.setMovX(x);
		p.setMovY(y);
	}

	public Circulo(double xCentro, double yCentro, double radio) {
		Punto p =new Punto(xCentro,yCentro);
		centro = p;
		setRadio(radio);
	}
	
	public Circulo(double xCentro, double yCentro, double radio, Color color) {
		Punto p =new Punto(xCentro,yCentro,color);
		centro = p;
		setRadio(radio);
	}
	
	public Circulo(double xCentro, double yCentro, double movX, double movY, double radio, Color color) {
		Punto p =new Punto(xCentro,yCentro,color);
		centro = p;
		p.setMovX(movX);
		p.setMovY(movY);
		setRadio(radio);
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
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


	public double getxCirculo() {
		return xCirculo;
	}

	public void setxCirculo(double xCirculo) {
		this.xCirculo = xCirculo;
	}

	public double getyCirculo() {
		return yCirculo;
	}

	public void setyCirculo(double yCirculo) {
		this.yCirculo = yCirculo;
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

	public void mover() {
		centro.mover();
		setxCirculo(centro.getX());
		setyCirculo(centro.getY());
	}

	public double distancia(Circulo otro) {
		return Math.sqrt(Math.pow(this.centro.getX()-otro.centro.getX(),2)+Math.pow(this.centro.getY()-otro.centro.getY(),2));
	}

	public Punto puntoMedio(Circulo circulo) {
		Punto p=new Punto((this.centro.getX()+circulo.centro.getX())/2,(this.centro.getY()+circulo.centro.getY())/2);
		return p;
	}
	
	public boolean contiene(Punto p) {
		return centro.distancia(p) < radio;
	} 
	
	public boolean seSuperpone(Circulo c) {
		// true si el círculo(this) se superpone con otro círculo c.
		// Se superponen si la distancia entre sus centros es menor que la suma de sus radios.
		return this.centro.distancia(c.getCentro()) < this.radio+c.getRadio();
	}

	public void controlarRebote() {
		// Detectar límites de la ventana
		if (Math.abs(getxCirculo()) >= 100-getRadio()) { // izq. o drecha
			getCentro().setMovX(-getCentro().getMovX());
			StdAudio.playInBackground("soniquete.wav");
		}
		if (Math.abs(getyCirculo()) >= 100-getRadio()) { // izq. o drecha
			getCentro().setMovY(-getCentro().getMovY());
			StdAudio.playInBackground("soniquete.wav");
		}
	}

	// PULIR CONDICION
	public void reboteRaqueta(Raqueta raqueta) {
		if ((this.centro.getY()-raqueta.getExtIzq().getY())<4 &&
			this.centro.getX()>raqueta.getExtIzq().getX() &&
			this.centro.getX()<raqueta.getExtIzq().getX()+raqueta.getLargo()) {
			centro.setMovY(-centro.getMovY());
			StdAudio.playInBackground("soniquete.wav");
		}
	}


//	public static void main(String[] args) {
//		StdDraw.setXscale(-100, 100);
//		StdDraw.setYscale(-100, 100);
//		Punto p = new Punto(0, 0);
//		Circulo c = new Circulo(p, 10);
//		// La doy color asignandolo a su punto central
//		c.getCentro().setColor(Color.GREEN);
//		System.out.println(c);
//		c.dibujar(false);
//		
//		Circulo c2=new Circulo(25,40,15);
//		c2.dibujar(false);
//	}

}