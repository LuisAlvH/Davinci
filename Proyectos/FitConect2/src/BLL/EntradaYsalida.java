package BLL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import DLL.ControllerAreaEntrenamiento;
import DLL.ControllerCliente;
import DLL.ControllerDatosPersonales;
import DLL.ControllerEjercicio;
import DLL.ControllerMenu;
import DLL.ControllerObjetivo;
import DLL.ControllerRutina;

public class EntradaYsalida {

	private static Scanner scanner = new Scanner(System.in);

	
	
	
	
	
	public static ArrayList<Rutina> arrayPerfilesInicioSesion() {
		
		 ArrayList<Rutina> rutinas = new ArrayList<>();
		
		int numeroTotal=ControllerRutina.ObteniendoTotalRegistrosRutina();
		
		 if (numeroTotal > 0) {
			
		ArrayList<Integer>numeros;
		
		int numeroTotalRegistroAmostrar=8;
		HashSet<Integer> valoresUnicos = new HashSet<>();//LISTA DE VALORES UNICOS
		Random random = new Random();
		
		
		while(valoresUnicos.size()<=numeroTotalRegistroAmostrar) {
			
		int	numeroEnteroLimitado = random.nextInt(numeroTotal) + 1;
		 valoresUnicos.add(numeroEnteroLimitado); //AÑADE SOLO SI EL VALOR ES UNICO , SI NO AÑADE NADA
		}
		 Integer[] ArrayDeValoresUnicos=valoresUnicos.toArray(new Integer[0]);
	
		
		for (int i = 0; i < numeroTotalRegistroAmostrar; i++) {
			
			rutinas.add(ControllerRutina.ObteniendoRutinaBuscada(ArrayDeValoresUnicos[i]));
			
		}
		
		 }else {
			 
			 
		 }
		 
	return rutinas;
	}
	
	public static int OpcionesBusquedaRutinaNoConectado(String texto) {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero(texto);

			if (num < 1 || num > 2) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);

