package Generador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada_Salida {

	private static Scanner teclado = new Scanner(System.in);

	/// MOSTRAR OPCIONES DEL MENU

	public static int OpcionSeleccionadaDelMenu() {
		int valor = 0;
		boolean ciclo = true;
		do {

			try {

				System.out.println("\n\tBienvenido al sistema de contraseñas\t\n");
				System.out.println("\t1-Generar contraseña");
				System.out.println("\t2-Verificar nivel de seguridad de la contraseña");
				System.out.println("\t3-Informacion importante de la contraseña");
				System.out.println("\t4-Salir");
				System.out.println("Seleccione una opcion:");
				valor = teclado.nextInt();
				if (valor != 1 && valor != 2 && valor != 3 && valor != 4) {

					System.out.println("\n\tPorfavor, ingresa un valor solicitado!\n");
					ciclo = false;
				} else {
					ciclo = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n\tPorfavor, ingresa un valor solicitado!\n");
				teclado.next();
				ciclo = false;
			}

		} while (!ciclo);

		return valor;

	}

	public static boolean PreguntasSobreLaContra(String mensaje) {
		boolean ciclo = true;
		String valorString;

		do {

			System.out.println(mensaje);
			valorString = teclado.next();

			if (!valorString.equalsIgnoreCase("si") && !valorString.equalsIgnoreCase("no")) {

				ciclo = false;

			} else {

				ciclo = true;

			}
		} while (!ciclo);

		return (valorString.equalsIgnoreCase("si")) ? true : false;

	}

	public static int CantidadDeCaracteres(String mensaje) {
		boolean ciclo = true;
		int valorEntero = 0;

		do {

			try {
				System.out.println(mensaje);
				valorEntero = teclado.nextInt();

				if (valorEntero == 0) {
					System.out.println("\n\tingresa un valor distinto de 0\n");
					ciclo = false;

				} else {
					ciclo = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n\tingresa un valor numerico!\n");
				teclado.next();
				ciclo = false;

			}
		} while (!ciclo);

		return valorEntero;

	}

	public static StringBuilder IngresaPassword(String mensaje) {

		System.out.println(mensaje);
		String valorString = teclado.next();
		StringBuilder valorBuilder = new StringBuilder(valorString);

		return valorBuilder;

	}

}
