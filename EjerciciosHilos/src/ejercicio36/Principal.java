package ejercicio36;

import java.util.Timer;

public class Principal {

	public static void main(String[] args) {
		
		Thread hilo0 = new Thread(new HilorRunnable("Hilo 0", 10));	
		HiloThread hilo1 = new HiloThread("Hilo 1", 10);
		//System.out.println(hilo0.getState());
		hilo0.start();
		hilo1.start();
		//System.out.println(hilo0.getState());
		

	}

}
