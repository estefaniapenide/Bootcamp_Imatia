package ejercicio45;

import java.util.concurrent.ThreadLocalRandom;

public class Tarea extends Thread{
	
	public Tarea(String nombre) {
		super(nombre);
	}
	
	@Override
	public void run() {
		int num= ThreadLocalRandom.current().nextInt(1, 3000);
		
		System.out.println("Tarea "+this.getName()+" iniciada");		
		
		System.out.println ("Tarea "+this.getName()+", Número: "+num);
		try {
		sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Tarea "+this.getName()+" finalizada");	
	}

}
