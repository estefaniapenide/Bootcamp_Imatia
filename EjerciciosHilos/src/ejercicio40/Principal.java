package ejercicio40;

public class Principal {

	public static void main(String[] args) {
		
		DistribuidorCoches distribuidor = new DistribuidorCoches();
		
		FabricanteAutomovil fabricanteHilo1 = new FabricanteAutomovil("Fab1",10,distribuidor);
		FabricanteAutomovil fabricanteHilo2 = new FabricanteAutomovil("Fab2",10,distribuidor);
		CompradorCoches compradorHilo1 = new CompradorCoches("Comp1",12,distribuidor);
		CompradorCoches compradorHilo2 = new CompradorCoches("Comp2",12,distribuidor);
		
		fabricanteHilo1.start();
		fabricanteHilo2.start();
		compradorHilo1.start();
		compradorHilo2.start();

	}

}
