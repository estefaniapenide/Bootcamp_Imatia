package ejercicio6;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ejercicio6 {

	public static void main(String[] args) {

		LocalDateTime hoy = LocalDateTime.now();

		int dia = hoy.getDayOfMonth();
		int mes = hoy.getMonthValue();
		
		int hora = hoy.getHour();
		
		System.out.println("DÍA: "+hoy.getDayOfMonth()+"/"+hoy.getMonthValue()+"/"+hoy.getYear());
		System.out.println("HORA: "+hoy.getHour()+":"+hoy.getMinute());
		
		estacion(mes,dia);
		hora(hora);

	}

	public static void estacion(int mes, int dia) {

		switch (mes) {
		case 1, 2:
			System.out.println("Es INVIERNO");
			break;
		case 3:
			estacionSegunDia(dia,"INVIERNO","PRIMAVERA");
			break;
		case 4, 5:
			System.out.println("Es PRIMAVERA");
			break;
		case 6:
			estacionSegunDia(dia,"PRIMAVERA","VERANO");
			break;
		case 7, 8:
			System.out.println("Es VERANO");
			break;
		case 9:
			estacionSegunDia(dia,"VERANO","OTOÑO");
			break;
		case 10, 11:
			System.out.println("Es OTOÑO");
		case 12:
			estacionSegunDia(dia,"OTOÑO","INVIERNO");
			break;
		default:
			System.out.println("No estamos en ninguna estación");
		}
	}
	
	public static void estacionSegunDia(int dia, String estacionAnterior, String estacionSiguiente) {
		switch (dia) {
		case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20:
			System.out.println("Es "+estacionAnterior);
			break;
		case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31:
			System.out.println("Es "+estacionSiguiente);
			break;
		}
	}

	public static void hora(int hora) {

		switch (hora) {

		case 6,7,8,9,10,11,12,13,14:
			System.out.println("Es por la MAÑANA");
			break;
		case 15,16,17,18,19,20,21:
			System.out.println("Es por la TARDE");
			break;
		case 22,23,0,1,2,3,4,5:
			System.out.println("Es por la NOCHE");
			break;
		default:
			System.out.println("No es ninguna parte del día.");

		}
	}

}
