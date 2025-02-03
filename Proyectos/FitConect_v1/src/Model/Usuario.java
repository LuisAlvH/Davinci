package Model;

public class Usuario {

	private int idUsuario;
	private String usser;
	private String pass;
	private int tipoUsuario;
	private int idDatosPersonales;

	public Usuario() {
		super();
		this.idUsuario = -1;
		this.usser = "";
		this.pass = "";
		this.tipoUsuario = -1;
		this.idDatosPersonales = -1;
	}

	public Usuario(String usser, String pass, int idDatosPersonales) {
		super();
		this.idUsuario = -1;
		this.usser = usser;
		this.pass = pass;
		this.tipoUsuario = 1;
		this.idDatosPersonales = idDatosPersonales;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getIdDatosPersonales() {
		return idDatosPersonales;
	}

	public void setIdDatosPersonales(int idDatosPersonales) {
		this.idDatosPersonales = idDatosPersonales;
	}

}
