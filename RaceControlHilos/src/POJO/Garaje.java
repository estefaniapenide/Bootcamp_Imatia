package POJO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Controlador.CochesControlador;
import Controlador.GarajesControlador;

public class Garaje {
	
	private String nombre;
	private ArrayList<Coche> coches = new ArrayList<Coche>();
	
	
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
	
	@Override
	public String toString() {
		StringBuilder c = new StringBuilder();
		for(Coche coche : coches) {
			c.append(coche);
		}
		
		String coche="\nNOMBRE: "+this.nombre+"\nNÚMERO DE COCHES: "+this.coches.size()+"\n\tCOCHES"+c;
		return coche;
	}
	
	public JSONObject exportarGarajeConCoches() {//En cada garaje debería ir cada lista de coches cocrrespondiente
		JSONObject obj = new JSONObject();
		obj.put("nombre",this.nombre);
		JSONArray listaCoches = new JSONArray();
		for(Coche coche: this.coches) {
			listaCoches.add(coche.exportarCoche());
		}
		obj.put("coches", listaCoches);
		return obj;
	}
	
	 @Override//Resolver lo de coches y ver si esto le afceta en algo
	    public boolean equals(Object object) {
		 if(object instanceof Garaje) {
			 return ((Garaje) object).getNombre().equals(nombre);
		 }
		 return super.equals(object);

	    }
	 
	 @Override
	 public int hashCode() {
		 return 1;
	 }
	

}
