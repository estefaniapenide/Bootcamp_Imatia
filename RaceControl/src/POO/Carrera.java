package POO;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Carrera {

	private String nombre;
	private ArrayList<Coche> coches = new ArrayList<Coche>();

	private ArrayList<Garaje> garajes = new ArrayList<Garaje>();
	private Garaje garaje;
	
	private HashMap<Integer,Coche> resultado = new HashMap<Integer,Coche>(); //Poniendo de clave la posición y de valor el coche???

	public Carrera() {

	}
	
	//Si participa un sólo garaje, todos sus coches entran en la competición
	public Carrera(String nombre, Garaje garaje) {
		this.nombre=nombre;
		this.garaje=garaje;
		for(Coche coche:garaje.getCoches()) { //Ver qué pasa con esto 
			this.coches.add(coche);
		}
	}
	
	//Si participa más de un garaje,competirá un coche de cada garaje elegido al azar
	public Carrera(String nombre, ArrayList<Garaje> garajes) {
		this.nombre=nombre;
		this.garajes=garajes;
		for(Garaje garaje:garajes) {
			Coche coche = garaje.getCoches().get(0+ (int) (Math.random() * garaje.getCoches().size()));//Ver qué pasa con esto
			this.coches.add(coche);
		}
	}
	
	

	public Carrera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}

}
