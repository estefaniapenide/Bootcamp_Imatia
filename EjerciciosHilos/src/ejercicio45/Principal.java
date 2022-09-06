package ejercicio45;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ejercicio37.Hilo;
import ejercicio45.Tarea;

public class Principal {

	public static void main(String[] args) {
		
		//Reacer tras ver el anterior arreglado
		
		Tarea tarea1 = new Tarea("1");
		Tarea tarea2 = new Tarea("2");
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
	
		
//		executor.execute(tarea1);
//		executor.execute(tarea2);
		
//		Future<String> primerFuture = executor.submit(new Callable<String>() {
//		      public String call() throws Exception {
//		        return primeraTarea("Arrancando la primera tarea");
//		      }
//		    });
		
		Future<?> resultado= executor.submit(tarea1);
		Future<?> resultado2= executor.submit(tarea2);

	}

}
