package POJO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Eliminacion extends Carrera {

	

	private final String TIPO = "eliminacion";
	
	private int minutosPrevios = 10;// Creo que en el enunciado no había valor por defecto. Quitar esto y dejar solo
	
	// Ir guardando aqui todos los coches antes de elimniarlos. Estos serán los que
	// se organicen el podio
	public ArrayList<Coche> cochesParaPodio = new ArrayList<Coche>();

	public Eliminacion() {
		super();
	}

	public Eliminacion(String nombre) {
		super(nombre);
	}

	public Eliminacion(String nombre, int minutosPrevios) {
		super(nombre);
		this.minutosPrevios = minutosPrevios;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void correr() {
		// Si aun están en los minutos previos
		while (this.minutosPrevios > 0) {
			super.movimientoCoches();
			this.minutosPrevios--;
		}
	
		// Una vez acabados los minutosPrevios
		while (getCoches().size() > 0) {
			super.movimientoCoches();
			retirarCoche();
		}
		Collections.sort(cochesParaPodio);
		super.cochesPodio();
	}

	@Override
	public void buscarPrimeros() {
		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < cochesParaPodio.size(); i++) {
			if (cochesParaPodio.get(i).getDistanciaRecorrida() == cochesParaPodio.get(0).getDistanciaRecorrida()) {
				getPrimeros().add(cochesParaPodio.get(i));
				cont++;
			}
		}
		// Borro los coches que estén en primera posición
		while (cont > 0) {
			cochesParaPodio.remove(cont - 1);
			cont--;
		}

	}

	@Override
	public void buscarSegundos() {
		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < cochesParaPodio.size(); i++) {
			if (cochesParaPodio.get(i).getDistanciaRecorrida() == cochesParaPodio.get(0).getDistanciaRecorrida()) {
				getSegundos().add(cochesParaPodio.get(i));
				cont++;
			}
		}
		// Borro los coches que estén en primera posición
		while (cont > 0) {
			cochesParaPodio.remove(cont - 1);
			cont--;
		}

	}

	@Override
	public void buscarTerceros() {
		int cont = 0;
		// Guardo los coches que estén en primera posición
		for (int i = 0; i < cochesParaPodio.size(); i++) {
			if (cochesParaPodio.get(i).getDistanciaRecorrida() == cochesParaPodio.get(0).getDistanciaRecorrida()) {
				getTerceros().add(cochesParaPodio.get(i));
				cont++;
			}
		}
		// Borro los coches que estén en primera posición
		while (cont > 0) {
			cochesParaPodio.remove(cont - 1);
			cont--;
		}

	}

	private void retirarCoche() {// Usar pila??
		if (super.getCoches().size() > 0) {

			if (super.getCoches().size() > 2) {
				int distanciaUltimo = super.getCoches().get((super.getCoches().size()) - 1).getDistanciaRecorrida();
				int distanciaPenultimo = super.getCoches().get((super.getCoches().size()) - 2).getDistanciaRecorrida();

				// Si no están iguales, el ultimo es eliminado
				if (distanciaUltimo != distanciaPenultimo) {
					cochesParaPodio.add(super.getCoches().get((super.getCoches().size()) - 1));
					super.getCoches().remove((super.getCoches().size()) - 1);
				}
			} else {
				cochesParaPodio.add(super.getCoches().get((super.getCoches().size()) - 1));
				super.getCoches().remove((super.getCoches().size()) - 1);
			}

		}

	}

	public JSONObject exportarCarrera() {

		JSONObject obj = new JSONObject();

		obj.put("nombre", super.getNombre());
		
		obj.put("torneo", super.getPegatinaTorneo());

		obj.put("tipo", this.TIPO);

		obj.put("tiempo", this.minutosPrevios);

		// obj.put("podio", super.getPodio());//Pendiente de hacer bien ya que no lo
		// puedo añadir asi como asi. Es un hashmap

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

// No estoy guardando nada en los garajes de las carreras cuando las creo (creo)
//			JSONArray listaGarajes = new JSONArray();
//			for(Garaje garaje: super.getGarajes()) {
//				listaGarajes.add(garaje.exportarGarajeConCoches());
//			}
//			obj.put("garajes", listaGarajes);

		return obj;

	}
}
