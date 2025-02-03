package DLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Cliente;
import BLL.Usuario;

public class ControllerCliente {

	private static Connection conect = Conexion.getInstance().getConection();

	public static boolean existeElUsuarioEnLaBd(String usser, String pass) {
		boolean flag = false;

		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT * FROM `Usuarios` WHERE usser= ? AND pass= ? ");
			statement.setString(1, usser);
			statement.setString(2, pass);

			ResultSet resul = statement.executeQuery();
			if (resul.next()) {
				flag = true;

			}

		} catch (Exception e) {
			System.out.println("Error, en busqueda de usuario");
		}

		return flag;
	}

	public static int agregarCliente(String usuario, String pass, int id_datos) {

		int idGenerado = 0;
		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"INSERT INTO `Usuarios`(`usser`, `pass`, `fk_tipo`,`fk_dato_personal`) VALUES (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario);
			statement.setString(2, pass);
			statement.setInt(3, 1);
			statement.setInt(4, id_datos);

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
				System.out.println("Se ha registrado exitosamente!");
			}

		} catch (Exception e) {

			System.out.println("Error, al agregar un cliente..");

		}
		return idGenerado;

	}
	
	
	public static String encontrandoUsuario(int id_cliente) {
		String usser = null;
		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT usser FROM `Usuarios` WHERE id_usuario= ? ");
			statement.setInt(1, id_cliente);
			

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				usser = result.getString("usser");
						
			}

		} catch (Exception e) {
			System.out.println("Error, encontrandoUsuarioExistente ..");
		}

		return usser;
	}
	
	public static Usuario encontrandoUsuarioExistente(String usser, String pass) {
		Usuario clienteEncontrado = null;
		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT * FROM `Usuarios` WHERE usser= ? AND pass= ?");
			statement.setString(1, usser);
			statement.setString(2, pass);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				clienteEncontrado = new Cliente(result.getString("usser"), result.getString("pass"),
						result.getInt("id_usuario"));
			}

		} catch (Exception e) {
			System.out.println("Error, encontrandoUsuarioExistente ..");
		}

		return clienteEncontrado;
	}
	
	public static boolean ValidacionDePassword(int id_usuario ,String pass) {
		boolean flag=false;
		
		try {

			PreparedStatement statement = (PreparedStatement) conect
					.prepareStatement("SELECT * FROM `Usuarios` WHERE pass= ? AND id_usuario= ?");
			statement.setString(1, pass);
			statement.setInt(2, id_usuario);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				flag=true;
			}

		} catch (Exception e) {
			System.out.println("Error, en la validacion de password ..");
		}

		return flag;
	}
	
	public static void actualizarPassword(int id_usuario, String pass) {

		try {

			PreparedStatement statement = (PreparedStatement) conect.prepareStatement(
					"UPDATE `usuarios` SET `pass`= ?  WHERE id_usuario = ?");
			statement.setString(1, pass);
			statement.setInt(2, id_usuario);
			

			int fila=statement.executeUpdate();
			
			if (fila>0) {
				
				System.out.println("\n\tSe ha cambiado la contraseña...\t");
			}
		} catch (Exception e) {
			System.out.println("Error,Actualizando el area");
		}

	}
}
