package Generador;

public class Password {

	private StringBuilder valor;
	private int longitudPass;

	public Password(StringBuilder valorObtenido) {
		valor = valorObtenido;
		longitudPass = valorObtenido.length();
	}

	public StringBuilder getValor() {
		return valor;
	}

	public void setValor(StringBuilder valor) {
		this.valor = valor;
	}

	public StringBuilder NivelDeSeguridadDelPassword() {

		int points = PuntosDeContraseña(valor);
		StringBuilder passAux = new StringBuilder();

		if (points == 6) {
			passAux.append("Esta es una contraseña muy buena![NIVEL 4]");

		} else if (points >= 4) {
			passAux.append("Esta es una buena contraseña :) pero aun puedes mejorarla[NIVEL 3]");

		} else if (points >= 3) {
			passAux.append("Esta es una contraseña media :/ intenta mejorarla[NIVEL 2]");

		} else {
			passAux.append("Esta es una contraseña débil :( definitivamente encuentra una nueva[NIVEL 1]");

		}
		return passAux;

	}

	private static int PuntosDeContraseña(StringBuilder valor) {
		boolean Mayuscula = false;
		boolean Minuscula = false;
		boolean Numeros = false;
		boolean Simbolos = false;

		int puntos = 0;
		for (int i = 0; i < valor.length(); i++) {

			char c = valor.charAt(i);
			int tipoCaracter = QueTipoDeCaracterEs(c);

			if (tipoCaracter == 1)
				Mayuscula = true;
			if (tipoCaracter == 2)
				Minuscula = true;
			if (tipoCaracter == 3)
				Numeros = true;
			if (tipoCaracter == 4)
				Simbolos = true;

		}

		if (Mayuscula)
			puntos += 1;
		if (Minuscula)
			puntos += 1;
		if (Numeros)
			puntos += 1;
		if (Simbolos)
			puntos += 1;

		if (valor.length() >= 8)
			puntos += 1;
		if (valor.length() >= 16)
			puntos += 1;

		return puntos;

	}

	private static int QueTipoDeCaracterEs(char caracter) {

		int val;

		if ((int) caracter >= 65 && (int) caracter <= 90)
			val = 1;

		else if ((int) caracter >= 97 && (int) caracter <= 122) {
			val = 2;
		}

		else if ((int) caracter >= 48 && (int) caracter <= 57) {
			val = 3;
		}

		else {
			val = 4;
		}

		return val;
	}

}
