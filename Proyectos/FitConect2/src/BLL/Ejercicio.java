package BLL;

public class Ejercicio {
	private int id_ejercicio;
	private String nombre;
	private int serie;
	private int repeticiones;
	private int descansoEntreSerie;
	private double pointDeProgreso;

	public Ejercicio(String nombre, int serie, int repeticiones, int descansoEntreSerie, double pointDeProgreso) {
		super();
		this.nombre = nombre;
		this.serie = serie;
		this.repeticiones = repeticiones;
		this.descansoEntreSerie = descansoEntreSerie;
		this.pointDeProgreso = pointDeProgreso;
		id_ejercicio = 0;
	}

	public Ejercicio(String nombre, int serie, int repeticiones, int descansoEntreSerie, int id_ejercicio) {
		super();
		this.nombre = nombre;
		this.serie = serie;
		this.repeticiones = repeticiones;
		this.descansoEntreSerie = descansoEntreSerie;
		this.pointDeProgreso = 0;
		this.id_ejercicio = id_ejercicio;
	}


	public int getId_ejercicio() {
		return id_ejercicio;
	}

	public void setId_ejercicio(int id_ejercicio) {
		this.id_ejercicio = id_ejercicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getDescansoEntreSerie() {
		return descansoEntreSerie;
	}

	public void setDescansoEntreSerie(int descansoEntreSerie) {
		this.descansoEntreSerie = descansoEntreSerie;
	}

	public double getPointDeProgreso() {
		return pointDeProgreso;
	}

	public void setPointDeProgreso(double pointDeProgreso) {
		this.pointDeProgreso = pointDeProgreso;
	}

}
