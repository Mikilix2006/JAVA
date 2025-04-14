package objetos;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		Persona p=new Persona("Miguel", 18, false); // Crear objeto (instanciar)

		System.out.println(p.nombre); // Imprime el atributo específico
		System.out.println(p.edad);
		System.out.println(p.llevaGafas);
		
		System.out.println("----------------");
		
		Persona p2=new Persona("Ana"); // Crea el mismo objeto con otro nombre

		System.out.println(p2.nombre);
		System.out.println(p2.edad);
		System.out.println(p2.llevaGafas);

		System.out.println("----------------");
		
		Persona p3=new Persona();

		System.out.println(p3.nombre);
		System.out.println(p3.edad);
		System.out.println(p3.llevaGafas);
		
		Persona [] a = new Persona[10]; // Crea una lista de 10 personas
		for (int i=0; i<10; i++) {
			a[i] = new Persona(); // La posicion i de a es una persona entera
			
			Random r = new Random();
			int datos = r.nextInt(1,5);
			switch(datos) {
			case 1:
				a[i].edad=18;
				a[i].llevaGafas=false;
				a[i].nombre="Miguel";
				break;
			case 2:
				a[i].edad=20;
				a[i].llevaGafas=true;
				a[i].nombre="Ana";
				break;
			case 3: 
				a[i].edad=10;
				a[i].llevaGafas=false;
				a[i].nombre="Juan";
				break;
			case 4:
				a[i].edad=50;
				a[i].llevaGafas=true;
				a[i].nombre="Francisca";
				break;
			}
			System.out.println(a[i]); // Imprime la persona entera con el toString()
		}
	}
}
