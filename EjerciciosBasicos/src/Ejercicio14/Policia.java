package Ejercicio14;

public class Policia extends Personas{
	
	private int numPlaca;
	
	public Policia() {
		super();
	}

	public Policia(int numPlaca) {
		super();
		this.numPlaca = numPlaca;
	}

	@Override
	public String toString() {
		return "Policia [numPlaca=" + numPlaca + ", Dni=" + getDni() + ", Nombre=" + getNombre()
				+ ", Apellidos=" + getApellidos() + ", FechaNacimeinto=" + getFechaNacimeinto()
				+ ", Peso=" + getPeso() + "]";
	}

}
