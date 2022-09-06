package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		controlUsuario();
	}
	
	public static String recibirSaludar() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduzca un nombre:");
		String nombre = input.nextLine();
		
		String saludo="¡Hola "+nombre+"!";
		
		return saludo;
	}
	
	public static String errorUsuario() {
		String error="Usuario no encontrado";
		return error;
	}
	
	
	public static void controlUsuario() {
		
		final String USUARIO="ESTEFANIA";
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduzca un nombre de usuario:");
		String nombre = input.nextLine().toUpperCase();
		
		if(nombre.equals(USUARIO)) {
			System.out.println("BINEVENIDO/A "+nombre);
		}else {
			System.out.println(errorUsuario());
		}
		
	}

}
