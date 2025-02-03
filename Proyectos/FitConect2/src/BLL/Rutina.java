package BLL;

import java.util.ArrayList;

import DLL.ControllerRutina;

public class Rutina {


	private int id_rutina;
	private String tituloRutina;
	private String dificultad;
	private double popularidadRutina;
	private int puntos_progreso;
	private String Actividad_deportiva;
	private String usuarioCreador;
	private int compartida;

	public Rutina(String tituloRutina, String dificultad, double popularidadRutina, int puntos_progreso,
			String actividad_deportiva, String usuarioCreador, int compartida) {
		super();
		this.tituloRutina = tituloRutina;
		this.dificultad = dificultad;
		this.popularidadRutina = popularidadRutina;
		this.puntos_progreso = puntos_progreso;
		Actividad_deportiva = actividad_deportiva;
		this.usuarioCreador = usuarioCreador;
		this.compartida = compartida;
	}
	
	public Rutina(String tituloRutina, String dificultad, double popularidadRutina,
			String actividad_deportiva, String usuarioCreador) {
		super();
		this.tituloRutina = tituloRutina;
		this.dificultad = dificultad;
		this.popularidadRutina = popularidadRutina;
		this.puntos_progreso = 0;
		Actividad_deportiva = actividad_deportiva;
		this.usuarioCreador = usuarioCreador;
		this.compartida = 0;
	}
	public Rutina(String tituloRutina, String dificultad, int popularidad_rutina,
			String actividad_deportiva, String usuarioCreador,int id_rutina ) {
		super();
		this.id_rutina=id_rutina;
		this.tituloRutina = tituloRutina;
		this.dificultad = dificultad;
		this.popularidadRutina = popularidad_rutina;
		this.puntos_progreso = 0;
		Actividad_deportiva = actividad_deportiva;
		this.usuarioCreador = usuarioCreador;
		this.compartida = 0;
	}

	public Rutina(String tituloRutina, String dificultad,
			String actividad_deportiva, int popularidad_rutina,int id_rutina) {
		super();
		this.tituloRutina = tituloRutina;
		this.dificultad = dificultad;
		this.popularidadRutina =popularidad_rutina ;
		this.puntos_progreso = 0;
		Actividad_deportiva = actividad_deportiva;
		this.usuarioCreador = "";
		this.compartida = 0;
		this.id_rutina=id_rutina;
	}

	public String getTituloRutina() {
		return tituloRutina;
	}

	public int getId_rutina() {
		return id_rutina;
	}

	public void setId_rutina(int id_rutina) {
		this.id_rutina = id_rutina;
	}

	public void setTituloRutina(String tituloRutina) {
		this.tituloRutina = tituloRutina;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public double getPopularidadRutina() {
		return popularidadRutina;
	}

	public void setPopularidadRutina(double popularidadRutina) {
		this.popularidadRutina = popularidadRutina;
	}

	public int getPuntos_progreso() {
		return puntos_progreso;
	}

	public void setPuntos_progreso(int puntos_progreso) {
		this.puntos_progreso = puntos_progreso;
	}

	public String getActividad_deportiva() {
		return Actividad_deportiva;
	}

	public void setActividad_deportiva(String actividad_deportiva) {
		Actividad_deportiva = actividad_deportiva;
	}

	public String getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(String usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public int getCompartida() {
		return compartida;
	}

	public void setCompartida(int compartida) {
		this.compartida = compartida;
	}
	
	@Override
	public String toString() {
		return "Titulo:" + tituloRutina + "\tDificultad:" + dificultad + "\tActividad:"
				+ Actividad_deportiva + "\tCreador:" + usuarioCreador ;
	}

	public static Rutina obteniendoRutina(int id_rutina) {
		
		 return ControllerRutina.obtenerInformacionDeRutina(id_rutina);
	}
	
}