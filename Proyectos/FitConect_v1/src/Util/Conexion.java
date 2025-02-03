package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection conexionBd=null;

	public static Connection getConecBd() {

		if (conexionBd == null) {

			try {

				String URL = "jdbc:mysql://localhost:3306/fitconnect";
				String USSER = "root";
				String PASS = "";

				conexionBd = DriverManager.getConnection(URL, USSER, PASS);
				System.out.println("Coneccion exitosa..!");

			} catch (SQLException e) {
				System.out.println("Error, al conectar las base de datos");

			}

		}

		return conexionBd;

	}

	public static void closeConnection() {
		if (conexionBd != null) {
			try {
				conexionBd.close();
				conexionBd = null;
				System.out.println("Conexión cerrada correctamente.");
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión: " + e.getMessage());
			}
		} else {
			System.out.println("No hay ninguna conexión activa para cerrar.");
		}
	}

}
