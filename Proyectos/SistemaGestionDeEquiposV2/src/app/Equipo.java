package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Equipo {

	private int idEquipo;
	private String nombreEquipo;
	private String Ciudad;
	private int eficaciaDeGoles;
	private ArrayList<Jugador> jugadores = new ArrayList<>();
	private static int numeroEquipos = 0;

	/// CONSTRUCTOR
	public Equipo(String nombreEquipo, String ciudad, int probabilidad) {
		this.idEquipo = ++numeroEquipos;
		this.nombreEquipo = nombreEquipo;
		this.Ciudad = ciudad;
		this.eficaciaDeGoles = probabilidad;
	}

	public Equipo(String nombreEquipo, String ciudad) {
		this.idEquipo = ++numeroEquipos;
		this.nombreEquipo = nombreEquipo;
		this.Ciudad = ciudad;
		this.eficaciaDeGoles = ProbabilidadAleatoria();
	}

	public Equipo() {

		this.nombreEquipo = "";
		Ciudad = "";

	}

	private static int ProbabilidadAleatoria() {

		int valor = (int) (Math.random() * 9) + 1;// VA DE 3 A 8

		valor = valor * 10;

		return valor;

	}
	/// GET AND SET

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public int getProbabilidad() {
		return eficaciaDeGoles;
	}

	public void setProbabilidad(int probabilidad) {
		this.eficaciaDeGoles = probabilidad;
	}

	/// TO STRING
	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", Ciudad=" + Ciudad + ", jugadores=" + jugadores + "]";
	}

	/// ***************************************METODOS
	/// PUBLICOS******************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	/// AGREGANDO JUGADOR A LA LISTA
	public void agregarJugadorAlEquipo(Jugador jugador) {

		jugadores.add(jugador);

	}

	/// ELIMINANDO JUGADOR DE LA LISTA

	public void eliminarJugadorDeLalista(String nombre) {

		if (nombre != null) {
			for (int i = 0; i < this.jugadores.size(); i++) {

				if (jugadores.get(i).getNombre().equalsIgnoreCase(nombre)) {

					jugadores.remove(i);
				}

			}

		}
	}
	/// BUSCAR JUGADOR POR NOMBRE

	public void buscandoJugadorEspecifico(String nombre) {

		for (Jugador jugadorAux : jugadores) {

			if (nombre.equalsIgnoreCase(jugadorAux.getNombre())) {

				System.out.println(" " + jugadorAux.toString());

			} else {

				System.out.println("Ese nombre, no existe en nuestros registros...");
			}

		}

	}

	/// OBTENER CANTIDAD TOTAL DE JUGADORES EN MI EQUIPO
	public void mostrarCantidadTotalDeJugadoresEnMiEquipo() {

		JOptionPane.showMessageDialog(null, "Tu equipo presenta " + jugadores.size() + " jugadores");

	}

	/// MOSTRAR LISTA DE JUGADORES DE MI EQUIPO
	public void mostrarListaDeJugadoresDeMiEquipo() {
		int i = 1;

		String mensaje = "\nLista de jugadores\n";

		if (!jugadores.isEmpty()) {
			for (Jugador jugadorAux : jugadores) {

				mensaje += "" + i + "- " + jugadorAux.toString() + "\n";

				i++;

			}

			JOptionPane.showMessageDialog(null, mensaje);
		} else {

			JOptionPane.showMessageDialog(null, "No presentas jugadores!");
		}

	}

}
