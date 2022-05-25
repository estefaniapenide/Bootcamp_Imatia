package Ejercicio12;

public class Coche {

	private String marca;
	private String modelo;
	private int velocidadMaxima;
	private String tipoCombustible;
	private int velocimetro;
	private int tacometro;

	public Coche() {
	}

	public Coche(String marca, String modelo, int velocidadMaxima, String tipoCombustible) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
		this.tipoCombustible = tipoCombustible;
	}

	public Coche(String marca, String modelo, int velocidadMaxima, String tipoCombustible, int velocimetro,
			int tacometro) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
		this.tipoCombustible = tipoCombustible;
		this.velocimetro = velocimetro;
		this.tacometro = tacometro;
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

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public int getVelocimetro() {
		return velocimetro;
	}

	public void setVelocimetro(int velocimetro) {
		this.velocimetro = velocimetro;
	}

	public int getTacometro() {
		return tacometro;
	}

	public void setTacometro(int tacometro) {
		this.tacometro = tacometro;
	}

	public void arrancar() {
		if (this.tacometro == 0 && this.velocimetro == 0) {
			this.velocimetro++;
			this.tacometro++;

		}
	}

	public void apagar() {
		this.velocimetro = 0;
		this.tacometro = 0;
	}

	public void acelerar() {
		if (this.velocidadMaxima > this.velocimetro) {
			this.velocimetro++;
		}
	}
	
	public void frenar() {
		if(this.velocimetro>0) {
			this.velocimetro--;
		}
	}
	
	public void girarVolante() {}
	
	public void darMarchaAtras() {}

}
