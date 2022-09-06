package ejercicio46_2;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		ap2();

	}
	
	public static void ap3() {
		
		Compra compra1 = new Compra(4);
		Compra compra2 = new Compra(1);
		Compra compra3 = new Compra(9);
	
		Cliente cliente1 = new Cliente("1",compra1);
		Cliente cliente2 = new Cliente("2",compra2);
		Cliente cliente3 = new Cliente("3",compra3);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		Cola cola = new Cola("Cola 1",clientes);
		
		Cajera cajera1 = new Cajera("CAJA 1",cola);
		Cajera cajera2 = new Cajera("CAJA 2",cola);
		
		cajera1.start();
		cajera2.start();
		
	}
	
	public static void ap2() {
		
		Compra compra1 = new Compra(4);
		Compra compra2 = new Compra(1);
		Compra compra3 = new Compra(9);

		
		Cliente cliente1 = new Cliente("1",compra1);
		Cliente cliente2 = new Cliente("2",compra2);
		Cliente cliente3 = new Cliente("3",compra3);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		Cola cola = new Cola("Cola 1",clientes);
		
		Cajera cajera1 = new Cajera("CAJA 1",cola);
		
		cajera1.start();
	}

}
