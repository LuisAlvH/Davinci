package DLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Ejercicio;

public class ControllerEjercicio {
	private static Connection conect = Conexion.getInstance().getConection();

	public static int agregarEjercicio(Ejercicio ejerci) {

		int idGenerado = 0;
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `Ejercicios`(`nombre`, `serie`, `descanso`,"
							+ "`repeticiones`,`puntos_progreso_ejer`) VALUES (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, ejerci.getNombre());
			statement.setInt(2, ejerci.getSerie());
			statement.setInt(3, ejerci.getDescansoEntreSerie());
			statement.setInt(4, ejerci.getRepeticiones());
			statement.setDouble(5, ejerci.getPointDeProgreso());

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

	public static void agregarRutinaHasEjercicio(int id_rutina, int id_ejercicio) {

		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("INSERT INTO `rutinas_has_ejercicios`(`fk_rutina`, `fk_ejercicio`) VALUES (?,?)");
			statement.setInt(1, id_rutina);
			statement.setInt(2, id_ejercicio);

			int filas = statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error, al agregar la rutina.");

		}

	}

	public static void mostrarInformacionEjercicio(int id_rutina) {

		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT e.nombre, e.serie, e.descanso, e.repeticiones " + "FROM rutinas r "
							+ "JOIN rutinas_has_ejercicios re ON r.id_rutina = re.fk_rutina "
							+ "JOIN ejercicios e ON e.id_ejercicio = re.fk_ejercicio " + "WHERE r.id_rutina = ?");

			statement.setInt(1, id_rutina);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int serie = resultSet.getInt("serie");
				int descanso = resultSet.getInt("descanso");
				int repeticiones = resultSet.getInt("repeticiones");
				System.out.println("nombre: " + nombre);
				System.out.println("serie: " + serie);
				System.out.println("descanso: " + descanso);
				System.out.println("repeticiones: " + repeticiones + "\n");

			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}

	}

	public static ArrayList<Ejercicio> obtenerInformacionEjecicio(int id_rutina) {
		ArrayList<Ejercicio> misEjercicicos = new ArrayList<Ejercicio>();
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT e.id_ejercicio, e.nombre, e.serie, e.descanso, e.repeticiones "
							+ "FROM rutinas r " + "JOIN rutinas_has_ejercicios re ON r.id_rutina = re.fk_rutina "
							+ "JOIN ejercicios e ON e.id_ejercicio = re.fk_ejercicio " + "WHERE r.id_rutina = ?");

			statement.setInt(1, id_rutina);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				misEjercicicos.add(new Ejercicio(resultSet.getString("nombre"), resultSet.getInt("serie"),
						resultSet.getInt("descanso"), resultSet.getInt("repeticiones"),
						resultSet.getInt("id_ejercicio")));

			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");

		}

		return misEjercicicos;

	}
	
	public static ArrayList<Integer> obteniendoInformacionIdEjercicios(int id_rutina) {
		ArrayList<Integer> misEjercicicos = new ArrayList<Integer>();
		
		
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT fk_ejercicio FROM Rutinas_has_ejercicios WHERE fk_rutina = ?");

			statement.setInt(1, id_rutina);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				misEjercicicos.add((Integer)resultSet.getInt("fk_ejercicio"));

				

			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información del ejercicio");

		}

		return misEjercicicos;

	}
	

	public static void actualizarEjercicio2(Ejercicio ejerc) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `ejercicios` SET `nombre`= ?, `serie`=? ,`descanso`= ? ,`repeticiones`= ?    WHERE id_ejercicio = ?");
			statement.setString(1, ejerc.getNombre());
			statement.setInt(2, ejerc.getSerie());
			statement.setInt(3, ejerc.getDescansoEntreSerie());
			statement.setInt(4, ejerc.getRepeticiones());
			statement.setInt(5, ejerc.getId_ejercicio());
			int fila = statement.executeUpdate();

			if (fila > 0) {

				System.out.println("\nEjercicio modificado...\t");
			}
		} catch (Exception e) {
			System.out.println("Error,Actualizando el los ejercicio");
		}

	}
	
	public static ArrayList<Ejercicio> obteniendoInformacionEjercicio(int id_rutina) {
		ArrayList<Ejercicio>ejercicios=new ArrayList<Ejercicio>();
		
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT e.nombre, e.serie, e.descanso, e.repeticiones " + "FROM rutinas r "
							+ "JOIN rutinas_has_ejercicios re ON r.id_rutina = re.fk_rutina "
							+ "JOIN ejercicios e ON e.id_ejercicio = re.fk_ejercicio " + "WHERE r.id_rutina = ?");

			statement.setInt(1, id_rutina);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int serie = resultSet.getInt("serie");
				int descanso = resultSet.getInt("descanso");
				int repeticiones = resultSet.getInt("repeticiones");
				
				ejercicios.add(new Ejercicio(nombre,serie,repeticiones,descanso,0));
				
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información de la rutina");
		}
		return ejercicios;

	}
}
