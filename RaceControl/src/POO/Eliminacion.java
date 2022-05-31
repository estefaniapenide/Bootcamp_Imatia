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

	public Eliminacion() {
		super();
	}

	public Eliminacion(String nombre) {
		super(nombre);
	}

	public Eliminacion(String nombre, Garaje garaje) {
		super(nombre, garaje);
	}

	public Eliminacion(String nombre, ArrayList<Garaje> garajes) {
		super(nombre, garajes);
	}

	public Eliminacion(String nombre, int minutosPrevios) {
		super(nombre);
		this.minutosPrevios = minutosPrevios;
	}

	public Eliminacion(String nombre, Garaje garaje, int minutosPrevios) {
		super(nombre, garaje);
		this.minutosPrevios = minutosPrevios;
	}

	public Eliminacion(String nombre, ArrayList<Garaje> garajes, int minutosPrevios) {
		super(nombre, garajes);
		this.minutosPrevios = minutosPrevios;
	}

//	private void ordenarPosicion() {
//		int posicion=1;
//		for(int i=0; i<super.getCoches().size();i++) {
//			if(super.getCoches().get(i).getDistanciaRecorrida()<super.getCoches().get(i+1).getDistanciaRecorrida()) {
//				super.getCoches().get(i+1).setPosicion(1);
//			}//No sé como hacer esto
//		}
//		
//	}

//	public void movimientoMinuto() {//Pendiente
//		// Si aun están en los minutos previos
//		if (this.minutosPrevios > 0) {// while o if dependiendo de si lo llamo yo de cada vez o lo dejo automatico
//			for (int i = 0; i < super.getCoches().size(); i++) {
//				super.getCoches().get(i).movimiento();//El coche cambia su velocidad y la distanciaRecorrida
//			}
//			//Ordenar los coches según la distancia recorrida
//			ordenarPosicion();
//			this.minutosPrevios--;
//		}
//		
//	}

	public void carrera() {
		// Si aun están en los minutos previos
		while (this.minutosPrevios > 0) {
			movimientoCoches();
			this.minutosPrevios--;
		}
		guardarRepeticiones();
		
		//Esto será un while y se repetirá si hay varios grupos de distancias repetidas es decir, mientras no esté vacío)
		if (!repeticiones.isEmpty()) {
			System.out.println("HAY REPETICIONES");
			int posicionMin = Collections.min(repeticiones.values());
			//Aqquí hay que comprobar si es la posición provisional que le toca o no. 
			//Si no le toca esa, habrá que darle a a posición el valor real de la posición provisional
			//Lo malo es que hay que actualizar los valores de posicón provisonal de los coches intermedios y que no están en el de repeticiones
			//Esta ultima frase habría que hacerlo al final del bucle (dentro) antes de que de la vuelta
			int posicion=posicionMin; 
			int distancia = 0;
			Coche coche=null;
			// Valor de la distancia en la posicion más cercana a ganar
			for (Map.Entry<Coche, Integer> entry : repeticiones.entrySet()) {
				if (Objects.equals(entry.getValue(), posicionMin)) {
					coche = entry.getKey();
					coche.posicionProvisional = posicion;
					distancia = coche.getDistanciaRecorrida();
					
				}
			}
			//Se elimina del HasMap una vez se le ha asignado su posición del podio
			repeticiones.remove(coche);
			
			//Si tiene la misma distancia, pasa a estar en la misma posición
			for (Coche cocheMismaDistnacia : repeticiones.keySet()) {
				if (distancia == cocheMismaDistnacia.getDistanciaRecorrida()) {
					cocheMismaDistnacia.posicionProvisional = posicion;
					//Se elimina del HasMap una vez se le ha asignado su posición del podio
					repeticiones.remove(cocheMismaDistnacia);
				}
			}
			
			//Aquí habría que recorrer getCoches y darle el valor de posicón provisional correspondiente a los que le toquen
			//También hay que mirar si hay que hacer esto en movimientoCoche, después del sort o ver qué hacer
			
			System.out.println(posicion);
			//NOOOOO. Creo que lo de aqui no. Hacer lo de arriba.
			//Ahora hay que añadirle uno a posición, `pues será la posción provisional del siguiente grupo de repeticiones y vuelta a empezar
		}

		// Una vez acabados los minutosPrevios
//		while (super.getCoches().size() > 0) {
//			movimientoCoches();
//			guardarRepeticiones();
//			retirarCoche();
//		}
		// Collections.sort(super.getPodio());// Se ordena el podio
	}

	private void movimientoCoches() {
		for (int i = 0; i < super.getCoches().size(); i++) {
			super.getCoches().get(i).movimiento();// El coche cambia su velocidad y la distanciaRecorrida
		}
		Collections.sort(super.getCoches());// Los coches se ordenan por distancia recorrida
	}

	HashMap<Coche, Integer> repeticiones = new HashMap<Coche, Integer>();

	private void guardarRepeticiones() {
		for (int i = 1; i < super.getCoches().size(); i++) {
			if (super.getCoches().get(i - 1).getDistanciaRecorrida() == super.getCoches().get(i)
					.getDistanciaRecorrida()) {
				repeticiones.put(super.getCoches().get(i - 1), i);// Guardo la posición y el coche para corregirlo
				repeticiones.put(super.getCoches().get(i), i + 1);// Guardo la posición y el coche para corregirlo
			}
		}
	}

	private void limpiarRepeticiones() {
		repeticiones.clear();
	}

//	private void retirarCoche() {// Usar pila??
//		if (super.getCoches().size() > 0) {
//			if (repeticiones.isEmpty()) {
//				if (super.getCoches().size() <= 3) {// Los ultimos tres se meten en el podio
//					super.getPodio().add(super.getCoches().get((super.getCoches().size()) - 1));
//				}
//
//				System.out.println("\nCOCHE ELIMINADO: " + super.getCoches().get((super.getCoches().size()) - 1)
//						+ "\nPOSICIÓN: " + (super.getCoches().size()));
//				super.getCoches().remove((super.getCoches().size()) - 1);
//			} else {
//				for (Map.Entry<Coche, Integer> entry : repeticiones.entrySet()) {
//					Integer posicion = entry.getValue();
//					Coche coche = entry.getKey();
//					int distancia = coche.getDistanciaRecorrida();
//					System.out.println(posicion + coche.toString());
//				}
//				int posicion = Collections.min(repeticiones.values());
//				System.out.println(posicion);
//			}
//
//		}
//
//	}

}
