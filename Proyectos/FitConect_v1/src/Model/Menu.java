package Model;

public class Menu {
	 private int id_menu;
	 private String nivel_cliente;
	 private int popularidad_cuenta;
	 private int id_objetivo;
	 private int id_area_entrenamiento;
	 private int id_usuario;
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public String getNivel_cliente() {
		return nivel_cliente;
	}
	public void setNivel_cliente(String nivel_cliente) {
		this.nivel_cliente = nivel_cliente;
	}
	public int getPopularidad_cuenta() {
		return popularidad_cuenta;
	}
	public void setPopularidad_cuenta(int popularidad_cuenta) {
		this.popularidad_cuenta = popularidad_cuenta;
	}
	public int getId_objetivo() {
		return id_objetivo;
	}
	public void setId_objetivo(int id_objetivo) {
		this.id_objetivo = id_objetivo;
	}
	public int getId_area_entrenamiento() {
		return id_area_entrenamiento;
	}
	public void setId_area_entrenamiento(int id_area_entrenamiento) {
		this.id_area_entrenamiento = id_area_entrenamiento;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Menu( int id_objetivo, int id_area_entrenamiento,
			int id_usuario) {
		super();
		this.id_menu = 0;
		this.nivel_cliente = "Principiante";
		this.popularidad_cuenta = 0;
		this.id_objetivo = id_objetivo;
		this.id_area_entrenamiento = id_area_entrenamiento;
		this.id_usuario = id_usuario;
	}
	 
	public Menu( ) {
		super();
		this.id_menu = 0;
		this.nivel_cliente = "Principiante";
		this.popularidad_cuenta = 0;
		this.id_objetivo = 0;
		this.id_area_entrenamiento = 0;
		this.id_usuario = 0;
	}
	
	
}
