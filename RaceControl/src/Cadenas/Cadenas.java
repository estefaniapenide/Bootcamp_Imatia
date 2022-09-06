package Cadenas;

public class Cadenas {

	public static void menuPrincipal() {
		System.out.println("\n*********************** RACE CONTROL ************************\n" + "\n1.-TORNEOS"
				+ "\n2.-GARAJES" + "\n\n0.-SALIR");
	}

	public static void menuTorneos() {
		System.out.println("\n*********************** TORNEOS ************************\n" + "\n1.-CREAR TORNEO"
				+ "\n2.-EMPEZAR/REANUDAR TORNEO" + "\n3.-CONSULTAR TORNEOS" + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
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
		System.out.println("\n\tGARAJES QUE PARTICIPAN EN EL TORNEO " + nombreTorneo.toUpperCase());

	}

	public static void menuAddGaraje() {
		System.out.println("\nAÑADIR GARAJE:" + "\n1.-SI" + "\n2.-NO");
	}

	public static void nombreGaraje() {
		System.out.println("\nNOMBRE DEL GARAJE: ");

	}

	public static void imposibleAddGaraje() {
		System.out.println("\nNO ES POSIBLE AÑADIR EL GARAJE");
	}

	public static void noExisteGaraje() {
		System.out.println("EL GARAJE NO EXISTE");
	}
	
	public static void ExisteGaraje() {
		System.out.println("EL GARAJE YA EXISTE");
		
	}

	public static void garajeYaTorneo() {
		System.out.println("EL GARAJE YA ESTÁ INSCRITO EN EL TORNEO");

	}

	public static void garajeAdded() {
		System.out.println("GARAJE AÑADIDO");

	}

	public static void numCarrerasEstandar() {
		System.out.println("\nNÚMERO DE CARRERAS ESTÁNDAR: ");

	}

	public static void numCarrerasEliminacion() {
		System.out.println("\nNÚMERO DE CARRERAS DE ELIMINACIÓN: ");

	}

	public static void torneoNoCreado() {
		System.out.println("\nAL NO AÑADIR NINGÚN GARAJE NO SE HA CREADO EL TORNEO");

	}

	public static void menuNumCarreras() {
		System.out.println("\nNÚMERO DE CARRERAS:" + "\n1.-DEFAULT (10 CARRERAS)" + "\n2.-INDICAR OTRO NÚMERO");

	}
	
	public static void numCarreras() {
		System.out.println("\nNÚMERO DE CARRERAS:");

	}

	public static void torneoCreado() {
		System.out.println("\nTORNEO CREADO");
		
	}

	public static void menuGarajes() {
		System.out.println("\n*********************** GARAJES ************************\n" + "\n1.-CREAR GARAJE"+
				"\n2.-CONSULTAR GARAJES" + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
	}

	public static void menuAddCoches() {
		System.out.println("\nAÑADIR COCHE:" + "\n1.-SI" + "\n2.-NO");
		
	}

	public static void menuTipoCarreras() {
		System.out.println("\nTIPO DE CARRERAS:\n" + "\n1.-CARRERAS ESTÁNDAR"+
				"\n2.-CARRERAS ELIMINACIÓN");
		
	}

	public static void carrerasAdded() {
		System.out.println("CARRERAS AÑADIDAS");
		
	}

	public static void nuevoCoche() {
		System.out.println("NUEVO COCHE");
		
	}

	public static void marca() {
		System.out.println("\nMARCA:");
		
	}
	
	public static void modelo() {
		System.out.println("\nMODELO:");
		
	}

	
		
	

}
