import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestorDeEquipos {

	private ArrayList<Equipo> equipos = new ArrayList<>();

	//// CONSTRUCTOR

	public GestorDeEquipos() {

	}

	/// GET AND SET

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	/// TO STRING

	@Override
	public String toString() {
		return "GestorDeEquipos [equipos=" + equipos + "]";
	}

	/// METODOS *****************************[MENU]******************************

	public void menuDeAdministracionDeEquipos() {

		String[] OpcionesMenu = { "PARTIDO[1 vs 1]", "TORNEO", "CREAR EQUIPO", "ELIMINAR EQUIPO", "MODIFICAR EQUIPO",
				"MOSTRAR INFORMACION DE EQUIPOS", "SALIR" };
		String OpcionSeleccionada = " ";

		/// OPCION AGREGAR EQUIPO
		ArrayList<String> equiposEliminados = new ArrayList<>();

		do {

			OpcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion", "Menu",
					JOptionPane.QUESTION_MESSAGE, null, OpcionesMenu, OpcionesMenu[0]);

			if (OpcionSeleccionada == null) {

				OpcionSeleccionada = ("Salir");

			} else {

				switch (OpcionSeleccionada) {

				case "CREAR EQUIPO":
					OpcionesAgregarEquipo(equiposEliminados, this.equipos);

					break;
				case "ELIMINAR EQUIPO":
					EliminandoEquipo(this.equipos, equiposEliminados);
					break;
				case "MODIFICAR EQUIPO":

					ModificarEquipo(this.equipos);

					break;
				case "MOSTRAR INFORMACION DE EQUIPOS":

					MostrarEquiposRegistrados(this.equipos);

					break;

				case "PARTIDO[1 vs 1]":

					PartidoVersusUnoContraUno(this.equipos);

					break;
				case "TORNEO":
					JOptionPane.showMessageDialog(null, "PROXIMAMENTE...");

					break;
				default:

					break;
				}

			}

		} while (!OpcionSeleccionada.equals("Salir"));

		System.out.println(" \n Hasta luego, vuelva pronto!");

	}

