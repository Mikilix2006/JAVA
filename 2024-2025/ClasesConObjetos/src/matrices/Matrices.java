package matrices;

import utilidades.Entrada;
import utilidades.Func;

public class Matrices {

	public static void main(String[] args) {
		// Matriz de 2x3 (filas x columnas)
		// String [][] pal= {{"Casa","Lobo","Alumno"},{"Manuel","Maria","Miguel"}};
		
		int ind;
		do {
			System.out.print("Intorduce el número de filas/columnas: ");
			ind = Entrada.entero();
		} while (ind<=0);
		
		// Creamos matriz cuadrada
		int [][] num=new int [ind][ind];
		
		// Ponemos 1s en la diagonal y parte superior
		for (int fila=0; fila<num.length; fila++)
			for (int columna=0; columna<num[0].length; columna++)
				if (columna>=fila)
					num[fila][columna] = 1;
		
		Func.mostrarMatriz(num);
		
		System.out.print("Que fila quieres: ");
		int indFila = Entrada.entero();
		Func.mostrarFila(Func.extraerFila(num, indFila));
		
		System.out.print("Que columna quieres: ");
		int indColum = Entrada.entero();
		Func.mostrarColumna(Func.extraerColumna(num, indColum));
		
	}

}
