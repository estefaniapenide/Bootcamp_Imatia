package POO;

import java.util.ArrayList;
import java.util.Collections;

public class Estandar extends Carrera {

	private int duracion = 3;// Si no se indica, duran 3 horas

	public Estandar() {
		super();
	}

	public Estandar(String nombre) {// Si no se indica, duran 3 horas
		super(nombre);
	}

	public Estandar(String nombre, Torneo torneo) {// Si no se indica, duran 3 horas
		super(nombre, torneo);
	}


	public Estandar(String nombre, int duracion) {
		super(nombre);
		this.duracion = duracion;
	}

	public Estandar(String nombre,Torneo torneo, int duracion) {
		super(nombre, torneo);
		this.duracion = duracion;
	}


	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void carrera() {
		while ((this.duracion * 60) > 0) {
			movimientoCoches();
			this.duracion = (this.duracion * 60) + 1;
		}
		addCochesPodio();
	}

	private void movimientoCoches() {
		for (int i = 0; i < super.getCoches().size(); i++) {
			super.getCoches().get(i).movimiento();// El coche cambia su velocidad y la distanciaRecorrida
		}
		Collections.sort(super.getCoches());// Los coches se ordenan por distancia recorrida
	}
	
//Pensar en lo de Armando, usando listas para cada puesto del podio.

	public void addCochesPodio() {
		int contador = 0;
		for (int i = 1; i <= super.getCoches().size(); i++) {
			// Solo se guardarán tres posiciones
			if (contador < 3) {
				// Si un coche ya está guardado en el podio, lo está con su posición final
				// correcta
				boolean yaGuardado = false;
				for (Coche coche : super.getPodio().keySet()) {
					if (coche.equals((super.getCoches().get(i - 1)))) {
						yaGuardado = true;
					}
				}
				if (!yaGuardado) {
					// En caso de que no no estemos en el ultimo coche
					if (super.getCoches().size() > i) {
						// Si un coche ha recorrido la misma distancia que el siguiente, ambos se
						// guardarán con la posición del primero
						if (super.getCoches().get(i - 1).getDistanciaRecorrida() == super.getCoches().get(i)
								.getDistanciaRecorrida()) {
							super.getPodio().put(super.getCoches().get(i - 1), (contador + 1));
							super.getPodio().put(super.getCoches().get(i), (contador + 1));
							// Si aun quedan coches por comprobar
							if (super.getCoches().size() > i + 1) {
								// Si la distancia del siguiente es igual a la de este y van a estar en la misma
								// posición, se deja dar una vuelta más para guardarlo
								if (super.getCoches().get(i).getDistanciaRecorrida() == super.getCoches().get(i + 1)
										.getDistanciaRecorrida()) {
									contador--;
								}
							}
						} else {// Se guarda el coche con su correspondiente posición
							super.getPodio().put(super.getCoches().get(i - 1), (contador + 1));
						}

					} else {// Se guarda el coche con su correspondiente posición
						super.getPodio().put(super.getCoches().get(i - 1), (contador + 1));
					}
					// Siguiente posición
					contador++;
				}
			}

		}
	}

}
