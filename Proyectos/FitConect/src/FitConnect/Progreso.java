package FitConnect;

public class Progreso {

	private double porcentajeProgreso;
	private int pointDeProgreso;
	private int pointMaxProgre;

	public Progreso(double porcentajeProgreso, int pointDeProgreso, int pointMaxProgre) {
		super();
		this.porcentajeProgreso = porcentajeProgreso;
		this.pointDeProgreso = pointDeProgreso;
		this.pointMaxProgre = pointMaxProgre;
	}

	public double getPorcentajeProgreso() {
		return porcentajeProgreso;
	}

	public void setPorcentajeProgreso(double porcentajeProgreso) {
		this.porcentajeProgreso = porcentajeProgreso;
	}

	public int getPointDeProgreso() {
		return pointDeProgreso;
	}

	public void setPointDeProgreso(int pointDeProgreso) {
		this.pointDeProgreso = pointDeProgreso;
	}

	public int getPointMaxProgre() {
		return pointMaxProgre;
	}

	public void setPointMaxProgre(int pointMaxProgre) {
		this.pointMaxProgre = pointMaxProgre;
	}

}
