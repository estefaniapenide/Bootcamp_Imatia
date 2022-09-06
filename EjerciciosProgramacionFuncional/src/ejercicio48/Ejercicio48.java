package ejercicio48;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ejercicio48 {

	public static void main(String[] args) {

		Function<Integer, Integer> aleatorio = valorMaximo -> (1 + (int) (Math.random() * valorMaximo));

		Function<String, String> convertirEnMayusculas = cadena -> cadena.toUpperCase();
		Function<String, String> convertirEnMayusculas2 = String::toUpperCase;

		BiFunction<Integer, Integer, Integer> numAzar = (num1, num2) -> {
			int solucion = 0;
			switch (num1.compareTo(num2)) {
			case 0:
				solucion = -1;
				break;
			case -1:
				solucion = (num1 + (int) (Math.random() * (num2-num1)));
				break;
			case 1:
				solucion = (num2 + (int) (Math.random() * (num1-num2)));
				break;
			}
			return solucion;
		};
		

		System.out.println(aleatorio.apply(20));
		System.out.println(convertirEnMayusculas.apply("holaaaa"));
		System.out.println(convertirEnMayusculas2.apply("que tal"));

		System.out.println(numAzar.apply(2, 10));
		System.out.println(numAzar.apply(10, 2));
		System.out.println(numAzar.apply(10, 10));

	}

}
