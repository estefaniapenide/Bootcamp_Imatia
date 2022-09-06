package ejercicio50;

import java.util.function.BiConsumer;

import ejercicio46.ObjetoDePrueba;

public class Principal {

	public static void main(String[] args) {

		Arithmetic<Double, Double, Double> suma = (num1, num2) -> (num1 + num2);
		Arithmetic<Double, Double, Double> resta = (num1, num2) -> (num1 - num2);
		Arithmetic<Double, Double, Double> multiplicacion = (num1, num2) -> (num1 * num2);
		Arithmetic<Double, Double, Double> division = (num1, num2) -> (num1 / num2);

		BiConsumer<Double, Double> sumaBiConsumer = (num1, num2) -> {
			System.out.println(num1 + num2);
		};

		BiConsumer<Double, Double> restaBiConsumer = (num1, num2) -> {
			System.out.println(num1 - num2);
		};

		BiConsumer<Double, Double> multiplicacionBiConsumer = (num1, num2) -> {
			System.out.println(num1 * num2);
		};

		BiConsumer<Double, Double> divisionBiConsumer = (num1, num2) -> {
			System.out.println(num1 / num2);
		};
		

		Calculadora s = new Calculadora(12, 3, suma, sumaBiConsumer);
		double solucion = s.operarConArithmetic();
		System.out.println("Suma Arithmetic => " + solucion);
		System.out.print("Suma BiConsumer => ");
		s.operarConBiConsumer();
		
		System.out.println();

		Calculadora r = new Calculadora(12, 3, resta,restaBiConsumer);
		solucion = r.operarConArithmetic();
		System.out.println("Resta Arithmetic => " + solucion);
		System.out.print("Resta BiConsumer => ");
		r.operarConBiConsumer();
		
		System.out.println();

		Calculadora m = new Calculadora(12, 3, multiplicacion,multiplicacionBiConsumer);
		solucion = m.operarConArithmetic();
		System.out.println("Multiplicación Arithmetic => " + solucion);
		System.out.print("Multiplicación BiConsumer => ");
		m.operarConBiConsumer();
		
		System.out.println();

		Calculadora d = new Calculadora(12, 3, division,divisionBiConsumer);
		solucion = d.operarConArithmetic();
		System.out.println("División Arithmetic => " + solucion);
		System.out.print("División BiConsumer => ");
		d.operarConBiConsumer();

	}

}
