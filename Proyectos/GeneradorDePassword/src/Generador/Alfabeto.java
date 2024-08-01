package Generador;

public class Alfabeto {

	private final String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String minusculas = "abcdefghijklmnopqrstuvwxyz";
	private final String numeros = "1234567890";
	private final String simbolos = "!@#$%^&*()-_=+\\/~?";

	private StringBuilder caracteresElegidos;

	public Alfabeto(boolean Mayus, boolean Minus, boolean numeros, boolean simbolos) {
		caracteresElegidos = new StringBuilder();

		if (Mayus)
			caracteresElegidos.append(this.mayusculas);
		if (Minus)
			caracteresElegidos.append(this.minusculas);
		if (numeros)
			caracteresElegidos.append(this.numeros);
		if (simbolos)
			caracteresElegidos.append(this.simbolos);

	}

	public StringBuilder getAlphabet() {
		return caracteresElegidos;
	}

}
