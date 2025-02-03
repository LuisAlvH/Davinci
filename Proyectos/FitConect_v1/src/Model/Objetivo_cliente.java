package Model;

import java.time.LocalDate;

public class Objetivo_cliente {

	private String tipo_objetivo;
	private LocalDate fecha_inicial;
	private float progreso;
	private int id_objetivo;

	public int getId_objetivo() {
		return id_objetivo;
	}

	public void setId_objetivo(int id_objetivo) {
		this.id_objetivo = id_objetivo;
	}

	public String getTipo_objetivo() {
		return tipo_objetivo;
	}

	public void setTipo_objetivo(String tipo_objetivo) {
		this.tipo_objetivo = tipo_objetivo;
	}

	public LocalDate getFecha_inicial() {
		return fecha_inicial;
	}

	public void setFecha_inicial(LocalDate fecha_inicial) {
		this.fecha_inicial = fecha_inicial;
	}

	public float getProgreso() {
		return progreso;
	}

	public void setProgreso(float f) {
		this.progreso = f;
	}

	public Objetivo_cliente() {
		super();
		this.tipo_objetivo = "Vacio";
		this.fecha_inicial = null;
		this.progreso = 0;
		this.id_objetivo = 0;
	}

}
