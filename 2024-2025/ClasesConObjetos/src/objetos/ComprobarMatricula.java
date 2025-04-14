package objetos;

import utilidades.Entrada;

public class ComprobarMatricula {

	public static void main(String[] args) {
		for (;;) {
			System.out.println("Mete matrícula:");
			String t = Entrada.cadena();
			
			t = t.toUpperCase();
			
			if (t.matches("[0-9]{4}[ -]?[B-DF-HJ-NP-TV-Z]{3}"))
				System.out.println("Si es una matrícula de coche");
			else
				System.out.println("No es una matrícula de coche");
		}
	}

}
