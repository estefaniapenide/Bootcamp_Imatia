package ejercicio46;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Ejercicio46 {

	public static void main(String[] args) {
		
		Consumer<String> consumer1 = (cadena) ->{
			System.out.println(cadena);
		};
		
		Consumer<ObjetoDePrueba> consumer2 = objetoDePrueba -> System.out.println(objetoDePrueba);
		
		BiConsumer<ObjetoDePrueba,String> biconsumer1 = (objetoDePrueba,cadena) ->{
			System.out.println(objetoDePrueba);
			System.out.println(cadena);
		};
		
		consumer1.accept("Holaaaaa");
		consumer2.accept(new ObjetoDePrueba(1,"Objeto de prueba",LocalDate.now()));
		
		biconsumer1.accept(new ObjetoDePrueba(2,"Objeto de prueba para biconsumer",LocalDate.now()), "Adiós");

	}

}
