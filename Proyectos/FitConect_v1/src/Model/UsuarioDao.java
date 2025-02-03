package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class UsuarioDao implements DaoGenerico<Usuario> {

	private static final String SQL_INSERT = "INSERT INTO `Usuarios`(`usser`, `pass`, `fk_tipo`,`fk_dato_personal`) VALUES (?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM `Usuarios` WHERE id_usuario= ? ";
	
	private static final String SQL_UPDATE = "UPDATE `usuarios` SET `pass` = ?, `fk_dato_personal` = ? WHERE `id_usuario` = ?";

	private static final String SQL_READ = "SELECT `id_usuario`, `usser`, `pass`, `fk_tipo`, `fk_dato_personal` FROM `usuarios` WHERE id_usuario= ?";
	private static final String SQL_READALL = "SELECT * FROM Usuarios;";

	private static final Connection myConec = Conexion.getConecBd();


	// https://www.youtube.com/watch?v=pe3ecG2wqhk 24

	@Override
	public int add(Usuario usuario) {
		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, usuario.getUsser());
			preparedStatement.setString(2, usuario.getPass());
			preparedStatement.setInt(3, 1);
			preparedStatement.setInt(4, usuario.getIdDatosPersonales());

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

			Conexion.getConecBd().commit(); /// CONFIRMAMOS LA TRANSACCION

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			Conexion.closeConnection();

		}

		return idGenerado;

	}

	@Override
	public ArrayList<Usuario> readAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READALL);
			/// PREPARA LA CONSULTA

			ResultSet resultado = preparedStatement.executeQuery(SQL_READALL);
			// EJECUTA LA CONSULTA Y DEVUELVE UN RESULTADO

			Conexion.getConecBd().setAutoCommit(false);
			/// DESACTIVAMOS LA VALIDACION AUTOMATICA DE TRANSACCIONES PARA CONTROLAR EL
			/// COMPROMISO DE LA TRANSACCIONES

			/// EJECUTAMOS LA QUERY

			resultado.last();/// METODO QUE ME PARA EN EL ULTIMO ELEMENTO REGISTRADO..

			resultado.last();/// METODO QUE ME PARA EN EL ULTIMO ELEMENTO REGISTRADO..

			if (resultado.getRow() > 0) { /// VERIFICAMOS SI EL ULTIMO ES MAYOR A 0
				resultado.beforeFirst(); /// METODO QUE ME DEVUELVE AL PRIMERO ELEMENTO REGISTRADO.

				usuarios = new ArrayList<Usuario>();

				while (resultado.next()) {

					Usuario usser = new Usuario();
					usser.setIdUsuario(resultado.getInt("id_usuario"));
					usser.setUsser(resultado.getString("usser"));
					usser.setPass(resultado.getString("pass"));

					usser.setTipoUsuario(resultado.getInt("fk_tipo"));

					usser.setIdDatosPersonales(resultado.getInt("fk_dato_personal"));
					usuarios.add(usser);

				}
				Conexion.getConecBd().commit(); /// CONFIRMAMOS LA TRANSACCION
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return usuarios;
	}

	@Override
	public void update(Usuario usuario) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, usuario.getPass());
			preparedStatement.setInt(2, usuario.getIdDatosPersonales());
			preparedStatement.setInt(3, usuario.getIdUsuario());

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

		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, id);

			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Usuario ha sido eliminado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

	}

	@Override
	public Usuario read(int id) {
		PreparedStatement preparedStatement;
		ResultSet resultado;
		Usuario usser = null;
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ);
			preparedStatement.setInt(1, id);

	        resultado = preparedStatement.executeQuery();
			while (resultado.next()) {

				usser = new Usuario();
				usser.setIdUsuario(resultado.getInt("id_usuario"));
				usser.setUsser(resultado.getString("usser"));
				usser.setPass(resultado.getString("pass"));
				usser.setTipoUsuario(resultado.getInt("fk_tipo"));
				usser.setIdDatosPersonales(resultado.getInt("fk_dato_personal"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

		return usser;
	}

}
