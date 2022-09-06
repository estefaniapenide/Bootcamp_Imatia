package Ejercicio14;

public class Profesor extends Personas{
	
	private int numAlumnos;
	private String titulacion;
	
	public Profesor() {
		super();
	}
	
	public Profesor(int numAlumnos, String titulacion) {
		super();
		this.numAlumnos = numAlumnos;
		this.titulacion = titulacion;
	}

	
	public int getNumAlumnos() {
		return numAlumnos;
	}


	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}


	@Override
	public String toString() {
		return "Profesor [Titilación=" + titulacion + "Número de alumnos=" + numAlumnos+ ", Dni=" + getDni() + ", Nombre=" + getNombre()
				+ ", Apellidos=" + getApellidos() + ", FechaNacimeinto=" + getFechaNacimeinto()
				+ ", Peso=" + getPeso() + "]";
	}
}
