package ejercicio46;

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
		for(int i =compra.getTotal();i>0;i--) {
			System.out.println(this.getName()+" poniendo producto...");
			compra.put(1);
			
		}
		
	}

}
