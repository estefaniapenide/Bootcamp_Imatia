package Ejercicio15;

public class Mercancia {
	
	private int id;
	private String nombre;
	private String responsable;
	private String zona;
	private String area;
	private String estanteria;
	private int cantidad;
	
	public Mercancia() {}
	
	public Mercancia(int id, String nombre, String responsable, String zona, String area, String estanteria, int cantidad) {
		this.id=id;
		this.nombre=nombre;
		this.responsable=responsable;
		this.zona=zona;
		this.area=area;
		this.estanteria=estanteria;
		this.cantidad=cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		String mercancia="\nID: "+this.id
				+"\nNOMBRE: "+this.nombre
				+"\nRESPONSABLE: "+this.responsable
				+"\nZONA: "+this.zona
				+"\n¡REA: "+this.area
				+"\nESTANTERÕA: "+this.estanteria
				+"\nCANTIDAD: "+this.cantidad;
		return mercancia;
	}

}
