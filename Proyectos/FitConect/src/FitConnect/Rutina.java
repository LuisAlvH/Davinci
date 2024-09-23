package FitConnect;

import java.util.ArrayList;

public class Rutina {

	private String tituloRutina;
	private String dificultad;
	private String nivelDePopularidad;
	private int pointsPopularidadRutina;
	private ArrayList<Ejercicio> listaEjercicios = new ArrayList<Ejercicio>();
	private int descansoEntreEjercicio;
	private int pointsDeProgreso;
	private String Actividad;
	private ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
	private String usuarioCreador;
	private String compartida;

	public Rutina(String tituloRutina, String dificultad, String nivelDePopularidad, int pointsPopularidadRutina,
			int descansoEntreEjercicio, int pointsDeProgreso, String actividad, String usuarioCreador,
			String compartidad) {
		super();
		this.tituloRutina = tituloRutina;
		this.dificultad = dificultad;
		this.nivelDePopularidad = nivelDePopularidad;
		this.pointsPopularidadRutina = pointsPopularidadRutina;
		this.descansoEntreEjercicio = descansoEntreEjercicio;
		this.pointsDeProgreso = pointsDeProgreso;
		Actividad = actividad;
		this.usuarioCreador = usuarioCreador;
		this.compartida = compartidad;
	}

	public String getTituloRutina() {
		return tituloRutina;
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

	public String getNivelDePopularidad() {
		return nivelDePopularidad;
	}

	public void setNivelDePopularidad(String nivelDePopularidad) {
		this.nivelDePopularidad = nivelDePopularidad;
	}

	public int getPointsPopularidadRutina() {
		return pointsPopularidadRutina;
	}

	public void setPointsPopularidadRutina(int pointsPopularidadRutina) {
		this.pointsPopularidadRutina = pointsPopularidadRutina;
	}

	public ArrayList<Ejercicio> getListaEjercicios() {
		return listaEjercicios;
	}

	public void setListaEjercicios(ArrayList<Ejercicio> listaEjercicios) {
		this.listaEjercicios = listaEjercicios;
	}

	public int getDescansoEntreEjercicio() {
		return descansoEntreEjercicio;
	}

	public void setDescansoEntreEjercicio(int descansoEntreEjercicio) {
		this.descansoEntreEjercicio = descansoEntreEjercicio;
	}

	public int getPointsDeProgreso() {
		return pointsDeProgreso;
	}

	public void setPointsDeProgreso(int pointsDeProgreso) {
		this.pointsDeProgreso = pointsDeProgreso;
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	public ArrayList<Comentario> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public String getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(String usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public void GuardarEjercicio(Ejercicio ejercicio) {

		this.listaEjercicios.add(ejercicio);

	}

	public void GuardarComentario(Comentario comentario) {

		this.listaComentarios.add(comentario);

	}

	public String getCompartida() {
		return compartida;
	}

	public void setCompartida(String compartida) {
		compartida = compartida;
	}

	public void mostrarRutina() {

		System.out.println("\n Titulo:  " + tituloRutina + "\n Dificultad: " + dificultad + "\n Popularidad:"
				+ nivelDePopularidad + "\n Descanso entre ejercicio: " + descansoEntreEjercicio + " segundos"
				+ "\n Actividad deportiva :" + Actividad + "\n Cantidad ejercicios: " + listaEjercicios.size());

	}

	private void mostrarEjercicios() {

		System.out.println("\n\t Lista de Ejercicios");
		for (Ejercicio ejerc : listaEjercicios) {
			ejerc.mostrarEjercicio();
		}

	}

}