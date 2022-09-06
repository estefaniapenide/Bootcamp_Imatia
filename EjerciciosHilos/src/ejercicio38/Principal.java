package ejercicio38;

import ejercicio38.Hilo;

public class Principal {

	public static void main(String[] args) {

		Thread hilo0 = new Thread(new Hilo("Hilo 0", 10));	
		Thread hilo1 = new Thread(new Hilo("Hilo 1", 10));	
		Thread hilo2 = new Thread(new Hilo("Hilo 2", 10));	
		
		System.out.println(hilo0.getName()+" "+hilo0.getState());
		System.out.println(hilo1.getName()+" "+hilo1.getState());
		System.out.println(hilo2.getName()+" "+hilo2.getState());
		
		hilo0.start();
		hilo1.start();
		hilo2.start();
		
		System.out.println(hilo0.getName()+" "+hilo0.getState());
		System.out.println(hilo1.getName()+" "+hilo1.getState());
		System.out.println(hilo2.getName()+" "+hilo2.getState());

		try {
			hilo0.join();
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(hilo0.getName()+" "+hilo0.getState());
		System.out.println(hilo1.getName()+" "+hilo1.getState());
		System.out.println(hilo2.getName()+" "+hilo2.getState());
	}

}
