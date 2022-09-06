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
import POJO.Puntuacion;
import POJO.Torneo;

public class TorneosJSON {

	public static void guardarTorneos() {

		JSONObject torneos = exportarTorneos();
		try {
			File file = new File("Torneos.json");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileW = new FileWriter(file);
			fileW.write(torneos.toJSONString());
			fileW.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static JSONObject exportarTorneos() {
		JSONObject obj = new JSONObject();
		JSONArray listaTorneos = new JSONArray();
		for (Torneo t : TorneosControlador.torneos) {
			listaTorneos.add(t.exportarTorneosJugados());
		}
		obj.put("torneos", listaTorneos);

		return obj;
	}

	public static void recuperarTorneos(JSONParser parser) {

		try {

			File torneos = new File("Torneos.json");

			if (torneos.exists() && torneos.length() > 0) {

				Object parse = parser.parse(new FileReader(torneos));
				JSONObject jsonOj = (JSONObject) parse;

				JSONArray listaTorneos = (JSONArray) jsonOj.get("torneos");

				for (Object torneo : listaTorneos) {
					JSONObject jtorneo = (JSONObject) torneo;
					String nombretorneo = (String) jtorneo.get("nombre");
					int numeroCarreras = Math.toIntExact((long) jtorneo.get("numeroCarreras"));

					Torneo t = new Torneo(nombretorneo, numeroCarreras);

					JSONArray listaPuntuaciones = (JSONArray) jtorneo.get("puntuaciones");

					for (Object puntuacion : listaPuntuaciones) {

						JSONObject jpuntuacion = (JSONObject) puntuacion;

						int puntos = Math.toIntExact((long) jpuntuacion.get("puntos"));

						Object coche = (Object) jpuntuacion.get("coche");

						JSONObject jcoche = (JSONObject) coche;
						String marca = (String) jcoche.get("marca");
						String modelo = (String) jcoche.get("modelo");

						Coche cocheTemporal = new Coche(marca, modelo);
						int indice = CochesControlador.coches.indexOf(cocheTemporal);

						Puntuacion p = new Puntuacion(puntos, CochesControlador.coches.get(indice));

						t.getPuntuaciones().add(p);

					}

					JSONArray listaCarreras = (JSONArray) jtorneo.get("carreras");

					for (Object carrera : listaCarreras) {
						JSONObject jcarrera = (JSONObject) carrera;
						String nombreCarrera = (String) jcarrera.get("nombre");
						String pegatinaTorneo = (String) jcarrera.get("torneo");
						String tipoCarrera = (String) jcarrera.get("tipo");

						Carrera race = null;
						if (tipoCarrera.equals("estandar")) {
							race = new Estandar(nombreCarrera);
						} else if (tipoCarrera.equals("eliminacion")) {
							race = new Eliminacion(nombreCarrera);
						}
						
						race.setPegatinaTorneo(pegatinaTorneo);

						int indice = CarreraControlador.carreras.indexOf(race);
						t.getCarreras().add(CarreraControlador.carreras.get(indice));

					}

					JSONArray listaGarajes = (JSONArray) jtorneo.get("garajes");

					for (Object garaje : listaGarajes) {
						JSONObject jgaraje = (JSONObject) garaje;
						String nombreGaraje = (String) jgaraje.get("nombre");

						Garaje g = new Garaje(nombreGaraje);

						int indice = GarajesControlador.garajes.indexOf(g);
						t.getGarajes().add(GarajesControlador.garajes.get(indice));

					}

					TorneosControlador.torneos.add(t);

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

}
