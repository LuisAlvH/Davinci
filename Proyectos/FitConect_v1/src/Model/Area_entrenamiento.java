package Model;

public class Area_entrenamiento {

	private int id_area;
	private String espacio;
	private String barrio;
	private String direccion;

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public Area_entrenamiento() {
		super();
		this.id_area = 0;
		this.espacio = "Vacio";
		this.barrio = "Vacio";
		this.direccion = "Vacio";
	}

}
