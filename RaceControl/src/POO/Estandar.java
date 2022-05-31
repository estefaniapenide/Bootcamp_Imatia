package POO;

import java.util.ArrayList;
import java.util.Collections;

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
	
//	public void carrera() {
//		// Si aun están en los minutos previos
//		while ((this.duracion*60) > 0) {
//			movimientoCoches();
//			this.minutosPrevios--;
//		}
//		//Una vez acabados los minutosPrevios
//		while (super.getCoches().size() > 0) {
//			movimientoCoches();
//			retirarCoche();
//		}
//		Collections.sort(super.getPodio());//Se ordena el podio
//	}
//	
//	private void movimientoCoches() {
//		for (int i = 0; i < super.getCoches().size(); i++) {
//			super.getCoches().get(i).movimiento();// El coche cambia su velocidad y la distanciaRecorrida
//		}
//		Collections.sort(super.getCoches());//Los coches se ordenan por distancia recorrida
//	}

}
