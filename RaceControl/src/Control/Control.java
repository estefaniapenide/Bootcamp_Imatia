package Control;

import java.util.ArrayList;

import POO.Coche;
import POO.Eliminacion;
import POO.Estandar;
import POO.Garaje;

public class Control {

	public static void main(String[] args) {
		
		//Pruebas
		
		Garaje g1 = new Garaje("1");
		Garaje g2 = new Garaje("2");
		Garaje g3 = new Garaje("3");
		
		Coche c1 = new Coche("uno");
		Coche c2 = new Coche("dos");
		Coche c3 = new Coche("tres");
		Coche c4 = new Coche("cuatro");
		c1.setGaraje(g1);
		c2.setGaraje(g1);
		c3.setGaraje(g1);
		c4.setGaraje(g1);
		
		Coche c5 = new Coche("a");
		Coche c6 = new Coche("b");
		Coche c7 = new Coche("c");
		Coche c8 = new Coche("d");
		c5.setGaraje(g2);
		c6.setGaraje(g2);
		c7.setGaraje(g2);
		c8.setGaraje(g2);
		
		Coche c9 = new Coche("alfa");
		Coche c10 = new Coche("beta");
		Coche c11 = new Coche("gamma");
		Coche c12 = new Coche("delta");
		c9.setGaraje(g3);
		c10.setGaraje(g3);
		c11.setGaraje(g3);
		c12.setGaraje(g3);
		
		g1.getCoches().add(c1);
		g1.getCoches().add(c2);
		g1.getCoches().add(c3);
		g1.getCoches().add(c4);
		
		g2.getCoches().add(c5);
		g2.getCoches().add(c6);
		g2.getCoches().add(c7);
		g2.getCoches().add(c8);
		
		g3.getCoches().add(c9);
		g3.getCoches().add(c10);
		g3.getCoches().add(c11);
		g3.getCoches().add(c12);
		
		System.out.println(c1.compareTo(c12));
		
		ArrayList<Garaje> garajes = new ArrayList<Garaje>();
		garajes.add(g2);
		garajes.add(g3);
		
		Eliminacion e1 = new Eliminacion("Eliminacion1",g1,7);
		Eliminacion e2 = new Eliminacion("Eliminacion2",garajes);
		
		Estandar es1 = new Estandar("Estandar 1",g1);//Dura tres horas porque no se ha indicado
		
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
			System.out.print("\nPOSICIÓN PODIO: "+posicionPodio);
			System.out.println(e1.getCoches().get(i));	
		}
		
//		for(int i=0; i<e1.getPodio().size();i++) {
//			int posicionPodio=(e1.getPodio().indexOf(e1.getPodio().get(i)))+1;
//			System.out.print("\nPOSICIÓN PODIO: "+posicionPodio);
//			System.out.println(e1.getPodio().get(i));
//			
//		}
		
//		System.out.println("\n*****************CARRERA ESTÁNADR***********************");
//		es1.carrera();
//		for(int i=0; i<es1.getPodio().size();i++) {
//			int posicionPodio=(es1.getPodio().indexOf(es1.getPodio().get(i)))+1;
//			System.out.print("\nPOSICIÓN PODIO: "+posicionPodio);
//			System.out.println(es1.getPodio().get(i));
//			
//		}

	}

}
