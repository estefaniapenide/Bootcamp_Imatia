package ejercicio55;

import java.util.stream.Stream;

public class Ejercicio55 {

	public static void main(String[] args) {

		Stream<String> nombresPersonas1 = Stream.of("JUAN", "LUCÍA", "JORGE", "PEDRO", "PABLO", "MARÍA", "ANTONIO",
				"JUANA");
		boolean algunoEmpiezaPorL = nombresPersonas1.map(s -> s.substring(0, 1) + s.substring(1).toLowerCase())
				.anyMatch(s -> s.charAt(0) == 'L');

		Stream<String> nombresPersonas2 = Stream.of("JUAN", "LUCÍA", "JORGE", "PEDRO", "PABLO", "MARÍA", "ANTONIO",
				"JUANA");
		boolean ningunoTerminaEnO = nombresPersonas2.map(s -> s.substring(0, 1) + s.substring(1).toLowerCase())
				.noneMatch(s -> s.charAt(s.length() - 1) == 'o');

		Stream<String> nombresPersonas3 = Stream.of("LUCÍA", "JORGE", "PEDRO", "PABLO", "MARÍA", "JUANA");
		boolean todosTienen5Letras = nombresPersonas3.map(s -> s.substring(0, 1) + s.substring(1).toLowerCase())
				.allMatch(s -> s.length() == 5);

		
		System.out.println("Alguno empieza por 'L': " + algunoEmpiezaPorL);
		System.out.println("Ninguno termina en 'o': " + ningunoTerminaEnO);
		System.out.println("Todos tienen 5 letras: " + todosTienen5Letras);

	}

}
