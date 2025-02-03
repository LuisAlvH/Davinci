package Controller;


import java.util.ArrayList;

import Model.Area_entrenamiento;
import Model.Area_entrenamientoDao;
import Model.Datos_personales;
import Model.Datos_personalesDao;
import Model.Menu;
import Model.MenuDao;
import Model.ObjetivoDao;
import Model.Objetivo_cliente;
import Model.Usuario;
import Model.UsuarioDao;

public class usuarioControlador {
	
	
	public static void creandoCuentaNuevaUsuario(Datos_personales datos,String usuario,String password) {
		MenuDao menuBD=new MenuDao();
		UsuarioDao usuariosBD=new UsuarioDao ();
		ObjetivoDao objetivoBD=new ObjetivoDao();
		
		
		Area_entrenamientoDao areaBD=new Area_entrenamientoDao();
		Datos_personalesDao datos_usuario=new Datos_personalesDao ();
		Usuario usser=new Usuario(usuario,password,datos_usuario.add(datos));
		int id_usse=usuariosBD.add(usser);
		Area_entrenamiento area= new Area_entrenamiento();
		Objetivo_cliente obj = new Objetivo_cliente();
		
		Menu mi_menu = new Menu(objetivoBD.add(obj),areaBD.add(area),id_usse);
		
	
	
		
		menuBD.add(mi_menu);
	}
	
	
	
	
	public static int LoginIngreso(String pass , String usuario) {
		
		UsuarioDao usuariosBD=new UsuarioDao ();
	
		ArrayList<Usuario>usuarios=new ArrayList<Usuario>();
		usuarios=usuariosBD.readAll();
		
		if(existenciaDelUsuarioEnLaBD(usuarios,pass,usuario)>0) {
			
			return existenciaDelUsuarioEnLaBD(usuarios,pass,usuario) ;
			
		}else {
			
			if(userExisteOnoExiste(usuarios,usuario)>0) {
				return 0;
				
			}
			
		}
		
	
	return -1;
	}
	
	
	
	public static boolean usuarioExistenteEnlaBd(String usuario) {
		UsuarioDao usuariosBD=new UsuarioDao ();
		ArrayList<Usuario>usuarios=new ArrayList<Usuario>();
		usuarios=usuariosBD.readAll();
		
		if(userExisteOnoExiste(usuarios,usuario)>0) {
			return true;
			
		}
		return false;
	}
	
	
	
	

	private static int  existenciaDelUsuarioEnLaBD(ArrayList<Usuario>usuarios,String pass ,String usuario) {
			for  (Usuario usuarioEjemplo : usuarios) {
			
				if(usuarioEjemplo.getPass().equals(pass)&& usuarioEjemplo.getUsser().equals(usuario)) {
					
					return usuarioEjemplo.getIdUsuario();
				}
			
			
			}
		
		
		return -1;
		
		
	}
	

	
	
	
	private static int  userExisteOnoExiste(ArrayList<Usuario>usuarios ,String usuario) {
		for  (Usuario usuarioEjemplo : usuarios) {
		
			if(usuarioEjemplo.getUsser().equals(usuario)) {
				
				return usuarioEjemplo.getIdUsuario();
			}
		
		
		}
	
	
	return -1;
	
	
}
	
	public static Usuario obteniendoCliente(int id_cliente) {
		UsuarioDao usuariosBD=new UsuarioDao ();
		Usuario usuario=usuariosBD.read(id_cliente);
	
		return usuario;
		
	}
	
	
	public static boolean cambiarContraDelCLiente(String PassActual,String passNew, String PassNewRe,Usuario usser) {
		UsuarioDao usuariosBD=new UsuarioDao ();
		
		if(usser.getPass().equals(PassActual) && passNew.equals(PassNewRe)) {
			usser.setPass(PassNewRe);
			usuariosBD.update(usser);
			return true;
		}
		
		return false;
		
	}
	
}
