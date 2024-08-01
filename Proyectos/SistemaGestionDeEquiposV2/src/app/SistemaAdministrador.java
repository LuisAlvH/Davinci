package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SistemaAdministrador {

	private ArrayList<Equipo> equipos = new ArrayList<>();

	//// CONSTRUCTOR

	public SistemaAdministrador() {

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

	public void Menu() {
		String[] OpcionesMenu = { "PARTIDO[1 vs 1]", "TORNEO [8 EQUIPOS]", "CREAR EQUIPO", "ELIMINAR EQUIPO",
				"MODIFICAR EQUIPO", "MOSTRAR INFORMACION DE EQUIPOS", "SALIR" };

		ArrayList<String> equiposEliminados = new ArrayList<>();

		boolean flag = false;

		do {

			String OpcionSeleccionada = EntradaSalida.SeleccionDeOpciones(OpcionesMenu, "Menu");

			if (OpcionSeleccionada == null) {

				flag = true;

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
				case "TORNEO [8 EQUIPOS]":
					JugarTorneo(equipos);

					break;

				case "SALIR":

					flag = true;

					break;

				}

			}

		} while (!flag);

		System.out.println(" \n Hasta luego, vuelva pronto!");

	}

	/// ***************************************JUGAR
	/// TORNEO**********************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	private static void JugarTorneo(ArrayList<Equipo> equipos) {
		String[] OpcionesMenu = { "JUGAR TORNEO[equipos aleatorios]", "SALIR" };

		boolean flag = false;
		do {

			String OpcionSeleccionada = EntradaSalida.SeleccionDeOpciones(OpcionesMenu, "Menu");

			if (OpcionSeleccionada == null) {

				flag = true;

			} else {

				switch (OpcionSeleccionada) {

				case "JUGAR TORNEO[equipos aleatorios]":

					JugarTorneoAleatorio(equipos);
					break;

				case "SALIR":

					flag = true;
					break;

				}

			}

		} while (!flag);

	}

	private static void JugarTorneoAleatorio(ArrayList<Equipo> equipos) {
		ArrayList<Equipo> equiposAux = new ArrayList<>();

		AgregandoEquiposExtra(equiposAux, equipos);

		CargarEquiposAleatorios(equiposAux);

		/// INGRESO DE SALDO
		int saldo = EntradaSalida.IngresoDeSaldo("Ingresa saldo inicial:");

		Torneo torneo8 = new Torneo(equiposAux);

		MostrarOpcioneTorneo(saldo, torneo8);

		JOptionPane.showMessageDialog(null, "Finalizo el torneo!");

		equiposAux.clear();

	}

	private static void AgregandoEquiposExtra(ArrayList<Equipo> equiposExtra, ArrayList<Equipo> equipos) {

		for (Equipo equipo : equipos) {

			equiposExtra.add(equipo);

		}

	}

	private static void MostrarOpcioneTorneo(int saldo, Torneo torne8) {

		torne8.GenerandoPartidosDeLosEquiposCargados();

		boolean valor = false;
		do {

			String[] opciones = { "Ingresar dinero", "Realizar apuesta", "Mostrar fixture" };

			String mensaje = "Tu saldo es : $" + saldo;

			int seleccion = JOptionPane.showOptionDialog(null, mensaje, "Menu torneo", 0,
					JOptionPane.INFORMATION_MESSAGE, null, opciones, "");

			switch (seleccion) {
			case 0:

				saldo += EntradaSalida.IngresoDeSaldo("ingresa cantidad de dinero:");
				JOptionPane.showMessageDialog(null, "Dinero recargado a la cuenta");
				break;
			case 1:

				valor = RealizarApuestasCuartos(torne8, saldo);
				break;

			case 2:

				torne8.MostrarFixtureCuartos();

				break;

			}

		} while (!valor);

	}

	private static boolean RealizarApuestasCuartos(Torneo torneo, int saldo) {

		Equipo g1 = torneo.getPartidos().get(0).JugarPartidoYDevuelveGanador();
		Equipo g2 = torneo.getPartidos().get(1).JugarPartidoYDevuelveGanador();
		Equipo g3 = torneo.getPartidos().get(2).JugarPartidoYDevuelveGanador();
		Equipo g4 = torneo.getPartidos().get(3).JugarPartidoYDevuelveGanador();

		String mensaje = torneo.MostrarResultadosCuartos();

		if (saldo != 0) {
			int apuesta = EntradaSalida.IngresaApuesta(saldo);

			String[] opciones = { torneo.getPartidos().get(0).InformacionInicialPartido(),
					torneo.getPartidos().get(1).InformacionInicialPartido(),
					torneo.getPartidos().get(2).InformacionInicialPartido(),
					torneo.getPartidos().get(3).InformacionInicialPartido() };

			int seleccion = JOptionPane.showOptionDialog(null, "Selecciona el partido", "Menu torneo",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			switch (seleccion) {
			case 0:
				String[] opciones2 = { torneo.getPartidos().get(0).getUno().getNombreEquipo(),
						torneo.getPartidos().get(0).getDos().getNombreEquipo() };

				int seleccion2 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opciones2,
						opciones2[0]);

				if (opciones2[seleccion2] == g1.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					mensaje = mensaje + "\n ------APUESTA------ \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, mensaje);

				} else {

					mensaje = mensaje + "\n ------APUESTA------ \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, mensaje);
				}

				break;
			case 1:
				String[] opciones3 = { torneo.getPartidos().get(1).getUno().getNombreEquipo(),
						torneo.getPartidos().get(1).getDos().getNombreEquipo() };
				int seleccion3 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones3, opciones3[0]);

				if (opciones3[seleccion3] == g2.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					mensaje = mensaje + "\n ------APUESTA------ \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, mensaje);

				} else {

					mensaje = mensaje + "\n ------APUESTA------ \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, mensaje);
				}

				break;
			case 2:

				String[] opciones4 = { torneo.getPartidos().get(2).getUno().getNombreEquipo(),
						torneo.getPartidos().get(2).getDos().getNombreEquipo() };
				int seleccion4 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones4, opciones4[0]);

				if (opciones4[seleccion4] == g3.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					mensaje = mensaje + "\n ------APUESTA------  \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, mensaje);

				} else {

					mensaje = mensaje + "\n ------APUESTA------ \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, mensaje);
				}

				break;
			case 3:
				String[] opciones5 = { torneo.getPartidos().get(3).getUno().getNombreEquipo(),
						torneo.getPartidos().get(3).getDos().getNombreEquipo() };
				int seleccion5 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones5, opciones5[0]);

				if (opciones5[seleccion5] == g4.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					mensaje = mensaje + "\n ------APUESTA------ \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, mensaje);

				} else {

					mensaje = mensaje + "\n ------APUESTA------ \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, mensaje);
				}

				break;

			}

			CargandoPartidosSemifinal(torneo, g1, g2, g3, g4);

			MostrarMenuSemifinal(torneo, saldo);
			return true;

		} else {

			JOptionPane.showMessageDialog(null, "No presentas saldo para seguir jugando con las apuestas!");
			return false;
		}

	}

	private static void CargandoPartidosSemifinal(Torneo torneo, Equipo G1, Equipo G2, Equipo G3, Equipo G4) {
		Partido partido1 = new Partido(G1, G3);
		Partido partido2 = new Partido(G2, G4);
		torneo.getPartidosSemifinales().add(partido1);
		torneo.getPartidosSemifinales().add(partido2);

	}

	private static void MostrarMenuSemifinal(Torneo torneo, int saldo) {

		boolean valor = false;
		do {
			String[] opciones = { "Ingresar dinero", "Realizar apuesta", "Mostrar fixture" };

			String mensaje = "Tu saldo es : $" + saldo;

			int seleccion = JOptionPane.showOptionDialog(null, mensaje, "Menu torneo", 0,
					JOptionPane.INFORMATION_MESSAGE, null, opciones, "");

			switch (seleccion) {
			case 0:
				saldo += EntradaSalida.IngresoDeSaldo("ingresa la cantidad de dinero:");

				JOptionPane.showMessageDialog(null, "Dinero recargado a la cuenta");
				break;

			case 1:

				valor = RealizarApuestaSemifinal(torneo, saldo);

				break;

			case 2:

				torneo.MostrarFixtureSemifinal();

				break;

			}
		} while (!valor);

	}

	private static boolean RealizarApuestaSemifinal(Torneo torneo, int saldo) {

		Equipo g1 = torneo.getPartidosSemifinales().get(0).JugarPartidoYDevuelveGanador();
		Equipo g2 = torneo.getPartidosSemifinales().get(1).JugarPartidoYDevuelveGanador();
		String mensaje = torneo.MostrarResultadoSemifinal();

		if (saldo != 0) {
			int apuesta = EntradaSalida.IngresaApuesta(saldo);

			String[] opciones = { torneo.getPartidosSemifinales().get(0).InformacionInicialPartido(),
					torneo.getPartidosSemifinales().get(1).InformacionInicialPartido() };

			int seleccion = JOptionPane.showOptionDialog(null, "Selecciona el partido", "Menu torneo",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			switch (seleccion) {
			case 0:
				String[] opciones2 = { torneo.getPartidosSemifinales().get(0).getUno().getNombreEquipo(),
						torneo.getPartidosSemifinales().get(0).getDos().getNombreEquipo() };

				int seleccion2 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opciones2,
						opciones2[0]);

				if (opciones2[seleccion2] == g1.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					mensaje = mensaje + "\n ------APUESTA------ \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, mensaje);

				} else {

					mensaje = mensaje + "\n ------APUESTA------  \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, mensaje);
				}

				break;
			case 1:

				String[] opciones3 = { torneo.getPartidosSemifinales().get(1).getUno().getNombreEquipo(),
						torneo.getPartidosSemifinales().get(1).getDos().getNombreEquipo() };

				int seleccion3 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opciones3,
						opciones3[0]);

				if (opciones3[seleccion3] == g2.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					mensaje = mensaje + "\n ------APUESTA------ \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, mensaje);

				} else {

					mensaje = mensaje + "\n ------APUESTA------ \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, mensaje);
				}
				break;

			}

			CargandoPartidosFinal(g1, g2, torneo);
			MostrarMenuFinal(torneo, saldo);

			return true;
		} else {

			JOptionPane.showMessageDialog(null, "No presentas saldo para seguir jugando con las apuestas!");
			return false;
		}

	}

	private static void CargandoPartidosFinal(Equipo G1, Equipo G2, Torneo torneo) {
		Partido partido1 = new Partido(G1, G2);
		torneo.getPartidoFinal().add(partido1);

	}

	private static void MostrarMenuFinal(Torneo torneo, int saldo) {

		boolean valor = false;
		do {

			String[] opciones = { "Ingresar dinero", "Realizar apuesta", "Mostrar fixture" };

			String mensaje = "Tu saldo es : $" + saldo;

			int seleccion = JOptionPane.showOptionDialog(null, mensaje, "Menu torneo", 0,
					JOptionPane.INFORMATION_MESSAGE, null, opciones, "");

			switch (seleccion) {
			case 0:

				saldo += EntradaSalida.IngresoDeSaldo("ingresa la cantidad de dinero:");
				JOptionPane.showMessageDialog(null, "Dinero recargado a la cuenta");
				break;
			case 1:

				valor = RealizarApuestaFinal(torneo, saldo);
				break;

			case 2:
				String InialPartido = "FINAL\n";
				InialPartido += torneo.getPartidoFinal().get(0).InformacionInicialPartido();
				JOptionPane.showMessageDialog(null, InialPartido);
				break;

			}
		} while (!valor);

	}

	private static boolean RealizarApuestaFinal(Torneo torneo, int saldo) {

		Equipo g1 = torneo.getPartidoFinal().get(0).JugarPartidoYDevuelveGanador();
		String FinalPartido = "RESULTADO\n";
		FinalPartido += torneo.getPartidoFinal().get(0).InformacionFinalPartido();

		if (saldo != 0) {
			int apuesta = EntradaSalida.IngresaApuesta(saldo);

			String[] opciones2 = { torneo.getPartidoFinal().get(0).getUno().getNombreEquipo(),
					torneo.getPartidoFinal().get(0).getDos().getNombreEquipo() };

			int seleccion2 = JOptionPane.showOptionDialog(null, "Selecciona el equipo Ganador:", "Menu torneo",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opciones2, opciones2[0]);

			if (seleccion2 >= 0) {
				if (opciones2[seleccion2] == g1.getNombreEquipo()) {

					apuesta = apuesta * 2;
					saldo = saldo + apuesta;

					FinalPartido = FinalPartido + "\n ------APUESTA------ \n Ganaste $ " + apuesta;

					JOptionPane.showMessageDialog(null, FinalPartido);

				} else {

					FinalPartido = FinalPartido + "\n ------APUESTA------ \n Perdiste $ " + apuesta;
					saldo = saldo - apuesta;
					JOptionPane.showMessageDialog(null, FinalPartido);
				}

			}
			return true;

		} else {
			JOptionPane.showMessageDialog(null, "No presentas saldo para seguir jugando con las apuestas!");

			return false;
		}

	}

	private static void CargarEquiposAleatorios(ArrayList<Equipo> equipos) {
		String[] EquiposName = { "Milan", "Real madrid", "Boca", "River", "Barcelona", "Osasuna", "Racing", "Benfica" };
		String[] EquiposCiudad = { "milan", "madrid", "la boca", "nuñez", "barcelona", "pamplona", "avellaneda",
				"lisboa" };
		int[] EfectividadGoles = { 50, 70, 10, 10, 70, 40, 10, 50 };

		for (int i = 0; i < EquiposName.length; i++) {

			Equipo equipo = CargandoJugadores(EquiposCiudad[i], EquiposName[i], EfectividadGoles[i]);

			equipos.add(equipo);

		}

	}

	private static Equipo CargandoJugadores(String ciudad, String equipoNombre, int efectividad) {
		int cantidadJugador = 8;
		String[] Camiseta = { "POR", "DEF", "DEF", "DEF", "MC", "MC", "DEL", "DEL" };
		Equipo equipo = new Equipo(equipoNombre, ciudad, efectividad);
		String[] cam = { "POR", "DEF", "DEF", "DEF", "MC", "MC", "DEL", "DEL" };

		for (int i = 0; i < cantidadJugador; i++) {

			Jugador jugador = new Jugador("nombre", 20 + i, cam[i], i + 1);

			equipo.agregarJugadorAlEquipo(jugador);
		}

		return equipo;

	}

	/// ***************************************METODOS DE OPCION AGREGAR
	/// EQUIPO**************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	private static void OpcionesAgregarEquipo(ArrayList<String> equiposEliminados, ArrayList<Equipo> equipos) {

		String[] opcionesAgregarEquipo = { "Crear un equipo personalizado", "Crear un equipo armado", "Salir" };

		boolean flag = false;

		do {

			String OpcionSeleccionada = EntradaSalida.SeleccionDeOpciones(opcionesAgregarEquipo, "Crear equipo");

			if (OpcionSeleccionada != null) {

				switch (OpcionSeleccionada) {

				case "Crear un equipo personalizado":

					//// VOY A CREAR MI EQUIPO
					CreandoEquipoPersonalizado(equipos);
					break;

				case "Crear un equipo armado":

					String[] nombresEquipos = { "Juventus", "Manchester United" };

					nombresEquipos = ElimandoEquipoElegidoDeMisOpciones(nombresEquipos, equiposEliminados);

					if (nombresEquipos.length > 0) {

						/// VOY A SELECCIONAR UN EQUIPO ARMADO

						String opcSelecEquipo = EntradaSalida.SeleccionDeOpciones(nombresEquipos,
								"Seleccione un equipo");

						if (opcSelecEquipo != null) {

							equiposEliminados.add(opcSelecEquipo);

							switch (opcSelecEquipo) {

							case "Juventus":

								equipos.add(CargaEquipoPorDefecto("Juventus", "turin"));

								break;

							case "Manchester United":

								equipos.add(CargaEquipoPorDefecto("Manchester United", "Old Trafford"));
								break;
							}

						}

					} else {

						JOptionPane.showMessageDialog(null, "No hay mas equipos disponibles");

					}

					break;

				case "Salir":

					flag = true;

					break;

				}

			} else {

				flag = true;

			}

		} while (!flag);
	}

	private static Equipo CargaEquipoPorDefecto(String nombre, String ciudad) {
		Equipo equipoDefault = new Equipo(nombre, ciudad, 50);

		Jugador jugador = new Jugador("A", 21, "POR", 1);
		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("B", 21, "DEF", 2);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("C", 21, "DEF", 3);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("D", 18, "DEF", 4);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("E", 16, "DEF", 5);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("F", 21, "MC", 6);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("G", 21, "MC", 7);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("H", 31, "MC", 8);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("I", 35, "MC", 9);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("J", 25, "DEL", 10);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		jugador = new Jugador("K", 30, "DEL", 11);

		equipoDefault.agregarJugadorAlEquipo(jugador);

		return equipoDefault;

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

	private static void CreandoEquipoPersonalizado(ArrayList<Equipo> equipos) {/// 1588

		String nombre = EntradaSalida.IngresandoNombreEquipo("Ingresa el nombre del equipo:", equipos);
		String ciudad = EntradaSalida.IngresandoCiudad("Ingresa el nombre de la ciudad del equipo:");
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

	private static Jugador CreandoJugadorPorEntradaDeDatos(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		String nombre = EntradaSalida.IngresandoNombreJugador("Ingresa el nombre del jugador: ", equipos,
				EquipoSeleccionado);
		int edadNum = EntradaSalida.IngresandoEdadJugador("Ingresa la edad del jugador :", equipos, EquipoSeleccionado);
		String posicion = EntradaSalida.IngresandoPosicionJugador("\nIngresa la posicion del jugador: ", equipos,
				EquipoSeleccionado);
		int numCamisetaEntero = EntradaSalida.IngresandoNumeroCamiseta("Ingresa el numero de la camiseta: ", equipos,
				EquipoSeleccionado);
		Jugador jugador = new Jugador(nombre, edadNum, posicion, numCamisetaEntero);

		return jugador;

	}

	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	/// ********************************************************ELIMINAR
	/// EQUIPO**************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	private static void EliminandoEquipo(ArrayList<Equipo> equipos, ArrayList<String> equiposEliminados) {

		if (!equipos.isEmpty()) {
			String[] opciones = ConvirtiendoArrayDeEquiposEnArrayDeOpciones(equipos);

			String opcionSeleccionada = EntradaSalida.SeleccionDeOpciones(opciones, "Eliminando equipo");
			Equipo equipoSeleccionado = BuscandoEquipoSeleccionado(opcionSeleccionada, equipos);

			if (equipoSeleccionado != null) {
				EliminarElEquipoSeleccionado(equipoSeleccionado, equipos);
				VolviendoAseleccionElEquipoEliminado(equipoSeleccionado, equiposEliminados);

			}

		} else {

			JOptionPane.showMessageDialog(null, "No hay equipos");
		}

	}

	private static String[] ConvirtiendoArrayDeEquiposEnArrayDeOpciones(ArrayList<Equipo> equipos) {
		ArrayList<String> equiposString = new ArrayList<String>();

		for (Equipo equipo : equipos) {

			equiposString.add(equipo.getNombreEquipo());

		}

		return equiposString.toArray(new String[0]);

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

	private static void EliminarElEquipoSeleccionado(Equipo equipoSeleccionado, ArrayList<Equipo> equipos) {

		for (int i = 0; i < equipos.size(); i++) {

			if (equipoSeleccionado.getNombreEquipo().equalsIgnoreCase(equipos.get(i).getNombreEquipo())) {

				equipos.remove(i);

			}
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
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	/// ********************************************************MODIFICAR
	/// EQUIPO*************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	private static void ModificarEquipo(ArrayList<Equipo> equipos) {

		if (!equipos.isEmpty()) {

			String[] opciones = ConvirtiendoArrayDeEquiposEnArrayDeOpciones(equipos);

			String opcionSeleccionada = EntradaSalida.SeleccionDeOpciones(opciones, "Modificar equipo");
			OpcionesModicarEquipo(opcionSeleccionada, equipos);

		} else {

			JOptionPane.showMessageDialog(null, "No hay equipos");

		}

	}

	private static void OpcionesModicarEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		String[] Opciones = { "Modificar nombre del equipo", "Modificar ciudad del equipo", "Modificar plantilla",
				"Salir" };

		boolean flag = false;

		do {

			String opcionSeleccionada = EntradaSalida.SeleccionDeOpciones(Opciones, "Modificar equipo");

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

				case "Salir":

					flag = true;

					break;

				}

			} else {

				flag = true;
			}

		} while (!flag);

	}

	private static void ModificarCiudadDelEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {

		String NuevoNombreCiudad = EntradaSalida.IngresandoCiudad("Ingresa el nuevo nombre de la ciudad:");

		if (NuevoNombreCiudad != null) {

			for (int i = 0; i < equipos.size(); i++) {

				if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

					equipos.get(i).setCiudad(NuevoNombreCiudad);
					;

				}

			}
		}

	}

	private static void OpcionesDeModificarPlantilla(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		String[] OpcionesModificaEqupo = { "Agregar jugador al equipo", "Eliminar jugador del equipo",
				"Lista de jugadores", "Salir" };

		boolean flag = false;
		do {
			String opcionSeleccionada = EntradaSalida.SeleccionDeOpciones(OpcionesModificaEqupo, "Modificar plantilla");

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
				case "Salir":

					flag = true;

					break;

				}

			} else {

				flag = true;

			}
		} while (!flag);

	}

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

	private static void EliminarJugadorDelEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		Equipo equipoSelec = BuscandoEquipoSeleccionado(EquipoSeleccionado, equipos);

		if (equipoSelec != null) {
			String[] nombreDeJugadores = ConvirtiendoArrayListDeJugadorEnArrayOpciones(equipoSelec.getJugadores());

			if (equipoSelec.getJugadores().size() != 0) {

				String opcionSeleccionada = EntradaSalida.SeleccionDeOpciones(nombreDeJugadores,
						"Eliminar jugador del equipo");

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

	private static String[] ConvirtiendoArrayListDeJugadorEnArrayOpciones(ArrayList<Jugador> jugadores) {
		ArrayList<String> jugadoresString = new ArrayList<String>();

		for (Jugador jugador : jugadores) {

			jugadoresString.add(jugador.getNombre());

		}

		return jugadoresString.toArray(new String[0]);

	}

	private static int BuscandoCantidadDeJugadoresDeMiEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {
		int CantidadDeJugadores = 0;

		for (int i = 0; i < equipos.size(); i++) {

			if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

				CantidadDeJugadores = equipos.get(i).getJugadores().size();

			}

		}

		return CantidadDeJugadores;

	}

	private static void ModificarNombreDelEquipo(String EquipoSeleccionado, ArrayList<Equipo> equipos) {

		String Nuevonombre = EntradaSalida.IngresandoNombreEquipo("Ingresa el nuevo nombre del equipo:", equipos);
		if (Nuevonombre != null) {

			for (int i = 0; i < equipos.size(); i++) {

				if (equipos.get(i).getNombreEquipo().equals(EquipoSeleccionado)) {

					equipos.get(i).setNombreEquipo(Nuevonombre);

				}

			}
		}

	}

	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// ***********************************************************MOSTRAR
	/// INFORMACION
	/// EQUIPOS***********************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
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

	/// *******************************************JUGAR PARTIDO
	/// 1vs1************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

	private static void PartidoVersusUnoContraUno(ArrayList<Equipo> equipos) {

		if (equipos.size() == 2) {

			Modo1vs1Confirmado(equipos);

		} else if (equipos.size() > 2) {

			Modo1vs1Seleccionado(equipos);

		} else {

			JOptionPane.showMessageDialog(null, "TE FALTAN EQUIPOS.. PARA JUGAR ESTE MODO...");

		}

	}

	private static void Modo1vs1Confirmado(ArrayList<Equipo> equipos) {
		Equipo uno = equipos.get(0);
		Equipo dos = equipos.get(1);
		Partido partidoOficial = new Partido(uno, dos);
		if (uno.getJugadores().size() < 8 || dos.getJugadores().size() < 8) {

			JOptionPane.showMessageDialog(null,
					"Error , uno de lo equipo no presenta suficientes jugadores[MINIMO= 8 JUGADORES]...");
		} else {

			partidoOficial.JugandoPartido1vs1();
		}

	}

	private static void Modo1vs1Seleccionado(ArrayList<Equipo> equipos) {

		String[] opciones = ConvirtiendoArrayDeEquiposEnArrayDeOpciones(equipos);

		String opcionSeleccionada = EntradaSalida.SeleccionDeOpciones(opciones, "Partido 1 vs 1 ");

		opciones = ActualizandoMiArrayDeOpciones(opciones, opcionSeleccionada);

		String opcionSeleccionada2 = EntradaSalida.SeleccionDeOpciones(opciones, "Partido 1 vs 1 ");
		Partido partidoOficial;
		if (opcionSeleccionada != null && opcionSeleccionada2 != null) {

			Equipo uno;
			Equipo dos;

			uno = BuscandoEquipoSeleccionado(opcionSeleccionada, equipos);
			dos = BuscandoEquipoSeleccionado(opcionSeleccionada2, equipos);

			if (uno.getJugadores().size() >= 8 && dos.getJugadores().size() >= 8) {
				partidoOficial = new Partido(uno, dos);
				partidoOficial.JugandoPartido1vs1();
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

	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************
	/// *************************************************************************************************************************************************

}
