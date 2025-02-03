package BLL;

import java.util.ArrayList;
import java.util.Scanner;

import DLL.ControllerMenu;

public class Cliente extends Usuario {

		private DatosPersonales DatosUsuario;
		private AreaEntrenamiento LugarEntrenamiento;
		private Objetivo  ObjetivoUsuario;
	
	
	
	


	
	public Cliente(String usser, String pass, int idUsuario, DatosPersonales datosUsuario,
				AreaEntrenamiento lugarEntrenamiento, Objetivo objetivoUsuario) {
			super(usser, pass, idUsuario);
			DatosUsuario = datosUsuario;
			LugarEntrenamiento = lugarEntrenamiento;
			ObjetivoUsuario = objetivoUsuario;
		}

	public Cliente(String usser, String pass, int idUsuario) {
		super(usser, pass, idUsuario);
		
		
	}

	public boolean MenuUsuario() {
		
		Menu_cliente menuCliente=new Menu_cliente(this.getIdUsuario());
		
	
		return  menuCliente.MenuUsuario();
		
		
	}
	public Cliente obteniendoInformacionCLiente(int id_usuario){
		
		return ControllerMenu.mostrasInformacion(id_usuario);
		
	}

	public DatosPersonales getDatosUsuario() {
		return DatosUsuario;
	}

	public void setDatosUsuario(DatosPersonales datosUsuario) {
		DatosUsuario = datosUsuario;
	}

	public AreaEntrenamiento getLugarEntrenamiento() {
		return LugarEntrenamiento;
	}

	public void setLugarEntrenamiento(AreaEntrenamiento lugarEntrenamiento) {
		LugarEntrenamiento = lugarEntrenamiento;
	}

	public Objetivo getObjetivoUsuario() {
		return ObjetivoUsuario;
	}

	public void setObjetivoUsuario(Objetivo objetivoUsuario) {
		ObjetivoUsuario = objetivoUsuario;
	}
	
	

}