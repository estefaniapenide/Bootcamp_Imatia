package POO;

import java.util.ArrayList;

public class Torneo {//Igual esto es mejor hacerlo en el menú
	
	private ArrayList<Garaje> garajes = new ArrayList<Garaje>();//Estos garajes son los que podrán participar en las carreras del torneo
;
	private String nombre;
	private int numeroCarreras=10;
	
	private Carrera[] carreras = new Carrera[this.numeroCarreras];//Mirar esto bien
	
	public Torneo() {	
	}
	
	public Torneo(String nombre) {	//Si no se indica serán 10 carreras
		this.nombre=nombre;
	}
	
	public Torneo(String nombre, int numeroCarreras) {	//Si se indica el número de carreras
		this.nombre=nombre;
		this.numeroCarreras=numeroCarreras;
	}

}
