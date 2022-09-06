package ejercicio17;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Ejercicio14.Personas;

public class Ejercicio17 {

	public static void main(String[] args) {

		// Ejercicio17
		System.out.println("\nEjercicio 17");
		String[] arrayStrings = { "Hola", "Esto", "es", "un", "array", "de", "strings" };
		int[] arrayEnteros = { 2, 4, 5, 6, 8, 10, 12, 15, 100, 34, 56, 78, 34, 23, 89, 34, 0, 12, 6, 9, 30 };

		for (int i = 0; i < 10; i++) {
			ramdomString(arrayStrings);
		}
		System.out.println();

		ramdomInts(arrayEnteros);
		System.out.println();

	}

	// Ejercicio 17
	public static void ramdomString(String[] array) {
		int num = (int) (0 + (array.length - 1) * Math.random());
		String a = array[num];
		System.out.print(a + " ");
	}

	public static void ramdomInts(int[] array) {
		int num = (int) (0 + (array.length - 1) * Math.random());

		for (int i = 0; i < num; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
