package objetos;

import utilidades.Entrada;

public class ComprobarDNI {

	public static void main(String[] args) {
			System.out.println("Mete DNI/NIE:");
			String dniNie = verificarDNI(Entrada.cadena()); // mete el dni/nie verificado y normalizado
			if (dniNie!=null) // si es valido, lo clasifica en 'nie' o 'dni'
				if (dniNie.matches("[XYZ][0-9]{7}")) // si su estructura es de nie, lo imprime con su mensaje
					System.out.println("NIE válido: "+dniNie);
				else // si su estructura no es de nie, lo imprime con su mensaje
					System.out.println("DNI válido: "+dniNie);
			else // si no es valido, te dice que no era valido
				System.out.println("DNI/NIE no válido");
	}
	
	public static String verificarDNI(String t) { // recoge el input en bruto
		String [] c = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		t = t.toUpperCase().trim(); // quitar espacios y pasar a mayusculas
		if (!t.matches("[0-9]{1,8}[A-Z]")) // si no tiene estructura de dni, comprobar si es un nie
			if (!t.matches("[XYZ][0-9]{7}[A-Z]")) // si no tiene estructura de nie ni de dni, null
				return null;
			else { // tiene estructura de un nie
				int n = Integer.valueOf(t.substring(1, t.length()-1)); // saca solo los numeros
				// si la primera es x no hace nada
				if (t.substring(0, 1).equals("Y")) // si la primera es y, pone un 1 delante
					n = 1000000 + n;
				if (t.substring(0, 1).equals("Z")) // si la primera es z, pone un 2 delante
					n = 2000000 + n;
				if (!c[n%23].equals(t.substring(t.length()-1))) // si letra del nie no equivale a la de su resto, null
					return null;
			}
		else { // tiene estructura de un dni
			int n = Integer.valueOf(t.substring(0, t.length()-1)); // saca solo los numeros
			if (!c[n%23].equals(t.substring(t.length()-1))) // si letra del dni no equivale a la de su resto, null
				return null;
			while (t.length()<9) // añade los 0's necesarios por la izquierda
				t = "0" + t;
		}
		return t; // devuelve el dni/nie verificado y normalizado
	}
}
