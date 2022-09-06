package ejercicio39;

public class Coche implements Runnable{
	
	private String marca;
	private String modelo;
	public Coche() {}
	
	public Coche(String marca, String modelo) {
		this.marca=marca;
		this.modelo=modelo;
	}
	
	@Override
	public void run() {
		
		System.out.println(marca);
		
		try {
			Thread.sleep(300);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(modelo);
		
	}

}
