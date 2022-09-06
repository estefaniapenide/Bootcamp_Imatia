package ejercicio39;

public class Principal {

	public static void main(String[] args) {
		
		Thread coche1 = new Thread(new Coche("Citroen","C3"));
		Thread coche2 = new Thread(new Coche("Opel","Corsa"));
		Thread coche3 = new Thread(new Coche("Ford","Fiesta"));
		
		coche1.start();
		coche2.start();
		coche3.start();

	}

}
