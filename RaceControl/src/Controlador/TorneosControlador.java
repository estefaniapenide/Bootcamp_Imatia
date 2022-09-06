package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ext.DOMDeserializer.NodeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import com.google.gson.reflect.TypeToken;

import JSON.InterfaceAdapter;
import POJO.Carrera;
import POJO.Garaje;
import POJO.Torneo;

public class TorneosControlador {

	// TODOS LOS TORNEOS QUE SE REGISTREN ESTRARÁN AQUI
	public static ArrayList<Torneo> torneos = new ArrayList<Torneo>();
	
	public static ArrayList<Torneo> getTorneos() {
		return torneos;
	}

	public static void setTorneos(ArrayList<Torneo> torneos) {
		TorneosControlador.torneos = torneos;
	}

	public static void crearTorneoEstandar(String nombre, ArrayList<Garaje> garajes) {
		Torneo torneo = new Torneo(nombre, garajes);
		torneos.add(torneo);
	}

	public static Torneo crearTorneo(String nombre, ArrayList<Garaje> garajes, int num) {
		Torneo torneo = new Torneo(nombre, garajes, num);
		// torneos.add(torneo);//Lo estoy aladiendo en TorneosVista. Darle una vuelta
		return torneo;
	}

	// Ver si usar una variante de este o no usarlo nunca
	public static void crearTorneo(String nombre, ArrayList<Garaje> garajes, int numCarrerasEstandar,
			int numCarrerasEliminacion) {
		int numCarreras = numCarrerasEstandar + numCarrerasEliminacion;

		Torneo torneo = new Torneo(nombre, garajes, numCarreras);
		torneos.add(torneo);
	}

	public static Torneo getTorneo(String nombreTorneo) {

		Torneo torneo = null;
		for (Torneo t : torneos) {
			if (t.getNombre().equals(nombreTorneo)) {
				torneo = t;
			}
		}
		return torneo;
	}

	public static Torneo getTorneo(Torneo torneo) {

		Torneo tor = null;
		for (Torneo t : torneos) {
			if (t.equals(torneo)) {
				tor = t;
			}
		}
		return tor;
	}

	public static boolean existeNombreTorneo(String nombreTorneo) {
		boolean existe = false;
		for (Torneo torneo : torneos) {
			if (torneo.getNombre().equals(nombreTorneo)) {
				existe = true;
			}
		}
		return existe;
	}

	public static boolean torneoTerminado(Torneo torneo) {
		boolean terminado = true;
		for (Carrera carrera : torneo.getCarreras()) {
			if (carrera.getPodio().isEmpty()) {
				terminado = false;
			}
		}
		return terminado;
	}
	
	public void setGanadores(Torneo torneo) {//Esto hay que acabarlo. Lo de borra los coches sin tener una copia...mejor no.
		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < torneo.getPuntuaciones().size(); i++) {
			if (torneo.getPuntuaciones().get(i).getPuntos() == torneo.getPuntuaciones().get(0).getPuntos()) {
				torneo.getGanadores().add(torneo.getPuntuaciones().get(i).getCoche());
				cont++;
			}
		}
		// Borro los coches que estén en primera posición
		while (cont > 0) {
			torneo.getPuntuaciones().remove(cont - 1);
			cont--;
		}

	}
	

	
//	public static void guardarTorneos() {
//		
//		GsonBuilder gsonBuilder = new GsonBuilder();
//		gsonBuilder.registerTypeAdapter(Carrera.class, new InterfaceAdapter<Carrera>());
//		gsonBuilder.setPrettyPrinting();
//		Gson gson = gsonBuilder.create();
//		
//		//Gson gsonGarages = new GsonBuilder().setPrettyPrinting().create();
//		try {
//
//			Writer writerGarages = Files.newBufferedWriter(Paths.get("Torneos.json"));
//			gson.toJson(torneos, writerGarages);
//			writerGarages.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	
//	public static void recuperarTorneos() {
//				
//		Reader reader;
//		try {
//			reader = Files.newBufferedReader(Paths.get("Torneos.json"));
//			Gson gsonTorneos = new Gson();
//			Type torneoType = new TypeToken<ArrayList<Torneo>>() {
//			}.getType();
//			setTorneos(gsonTorneos.fromJson(reader, torneoType));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}


	

}
