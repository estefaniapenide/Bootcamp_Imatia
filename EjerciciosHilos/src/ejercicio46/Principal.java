package ejercicio46;

import java.util.concurrent.ThreadLocalRandom;

public class Principal {

	public static void main(String[] args) {

//		ap1();
		ap2();//No funciona

	}

	public static void ap1() {

		Compra compra1 = new Compra("1", 8);
		Cliente cliente1 = new Cliente("C1", compra1);

		Cajera cajera1 = new Cajera("CAJA 1", compra1);

		cliente1.start();
		cajera1.start();

	}

	public static void ap2() {

		Cajera cajera1 = new Cajera("CAJA 1");

		for (int i = 1; i <= 3; i++) {
			String nombre = String.valueOf(i);
			int num = ThreadLocalRandom.current().nextInt(1, 10);
			Compra compra = new Compra(nombre, num);
			Cliente cliente = new Cliente("C" + nombre, compra);
			cajera1.setCompra(compra);

			cliente.start();
			cajera1.start();

			try {
				cliente.join();
				cajera1.join();
			} catch (InterruptedException e) {
			}
		}

	}

}
