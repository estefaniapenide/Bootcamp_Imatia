package ejercicio43;

import java.util.TimerTask;

public class Tarea extends Thread{
	
	@Override
	public void run() {
		System.out.println("Tarea iniciada");		
		try {
		sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Tarea finalizada");	
	}

}
