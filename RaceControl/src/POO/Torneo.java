package POO;

import java.util.ArrayList;
import java.util.HashMap;

public class Torneo {//Todos los garajes que participan en el torneo irán a todas las carreras. El coche de aleatorio de cada garaje se escoje en cada carrera
	
	private ArrayList<Garaje> garajes = new ArrayList<Garaje>();//Estos garajes son los que podrán participar en las carreras del torneo
	
	private HashMap<Coche,Integer> puntuaciones = new HashMap<Coche,Integer>();

	private String nombre;
	private int numeroCarreras=10;
	
	private ArrayList<Carrera> carreras = new ArrayList<Carrera>();//Ver como hacer lo del numero de carreras con el arrayList. Igual es mejor usar array.
	//Quizá controlandolo en el menú y listo (en funcion del número de carreras que se ha indicado en el constructor)
	
	public Torneo() {	
	}
	
	public void setCarreras(ArrayList<Carrera> carreras) {
		this.carreras = carreras;
	}

	public Torneo(String nombre) {//Si no se indica serán 10 carreras
		this.nombre=nombre;
	}
	
	public Torneo(String nombre, int numeroCarreras) {	//Si se indica el número de carreras
		this.nombre=nombre;
		this.numeroCarreras=numeroCarreras;
	}
	

	public String getNombre() {
		return nombre;
	}

}
