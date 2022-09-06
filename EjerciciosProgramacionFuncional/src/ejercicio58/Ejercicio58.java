package ejercicio58;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio58 {

	public static void main(String[] args) {
		
		ArrayList<String> nombresPersonas = new ArrayList<String>();
		nombresPersonas.add("juan");
		nombresPersonas.add("lucía");
		nombresPersonas.add("pedro");
		nombresPersonas.add("pablo");
		nombresPersonas.add("maría");
		nombresPersonas.add("antonio");
		
		IntStream longitudNombres= nombresPersonas.stream().mapToInt(String::length);
		
		IntSummaryStatistics estadisticasNombres = longitudNombres.summaryStatistics();
		
		System.out.println(estadisticasNombres.getMax());
		System.out.println(estadisticasNombres.getMin());
		System.out.println(estadisticasNombres.getSum());
		System.out.println(estadisticasNombres.getCount());
		System.out.println(estadisticasNombres.getAverage());
		
	}

		
		
		
		

	}