		return num;
	}
	
	
	
	
	
	
	
	
	public static int OpcionesBusquedaRutina(String texto) {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero(texto);

			if (num < 1 || num > 3) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);

		return num;
	}
	public static void buscandoRutinasNoConectado() {
		boolean flag = true;

		do {
			String nombreDeLaActividad = EntradaYsalida.ingresoUnString("\ningresa la actividad deportiva:");

			if (nombreDeLaActividad.length() >= 3) {
				String busqueda = obtenerCaracteresDosYTres(nombreDeLaActividad);

				ArrayList<Integer> misRutinas = ControllerRutina.obteniendoRutinasDelBuscador(busqueda);

				if (misRutinas.size() != 0) {

					System.out.println("\t**RESULTADOS DE BUSQUEDAS**\t");
					int contador = 0;
					int opcion = 0;
					for (Integer rutina : misRutinas) {

						System.out.println("\n\t*Rutina [ Opcion " + (contador + 1) + "]*\t");

						ControllerRutina.mostrasInformacionRutina(rutina.intValue());
						contador++;

					}

					opcion = OpcionesBusquedaRutinaNoConectado("\n[1-Ver rutina] [2-Salir]");

					switch (opcion) {
				
					case 1:
						int contador2 = 0;
						for (Integer rutina : misRutinas) {

							System.out.println("\n\t*Rutina [ Opcion " + (contador2 + 1) + "]*\t");

							ControllerRutina.mostrasInformacionRutina(rutina.intValue());
							contador2++;

						}
						int opcion2 = SioNoOpcionesRutina("\nSELECCIONA UNA RUTINA :", contador2 + 1);

						System.out.println("\n\t**Ejercicios de la rutina seleccionada**\t\n");
						ControllerEjercicio.mostrarInformacionEjercicio(misRutinas.get(opcion2 - 1));

						break;
						
					case 2:
						flag = false;
						break;
					
					}

				} else {

					System.out.println("\n\tNo se encontraron resultados..");
					flag = false;
				}
				

			} else {
				System.out.println("Error , ingresa mas de 3 caracteres");
			}
		} while (flag);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	public static void buscandoRutinasUsuarioConectado(int id_cliente) {
		boolean flag = true;

		do {
			String nombreDeLaActividad = EntradaYsalida.ingresoUnString("\ningresa la actividad deportiva:");

			if (nombreDeLaActividad.length() >= 3) {
				String busqueda = obtenerCaracteresDosYTres(nombreDeLaActividad);

				ArrayList<Integer> misRutinas = ControllerRutina.obteniendoRutinasDelBuscador(busqueda);

				if (misRutinas.size() != 0) {

					System.out.println("\t**RESULTADOS DE BUSQUEDAS**\t");
					int contador = 0;
					int opcion = 0;
					for (Integer rutina : misRutinas) {

						System.out.println("\n\t*Rutina [ Opcion " + (contador + 1) + "]*\t");

						ControllerRutina.mostrasInformacionRutina(rutina.intValue());
						contador++;

					}

					opcion = OpcionesBusquedaRutina("\n[1-Ver rutina] [2-Agregar rutina] [3-Dar like]");

					switch (opcion) {

					case 1:
						int contador2 = 0;
						for (Integer rutina : misRutinas) {

							System.out.println("\n\t*Rutina [ Opcion " + (contador2 + 1) + "]*\t");

							ControllerRutina.mostrasInformacionRutina(rutina.intValue());
							contador2++;

						}
						int opcion2 = SioNoOpcionesRutina("\nSELECCIONA UNA RUTINA :", contador2 + 1);

						System.out.println("\n\t**Ejercicios de la rutina seleccionada**\t\n");
						ControllerEjercicio.mostrarInformacionEjercicio(misRutinas.get(opcion2 - 1));

						break;
					case 2:

						/// AGREGAR RUTINA

						int contador5 = 0;
						for (Integer rutina : misRutinas) {

							System.out.println("\n\t*Rutina [ Opcion " + (contador5 + 1) + "]*\t");

							ControllerRutina.mostrasInformacionRutina(rutina.intValue());
							contador5++;

						}
						int opcion5 = SioNoOpcionesRutina("\nSELECCIONA UNA RUTINA :", contador5 + 1);

						Rutina ruti = ControllerRutina.ObteniendoRutinaBuscada(misRutinas.get(opcion5 - 1));
						ruti.setUsuarioCreador(ControllerCliente.encontrandoUsuario(id_cliente));
						ArrayList<Integer> EjerciciosID = ControllerEjercicio
								.obteniendoInformacionIdEjercicios(misRutinas.get(opcion5 - 1));
						
						int id_nuevaRutina = ControllerRutina.agregarRutina(ruti);
						
						int id_menu=ControllerMenu.obtenerIdMenu(id_cliente);
						
						ControllerMenu.agregarRutinaHasMenu(id_menu,id_nuevaRutina);
					
						for (Integer id_ejercicio : EjerciciosID) {
							ControllerEjercicio.agregarRutinaHasEjercicio(id_nuevaRutina, id_ejercicio);
						}

						System.out.println("\n\tSe agrego rutina..");
						break;
					case 3:

						int contador3 = 0;
						for (Integer rutina : misRutinas) {

							System.out.println("\n\t*Rutina [ Opcion " + (contador3 + 1) + "]*\t");

							ControllerRutina.mostrasInformacionRutina(rutina.intValue());
							contador3++;

						}
						int opcion3 = SioNoOpcionesRutina("\nSELECCIONA UNA RUTINA :", contador3 + 1);
						ControllerRutina.ActualizandoPopularidadRutina(misRutinas.get(opcion3 - 1));

						break;


					}

				} else {

					System.out.println("\n\tNo se encontraron resultados..");
					flag = false;
				}
				int Salir = EntradaYsalida.SioNoOpciones("\nDesea salir de la busqueda ? [1-Si] [2-No]");
				if (Salir == 1) {
					flag = false;
				}

			} else {
				System.out.println("Error , ingresa mas de 3 caracteres");
			}
		} while (flag);

	}

	public static String obtenerCaracteresDosYTres(String busqueda) {

		String Resultado;

		char segundoCaracter = busqueda.charAt(1);
		char tercerCaracter = busqueda.charAt(2);

		return Resultado = "" + segundoCaracter + tercerCaracter;

	}

	public static ArrayList<Integer> obteniendoRutinasC(ArrayList<Integer> RutinasTotales) {
		ArrayList<Integer> misRutinasC = new ArrayList<Integer>();

		for (Integer rutina : RutinasTotales) {

			misRutinasC.add(ControllerRutina.obteniendoIdRutinaC(1));
		}

		return misRutinasC;

	}

	public static void mostrarRutinasCompartidasC(int id_cliente) {

		int id_menu = ControllerMenu.obtenerIdMenu(id_cliente);

		ArrayList<Integer> misRutinasC = ControllerMenu.obteniendoRutinasId(id_menu);

		if (misRutinasC.size() != 0) {

			System.out.println("\t**MIS RUTINAS COMPARTIDAS**\t");
			int contador = 0;
			int opcion = 0;
			for (Integer rutina : misRutinasC) {

				System.out.println("\n\t*Rutina [ Opcion " + (contador + 1) + "]*\t");
				ControllerRutina.mostrasInformacionRutinaUsuario(rutina.intValue());
				contador++;

			}

			opcion = SioNoOpcionesRutina("\nSELECCIONA UNA RUTINA :", contador + 1);

			System.out.println("\n\t**Ejercicios de la rutina seleccionada**\t\n");
			ControllerEjercicio.mostrarInformacionEjercicio(misRutinasC.get(opcion - 1));

			int continuarOpciones = OpcionesCRUD(
					"\n[1-Modificar rutina] [2-Modificar ejercicios] [3-Descompartir rutina] [4-Eliminar rutina] ");

			switch (continuarOpciones) {
			case 1:

				String titulo = EntradaYsalida.ingresoUnString("ingresa titulo de la rutina:");
				String actividad_deportiva = EntradaYsalida.ingresoUnString("ingresa la actividad :");
				String dificultad = EntradaYsalida.ingresoUnString("ingresa la dificultad :");
				ControllerRutina.actualizarRutina2(misRutinasC.get(opcion - 1), dificultad, actividad_deportiva,
						dificultad);

				System.out.println("\n\t rutina se ha modificado...");
				break;

			case 2:
				ArrayList<Ejercicio> misEjercicicos = ControllerEjercicio
						.obtenerInformacionEjecicio(misRutinasC.get(opcion - 1));

				int contador3 = 0;

				for (Ejercicio ejercicio : misEjercicicos) {

					System.out.println("\tEjercicio  " + (contador3 + 1));
					String nombreEjer = EntradaYsalida.ingresoUnString("ingresa el nombre del ejercicio");
					int serie = EntradaYsalida.IngresoEntero("Cantidad total de series: ");
					int descanso = EntradaYsalida.IngresoEntero("Tiempo de descanso por cada serie:");
					int repeticiones = EntradaYsalida.IngresoEntero("La cantidad de repeticiones :");

					ejercicio.setNombre(nombreEjer);
					ejercicio.setSerie(serie);
					ejercicio.setDescansoEntreSerie(descanso);
					ejercicio.setRepeticiones(repeticiones);

					ControllerEjercicio.actualizarEjercicio2(ejercicio);
					contador3++;
				}

				System.out.println("\n\t Se ha completado la actualizacion...");

				break;

			case 3:
				int Descompartir = EntradaYsalida.SioNoOpciones("\nDesea descompartir la rutina ? [1-Si] [2-No]");

				if (Descompartir == 1) {
					ControllerRutina.actualizarRutina3(misRutinasC.get(opcion - 1), 0);
					System.out.println("\t rutina descompartida...");
				}

				break;

			case 4:
				int Eliminar = EntradaYsalida.SioNoOpciones("\nDesea eliminar la rutina ? [1-Si] [2-No]");

				if (Eliminar == 1) {
					ControllerRutina.EliminarRutina(misRutinasC.get(opcion - 1));
					System.out.println("Se ha eliminado la rutina..");

				}

				break;

			}

		} else {

			System.out.println("\n\tNo tenes ninguna rutina guardada...");
		}
	}

	public static void mostrarRutinasCompartidas(int id_cliente) {

		int id_menu = ControllerMenu.obtenerIdMenu(id_cliente);

		ArrayList<Integer> misRutinas = ControllerMenu.obteniendoRutinasIdSinCompartir(id_menu);

		if (misRutinas.size() != 0) {

			System.out.println("\t**MIS RUTINAS**\t");
			int contador = 0;
			int opcion = 0;
			for (Integer rutina : misRutinas) {

				System.out.println("\n\t*Rutina [ Opcion " + (contador + 1) + "]*\t");
				ControllerRutina.mostrasInformacionRutinaUsuario(rutina.intValue());
				contador++;

			}

			opcion = SioNoOpcionesRutina("\nSELECCIONA UNA RUTINA :", contador + 1);

			System.out.println("\n\t**Ejercicios de la rutina seleccionada**\t\n");
			ControllerEjercicio.mostrarInformacionEjercicio(misRutinas.get(opcion - 1));

			int continuarOpciones = OpcionesCRUD(
					"\n[1-Modificar rutina] [2-Modificar ejercicios] [3-Compartir rutina] [4-Eliminar rutina] ");

			switch (continuarOpciones) {
			case 1:

				String titulo = EntradaYsalida.ingresoUnString("ingresa titulo de la rutina:");
				String actividad_deportiva = EntradaYsalida.ingresoUnString("ingresa la actividad :");
				String dificultad = EntradaYsalida.ingresoUnString("ingresa la dificultad :");
				ControllerRutina.actualizarRutina2(misRutinas.get(opcion - 1), dificultad, actividad_deportiva,
						dificultad);

				System.out.println("\n\t rutina se ha modificado...");
				break;

			case 2:
				ArrayList<Ejercicio> misEjercicicos = ControllerEjercicio
						.obtenerInformacionEjecicio(misRutinas.get(opcion - 1));

				int contador3 = 0;

				for (Ejercicio ejercicio : misEjercicicos) {

					System.out.println("\tEjercicio  " + (contador3 + 1));
					String nombreEjer = EntradaYsalida.ingresoUnString("ingresa el nombre del ejercicio");
					int serie = EntradaYsalida.IngresoEntero("Cantidad total de series: ");
					int descanso = EntradaYsalida.IngresoEntero("Tiempo de descanso por cada serie:");
					int repeticiones = EntradaYsalida.IngresoEntero("La cantidad de repeticiones :");

					ejercicio.setNombre(nombreEjer);
					ejercicio.setSerie(serie);
					ejercicio.setDescansoEntreSerie(descanso);
					ejercicio.setRepeticiones(repeticiones);

					ControllerEjercicio.actualizarEjercicio2(ejercicio);
					contador3++;
				}

				System.out.println("\n\t Se ha completado la actualizacion...");

				break;

			case 3:
				int Descompartir = EntradaYsalida.SioNoOpciones("\nDesea compartir la rutina ? [1-Si] [2-No]");

				if (Descompartir == 1) {
					ControllerRutina.actualizarRutina3(misRutinas.get(opcion - 1), 1);
					System.out.println("\t rutina compartida...");
				}

				break;

			case 4:
				int Eliminar = EntradaYsalida.SioNoOpciones("\nDesea eliminar la rutina ? [1-Si] [2-No]");

				if (Eliminar == 1) {
					ControllerRutina.EliminarRutina(misRutinas.get(opcion - 1));
					System.out.println("Se ha eliminado la rutina..");

				}

				break;

			}

		} else {

			System.out.println("\n\tNo tenes ninguna rutina guardada...");
		}
	}

	public static int OpcionesCRUD(String texto) {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero(texto);

			if (num < 1 || num > 4) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);

		return num;
	}

	public static int SioNoOpcionesRutina(String texto, int valorMaxOpciones) {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero(texto);

			if (num < 1 || num > valorMaxOpciones) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);

		return num;
	}

	public static void crearRutina(int id_usuario) {
		boolean flag = true;
		String titulo = EntradaYsalida.ingresoUnString("ingresa titulo de la rutina:");
		String actividad_deportiva = EntradaYsalida.ingresoUnString("ingresa la actividad :");
		
		
		String usser = ControllerCliente.encontrandoUsuario(id_usuario);
		Rutina rutina = new Rutina(titulo, "VACIO", 0, 0, actividad_deportiva, usser, 0);
		int id_rutina = ControllerRutina.agregarRutina(rutina);
		int id_menu = ControllerMenu.obtenerIdMenu(id_usuario);
		ControllerMenu.agregarRutinaHasMenu(id_menu, id_rutina);
		;

		int contador = 0;
		int valorMaximo = 4;
		int acumuladorPuntosRutina = 0;
		do {
			contador++;
			Ejercicio ejercicio = EntradaYsalida.RegistrandoEjercicios();
			acumuladorPuntosRutina += ejercicio.getPointDeProgreso();
			int id_ejercicio = ControllerEjercicio.agregarEjercicio(ejercicio);
			ControllerEjercicio.agregarRutinaHasEjercicio(id_rutina, id_ejercicio);
			if (contador >= valorMaximo) {
				int Finalizar = EntradaYsalida.SioNoOpciones("\nDesea dar finalizada la rutina ? [1-Si] [2-No]");

				if (Finalizar == 1) {
					flag = false;
				} else {
					valorMaximo = valorMaximo + valorMaximo;
				}

			}

		} while (flag);

		String dificultad = EntradaYsalida.ingresoUnString("ingresa la dificultad :");
		int comparte = EntradaYsalida.SioNoOpciones("\nSe comparte la rutina ? [1-Si] [2-No]");

		/// popularidad_rutina [double] puntos_progreso [int]

		ControllerRutina.actualizarRutina(id_rutina, dificultad, comparte, acumuladorPuntosRutina);

	}

	public static Ejercicio RegistrandoEjercicios() {
		Ejercicio ejerci = null;
		int guardar = 0;
		do {

			System.out.println("\tATENCION: MINIMO 4 EJERCICIO PARA QUE SEA UNA RUTINA");
			String nombre = EntradaYsalida.ingresoUnString("Ingresa el nombre del ejercicio:");
			int serie = EntradaYsalida.IngresoEntero("Cantidad total de series: ");
			int descanso = EntradaYsalida.IngresoEntero("Tiempo de descanso por cada serie:");
			int repeticiones = EntradaYsalida.IngresoEntero("La cantidad de repeticiones :");
			double puntos_progre_ejerci = (serie * repeticiones / 100);

			guardar = EntradaYsalida.SioNoOpciones("\n Guardar ejercicio ? [1-Si] [2-No]");
			if (guardar == 1)
				ejerci = new Ejercicio(nombre, serie, repeticiones, descanso, puntos_progre_ejerci);

		} while (guardar == 2);

		return ejerci;
	}

	public static int SioNoOpciones(String texto) {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero(texto);

			if (num != 1 && num != 2) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);

		return num;
	}

	public static void ModificarUsuario(int id_usuario) {
		boolean flag = true;
		int OpcionSelecionada;
		do {
			ControllerMenu.mostrasInformacion(id_usuario);
			OpcionSelecionada = EntradaYsalida.seleccioneOpcionModificarPerfil();

			switch (OpcionSelecionada) {
			case 1:
				//// UPDATE
				int id_datos = ControllerDatosPersonales.obtenerIdDatos(id_usuario);
				String nombre = EntradaYsalida.ingresoUnString("ingresa tu nombre :");
				String apellido = EntradaYsalida.ingresoUnString("ingresa tu apellido :");
				String telefono = EntradaYsalida.ingresoUnString("ingresa tu telefono :");
				int edad = EntradaYsalida.IngresoEntero("ingresa tu edad :");
				String email = EntradaYsalida.ingresoUnString("ingresa tu email :");

				ControllerDatosPersonales.ActualizarDatosPersonales(id_datos, nombre, apellido, edad, telefono, email);
				
				int[] ids = ControllerMenu.obtenerIdsMenu(id_usuario);
			
				String tipo = EntradaYsalida.ingresoUnString("ingresa el tipo de objetivo :");
				ControllerObjetivo.actualizarObjetivo(ids[0], tipo);
				String espacio = EntradaYsalida
						.ingresoUnString("ingresa el espacio[ejemplos:box de crossfit/gimnasio/Cancha de futbol]:");
				String barrio = EntradaYsalida.ingresoUnString("ingresa el barrio :");
				String direccion = EntradaYsalida.ingresoUnString("ingresa la direccion :");
				ControllerAreaEntrenamiento.actualizarArenaEntrenamiento(ids[1], espacio, barrio, direccion);

				break;

			case 2:

				String cActual = EntradaYsalida.ingresoUnString("ingresa contraseña actual :");

				while (!ControllerCliente.ValidacionDePassword(id_usuario, cActual)) {

					System.out.println("\tError, ingresa tu contraseña actual..\t\n");
					cActual = EntradaYsalida.ingresoUnString("ingresa contraseña actual :");
				}
				String cNueva = EntradaYsalida.ingresoUnString("ingresa la nueva contraseña :");
				ControllerCliente.actualizarPassword(id_usuario, cNueva);
				break;
			case 3:
				/// SALIR
				flag = false;
				break;
			}

		} while (flag);

	}

	public static int seleccioneOpcionModificarPerfil() {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero(
					"\t\t*SELECCIONA OPCION*\t\n[1-Modificar informacion] [2-Cambiar contraseña] [3-Salir]");

			if (num != 1 && num != 2 && num != 3) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			}

		} while (flag);

		return num;
	}

	public static void registrandoUsuario() {

		String nombre = ingresoUnString("ingresa un nombre :");
		String apellido = ingresoUnString("ingresa el apellido :");
		String email = ingresoUnString("ingresa el email :");
		int edad = IngresoEntero("ingresa la edad:");
		String telefono = ingresoUnString("ingresa el telefono:");
		ControllerDatosPersonales.AgregandoDatoPersonales(new DatosPersonales(nombre, apellido, edad, telefono, email));
		int id_dato_personal = ControllerDatosPersonales.buscandoIdDatosPersonales(nombre, apellido);

		String usuario = ingresoUnString("ingresa el usuario:");
		String pass = ingresoUnString("ingresa el password:");

		while (ControllerCliente.existeElUsuarioEnLaBd(usuario, pass)) {
			System.out.println("\tERROR, INGRESASTE UN USUARIO EXISTENTE...\n");
			usuario = ingresoUnString("ingresa el usuario:");
			pass = ingresoUnString("ingresa el password:");
		}

				ControllerMenu.agregarMenu(ControllerObjetivo.agregarObjetivo(new Objetivo()),
				ControllerAreaEntrenamiento.agregarAreaEntrenamiento(new AreaEntrenamiento()),
				ControllerCliente.agregarCliente(usuario, pass, id_dato_personal));

	}

	public static int IngresoEntero(String texto) {
		int num = 0;

		boolean error = false;

		do {

			System.out.println(texto);

			if (scanner.hasNextInt()) {
				num = scanner.nextInt();

				if (num <= 0) {

					System.out.println("[ERROR: ingresa un valor mayor a 0...]\n");
					error = true;
				} else {
					error = false;
				}

			} else {
				System.out.println("[ERROR: ingresa un valor entero...]\n");
				scanner.next();
				error = true;
			}

		} while (error);

		scanner.nextLine();
		return num;

	}

	public static String ingresoUnString(String texto) {

		String palabra;

		do {

			System.out.println(texto);

			palabra = scanner.nextLine();

			if (palabra.isEmpty()) {

				System.out.println("[ERROR: el usuario no puede ser vacio...]\n");

			}

		} while (palabra == null || palabra.isEmpty());

		return palabra;

	}

	

	public static String ingresaStringSinEspacios(String texto) {

		String palabra;

		do {

			System.out.println(texto);

			palabra = scanner.nextLine();

			if (palabra.isEmpty()) {

				System.out.println("[ERROR: el usuario no puede ser vacio...]\n");

			}
			if (palabra.contains(" ")) {
				System.out.println("[ERROR: no puedes usar espacios en blanco..]\n");
			}

		} while (palabra == null || palabra.isEmpty() || palabra.contains(" "));

		return palabra;

	}

	public static int UsuarioSeleccionOpcion() {
		boolean flag = false;
		int num;
		do {

			num = EntradaYsalida.IngresoEntero("\n[1-Iniciar sesion] [2-Registrarse] [3-Buscar] [4-Salir]");

			if (num != 1 && num != 2 && num != 3 && num != 4) {

				System.out.println("Opcion incorrecta..");
				flag = true;
			}

		} while (flag);

		return num;
	}

	public static String IngresoUsuario() {
		String usuario = "";

		System.out.println("Ingresa el usuario:");
		do {

			try {

				usuario = scanner.nextLine();

			} catch (NullPointerException e) {
				System.err.println("Error, capturado.");
				scanner.nextLine();

			}

		} while (usuario.isEmpty());

		return usuario;

	}

	public static String IngresoPassword() {

		String pass;

		do {

			System.out.println("Ingresa la contraseña:");
			pass = scanner.nextLine();

			if (pass.isEmpty())
				System.out.println("[ERROR: la contraseña no puede ser vacio...]\n");

		} while (pass == null || pass.isEmpty());

		return pass;

	}
	
	public static void modificandoInformacion(int id_usuario,String nombre,String apellido,int edad,String telefono,String email,String tipo,String espacio,String barrio,String direccion){
		int id_datos=ControllerDatosPersonales.obtenerIdDatos(id_usuario);
		ControllerDatosPersonales.ActualizarDatosPersonales(id_datos, nombre, apellido, edad, telefono, email);
		
		int[] ids = ControllerMenu.obtenerIdsMenu(id_usuario);
		ControllerObjetivo.actualizarObjetivo(ids[0], tipo);
		ControllerAreaEntrenamiento.actualizarArenaEntrenamiento(ids[1], espacio, barrio, direccion);
	}
	public static boolean cambiarPassword(String passActual , int id_usuario) {
		
		
		

		return ControllerCliente.ValidacionDePassword(id_usuario, passActual);
		
		
	}
	
	
	public static void actualizarPassword(int id_usuario,String cNueva) {
		
		ControllerCliente.actualizarPassword(id_usuario, cNueva);
	}
	
	public static ArrayList<Integer>obteniendoRutinasBuscador(String busqueda) {
		
		
		ArrayList<Integer> misRutinas = ControllerRutina.obteniendoRutinasDelBuscador(busqueda);
		return misRutinas;
	}
	
	public static void darLikeRutina(int id_rutina) {
		
		
		ControllerRutina.ActualizandoPopularidadRutina(id_rutina);
		
	}
	
	
	
	
	
	public static void agregandoRutina(int id_rutina, int id_cliente) {
		
		Rutina ruti = ControllerRutina.ObteniendoRutinaBuscada(id_rutina);
		ruti.setPuntos_progreso(0);
		ruti.setPopularidadRutina(0);
		ruti.setUsuarioCreador(ControllerCliente.encontrandoUsuario(id_cliente));
		ArrayList<Integer> EjerciciosID = ControllerEjercicio
				.obteniendoInformacionIdEjercicios(id_rutina);
		
		int id_nuevaRutina = ControllerRutina.agregarRutina(ruti);
		
		int id_menu=ControllerMenu.obtenerIdMenu(id_cliente);
		
		ControllerMenu.agregarRutinaHasMenu(id_menu,id_nuevaRutina);
	
		for (Integer id_ejercicio : EjerciciosID) {
			ControllerEjercicio.agregarRutinaHasEjercicio(id_nuevaRutina, id_ejercicio);
		}
		
	}
	
	
	public static ArrayList<Ejercicio> ObteniendoListaDeEjerci(int id_rutina){
		
		
		return ControllerEjercicio.obteniendoInformacionEjercicio(id_rutina);
		
	}
	
	public static ArrayList<Integer>obteneniendoRutiSinCompa(int id_cliente) {
		
		int id_menu = ControllerMenu.obtenerIdMenu(id_cliente);

		
		
		return ControllerMenu.obteniendoRutinasIdSinCompartir(id_menu);
	}
	
	public static Rutina obteniendoRutinaSinComp(int id_rutina) {
		
		return ControllerRutina.obteniendoRutsSinCompartirUsuario(id_rutina);
	}
	
	
	public static void actualizarRutnaAtributoCompartida(int id_rutina,int id_compartida) {
		
	
		 ControllerRutina.actualizarRutina3(id_rutina, id_compartida);
	}
	
	public static void eliminarRutna(int id_rutina) {
		
		
		ControllerRutina.EliminarRutina(id_rutina);
	}
	public static ArrayList<Ejercicio> obteniendoInformacionEjerciciosALL(int id_rutina) {
		
		
		 return  ControllerEjercicio.obtenerInformacionEjecicio(id_rutina);
	}
	public static void ActualziarEjercicio(Ejercicio ejerc) {
		
		
		ControllerEjercicio.actualizarEjercicio2(ejerc);
	}
	
	public static void ActualizarRutina(int id_rutina,String dificultad, String actividad_deportiva, String titulo) {
		
		
	ControllerRutina.actualizarRutina2(id_rutina, dificultad, actividad_deportiva,titulo);
	}
	public static ArrayList<Integer>obteneniendoRutiCompa(int id_cliente) {
		
		int id_menu = ControllerMenu.obtenerIdMenu(id_cliente);

		
		
		return ControllerMenu.obteniendoRutinasId(id_menu);
	}
	public static int GuardandoRutinaInicial(int id_usuario,String actividad_deportiva,String titulo ,String dificultad,int comparte,int acumuladorPuntosrutina) {
		
	String usser = ControllerCliente.encontrandoUsuario(id_usuario);
	Rutina rutina = new Rutina(titulo, "VACIO", 0, 0, actividad_deportiva, usser, 0);
	int id_rutina = ControllerRutina.agregarRutina(rutina);
	ControllerRutina.actualizarRutina(id_rutina, dificultad, comparte, acumuladorPuntosrutina);
	int id_menu = ControllerMenu.obtenerIdMenu(id_usuario);
	ControllerMenu.agregarRutinaHasMenu(id_menu, id_rutina);
		
		return id_rutina;
		
	}
	
	public static void ActualizarRutis(int id_rutina,String  dificultad,  int comparte, int  acumuladorPuntosRutina) {
		ControllerRutina.actualizarRutina(id_rutina, dificultad, comparte, acumuladorPuntosRutina);
		
	}
	
	
	public static void AgregandoEjercicioRtis(Ejercicio ejercicio , int id_rutina) {
		
		int id_ejercicio = ControllerEjercicio.agregarEjercicio(ejercicio);
		ControllerEjercicio.agregarRutinaHasEjercicio(id_rutina, id_ejercicio);
	}
	public static int registrandoDatosPersonalesUsuario(String nombre ,String apellido, int edad,String telefono,String email) {
		
		ControllerDatosPersonales.AgregandoDatoPersonales(new DatosPersonales(nombre, apellido, edad, telefono, email));
		
		
		return ControllerDatosPersonales.buscandoIdDatosPersonales(nombre, apellido);
	}
	public static boolean VerificandoExistenciaDelUsuario(String usuario ,String pass) {
		
		
		 return ControllerCliente.existeElUsuarioEnLaBd(usuario, pass);
		
	
	}
	public static void creandoCuentaDelUsuarioNuevo(String usuario ,String pass ,int id_dato_personal) {
		
		
		ControllerMenu.agregarMenu(ControllerObjetivo.agregarObjetivo(new Objetivo()),
				ControllerAreaEntrenamiento.agregarAreaEntrenamiento(new AreaEntrenamiento()),
				ControllerCliente.agregarCliente(usuario, pass, id_dato_personal));
		
	
	}
	


}
