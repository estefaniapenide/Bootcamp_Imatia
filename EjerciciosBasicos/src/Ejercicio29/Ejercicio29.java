package Ejercicio29;

public class Ejercicio29 {

	public static void main(String[] args) {

		try {

			int b = 3 / 0;

		} catch (ArithmeticException E) {
			System.out.println("No es posible dividir un entero entre cero.");
		}

	}

}
