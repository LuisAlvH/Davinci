package BLL;

public abstract class Usuario implements Menu {

	private String usser;
	private String pass;
	private int idUsuario;
	

	public Usuario(String usser, String pass,int idUsuario) {
		super();
		this.usser = usser;
		this.pass = pass;
		this.idUsuario=idUsuario;
	
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


	
	
}
