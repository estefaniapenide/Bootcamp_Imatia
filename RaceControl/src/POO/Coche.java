package POO;

public class Coche {
	
	private String marca;
	private String modelo;
	private final int MAX_VELOCIDAD=300;
	private Garaje garaje;
	private int velocidad;
	private int posicion;
	private int distanciaRecorrida;//Para comprarla con la de los otros coches y saber en qué posición están
	
	public Coche() {}
	
	public Coche(String marca, String modelo, Garaje garaje) {
		this.marca=marca;
		this.modelo=modelo;
		this.garaje=garaje;
		
	}
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Garaje getGaraje() {
		return garaje;
	}

	public void setGaraje(Garaje garaje) {
		this.garaje = garaje;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getMAX_VELOCIDAD() {
		return MAX_VELOCIDAD;
	}

	//Acelera y frena el coche de forma aleatoria una vez por minuto (controlar en la carrera??)
	public void acelerar() {
		this.velocidad+=10;
	}
	
	public void frenar() {
		this.velocidad-=10;
	}

}
