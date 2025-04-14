package arrayLists;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import objetos.Punto;
import utilidades.Entrada;

public class ListasDeArray {
	
//	**********************************************
//	.set() .sort() .add() .size() .remove() .get()
//	**********************************************

	public static void main(String[] args) {

		List <Integer> a1=new ArrayList <Integer>();
		int n;
		
		do {
			System.out.println("Mete número (-1 para salir): ");
			n = Entrada.entero();
			if (n!=-1)
				a1.add(0, n);
		} while (n!=-1);
		
		System.out.println(a1);
		a1.sort(null); // ordena de menor a mayor la lista
		System.out.println(a1);
		
		List <Punto> a2=new ArrayList <Punto>();
		a2.add(new Punto(0,0,Color.BLUE));
	}

}
