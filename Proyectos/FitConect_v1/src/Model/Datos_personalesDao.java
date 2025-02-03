package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class Datos_personalesDao implements DaoGenerico<Datos_personales> {

	private static final String SQL_INSERT = "INSERT INTO `datos_personales`(`nombre`, `apellido`, `edad`,`telefono`,`email`) VALUES (?,?,?,?,?)";
	private static final String SQL_READ = "SELECT `id_dato_personal`,`nombre`, `apellido`, `edad`, `telefono`, `email` FROM `datos_personales` WHERE id_dato_personal= ?";
	private static final String SQL_UPDATE = "UPDATE `datos_personales` SET `nombre` = ?, `apellido` = ?, `edad` = ?, `telefono` = ?, `email` = ? WHERE `id_dato_personal` = ?";
	
	
	
	@Override
	public void update(Datos_personales datos) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, datos.getNombre());
			preparedStatement.setString(2, datos.getApellido());
			preparedStatement.setInt(3, datos.getEdad());
			preparedStatement.setString(4, datos.getTelefono());
			preparedStatement.setString(5, datos.getEmail());
			preparedStatement.setInt(6, datos.getId_dato_personal());

			int filas = preparedStatement.executeUpdate();
			 System.out.println("Filas afectadas: " + filas);
			if (filas > 0) {

				System.out.println("Datos han sido actualizados...");
			}else {
	            System.out.println("No se actualizó ninguna fila. Verifica el ID.");
	        }

		} catch (SQLException e) {
			 System.err.println("Error al actualizar los datos: " + e.getMessage());
		        e.printStackTrace();
		} finally {
			Conexion.closeConnection();
		}

	}
	
	
	
	
	
	
	
	
	@Override
	public int add(Datos_personales a) {

		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, a.getNombre());
			preparedStatement.setString(2, a.getApellido());
			preparedStatement.setInt(3, a.getEdad());
			preparedStatement.setString(4, a.getTelefono());
			preparedStatement.setString(5, a.getEmail());

			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				try {
					ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

					if (generatedKeys.next()) {

						idGenerado = generatedKeys.getInt(1);

					}

				} catch (SQLException e) {
					System.out.println("Error al obtener el ID generado.");
					e.printStackTrace();

				}

				System.out.println("Se ha registrado exitosamente!");

			}

			Conexion.getConecBd().commit();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			Conexion.closeConnection();

		}

		return idGenerado;

	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Datos_personales read(int id_dato) {
		PreparedStatement preparedStatement;
		ResultSet resultado;
		Datos_personales datos = null;
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ);
			preparedStatement.setInt(1, id_dato);

			 resultado = preparedStatement.executeQuery();
			while (resultado.next()) {

				datos = new Datos_personales();
				datos.setId_dato_personal(resultado.getInt("id_dato_personal"));
				datos.setNombre(resultado.getString("nombre"));
				datos.setApellido(resultado.getString("apellido"));
				datos.setEdad(resultado.getInt("edad"));
				datos.setEmail(resultado.getString("email"));
				datos.setTelefono(resultado.getString("telefono"));
			
			

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

		return datos;
		
		
	}

	@Override
	public ArrayList<Datos_personales> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
