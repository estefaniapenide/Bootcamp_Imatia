package POO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public abstract class Carrera {

	private String nombre;
	private ArrayList<Coche> coches = new ArrayList<Coche>();// El orden del arrayList determinará en qué psosión está
																// cada coche

	private ArrayList<Garaje> garajes = new ArrayList<Garaje>();
	private Garaje garaje;

	private HashMap<Coche, Integer> podio = new HashMap<Coche, Integer>();

	private Torneo torneo;

	public Carrera() {

	}

	public Carrera(String nombre, Torneo torneo) {//No me funciona el constructor!!!
		this.nombre = nombre;
		this.torneo = torneo;
		
		if (this.torneo.getGarajes().size() > 1) {// Si en un torneo participan varios garajes
			for (Garaje garaje : this.torneo.getGarajes()) {
				Coche coche = garaje.getCoches().get(0 + (int) (Math.random() * garaje.getCoches().size()));
				this.coches.add(coche);
			}
			
		} else if (this.torneo.getGarajes().size() == 1) {// Si en un torneo sólo participa un garaje
			this.garaje = torneo.getGarajes().get(0);
			for (Coche coche : garaje.getCoches()) {
				this.coches.add(coche);
			}
		}

	}

	public Carrera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}


	public HashMap<Coche, Integer> getPodio() {
		return podio;
	}

	public void setPodio(HashMap<Coche, Integer> podio) {
		this.podio = podio;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

}
