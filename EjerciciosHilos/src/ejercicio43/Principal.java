package ejercicio43;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		
		Tarea tarea = new Tarea();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(tarea);		
//		executor.execute(tarea);
		executor.shutdown();
		try {
		executor.awaitTermination(2000,TimeUnit.MILLISECONDS);
		}catch(InterruptedException e) {
		}
		
		System.out.println("aaaa");
		
	}

}
