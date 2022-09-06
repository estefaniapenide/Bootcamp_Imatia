package POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class Carrera{//Añadir a las carreras una etiqueta de torneos y cambiar el equals para que se identifiquen por su nombre y la etiqueta de torneo

	private String nombre;
	
	private String pegatinaTorneo;
	
	private HashMap<Integer, ArrayList<Coche>> podio = new HashMap<Integer, ArrayList<Coche>>();

	private ArrayList<Coche> primeros = new ArrayList<Coche>();
	private ArrayList<Coche> segundos = new ArrayList<Coche>();
	private ArrayList<Coche> terceros = new ArrayList<Coche>();
	
	
	private ArrayList<Coche> coches = new ArrayList<Coche>();
	
	
//	private ArrayList<Garaje> garajes = new ArrayList<Garaje>();
//	private Garaje garaje;


	public Carrera() {
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

	public String getPegatinaTorneo() {
		return pegatinaTorneo;
	}

	public void setPegatinaTorneo(String pegatinaTorneo) {
		this.pegatinaTorneo = pegatinaTorneo;
	}
	
	public HashMap<Integer, ArrayList<Coche>> getPodio() {
		return podio;
	}

	public void setPodio(HashMap<Integer, ArrayList<Coche>> podio) {
		this.podio = podio;
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}

	public ArrayList<Coche> getPrimeros() {
		return primeros;
	}

	public void setPrimeros(ArrayList<Coche> primeros) {
		this.primeros = primeros;
	}

	public ArrayList<Coche> getSegundos() {
		return segundos;
	}

	public void setSegundos(ArrayList<Coche> segundos) {
		this.segundos = segundos;
	}

	public ArrayList<Coche> getTerceros() {
		return terceros;
	}

	public void setTerceros(ArrayList<Coche> terceros) {
		this.terceros = terceros;
	}
	
	


	public void movimientoCoches() {
		for (int i = 0; i < getCoches().size(); i++) {
			getCoches().get(i).movimiento();// El coche cambia su velocidad y la distanciaRecorrida
		}
//		Collections.sort(getCoches());// Los coches se ordenan por distancia recorrida
	}



	public void buscarPrimeros() {

		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < getCoches().size(); i++) {
			if (getCoches().get(i).getDistanciaRecorrida() == getCoches().get(0).getDistanciaRecorrida()) {
				getPrimeros().add(getCoches().get(i));
				cont++;
			}
		}
		// Borro los coches que estén en primera posición
		while (cont > 0) {
			getCoches().remove(cont - 1);
			cont--;
		}

	}

	public void buscarSegundos() {

		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < getCoches().size(); i++) {
			if (getCoches().get(i).getDistanciaRecorrida() == getCoches().get(0).getDistanciaRecorrida()) {
				getSegundos().add(getCoches().get(i));
				cont++;
			}
		}
		// Borro los coches que estén en segunda posición
		while (cont > 0) {
			getCoches().remove(cont - 1);
			cont--;
		}

	}

	public void buscarTerceros() {

		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < getCoches().size(); i++) {
			if (getCoches().get(i).getDistanciaRecorrida() == getCoches().get(0).getDistanciaRecorrida()) {
				getTerceros().add(getCoches().get(i));
				cont++;
			}
		}
		// Borro los coches que estén en tercera posición
		while (cont > 0) {
			getCoches().remove(cont - 1);
			cont--;
		}

	}

	public void cochesPodio() {
		buscarPrimeros();
		this.podio.put(1, this.primeros);
		buscarSegundos();
		this.podio.put(2, this.segundos);
		buscarTerceros();
		this.podio.put(3, this.terceros);
	}



	@Override
	public String toString() {

		StringBuilder podio = new StringBuilder();

		if (this.podio.isEmpty()) {
			podio.append(": AÚN NO SE HA CELEBRADO LA CARRERA");
		} else {

			for (Map.Entry<Integer, ArrayList<Coche>> entry : this.podio.entrySet()) {
				int posicion = entry.getKey();
				ArrayList<Coche> coches = entry.getValue();
				podio.append("\n\tPOSICIÓN ");
				podio.append(posicion);
				for (Coche coche : coches) {
					podio.append("\nCOCHE");
					podio.append(coche);
				}
			}
		}

		String carrera = "\nCARRERA: " + this.nombre + "\nPODIO " + podio;
		return carrera;
	}

//	public ArrayList<Garaje> getGarajes() {
//		return garajes;
//	}
//
//	public void setGarajes(ArrayList<Garaje> garajes) {
//		this.garajes = garajes;
//	}
//
//	public Garaje getGaraje() {
//		return garaje;
//	}
//
//	public void setGaraje(Garaje garaje) {
//		this.garaje = garaje;
//	}
	
	
	public abstract JSONObject exportarCarrera();
	
	 @Override//Resolver lo de coches y ver si esto le afceta en algo
	    public boolean equals(Object object) {
		 if(object instanceof Carrera) {
			 return ((Carrera) object).getNombre().equals(nombre) && ((Carrera) object).getPegatinaTorneo().equals(pegatinaTorneo);
		 }
		 return super.equals(object);

	    }
	 
	 @Override
	 public int hashCode() {
		 return 1;
	 }

}
