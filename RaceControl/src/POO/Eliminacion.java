package POO;

import java.util.ArrayList;

public class Eliminacion extends Carrera {

	private int minutosPrevios;
	private int minutoCarrera;

	public Eliminacion() {
		super();
	}

	public Eliminacion(String nombre) {
		super(nombre);
	}
	
	public Eliminacion(String nombre, Garaje garaje) {
		super(nombre,garaje);
	}
	
	public Eliminacion(String nombre, ArrayList<Garaje> garajes) {
		super(nombre,garajes);
	}

	public Eliminacion(String nombre, int minutosPrevios) {
		super(nombre);
		this.minutosPrevios = minutosPrevios;
	}
	
	public Eliminacion(String nombre, Garaje garaje, int minutosPrevios) {
		super(nombre,garaje);
		this.minutosPrevios=minutosPrevios;
	}
	
	public Eliminacion(String nombre, ArrayList<Garaje> garajes, int minutosPrevios) {
		super(nombre,garajes);
		this.minutosPrevios=minutosPrevios;
	}

	public void retirarCoche() {//Hacer que esta eliminación sea cada minuto de la carrera
		if (this.minutosPrevios == 0) {
			for (Coche coche : super.getCoches()) {
				if (super.getCoches().size() == coche.getPosicion() && super.getCoches().size()>1 ) { //Ver qué pasa con esto
					super.getCoches().remove(coche);
				}
			}
		}
	}

}
