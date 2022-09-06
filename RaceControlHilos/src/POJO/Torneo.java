package POJO;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Torneo {// Todos los garajes que participan en el torneo irán a todas las carreras. El
						// coche aleatorio de cada garaje se escoje en cada carrera

	private String nombre;

	private int numeroCarreras = 10;// Por defecto tendrá 10 carreras
	
	//private HashMap<Coche, Integer> puntuaciones = new HashMap<Coche, Integer>();
	
	private ArrayList<Puntuacion> puntuaciones = new  ArrayList<Puntuacion>();
	
	private ArrayList<Coche> ganadores = new  ArrayList<Coche>();//Acabar de planetar bien

	private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

	private ArrayList<Garaje> garajes = new ArrayList<Garaje>();// Estos garajes son los que podrán participar en las
																// carreras del torneo

	public Torneo() {
	}

	public Torneo(String nombre) {
		this.nombre = nombre;
	}
	
	public Torneo(String nombre,int numeroCarreras) {
		this.nombre = nombre;
		this.numeroCarreras = numeroCarreras;
	}

	public Torneo(String nombre, ArrayList<Garaje> garajes) {// Si no se indica serán 10 carreras
		this.nombre = nombre;
		this.garajes = garajes;
		//this.setCarreras();
	}

	public Torneo(String nombre, ArrayList<Garaje> garajes, int numeroCarreras) {// Si se indica el número de carreras
		this.nombre = nombre;
		this.numeroCarreras = numeroCarreras;
		this.garajes = garajes;
		//this.setCarreras();
	}

	public int getNumeroCarreras() {
		return numeroCarreras;
	}

	public void setNumeroCarreras(int numeroCarreras) {
		this.numeroCarreras = numeroCarreras;
	}
	
	public ArrayList<Coche> getGanadores() {
		return ganadores;
	}

	public ArrayList<Puntuacion> getPuntuaciones() {
		return puntuaciones;
	}

	public void setPuntuaciones(ArrayList<Puntuacion> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}

	public void setCarreras(ArrayList<Carrera> carreras) {
		this.carreras = carreras;
	}

//	public HashMap<Coche, Integer> getPuntuaciones() {
//		return puntuaciones;
//	}

	public void calcularPuntuacionCarrera(Carrera carrera) {

		int primero = 300;
		int segundo = 200;
		int tercero = 100;

		addPuntos(carrera, 1, primero);
		addPuntos(carrera, 2, segundo);
		addPuntos(carrera, 3, tercero);

	}
	
	private void addPuntos(Carrera carrera, int puesto, int premio) {

		ArrayList<Coche> listaCochesPuesto = carrera.getPodio().get(puesto);

		for (Coche coche : listaCochesPuesto) {
			boolean yaTienePuntos = false;
			for (Puntuacion p: this.puntuaciones) {
				if (coche.equals(p.getCoche())) {
					yaTienePuntos = true;
					int puntosTotales = p.getPuntos()+(premio / listaCochesPuesto.size());
					p.setPuntos(puntosTotales);
				}
			}

			if (!yaTienePuntos) {
				
				int puntos=premio / listaCochesPuesto.size();
				Puntuacion p = new Puntuacion(puntos,coche);
				this.puntuaciones.add(p);
			} 

		}
	}

//	private void addPuntos(Carrera carrera, int puesto, int premio) {
//
//		ArrayList<Coche> listaCochesPuesto = carrera.getPodio().get(puesto);
//
//		for (Coche coche : listaCochesPuesto) {
//			boolean yaTienePuntos = false;
//			for (Coche c : this.puntuaciones.keySet()) {
//				if (coche.equals(c)) {
//					yaTienePuntos = true;
//				}
//			}
//
//			if (yaTienePuntos) {
//				int puntos = this.puntuaciones.get(coche);
//				puntos += (premio / listaCochesPuesto.size());
//				this.puntuaciones.put(coche, puntos);// El nuevo reemplaza al viejo en el HashMap si tienen la misma
//														// clave
//			} else {
//				this.puntuaciones.put(coche, premio / listaCochesPuesto.size());
//			}
//
//		}
//	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Garaje> getGarajes() {
		return garajes;
	}

	public void setGarajes(ArrayList<Garaje> garajes) {
		this.garajes = garajes;
	}