///JUGAR 1 VS 1 
	private static void PartidoVersusUnoContraUno(ArrayList<Equipo> equipos) {

		if (equipos.size() == 2) {

			Modo1vs1Confirmado(equipos);

		} else if (equipos.size() > 2) {

			Modo1vs1Seleccionado(equipos);

		} else {

			JOptionPane.showMessageDialog(null, "TE FALTAN EQUIPOS.. PARA JUGAR ESTE MODO...");

		}

	}

	private static void Modo1vs1Seleccionado(ArrayList<Equipo> equipos) {

		String[] opciones = ConvirtiendoArrayDeEquiposEnArrayDeOpciones(equipos);
		String opcionSeleccionada = "";
		String opcionSeleccionada2 = "";
		opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione  equipo uno :", "Partido 1 vs 1 ",
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		opciones = ActualizandoMiArrayDeOpciones(opciones, opcionSeleccionada);
		opcionSeleccionada2 = (String) JOptionPane.showInputDialog(null, "Seleccione un equipo dos :", "Partido 1 vs 1",
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada != null && opcionSeleccionada2 != null) {

			Equipo uno;
			Equipo dos;

			uno = BuscandoEquipoSeleccionado(opcionSeleccionada, equipos);
			dos = BuscandoEquipoSeleccionado(opcionSeleccionada2, equipos);

			if (uno.getJugadores().size() >= 8 && dos.getJugadores().size() >= 8) {

				JugandoPartido1vs1(uno, dos);
			} else {
				JOptionPane.showMessageDialog(null,
						"Uno de lo equipos seleccionados , no presenta la cantidad correcta de jugadores..");

			}

		}

	}

	private static String[] ActualizandoMiArrayDeOpciones(String[] opciones, String opcioneSelccionada) {
		String[] ArrayNuevo = new String[opciones.length];
		int u = 0;

		for (int i = 0; i < opciones.length; i++) {

			if (!opciones[i].equalsIgnoreCase(opcioneSelccionada)) {

				ArrayNuevo[u] = opciones[i];
				u++;

			}

		}

		return ArrayNuevo;

	}

	private static void Modo1vs1Confirmado(ArrayList<Equipo> equipos) {
		Equipo uno = equipos.get(0);
		Equipo dos = equipos.get(1);

		if (uno.getJugadores().size() < 8 || dos.getJugadores().size() < 8) {

			JOptionPane.showMessageDialog(null,
					"Error , uno de lo equipo no presenta suficientes jugadores[MINIMO= 8 JUGADORES]...");
		} else {

			JugandoPartido1vs1(uno, dos);
		}

	}

	private static void JugandoPartido1vs1(Equipo uno, Equipo dos) {
		int goles1;
		int goles2;

		goles1 = (int) (Math.random() * 3) + 1;
		goles2 = (int) (Math.random() * 3) + 1;

		if (goles1 == goles2) {

			JOptionPane.showMessageDialog(null, "\nResultado\n" + "" + uno.getNombreEquipo() + "[" + goles1 + "]"
					+ "  VS  " + dos.getNombreEquipo() + "[" + goles2 + "]" + "\n" + "\n        PENALES...");

			PenalesJuego1vs1(uno, dos);

		} else if (goles1 < goles2) {

			JOptionPane.showMessageDialog(null, "\nResultado\n" + "" + uno.getNombreEquipo() + "[" + goles1 + "]"
					+ "  VS  " + dos.getNombreEquipo() + "[" + goles2 + "]" + "\n");

		} else {

			JOptionPane.showMessageDialog(null, "\nResultado\n" + "" + uno.getNombreEquipo() + "[" + goles1 + "]"
					+ "  VS  " + dos.getNombreEquipo() + "[" + goles2 + "]" + "\n");

		}

	}

	private static void PenalesJuego1vs1(Equipo uno, Equipo dos) {
		char equipo1;
		char equipo2;
		String mensaje1 = "";
		String mensaje2 = "";
		int difDeLosGoles = 0;
		int positivosEquipo1 = 0;
		int positivosEquipo2 = 0;
		int rondas = 0;

		do {

			rondas++;

			equipo1 = PenalPateado((int) (Math.random() * 2) + 1);
			mensaje1 += equipo1 + " ";

			if (equipo1 == 'O') {
				positivosEquipo1++;

			}

			equipo2 = PenalPateado((int) (Math.random() * 2) + 1);
			mensaje2 += equipo2 + " ";
			if (equipo2 == 'O') {

				positivosEquipo2++;
			}

			difDeLosGoles = Math.abs(positivosEquipo1 - positivosEquipo2);

			if (rondas >= 5 && difDeLosGoles == 0) {

				do {
					equipo1 = PenalPateado((int) (Math.random() * 2) + 1);
					mensaje1 += equipo1 + " ";

					if (equipo1 == 'O') {
						positivosEquipo1++;

					}
					equipo2 = PenalPateado((int) (Math.random() * 2) + 1);
					mensaje2 += equipo2 + " ";
					if (equipo2 == 'O') {

						positivosEquipo2++;
					}

					difDeLosGoles = Math.abs(positivosEquipo1 - positivosEquipo2);

				} while (difDeLosGoles != 1);

				if (difDeLosGoles == 1) {

					difDeLosGoles = 3;
				}

			} else if (rondas >= 5 && difDeLosGoles == 1) {

				difDeLosGoles = 3;

			} else if (rondas >= 5 && difDeLosGoles == 2) {

				difDeLosGoles = 3;
			} else if (rondas == 3 && difDeLosGoles == 3) {

				difDeLosGoles = 3;
			} else if (rondas == 4 && difDeLosGoles == 2) {
				difDeLosGoles = 3;
			}

		} while (difDeLosGoles != 3);

		if (positivosEquipo1 > positivosEquipo2) {
			JOptionPane.showMessageDialog(null,
					"\nResultado\n" + "" + uno.getNombreEquipo() + "  VS  " + dos.getNombreEquipo()
							+ "\n*************PENALES**************\n" + " " + mensaje1 + "  VS  " + mensaje2
							+ "\nGanador: " + uno.getNombreEquipo());

		} else {

			JOptionPane.showMessageDialog(null,
					"\nResultado\n" + "" + uno.getNombreEquipo() + "  VS  " + dos.getNombreEquipo()
							+ "\n*************PENALES**************\n" + " " + mensaje1 + "  VS  " + mensaje2
							+ "\nGanador: " + dos.getNombreEquipo());
		}

	}

	private static char PenalPateado(int penal) {

		if (penal == 1) {
			return 'O';
		} else {
			return 'X';
		}

	}

