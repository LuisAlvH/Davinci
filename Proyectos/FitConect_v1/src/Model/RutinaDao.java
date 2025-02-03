package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ControllerDao.DaoGenerico;
import Util.Conexion;

public class RutinaDao implements DaoGenerico<Rutina> {
	private static final String SQL_READALL = "SELECT * FROM rutinas;";
	private static final String SQL_READALLSEARCH = "SELECT `id_rutina`, `titulo`, `dificultad`, `popularidad_rutina`, `actividad_deportiva`,`usuario_creador` , `compartida` FROM `rutinas` WHERE LOWER(actividad_deportiva) LIKE LOWER(?) AND compartida = 1;";
	private static final String SQL_UPDATELIKE = "UPDATE `rutinas` SET `popularidad_rutina` = ? WHERE `id_rutina` = ?";
	private static final String SQL_INSERT = "INSERT INTO `rutinas`(`titulo`, `dificultad`, `popularidad_rutina`,`actividad_deportiva`,`usuario_creador`,`compartida`,`puntos_progreso`) VALUES (?,?,?,?,?,?,?)";
	private static final String SQL_INSERT_MENU_HAS_RUTI = "INSERT INTO `menu_usuario_has_rutinas`(`id_menu`, `id_rutina`) VALUES (?,?)";
	private static final String SQL_READALL_RUTSC = "SELECT r.id_rutina, r.titulo, r.dificultad, r.popularidad_rutina, r.actividad_deportiva, r.usuario_creador, r.compartida " +
            "FROM menu m " +
            "JOIN menu_usuario_has_rutinas mu ON m.id_menu = mu.id_menu " +
            "JOIN rutinas r ON r.id_rutina = mu.id_rutina " +
            "WHERE r.compartida = ? AND m.id_menu = ?";
	
