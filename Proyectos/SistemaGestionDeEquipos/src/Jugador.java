
public class Jugador extends Persona{

	

	private String posicion;
	private int numCamiseta;
	
	
	
////CONSTRUCTOR
	public Jugador(String nombre, int edad, String posicion, int numCamiseta) {
		super(nombre, edad);
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



///TO STRING

	@Override
	public String toString() {
		return "Jugador [Posicion=" + posicion + ", Camiseta=" + numCamiseta + ", Nombre=" + getNombre()
				+ ", Edad=" + getEdad() + "]";
	}




	
	


	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
