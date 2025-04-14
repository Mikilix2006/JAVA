package objetos;

public class Persona {
	// Atributos
	String nombre;
	int edad;
	boolean llevaGafas;
	
	public Persona(String n, int e, boolean gafas) {
		nombre=n;
		edad=e;
		llevaGafas=gafas;
	}

	public Persona(String n) {
		nombre=n;
		edad=0;
		llevaGafas=false;
	}

	public Persona() {
		nombre="Alicia";
		edad=20;
		llevaGafas=true;
	}

	// Imprime los atributos con el nombre del objeto
	// Click derecho --> Source --> Generate toString()
	public String toString() {
		return "Persona ["+ nombre + " " + edad + " " + llevaGafas + "]";
	}
		
}
