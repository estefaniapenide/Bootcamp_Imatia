package ejercicio46_2;

import ejercicio46_2.Compra;

public class Cliente extends Thread{
	
	private Compra compra;
	
	public Cliente() {}
	
	public Cliente(String nombre,Compra compra) {
		super(nombre);
		this.compra=compra;
	}
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public void run() {
		compra.start();
		try {
		compra.join();
		}catch(InterruptedException e) {}
		
	}

}
