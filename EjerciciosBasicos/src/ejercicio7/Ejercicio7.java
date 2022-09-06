package ejercicio7;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		numerosNaturales();
		sumarNaturales();
		
		String[] array= {"cero","uno","dos","tres","cuatro","cinco"};
		
		buscarPosicionArray(array,"tres");
		buscarPosicionArray(array,"seis");

	}
	
	public static void numerosNaturales() {
		System.out.print("15 primeros n�meros naturales: ");
		
		for(int i=1; i<=15;i++) {
			System.out.print(i+" ");
		}
	}
	
	public static void sumarNaturales() {
		
		int suma = 0;
		for (int i = 0; i <= 100; i++) {
			suma = suma + i;
		}
		System.out.println("\nSuma de los 100 primeros n�meros: " + suma);
	}
	
	public static void buscarPosicionArray(String[] array, String elemento) {
		
		int psoicion=-1;
		
		for (int i = 0; i < array.length; i++) {
		    if (array[i] == elemento) {
		    	psoicion=i;
		    	break; //Para que no siga dando vueltas si lo encuentra
		    }
		  }
		
		if (psoicion==-1) {
			System.out.println("El elemento '"+elemento+"' no est� en el array.");
		}else {
			System.out.println("Posici�n: "+psoicion);
		}
		
	}

}
