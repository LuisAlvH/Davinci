package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class Area_entrenamientoDao implements DaoGenerico<Area_entrenamiento> {
	private static final String SQL_READ = "SELECT `espacio`, `barrio`, `direccion` FROM `areas_entrenamientos` WHERE id_area_entrenamiento= ?";
	private static final String SQL_INSERT = "INSERT INTO `areas_entrenamientos`(`espacio`, `barrio`, `direccion`) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE `areas_entrenamientos` SET `espacio` = ?, `barrio`= ?,`direccion` = ? WHERE `id_area_entrenamiento` = ?";
	@Override
	public int add(Area_entrenamiento a) {
		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {
			
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, a.getEspacio());
			preparedStatement.setString(2, a.getBarrio());
			preparedStatement.setString(3, a.getDireccion());
			
			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				try {
					ResultSet generatedKeys = preparedStatement.getGeneratedKeys();/// DEVUELVE EL ULTIMO ID GENERADO EN
																					/// LA
					/// ULTIMA CONSULTA REALIAZADA

					if (generatedKeys.next()) {

						idGenerado = generatedKeys.getInt(1);

					}

				} catch (SQLException e) {
					System.out.println("Error al obtener el ID generado.");
					e.printStackTrace();

				}

				System.out.println("Se ha registrado exitosamente!");

			}

			

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			Conexion.closeConnection();

		}

		return idGenerado;
	}

	@Override
	public void update(Area_entrenamiento u) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, u.getEspacio());
			preparedStatement.setString(2, u.getBarrio());
			preparedStatement.setString(3, u.getDireccion());
			preparedStatement.setInt(4, u.getId_area());
			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Usuario ha sido actualizado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Area_entrenamiento read(int id_area) {
		
		PreparedStatement preparedStatement;
		ResultSet resultado;
		Area_entrenamiento area = null;
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ);
			preparedStatement.setInt(1, id_area);

	        resultado = preparedStatement.executeQuery();
			while (resultado.next()) {

				area = new Area_entrenamiento();
				
				
				area.setEspacio(resultado.getString("espacio"));
				area.setDireccion(resultado.getString("direccion"));
				area.setBarrio(resultado.getString("barrio"));
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

		return area;
		
		
		
	}

	@Override
	public ArrayList<Area_entrenamiento> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
