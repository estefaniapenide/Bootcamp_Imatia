package Ejercicio30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import Ejercicio31.ExcepcionPropia;

public class Ficheros {

	public static void leerFichero(File fichero) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fichero, Charset.forName("UTF-8")));

			System.out.println("\nContenido del fichero " + fichero.getAbsolutePath() + ":");

			StringBuilder textoFichero = new StringBuilder();

			// Funciona
//			Reader lector = new FileReader(fichero, Charset.forName("UTF-8"));
//			char[] bufer = new char[1024];
//			while (lector.read(bufer) != -1) {
//				textoFichero.append(bufer);
//			}
//			lector.close();
//			System.out.println(textoFichero);

			// Funciona
			String linea="";
			while ((linea=br.readLine())!=null) {
				System.out.println(linea);
			}

			// Lee sólo la última línea
//            String linea="";
//			while ((linea=br.readLine())!=null) {
//				textoFichero.append(br.readLine());
//			}
//			 System.out.println(textoFichero);

			// No lee la primera letra de cada fila
//			while (br.read() != -1) {
//				System.out.println(br.readLine());
//			}
			
			// Lee caracteres sueltos
//			 while (br.read()!=-1) {
//			 System.out.print((char)br.read()); 
//			 }

		} catch (FileNotFoundException e) {
			System.out.println("\nNo se ha encontrado el fichero " + fichero.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void escribirFichero(File fichero, String contenido) throws ExcepcionPropia {

		if (contenido.equals("")) {
			throw new ExcepcionPropia("No se está escribiendo nada en el fichero");
		}

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(fichero, Charset.forName("UTF-8")));
			bw.write(contenido);

		} catch (FileNotFoundException e) {
			System.out.println("\nNo se ha encontrado el fichero " + fichero.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void borrarFichero(File fichero) {

		boolean borrado = fichero.delete();

		if (borrado) {
			System.out.println("El fichero ha sido borrado");
		} else {
			System.out.println("No ha sido posible borrar el fichero");
		}
	}

}
