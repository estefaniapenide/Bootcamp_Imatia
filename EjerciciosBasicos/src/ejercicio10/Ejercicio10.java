package ejercicio10;

import java.util.ArrayList;

public class Ejercicio10 {

	public static void main(String[] args) {

		String[] colores = { "azul", "roja", "verde" };

		ArrayList<Bola> bolas = new ArrayList<Bola>();

		int contadorAzul = 0;

		for (int i = 0; i < 10; i++) {

			int color = 0 + (int) (Math.random() * 3);
			Bola bola = new Bola(colores[color]);

			if (bola.getColor().equals(colores[0])) {
				contadorAzul++;
			}

			bolas.add(bola);
		}
		
		System.out.println("Total azules: " + contadorAzul+"\n");

		for (Bola bola : bolas) {

			if (!bola.getColor().equals(colores[0])) {
				System.out.println("Bola " + bola.getColor());
			} else {
				System.out.println("Bola " + bola.getColor());
				break;
			}
		}

		

	}

}
