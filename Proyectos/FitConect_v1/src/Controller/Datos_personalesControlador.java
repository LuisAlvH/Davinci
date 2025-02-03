package Controller;

import Model.Datos_personales;
import Model.Datos_personalesDao;
import Model.UsuarioDao;

public class Datos_personalesControlador {
	
	
	
	public static boolean validacionDeEdad(String text) {
	    try {
	        int edad = Integer.parseInt(text);
	        return edad > 0; 
	    } catch (NumberFormatException e) {
	        return false;  
	    }
	}
	public static boolean validacionDeEmail(String text) {
		
		char arroba='@';
		
		
		return text.contains(String.valueOf(arroba));
		
	}


	
	public static Datos_personales obteniendoDatosCliente(int id_datos) {
		   Datos_personalesDao datosBd = new Datos_personalesDao();
		    
		    // Obtener los datos del cliente
		    Datos_personales datosCliente = datosBd.read(id_datos);
		    
		    if (datosCliente == null) {
		        System.out.println("No se encontraron datos para el cliente con ID: " + id_datos);
		        return null;  // O podrías retornar un objeto vacío o lanzar una excepción
		    }
		    
		    return datosCliente;
	
		
		
	}
	
	
	public static void actualizarDatosPersonalesCliente(Datos_personales datos) {
		
		 Datos_personalesDao datosBd = new Datos_personalesDao();
		 datosBd.update(datos);
	}
}
