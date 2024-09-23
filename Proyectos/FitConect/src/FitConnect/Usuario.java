package FitConnect;

public abstract class Usuario implements Menu {

	private String usser;
	private String pass;
	private DatosPersonales datos;
	private String tipo;

	public Usuario(String usser, String pass, DatosPersonales datos, String tipo) {
		super();
		this.usser = usser;
		this.pass = pass;
		this.datos = datos;
		this.tipo = tipo;
	}

	public String getUsser() {
		return usser;
	}

	public void setUsser(String usser) {
		this.usser = usser;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public DatosPersonales getDatos() {
		return datos;
	}

	public void setDatos(DatosPersonales datos) {
		this.datos = datos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	
}
