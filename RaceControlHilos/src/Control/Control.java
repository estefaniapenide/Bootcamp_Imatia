package Control;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;

import Cadenas.Cadenas;
import ControlData.ControlData;
import Controlador.CarreraControlador;
import Controlador.CochesControlador;
import Controlador.GarajesControlador;
import Controlador.TorneosControlador;
import Vista.GarajesVista;
import Vista.TorneosVista;
import JSON.CarrerasJSON;
import JSON.CochesJSON;
import JSON.GarajesJSON;
import JSON.TorneosJSON;
import POJO.Carrera;
import POJO.Coche;
import POJO.Eliminacion;
import POJO.Estandar;
import POJO.Garaje;
import POJO.Torneo;

public class Control {

	public static void main(String[] args) {

		// Pruebas

		Garaje g1 = new Garaje("1");
		Garaje g2 = new Garaje("2");
		Garaje g3 = new Garaje("3");

		Coche c1 = new Coche("aaaa", "uno", g1.getNombre());
		Coche c2 = new Coche("aaaa", "dos", g1.getNombre());
		Coche c3 = new Coche("aaaa", "tres", g1.getNombre());
		Coche c4 = new Coche("aaaa", "cuatro", g1.getNombre());
		Coche c20 = new Coche("aaaa", "cinco", g1.getNombre());
//				c1.setGaraje(g1);
//				c2.setGaraje(g1);
//				c3.setGaraje(g1);
//				c4.setGaraje(g1);
//				c20.setGaraje(g1);

		Coche c5 = new Coche("bbbbb", "a", g2.getNombre());
		Coche c6 = new Coche("bbbbb", "b", g2.getNombre());
		Coche c7 = new Coche("bbbbb", "c", g2.getNombre());
		Coche c8 = new Coche("bbbbb", "d", g2.getNombre());
//				c5.setGaraje(g2);
//				c6.setGaraje(g2);
//				c7.setGaraje(g2);
//				c8.setGaraje(g2);

		Coche c9 = new Coche("cccc", "alfa", g3.getNombre());
		Coche c10 = new Coche("cccc", "beta", g3.getNombre());
		Coche c11 = new Coche("cccc", "gamma", g3.getNombre());
		Coche c12 = new Coche("cccc", "delta", g3.getNombre());
//				c9.setGaraje(g3);
//				c10.setGaraje(g3);
//				c11.setGaraje(g3);
//				c12.setGaraje(g3);
//
//		g1.getCoches().add(c1);
//		g1.getCoches().add(c2);
//		g1.getCoches().add(c3);
//		g1.getCoches().add(c4);
//		g1.getCoches().add(c20);
//
//		g2.getCoches().add(c5);
//		g2.getCoches().add(c6);
//		g2.getCoches().add(c7);
//		g2.getCoches().add(c8);
//
//		g3.getCoches().add(c9);
//		g3.getCoches().add(c10);
//		g3.getCoches().add(c11);
//		g3.getCoches().add(c12);
		
//		GarajesControlador.garajes.add(g1);
//		GarajesControlador.garajes.add(g2);
//		GarajesControlador.garajes.add(g3);
//		
		
//		GarajesControlador.guardarGarajes();
		
//		GarajesControlador.recuperarGarjes();
		
//		

//		
//		CochesControlador.coches.add(c1);
//		CochesControlador.coches.add(c2);
//		CochesControlador.coches.add(c3);
//		CochesControlador.coches.add(c4);
//		CochesControlador.coches.add(c5);
//		CochesControlador.coches.add(c6);
//		CochesControlador.coches.add(c7);
//		CochesControlador.coches.add(c8);
//		CochesControlador.coches.add(c9);
//		CochesControlador.coches.add(c10);
//		CochesControlador.coches.add(c11);
//		CochesControlador.coches.add(c12);
//		CochesControlador.coches.add(c20);
		
//		GarajesJSON.guardarGarajes();
		
//		JSONParser parser = new JSONParser();
//		GarajesJSON.recuperarGarajes(parser);
//		
//		for(Garaje g:GarajesControlador.garajes) {
//		System.out.println(g);
//	}
//		
//		
//		GarajesJSON.guardarGarajes();
		

	/*ArrayList<Garaje> garajes1 = new ArrayList<Garaje>();
		garajes1.add(g1);
		garajes1.add(g2);
		garajes1.add(g3);

		ArrayList<Garaje> garajes2 = new ArrayList<Garaje>();
		garajes2.add(g1);

		Torneo t1 = new Torneo("T1", garajes1);
		Torneo t2 = new Torneo("T2", garajes2);

//		System.out.print(t1);

		Torneo t3 = new Torneo("T3");
		Torneo t4 = new Torneo("T4");
		Torneo t5 = new Torneo("T5");

		t3.getGarajes().add(g1);
		t3.getGarajes().add(g2);*/


//
//		GarajesControlador.garajes.add(g1);
//		GarajesControlador.garajes.add(g2);
//		GarajesControlador.garajes.add(g3);

		Scanner input = new Scanner(System.in);

//		TorneosControlador.recuperarTorneos();
		
		JSONParser parser4 = new JSONParser();
		CochesJSON.recuperarCoches(parser4);
//		for(Coche coche: CochesControlador.coches) {
//			System.out.println(coche);
//		}
		
		JSONParser parser3 = new JSONParser();
		GarajesJSON.recuperarGarajes(parser3);
//		for(Garaje garaje: GarajesControlador.garajes) {
//			System.out.println(garaje);
//		}

		JSONParser parser2 = new JSONParser();
		CarrerasJSON.recuperarCarreras(parser2);
//		for(Carrera carrera: CarreraControlador.carreras) {
//			System.out.println(carrera);
//		}

		JSONParser parser1 = new JSONParser();
		TorneosJSON.recuperarTorneos(parser1);
//		for(Torneo torneo: TorneosControlador.torneos) {
//			System.out.println(torneo);
//		}


		byte op = 0;
		do {
			Cadenas.menuPrincipal();
			op = ControlData.leerByte(input);
			switch (op) {
			case 1:
				TorneosVista.opcionesTorneos(input);
				break;
			case 2:
				GarajesVista.opcionesGarajes(input);
				break;
			case 3:
				ArrayList<Garaje> garajes = new ArrayList<Garaje>();
				garajes.add(GarajesControlador.getGarajes().get(0));
				Carrera carrera=CarreraControlador.crearCarreraDragster(garajes,true);
				if(carrera instanceof Estandar) {
					((Estandar) carrera).correr();
//					carrera.cochesPodio();
//					System.out.println(carrera.getPodio());
				}
//				for(Coche coche:carrera.getCoches()) {
//					coche.start();
//				}
			case 0:
//				for (Torneo t : TorneosControlador.torneos) {
//					TorneosControlador.guardarTorneo(t);
//				}
//				TorneosControlador.guardarTorneos();
				CochesJSON.guardarCoches();
				GarajesJSON.guardarGarajes();
				CarrerasJSON.guardarCarreras();
				TorneosJSON.guardarTorneos();
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}
		} while (op != 0);

		input.close();



	}

}
