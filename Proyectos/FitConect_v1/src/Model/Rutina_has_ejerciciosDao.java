package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Util.Conexion;

public class Rutina_has_ejerciciosDao {
	
	
	
	private static final String SQL_READALL_EJERCICIOS="SELECT e.id_ejercicio, e.nombre, e.serie, e.descanso, e.repeticiones,e.puntos_progreso_ejer " + "FROM rutinas r "
			+ "JOIN rutinas_has_ejercicios re ON r.id_rutina = re.fk_rutina "
			+ "JOIN ejercicios e ON e.id_ejercicio = re.fk_ejercicio " + "WHERE r.id_rutina = ?";
	private static final String SQL_DELETE="DELETE FROM `rutinas_has_ejercicios` WHERE fk_ejercicio = ?";
	
	
	public static ArrayList<Ejercicio> obteniendoEjerciciosDeLaRutina(int id_rutina) {
		
		ArrayList<Ejercicio> ejercicios =new ArrayList<Ejercicio>();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READALL_EJERCICIOS);
			preparedStatement.setInt(1, id_rutina);

			ResultSet resultado = preparedStatement.executeQuery();
			

			Conexion.getConecBd().setAutoCommit(false);
		

			resultado.last();

			if (resultado.getRow() > 0) { /// VERIFICAMOS SI EL ULTIMO ES MAYOR A 0
				resultado.beforeFirst(); /// METODO QUE ME DEVUELVE AL PRIMERO ELEMENTO REGISTRADO.

			

				while (resultado.next()) {

					Ejercicio ejercicio = new Ejercicio();
					ejercicio.setId_ejercicio(resultado.getInt("id_ejercicio"));
					ejercicio.setNombre(resultado.getString("nombre"));
					ejercicio.setSerie(resultado.getInt("serie"));
					ejercicio.setDescanso(resultado.getInt("descanso"));
					ejercicio.setRepeteticiones(resultado.getInt("repeticiones"));
					ejercicio.setPuntos_progre_ejerci(resultado.getInt("puntos_progreso_ejer"));
					ejercicios.add(ejercicio);
				}
				Conexion.getConecBd().commit(); 
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return ejercicios;
	}
	
	public void deleteRutinaHasEjercicio(int id_ejercicio) {
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, id_ejercicio);
		

			int filasAfectadas = preparedStatement.executeUpdate();
	    
			
			
		} catch (Exception e) {
	        System.out.println("Error eliminando la rutina.");
	        e.printStackTrace();
	    } finally {
	        Conexion.closeConnection();
	    }

	}

}
