package BLL;

import java.util.ArrayList;
import java.util.Scanner;

import DLL.ControllerDatosPersonales;

public class Menu_cliente {
	
	private int id_cliente;
	private String nivel_cliente;
	private int popularidad_cuenta;
	private Objetivo objetivo;
	private ArrayList<Rutina> listaRutinas = new ArrayList<Rutina>();
	//private Desafio desafio;
	private AreaEntrenamiento lugarEntrenamiento;
	
	
	
	
	
	
	public Menu_cliente(int id_cliente, String nivel_cliente, int popularidad_cuenta, Objetivo objetivo,
			 AreaEntrenamiento lugarEntrenamiento) {
		super();
		this.nivel_cliente = nivel_cliente;
		this.popularidad_cuenta = popularidad_cuenta;
		this.objetivo = objetivo;
		this.lugarEntrenamiento = lugarEntrenamiento;
	}

	public Menu_cliente(int id_cliente){
		this.id_cliente=id_cliente;
		this.nivel_cliente = "Principiante";
		popularidad_cuenta = 0;
		this.objetivo =new Objetivo();
		this.lugarEntrenamiento =  new AreaEntrenamiento();
		}
	
	public Menu_cliente(Objetivo objetivo,AreaEntrenamiento area){
		this.nivel_cliente = "Principiante";
		popularidad_cuenta = 0;
		this.objetivo =objetivo;
		this.lugarEntrenamiento = area;
		}


	public String getNivelCliente() {
		return nivel_cliente;
	}

	public void setNivelCliente(String nivelCliente) {
		this.nivel_cliente = nivelCliente;
	}

	public int getPointsPopularidad() {
		return popularidad_cuenta;
	}

	public void setPointsPopularidad(int pointsPopularidad) {
		popularidad_cuenta = pointsPopularidad;
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
				menuRutinas(scanner,this.id_cliente);

				break;
			case 2:

				/// VER DESAFIOS
				menuDesafios(scanner);
				break;
			case 3:

				////MODIFICAR USUARIO LISTO
				
				EntradaYsalida.ModificarUsuario( this.id_cliente);
				
				
				
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
				break;
			case 3:

				/// CREAR DESAFIO
			
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

	private void menuRutinas(Scanner scan ,int id_usuario) {

		boolean continuar = true;
		int opcion = 0;
		do {
			opcion = OpcionesRutina(scan);
			switch (opcion) {

			case 1:

				/// BUSCAR RUTINAS EN EL SISTEMA
				EntradaYsalida.buscandoRutinasUsuarioConectado(id_usuario);
				

				break;
			case 2:
				/// CREAR RUTINA [LISTO]
				
				EntradaYsalida.crearRutina(id_usuario);
				
				break;
			case 3:

				/// VER RUTINAS COMPARTIDAS[Listo]
				
				EntradaYsalida.mostrarRutinasCompartidasC(id_usuario);
				
				break;
			case 4:
				
				EntradaYsalida.mostrarRutinasCompartidas(id_usuario);
				
				break;
			case 5:
				continuar = false;

				break;

			}

		} while (continuar);

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




	public void GuardarRutina(Rutina rutina) {

		this.listaRutinas.add(rutina);

	}
	
	
	
}
