package JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Controlador.CochesControlador;
import Controlador.GarajesControlador;
import POJO.Coche;
import POJO.Garaje;

public class CochesJSON {

	public static void guardarCoches() {
		JSONObject coches = exportarCoches();
		try {
			File file = new File("Coches.json");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileW = new FileWriter(file);
			fileW.write(coches.toJSONString());
			fileW.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static JSONObject exportarCoches() {
		JSONObject obj = new JSONObject();
		JSONArray listaCoches = new JSONArray();
		for (Coche c : CochesControlador.coches) {
			listaCoches.add(c.exportarCoche());
		}
		obj.put("coches", listaCoches);

		return obj;
	}

	public static void recuperarCoches(JSONParser parser) {

		try {

			File coches = new File("Coches.json");

			if (coches.exists() && coches.length() > 0) {

				Object parse = parser.parse(new FileReader(coches));
				JSONObject jsonOj = (JSONObject) parse;

				JSONArray listaCoches = (JSONArray) jsonOj.get("coches");

				for (Object coche : listaCoches) {
					JSONObject jcoche = (JSONObject) coche;
					String marca = (String) jcoche.get("marca");
					String modelo = (String) jcoche.get("modelo");
					String garaje = (String) jcoche.get("pegatinaGaraje");

					Coche c = new Coche(marca, modelo, garaje);

					CochesControlador.coches.add(c);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

}
