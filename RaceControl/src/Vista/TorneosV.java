package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Cadenas.Cadenas;
import ControlData.ControlData;
import POO.Torneo;
import Controlador.TorneosC;

public class TorneosV {

	public static void opcionesTorneos() {

		Scanner input = new Scanner(System.in);

		byte op = 0;
		do {
			Cadenas.menuTorneos();
			op = ControlData.leerByte(input);

			switch (op) {
			case 1:
				nuevoTorneo(input);
				break;
			case 2:
				break;
			case 3:
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

	public static void nuevoTorneo(Scanner input) {

		Cadenas.nombreTorneo();
		String nombreTorneo = ControlData.leerString(input).toUpperCase();
		if (!TorneosC.existeNombreTorneo(nombreTorneo)) {
			Cadenas.garajesTorneo(nombreTorneo);
			addGarajes(input);

		} else {
			Cadenas.existeTorneo();
		}

	}
	
	private static void addGarajes(Scanner input) {
		byte op = 2;
		do {
			Cadenas.menuAddGaraje();
			op = ControlData.leerByte(input);
			switch (op) {
			case 1:
				// Añadir garaje
			case 2:
				//Nada. Se sale.
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}

		} while (op != 1 && op != 2);
		
	}

	private static void consultarTorneos() {
		// Quizá mostrar info sobre los que están finalizados, los que no etc..
		TorneosC.verTorneos();
	}

}