	private static final String SQL_DELETE="DELETE FROM `rutinas` WHERE id_rutina = ?";
	private static final String SQL_UPDATECOMPAR = "UPDATE `rutinas` SET `compartida` = ? WHERE `id_rutina` = ?";
	private static final String SQL_UPDATE_DTA="UPDATE `rutinas` SET `dificultad`= ?, `titulo`=? ,`actividad_deportiva`= ?   WHERE id_rutina = ?";
	
	
	

	
	public void updateDTA(Rutina u) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATE_DTA);
			preparedStatement.setString(1, u.getDificultad());
			preparedStatement.setString(2, u.getTitulo());
			preparedStatement.setString(3, u.getActividad_deportiva());
			preparedStatement.setInt(4, u.getId_rutina());
			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Rutina ha sido actualizado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}

	}
	
	
	
	@Override
	public void update(Rutina u) {
		
	}
	
	
	
	public void updateCompartir(Rutina u) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATECOMPAR);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, u.getId_rutina());
		

			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Rutina ha sido actualizado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}
		
	}
	public void updateDescompartir(Rutina u) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATECOMPAR);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, u.getId_rutina());
		

			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Rutina ha sido actualizado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}
		
	}
	
	
	public ArrayList<Rutina> readAllRutiSinCompartirDelUsuario(int id_menu) {
		
		ArrayList<Rutina> rutinas_usuarios = new ArrayList<Rutina>();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READALL_RUTSC);
	
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, id_menu);
			
			
			
			ResultSet resultado = preparedStatement.executeQuery();
		

			Conexion.getConecBd().setAutoCommit(false);
			
			


			resultado.last();

			if (resultado.getRow() > 0) { 
				resultado.beforeFirst();

				while (resultado.next()) {

					Rutina ruti = new Rutina();
					ruti.setId_rutina(resultado.getInt("id_rutina"));
					ruti.setTitulo(resultado.getString("titulo"));
					ruti.setDificultad(resultado.getString("dificultad"));
					ruti.setPopularidad_rutina(resultado.getInt("popularidad_rutina"));
					ruti.setActividad_deportiva(resultado.getString("actividad_deportiva"));
					ruti.setUsuario_creador(resultado.getNString("usuario_creador"));
					ruti.setCompartida(resultado.getInt("compartida"));
					
					rutinas_usuarios.add(ruti);

				}
				Conexion.getConecBd().commit(); 
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return rutinas_usuarios;
		
	}
	
		public ArrayList<Rutina> readAllRutiCompartirDelUsuario(int id_menu) {
		
		ArrayList<Rutina> rutinas_usuarios = new ArrayList<Rutina>();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READALL_RUTSC);
	
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, id_menu);
			
			
			
			ResultSet resultado = preparedStatement.executeQuery();
		

			Conexion.getConecBd().setAutoCommit(false);
			
			


			resultado.last();

			if (resultado.getRow() > 0) { 
				resultado.beforeFirst();

				while (resultado.next()) {

					Rutina ruti = new Rutina();
					ruti.setId_rutina(resultado.getInt("id_rutina"));
					ruti.setTitulo(resultado.getString("titulo"));
					ruti.setDificultad(resultado.getString("dificultad"));
					ruti.setPopularidad_rutina(resultado.getInt("popularidad_rutina"));
					ruti.setActividad_deportiva(resultado.getString("actividad_deportiva"));
					ruti.setUsuario_creador(resultado.getNString("usuario_creador"));
					ruti.setCompartida(resultado.getInt("compartida"));
					
					rutinas_usuarios.add(ruti);

				}
				Conexion.getConecBd().commit(); 
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return rutinas_usuarios;
		
	}
	
	
	
	
	
	
	
	public int conectandoMenuHasRutina(int id_rutina,int id_menu) {
		
		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT_MENU_HAS_RUTI,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id_menu);
			preparedStatement.setInt(2, id_rutina);
			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				try {
					ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

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
	public int add(Rutina a) {
		
		
		int idGenerado = 0;
		PreparedStatement preparedStatement;

		try {
			
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, a.getTitulo());
			preparedStatement.setString(2, a.getDificultad());
			preparedStatement.setInt(3, a.getPopularidad_rutina());
			preparedStatement.setString(4, a.getActividad_deportiva());
			preparedStatement.setString(5, a.getUsuario_creador());
			preparedStatement.setInt(6, a.getCompartida());
			preparedStatement.setInt(7, 0);
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void updatePopularidad(Rutina u) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_UPDATELIKE);
			preparedStatement.setInt(1,  u.getPopularidad_rutina());
			preparedStatement.setInt(2, u.getId_rutina());
		

			int filas = preparedStatement.executeUpdate();
			if (filas > 0) {

				System.out.println("Rutina ha sido actualizado...");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexion.closeConnection();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Rutina> readAllSearch(String busqueda) {

		String busquedaOficial;
		ArrayList<Rutina> rutinas_busqueda = new ArrayList<Rutina>();
		PreparedStatement preparedStatement;
		try {

			busquedaOficial = "%" + busqueda + "%";

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_READALLSEARCH);
			preparedStatement.setString(1, busquedaOficial);
			ResultSet resultado = preparedStatement.executeQuery();
			Conexion.getConecBd().setAutoCommit(false);

			resultado.last();

			if (resultado.getRow() > 0) {
				resultado.beforeFirst();

				while (resultado.next()) {

					Rutina ruti = new Rutina();
					ruti.setId_rutina(resultado.getInt("id_rutina"));
					ruti.setTitulo(resultado.getString("titulo"));
					ruti.setDificultad(resultado.getString("dificultad"));
					ruti.setPopularidad_rutina(resultado.getInt("popularidad_rutina"));
					ruti.setActividad_deportiva(resultado.getString("actividad_deportiva"));
					ruti.setUsuario_creador(resultado.getNString("usuario_creador"));
					ruti.setCompartida(resultado.getInt("compartida"));
					rutinas_busqueda.add(ruti);

				}
				Conexion.getConecBd().commit();
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			Conexion.closeConnection();
		}

		return rutinas_busqueda;

	}

	@Override
	public ArrayList<Rutina> readAll() {
		ArrayList<Rutina> rutinas_usuarios = new ArrayList<Rutina>();
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

				while (resultado.next()) {

					Rutina ruti = new Rutina();
					ruti.setId_rutina(resultado.getInt("id_rutina"));
					ruti.setTitulo(resultado.getString("titulo"));
					ruti.setDificultad(resultado.getString("dificultad"));
					ruti.setPopularidad_rutina(resultado.getInt("popularidad_rutina"));
					ruti.setActividad_deportiva(resultado.getString("actividad_deportiva"));
					ruti.setUsuario_creador(resultado.getNString("usuario_creador"));
					ruti.setCompartida(resultado.getInt("compartida"));
					rutinas_usuarios.add(ruti);

				}
				Conexion.getConecBd().commit(); /// CONFIRMAMOS LA TRANSACCION
			}

		} catch (SQLException e) {

		} finally {
			Conexion.closeConnection();
		}

		return rutinas_usuarios;

	}



	@Override
	public void delete(int id_rutina) {
		PreparedStatement preparedStatement;
		try {

			preparedStatement = (PreparedStatement) Conexion.getConecBd().prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, id_rutina);
		

			int filasAfectadas = preparedStatement.executeUpdate();
	    
			
			
		} catch (Exception e) {
	        System.out.println("Error eliminando la rutina.");
	        e.printStackTrace();
	    } finally {
	        Conexion.closeConnection();
	    }

	}

	@Override
	public Rutina read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
