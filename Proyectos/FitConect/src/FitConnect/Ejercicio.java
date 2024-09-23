package FitConnect;

public class Ejercicio {
	private String nombre;
	private int serie;
	private int repeticiones;
	private int descansoEntreSerie;
	private int pointDeProgreso;

	public Ejercicio(String nombre, int serie, int repeticiones, int descansoEntreSerie, int pointDeProgreso) {
		super();
		this.nombre = nombre;
		this.serie = serie;
		this.repeticiones = repeticiones;
		this.descansoEntreSerie = descansoEntreSerie;
		this.pointDeProgreso = pointDeProgreso;
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

	public int getPointDeProgreso() {
		return pointDeProgreso;
	}

	public void setPointDeProgreso(int pointDeProgreso) {
		this.pointDeProgreso = pointDeProgreso;
	}

	public void mostrarEjercicio() {

		System.out.println("\n Nombre:  " + nombre + "\n Series: " + serie + "\n Repeticiones:" + repeticiones
				+ "\nDescanso entre serie: " + descansoEntreSerie);

	}

}
