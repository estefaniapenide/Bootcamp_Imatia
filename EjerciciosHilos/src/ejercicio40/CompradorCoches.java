package ejercicio40;

public class CompradorCoches extends Thread {

	private int vecesCompra;
	private DistribuidorCoches distribuidor;

	public CompradorCoches() {
	}

	public CompradorCoches(String nombre,int vecesCompra, DistribuidorCoches distribuidor) {
		super(nombre);
		this.vecesCompra = vecesCompra;
		this.distribuidor = distribuidor;
	}

	@Override
	public void run() {
		synchronized (distribuidor) {
			while (vecesCompra > 0) {
				System.out.println("\n"+this.getName()+" intentando comprar coche...");
				distribuidor.venderCoche();
				distribuidor.notifyAll();
				try {
					distribuidor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				distribuidor.notifyAll();
//			try {
//				sleep(3000);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
				vecesCompra--;
			}
		}
	}

}
