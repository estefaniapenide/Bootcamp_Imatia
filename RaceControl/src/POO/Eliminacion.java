package POO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Eliminacion extends Carrera {

	private int minutosPrevios;
	private int minutoCarrera;
	
	public ArrayList<Coche> cochesParaPodio = new ArrayList<Coche>();//Ir guardando aqui todos los coches antes de elimniarlos. Estos serán los que se organicen el podio

	public Eliminacion() {
		super();
	}

	public Eliminacion(String nombre) {
		super(nombre);
	}

	public Eliminacion(String nombre, Torneo torneo) {
		super(nombre, torneo);
	}


	public Eliminacion(String nombre, int minutosPrevios) {
		super(nombre);
		this.minutosPrevios = minutosPrevios;
	}

	public Eliminacion(String nombre,Torneo torneo, int minutosPrevios) {
		super(nombre, torneo);
		this.minutosPrevios = minutosPrevios;
	}


	public void carrera() {
		// Si aun están en los minutos previos
		while (this.minutosPrevios > 0) {
			movimientoCoches();
			this.minutosPrevios--;
		}
		guardarCochesParaPodio();
		// Una vez acabados los minutosPrevios
		while (super.getCoches().size() > 0) {
			movimientoCoches();
			retirarCoche();
			actualizarCochesParaPodio();
		}
		addCochesPodio();

	}
	
	private void actualizarCochesParaPodio() {//Equals de coche cambiado para que dos coches sean iguales si lo es su marca y su modelo
		
		Coche coche =null;	
		boolean cochePermanece=false;
		for(int i=0; i<super.getCoches().size();i++) {
			if(cochesParaPodio.contains(super.getCoches().get(i))) {
//				cochePermanece=true;
//				coche=super.getCoches().get(i);
//				break;//Solo me va a guardar un coche!!
				cochesParaPodio.remove(super.getCoches().get(i));//Elimnia el coche con distanciaRecorrida antigua
				cochesParaPodio.add(super.getCoches().get(i));//Añade el coche con la nueva distanciaRecorrida
			}
		}
	
		Collections.sort(cochesParaPodio);
	}
	
	private void guardarCochesParaPodio() {
		cochesParaPodio.removeAll(cochesParaPodio);	
		for (int i=0; i<super.getCoches().size();i++) {
			cochesParaPodio.add(super.getCoches().get(i));
		}	
		Collections.sort(cochesParaPodio);
	}

	private void movimientoCoches() {
		for (int i = 0; i < super.getCoches().size(); i++) {
			super.getCoches().get(i).movimiento();// El coche cambia su velocidad y la distanciaRecorrida
		}
		Collections.sort(super.getCoches());// Los coches se ordenan por distancia recorrida
	}

	private void retirarCoche() {// Usar pila??
		if (super.getCoches().size() > 0) {
				
			System.out.println("\nCOCHE ELIMINADO: " + super.getCoches().get((super.getCoches().size()) - 1)
						+ "\nPOSICIÓN: " + (super.getCoches().size()));
				
			if(super.getCoches().size()>2){
				int distanciaUltimo=super.getCoches().get((super.getCoches().size())-1).getDistanciaRecorrida();
				int distanciaPenultimo=super.getCoches().get((super.getCoches().size())-2).getDistanciaRecorrida();
				
				//Si no están iguales, el ultimo es eliminado
				if(distanciaUltimo!=distanciaPenultimo){
					super.getCoches().remove((super.getCoches().size()) - 1);
				}
			}else {
				super.getCoches().remove((super.getCoches().size()) - 1);
			}
				

		}

	}
	
	
	public void addCochesPodio() {//En vez de usar el arrylist de coches (ya que aqui voy a ir eliminado), usa el propio de cochesParaPodio, donde están todos con las posciones finales
		int contador = 0;
		for (int i = 1; i <= cochesParaPodio.size(); i++) {
			// Solo se guardarán tres posiciones
			if (contador < 3) {
				// Si un coche ya está guardado en el podio, lo está con su posición final
				// correcta
				boolean yaGuardado = false;
				for (Coche coche : super.getPodio().keySet()) {
					if (coche.equals((cochesParaPodio.get(i - 1)))) {
						yaGuardado = true;
					}
				}
				if (!yaGuardado) {
					// En caso de que no no estemos en el ultimo coche
					if (cochesParaPodio.size() > i) {
						// Si un coche ha recorrido la misma distancia que el siguiente, ambos se
						// guardarán con la posición del primero
						if (cochesParaPodio.get(i - 1).getDistanciaRecorrida() == cochesParaPodio.get(i)
								.getDistanciaRecorrida()) {
							super.getPodio().put(cochesParaPodio.get(i - 1), (contador + 1));
							super.getPodio().put(cochesParaPodio.get(i), (contador + 1));
							// Si aun quedan coches por comprobar
							if (cochesParaPodio.size() > i + 1) {
								// Si la distancia del siguiente es igual a la de este y van a estar en la misma
								// posición, se deja dar una vuelta más para guardarlo
								if (cochesParaPodio.get(i).getDistanciaRecorrida() == cochesParaPodio.get(i + 1)
										.getDistanciaRecorrida()) {
									contador--;
								}
							}
						} else {// Se guarda el coche con su correspondiente posición
							super.getPodio().put(cochesParaPodio.get(i - 1), (contador + 1));
						}

					} else {// Se guarda el coche con su correspondiente posición
						super.getPodio().put(cochesParaPodio.get(i - 1), (contador + 1));
					}
					// Siguiente posición
					contador++;
				}
			}

		}
	}

}
