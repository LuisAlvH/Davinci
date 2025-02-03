package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class EjercicioDao implements DaoGenerico<Ejercicio> {
	private static final String SQL_INSERT = "INSERT INTO `ejercicios`(`nombre`, `serie`,`descanso`,`repeticiones`,`puntos_progreso_ejer`) VALUES (?,?,?,?,?)";
	private static final String SQL_READ = "SELECT `id_ejercicio`, `nombre`, `serie`, `descanso`, `repeticiones`,`puntos_progreso_ejer` FROM `ejercicios` WHERE= ?";
	private static final String SQL_ADDRUT_AND_EJER = "INSERT INTO `rutinas_has_ejercicios`(`fk_rutina`, `fk_ejercicio`) VALUES (?,?)";
	private static final String SQL_READ_ALL_EJER = "SELECT e.id_ejercicio, e.nombre, e.serie, e.descanso, e.repeticiones "
			+ "FROM rutinas r " + "JOIN rutinas_has_ejercicios re ON r.id_rutina = re.fk_rutina "
			+ "JOIN ejercicios e ON e.id_ejercicio = re.fk_ejercicio " + "WHERE r.id_rutina = ?";
	private static final String SQL_UPDATE_EJER = "UPDATE `ejercicios` SET `nombre`= ?, `serie`=? ,`descanso`= ? ,`repeticiones`= ?    WHERE id_ejercicio = ?";
	
	
	
	
	public static void actualizarEjercicio(Ejercicio u) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATE_EJER);
			preparedStatement.setString(1, u.getNombre());
			preparedStatement.setInt(2, u.getSerie());
			preparedStatement.setInt(3, u.getDescanso());
			preparedStatement.setInt(4, u.getRepeteticiones());
			preparedStatement.setInt(5, u.getId_ejercicio());
			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Ejercicio ha sido actualizado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void agregarRutinaHasEjercicio(int id_rutina, int id_ejercicio) {
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_ADDRUT_AND_EJER);
			preparedStatement.setInt(1, id_rutina);
			preparedStatement.setInt(2, id_ejercicio);

			int filas = preparedStatement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error, al agregar la rutina.");

		}

	}
	
	public static ArrayList<Ejercicio>readAllEjerc(int id_rutina){
		ArrayList<Ejercicio> misEjercicios =new ArrayList<Ejercicio>();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ_ALL_EJER);
			preparedStatement.setInt(1, id_rutina);
			
			ResultSet resultado = preparedStatement.executeQuery();
		

			Conexion.getConecBd().setAutoCommit(false);
			

			resultado.last();

			if (resultado.getRow() > 0) { 
				resultado.beforeFirst();

				while (resultado.next()) {

					Ejercicio ejer = new Ejercicio();
					ejer.setId_ejercicio(resultado.getInt("id_ejercicio"));
					ejer.setNombre(resultado.getString("nombre"));
					ejer.setRepeteticiones(resultado.getInt("repeticiones"));
					ejer.setDescanso(resultado.getInt("descanso"));
					ejer.setSerie(resultado.getInt("serie"));
					
					misEjercicios.add(ejer);

				}
				Conexion.getConecBd().commit(); 
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return misEjercicios;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public int add(Ejercicio ejercicio) {

		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, ejercicio.getNombre());
			preparedStatement.setInt(2, ejercicio.getSerie());
			preparedStatement.setInt(3, ejercicio.getDescanso());
			preparedStatement.setInt(4, ejercicio.getRepeteticiones());
			preparedStatement.setInt(5, ejercicio.getPuntos_progre_ejerci());

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
	public Ejercicio read(int id) {

		PreparedStatement preparedStatement;
		ResultSet resultado;
		Ejercicio ejercicio = null;
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ);
			preparedStatement.setInt(1, id);

			resultado = preparedStatement.executeQuery(SQL_READ);
			while (resultado.next()) {

				ejercicio = new Ejercicio();
				ejercicio.setId_ejercicio(resultado.getInt("id_ejercicio"));
				ejercicio.setNombre(resultado.getString("nombre"));
				ejercicio.setSerie(resultado.getInt("serie"));
				ejercicio.setDescanso(resultado.getInt("descanso"));
				ejercicio.setRepeteticiones(resultado.getInt("repeticiones"));
				ejercicio.setPuntos_progre_ejerci(resultado.getInt("puntos_progreso_ejer"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

		return ejercicio;

	}

	@Override
	public void update(Ejercicio u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Ejercicio> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
