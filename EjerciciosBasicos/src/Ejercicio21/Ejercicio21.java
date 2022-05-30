package Ejercicio21;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio21 {

	public static void main(String[] args) {

		// Ejercicio 21
		System.out.println("\nEjercicio 21");
		Set<String> conjunto = new HashSet<String>();
		conjunto.add("hola");
		conjunto.add("adiós");
		conjunto.add("hola");
		conjunto.add("hooooo");
		conjunto.add("aaaa");
		conjunto.add("laaaa");
		conjunto.remove("hooooo");

		for (String cadena : conjunto) {
			System.out.println(cadena);
		}

	}

}
