 package FitConnect;

import java.time.LocalDate;

public class Objetivo {
	private String tipo;
	private Progreso progreso;
	private LocalDate fechaInicial;
	private String descripcion;
	
	
	
	
	public Objetivo(String tipo,LocalDate fechaInicial ) {
		super();
		this.tipo = tipo;
		this.progreso = null;
		this.fechaInicial = fechaInicial;
		this.descripcion = "vacio";
	}

              

	public Objetivo(String tipo, LocalDate fechaInicial, String descripcion) {
		super();
		this.tipo = tipo;
		this.progreso = new Progreso(0, 0, 0);
		this.fechaInicial = fechaInicial;
		this.descripcion = descripcion;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public Progreso getProgreso() {
		return progreso;
	}




	public void setProgreso(Progreso progreso) {
		this.progreso = progreso;
	}




	public LocalDate getFechaInicial() {
		return fechaInicial;
	}




	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

}
