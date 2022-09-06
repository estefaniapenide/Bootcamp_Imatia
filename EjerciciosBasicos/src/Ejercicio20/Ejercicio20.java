package Ejercicio20;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Ejercicio14.Personas;

public class Ejercicio20 {

	public static void main(String[] args) {

		// Ejercicio 20
		System.out.println("\nEjercicio 20");
		List<Personas> personas = new ArrayList<Personas>();
		Personas p1 = new Personas("11111111", "adssad", "asdasd", LocalDate.now(), 78);
		Personas p2 = new Personas("22222222", "adssdfdssad", "asduikyuasd", LocalDate.now(), 50);
		Personas p3 = new Personas("33333333", "adsxcvdsad", "asdattysd", LocalDate.now(), 60);
		Personas p4 = new Personas("4444444", "adsssdfad", "asdtyuyuasd", LocalDate.now(), 55);
		Personas p5 = new Personas("555555", "adssuyiad", "asdtyuasd", LocalDate.now(), 89);

		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		personas.add(p5);

		for (Personas p : personas) {
			System.out.println(p);
		}

	}

}
