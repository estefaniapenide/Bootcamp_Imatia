package Ejercicio11;

public class ControlRemoto {

	private int canal;
	private int volumen;
	private boolean encendido;

	public ControlRemoto() {
	}

	public ControlRemoto(int canal, int volumen, boolean encendido) {
		this.canal = canal;
		this.volumen = volumen;
		this.encendido = encendido;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	public void aumentarCanal() {
		this.canal++;
	}

	public void disminuirCanal() {
		this.canal--;
	}

	public void subirVolumen() {
		this.volumen++;
	}

	public void bajarVolumen() {
		this.volumen--;
	}

	public void encender() {
		this.encendido = true;
	}

	public void apagar() {
		this.encendido = false;
	}

	@Override
	public String toString() {
		String estado = "";
		if (this.encendido == true) {
			estado = "ENCENDIDO";
		} else if (this.encendido == false) {
			estado = "APAGADO";
		}
		String controlRemoto = "\nCANAL: " + this.canal + "\n" + "VOLUMEN: " + this.volumen + "\n" + "ESTADO: "+ estado;
		return controlRemoto;
	}

}
