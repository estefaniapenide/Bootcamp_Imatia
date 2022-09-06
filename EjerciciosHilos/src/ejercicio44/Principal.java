package ejercicio44;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ejercicio44.Tarea;

public class Principal {

	public static void main(String[] args) {
		
		//Ver capturas
		
		Tarea tarea1 = new Tarea("1");
		Tarea tarea2 = new Tarea("2");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
//		executor.submit(tarea1);
//		executor.submit(tarea2);
		
		Future<?> resultado= executor.submit(tarea1);
		Future<?> resultado2= executor.submit(tarea2);


	}

}
