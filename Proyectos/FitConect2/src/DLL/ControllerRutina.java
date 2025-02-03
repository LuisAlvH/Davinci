package DLL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Rutina;

public class ControllerRutina {

	
	private static Connection conect = Conexion.getInstance().getConection();
	
	
	public static int agregarRutina(Rutina rutina) {

		int idGenerado = 0;
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `Rutinas`(`titulo`, `dificultad`, `popularidad_rutina`,"
					+ "`puntos_progreso`,`actividad_deportiva`,`usuario_creador`,`compartida`) VALUES (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
					statement.setString(1, rutina.getTituloRutina());
					statement.setString(2, rutina.getDificultad());
					statement.setDouble(3, rutina.getPopularidadRutina());
					statement.setInt(4, rutina.getPuntos_progreso());
					statement.setString(5, rutina.getActividad_deportiva());
					statement.setString(6, rutina.getUsuarioCreador());
					statement.setInt(7, rutina.getCompartida());
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

			System.out.println("Error, al agregar la rutina.");

		}
		return idGenerado;

	}
	
	
	
	public static void actualizarRutina(int id_rutina, String dificultad, int compartida, int puntos_progreso) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `rutinas` SET `dificultad`= ?, `compartida`=? ,`puntos_progreso`= ?   WHERE id_rutina = ?");
			statement.setString(1, dificultad);
			statement.setInt(2, compartida);
			statement.setInt(3, puntos_progreso);
			statement.setInt(4, id_rutina);

