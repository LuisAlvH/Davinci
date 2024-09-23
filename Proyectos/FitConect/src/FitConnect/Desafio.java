package FitConnect;

import java.time.LocalDate;
import java.util.ArrayList;

public class Desafio {
	private String titulo;
	private Objetivo objetivoDesafio;
	private String nivelDesafio;
	private int puntosPopularidadPremio;
	private ArrayList<Ejercicio> listaEjercicios = new ArrayList<Ejercicio>();
	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	private String usuarioCreador;

	public Desafio(String titulo, Objetivo objetivoDesafio, String nivelDesafio, int puntosPopularidadPremio,
			LocalDate fechaInicio, LocalDate fechaFinalizacion, String usuarioCreador) {
		super();
		this.titulo = titulo;
		this.objetivoDesafio = objetivoDesafio;
		this.nivelDesafio = nivelDesafio;
		this.puntosPopularidadPremio = puntosPopularidadPremio;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.usuarioCreador = usuarioCreador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Objetivo getObjetivoDesafio() {
		return objetivoDesafio;
	}

	public void setObjetivoDesafio(Objetivo objetivoDesafio) {
		this.objetivoDesafio = objetivoDesafio;
	}

	public String getNivelDesafio() {
		return nivelDesafio;
	}

	public void setNivelDesafio(String nivelDesafio) {
		this.nivelDesafio = nivelDesafio;
	}

	public int getPuntosPopularidadPremio() {
		return puntosPopularidadPremio;
	}

	public void setPuntosPopularidadPremio(int puntosPopularidadPremio) {
		this.puntosPopularidadPremio = puntosPopularidadPremio;
	}

	public ArrayList<Ejercicio> getListaEjercicios() {
		return listaEjercicios;
	}

	public void setListaEjercicios(ArrayList<Ejercicio> listaEjercicios) {
		this.listaEjercicios = listaEjercicios;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(String usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

}
