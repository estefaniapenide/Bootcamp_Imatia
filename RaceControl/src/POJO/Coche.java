package POJO;

import org.json.simple.JSONObject;

public class Coche implements Comparable<Coche>{

	private String marca;
	private String modelo;
	
	

	private final int MAX_VELOCIDAD = 300;
//	private Garaje garaje;// cambiar por la pegatina!!!
	private String pegatinaGaraje;
	private int velocidad;
	private int distanciaRecorrida;// Para comprarla con la de los otros coches y saber en qué posición están



	public Coche() {
	}

	public Coche(String marca,String modelo) {
		this.marca = marca;
		this.modelo=modelo;
	}

//	public Coche(String marca, String modelo, Garaje garaje) {
//		this.marca = marca;
//		this.modelo = modelo;
//		this.garaje = garaje;
//
//	}
	
	public Coche(String marca, String modelo, String pegatinaGaraje) {
		this.marca = marca;
		this.modelo = modelo;
		this.pegatinaGaraje = pegatinaGaraje;

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
	
	public void setPegatinaGaraje(String pegatinaGaraje) {
		this.pegatinaGaraje = pegatinaGaraje;
	}
	public String getPegatinaGaraje() {
		return pegatinaGaraje;
	}

//	public Garaje getGaraje() {
//		return garaje;
//	}
//
//	public void setGaraje(Garaje garaje) {
//		this.garaje = garaje;
//	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void setDistanciaRecorrida(int distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}


	public int getMAX_VELOCIDAD() {
		return MAX_VELOCIDAD;
	}


	private void acelerar() {
		int v = (int)( Math.random() * (10-1+10)+1);
		if (this.velocidad+v <= this.MAX_VELOCIDAD) {
			this.velocidad += v;
		}
		this.distanciaRecorrida += this.velocidad / 60;//Aunque no acelere, sigue avanzando a la velocidad que tenía
	}

	private void frenar() {
		int v = (int)( Math.random() * (10-1+10)+1);
		if (this.velocidad-v>=0) {
			this.velocidad -= v;
		}
		this.distanciaRecorrida += this.velocidad / 60;//Aunque no frene, sigue avanzando a la velocidad que tenía
	}

	public void movimiento() {
		int acelera = (int)( Math.random() * (1-0+1)+0);
		switch (acelera) {
		case 1:
			acelerar();
			break;
		case 0:
			frenar();
			break;
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		String coche = "\n\tMARCA: " + this.marca + "\n\tMODELO: " + this.modelo + "\n\tGARAJE: " + this.pegatinaGaraje+"\n\tVELOCIDAD: "+this.velocidad+"\n\tDISTANCIA RECORRIDA: "+this.distanciaRecorrida+"\n";
		return coche;
	}
	
	@Override
	public int compareTo(Coche coche) {
		if(this.distanciaRecorrida>coche.distanciaRecorrida) {
			return -1;
		}else if(this.distanciaRecorrida<coche.distanciaRecorrida) {
			return 1;
		}else {
			return 0;
		}
	}
	

	 @Override//Me tiendo esto se me fastidia el addCochesPodio() //Mejor no hacerlo y ver otra manera de gusradar los cochesParaPodio
	    public boolean equals(Object object) {
		 if(object instanceof Coche) {
			 return ((Coche) object).getMarca().equals(marca) && ((Coche) object).getModelo().equals(modelo);
		 }
		 return super.equals(object);

	    }
	 
	 @Override
	 public int hashCode() {
		 return 1;
	 }
	
	public JSONObject exportarCoche() {//Meterle tambien la pegatina si lo hago de forma que cada vez que guardo un coche le pongo el garaje
		JSONObject obj = new JSONObject();
		obj.put("marca", this.marca);
		obj.put("modelo", this.modelo);
		obj.put("pegatinaGaraje",this.pegatinaGaraje);
		return obj;
	}

}
