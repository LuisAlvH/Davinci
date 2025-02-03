package DLL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Objetivo;

public class ControllerObjetivo {

	private static Connection conect = Conexion.getInstance().getConection();

	public static int agregarObjetivo(Objetivo obje) {
		int idGenerado = 0;
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `Objetivos`(`tipo_objetivo`, `fecha_inicial`, `porcen_progreso`) VALUES (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, obje.getTipo_objetivo());
			statement.setNull(2, java.sql.Types.DATE);
			statement.setFloat(3, obje.getPorcent_progreso());

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

			System.out.println("Error, al agregar un objetivo..");

		}
		return idGenerado;

	}

	public static void actualizarObjetivo(int id_objetivo, String tipo_objetivo) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `objetivos` SET `tipo_objetivo`= ?," + "`fecha_inicial`= ?  WHERE id_objetivo = ?");
			statement.setString(1, tipo_objetivo);
			statement.setDate(2, Date.valueOf(LocalDate.now()));
			statement.setInt(3, id_objetivo);

			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error,Actualizando el objetivo");
		}

	}
}
