package FitConnect;

public class AreaEntrenamiento {
	private String espacio;
	private String barrio;
	private String direccion;
	
	public AreaEntrenamiento(String espacio, String barrio, String direccion) {
		super();
		this.espacio = espacio;
		this.barrio = barrio;
		this.direccion = direccion;
	}
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

	
	

}
