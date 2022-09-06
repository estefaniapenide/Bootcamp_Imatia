package ejercicio40;

public class FabricanteAutomovil extends Thread {

	private int vecesFabrica;
	private DistribuidorCoches distribuidor;

	public FabricanteAutomovil() {
	}

	public FabricanteAutomovil(String nombre,int vecesFabrica, DistribuidorCoches distribuidor) {
		super(nombre);
		this.vecesFabrica = vecesFabrica;
		this.distribuidor = distribuidor;
	}

	@Override
	public void run() {
		synchronized (distribuidor) {
			while (vecesFabrica > 0) {
				System.out.println("\n"+this.getName()+" fabricando coche...");
				distribuidor.ponerCocheVenta();
				distribuidor.notifyAll();
				try {
					distribuidor.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
					}
				
				distribuidor.notifyAll();

//			try {
//				sleep(3000);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}		
				vecesFabrica--;
			}
		}
	}

}
