package ejercicio47;

public class PersonaJava8 {
	
	private String nombre;
	private String apellidos;
	
	
	public PersonaJava8() {}

	public PersonaJava8(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
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
	};

}
