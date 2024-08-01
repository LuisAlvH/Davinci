package app;

public class Persona {

	private String nombre;
	private int edad;

	//// CONSTRUCTOR
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

////GET AND SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/// TO STRING

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
