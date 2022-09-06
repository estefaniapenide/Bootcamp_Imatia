package ejercicio46;

import java.util.concurrent.ThreadLocalRandom;

public class Cajera extends Thread {

	private Compra compra;

	public Cajera() {
	}
	
	public Cajera(String nombre) {
		super(nombre);

	}

	public Cajera(String nombre, Compra compra) {
		super(nombre);
		this.compra = compra;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public void run() {

		for(int i =compra.getTotal();i>0;i--) {
			System.out.println(this.getName()+" trabajando...");
			compra.get();
			
		}
		
		

	}

}
