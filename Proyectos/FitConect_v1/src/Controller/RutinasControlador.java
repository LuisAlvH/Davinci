package Controller;

import java.util.ArrayList;

import Model.Ejercicio;
import Model.Menu;
import Model.MenuDao;
import Model.Rutina;
import Model.RutinaDao;
import Model.Usuario;

public class RutinasControlador {
	
	
	
	
	
	public static void actualizarDTA(Rutina ruti) {
		
		RutinaDao RutinaDao = new RutinaDao();
		RutinaDao.updateDTA(ruti);
		
	}
		
	
	
	
	public static void actualizandoCompartir(Rutina ruti ,int compartir) {
		
		RutinaDao RutinaDao = new RutinaDao();
		
		if (compartir == 1) {
		    RutinaDao.updateCompartir(ruti);
		} else {
		    RutinaDao.updateDescompartir(ruti);
		}
			
		
		
		
		
		
		
	}
public static void actualizandoDescompartida(Rutina ruti) {
		
		RutinaDao RutinaDao = new RutinaDao();
		RutinaDao.updateCompartir(ruti);
	}
	
	
	
	public static void eliminarRutina(int id_rutina) {
		
		RutinaDao RutinaDao = new RutinaDao();
		RutinaDao.delete(id_rutina);
	}
	
	
	
	public static ArrayList<Rutina> obteniendoRutinasSinCompartirDelUsuario(int id_usuario){
		RutinaDao RutinaDao = new RutinaDao();
		Menu menu =MenuControlador.obteniendoMenuCliente(id_usuario);
		
		return RutinaDao.readAllRutiSinCompartirDelUsuario(menu.getId_menu());
		
	}
	
	
	
	public static ArrayList<Rutina> obteniendoRutinasCompartirDelUsuario(int id_usuario){
		RutinaDao RutinaDao = new RutinaDao();
		Menu menu =MenuControlador.obteniendoMenuCliente(id_usuario);
		
		return RutinaDao.readAllRutiCompartirDelUsuario(menu.getId_menu());
		
	}
	
	
	public static int agregandoRutinaAlUsuario(Rutina rutina, int id_usuario) {
		RutinaDao RutinaDao = new RutinaDao();
		MenuDao MenuDao = new MenuDao();
	
		
		ArrayList<Ejercicio>misEjerc=EjerciciosControlador.obteniendoEjerciciosDeLaRutina(rutina.getId_rutina());

		Usuario usser=usuarioControlador.obteniendoCliente(id_usuario);
		
		
		
		Menu menu=MenuControlador.obteniendoMenuCliente(id_usuario);
		rutina.setPopularidad_rutina(0);
		rutina.setCompartida(0);
		rutina.setUsuario_creador(usser.getUsser());
		int id_rutinaNueva=RutinaDao.add(rutina);
		
		agregandoMisEjerciciosAMirutina(misEjerc,id_rutinaNueva);
		RutinaDao.conectandoMenuHasRutina(id_rutinaNueva, menu.getId_menu());
		
		
		
		
		return id_rutinaNueva;
		
	}
	
	

	private static void agregandoMisEjerciciosAMirutina(ArrayList<Ejercicio>MisEjer, int id_rutina) {
		
		
		for (Ejercicio ejercicio : MisEjer) {
			
			EjerciciosControlador.agregandoEjercicioAMiRutina(ejercicio,id_rutina);
			
		}
		
	}
	
	
	public static void  actualizarPopularidad(Rutina rutina) {
		
		RutinaDao RutinaDao = new RutinaDao();
		
		RutinaDao.updatePopularidad(rutina);
	}
	
	
	
	public static ArrayList<Rutina> filtrandoArrayBusqueda(ArrayList<Rutina> rutinasBusquedasTotal,Menu menu){
		MenuDao MenuDao = new MenuDao();
		ArrayList<Rutina> rutinasBusquedaFiltrado=new ArrayList<Rutina>();
		ArrayList<Integer> id_misRutinas=new ArrayList<Integer>();
		id_misRutinas=MenuDao.readAllRutinasHasMenu(menu.getId_menu());
		
		
		
		for (Rutina rutina : rutinasBusquedasTotal) {
	        // Si el id de la rutina NO está en la lista de misRutinas, se agrega a la lista filtrada
	        if (!id_misRutinas.contains(rutina.getId_rutina())) {
	            rutinasBusquedaFiltrado.add(rutina);
	           
	        }
	    }
		return rutinasBusquedaFiltrado;	
	}
	
	
	
	
	public static ArrayList<Rutina> obteniendoRutinasDeLaBusqueda(String busqueda) {
		RutinaDao rutinasDB = new RutinaDao();
		ArrayList<Rutina> rutinas_busqueda = new ArrayList<Rutina>();
		rutinas_busqueda = rutinasDB.readAllSearch(busqueda);
		
		return rutinas_busqueda;	
	}

	public static ArrayList<Rutina> obteniendoRutinasCompartidas() {
		int compartida=1;
		ArrayList<Rutina> rutinasCompartidas = obteniendoRutinasBuscadas(compartida);
		
		
		return rutinasCompartidas;

	}
	
	
	public static ArrayList<Rutina> obteniendoRutinasNoCompartidas() {
		int compartida=0;
		ArrayList<Rutina> rutinasNoCompartidas = obteniendoRutinasBuscadas(compartida);
		
		
		return rutinasNoCompartidas;

	}

	private static ArrayList<Rutina> obteniendoRutinasBuscadas(int compartida) {
		RutinaDao rutinasDB = new RutinaDao();
		ArrayList<Rutina> rutinasTotales = new ArrayList<Rutina>();
		rutinasTotales = rutinasDB.readAll();
		ArrayList<Rutina> rutinasBuscadas = new ArrayList<Rutina>();

		for (Rutina rutina : rutinasTotales) {

			if (rutina.getCompartida() == compartida) {

				rutinasBuscadas.add(rutina);
			}

		}

		return rutinasBuscadas;

	}

	
}
