package BLL;

import java.sql.Date;
import java.time.LocalDate;

public class Objetivo {
	private String tipo_objetivo;
	private LocalDate fechaInicial;
	private float porcent_progreso;

	public Objetivo() {
		super();
		this.tipo_objetivo = " ";
		this.fechaInicial=null;
		this.porcent_progreso = 0.00f;
	}
	
	
	public Objetivo(String tipo_objetivo, LocalDate fechaInicial) {
		super();
		this.tipo_objetivo = tipo_objetivo;
		this.fechaInicial = fechaInicial;
		this.porcent_progreso = 0;
	}


	public String getTipo_objetivo() {
		return tipo_objetivo;
	}

	public void setTipo_objetivo(String tipo_objetivo) {
		this.tipo_objetivo = tipo_objetivo;
	}

	public LocalDate getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public float getPorcent_progreso() {
		return porcent_progreso;
	}

	public void setPorcent_progreso(float porcent_progreso) {
		this.porcent_progreso = porcent_progreso;
	}

}