///ELIMINAR EQUIPO
	private static void EliminandoEquipo(ArrayList<Equipo> equipos, ArrayList<String> equiposEliminados) {

		if (!equipos.isEmpty()) {
			String[] opciones = ConvirtiendoArrayDeEquiposEnArrayDeOpciones(equipos);
			String opcionSeleccionada = "";
			opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione un equipo:", "Modificar equipo",
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

			Equipo equipoSeleccionado = BuscandoEquipoSeleccionado(opcionSeleccionada, equipos);

			if (equipoSeleccionado != null) {
				EliminarElEquipoSeleccionado(equipoSeleccionado, equipos);
				VolviendoAseleccionElEquipoEliminado(equipoSeleccionado, equiposEliminados);

			}

		} else {

			JOptionPane.showMessageDialog(null, "No hay equipos");
		}

	}

	private static void VolviendoAseleccionElEquipoEliminado(Equipo equipoSeleccionado,
			ArrayList<String> equiposEliminados) {

		for (int i = 0; i < equiposEliminados.size(); i++) {

			if (equipoSeleccionado.getNombreEquipo().equalsIgnoreCase(equiposEliminados.get(i))) {

				equiposEliminados.remove(i);

			}
		}

	}

	private static void EliminarElEquipoSeleccionado(Equipo equipoSeleccionado, ArrayList<Equipo> equipos) {

		for (int i = 0; i < equipos.size(); i++) {

			if (equipoSeleccionado.getNombreEquipo().equalsIgnoreCase(equipos.get(i).getNombreEquipo())) {

				equipos.remove(i);

			}
		}

	}

