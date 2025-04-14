package matrices;

import utilidades.Func;

public class OperarMatrices {

	public static void main(String[] args) {
		double[][] m1 ={
				{1.1,1.2,1.3},
				{2.1,2.2,2.3},
				{3.1,3.2,3.3}
				};
		double[][] m2 ={
				{1.1,1.2,1.3},
				{2.1,2.2,2.3},
				{3.1,3.2,3.3}
				};
		
		System.out.println("Suma:");
		Func.mostrarMatriz(Func.sumarMatrices(m1, m2));
		System.out.println();
		System.out.println("Resta:");
		Func.mostrarMatriz(Func.restarMatrices(m1, m2));
		System.out.println();
		System.out.println("Multiplicación:");
		Func.mostrarMatriz(Func.multiplicarMatrices(m1, m2));
	}

}
