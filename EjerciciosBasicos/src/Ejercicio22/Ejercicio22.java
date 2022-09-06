package Ejercicio22;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio22 {

	public static void main(String[] args) {

		// Ejercicio 22
		System.out.println("\nEjercicio 22");
		List<String> listaStrings = new ArrayList<String>();
		listaStrings.add("hola");
		listaStrings.add("adiós");
		listaStrings.add("hola");
		listaStrings.add("hooooo");
		listaStrings.add("aaaa");
		listaStrings.add("laaaa");

		for (int i = 0; i < listaStrings.size(); i++) {
			System.out.println(i + " " + listaStrings.get(i));
		}

	}

}
