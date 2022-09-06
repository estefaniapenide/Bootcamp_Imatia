package ejercicio52;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio52 {

	public static void main(String[] args) {
		
		Stream<String> nombresPersonas = Stream.of("JUAN","LUCÍA","PEDRO","PABLO","MARÍA","ANTONIO");
		 nombresPersonas.map(s->s.substring(0,1)+s.substring(1).toLowerCase()).peek(System.out::println).collect(Collectors.toList());
		
	}

}
