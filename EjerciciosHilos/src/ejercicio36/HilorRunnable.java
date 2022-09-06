package ejercicio36;

import java.util.concurrent.ThreadLocalRandom;

public class HilorRunnable implements Runnable {

	private int repeticiones;
	private String nombre;

	public HilorRunnable(String nombre, int repeticiones) {
		this.nombre = nombre;
		this.repeticiones = repeticiones;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
				Thread.sleep(tiempo);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repeticiones--;
		}

		System.out.println(nombre + " finalizado");
	}

}
