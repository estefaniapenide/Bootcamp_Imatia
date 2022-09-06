package ejercicio41;

import java.util.Timer;
import java.util.TimerTask;

public class TareaFutura extends TimerTask{
	
	private Timer timer;
	public TareaFutura(Timer timer) {
		this.timer=timer;
	}
	
	@Override
	public void run() {
		System.out.println("Esta tarea se ejecuta unos segundos despu�s de haber inicializado el programa.");
		timer.cancel();
	}

}
