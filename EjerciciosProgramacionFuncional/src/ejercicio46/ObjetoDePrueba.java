package ejercicio46;

import java.time.LocalDate;
import java.util.Date;

public class ObjetoDePrueba {
	
	private int i;
	private String a;
	private LocalDate date;
	
	public ObjetoDePrueba() {}

	public ObjetoDePrueba(int i, String a, LocalDate date) {
		super();
		this.i = i;
		this.a = a;
		this.date = date;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	public String toString() {
		String cadena=i+" "+a+" "+date;
		return cadena;
	}

}
