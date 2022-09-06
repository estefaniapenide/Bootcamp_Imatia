package ejercicio40_productorConsumidor;

import ejercicio40_productorConsumidor.DistribuidorCoches;

public class FabricanteAutomovil extends Thread{
	
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
	        for (int i = vecesFabrica; i >0; i--) {
	        	System.out.println(this.getName()+" fabricando coche...");
	            distribuidor.put(1); //pone el número
	            System.out.println("\tCOCHE FABRICADO POR "+this.getName()+"\n");
	            
	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) { }		
		    }
	        System.out.println("Fin productor...");
	    }

//	@Override
//	public void run() {
//		synchronized (distribuidor) {
//			while (vecesFabrica > 0) {
//				System.out.println("\n"+this.getName()+" fabricando coche...");
//				distribuidor.ponerCocheVenta();
//				distribuidor.notifyAll();
//				try {
//					distribuidor.wait();
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//					}
//				
//				distribuidor.notifyAll();
//
////			try {
////				sleep(3000);
////			}catch(InterruptedException e) {
////				e.printStackTrace();
////			}		
//				vecesFabrica--;
//			}
//		}
//	}

}
