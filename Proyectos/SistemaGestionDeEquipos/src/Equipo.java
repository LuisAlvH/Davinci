import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Equipo {

	private String nombreEquipo;
	private String Ciudad;
	private ArrayList<Jugador> jugadores=new ArrayList<>();
	
	
	
///CONSTRUCTOR
public Equipo() {
		
		this.nombreEquipo = "";
		Ciudad = "";
		
		
	}
	
	
	public Equipo(String nombreEquipo, String ciudad) {
		super();
		this.nombreEquipo = nombreEquipo;
		Ciudad = ciudad;
		
		
	}
	
	
	

///GET AND SET
		
	
	

	public String getNombreEquipo() {
		return nombreEquipo;
	}



	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}



	public String getCiudad() {
		return Ciudad;
	}



	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}



	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}



	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
///TO STRING

	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", Ciudad=" + Ciudad + ", jugadores=" + jugadores + "]";
	} 
	

///AGREGANDO JUGADOR A LA LISTA	
public void agregarJugadorAlEquipo(Jugador jugador) {
	
		jugadores.add(jugador);
	
	
		
}
///ELIMINANDO JUGADOR DE LA LISTA

public void eliminarJugadorDeLalista(String nombre) {
	
	
		if(nombre!=null) {
		for (int i = 0; i < this.jugadores.size(); i++) {
			
				if(jugadores.get(i).getNombre().equalsIgnoreCase(nombre)) {
					
					jugadores.remove(i);
				}
			
		}
	
		}
}

///BUSCAR JUGADOR POR NOMBRE


public void buscandoJugadorEspecifico(String nombre) {
	
	
	
	
		for (Jugador jugadorAux : jugadores) {
			
				if(nombre.equalsIgnoreCase(jugadorAux.getNombre())) {
					
					System.out.println(" "+jugadorAux.toString());
					
				}else {
					
					System.out.println("Ese nombre, no existe en nuestros registros...");
				}
			
		}
	
	
}
	
///OBTENER CANTIDAD TOTAL DE JUGADORES EN MI EQUIPO
public void mostrarCantidadTotalDeJugadoresEnMiEquipo() {

	
	JOptionPane.showMessageDialog(null, "Tu equipo presenta "+jugadores.size()+" jugadores");
	
	
}

///MOSTRAR LISTA DE JUGADORES DE MI EQUIPO


public void mostrarListaDeJugadoresDeMiEquipo() {
int i=1;

String mensaje="\nLista de jugadores\n";

	if(!jugadores.isEmpty()) {
	for (Jugador jugadorAux : jugadores) {
		
		mensaje+=""+i+"- "+jugadorAux.toString()+"\n";
		
		
			i++;
		

	}
	
	JOptionPane.showMessageDialog(null, mensaje);
	}else {
		
		JOptionPane.showMessageDialog(null, "No presentas jugadores!");
	}
	
}


	
	


	
}
