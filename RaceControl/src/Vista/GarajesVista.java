package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Cadenas.Cadenas;
import ControlData.ControlData;
import Controlador.CochesControlador;
import Controlador.GarajesControlador;
import POJO.Coche;
import POJO.Garaje;

public class GarajesVista {
	
	public static void opcionesGarajes(Scanner input) {

		byte op = 0;
		do {
			Cadenas.menuGarajes();
			op = ControlData.leerByte(input);

			switch (op) {
			case 1:
				nuevoGaraje(input);
				break;
			case 2:
				consultarGarajes(input);
				break;
			case 0:
				Cadenas.vueltaMenu();
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}
		} while (op != 0);
	}
	
	public static void nuevoGaraje(Scanner input) {
		
		Cadenas.nombreGaraje();
		String nombreGaraje = ControlData.leerString(input);
		
		if(!GarajesControlador.existeNombreGaraje(nombreGaraje)) {
			
			GarajesControlador.crearGaraje(nombreGaraje);
			menuAddCoches(input,nombreGaraje);
			
		}else {
			Cadenas.ExisteGaraje();
		}
	}
	
	private static void menuAddCoches(Scanner input,String nombreGaraje) {

		byte op = 2;
		do {
			Cadenas.menuAddCoches();
			op = ControlData.leerByte(input);
			switch (op) {
			case 1:
				addCoche(input,nombreGaraje);
				break;
			case 2:
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}

		} while (op != 2);

	}
	
	private static void addCoche(Scanner input,String nombreGaraje) {
		
		Cadenas.nuevoCoche();	
		
		Cadenas.marca();
		String marca = ControlData.leerString(input);
		Cadenas.modelo();
		String modelo = ControlData.leerString(input);
		
		Coche coche = new Coche(marca,modelo,nombreGaraje);
		
		if(!CochesControlador.existeCoche(coche)) {
			CochesControlador.crearCoche(marca,modelo,nombreGaraje);
			System.out.println("COCHE AÑADIDO");
			
		}else {
			System.out.println("EL COCHE YA EXISTE");
		}
	}
	
	private static void consultarGarajes(Scanner input) {
		System.out.println("\tGARAJES\n");
		for(Garaje garaje:GarajesControlador.garajes) {
			System.out.println("NOMBRE: "+garaje.getNombre()+", NÚMERO DE COCHES: "+garaje.getCoches().size());
		}
		System.out.println("\nNOMBRE DEL GARAJE (VER MÁS DATOS DEL GARAJE):");
		String nombre = ControlData.leerString(input);
		//Comprobar antes si existe o no pra que no devuelva null
		Garaje garaje = GarajesControlador.getGaraje(nombre);
		
		System.out.println(garaje);
	}

}
