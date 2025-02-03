package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class MenuDao implements DaoGenerico<Menu> {
	private static final String SQL_READ = "SELECT `id_menu`, `nivel_cliente`, `popularidad_cuenta`, `fk_objetivo`, `fk_area_entrenamiento` FROM `menu` WHERE fk_usuario= ?";
	private static final String SQL_READ_ALLRUT_MENU = "SELECT `id_rutina` FROM `menu_usuario_has_rutinas` WHERE id_menu= ?";
	private static final String SQL_UPDATE = "UPDATE `rutinas` SET `popularidad_rutina` = ? WHERE `id_rutina` = ?";
	
	
	private static final String SQL_INSERT = "INSERT INTO `menu`(`nivel_cliente`, `popularidad_cuenta`, `fk_objetivo`,`fk_area_entrenamiento`,`fk_usuario`) VALUES (?,?,?,?,?)";
	public ArrayList<Integer> readAllRutinasHasMenu(int id_menu) {

		ArrayList<Integer> idRutinasTodasHasMenu = new ArrayList<Integer>();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ_ALLRUT_MENU);
			/// PREPARA LA CONSULTA
			preparedStatement.setInt(1, id_menu);
			
			ResultSet resultado = preparedStatement.executeQuery();
			// EJECUTA LA CONSULTA Y DEVUELVE UN RESULTADO

			Conexion.getConecBd().setAutoCommit(false);
			/// DESACTIVAMOS LA VALIDACION AUTOMATICA DE TRANSACCIONES PARA CONTROLAR EL
			/// COMPROMISO DE LA TRANSACCIONES

			/// EJECUTAMOS LA QUERY

			resultado.last();/// METODO QUE ME PARA EN EL ULTIMO ELEMENTO REGISTRADO..
			resultado.last();/// METODO QUE ME PARA EN EL ULTIMO ELEMENTO REGISTRADO..

			if (resultado.getRow() > 0) { /// VERIFICAMOS SI EL ULTIMO ES MAYOR A 0
				resultado.beforeFirst(); /// METODO QUE ME DEVUELVE AL PRIMERO ELEMENTO REGISTRADO.

				idRutinasTodasHasMenu = new ArrayList<Integer>();

				while (resultado.next()) {

					int id_rutina = resultado.getInt("id_rutina");

					idRutinasTodasHasMenu.add(id_rutina);
				}
				Conexion.getConecBd().commit(); /// CONFIRMAMOS LA TRANSACCION
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return idRutinasTodasHasMenu;

	}

	@Override
	public int add(Menu a) {
	
			
			
			int idGenerado = 0;
			PreparedStatement preparedStatement;

			try {
				
				preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
						PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, a.getNivel_cliente());
				preparedStatement.setInt(2, a.getPopularidad_cuenta());
				preparedStatement.setInt(3, a.getId_objetivo());
				preparedStatement.setInt(4, a.getId_area_entrenamiento());
				preparedStatement.setInt(5, a.getId_usuario());
				
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
	public void update(Menu u) {

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Menu read(int id_cliente) {
		PreparedStatement preparedStatement;
		ResultSet resultado;
		Menu menu_usser = null;
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READ);
			preparedStatement.setInt(1, id_cliente);

			resultado = preparedStatement.executeQuery();
			if (resultado.next()) { // Usamos 'if' ya que esperamos solo un resultado
				menu_usser = new Menu();
				menu_usser.setId_menu(resultado.getInt("id_menu"));
				menu_usser.setNivel_cliente(resultado.getString("nivel_cliente"));
				menu_usser.setPopularidad_cuenta(resultado.getInt("popularidad_cuenta"));
				menu_usser.setId_objetivo(resultado.getInt("fk_objetivo"));
				menu_usser.setId_area_entrenamiento(resultado.getInt("fk_area_entrenamiento"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

		return menu_usser;
	}

	@Override
	public ArrayList<Menu> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
