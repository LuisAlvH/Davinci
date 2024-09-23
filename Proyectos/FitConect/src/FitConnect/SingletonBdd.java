package FitConnect;

import java.util.ArrayList;


public class SingletonBdd {

	private static ArrayList<Usuario> usuarios;
	
	
	

	public static ArrayList<Usuario> CrearListaUsuarios() {

		if (usuarios == null) {
			usuarios = new ArrayList<Usuario>();
		}

		return usuarios;
	}

	public static void GuardarUsuarios(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	
	
}
