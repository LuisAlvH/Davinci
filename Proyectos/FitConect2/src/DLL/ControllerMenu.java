package DLL;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.AreaEntrenamiento;
import BLL.Cliente;
import BLL.DatosPersonales;
import BLL.Objetivo;

public class ControllerMenu {

	private static Connection conect = Conexion.getInstance().getConection();

	public static void agregarMenu(int id_obje, int id_area, int id_usuario) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `menu`(`nivel_cliente`,`popularidad_cuenta`,`fk_objetivo`,`fk_area_entrenamiento`,`fk_usuario`)"
							+ " VALUES (?,?,?,?,?)");
			statement.setString(1, "principiante");
			statement.setInt(2, 0);
			statement.setInt(3, id_obje);
			statement.setInt(4, id_area);
			statement.setInt(5, id_usuario);
			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error, al agregar el menu..");

		}

	}

	public static Cliente mostrasInformacion(int id) {
		
		
		Cliente cliente = null;
		try {
			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT d.nombre, d.apellido, d.telefono, d.edad, d.email, "
							+ "o.tipo_objetivo, o.fecha_inicial, a.espacio, a.barrio, a.direccion " + "FROM menu m "
							+ "JOIN usuarios u ON m.fk_usuario = u.id_usuario "
							+ "JOIN datos_personales d ON u.id_usuario = d.id_dato_personal "
							+ "JOIN objetivos o ON m.fk_objetivo = o.id_objetivo "
							+ "JOIN areas_entrenamientos a ON m.fk_area_entrenamiento = a.id_area_entrenamiento "
							+ "WHERE m.fk_usuario = ?;");

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String telefono = resultSet.getString("telefono");
				int edad = resultSet.getInt("edad");
				String email = resultSet.getString("email");
				
				
				String tipoObjetivo = resultSet.getString("tipo_objetivo");
				Date fechaInicial = resultSet.getDate("fecha_inicial");
				
				
				String espacio = resultSet.getString("espacio");
				String barrio = resultSet.getString("barrio");
				String direccion = resultSet.getString("direccion");

				
				DatosPersonales DatosUsser=new DatosPersonales(nombre, apellido, edad, telefono, email);
				AreaEntrenamiento LugarEntrenamiento=new AreaEntrenamiento(espacio, barrio, direccion);
				Objetivo  ObjetivoUsuario=new Objetivo(tipoObjetivo, fechaInicial.toLocalDate());
				 
				cliente=new Cliente("","" ,0, DatosUsser, LugarEntrenamiento, ObjetivoUsuario); 
				
				/*System.out.println("\n\t*INFOMARCION ACTUAL*\t\n");
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellido: " + apellido);
				System.out.println("Teléfono: " + telefono);
				System.out.println("Edad: " + edad);
				System.out.println("Email: " + email);
				System.out.println("Tipo de Objetivo: " + tipoObjetivo);
				System.out.println("Fecha Inicial: " + fechaInicial);
				System.out.println("Espacio: " + espacio);
				System.out.println("Barrio: " + barrio);
				System.out.println("Dirección: " + direccion + "\n");*/
			}

		} catch (Exception e) {
			System.out.println("Error al obtener la información: " + e.getMessage());
		}
		
		
		return cliente;
	}

	public static int[] obtenerIdsMenu(int id_usuario) {
		int[] ids = new int[2];

		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `fk_objetivo`,`fk_area_entrenamiento` FROM `menu` WHERE fk_usuario= ?");
			statement.setInt(1, id_usuario);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				ids[0] = result.getInt("fk_objetivo");
				ids[1] = result.getInt("fk_area_entrenamiento");

			}

		} catch (Exception e) {

			System.out.println("Error, al obtener los ids menu..");

		}
		return ids;

	}

	public static int obtenerIdMenu(int id_usuario) {
		int id_menu = 0;

		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT `id_menu` FROM `menu` WHERE fk_usuario= ?");
			statement.setInt(1, id_usuario);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				id_menu = result.getInt("id_menu");

			}

		} catch (Exception e) {

			System.out.println("Error, al obtener el id menu..");

		}
		return id_menu;

	}

	public static void agregarRutinaHasMenu(int id_menu, int id_rutina) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `menu_usuario_has_rutinas`(`id_menu`,`id_rutina`)" + " VALUES (?,?)");
			statement.setInt(1, id_menu);
			statement.setInt(2, id_rutina);
			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error, al agregar Rutinas has menus.");

		}

	}

	public static ArrayList<Integer> obteniendoRutinasId(int id_menu) {
		ArrayList<Integer> rutinasId = new ArrayList<Integer>();
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					 "SELECT r.id_rutina " +
				                "FROM menu m " +
				                "JOIN menu_usuario_has_rutinas mu " +
				                "ON m.id_menu = mu.id_menu " +  
				                "JOIN rutinas r " +
				                "ON r.id_rutina = mu.id_rutina " +
				                "WHERE r.compartida = ? AND m.id_menu = ?");
			statement.setInt(1, 1);
			statement.setInt(2, id_menu);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				rutinasId.add(resultSet.getInt("id_rutina"));
			}

		} catch (Exception e) {
			System.out.println("No se agregó");
		}

		return rutinasId;
	}
	public static ArrayList<Integer> obteniendoRutinasIdSinCompartir(int id_menu) {
		ArrayList<Integer> rutinasId = new ArrayList<Integer>();
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					 "SELECT r.id_rutina " +
				                "FROM menu m " +
				                "JOIN menu_usuario_has_rutinas mu " +
				                "ON m.id_menu = mu.id_menu " +  
				                "JOIN rutinas r " +
				                "ON r.id_rutina = mu.id_rutina " +
				                "WHERE r.compartida = ? AND m.id_menu = ?");
			statement.setInt(1, 0);
			statement.setInt(2, id_menu);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				rutinasId.add(resultSet.getInt("id_rutina"));
			}

		} catch (Exception e) {
			System.out.println("No se agregó");
		}

		return rutinasId;
	}

}
