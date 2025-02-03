package Controller;

import java.util.ArrayList;

import Model.Ejercicio;
import Model.EjercicioDao;
import Model.MenuDao;
import Model.Rutina_has_ejerciciosDao;

public class EjerciciosControlador {
	
	
	
	
	public static void eliminandoEjercicioDeLaRutina(int id_ejercicio) {
		Rutina_has_ejerciciosDao rHeDao = new Rutina_has_ejerciciosDao();
		
		rHeDao.deleteRutinaHasEjercicio(id_ejercicio);
	}
	
	
	
	public static void actualizandoElEjercicioSeleccionado( Ejercicio ejerci) {
		EjercicioDao EjercicioDao = new EjercicioDao();
		EjercicioDao.actualizarEjercicio(ejerci);
		
		
	}
	
	

	public static ArrayList<Ejercicio> obteniendoEjerciciosDeLaRutina(int id_rutina) {

		return Rutina_has_ejerciciosDao.obteniendoEjerciciosDeLaRutina(id_rutina);

	}

	
	
	public static void agregarEjercicioNuevoAlaRutina(Ejercicio ejerci,int id_rutinaNueva) {
		EjercicioDao EjercicioDao = new EjercicioDao();
		 int id_ejercicioNuevo=EjercicioDao.add(ejerci);
		
		 EjercicioDao.agregarRutinaHasEjercicio(id_rutinaNueva, id_ejercicioNuevo);
		
		
		
		
		
	}
	
	
	public static void agregandoEjercicioAMiRutina(Ejercicio ejerci,int id_rutinaNueva) {
		
		EjercicioDao EjercicioDao = new EjercicioDao();
		
		 EjercicioDao.agregarRutinaHasEjercicio(id_rutinaNueva, ejerci.getId_ejercicio());
	}
}
