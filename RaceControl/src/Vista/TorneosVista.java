package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Cadenas.Cadenas;
import ControlData.ControlData;
import Controlador.CarreraControlador;
import Controlador.CochesControlador;
import Controlador.GarajesControlador;
import Controlador.TorneosControlador;
import POJO.Carrera;
import POJO.Coche;
import POJO.Eliminacion;
import POJO.Estandar;
import POJO.Garaje;
import POJO.Torneo;

public class TorneosVista {

	public static void opcionesTorneos(Scanner input) {

		byte op = 0;
		do {
			Cadenas.menuTorneos();
			op = ControlData.leerByte(input);

			switch (op) {
			case 1:
				nuevoTorneo(input);
				break;
			case 2:
				empezarReanudarTorneo(input);
				break;
			case 3:
				consultarTroneo(input);
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

	private static void nuevoTorneo(Scanner input) {

		ArrayList<Garaje> garajesTorneo = new ArrayList<Garaje>();

		Cadenas.nombreTorneo();
		String nombreTorneo = ControlData.leerString(input).toUpperCase();

		if (!TorneosControlador.existeNombreTorneo(nombreTorneo)) {
			Cadenas.garajesTorneo(nombreTorneo);
			menuAddGarajes(input, garajesTorneo);

			if (!garajesTorneo.isEmpty()) {
				Cadenas.numCarreras();
				int num = ControlData.leerInt(input);

				Torneo torneo = TorneosControlador.crearTorneo(nombreTorneo, garajesTorneo, num);
				Cadenas.torneoCreado();

				tipoCarreras(input, torneo);

				TorneosControlador.torneos.add(torneo);

			}
		} else {
			Cadenas.existeTorneo();
		}

	}

	private static void menuAddGarajes(Scanner input, ArrayList<Garaje> garajesTorneo) {

		byte op;
		do {
			Cadenas.menuAddGaraje();
			op = ControlData.leerByte(input);
			switch (op) {
			case 1:
				addGaraje(input, garajesTorneo);
				break;
			case 2:
				if (garajesTorneo.isEmpty()) {
					Cadenas.torneoNoCreado();
				}
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}

		} while (op != 2);

	}

	private static void addGaraje(Scanner input, ArrayList<Garaje> garajesTorneo) {

		Cadenas.nombreGaraje();
		String nombreGaraje = ControlData.leerString(input);

		boolean parteDelTorneo = false;
		for (Garaje garaje : garajesTorneo) {
			if (garaje.getNombre().equals(nombreGaraje)) {
				parteDelTorneo = true;
			}
		}

		if (GarajesControlador.existeNombreGaraje(nombreGaraje)) {
			if (!parteDelTorneo) {
				garajesTorneo.add(GarajesControlador.getGaraje(nombreGaraje));
				Cadenas.garajeAdded();
			} else {
				Cadenas.garajeYaTorneo();
			}

		} else {
			Cadenas.imposibleAddGaraje();
			Cadenas.noExisteGaraje();
		}

	}
	
	private static void mostrarTorneoYCarreras(Torneo torneo) {
		System.out.println(torneo);
		System.out.println("\n\tCARRERAS");
		for (Carrera carrera : torneo.getCarreras()) {
			System.out.print(carrera);
		}
	}

	private static void tipoCarreras(Scanner input, Torneo torneo) {
		byte op = 1;
		do {
			Cadenas.menuTipoCarreras();
			op = ControlData.leerByte(input);
			switch (op) {
			case 1:
				CarreraControlador.crearCarrerasEstandarTorneo(torneo);
				Cadenas.carrerasAdded();
				break;
			case 2:
				CarreraControlador.crearCarrerasEliminacionTorneo(torneo);
				Cadenas.carrerasAdded();
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}
		} while (op != 1 && op != 2);

	}

	private static void empezarReanudarTorneo(Scanner input) {

		Cadenas.nombreTorneo();
		String nombreTorneo = ControlData.leerString(input).toUpperCase();

		if (TorneosControlador.existeNombreTorneo(nombreTorneo)) {
			Torneo torneo = TorneosControlador.getTorneo(nombreTorneo);
			
			mostrarTorneoYCarreras(torneo);
			
			System.out.println("\n\n\tINCIAR CARRERA");
			System.out.println("\nNOMBRE CARRERA A CELEBRAR:");
			String nombreCarrera = ControlData.leerString(input);

			Carrera carrera = CarreraControlador.getCarrera(nombreCarrera, torneo);

			if (CarreraControlador.carreraNoRealizada(torneo, carrera)) {
				
				if (carrera instanceof Estandar) {
					((Estandar) carrera).correr();
					torneo.calcularPuntuacionCarrera(carrera);

				} else if (carrera instanceof Eliminacion) {
					((Eliminacion) carrera).correr();
					torneo.calcularPuntuacionCarrera(carrera);
				}

				mostrarTorneoYCarreras(torneo);

				// Poniendo a cero todos los coches para que estén listos para la siguiente carrera		
					for (Coche coche : CochesControlador.coches) {
						coche.setDistanciaRecorrida(0);
						coche.setVelocidad(0);
					}

			} else {
				System.out.println("LA CARRERA " + nombreCarrera + " YA HA SIDO CELEBRADA O NO EXISTE");
			}

		}else {
			System.out.println("EL TORNEO NO EXISTE");
		}

	}

	public static void consultarTroneo(Scanner input) {

		Cadenas.nombreTorneo();
		String nombreTorneo = ControlData.leerString(input).toUpperCase();

		if (TorneosControlador.existeNombreTorneo(nombreTorneo)) {
			Torneo torneo = TorneosControlador.getTorneo(nombreTorneo);
			
			mostrarTorneoYCarreras(torneo);

		}else {
			System.out.println("EL TORNEO NO EXISTE");
		}
	}


}
