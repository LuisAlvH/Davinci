import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Partido {

	private String resultado;
	private Equipo uno;
	private Equipo dos;
	private Equipo ganador;
	
	


		
	public Partido( Equipo uno, Equipo dos) {
		super();
		
		this.uno = uno;
		this.dos = dos;
	}
	
	public Partido() {
		super();
		
		this.uno = null;
		this.dos = null;
		this.ganador = new Equipo();
	}
	
	
	
	



	public String getResultado() {
		return resultado;
	}






	public void setResultado(String resultado) {
		this.resultado = resultado;
	}






	public Equipo getUno() {
		return uno;
	}






	public void setUno(Equipo uno) {
		this.uno = uno;
	}






	public Equipo getDos() {
		return dos;
	}






	public void setDos(Equipo dos) {
		this.dos = dos;
	}


	public Equipo getGanador() {
		return ganador;
	}






	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}







	public Equipo JugarPartidoYDevuelveGanador() {
		
		
			int goles1;
			int goles2;

			goles1 = (int) (Math.random() * 3) + 1;
			goles2 = (int) (Math.random() * 3) + 1;

			
			
			if (goles1 == goles2) {
				Partido pjugado=new Partido();
			
				resultado=PenalesJuego1vs1(uno,dos,pjugado);
				
				return pjugado.getGanador();

			} else if (goles1 < goles2) {
				
				resultado=(uno.getNombreEquipo() + "[" + goles1 + "]"
						+ "  vs  " + dos.getNombreEquipo() + "[" + goles2 + "]" + "\n");

				return dos;
				

			} else {

				resultado=(uno.getNombreEquipo() + "[" + goles1 + "]"
						+ "  vs  " + dos.getNombreEquipo() + "[" + goles2 + "]" + "\n");
				
				return uno;

			}

		
		
		
		
		
	}
	
	public String InformacionInicialPartido() {
		
		
		return(uno.getNombreEquipo()+"  vs  "+dos.getNombreEquipo());
		
		
		
	}
	
	public String InformacionFinalPartido() {
		
		return resultado;
		
		

	}
	
	
	
	
	private static String PenalesJuego1vs1(Equipo uno, Equipo dos ,Partido pjugado) {
		char equipo1;
		char equipo2;
		String mensaje1 = "";
		String mensaje2 = "";
		int difDeLosGoles = 0;
		int positivosEquipo1 = 0;
		int positivosEquipo2 = 0;
		int rondas = 0;

		do {

			rondas++;

			equipo1 = PenalPateado((int) (Math.random() * 2) + 1);
			mensaje1 += equipo1 + " ";

			if (equipo1 == 'O') {
				positivosEquipo1++;

			}

			equipo2 = PenalPateado((int) (Math.random() * 2) + 1);
			mensaje2 += equipo2 + " ";
			if (equipo2 == 'O') {

				positivosEquipo2++;
			}

			difDeLosGoles = Math.abs(positivosEquipo1 - positivosEquipo2);

			if (rondas >= 5 && difDeLosGoles == 0) {

				do {
					equipo1 = PenalPateado((int) (Math.random() * 2) + 1);
					mensaje1 += equipo1 + " ";

					if (equipo1 == 'O') {
						positivosEquipo1++;

					}
					equipo2 = PenalPateado((int) (Math.random() * 2) + 1);
					mensaje2 += equipo2 + " ";
					if (equipo2 == 'O') {

						positivosEquipo2++;
					}

					difDeLosGoles = Math.abs(positivosEquipo1 - positivosEquipo2);

				} while (difDeLosGoles != 1);

				if (difDeLosGoles == 1) {

					difDeLosGoles = 3;
				}

			} else if (rondas >= 5 && difDeLosGoles == 1) {

				difDeLosGoles = 3;

			} else if (rondas >= 5 && difDeLosGoles == 2) {

				difDeLosGoles = 3;
			} else if (rondas == 3 && difDeLosGoles == 3) {

				difDeLosGoles = 3;
			} else if (rondas == 4 && difDeLosGoles == 2) {
				difDeLosGoles = 3;
			}

		} while (difDeLosGoles != 3);

		if (positivosEquipo1 > positivosEquipo2) {
			
			pjugado.setGanador(uno);
					return ( uno.getNombreEquipo() + "  vs  " + dos.getNombreEquipo()
							+ "[PENALES]\n" + " " + mensaje1 + "  -  " + mensaje2
							+ "\nGanador: " + uno.getNombreEquipo()+"\n");
					

		} else {

			pjugado.setGanador(dos);
					return (uno.getNombreEquipo() + "  vs  " + dos.getNombreEquipo()
							+ "[PENALES]\n" + " " + mensaje1 + "  -  " + mensaje2
							+ "\nGanador: " + dos.getNombreEquipo()+"\n");
		}

	}
	
	
	

	



	private static char PenalPateado(int penal) {

		if (penal == 1) {
			return 'O';
		} else {
			return 'X';
		}

	}

	
	
	
	
	

	
}

