package objetos;

import utilidades.Entrada;

public class IgualdadEntreObjetos {

	public static void main(String[] args) {
		// String es un objeto
		System.out.print("Texto 1?: ");
		String t1 = Entrada.cadena();
		System.out.print("Texto 2?: ");
		String t2 = Entrada.cadena();
		
		if (t1.equals(t2))
			System.out.println("Los objetos contienen el mismo texto");
		else
			System.out.println("Los objetos contienen distinto texto");
		
		if (t1==t2)
			System.out.println("t1 y t2 tienen asociado el mismo objeto");
		else
			System.out.println("t1 y t2 tienen asociados distintos objetos");
	}

}
