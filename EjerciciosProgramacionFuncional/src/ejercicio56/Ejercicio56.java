package ejercicio56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Ejercicio56 {

	public static void main(String[] args) {
		
		ArrayList<String> nombresPersonas = new ArrayList<String>();
		nombresPersonas.add("juan");
		nombresPersonas.add("lucía");
		nombresPersonas.add("pedro");
		nombresPersonas.add("pablo");
		nombresPersonas.add("maría");
		nombresPersonas.add("antonio");
		nombresPersonas.add("pedro");
		nombresPersonas.add("pablo");
		
		nombresPersonas.stream().distinct().map(s->s.substring(0,1).toUpperCase()+s.substring(1)).forEach(System.out::println);
		
		BinaryOperator<String>formatear= (acum,cadena)-> acum+cadena+",";
		

		BinaryOperator<String>formatear2= (acum,cadena)-> acum+","+cadena;
		
//		nombresPersonas.stream().distinct().map(s->s.substring(0,1).toUpperCase()+s.substring(1)).reduce("",formatear);
		
		nombresPersonas.stream().distinct().map(s->s.substring(0,1).toUpperCase()+s.substring(1)).reduce(formatear2).ifPresent(System.out::println);
		

	}

}
