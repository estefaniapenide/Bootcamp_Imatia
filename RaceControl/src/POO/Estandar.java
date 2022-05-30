package POO;

import java.util.ArrayList;

public class Estandar extends Carrera{
	
	private int duracion=3;//Si no se indica, duran 3 horas
	
	public Estandar() {
		super();
	}
	
	public Estandar(String nombre) {//Si no se indica, duran 3 horas
		super(nombre);
	}
	
	public Estandar(String nombre, Garaje garaje) {//Si no se indica, duran 3 horas
		super(nombre,garaje);
	}
	
	public Estandar(String nombre, ArrayList<Garaje> garajes) {//Si no se indica, duran 3 horas
		super(nombre,garajes);
	}
	
	public Estandar(String nombre, int duracion) {
		super(nombre);
		this.duracion=duracion;
	}
	
	public Estandar(String nombre, Garaje garaje, int duracion) {
		super(nombre,garaje);
		this.duracion=duracion;
	}
	
	public Estandar(String nombre, ArrayList<Garaje> garajes, int duracion) {
		super(nombre,garajes);
		this.duracion=duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
