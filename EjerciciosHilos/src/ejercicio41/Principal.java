package ejercicio41;

import java.util.Timer;
import java.util.TimerTask;

public class Principal {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		
		TareaFutura tarea = new TareaFutura(timer);		
		timer.schedule(tarea, 3000);	
		
	//????
//		tarea.cancel();
//		timer.cancel();
		
		System.out.println("Programa iniciado");

	}

}
