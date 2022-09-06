package Ejercicio19;

public class Ejercicio19 {

	public static void main(String[] args) {

		// Ejercicio 19
		System.out.println("\nEjercicio 19");
		String[][] arrayStringsBi = { { "Hola", "Esto", "es", "un", "array", "de", "strings" },
				{ "y", "esta", "es", "la", "segunda", "dimensión", "!!" } };

		int[][][] arrayIntTri = { { { 1, 2, 3 }, { 3, 7, 8 } }, { { 6, 9, 8 }, { 7, 9, 7 } },
				{ { 6, 9, 8 }, { 7, 9, 7 } } };

		recorrerArrayBi(arrayStringsBi);
		recorrerArrayTri(arrayIntTri);

	}

	// Ejercicio 19
	public static void recorrerArrayBi(String[][] array) {

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void recorrerArrayTri(int[][][] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				for (int k = 0; k < array[i][j].length; k++) {
					sum += array[i][j][k];
				}

			}

		}
		System.out.println(sum);
	}

}
