package Ejercicio30;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import Ejercicio31.ExcepcionPropia;

public class Ejercicio30 {

	public static void main(String[] args) {

		File fichero = new File("fichero30NoExiste.txt");
		Ficheros.leerFichero(fichero);

		File fichero2 = new File("ficheroEscrito31.txt");

		try {

			fichero2.createNewFile();
			
			//Ficheros.escribirFichero(fichero2, "");
			Ficheros.escribirFichero(fichero2, "Holaaaa\nA ver qué tal va esto");
			//Ficheros.escribirFichero(fichero2, "Holaaaa\rA ver qué tal va esto");
			Ficheros.leerFichero(fichero2);

		} catch (ExcepcionPropia e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
