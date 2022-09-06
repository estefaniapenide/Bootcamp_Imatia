package ejercicio53;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio53 {

	public static void main(String[] args) {
		
//		Stream<String> nombresPersonas = Stream.of("JUAN","LUCÍA","PEDRO","PABLO","MARÍA","ANTONIO");
//		 nombresPersonas.map(s->s.substring(0,1).toLowerCase()+s.substring(1)).peek(System.out::println)
//		 .map(s->s.substring(0,1)+s.substring(1).toLowerCase()).peek(System.out::println).collect(Collectors.toList());
		
		Stream<String> nombresPersonas = Stream.of("JUAN","LUCÍA","PEDRO","PABLO","MARÍA","ANTONIO");
		 nombresPersonas.map(s->s.substring(0,1).toLowerCase()+s.substring(1)).peek(System.out::println)
		 .map(s->s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase()).peek(System.out::println).sorted().toList();
	}

}
