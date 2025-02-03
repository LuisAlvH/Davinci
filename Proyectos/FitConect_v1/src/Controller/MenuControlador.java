package Controller;

import Model.Area_entrenamiento;
import Model.Area_entrenamientoDao;
import Model.Menu;
import Model.MenuDao;
import Model.ObjetivoDao;
import Model.Objetivo_cliente;

public class MenuControlador {

	public static Menu obteniendoMenuCliente(int id_cliente) {

		MenuDao menu = new MenuDao();
		Menu menu_usuario = menu.read(id_cliente);
		

		return menu_usuario;

	}
	
	public static Objetivo_cliente obteniendoObjetivoCliente(int id_objetivo) {
		
		ObjetivoDao obj = new ObjetivoDao();
		
		return obj.read(id_objetivo);
		
		
	}
	
	
	public static Area_entrenamiento obteniendoAreaDeEntrenamiento(int id_area) {
		
	Area_entrenamientoDao area = new Area_entrenamientoDao();
		
		return area.read(id_area);
		
		
	}

	public static void actualizarObjetivo(Objetivo_cliente objetivo) {
		
		ObjetivoDao obj = new ObjetivoDao();
		obj.update(objetivo);
	}
	
public static void actualizarArea(Area_entrenamiento area) {
		
		Area_entrenamientoDao are = new Area_entrenamientoDao();
		are.update(area);
	}
}
