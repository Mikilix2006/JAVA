package tiempo;

public class Milisegundos {

	public static void main(String[] args) throws InterruptedException {
		// Mirar el reloj
		long tiempo1=System.currentTimeMillis();
		System.out.println(tiempo1);
		for (int i = 0; i<1000000000; i++) {
			
		}
		long tiempo2=System.currentTimeMillis();
		System.out.println(tiempo2);
		System.out.println("El for ha tardado: "+(tiempo2-tiempo1));
	}

}
