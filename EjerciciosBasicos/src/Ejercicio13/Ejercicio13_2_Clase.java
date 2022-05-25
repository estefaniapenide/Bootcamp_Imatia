package Ejercicio13;

public class Ejercicio13_2_Clase {
	
	private int actualFuel=10;
	
	public void setActualFuel(int actualFuel) {
		if(actualFuel>=0) {
			this.actualFuel=actualFuel;
		}else {
			System.out.println("No es posible introducir valores negativos de actualFuel");
		}
	}
	
	public void showDetails() {
		 System.out.println("La capacidad actual es de "+this.actualFuel+" litros.");
	 }

}
