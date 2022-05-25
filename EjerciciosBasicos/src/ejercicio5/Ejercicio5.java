package ejercicio5;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		negativoPositivo(3);
		negativoPositivo(-3.8f);
		
		multiplo(2,4);
		multiplo(3,4);
		
		menorque(2,5);
		menorque(7,3);
		

	}
	
	public static void negativoPositivo(float num) {
		if (num>0) {
			System.out.println(num+" es POSITIVO");
		}else if (num<0) {
			System.out.println(num+" es NEGATIVO");	
		}else {
			System.out.println(num+" es CERO");	
		}
	}
	
	public static void multiplo(int num, int num2) {
		if(num2%num==0) {
			System.out.println(num2+" es multiplo de "+num);
		}else {
			System.out.println(num2+" NO es multiplo de "+num);
		}
	}
	
	public static void menorque(float num, float num2) {
		if(num<num2) {
			System.out.println(num+" es menor que "+num2);
		}else {
			System.out.println(num+" NO es menor que "+num2);
		}
	}

}
