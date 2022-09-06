package ejercicio60;

import java.util.stream.Stream;

public class Ejercicio60 {

	public static void main(String[] args) {
		
		Stream.generate(()-> (1 + (int) (Math.random() * 100))).limit(25).forEach(s -> System.out::println
				try{
					Thread.sleep(250);
				}catch(InterruptedException e) {});

	}

}
