package ejercicio47;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Ejercicio47 {

	public static void main(String[] args) {
		
		
		BiConsumer<PersonaJava8, String> cambiarNombre = (personaJava8, nombre) ->{
			personaJava8.setNombre(nombre);
		};
		
		BiConsumer<PersonaJava8, String> cambiarNombre2 = PersonaJava8::setNombre;
		
		Consumer<String> mostrarString = cadena -> {System.out.println(cadena);};
		
		Supplier<Integer> numeroAzar = () ->{
			int i = 1 + (int)(Math.random() * 200);
			return i;
		};
		
		Supplier<Integer> numeroAzar2 = () -> (1 + (int)(Math.random() * 200));
	
		
		Supplier<PersonaJava8> crearPersona = () -> new PersonaJava8();
		Supplier<PersonaJava8> crearPersona2 = 	PersonaJava8::new;
		
		
		//****************************************************************************
		
		PersonaJava8 persona = new PersonaJava8("Paula","González López");
		cambiarNombre.accept(persona, "Patricia");
		System.out.println("NUEVO NOMBRE: "+persona.getNombre());
		
		ArrayList<String> cadenas = new ArrayList<String>();
		for(int i=1; i<=10; i++) {
			cadenas.add("CADENA "+i);
		}
		for(String cadena: cadenas) {
		mostrarString.accept(cadena);
		}
		
		System.out.println(numeroAzar2.get());
		
		cambiarNombre.accept(crearPersona.get(),"Juan");
		

	}

}
