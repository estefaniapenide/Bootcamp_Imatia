package ejercicio42;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Principal {

	public static void main(String[] args) {

		Timer timer = new Timer();
		AtomicInteger contador = new AtomicInteger();
		contador.set(1);
		
//		AtomicInteger contador = new AtomicInteger();
//		contador.set(0);
//		Tarea tarea = new Tarea(timer);
//		
//		while(contador.get()<5) {
//		timer.schedule(tarea, 3000,3000);
//		contador.getAndAdd(1);
//		}
//		
//		tarea.cancel();
		
		


		timer.schedule(new TimerTask() {
			
			
			@Override
			public void run() {
//				contador.set(1);
				
				if(contador.getAndIncrement()<=5) {	
					System.out.println("Tarea furtura");

				}else {
				System.out.println("Fin de la tarea");
				timer.cancel();
				}
			}
			},3000,3000);

		System.out.println("Programa iniciado");

	}

}
