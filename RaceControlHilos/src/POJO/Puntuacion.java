package POJO;

import org.json.simple.JSONObject;

public class Puntuacion  implements Comparable<Puntuacion>{
	
	private int puntos;
	private Coche coche;
	
	public Puntuacion() {}
	
	public Puntuacion(int puntos, Coche coche) {
		super();
		this.puntos = puntos;
		this.coche = coche;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	public JSONObject exportarPuntuacion() {
		JSONObject obj = new JSONObject();
		obj.put("puntos", this.puntos);
		obj.put("coche", this.coche.exportarCoche());
		return obj;
	}

	
	@Override
	public int compareTo(Puntuacion puntuacion) {
		if(this.puntos>puntuacion.puntos) {
			return -1;
		}else if(this.puntos<puntuacion.puntos) {
			return 1;
		}else {
			return 0;
		}
	}
	

}
