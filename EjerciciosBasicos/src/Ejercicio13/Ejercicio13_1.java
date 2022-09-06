package Ejercicio13;

public class Ejercicio13_1 {
	
	public int actualFuel=10;
	
	
	public void showDetails() {
		 System.out.println("La capacidad actual es de "+this.actualFuel+" litros.");
	 }
	 
	 public static void main(String[] args) {
		 Ejercicio13_1 cO = new Ejercicio13_1();
		 cO.showDetails();
		 System.out.println("Actualización de capacidad");
		 cO.actualFuel=-8;
		 cO.showDetails();
		 
	 }

}
