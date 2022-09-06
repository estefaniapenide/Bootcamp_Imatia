package ejercicio46_2;

import ejercicio46_2.Compra;

public class Cajera extends Thread{
	
	private Cola cola;

	public Cajera() {
	}
	
	public Cajera(String nombre) {
		super(nombre);

	}

	public Cajera(String nombre, Cola cola) {
		super(nombre);
		this.cola = cola;
	}


	public Cola getCola() {
		return cola;
	}

	public void setCola(Cola cola) {
		this.cola = cola;
	}

	@Override
	public void run() {

		for(int i =cola.getTotalClientes();i>0;i--) {		
			cola.put();		
			cola.get();	
		}
			

	}

}
