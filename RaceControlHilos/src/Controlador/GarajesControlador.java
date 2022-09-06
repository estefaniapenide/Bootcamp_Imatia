package Controlador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.lang.reflect.Type;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import JSON.InterfaceAdapter;
import POJO.Carrera;
import POJO.Coche;
import POJO.Garaje;
import POJO.Torneo;

public class GarajesControlador {
	
	//TODOS LOS GARAJES QUE SE REGISTREN ESTRARÁN AQUI
	public static ArrayList<Garaje> garajes = new ArrayList<Garaje>();
	
	
	public static ArrayList<Garaje> getGarajes() {
		return garajes;
	}

	public static void setGarajes(ArrayList<Garaje> garajes) {
		GarajesControlador.garajes = garajes;
	}

	public static boolean existeNombreGaraje(String nombreGaraje) {
		boolean existe=false;
		for(Garaje garaje: garajes) {
			if(garaje.getNombre().equals(nombreGaraje)) {
				existe=true;
			}
		}
		return existe;
	}
	
	public static Garaje getGaraje(String nombreGaraje) {
		
		Garaje garaje =null;
		for(Garaje g: garajes) {
			if(g.getNombre().equals(nombreGaraje)) {
				garaje=g;
			}
		}		
		return garaje;
	}
	
	public static void crearGaraje(String nombreGaraje) {
		Garaje garaje = new Garaje(nombreGaraje);
		garajes.add(garaje);
	}
	
	
//	public static void guardarGarajes() {
////		Gson gsonGarages = new GsonBuilder().setPrettyPrinting().create();
//		
//		GsonBuilder gsonBuilder = new GsonBuilder();
//		gsonBuilder.registerTypeAdapter(Carrera.class, new InterfaceAdapter<Carrera>());
//		gsonBuilder.setPrettyPrinting();
//		Gson gson = gsonBuilder.create();
//		try {
//
//			Writer writerGarages = Files.newBufferedWriter(Paths.get("Garajes.json"));
//			gson.toJson(garajes, writerGarages);
//			writerGarages.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	
//	public static void recuperarGarjes() {
//		Reader reader;
//		try {
//			reader = Files.newBufferedReader(Paths.get("Garajes.json"));
//			Gson gsonGarages = new Gson();
//			Type garageType = new TypeToken<ArrayList<Garaje>>() {
//			}.getType();
//			setGarajes(gsonGarages.fromJson(reader, garageType));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
	


}
