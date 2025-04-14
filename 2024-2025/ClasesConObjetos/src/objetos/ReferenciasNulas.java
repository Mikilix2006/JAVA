package objetos;

public class ReferenciasNulas {

	public static void main(String[] args) {
		System.out.println(ultimaLetra("Las"));
		
		String [] pal = {"Pek","Perro","LOT"};
		for (int i=0; i < pal.length; i++)
			System.out.println(ultimaLetra(pal[i]));
		
		String [] pal2 = new String [5]; // cada elemento contiene null
		for (int i=0; i < pal2.length; i++)
			System.out.println(ultimaLetra(pal2[i]));
		
		
	}
	
	private static String ultimaLetra(String t) {
		if (t==null) // t no tiene objeto asociado
			return null;
		
		return t.substring(t.length()-1);
	}
	
}