///MODIFICAR EQUIPO
	private static void ModificarEquipo(ArrayList<Equipo> equipos) {

		if (!equipos.isEmpty()) {

			String[] opciones = ConvirtiendoArrayDeEquiposEnArrayDeOpciones(equipos);
			String opcionSeleccionada = "";
			opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione un equipo:", "Modificar equipo",
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

			OpcionesModicarEquipo(opcionSeleccionada, equipos);

		} else {

			JOptionPane.showMessageDialog(null, "No hay equipos");

		}

	}

	private static void OpcionesModicarEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		String[] Opciones = { "Modificar nombre del equipo", "Modificar ciudad del equipo", "Modificar plantilla",
				"Salir" };
		String opcionSeleccionada = "";

		do {

			opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione un equipo:", "Modificar equipo",
					JOptionPane.QUESTION_MESSAGE, null, Opciones, Opciones[0]);

			if (opcionSeleccionada != null) {

				switch (opcionSeleccionada) {
				case "Modificar nombre del equipo":
					ModificarNombreDelEquipo(EquipoSeleccionado, equipos);
					JOptionPane.showMessageDialog(null, "Nombre del equipo se ha modificado..");
					opcionSeleccionada = "Salir";

					break;

				case "Modificar ciudad del equipo":
					ModificarCiudadDelEquipo(EquipoSeleccionado, equipos);
					JOptionPane.showMessageDialog(null, "Ciudad del equipo se ha modificado..");
					opcionSeleccionada = "Salir";

					break;
				case "Modificar plantilla":

					OpcionesDeModificarPlantilla(EquipoSeleccionado, equipos);
					break;

				}

			} else {

				opcionSeleccionada = "Salir";
			}

		} while (!opcionSeleccionada.equals("Salir"));

	}

	/// MODIFICAR CIUDAD DEL EQUIPO
	private static void ModificarCiudadDelEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {

		String NuevoNombreCiudad = JOptionPane.showInputDialog("Ingresa el nuevo nombre de la ciudad:");
		NuevoNombreCiudad = VerificacionDelaCiudad(NuevoNombreCiudad);
		if (NuevoNombreCiudad != null) {

			for (int i = 0; i < equipos.size(); i++) {

				if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

					equipos.get(i).setCiudad(NuevoNombreCiudad);
					;

				}

			}
		}

	}

	private static String VerificacionDelaCiudad(String nombre) {

		while (nombre == null || nombre.trim().isEmpty() || ExistenciaDeUnNumeroEnMiString(nombre)) {

			nombre = JOptionPane.showInputDialog("Error,Ingresa el nuevo nombre de la ciudad ");

		}

		return nombre;

	}

	/// MODIFICAR NOMBRE DEL EQUIPO

	private static void ModificarNombreDelEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		String Nuevonombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre del equipo:");
		Nuevonombre = verificacionEntradaNombreEquipo(Nuevonombre, equipos);

		if (Nuevonombre != null) {

			for (int i = 0; i < equipos.size(); i++) {

				if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

					equipos.get(i).setNombreEquipo(Nuevonombre);

				}

			}
		}

	}

	private static String verificacionEntradaNombreEquipo(String nombre, ArrayList<Equipo> equipos) {

		while (nombre == null || nombre.trim().isEmpty() || ExistenciaDelNombreEnMiEquipo(nombre, equipos)
				|| ExistenciaDeUnNumeroEnMiString(nombre)) {

			nombre = JOptionPane.showInputDialog("Error,Ingresa un nuevo nombre de equipo:");

		}

		return nombre;

	}

	private static boolean ExistenciaDelNombreEnMiEquipo(String equipo, ArrayList<Equipo> equipos) {

		for (int i = 0; i < equipos.size(); i++) {

			if (equipos.get(i).getNombreEquipo().equalsIgnoreCase(equipo)) {

				return true;
			}
		}

		return false;
	}

	//// MODIFICAR PLANTILLA

	private static void OpcionesDeModificarPlantilla(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		String[] OpcionesModificaEqupo = { "Agregar jugador al equipo", "Eliminar jugador del equipo",
				"Lista de jugadores", "Salir" };
		String opcionSeleccionada = "";

		do {

			opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion:",
					"Modificar plantilla", JOptionPane.QUESTION_MESSAGE, null, OpcionesModificaEqupo,
					OpcionesModificaEqupo[0]);

			if (opcionSeleccionada != null) {
				switch (opcionSeleccionada) {
				case "Agregar jugador al equipo":
					int cantidadJugadores = BuscandoCantidadDeJugadoresDeMiEquipo(EquipoSeleccionado, equipos);

					if (cantidadJugadores < 16) {
						Jugador jugador = CreandoJugadorPorEntradaDeDatos(EquipoSeleccionado, equipos);

						for (int i = 0; i < equipos.size(); i++) {

							if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

								equipos.get(i).agregarJugadorAlEquipo(jugador);

							}

						}

					} else {

						JOptionPane.showMessageDialog(null, "No puedes agregar mas jugadores [MAXIMO=16]");
					}

					break;

				case "Eliminar jugador del equipo":
					EliminarJugadorDelEquipo(EquipoSeleccionado, equipos);

					break;

				case "Lista de jugadores":

					MostrarJugadoresDeMiEquipo(EquipoSeleccionado, equipos);

					break;

				}
			} else {
				opcionSeleccionada = "Salir";
			}
		} while (!opcionSeleccionada.equals("Salir"));

	}

	/// ELIMINAR JUGADOR
	private static void EliminarJugadorDelEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		Equipo equipoSelec = BuscandoEquipoSeleccionado(EquipoSeleccionado, equipos);

		if (equipoSelec != null) {
			String[] nombreDeJugadores = ConvirtiendoArrayListDeJugadorEnArrayOpciones(equipoSelec.getJugadores());
			String opcionSeleccionada = "";

			if (equipoSelec.getJugadores().size() != 0) {
				opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione un jugador:",
						"Eliminar jugador del equipo", JOptionPane.QUESTION_MESSAGE, null, nombreDeJugadores,
						nombreDeJugadores[0]);

				for (int i = 0; i < equipos.size(); i++) {

					if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

						equipos.get(i).eliminarJugadorDeLalista(opcionSeleccionada);

					}

				}
			} else {
				JOptionPane.showMessageDialog(null, "No presentas jugadores...");
			}
		}

	}

	private static Equipo BuscandoEquipoSeleccionado(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		Equipo equipoAux = null;

		for (Equipo equipo : equipos) {

			if (equipo.getNombreEquipo().equalsIgnoreCase(EquipoSeleccionado)) {

				equipoAux = equipo;
				break;
			}
		}

		return equipoAux;

	}

	private static String[] ConvirtiendoArrayListDeJugadorEnArrayOpciones(ArrayList<Jugador> jugadores) {
		ArrayList<String> jugadoresString = new ArrayList<String>();

		for (Jugador jugador : jugadores) {

			jugadoresString.add(jugador.getNombre());

		}

		return jugadoresString.toArray(new String[0]);

	}

	/// MOSTRAR LISTA DE JUGADORES DEL EQUIPO

	private static void MostrarJugadoresDeMiEquipo(String opcionSeleccionada, ArrayList<Equipo> equipos) {

		Equipo equipoAux = null;

		for (int i = 0; i < equipos.size(); i++) {

			if (equipos.get(i).getNombreEquipo().equals(opcionSeleccionada)) {
				equipoAux = equipos.get(i);

			}

		}
		equipoAux.mostrarListaDeJugadoresDeMiEquipo();
		equipoAux.mostrarCantidadTotalDeJugadoresEnMiEquipo();

	}

	/// AGREGAR JUGADOR AL EQUIPO

	private static int BuscandoCantidadDeJugadoresDeMiEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		int CantidadDeJugadores = 0;

		for (int i = 0; i < equipos.size(); i++) {

			if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

				CantidadDeJugadores = equipos.get(i).getJugadores().size();

			}

		}

		return CantidadDeJugadores;

	}

	private static Jugador CreandoJugadorPorEntradaDeDatos(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		int edadNum = 0;
		int numCamisetaEntero = 0;
		String Mensaje = "DEL=DELANTERO\nMC=MEDIOCAMPISTA\nDEF=DEFENSOR\nPOR=PORTERO\n";

		String nombre = JOptionPane.showInputDialog("Ingresa el nombre del jugador: ");
		nombre = verificacionEntradaNombreJugador(nombre, equipos, EquipoSeleccionado);

		String edad = JOptionPane.showInputDialog("Ingresa la edad del jugador :");
		edadNum = VerificandoEntradaEdad(edad);

		String posicion = JOptionPane.showInputDialog(Mensaje + "\nIngresa la posicion del jugador:  ");
		posicion = VerificandoEntradaPosicion(posicion, Mensaje);

		String numCamiseta = JOptionPane.showInputDialog("Ingresa el numero de la camiseta: ");
		numCamisetaEntero = VerficandoEntradaDenumCamiseta(numCamiseta, equipos, EquipoSeleccionado);

		Jugador jugador = new Jugador(nombre, edadNum, posicion, numCamisetaEntero);

		return jugador;

	}

	private static String verificacionEntradaNombreJugador(String nombre, ArrayList<Equipo> equipos,
			String EquipoSeleccionado) {

		while (nombre == null || nombre.trim().isEmpty()
				|| ExistenciaJugadorEnMiEquipo(nombre, equipos, EquipoSeleccionado)
				|| ExistenciaDeUnNumeroEnMiString(nombre)) {

			nombre = JOptionPane.showInputDialog("Error,Ingresa un nuevo nombre de jugador:");

		}

		return nombre;

	}

	private static boolean ExistenciaDeUnNumeroEnMiString(String nombre) {

		for (char caracter : nombre.toCharArray()) {

			if (Character.isDigit(caracter)) {

				return true;
			}

		}

		return false;

	}

	private static boolean ExistenciaJugadorEnMiEquipo(String nombre, ArrayList<Equipo> equipos,
			String equipoSeleccionado) {

		for (int i = 0; i < equipos.size(); i++) {

			if (equipos.get(i).getNombreEquipo().equalsIgnoreCase(equipoSeleccionado)) {

				for (int j = 0; j < equipos.get(i).getJugadores().size(); j++) {

					if (nombre.equalsIgnoreCase(equipos.get(i).getJugadores().get(j).getNombre())) {

						return true;

					}

				}

			}
		}

		return false;
	}

	private static int VerficandoEntradaDenumCamiseta(String numCamiseta, ArrayList<Equipo> equipos,
			String EquipoSeleccionado) {

		int numeroCamiseta = ExisteEseNumeroDeCamisetaEnelEquipo(numCamiseta, equipos, EquipoSeleccionado);

		while (numeroCamiseta <= 0) {

			if (numeroCamiseta == -1) {
				JOptionPane.showMessageDialog(null, "Ingresaste un numero de camiseta existente");
				numCamiseta = JOptionPane.showInputDialog("Ingresa el numero de la camiseta: ");
				numeroCamiseta = ExisteEseNumeroDeCamisetaEnelEquipo(numCamiseta, equipos, EquipoSeleccionado);
			} else {

				JOptionPane.showMessageDialog(null, "Error, no es un numero entero positivo..");
				numCamiseta = JOptionPane.showInputDialog("Ingresa el numero de la camiseta: ");
				numeroCamiseta = ExisteEseNumeroDeCamisetaEnelEquipo(numCamiseta, equipos, EquipoSeleccionado);

			}

		}

		return numeroCamiseta;

	}

	private static int ExisteEseNumeroDeCamisetaEnelEquipo(String numCamiseta, ArrayList<Equipo> equipos,
			String EquipoSeleccionado) {

		int numeroCamiseta = StringPresentaUnNumero(numCamiseta);

		for (Equipo equipo : equipos) {

			if (equipo.getNombreEquipo().equals(EquipoSeleccionado)) {

				for (Jugador jugador : equipo.getJugadores()) {

					if (jugador.getNumCamiseta() == numeroCamiseta || numeroCamiseta <= 0) {

						if (numeroCamiseta <= 0) {
							return 0;
						} else {

							return -1;
						}

					}
				}
			}

		}

		return numeroCamiseta;

	}

	private static String VerificandoEntradaPosicion(String posicion, String mensaje) {

		while (posicion == null || (!posicion.equalsIgnoreCase("POR") && !posicion.equalsIgnoreCase("DEF")
				&& !posicion.equalsIgnoreCase("MC") && !posicion.equalsIgnoreCase("DEL")
				&& !posicion.equalsIgnoreCase("DEL"))) {

			posicion = JOptionPane.showInputDialog(mensaje + "\nError,Ingresa la posicion del jugador:  ");

		}

		return posicion.toUpperCase();

	}

	private static int VerificandoEntradaEdad(String edadNum) {

		int numero = StringPresentaUnNumero(edadNum);

		while (numero < 16 || numero > 42) {

			edadNum = JOptionPane.showInputDialog("Error,Ingresa la edad del jugador[16-42] :");
			numero = StringPresentaUnNumero(edadNum);
		}

		return Integer.parseInt(edadNum);

	}

	private static int StringPresentaUnNumero(String numEnCadena) {

		try {

			Integer.parseInt(numEnCadena);

			return Integer.parseInt(numEnCadena);

		} catch (NumberFormatException e) {

			return 0;
		}

	}

	private static String[] ConvirtiendoArrayDeEquiposEnArrayDeOpciones(ArrayList<Equipo> equipos) {
		ArrayList<String> equiposString = new ArrayList<String>();

		for (Equipo equipo : equipos) {

			equiposString.add(equipo.getNombreEquipo());

		}

		return equiposString.toArray(new String[0]);

	}

