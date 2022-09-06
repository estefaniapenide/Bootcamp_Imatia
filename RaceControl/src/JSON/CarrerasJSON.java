package JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

public class CarrerasJSON {

	public static void guardarCarreras() {
		JSONObject carreras = exportarCarreras();
		try {
			File file = new File("Carreras.json");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileW = new FileWriter(file);
			fileW.write(carreras.toJSONString());
			fileW.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static JSONObject exportarCarreras() {
		JSONObject obj = new JSONObject();
		JSONArray listaCarreras = new JSONArray();
		for (Carrera c : CarreraControlador.carreras) {
			listaCarreras.add(c.exportarCarrera());
		}
		obj.put("carreras", listaCarreras);

		return obj;
	}

	public static void recuperarCarreras(JSONParser parser) {

		try {

			File carreras = new File("Carreras.json");

			if (carreras.exists() && carreras.length() > 0) {

				Object parse = parser.parse(new FileReader(carreras));
				JSONObject jsonOj = (JSONObject) parse;

				JSONArray listaCarreras = (JSONArray) jsonOj.get("carreras");

				for (Object carrera : listaCarreras) {
					JSONObject jcarrera = (JSONObject) carrera;
					String nombreCarrera = (String) jcarrera.get("nombre");
					String pegatinaTorneo = (String) jcarrera.get("torneo");
					String tipoCarrera = (String) jcarrera.get("tipo");
					int tiempo = Math.toIntExact((long) jcarrera.get("tiempo"));

					Carrera race = null;
					if (tipoCarrera.equals("estandar")) {
						race = new Estandar(nombreCarrera, tiempo);
					} else if (tipoCarrera.equals("eliminacion")) {
						race = new Eliminacion(nombreCarrera, tiempo);
					}
					
					race.setPegatinaTorneo(pegatinaTorneo);

					JSONArray listaPrimeros = (JSONArray) jcarrera.get("primeros");
					for (Object cochePrimero : listaPrimeros) {
						JSONObject jcochePrimero = (JSONObject) cochePrimero;

						String marcaCoche = (String) jcochePrimero.get("marca");
						String modeloCoche = (String) jcochePrimero.get("modelo");
						Coche cocheTemporal = new Coche(marcaCoche, modeloCoche);
						int indice = CochesControlador.coches.indexOf(cocheTemporal);
						race.getPrimeros().add(CochesControlador.coches.get(indice));
					}

					JSONArray listaSegundos = (JSONArray) jcarrera.get("segundos");
					for (Object cocheSegundo : listaSegundos) {
						JSONObject jcocheSegundo = (JSONObject) cocheSegundo;

						String marcaCoche = (String) jcocheSegundo.get("marca");
						String modeloCoche = (String) jcocheSegundo.get("modelo");
						Coche cocheTemporal = new Coche(marcaCoche, modeloCoche);
						int indice = CochesControlador.coches.indexOf(cocheTemporal);
						race.getSegundos().add(CochesControlador.coches.get(indice));
					}

					JSONArray listaTerceros = (JSONArray) jcarrera.get("segundos");
					for (Object cocheTercero : listaTerceros) {
						JSONObject jcocheTercero = (JSONObject) cocheTercero;

						String marcaCoche = (String) jcocheTercero.get("marca");
						String modeloCoche = (String) jcocheTercero.get("modelo");
						Coche cocheTemporal = new Coche(marcaCoche, modeloCoche);
						int indice = CochesControlador.coches.indexOf(cocheTemporal);
						race.getSegundos().add(CochesControlador.coches.get(indice));
					}

					// Montar el podio
					if (!race.getPrimeros().isEmpty()) {
						race.getPodio().put(1, race.getPrimeros());
					}
					if (!race.getSegundos().isEmpty()) {
						race.getPodio().put(2, race.getSegundos());
					}
					if (!race.getTerceros().isEmpty()) {
						race.getPodio().put(3, race.getTerceros());
					}

					JSONArray listaCoches = (JSONArray) jcarrera.get("coches");
					for (Object c : listaCoches) {
						JSONObject jc = (JSONObject) c;
						String marcaCoche = (String) jc.get("marca");
						String modeloCoche = (String) jc.get("modelo");
						Coche cocheTemporal = new Coche(marcaCoche, modeloCoche);
						int indice = CochesControlador.coches.indexOf(cocheTemporal);
						race.getCoches().add(CochesControlador.coches.get(indice));

					}

					CarreraControlador.carreras.add(race);

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

	}
}
