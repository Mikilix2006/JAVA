package objetos;

import utilidades.Entrada;

public class ExpresionesRegulares {

	public static void main(String[] args) {

		for (;;) {
			
			System.out.println("Mete nnnumerín: ");
			String t = Entrada.cadena();

			if (t.matches("[0-9]+")) // esto es para si contiene totalmente números
				System.out.println("ES un nnnumerín");
			else
				System.out.println("No es un nnnumerín");
			
		}
		
//		. --> Un unico caracter cualquiera
//		[0-9 a-z A-Z] --> un unico caracter entre el codigo unicode de 0 y el 9, la a y la z y la A y la Z
//		? --> Un unico caracter o ninguno
		
	}

}
