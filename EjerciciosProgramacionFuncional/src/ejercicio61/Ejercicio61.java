package ejercicio61;

public class Ejercicio61 {

	public static void main(String[] args) {
		
		Stream.generate(()-> (1 + (int) (Math.random() * 100))).parallel.limit(25).forEach(s -> System.out::println
				try{
					Thread.sleep(250);
				}catch(InterruptedException e) {});

	}

	}

}
