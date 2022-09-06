package ejercicio36;

import java.util.concurrent.ThreadLocalRandom;

public class HiloThread extends Thread{
	
	private int repeticiones;
	private String nombre;

	public HiloThread(String nombre, int repeticiones) {
		this.nombre = nombre;
		this.repeticiones = repeticiones;
	}
	
	@Override
	public void run() {
		while (repeticiones > 0) {
//			Thread.State stateRunnable = Thread.currentThread().getState();
//			System.out.println(stateRunnable);
			
			int tiempo = ThreadLocalRandom.current().nextInt(1000, 3000);
			// int tiempo = (int)( Math.random() * (3000-1000+3000)+1000);
			
			System.out.println(nombre);
			
			try {
				sleep(tiempo);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repeticiones--;
		}

		System.out.println(nombre + " finalizado");
	}

}
