package POO;

import java.util.ArrayList;

public class Garaje {
	
	private ArrayList<Coche> coches = new ArrayList<Coche>();
	private String nombre;
	
	public Garaje() {}
	
	public Garaje(String nombre) {
		this.nombre=nombre;
	}
	

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	

}
