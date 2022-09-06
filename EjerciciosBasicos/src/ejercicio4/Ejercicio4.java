package ejercicio4;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		int suma = 1+2+3+4+5;
		System.out.println("Suma de los 5 primeros números: " + suma);
		
		int sumaPares = 2+4+6+8+10+12+14+16+18+20+22+24+26+28+30+32+34+36+38+40;
		System.out.println("Suma de los 20 primeros números pares: " + sumaPares);
		
		//Metodo recursivo
		/*int facR (int n){
	        int resultado;
	        if (n==1) return 1;
	        resultado=facR(n-1)*n;
	        return resultado;
	    }*/
		
		suma();
		sumapares();
		factorial(1);
		factorial(7);

	}

	public static void suma() {

		int suma = 0;
		for (int i = 0; i <= 5; i++) {
			suma = suma + i;
		}
		System.out.println("Suma de los 5 primeros números: " + suma);
	}
	

	public static void sumapares() {
		
		int cont=0;
		int num=0;
		int suma = 0;
		
		while(cont<20) {		
			num++;;		
			if(num%2==0) {
				suma = suma + num;
				cont++;
			}
		}

		System.out.println("Suma de los 20 primeros números pares: " + suma);

	}
	
	public static void factorial(int num) {
		
		int factorial = 1;
		for(int i=1; i<=num; i++) {
			if(num>1) {
				factorial=factorial*i;
			
			}else {
				factorial=0;
			}			
		}
		
		System.out.println(num+"!="+factorial);
	}

}
