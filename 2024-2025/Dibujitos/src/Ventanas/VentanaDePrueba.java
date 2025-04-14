package Ventanas;

import javax.swing.JOptionPane;

public class VentanaDePrueba {

	public static void main(String[] args) {
		String dato = JOptionPane.showInputDialog(null, "Mete un dato"); // Capta mensaje
		JOptionPane.showMessageDialog(null, "Voy a adivinar tu dato"); // Muestra mensaje
		if (dato==null)
			JOptionPane.showMessageDialog(null, "Eres subnormal");
		else
			JOptionPane.showMessageDialog(null, dato.toUpperCase());
		
	}

}
