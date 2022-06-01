package Control;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import Cadenas.Cadenas;
import ControlData.ControlData;
import POO.Coche;
import POO.Eliminacion;
import POO.Estandar;
import POO.Garaje;
import POO.Torneo;
import Vista.TorneosV;

public class Control {

	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		
		byte op=0;
		do {
			Cadenas.menuPrincipal();
			op = ControlData.leerByte(input);
			switch(op) {
			case 1:
				TorneosV.opcionesTorneos();
				break;
			case 2:
				break;
			case 3:
				break;
			case 0:
				Cadenas.fin();
				break;
			default:
				Cadenas.mensajeDefault();
				break;
			}
		}while(op!=0);
		
		input.close();
		
		//Pruebas
		
		Garaje g1 = new Garaje("1");
		Garaje g2 = new Garaje("2");
		Garaje g3 = new Garaje("3");
		
		Coche c1 = new Coche("opel","uno");
		Coche c2 = new Coche("opel","dos");
		Coche c3 = new Coche("opel","tres");
		Coche c4 = new Coche("opel","cuatro");
		Coche c20 = new Coche("opel","cinco");
		c1.setGaraje(g1);
		c2.setGaraje(g1);
		c3.setGaraje(g1);
		c4.setGaraje(g1);
		c20.setGaraje(g1);
		
		Coche c5 = new Coche("seat","a");
		Coche c6 = new Coche("seat","b");
		Coche c7 = new Coche("seat","c");
		Coche c8 = new Coche("seat","d");
		c5.setGaraje(g2);
		c6.setGaraje(g2);
		c7.setGaraje(g2);
		c8.setGaraje(g2);
		
		Coche c9 = new Coche("seat","alfa");
		Coche c10 = new Coche("seat","beta");
		Coche c11 = new Coche("seat","gamma");
		Coche c12 = new Coche("seat","delta");
		c9.setGaraje(g3);
		c10.setGaraje(g3);
		c11.setGaraje(g3);
		c12.setGaraje(g3);
		
		g1.getCoches().add(c1);
		g1.getCoches().add(c2);
		g1.getCoches().add(c3);
		g1.getCoches().add(c4);
		g1.getCoches().add(c20);
		
		g2.getCoches().add(c5);
		g2.getCoches().add(c6);
		g2.getCoches().add(c7);
		g2.getCoches().add(c8);
		
		g3.getCoches().add(c9);
		g3.getCoches().add(c10);
		g3.getCoches().add(c11);
		g3.getCoches().add(c12);
		
		
		ArrayList<Garaje> garajes1 = new ArrayList<Garaje>();
		garajes1.add(g1);
		garajes1.add(g2);
		garajes1.add(g3);
		
		ArrayList<Garaje> garajes2 = new ArrayList<Garaje>();
		garajes2.add(g1);
		
		Torneo t1 = new Torneo("T1",garajes1);
		Torneo t2 = new Torneo("T2",garajes2);
		
		
		Eliminacion e1 = new Eliminacion("Eliminacion1",t2,7);
		Eliminacion e2 = new Eliminacion("Eliminacion2",t1);
		
		for(Coche coche:e1.getCoches()) {
			System.out.println(coche);
		}
		
		Estandar es1 = new Estandar("Estandar 1",t2);//Dura tres horas porque no se ha indicado
		
		System.out.println("Eliminacion1");
		for(Coche c : e1.getCoches()) {
			System.out.println(c.getMarca());
		}
		
		System.out.println("Eliminacion2");
		for(Coche c : e2.getCoches()) {
			System.out.println(c.getMarca());
		}
		

		System.out.println("\n*****************CARRERA ELIMINACIÓN***********************");
		e1.carrera();
		
		for(int i=0; i<e1.getCoches().size();i++) {
			int posicionPodio=(e1.getCoches().indexOf(e1.getCoches().get(i)))+1;
			System.out.print("\nPOSICIÓN : "+posicionPodio);
			System.out.println(e1.getCoches().get(i));	
		}
		
//		for(int i=0; i<e1.cochesParaPodio.size();i++) {
//			int posicionPodio=(e1.cochesParaPodio.indexOf(e1.cochesParaPodio.get(i)))+1;
//			System.out.print("\nPOSICIÓN COCHES PARA PODIO: "+posicionPodio);
//			System.out.println(e1.cochesParaPodio.get(i));	
//		}
		
		for (Map.Entry<Coche, Integer> entry : e1.getPodio().entrySet()) {	
			Coche coche = entry.getKey();
			int posicion=entry.getValue();
			System.out.print("\nPOSICIÓN PODIO "+posicion);
			System.out.println(coche);
					
	}
		
		System.out.println("\n*****************CARRERA ESTÁNADR***********************");
		es1.carrera();
		
//		es1.getCoches().get(0).setDistanciaRecorrida(5000);
//		es1.getCoches().get(1).setDistanciaRecorrida(5000);
//		es1.getCoches().get(2).setDistanciaRecorrida(300);
//		es1.getCoches().get(3).setDistanciaRecorrida(300);
//		es1.getCoches().get(4).setDistanciaRecorrida(200);
//		
//		es1.addCochesPodio();
		
//		for(int i=0; i<es1.getCoches().size();i++) {
//		int posicionPodio=(es1.getCoches().indexOf(es1.getCoches().get(i)))+1;
//		System.out.print("\nPOSICIÓN: "+posicionPodio);
//		System.out.println(es1.getCoches().get(i));	
//	}
		
		for (Map.Entry<Coche, Integer> entry : es1.getPodio().entrySet()) {	
				Coche coche = entry.getKey();
				int posicion=entry.getValue();
				System.out.print("\nPOSICIÓN PODIO "+posicion);
				System.out.println(coche);
						
		}
		
		
			
		
		
//		for(int i=0; i<es1.getCochesAlReves().size();i++) {
//			int posicionPodio=(es1.getCochesAlReves().indexOf(es1.getCochesAlReves().get(i)))+1;
//			System.out.print("\nPOSICIÓN  AL REVÉS: "+posicionPodio);
//			System.out.println(es1.getCochesAlReves().get(i));	
//		}
		
//		for(int i=0; i<es1.getPodio().size();i++) {
//			int posicionPodio=(es1.getPodio().indexOf(es1.getPodio().get(i)))+1;
//			System.out.print("\nPOSICIÓN PODIO: "+posicionPodio);
//			System.out.println(es1.getPodio().get(i));
//			
//		}

	}
	

}
