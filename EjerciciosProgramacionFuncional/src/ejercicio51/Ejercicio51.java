package ejercicio51;

import java.util.stream.Stream;

public class Ejercicio51 {

	public static void main(String[] args) {
		
		
		Stream<String> nombresPersonas = Stream.of("Juan","Luc�a","Pedro","Pablo","Mar�a","Antonio");
//		 nombresPersonas.forEach(p -> System.out.println(p));
		nombresPersonas.forEach(System.out::println);

	}

}
