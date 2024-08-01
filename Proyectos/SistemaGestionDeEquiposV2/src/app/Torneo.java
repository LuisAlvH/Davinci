package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Torneo {

	private ArrayList<Equipo> equipos;
	private ArrayList<Partido> partidosTotales = new ArrayList<Partido>();
	private ArrayList<Partido> partidosSemifinales = new ArrayList<Partido>();
	private ArrayList<Partido> partidoFinal = new ArrayList<Partido>();

	public ArrayList<Partido> getPartidosTotales() {
		return partidosTotales;
	}

	public void setPartidosTotales(ArrayList<Partido> partidosTotales) {
		this.partidosTotales = partidosTotales;
	}

	public ArrayList<Partido> getPartidosSemifinales() {
		return partidosSemifinales;
	}

	public void setPartidosSemifinales(ArrayList<Partido> partidosSemifinales) {
		this.partidosSemifinales = partidosSemifinales;
	}

	public ArrayList<Partido> getPartidoFinal() {
		return partidoFinal;
	}

	public void setPartidoFinal(ArrayList<Partido> partidoFinal) {
		this.partidoFinal = partidoFinal;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public ArrayList<Partido> getPartidos() {
		return partidosTotales;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidosTotales = partidos;
	}

	public Torneo(ArrayList<Equipo> equiposReales) {

		this.equipos = equiposReales;

	}

	public void GenerandoPartidosDeLosEquiposCargados() {

		int CantidadEquipos = equipos.size();
		double CantidadPartidos = CantidadEquipos / 2;
		int numeroRedondeado = (int) Math.ceil(CantidadPartidos);

		for (int i = 0; i < numeroRedondeado; i++) {

			partidosTotales.add(ObteniendoPartido(equipos));

		}

		equipos.clear();
	}

	private static Partido ObteniendoPartido(ArrayList<Equipo> equipos) {

		Equipo equipo1 = SeleccionandoUnEquipoAleatorio(equipos);
		Equipo equipo2 = SeleccionandoUnEquipoAleatorio(equipos);

		return new Partido(equipo1, equipo2);

	}

	private static Equipo SeleccionandoUnEquipoAleatorio(ArrayList<Equipo> equipos) {

		int totalEquipos = equipos.size();

		Equipo auxiliar;

		int seleccionado = (int) (Math.random() * totalEquipos);

		auxiliar = equipos.get(seleccionado);
		equipos.remove(seleccionado);

		return auxiliar;

	}

	public void MostrarFixtureCuartos() {

		String InialPartido = "CUARTOS DE FINAL        \n\n";
		InialPartido += partidosTotales.get(0).InformacionInicialPartido();
		InialPartido += "     ||     ";
		InialPartido += partidosTotales.get(1).InformacionInicialPartido();
		InialPartido += "\n\n";
		InialPartido += partidosTotales.get(2).InformacionInicialPartido();
		InialPartido += "     ||     ";
		InialPartido += partidosTotales.get(3).InformacionInicialPartido();
		JOptionPane.showMessageDialog(null, InialPartido);
	}

	public String MostrarResultadosCuartos() {
		String FinalPartido = "          RESULTADOS : CUARTOS DE FINAL        \n\n";
		FinalPartido += "\n   PARTIDO 1" + "\n";
		FinalPartido += partidosTotales.get(0).InformacionFinalPartido();
		FinalPartido += "\n   PARTIDO 2" + "\n";
		FinalPartido += partidosTotales.get(1).InformacionFinalPartido();
		FinalPartido += "\n   PARTIDO 3" + "\n";
		FinalPartido += partidosTotales.get(2).InformacionFinalPartido();
		FinalPartido += "\n   PARTIDO 4" + "\n";
		FinalPartido += partidosTotales.get(3).InformacionFinalPartido();

		return FinalPartido;

	}

	public void MostrarFixtureSemifinal() {
		String InialPartido = "SEMIFINAL               \n\n";
		InialPartido += partidosSemifinales.get(0).InformacionInicialPartido();
		InialPartido += "     ||     ";
		InialPartido += partidosSemifinales.get(1).InformacionInicialPartido();
		JOptionPane.showMessageDialog(null, InialPartido);

	}

	public String MostrarResultadoSemifinal() {
		String FinalPartido = "          RESULTADOS : SEMIFINAL                \n";
		FinalPartido += "\n   PARTIDO 1" + "\n";
		FinalPartido += partidosSemifinales.get(0).InformacionFinalPartido();
		FinalPartido += "\n   PARTIDO 2" + "\n";
		FinalPartido += partidosSemifinales.get(1).InformacionFinalPartido();

		return FinalPartido;

	}
}
