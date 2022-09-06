package ejercicio50;

import java.util.function.BiConsumer;

public class Calculadora {
	
	private double num1;
	private double num2;
	private Arithmetic<Double,Double,Double> cuenta;
	private BiConsumer<Double,Double> cuentaBiConsumer;
	
	public Calculadora() {}
//	
//	public Calculadora(double num1, double num2, Arithmetic<Double,Double,Double> cuenta) {
//		this.num1=num1;
//		this.num2=num2;
//		this.cuenta=cuenta;	
//	}
//	
//	public Calculadora(double num1, double num2, BiConsumer<Double,Double> cuentaBiConsumer) {
//		this.num1=num1;
//		this.num2=num2;
//		this.cuentaBiConsumer=cuentaBiConsumer;	
//	}
	
	public Calculadora(double num1, double num2, Arithmetic<Double,Double,Double> cuenta,BiConsumer<Double,Double> cuentaBiConsumer) {
		this.num1=num1;
		this.num2=num2;
		this.cuenta=cuenta;	
		this.cuentaBiConsumer=cuentaBiConsumer;	
	}
	
	public double operarConArithmetic() {
		double solucion=cuenta.operacion(num1,num2);
		return solucion;
	}
	
	public void operarConBiConsumer() {
		cuentaBiConsumer.accept(num1,num2);
	}

}
