package ejercicio46_2;

import java.util.concurrent.ThreadLocalRandom;

public class Compra extends Thread{
	
	public int numProductos;
	private int total;
	
	public Compra() {}
	
	public Compra(int numProductos) {
		this.numProductos=numProductos;
		this.total=numProductos;
	}
	
	public int getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public void run() {
		while(numProductos>0) {			
			int num = ThreadLocalRandom.current().nextInt(1000, 3000);
			try {
				Thread.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producto pasado");
			numProductos--;
		}
	}

}
