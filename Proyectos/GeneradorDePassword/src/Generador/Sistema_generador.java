package Generador;

public class Sistema_generador {

	public static void menuDelSistema() {
		int Opcion;
		boolean ciclo = false;
		do {

			Opcion = Entrada_Salida.OpcionSeleccionadaDelMenu();

			switch (Opcion) {

			case 1:
				CreandoPassword();

				break;
			case 2:
				VerificandoPassword();
				break;
			case 3:
				InformacionDeContraseñas();
				break;
			case 4:
				ciclo = true;
				break;
			}

		} while (!ciclo);

		System.out.println("Hasta luego!");
	}

	private static void InformacionDeContraseñas() {
		System.out.println();
		System.out.println("Usa una longitud mínima de contraseña de 8 o más caracteres si está permitido");
		System.out.println(
				"Incluye caracteres alfabéticos en minúsculas y mayúsculas, números y símbolos si está permitido");
		System.out.println("Genera contraseñas al azar cuando sea posible");
		System.out.println(
				"Evita usar la misma contraseña dos veces (por ejemplo, en varias cuentas de usuario y/o sistemas de software)");
		System.out.println(
				"Evita la repetición de caracteres, patrones de teclado, palabras del diccionario, secuencias de letras o números,"
						+ "\nnombres de usuario, nombres de familiares o mascotas, vínculos románticos (actuales o pasados) "
						+ "y información biográfica (por ejemplo, números de identificación, nombres de ancestros o fechas).");
		System.out.println("Evita usar información que los compañeros de trabajo y/o "
				+ "conocidos del usuario puedan saber que está asociada con el usuario");
		System.out.println(
				"No uses contraseñas que consistan completamente en una combinación simple de los componentes débiles mencionados anteriormente");
	}

	private static void VerificandoPassword() {
		StringBuilder passObtenida = Entrada_Salida.IngresaPassword("ingresa una contraseña:");

		Password password = new Password(passObtenida);

		System.out.println(password.NivelDeSeguridadDelPassword());

	}

	private static void CreandoPassword() {
		boolean Minusculas;
		boolean Mayusculas;
		boolean numeros;
		boolean Simbolos;
		System.out.println("Hola, bienvenido al Generador de Contraseñas :) responde"
				+ " las siguientes preguntas con Sí o No \n");

		boolean ciclo = false;

		do {
			Minusculas = Entrada_Salida.PreguntasSobreLaContra("Quieres letras minusculas?");
			Mayusculas = Entrada_Salida.PreguntasSobreLaContra("Quieres letras mayusculas?");
			numeros = Entrada_Salida.PreguntasSobreLaContra("Quieres numeros?");
			Simbolos = Entrada_Salida.PreguntasSobreLaContra("Quieres simbolos?");

			if (!Minusculas && !Mayusculas && !numeros && !Simbolos) {

				System.out.println("\n\n\tDebes responder al menos una pregunta con  [si] !");
				ciclo = true;

			}

		} while (ciclo);

		int longitud = Entrada_Salida.CantidadDeCaracteres("Ingresa la cantidad de caracteres de la contraseña?");

		Password pass = ObteniendoContra(longitud, Mayusculas, Minusculas, numeros, Simbolos);

		System.err.println("\n Tu contraseña es  -> " + pass.getValor());

	}

	private static Password ObteniendoContra(int longitud, boolean Mayusculas, boolean Minusculas, boolean numeros,
			boolean Simbolos) {

		Alfabeto alfabeto = new Alfabeto(Mayusculas, Minusculas, numeros, Simbolos);

		StringBuilder pass = new StringBuilder();
		int longitudAlfabeto = alfabeto.getAlphabet().length();
		int index;

		for (int i = 0; i < longitud; i++) {

			index = (int) (Math.random() * longitudAlfabeto);
			pass.append(alfabeto.getAlphabet().charAt(index));

		}

		return new Password(pass);

	}

}