////MOSTRAR LISTA DE EQUIPOS

	private static void MostrarEquiposRegistrados(ArrayList<Equipo> equipos) {
		int i = 0;
		if (!equipos.isEmpty()) {
			String Mensaje = "Equipos Registrados\n\n";

			for (Equipo equipo : equipos) {
				i++;
				Mensaje = Mensaje + equipo.getNombreEquipo() + "\n" + equipo.getCiudad() + "\n";

			}

			JOptionPane.showMessageDialog(null, "" + Mensaje + "\n\n La cantidad de equipos es : " + i);

		} else {

			JOptionPane.showMessageDialog(null, "No hay equipos registrados aun..");
		}

	}

/// METODOS DE OPCION AGREGAR EQUIPO

	private static void OpcionesAgregarEquipo(ArrayList<String> equiposEliminados, ArrayList<Equipo> equipos) {

		String[] opcionesAgregarEquipo = { "Crear un equipo personalizado", "Crear un equipo armado" };

		String OpcionSeleccionada = " ";

		OpcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion", "CREAR EQUIPO",
				JOptionPane.QUESTION_MESSAGE, null, opcionesAgregarEquipo, opcionesAgregarEquipo[0]);

		if (OpcionSeleccionada != null) {

			switch (OpcionSeleccionada) {
			case "Crear un equipo personalizado":

				//// VOY A CREAR MI EQUIPO

				CreandoEquipoPersonalizado(equipos);
				break;

			case "Crear un equipo armado":

				String opcSelecEquipo = "";

				String[] nombresEquipos = { "Juventus", "Manchester United" };

				nombresEquipos = ElimandoEquipoElegidoDeMisOpciones(nombresEquipos, equiposEliminados);

				if (nombresEquipos.length > 0) {

					/// VOY A SELECCIONAR UN EQUIPO ARMADO

					opcSelecEquipo = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion",
							"Seleccione un equipo", JOptionPane.QUESTION_MESSAGE, null, nombresEquipos,
							nombresEquipos[0]);

					if (opcSelecEquipo != null) {

						equiposEliminados.add(opcSelecEquipo);

						switch (opcSelecEquipo) {
						case "Juventus":

							equipos.add(CargandoEquipoJuventus());

							break;

						case "Manchester United":

							equipos.add(CargandoEquipoManchesterUnited());
							break;
						}

					} else {

					}

				} else {

					JOptionPane.showMessageDialog(null, "No hay mas equipos disponibles");

				}

				break;

			}
		}

	}

	/// CREACION DE EQUIPO PERSONALIZADO

	private static void CreandoEquipoPersonalizado(ArrayList<Equipo> equipos) {

		String nombre = JOptionPane.showInputDialog("Ingresa el nombre del equipo:");
		nombre = verificacionEntradaNombreEquipo(nombre, equipos);
		String ciudad = JOptionPane.showInputDialog("Ingresa el nombre de la ciudad del equipo:");
		ciudad = VerificacionDelaCiudad(ciudad);
		int valor = 0;
		int numeroDeJugadoresAgregados = 0;
		Equipo equipoCreado = new Equipo(nombre, ciudad);
		equipos.add(equipoCreado);

		do {

			JOptionPane.showMessageDialog(null, "Jugador " + (++numeroDeJugadoresAgregados));
			equipos.get(equipos.size() - 1)
					.agregarJugadorAlEquipo(CreandoJugadorPorEntradaDeDatos(equipoCreado.getNombreEquipo(), equipos));
			;

			valor = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro jugador?", "Confirmación",
					JOptionPane.YES_NO_OPTION);

		} while (valor == 0);

		if (numeroDeJugadoresAgregados < 8) {
			JOptionPane.showMessageDialog(null,
					"Necitas como minimo 8 jugadores para poder jugar algun modo de juego.. hasta luego!");
		}

	}

	private static String[] ElimandoEquipoElegidoDeMisOpciones(String[] OpcionesDeEquipo,
			ArrayList<String> equiposEliminados) {

		if (!equiposEliminados.isEmpty()) {

			ArrayList<String> equiposOpciones = new ArrayList<>();

			for (String equiposAux : OpcionesDeEquipo) {

				if (!equiposEliminados.contains(equiposAux)) {

					equiposOpciones.add(equiposAux);

				}

			}

			return equiposOpciones.toArray(new String[0]);/// CONVIERTE UN ARRAYLIST EN ARRAY

		} else {

			return OpcionesDeEquipo;

		}

	}

	private static Equipo CargandoEquipoJuventus() {
		Equipo juventus = new Equipo("Juventus", "turin");

		Jugador jugador = new Jugador("A", 21, "POR", 1);
		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("B", 21, "DEF", 2);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("C", 21, "DEF", 3);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("D", 18, "DEF", 4);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("E", 16, "DEF", 5);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("F", 21, "MC", 6);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("G", 21, "MC", 7);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("H", 31, "MC", 8);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("I", 31, "MC", 9);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("J", 25, "DEL", 10);

		juventus.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("K", 30, "DEL", 11);

		juventus.agregarJugadorAlEquipo(jugador);

		return juventus;

	}

	private static Equipo CargandoEquipoManchesterUnited() {
		Equipo manchester = new Equipo("Manchester United", "Old Trafford");

		Jugador jugador = new Jugador("A", 21, "POR", 1);
		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("B", 21, "DEF", 2);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("C", 21, "DEF", 3);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("D", 18, "DEF", 4);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("E", 16, "DEF", 5);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("F", 21, "MC", 6);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("G", 21, "MC", 7);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("H", 31, "MC", 8);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("I", 35, "MC", 9);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("J", 25, "DEL", 10);

		manchester.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("K", 30, "DEL", 11);

		manchester.agregarJugadorAlEquipo(jugador);

		return manchester;

	}

	private void EliminarUnEquipo(Equipo equipo) {

		for (int i = 0; i < equipos.size(); i++) {

			if (equipo.getNombreEquipo().equalsIgnoreCase(equipos.get(i).getNombreEquipo())) {

				equipos.remove(i);

			} else {

			}
		}

	}

