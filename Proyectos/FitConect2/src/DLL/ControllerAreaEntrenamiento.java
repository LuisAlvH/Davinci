package DLL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.AreaEntrenamiento;

public class ControllerAreaEntrenamiento {

	private static Connection conect = Conexion.getInstance().getConection();
	
	
	public static int agregarAreaEntrenamiento(AreaEntrenamiento area) {
		
		
		int idGenerado = 0;
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `Areas_entrenamientos`(`espacio`, `barrio`, `direccion`) VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS );
			statement.setString(1, area.getEspacio());
			statement.setString(2, area.getBarrio());
			statement.setString(3, area.getDireccion());
			 

			int filas = statement.executeUpdate();
			if (filas > 0) {
				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
					if (generatedKeys.next()) {

						idGenerado = generatedKeys.getInt(1);

					} else {
						System.out.println("No se pudo obtener el ID de la dirección");
					}
				} catch (SQLException e) {
					System.out.println("Error al obtener el ID generado.");
					e.printStackTrace(); 
				}
			}

		} catch (Exception e) {

				System.out.println("Error, al agregar area de entrenamiento");

		}
		
		return idGenerado;
	}
	
	
	
	public static void actualizarArenaEntrenamiento(int id_area, String espacio, String barrio, String direccion) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `areas_entrenamientos` SET `espacio`= ?, `barrio`=? ,`direccion`= ?   WHERE id_area_entrenamiento = ?");
			statement.setString(1, espacio);
			statement.setString(2, barrio);
			statement.setString(3, direccion);
			statement.setInt(4, id_area);

			int fila=statement.executeUpdate();
			
			if (fila>0) {
				
				System.out.println("\n\tInformaciones actualizada...\t");
			}
		} catch (Exception e) {
			System.out.println("Error,Actualizando el area");
		}

	}
	
	
	
}
