package POJO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Estandar extends Carrera implements Runnable{ 
	

	private final String TIPO = "estandar";

	private int duracion = 10;// Si no se indica, duran 3 horas

	public Estandar() {
		super();
	}

	public Estandar(String nombre) {// Si no se indica, duran 3 horas
		super(nombre);
	}

	public Estandar(String nombre, int duracion) {
		super(nombre);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getTIPO() {
		return TIPO;
	}
	
	
//	public void minutoMenos() {
//		this.duracion-=1;
//	}
	
//	public synchronized void  correr() {
//		int tiempo = this.duracion;
//		while (tiempo > 0) {
////			super.movimientoCoches();
//			tiempo--;
//		}
//		Collections.sort(getCoches());
//		super.cochesPodio();
//	}
	
	@Override
	public void run() {
		
	}

	public void correr() {
		int tiempo = this.duracion ;
		while (tiempo > 0) {
			super.movimientoCoches();
			tiempo--;
		}
		Collections.sort(getCoches());
//		super.executor.shutdown();
		super.cochesPodio();
	}

	public JSONObject exportarCarrera() {

		JSONObject obj = new JSONObject();

		obj.put("nombre", super.getNombre());
		
		obj.put("torneo", super.getPegatinaTorneo());

		obj.put("tipo", this.TIPO);

		obj.put("tiempo", this.duracion);

		// No hace falta guaradar el podio teniendo ya las listas de primeros, segundos y terceros. Sería guaradr la info demasiadas vaces
		//Luego al recuperarlo ya lo monto con los datos obtenidos

		JSONArray listaPrimeros = new JSONArray();
		for (Coche coche : super.getPrimeros()) {
			listaPrimeros.add(coche.exportarCoche());
		}
		obj.put("primeros", listaPrimeros);

		JSONArray listaSegundos = new JSONArray();
		for (Coche coche : super.getSegundos()) {
			listaSegundos.add(coche.exportarCoche());
		}
		obj.put("segundos", listaSegundos);

		JSONArray listaTerceros = new JSONArray();
		for (Coche coche : super.getTerceros()) {
			listaTerceros.add(coche.exportarCoche());
		}
		obj.put("terceros", listaTerceros);

		JSONArray listaCochesCarrera = new JSONArray();
		for (Coche coche : super.getCoches()) {
			listaCochesCarrera.add(coche.exportarCoche());
		}
		obj.put("coches", listaCochesCarrera);

// No estoy guardando nada en los garajes de las carreras cuando las creo, asi que esto no hace falta(creo)
//			JSONArray listaGarajes = new JSONArray();
//			for(Garaje garaje: super.getGarajes()) {
//				listaGarajes.add(garaje.exportarGarajeConCoches());
//			}
//			obj.put("garajes", listaGarajes);

		return obj;
	}

}
