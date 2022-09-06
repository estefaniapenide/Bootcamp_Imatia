package Controlador;

import java.util.ArrayList;

import POJO.Coche;
import POJO.Garaje;

public class CochesControlador {

	// TODOS LOS COCHES QUE SE REGISTREN ESTRARÁN AQUI
	public static ArrayList<Coche> coches = new ArrayList<Coche>();

	public static boolean existeCocheEnGaraje(Coche coche) {
		boolean existe = false;
		for (Garaje garaje : GarajesControlador.garajes) {
			if (garaje.getNombre().equals(coche.getPegatinaGaraje())) {
				for (Coche c : garaje.getCoches()) {
					if (c.equals(coche)) {
						existe = true;
					}
				}
			}
		}
		return existe;
	}

	public static boolean existeCoche(Coche coche) {
		boolean existe = false;
		for (Coche c : CochesControlador.coches) {
			if (c.equals(coche)) {
				existe = true;
			}
		}
		return existe;
	}

	public static void crearCoche(String marca, String modelo, String nombreGaraje) {

		Coche coche = new Coche(marca, modelo, nombreGaraje);

		if (!existeCoche(coche)) {
			for (Garaje garaje : GarajesControlador.garajes) {
				if (garaje.getNombre().equals(nombreGaraje)) {
					garaje.getCoches().add(coche);
					CochesControlador.coches.add(coche);
				}
			}
		}

	}

}
