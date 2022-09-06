package ejercicio40;

public class DistribuidorCoches {

	private int numeroCochesVendidos=0;
	private int stock=0;
	private boolean stockDisponible;

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
	
	public void ponerCocheVenta() {
		this.stock++;
		System.out.println("STOCK ACTUALIZADO");
		System.out.println("Stock: "+this.stock);
	}

//	public synchronized void ponerCocheVenta() {
//		this.stock++;
//		System.out.println("STOCK ACTUALIZADO");
//		System.out.println("Stock: "+this.stock);
//	}
	
	public void venderCoche() {
		if (this.stock > 0) {
			this.numeroCochesVendidos++;
			this.stock--;
			System.out.println("VENTA REALIZADA");
			System.out.println("Coches vendidos: "+this.numeroCochesVendidos);
			System.out.println("Stock: "+this.stock);
		}else {
			System.out.println("No es posible vender un coche. No hay suficiente stock");
		}
	}

	

//	public synchronized void venderCoche() {
//		if (this.stock > 0) {
//			this.numeroCochesVendidos++;
//			this.stock--;
//			System.out.println("VENTA REALIZADA");
//			System.out.println("Coches vendidos: "+this.numeroCochesVendidos);
//			System.out.println("Stock: "+this.stock);
//		}else {
//			System.out.println("No es posible vender un coche. No hay suficiente stock");
//		}
//	}

}
