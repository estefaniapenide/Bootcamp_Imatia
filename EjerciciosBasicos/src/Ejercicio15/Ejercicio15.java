package Ejercicio15;

import java.time.LocalDate;

public class Ejercicio15 {

	public static void main(String[] args) {
		
		Mercancia m = new Mercancia(1,"Cosas","Juan","AA","B","7-izq",70);
		MercanciaPerecedera mp = new MercanciaPerecedera(2,"Cosas de comer","Antonio","CC","W","10-izq",50, LocalDate.now());
		
		System.out.println(m);
		System.out.println(mp);

	}

}
