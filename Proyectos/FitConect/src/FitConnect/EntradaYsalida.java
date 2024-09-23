package FitConnect;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EntradaYsalida {

	private static Scanner scanner = new Scanner(System.in);

	public static Cliente registroUsuario() {

		String nombre = ingresoUnString("ingresa un nombre:");
		String apellido = ingresoUnString("ingresa el apellido:");
		String email = ingresoUnString("ingresa el email:");
		String telefono = ingresoUnString("ingresa el telefono:");
		int edad = IngresoEntero("ingresa la edad:");
		String objetivoTipo = ingresoUnString("objetivo a buscar:");
		Objetivo objetivo=new Objetivo(objetivoTipo, LocalDate.now());
		String usuario = ingresoUnString("ingresa el usuario:");
		String pass = ingresoUnString("ingresa el password:");
		
		DatosPersonales dates = new DatosPersonales(nombre, apellido, edad, telefono, email);
		Cliente cliente = new Cliente(usuario, pass, dates, "Cliente",objetivo);

		return cliente;

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

	public static int UsuarioSeleccionOpcion() {
		boolean flag=false;
		int num;
		do {

		 num=EntradaYsalida.IngresoEntero("\n[1-Iniciar sesion] [2-Registrarse] [3-Buscar] [4-Salir]");
		 
			if(num!=1 && num!=2 && num!=3 && num!=4) {
				
				System.out.println("Opcion incorrecta..");
				flag=true;
			}
		
		
		}while(flag);
		

	
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

			// if(usuario.isEmpty())System.out.println("ERROR: El usuario no puede ser
			// nulo.");

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

}
