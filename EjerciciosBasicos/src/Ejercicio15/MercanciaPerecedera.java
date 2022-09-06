package Ejercicio15;

import java.time.LocalDate;

public class MercanciaPerecedera extends Mercancia {

	private LocalDate fechaCaducidad;

	public MercanciaPerecedera() {
		super();
	}

	public MercanciaPerecedera(int id, String nombre, String responsable, String zona, String area, String estanteria,
			int cantidad, LocalDate fechaCaducidad) {
		super(id, nombre, responsable, zona, area, estanteria, cantidad);
		this.fechaCaducidad = fechaCaducidad;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	@Override
	public String toString() {
		String MercanciaPerecedera=super.toString()+"\nFECHA CADUCIDAD: "+this.fechaCaducidad;
		return MercanciaPerecedera;
	}

}
