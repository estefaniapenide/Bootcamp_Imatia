package Ejercicio33;

import java.io.File;
import java.io.IOException;

import Ejercicio30.Ficheros;
import Ejercicio31.ExcepcionPropia;

public class Ejercicio33 {

	public static void main(String[] args) {
		
		File fichero = new File("fichero33.txt");
		try {
		boolean crearFichero = fichero.createNewFile();
		
		Ficheros.escribirFichero(fichero, "Escribiendo cosas en el fichero 33");
		
		}catch(ExcepcionPropia e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
