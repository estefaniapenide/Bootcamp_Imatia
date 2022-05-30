package Ejercicio14;

public class Doctor extends Personas{
	
	private int numColegiado;
	private String especializacion;
	
	public Doctor() {
		super();
	}
	
	

	public Doctor(int numColegiado, String especializacion) {
		super();
		this.numColegiado = numColegiado;
		this.especializacion = especializacion;
	}



	public int getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(int numColegiado) {
		this.numColegiado = numColegiado;
	}


	public String getEspecializacion() {
		return especializacion;
	}
	
	public void setEspecialización(String especializacion) {
		this.especializacion = especializacion;
	}


	@Override
	public String toString() {
		return "Doctor [Especialización=" + especializacion + "Número de colegiados=" + numColegiado+ ", Dni=" + getDni() + ", Nombre=" + getNombre()
				+ ", Apellidos=" + getApellidos() + ", FechaNacimeinto=" + getFechaNacimeinto()
				+ ", Peso=" + getPeso() + "]";
	}

}
