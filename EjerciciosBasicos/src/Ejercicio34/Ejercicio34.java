package Ejercicio34;

import java.io.File;

import Ejercicio30.Ficheros;

public class Ejercicio34 {

	public static void main(String[] args) {
		
		File ficheroNoExiste = new File("fichero34.txt");
		Ficheros.borrarFichero(ficheroNoExiste);
		
		
		File ficheroExiste = new File("fichero33.txt");//Si se ejecutó antes el ejercicio33
		Ficheros.borrarFichero(ficheroExiste);

	}

}
