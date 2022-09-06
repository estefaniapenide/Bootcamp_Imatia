package ejercicio59;

import java.util.ArrayList;

public class Ejercicio59 {

	public static void main(String[] args) {
		
		ArrayList<String> nombresPersonas = new ArrayList<String>();
		nombresPersonas.add("juan");
		nombresPersonas.add("lucía");
		nombresPersonas.add("pedro");
		nombresPersonas.add("pablo");
		nombresPersonas.add("maría");
		nombresPersonas.add("antonio");
		
		nombresPersonas.stream().flatMap(n->{
			if(n.s)
		})

	}

}
