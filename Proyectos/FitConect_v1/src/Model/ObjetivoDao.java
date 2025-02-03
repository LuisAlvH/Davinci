package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class ObjetivoDao implements DaoGenerico<Objetivo_cliente> {

	
	private static final String SQL_READ = "SELECT `tipo_objetivo`, `fecha_inicial`, `porcen_progreso` FROM `objetivos` WHERE id_objetivo= ?";
	private static final String SQL_UPDATE = "UPDATE `objetivos` SET `tipo_objetivo` = ?, `fecha_inicial`= ?, `porcen_progreso` = ? WHERE `id_objetivo` = ?";
	private static final String SQL_INSERT = "INSERT INTO `objetivos`(`tipo_objetivo`, `fecha_inicial`, `porcen_progreso`) VALUES (?,?,?)";
	
	
	
	
	
	

	
	
	

	
	
	
	@Override
	public void update(Objetivo_cliente u) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, u.getTipo_objetivo());
			preparedStatement.setDate(2, java.sql.Date.valueOf(u.getFecha_inicial()));
			preparedStatement.setFloat(3, u.getProgreso());
			preparedStatement.setInt(4, u.getId_objetivo());
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
	public int add(Objetivo_cliente a) {
		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {
			
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, a.getTipo_objetivo());
			preparedStatement.setDate(2, null);
			preparedStatement.setFloat(3, a.getProgreso());
			
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
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Objetivo_cliente read(int id_objetivo) {
	
		PreparedStatement preparedStatement;
		ResultSet resultado;
		Objetivo_cliente obj = null;
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ);
			preparedStatement.setInt(1, id_objetivo);

	        resultado = preparedStatement.executeQuery();
			while (resultado.next()) {

				obj = new Objetivo_cliente();
				
				obj.setTipo_objetivo(resultado.getString("tipo_objetivo"));
				
				
			    Date fechaInicialSQL = resultado.getDate("fecha_inicial");
	            if (fechaInicialSQL != null) {
	                obj.setFecha_inicial(fechaInicialSQL.toLocalDate());
	            } else {
	                // Maneja el caso en que la fecha es null, por ejemplo, usando una fecha por defecto
	                obj.setFecha_inicial(null);  // O alguna fecha predeterminada
	            }
				obj.setProgreso(resultado.getFloat("porcen_progreso"));
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

		return obj;
		
		
		
	
	}

	@Override
	public ArrayList<Objetivo_cliente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
