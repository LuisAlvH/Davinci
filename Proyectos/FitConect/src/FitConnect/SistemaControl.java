package FitConnect;

import java.time.LocalDate;
import java.util.ArrayList;



public class SistemaControl {



	public static void IniciarPrograma() {
		
		
		SingletonBdd.CrearListaUsuarios();
		
		
		Objetivo objetivo=new Objetivo("lala", LocalDate.now(),"Lorem");
		AreaEntrenamiento areaEntrenamiento=new AreaEntrenamiento("Gymnasio", "Belgrano","lorem 456");
		DatosPersonales datosPorDefauld=new DatosPersonales("vacio", "vacio", 15,  "vacio",  "llalal@gmail.com");
		Cliente a1=new Cliente("Principiante",62,objetivo,null, areaEntrenamiento, "alex", "1234", datosPorDefauld, "Cliente");
		Cliente a2=new Cliente("Intermedio",62,objetivo,null, areaEntrenamiento, "lucas", "1234", datosPorDefauld, "Cliente");
		
		
		Ejercicio ejercicio=new Ejercicio("A1",2,10,5,10);
		Ejercicio ejercicio2=new Ejercicio("A2",2,10,5,10);
		Ejercicio ejercicio3=new Ejercicio("A1",2,10,5,10);
		Ejercicio ejercicio4=new Ejercicio("A2",2,10,5,10);
		Rutina rutina=new Rutina("Rutina 1", "Dificil", "Plata",1000, 40,0, "Futbol", "alex","N");
		Rutina rutina2=new Rutina("Rutina 2", "Dificil", "Plata",1000, 40,0, "Futbol", "lucas","S");
		rutina2.GuardarEjercicio(ejercicio);
		rutina2.GuardarEjercicio(ejercicio2);
		rutina2.GuardarEjercicio(ejercicio3);
		rutina2.GuardarEjercicio(ejercicio4);
		rutina.GuardarEjercicio(ejercicio);
		rutina.GuardarEjercicio(ejercicio2);
		rutina.GuardarEjercicio(ejercicio3);
		rutina.GuardarEjercicio(ejercicio4);
		a1.GuardarRutina(rutina);
		a2.GuardarRutina(rutina2);
		SingletonBdd.GuardarUsuarios(a1);
		SingletonBdd.GuardarUsuarios(a2);
	
		
	
		
		
		int opcion = 0;
		boolean flag = false;

		do {

			System.out.println("\n*****************FitConnect***********************");
			MostrarPerfiles();
			opcion = EntradaYsalida.UsuarioSeleccionOpcion();

			switch (opcion) {
			case 1:
				
				Cliente clienteEncontrado;
				// INICIAR SESSION
				System.out.println("\tINICIAR SESION\t");
				String usuario=EntradaYsalida.IngresoUsuario();
				String pass=EntradaYsalida.IngresoPassword();
				clienteEncontrado=SistemaControl.BuscarUsuarioEnElSistema(usuario,pass);
				
				if(clienteEncontrado==null) {
					System.out.println("Usuario Inexistente...");
					flag = true;
				}else {
					
					
					flag = clienteEncontrado.MenuUsuario();;
				}
				
				break;
			case 2:
				System.out.println("\tREGISTRARSE\t");
				Cliente cliente = EntradaYsalida.registroUsuario();
				SingletonBdd.GuardarUsuarios(cliente);
				///FALTA VALIDACION DE EXISTENCIA DEL USUARIO EN EL SISTEMA
				System.out.println("Se ha registrado correctamente!");
				flag = true;
				break;
			case 3:
				///BUSCAR
				flag = false;
				System.out.println("Proximamente...");
				break;
			case 4:

				System.out.println("Hasta luego!");
				flag = false;
				break;

			}

		} while (flag);

		
		
		
		
		
	}
	
	
	private static Cliente BuscarUsuarioEnElSistema(String usuario,String pass) {
		
		
		
		for (Usuario usser : SingletonBdd.CrearListaUsuarios()) {
			
		
			
			if(usser.getPass().equals(pass) && usser.getUsser().equals(usuario)) {
				
				
				return  (Cliente)usser;
			}
			
			
		}
		return null;
		
		
		
		
	}
	
	
	private static void MostrarPerfiles() {
		Cliente cliente;
		for (Usuario usser : SingletonBdd.CrearListaUsuarios()) {
			
			cliente=(Cliente)usser;
			
			cliente.MostrarPerfilInicio();
			
		}
	}

}
