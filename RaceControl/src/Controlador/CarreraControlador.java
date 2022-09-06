package Controlador;

import java.util.ArrayList;

import POJO.Carrera;
import POJO.Coche;
import POJO.Eliminacion;
import POJO.Estandar;
import POJO.Garaje;
import POJO.Torneo;

public class CarreraControlador {// No lo estoy usando
	
	//TODOS LAS CARRERAS QUE SE REGISTREN ESTRARÁN AQUI
	public static ArrayList<Carrera> carreras = new ArrayList<Carrera>();

	
	public static void crearCarrerasEliminacionTorneo(Torneo torneo) {

		Carrera eliminacion = null;
		for (int i = 1; i <= torneo.getNumeroCarreras(); i++) {
			String nombre = String.valueOf(i);
			eliminacion = new Eliminacion(nombre);
			eliminacion.setPegatinaTorneo(torneo.getNombre());
			
			// Si en un torneo participan varios garajes
			if (torneo.getGarajes().size() > 1) {
				for (Garaje garaje : torneo.getGarajes()) {
					Coche coche = garaje.getCoches().get(0 + (int) (Math.random() * garaje.getCoches().size()));
					eliminacion.getCoches().add(coche);
				}
			
			// Si en un torneo sólo participa un garaje
			} else if (torneo.getGarajes().size() == 1) {
				Garaje garaje = torneo.getGarajes().get(0);
				for (Coche coche : garaje.getCoches()) {
					eliminacion.getCoches().add(coche);
				}
			}
			
			torneo.getCarreras().add(eliminacion);
			carreras.add(eliminacion);
		}

	}

	public static void crearCarrerasEstandarTorneo(Torneo torneo) {

		for (int i = 1; i <= torneo.getNumeroCarreras(); i++) {
			String nombre = String.valueOf(i);

			Carrera estandar = new Estandar(nombre);
			estandar.setPegatinaTorneo(torneo.getNombre());
			
			// Si en un torneo participan varios garajes
			if (torneo.getGarajes().size() > 1) {
				for (Garaje garaje : torneo.getGarajes()) {
					Coche coche = garaje.getCoches().get(0 + (int) (Math.random() * garaje.getCoches().size()));
					estandar.getCoches().add(coche);
				}
			
		    // Si en un torneo sólo participa un garaje
			} else if (torneo.getGarajes().size() == 1) {
				Garaje garaje = torneo.getGarajes().get(0);
				for (Coche coche : garaje.getCoches()) {
					estandar.getCoches().add(coche);
				}
			}

			torneo.getCarreras().add(estandar);
			carreras.add(estandar);
		}

	}

	public static boolean carreraNoRealizada(Torneo torneo, Carrera carrera) {
		boolean noRealizada = false;
		for (Torneo t : TorneosControlador.torneos) {
			if (t.equals(torneo)) {
				for (Carrera c : t.getCarreras()) {
					if (c.equals(carrera)) {
						if (c.getPodio().isEmpty()) {
							noRealizada = true;
						}
					}
				}
			}
		}
		return noRealizada;
	}

	public static Carrera getCarrera(String nombreCarrera, Torneo torneo) {

		Carrera carrera = null;

		for (Torneo t : TorneosControlador.torneos) {
			if (t.equals(torneo)) {
				for (Carrera c : t.getCarreras()) {
					if (c.getNombre().equals(nombreCarrera)) {
						carrera = c;
					}
				}
			}
		}
		return carrera;
	}
	
}




