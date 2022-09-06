package Ejercicio14;

import java.time.LocalDate;

public class Personas {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimeinto;
	private int peso;

	public Personas() {}
	
	public Personas(String dni, String nombre, String apellidos, LocalDate fechaNacimeinto, int peso) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimeinto = fechaNacimeinto;
		this.peso = peso;
	}
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimeinto() {
		return fechaNacimeinto;
	}

	public void setFechaNacimeinto(LocalDate fechaNacimeinto) {
		this.fechaNacimeinto = fechaNacimeinto;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}


	@Override
	public String toString() {
		return "Personas [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimeinto="
				+ fechaNacimeinto + ", peso=" + peso + "]";
	}

}
