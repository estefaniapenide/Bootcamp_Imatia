package ejercicio49;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Ejercicio49 {

	public static void main(String[] args) {
		
		Predicate<Integer> divisible2 = numero -> numero%2 == 0;
		
		BiPredicate<String, String> cadenasIguales = (cadena1, cadena2) -> {
			boolean a=false;
			if(cadena1.compareToIgnoreCase(cadena2)==0) {
				a=true;
			}
			return a;
		};
		
		BiPredicate<String, String> cadenasIguales2 = (cadena1, cadena2) -> cadena1.compareToIgnoreCase(cadena2)==0;	
		
		System.out.println("5 "+divisible2.test(5));
		System.out.println("6 "+divisible2.test(6));
		
		System.out.println(cadenasIguales.test("hola", "HOLa"));
		System.out.println(cadenasIguales.test("aaaa", "eeee"));

	}

}
