package DLL;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.DatosPersonales;

public class ControllerDatosPersonales {

	private static Connection conect = Conexion.getInstance().getConection();

	public static void AgregandoDatoPersonales(DatosPersonales datos) {
		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("INSERT INTO `datos_personales`(`nombre`, `apellido`, `edad`,`telefono`"
							+ ",`email`) VALUES (?,?,?,?,?)");
			statement.setString(1, datos.getNombre());
			statement.setString(2, datos.getApellido());
			statement.setInt(3, datos.getEdad());
			statement.setString(4, datos.getTelefono());
			statement.setString(5, datos.getEmail());

			int filas = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error , al agregar datos personales");
		}

	}

	

	public static int buscandoIdDatosPersonales(String nombre, String apellido) {

		int id_Datos = 0;
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"SELECT id_dato_personal FROM `datos_personales` WHERE nombre= ? AND apellido= ? ");
			statement.setString(1, nombre);
			statement.setString(2, apellido);

			ResultSet resul = statement.executeQuery();

			if (resul.next()) {
				id_Datos = resul.getInt("id_dato_personal");
			}

		} catch (Exception e) {
			System.out.println("No se agregó");
		}

		return id_Datos;
	}
	public static void ActualizarDatosPersonales(int id_dato ,String nombre,String apellido,int edad,String telefono,String email) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					conect.prepareStatement("UPDATE `datos_personales` SET `nombre`= ?,"
							+ "`apellido`= ? ,`edad`= ? ,`telefono`= ? ,`email`= ?  WHERE id_dato_personal = ?");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setInt(3,edad);
			statement.setString(4, telefono);
			statement.setString(5, email);
			statement.setInt(6, id_dato);
			statement.executeUpdate();
			
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	
	public static int obtenerIdDatos(int id_usuario) {
		int id_dato = 0;
	
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"SELECT `fk_dato_personal` FROM `usuarios` WHERE id_usuario= ?");
			statement.setInt(1, id_usuario);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				id_dato =result.getInt("fk_dato_personal");
						
					
			}

		} catch (Exception e) {

			System.out.println("Error, al agregar un cliente..");

		}
		return id_dato;
		

	}
	
}
