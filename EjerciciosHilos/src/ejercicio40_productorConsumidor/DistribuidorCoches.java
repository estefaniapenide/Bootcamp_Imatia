package ejercicio40_productorConsumidor;

public class DistribuidorCoches {

	private int numeroCochesVendidos = 0;
	private int stock = 0;
	private boolean stockDisponible = false;

	public DistribuidorCoches() {
	}

	public DistribuidorCoches(int numeroCochesVendidos, int stock) {
		super();
		this.numeroCochesVendidos = numeroCochesVendidos;
		this.stock = stock;
	}

	public int getNumeroCochesVendidos() {
		return numeroCochesVendidos;
	}

	public void setNumeroCochesVendidos(int numeroCochesVendidos) {
		this.numeroCochesVendidos = numeroCochesVendidos;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isStockDisponible() {
		return stockDisponible;
	}

	public void setStockDisponible(boolean stockDisponible) {
		this.stockDisponible = stockDisponible;
	}

	public synchronized void put(int valor) {
		while (stockDisponible) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.stock += valor;
		stockDisponible = true;
		 System.out.println("\tSTOCK ACTUALIZADO => Stock: "+this.stock);
		notifyAll();
	}

	public synchronized void get() {
		while (!stockDisponible) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		stockDisponible = false;
		this.numeroCochesVendidos++;
		this.stock--;
		System.out.println("\tVENTA REALIZADA => Coches vendidos: "+this.numeroCochesVendidos+", Stock: "+this.stock);
		notifyAll();
	}

}
