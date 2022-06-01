package Controlador;

import java.util.ArrayList;

import POO.Torneo;

public class TorneosC {
	
	//Ver donde guardar los torneos, si aquí o en el main(mejor en el main que es donde se recuperarán de archivo)
	public static ArrayList<Torneo> torneos = new ArrayList<Torneo>();
	
	public static void crearTorneo() {
		
	}
	
	public static void verTorneos() {
		for(Torneo torneo:torneos) {
			System.out.println(torneo);
		}
	}
	
	public static boolean existeNombreTorneo(String nombreTonreo) {
		boolean existe=false;
		for(Torneo torneo: torneos) {
			if(torneo.getNombre().equals(nombreTonreo)) {
				existe=true;
			}
		}
		return existe;
	}
}