///METODOS************************************************************************************************
///METODOS************************************************************************************************
///METODOS************************************************************************************************
///METODOS************************************************************************************************
///METODOS************************************************************************************************
///METODOS************************************************************************************************
///METODOS************************************************************************************************

///AGREGAR EQUIPO	
	public void AgregarUnEquipoDesdeCodigo(Equipo equipo) {

		equipos.add(equipo);

	}

///ELIMINAR EQUIPO
	public void EliminarUnEquipoDesdeCodigo(String nombre) {

		for (int i = 0; i < equipos.size(); i++) {

			if (nombre.equalsIgnoreCase(equipos.get(i).getNombreEquipo())) {

				equipos.remove(i);
				System.out.println("Equipo eliminado.");

			} 
		}
		
		

}







	public void MostrarCantidadTotalDeEquiposDesdeCodigo() { {
		
			
		if(equipos.size()==0) {
			System.out.println("No presentas equipos aun ");
			
		}else {
			System.out.println("Cantidad de equipos registrados... "+equipos.size());
		}
		
		

	}


}


	public void MostrarListaDeEquiposDesdeElCodigo() { {
		
		
	
		if(equipos.size()==0) {
			
			System.out.println("No hay equipos registrados...");
		}else {
			String mensaje="\nLista de equipos\n";

			for (Equipo equipo : equipos) {
			
				mensaje = mensaje + equipo.getNombreEquipo() + "\n" + equipo.getCiudad() + "\n";

			}
			
			System.out.println(mensaje);
			
		}
		
		
		
		

	}


}





}