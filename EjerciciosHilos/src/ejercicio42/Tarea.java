package ejercicio42;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Tarea extends TimerTask{
	
	private Timer timer;
	
	public Tarea() {}
	
	public Tarea(Timer timer) {
		this.timer=timer;
	}
	
	@Override
	public void run() {
		System.out.println("Esta tarea se ejecuta segundos despu�s de haber inicializado el programa.");
		//timer.cancel();	
	}			
}


