package Ejercicio11;

public class Ejercicio11 {

	public static void main(String[] args) {
		
		ControlRemoto cr = new ControlRemoto(2,3,false);
		System.out.println(cr);
		
		cr.subirVolumen();
		System.out.println(cr);
		
		cr.disminuirCanal();
		System.out.println(cr);
		
		cr.encender();
		System.out.println(cr);
		

	}

}
