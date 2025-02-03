

import java.time.LocalDate;
import java.util.ArrayList;

import BLL.EntradaYsalida;
import BLL.Usuario;
import DLL.ControllerCliente;



public class SistemaControl {



	public static void IniciarPrograma() {	
		
		int opcion = 0;
		boolean flag = false;

		do {

			System.out.println("\n*****************FitConnect***********************\n");
			EntradaYsalida.arrayPerfilesInicioSesion();
			
			
			opcion = EntradaYsalida.UsuarioSeleccionOpcion();

			switch (opcion) {
			case 1:
				
				Usuario usuarioEncontrad;
				// INICIAR SESSION
				System.out.println("\tINICIAR SESION\t");
				String usuario=EntradaYsalida.IngresoUsuario();
				String pass=EntradaYsalida.IngresoPassword();
				usuarioEncontrad=ControllerCliente.encontrandoUsuarioExistente(usuario, pass);
			
				if(usuarioEncontrad==null) {
					System.out.println("\nUsuario inexistente..");
					flag = true;
				}else {
				
				
					flag = usuarioEncontrad.MenuUsuario();
				}
				
				break;
			case 2:
				
				///REGISTRO USUARIO****************LISTO
				System.out.println("\tREGISTRARSE\t");
				EntradaYsalida.registrandoUsuario();	
				flag = true;
				break;
			case 3:
				///BUSCAR
			
				EntradaYsalida.buscandoRutinasNoConectado();
				
				
				flag = true;
				break;
			case 4:

				System.out.println("Hasta luego!");
				flag = false;
				break;

			}

		} while (flag);

		
		
		
		
		
	}
	
	


}
