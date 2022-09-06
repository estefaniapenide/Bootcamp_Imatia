package JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Controlador.CochesControlador;
import Controlador.GarajesControlador;
import POJO.Coche;
import POJO.Garaje;

public class GarajesJSON {

	public GarajesJSON() {
	}

	public static void guardarGarajes() {
		JSONObject garajes = exportarGarajes();
		try {
			File file = new File("Garajes.json");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileW = new FileWriter(file);
			fileW.write(garajes.toJSONString());
			fileW.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static JSONObject exportarGarajes() {
		JSONObject obj = new JSONObject();
		JSONArray listaGarajes = new JSONArray();
		for (Garaje g : GarajesControlador.garajes) {
			listaGarajes.add(g.exportarGarajeConCoches());
		}
		obj.put("garajes", listaGarajes);

		return obj;
	}

	public static void recuperarGarajes(JSONParser parser) {

		try {

			File garajes = new File("Garajes.json");

			if (garajes.exists() && garajes.length() > 0) {

				Object parse = parser.parse(new FileReader(garajes));
				JSONObject jsonOj = (JSONObject) parse;

				JSONArray listaGarajes = (JSONArray) jsonOj.get("garajes");

				for (Object g : listaGarajes) {
					JSONObject jg = (JSONObject) g;
					String nombreGaraje = (String) jg.get("nombre");

					Garaje garaje = new Garaje(nombreGaraje);

					JSONArray listaCoches = (JSONArray) jg.get("coches");
					for (Object c : listaCoches) {
						JSONObject jc = (JSONObject) c;
						String marcaCoche = (String) jc.get("marca");
						String modeloCoche = (String) jc.get("modelo");
						Coche cocheTemporal = new Coche(marcaCoche, modeloCoche);
						int indice = CochesControlador.coches.indexOf(cocheTemporal);
						garaje.getCoches().add(CochesControlador.coches.get(indice));

					}

					GarajesControlador.garajes.add(garaje);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

}
