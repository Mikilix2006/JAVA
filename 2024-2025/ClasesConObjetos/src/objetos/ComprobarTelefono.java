package objetos;

import utilidades.Entrada;

public class ComprobarTelefono {

	public static void main(String[] args) {
		for (;;) {
			System.out.println("Mete Teléfono");
			String t = Entrada.cadena();
			
			// para meter '\' dentro de un "", tienes que poner un doble \\
			if (t.matches("\\+[0-9]{1,3}[ -][0-9]{9}"))
				System.out.println("Es un  teléfono");
			else
				System.out.println("No es un teléfono");
		}
	}

}
