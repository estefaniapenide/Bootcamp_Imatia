package ejercicio59;

import java.util.ArrayList;

public class Ejercicio59 {

	public static void main(String[] args) {
		
		ArrayList<String> nombresPersonas = new ArrayList<String>();
		nombresPersonas.add("juan");
		nombresPersonas.add("luc�a");
		nombresPersonas.add("pedro");
		nombresPersonas.add("pablo");
		nombresPersonas.add("mar�a");
		nombresPersonas.add("antonio");
		
		nombresPersonas.stream().flatMap(n->{
			if(n.s)
		})

	}

}