//	public void setCarreras() {// Las carreras las creo estandar o de eliminación de forma
//								// aleatoria??//Pregunto al usuario y no lo hago automático??
//
//		// int numEstandar = (int) (Math.random() * (this.numeroCarreras - 0 +
//		// this.numeroCarreras) + 0);
//		// int numEliminacion = this.numeroCarreras - numEstandar;
//		int numEstandar = this.numeroCarreras;
//
//		Carrera carreraEstandar = null;
//		for (int i = 0; i < numEstandar; i++) {
//			String nombre = String.valueOf(i + 1);
//			carreraEstandar = new Estandar(nombre);
//
//			if (this.getGarajes().size() > 1) {// Si en un torneo participan varios garajes
//				for (Garaje garaje : this.getGarajes()) {
//					Coche coche = garaje.getCoches().get(0 + (int) (Math.random() * garaje.getCoches().size()));
//					carreraEstandar.getCoches().add(coche);
//				}
//
//			} else if (this.getGarajes().size() == 1) {// Si en un torneo sólo participa un garaje
//				Garaje garaje = this.getGarajes().get(0);// Ver esto para el propio garaje de la carrera
//				for (Coche coche : garaje.getCoches()) {//
//					carreraEstandar.getCoches().add(coche);
//				}
//			}
//
//			carreras.add(carreraEstandar);
//		}
//
////		Carrera carreraEliminacion=null;
////		for (int i = 0; i < numEliminacion; i++) {
////			String nombre = String.valueOf(i + 1);
////			carreraEliminacion = new Eliminacion(nombre);
////			
////			if (this.getGarajes().size() > 1) {// Si en un torneo participan varios garajes
////				for (Garaje garaje : this.getGarajes()) {
////					Coche coche = garaje.getCoches().get(0 + (int) (Math.random() * garaje.getCoches().size()));
////					carreraEliminacion.getCoches().add(coche);
////				}
////
////			} else if (this.getGarajes().size() == 1) {// Si en un torneo sólo participa un garaje
////				Garaje garaje= this.getGarajes().get(0);//Ver esto para el propio garaje de la carrera
////				for (Coche coche : garaje.getCoches()) {//
////					carreraEliminacion.getCoches().add(coche);
////				}
////			}
////			carreras.add(carreraEliminacion);
////		}
//
//	}

	public ArrayList<Carrera> getCarreras() {
		return carreras;
	}

	@Override
	public String toString() {

		String garajes = "";
		for (Garaje garaje : this.garajes) {
			garajes += garaje.getNombre() + "   ";
		}

		StringBuilder clasificacion = new StringBuilder();

		if (this.puntuaciones.isEmpty()) {
			clasificacion.append(": EL TORNEO AÚN NO HA COMENZADO");
		} else {
			Collections.sort(this.puntuaciones);
			for(Puntuacion p:this.puntuaciones) {
				clasificacion.append("\n\nPUNTOS:");
				clasificacion.append(p.getPuntos());
				clasificacion.append("\nCOCHE:");
				clasificacion.append("\n\tMARCA: "+p.getCoche().getMarca());
				clasificacion.append("\n\tMODELO: "+p.getCoche().getModelo());
				clasificacion.append("\n\tGARAJE: "+p.getCoche().getPegatinaGaraje());
				
			}

		}

		String torneo = "\nTORNEO: " + this.nombre + "\nGARAJES: " + garajes + "\nCLASIFICACIÓN" + clasificacion;

		return torneo;

	}
	
	public JSONObject exportarTorneosJugados() {
		JSONObject obj = new JSONObject();
		obj.put("nombre",this.nombre);
		obj.put("numeroCarreras",this.numeroCarreras);

		
		JSONArray listaPuntuaciones = new JSONArray();
		for(Puntuacion puntuacion: this.puntuaciones) {
			listaPuntuaciones.add(puntuacion.exportarPuntuacion());
		}
		obj.put("puntuaciones", listaPuntuaciones);
		
		JSONArray listaCarreras = new JSONArray();
		for(Carrera  carrera: this.carreras) {
			listaCarreras.add(carrera.exportarCarrera());
		}
		obj.put("carreras", listaCarreras);
		
		JSONArray listaGarajes = new JSONArray();
		for(Garaje garaje: this.garajes) {
			listaGarajes.add(garaje.exportarGarajeConCoches());
		}
		obj.put("garajes", listaGarajes);
		
		return obj;
		
	}
	
	 @Override//Resolver lo de coches y ver si esto le afceta en algo
	    public boolean equals(Object object) {
		 if(object instanceof Torneo) {
			 return ((Torneo) object).getNombre().equals(nombre);
		 }
		 return super.equals(object);

	    }
	 
	 @Override
	 public int hashCode() {
		 return 1;
	 }

}
