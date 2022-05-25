package ejercicio2;

public class Circulo {
	
	public static void main(String[] args) {

		double radio = 15;

		double area = area(radio);
		double circunferencia = circuncefencia(radio);

		System.out.println("Círculo de radio " + radio 
				+ "\n\t Circunferencia: " + circunferencia
				+ "\n\t Área: " + area);

	}

	public static double area(double radio) {
		double area = Math.PI * Math.pow(radio, 2);
		return area;
	}

	public static double circuncefencia(double radio) {
		double circunferencia = Math.PI * 2 * radio;
		return circunferencia;
	}

}
