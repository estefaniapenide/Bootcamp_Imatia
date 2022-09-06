package ejercicio57;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Ejercicio57 {

	public static void main(String[] args) {
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(2);
		numeros.add(3);
		numeros.add(2);
		numeros.add(4);
		numeros.add(6);
		numeros.add(8);
		numeros.add(1);
		
		int total = numeros.stream().mapToInt(Integer::intValue).sum();
		
//		numeros.stream().reduce(0,Integer::sum);
//		numeros.stream().reduce(Integer::sum).ifPresent(System.out::println);
		
		System.out.println(total);
		
		IntStream is = IntStream.range(1, 51);
		
		IntStream resultado = is.map(s-> (s + (int) (Math.random() * (50))));
		
		IntSummaryStatistics estadisticas = resultado.summaryStatistics();
		
		System.out.println(estadisticas.getMax());
		System.out.println(estadisticas.getMin());
		System.out.println(estadisticas.getCount());
		System.out.println(estadisticas.getAverage());
		
	
		

	}

}
