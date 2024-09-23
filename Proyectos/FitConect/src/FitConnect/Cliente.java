package FitConnect;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {

	private String nivelCliente;
	private int PointsPopularidad;
	private Objetivo objetivo;
	private ArrayList<Rutina> listaRutinas = new ArrayList<Rutina>();
	private Desafio desafio;
	private AreaEntrenamiento lugarEntrenamiento;

	public Cliente(String nivelCliente, int pointsPopularidad, Objetivo objetivo, Desafio desafio,
			AreaEntrenamiento lugarEntrenamiento, String usser, String pass, DatosPersonales datos, String tipo) {
		super(usser, pass, datos, tipo);
		this.nivelCliente = nivelCliente;
		PointsPopularidad = pointsPopularidad;
		this.objetivo = objetivo;

		this.desafio = desafio;
		this.lugarEntrenamiento = lugarEntrenamiento;
	}

	public Cliente(String usser, String pass, DatosPersonales datos, String tipo, Objetivo objetivo) {
		super(usser, pass, datos, tipo);

		this.nivelCliente = "Principiante";
		PointsPopularidad = 0;
		this.objetivo = objetivo;
		this.desafio = null;
		this.lugarEntrenamiento = null;
	}

	public String getNivelCliente() {
		return nivelCliente;
	}

	public void setNivelCliente(String nivelCliente) {
		this.nivelCliente = nivelCliente;
	}

	public int getPointsPopularidad() {
		return PointsPopularidad;
	}

	public void setPointsPopularidad(int pointsPopularidad) {
		PointsPopularidad = pointsPopularidad;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public ArrayList<Rutina> getListaRutinas() {
		return listaRutinas;
	}

	public void setListaRutinas(ArrayList<Rutina> listaRutinas) {
		this.listaRutinas = listaRutinas;
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}

	public AreaEntrenamiento getLugarEntrenamiento() {
		return lugarEntrenamiento;
	}

	public void setLugarEntrenamiento(AreaEntrenamiento lugarEntrenamiento) {
		this.lugarEntrenamiento = lugarEntrenamiento;
	}

	public boolean MenuUsuario() {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		boolean continuarCliente = true;

		do {
			opcion = opcionesCliente(scanner);
			switch (opcion) {

			case 1:

				/// VER RUTINAS
				menuRutinas(scanner);

				break;
			case 2:

				/// VER DESAFIOS
				menuDesafios(scanner);
			case 3:

				/// MODIFICAR PERFIL
				break;
			case 4:
				/// SALIR
				continuarCliente = false;

				break;

			}

		} while (continuarCliente);

		return (opcion == 4) ? continuarCliente = true : continuarCliente;

	}

	private static int opcionesCliente(Scanner scan) {

		int opcion = 0;
		boolean error = false;

		do {

			System.out.println("OPCIONES DEL USUARIO\n" + "[1] Ver rutinas\n" + "[2] Ver desafios\n"
					+ "[3] Modificar informacion\n" + "[4] Salir del menu\n");

			if (scan.hasNextInt()) {
				opcion = scan.nextInt();

				if (opcion < 1 || opcion > 4) {
					error = true;

					System.out.println("\n\t[Error, ingresa un valor del (1-4)]\n");

				}

			} else {
				System.out.println("\n\t[Error, ingresa un valor entero]\n");
				error = true;
				scan.next();
			}

		} while (error);

		return opcion;
	}

	private void menuDesafios(Scanner scan) {

		boolean continuar = true;
		int opcion = 0;
		do {
			opcion = opcionesDesafio(scan);
			switch (opcion) {

			case 1:

				/// VER DESAFIOS ACTIVOS

				System.out.println("Proximamente");

				break;
			case 2:
				/// VER MIS DESAFIOS

				System.out.println("Proximamente");
			case 3:

				/// CREAR DESAFIO
				System.out.println("Proximamente");
				break;
			case 4:
				// SALIR
				continuar = false;

				break;

			}

		} while (continuar);

	}

	private static int opcionesDesafio(Scanner scan) {

		int opcion = 0;
		boolean error = false;

		do {

			System.out.println("\nSELECCIONA UNA OPCION\n" + "[1] Ver desafios activos\n" + "[2] Ver mis desafios\n"
					+ "[3] Crear desafio\n" + "[4]Salir de rutinas");

			if (scan.hasNextInt()) {
				opcion = scan.nextInt();

				if (opcion < 1 || opcion > 4) {
					error = true;

					System.out.println("\n\t[Error, ingresa un valor del (1-4)]\n");

				}

			} else {
				System.out.println("\n\t[Error, ingresa un valor entero]\n");
				error = true;
				scan.next();
			}

		} while (error);

		return opcion;
	}

	private void menuRutinas(Scanner scan) {

		boolean continuar = true;
		int opcion = 0;
		do {
			opcion = OpcionesRutina(scan);
			switch (opcion) {

			case 1:

				/// BUSCAR RUTINAS EN EL SISTEMA

				System.out.println("Proximamente");

				break;
			case 2:
				/// CREAR RUTINA
				System.out.println("Proximamente");
			case 3:

				/// VER RUTINAS COMPARTIDAS
				mostrarRutinasCompartidad();
				break;
			case 4:
				/// MIS RUTINAS

				mostrarRutinasNoCompartidad();
				break;
			case 5:
				continuar = false;

				break;

			}

		} while (continuar);

	}

	private void mostrarRutinasNoCompartidad() {

		if (contadorDeRutinaNoCompartidas() != 0) {
			System.out.println("\n\t Lista de Rutinas");

			for (Rutina rutina : listaRutinas) {

				if (rutina.getCompartida().equalsIgnoreCase("N")) {
					rutina.mostrarRutina();
				}
			}
		} else {

			System.out.println("\n\t\t[NO PRESENTAS RUTINAS CARGADAS]\n");
		}

	}

	private void mostrarRutinasCompartidad() {

		if (presentaRutinasCompartidas().equalsIgnoreCase("Si")) {
			System.out.println("\n\t Lista de Rutinas");

			for (Rutina rutina : listaRutinas) {

				if (rutina.getCompartida().equalsIgnoreCase("S")) {
					rutina.mostrarRutina();
				}
			}
		} else {

			System.out.println("\n\t\t[NO PRESENTAS RUTINAS COMPARTIDAS]\n");
		}

	}

	private int contadorDeRutinaNoCompartidas() {

		int contador = 0;

		for (Rutina rutina : listaRutinas) {

			if (rutina.getCompartida().equalsIgnoreCase("N")) {
				contador++;
			}
		}

		return contador;

	}

	private static int OpcionesRutina(Scanner scan) {

		int opcion = 0;
		boolean error = false;

		do {

			System.out
					.println("\nSELECCIONA UNA OPCION\n" + "[1] Buscar rutinas en el sistema \n" + "[2] Crear rutina\n"
							+ "[3] Ver rutinas compartidas\n" + "[4] Mis rutinas\n" + "[5] Salir de rutinas");

			if (scan.hasNextInt()) {
				opcion = scan.nextInt();

				if (opcion < 1 || opcion > 5) {
					error = true;

					System.out.println("\n\t[Error, ingresa un valor del (1-5)]\n");

				}

			} else {
				System.out.println("\n\t[Error, ingresa un valor entero]\n");
				error = true;
				scan.next();
			}

		} while (error);

		return opcion;
	}

	public void MostrarPerfilInicio() {
		System.out.println("\n\tUsuario:" + getUsser() + "\nNivel:" + nivelCliente + "\nObjetivo a lograr:"
				+ objetivo.getTipo() + "\nEdad:" + getDatos().getEdad() + "\nEmail:" + getDatos().getEmail()
				+ "\nPresenta rutinas compartidas: " + presentaRutinasCompartidas());

	}

	private String presentaRutinasCompartidas() {

		int contador = 0;
		String opcionElegida = "si";

		for (Rutina rutina : listaRutinas) {

			if (rutina.getCompartida().equalsIgnoreCase("S")) {
				contador++;
			}
		}

		if (contador == 0)
			opcionElegida = "no";

		return opcionElegida;

	}

	public void GuardarRutina(Rutina rutina) {

		this.listaRutinas.add(rutina);

	}

}