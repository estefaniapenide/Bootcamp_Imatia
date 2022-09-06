package Ejercicio18;

public class Ejercicio18 {

	public static void main(String[] args) {

		int[] arrayEnteros = { 2, 4, 5, 6, 8, 10, 12, 15, 100, 34, 56, 78, 34, 23, 89, 34, 0, 12, 6, 9, 30 };

		// Ejercicio 18
		System.out.println("\nEjercicio 18");
		enterosRepetidos(arrayEnteros, 30);
		enterosRepetidos(arrayEnteros, 2);
		enterosRepetidos(arrayEnteros, 34);

	}

	// Ejercicio 18
	public static void enterosRepetidos(int[] array, int valor) {

		int cont = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == valor) {
				cont++;
			}
		}

		System.out.println("Veces que se repite " + valor + " en el array: " + cont);
	}

}
