package app;

public class Jugador extends Persona {

	private int id;
	private String posicion;
	private int numCamiseta;
	private static int numeroJugadores = 0;

////CONSTRUCTOR
	public Jugador(String nombre, int edad, String posicion, int numCamiseta) {
		super(nombre, edad);
		this.id = ++numeroJugadores;
		this.posicion = posicion;
		this.numCamiseta = numCamiseta;

	}

////GET AND SET
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getNumCamiseta() {
		return numCamiseta;
	}

	public void setNumCamiseta(int numCamiseta) {
		this.numCamiseta = numCamiseta;
	}

	public static int getNumeroJugadores() {
		return numeroJugadores;
	}

	public static void setNumeroJugadores(int numeroJugadores) {
		Jugador.numeroJugadores = numeroJugadores;
	}

	public String toString() {
		return "Jugador [id=" + id + "Posicion=" + posicion + ", Camiseta=" + numCamiseta + ", Nombre=" + getNombre()
				+ ", Edad=" + getEdad() + "]";
	}

}
