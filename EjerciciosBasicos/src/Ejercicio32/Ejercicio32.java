package Ejercicio32;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import Ejercicio30.Ficheros;

public class Ejercicio32 {

	public static void main(String[] args) {

		File fichero = new File("fichero32.txt");

		Ficheros.leerFichero(fichero);

	}

}
