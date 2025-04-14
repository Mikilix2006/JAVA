package tartaglia;

import utilidades.Entrada;

public class TrianguloTartaglia {

	public static void main(String[] args) {
		int filas, fila;
		
		// VERIFICO QUE EL DATO SEA MAYOR A 0
		do {
			System.out.println("Cuántas filas?:");
			filas = Entrada.entero();
			if (filas<=0)
				System.out.println("Sólo filas mayores a 0 :))");
		} while (filas<=0);
		
		if (filas>2) {
			String [] array = new String [filas*2-1]; // ESTE TIENE LOS SUMANDOS
			String [] imprimir = new String [filas*2-1]; // ESTE TIENE LAS SUMAS
			fila = 1;
			
			// RELLENA EL ARRAY ENTERO CON ESPACIOS
			for (int i=0; i<array.length; i++) {
				array[i] = "0";
				imprimir[i] = "0";
			}
			array[(array.length-1)/2] = "1";
			
			// LO MEJOR ES UTILIZAR EL DEBUGGER PARA ENTENDERLO
			do {
				for (int j=0;j<(imprimir.length-1)/2; j++) {
					for (int i=0;i<imprimir.length; i++) {
						if (i!=0 && i!=imprimir.length-1) {
							imprimir[i] = String.valueOf(Integer.valueOf(array[i-1])+Integer.valueOf(array[i+1]));
						}
					}
					if (fila==1) {
						for (int k=0; k<array.length; k++) {
							if (array[k].equals("0"))
								System.out.print("  ");
							else
								System.out.print(array[k]);
						}
						System.out.println();
						for (int l=0; l<imprimir.length; l++) {
							if (imprimir[l].equals("0"))
								System.out.print("  ");
							else
								System.out.print(imprimir[l]);
						}
						fila++;
					} else {
						for (int l=0; l<imprimir.length; l++) {
							if (fila == filas && (l==0 || l==imprimir.length-1))
								System.out.print("1");
							else {
							if (imprimir[l].equals("0")) 
								System.out.print("  ");
							else
								System.out.print(imprimir[l]);
							}
						}
					}
					fila++;
					for (int k=0; k<array.length; k++)
						array[k] = imprimir[k];
					System.out.println(); // NUEVA FILA
							}
			} while (fila<=filas);
		} else {
			if (filas == 2) {
				System.out.println(" 1 ");
				System.out.println("1 1");
			} else
				System.out.println("1");
		}
	}
}
