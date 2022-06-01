package Cadenas;

public class Cadenas {

	public static void menuPrincipal() {
		System.out.println("*********************** RACE CONTROL ************************\n" + "\n1.-TORNEOS"
				+ "\n2.-GARAJES" + "\n3.-COCHES" + "\n\n0.-SALIR");
	}

	public static void menuTorneos() {
		System.out.println("*********************** TORNEOS ************************\n" + "\n1.-NUEVO TORNEO"
				+ "\n2.-REANUDAR TORNEO"+ "\n3.-CONSULTAR TORNEOS" + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
	}

	public static void mensajeDefault() {
		System.out.println("\nNO HA INTRODUCIDO NINGUNA DE LAS OPCIONES");
		
	}

	public static void fin() {
		System.out.println("\nPROGRAMA FINALIZADO");
		
	}

	public static void vueltaMenu() {
		System.out.println("\nVOLVIENDO AL MENÚ ANTERIOR...");
		
	}

	public static void nombreTorneo() {
		System.out.println("\nNOMBRE DEL TORNEO: ");
		
	}

	public static void existeTorneo() {
		System.out.println("\nEL TORNEO YA EXISTE");
		
	}

	public static void garajesTorneo(String nombreTorneo) {
		System.out.println("\n\tGARAJES QUE PARTICIPAN EN EL TORNEO "+nombreTorneo.toUpperCase());
		
	}
	
	public static void menuAddGaraje() {
		System.out.println("AÑADIR GARAJE:"+"\n1.-SI"+"\n2.-NO");
	}

}