			int fila=statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error,Actualizando el area");
		}

	}
	public static void actualizarRutina2(int id_rutina, String dificultad, String actividad, String titulo) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `rutinas` SET `dificultad`= ?, `titulo`=? ,`actividad_deportiva`= ?   WHERE id_rutina = ?");
			statement.setString(1, dificultad);
			statement.setString(2, titulo);
			statement.setString(3, actividad);
			statement.setInt(4, id_rutina);

			int fila=statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error,Actualizando el area");
		}

	}

	
	public static void actualizarRutina3(int id_rutina, int compartida) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `rutinas` SET `compartida`= ? WHERE id_rutina = ?");
			statement.setInt(1, compartida);
			statement.setInt(2, id_rutina);

			int fila=statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error,Actualizando el area");
		}

	}
	
	public static void ActualizandoPopularidadRutina(int id_rutina) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `rutinas` SET `popularidad_rutina`= `popularidad_rutina` + 1  WHERE id_rutina = ?");
			statement.setInt(1, id_rutina);

			int fila=statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error,Actualizando el popularidad");
		}

	}
	
	public static void  mostrasInformacionRutina(int id ) {
	
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `id_rutina`,`titulo`, `dificultad`,"
							+ " `popularidad_rutina`, `actividad_deportiva`,`usuario_creador` FROM rutinas  "
							+ "WHERE id_rutina= ? AND compartida=1 ");

			statement.setInt(1, id);
		
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				String titulo = resultSet.getString("titulo");
				String difi = resultSet.getString("dificultad");
				String popu = resultSet.getString("popularidad_rutina");
				String creador = resultSet.getString("usuario_creador");
				String act_depor = resultSet.getString("actividad_deportiva");
				System.out.println("Titulo: " + titulo);
				System.out.println("Dificultad: " + difi);
				System.out.println("Popularidad: " + popu);
				System.out.println("Actividad deportiva: " + act_depor);
				System.out.println("Creador: " + creador  +"\n");
				
			
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
	}
	public static void  mostrasInformacionRutinaUsuario(int id ) {
		
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `id_rutina`,`titulo`, `dificultad`,"
							+ " `popularidad_rutina`, `actividad_deportiva` FROM rutinas  "
							+ "WHERE id_rutina= ? ");

			statement.setInt(1, id);
		
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				String titulo = resultSet.getString("titulo");
				String difi = resultSet.getString("dificultad");
				String popu = resultSet.getString("popularidad_rutina");
				String act_depor = resultSet.getString("actividad_deportiva");
				System.out.println("Titulo: " + titulo);
				System.out.println("Dificultad: " + difi);
				System.out.println("Popularidad: " + popu);
				System.out.println("Actividad deportiva: " + act_depor+"\n");
	
				
			
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
	}
	public static int  obteniendoIdRutinaC(int comparte) {
		int id_rutina=0;
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `id_rutina` FROM rutinas  "
							+ "WHERE compartida= ? ");

			statement.setInt(1, comparte);
		
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				 id_rutina = resultSet.getInt("id_rutina");
			
				
			
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
		
	return id_rutina;
	}
	public static int  ObteniendoTotalRegistrosRutina() {
		int total=0;
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT COUNT(*) AS total_registros FROM rutinas  ");

		
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				total = resultSet.getInt("total_registros");
			
				
			
			}

		} catch (Exception e) {
			System.out.println("Error al obtener total de registros");
		}
		
	return total;
	}
	
	
	public static Rutina  ObteniendoRutinaBuscada(int id_rutina) {
		Rutina rut = null;
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `titulo`,`puntos_progreso`,`dificultad`,`actividad_deportiva`,`usuario_creador`,`compartida`  "
							+ " FROM rutinas  "
							+ "WHERE id_rutina= ? ");

			statement.setInt(1, id_rutina);
			
		
			ResultSet resultSet = statement.executeQuery();

			
		
			
			if (resultSet.next()) {
				
				 rut=new Rutina(resultSet.getString("titulo"),
				resultSet.getString("dificultad"),resultSet.getInt("puntos_progreso"),
				resultSet.getString("actividad_deportiva"),resultSet.getString("usuario_creador") );
				 
			
				
			
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
		
	return rut;
	}

	
	public static void EliminarRutina(int id_rutina) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"DELETE FROM `rutinas` WHERE id_rutina = ?");
				statement.setInt(1, id_rutina);
		

			int fila=statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error,eliminando el rutina");
			e.printStackTrace();
		}

	}
	
	public static ArrayList<Integer> obteniendoRutinasDelBuscador(String busqueda) {
		String busquedaOficial;
		ArrayList<Integer> misRutinas = new ArrayList<Integer>();
		try {
			
			busquedaOficial = "%" + busqueda + "%";
			
			  PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
		                "SELECT id_rutina FROM `rutinas` WHERE LOWER(actividad_deportiva) LIKE LOWER(?) AND compartida = 1");

			statement.setString(1,busquedaOficial);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
					
				
				misRutinas.add((Integer)resultSet.getInt("id_rutina"));
				

			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");

		}

		return misRutinas;

	}
	
	public static Rutina  obtenerInformacionDeRutina(int id ) {
		Rutina rut = null;
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `id_rutina`,`titulo`, `dificultad`,"
							+ " `popularidad_rutina`, `actividad_deportiva`,`usuario_creador` FROM rutinas  "
							+ "WHERE id_rutina= ? AND compartida=1 ");

			statement.setInt(1, id);
		
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				
				rut=new Rutina(resultSet.getString("titulo"),
						resultSet.getString("dificultad"),resultSet.getInt("popularidad_rutina"),
						resultSet.getString("actividad_deportiva"),resultSet.getString("usuario_creador"),resultSet.getInt("id_rutina") );
			}
	
		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
		return rut;
	}
	
public static Rutina  obteniendoRutsSinCompartirUsuario(int id ) {
	Rutina rut = null;
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `id_rutina`,`titulo`, `dificultad`,"
							+ " `popularidad_rutina`, `actividad_deportiva` FROM rutinas  "
							+ "WHERE id_rutina= ? ");

			statement.setInt(1, id);
		
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				String titulo = resultSet.getString("titulo");
				String difi = resultSet.getString("dificultad");
				String popu = resultSet.getString("actividad_deportiva");
				String act_depor = resultSet.getString("actividad_deportiva");
				
				
				rut = new Rutina(
					    resultSet.getString("titulo"),
					    resultSet.getString("dificultad"),
					    resultSet.getString("actividad_deportiva"),
					    resultSet.getInt("popularidad_rutina") , // Corrige el campo aquí
					    resultSet.getInt("id_rutina")
					);
				
			
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
		return rut;
	}
}
