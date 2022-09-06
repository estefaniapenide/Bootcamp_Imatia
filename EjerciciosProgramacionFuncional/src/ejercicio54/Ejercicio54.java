package ejercicio54;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio54 {

	public static void main(String[] args) {
		
		
		Stream<String> nombresPersonas = Stream.of("JUAN","LUCÍA","JORGE","PEDRO","PABLO","MARÍA","ANTONIO","JUANA");
		 nombresPersonas.map(s->s.substring(0,1)+s.substring(1).toLowerCase()).filter(s->s.charAt(0)=='J').forEach(System.out::println);

	}

}
