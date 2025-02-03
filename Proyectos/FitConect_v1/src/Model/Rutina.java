package Model;

public class Rutina {

	private int id_rutina;
	private String titulo;
	private String dificultad;
	private int popularidad_rutina;
	private String actividad_deportiva;
	private String usuario_creador;
	private int compartida;

	public int getId_rutina() {
		return id_rutina;
	}

	public void setId_rutina(int id_rutina) {
		this.id_rutina = id_rutina;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public int getPopularidad_rutina() {
		return popularidad_rutina;
	}

	public void setPopularidad_rutina(int popularidad_rutina) {
		this.popularidad_rutina = popularidad_rutina;
	}

	public String getActividad_deportiva() {
		return actividad_deportiva;
	}

	public void setActividad_deportiva(String actividad_deportiva) {
		this.actividad_deportiva = actividad_deportiva;
	}

	public String getUsuario_creador() {
		return usuario_creador;
	}

	public void setUsuario_creador(String usuario_creador) {
		this.usuario_creador = usuario_creador;
	}

	public int getCompartida() {
		return compartida;
	}

	public void setCompartida(int compartida) {
		this.compartida = compartida;
	}

}
