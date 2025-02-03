package GUI;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Cliente;
import BLL.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Cuenta_cliente extends JFrame {



	public Cuenta_cliente(Usuario usser) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		Cliente Cliente=new Cliente(usser.getUsser(), usser.getPass(), usser.getIdUsuario());
		Cliente inforPersonalCliente=Cliente.obteniendoInformacionCLiente(usser.getIdUsuario());
		
		 int yPosition = 20;  
	        int yIncrement = 15;
	        
	        JLabel lblTitulo = new JLabel("INFORMACION PERSONAL");
	        lblTitulo.setBounds(10, 15, 400, 20);
	        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
	        getContentPane().add(lblTitulo);
	        yPosition += yIncrement;
	        JLabel lblNombre = new JLabel("Nombre: " + inforPersonalCliente.getDatosUsuario().getNombre());
	        lblNombre.setBounds(10, yPosition, 400, 20);
	        lblNombre.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblNombre);
	        yPosition += yIncrement;  // Incrementar la posición Y

	        JLabel lblApellido = new JLabel("Apellido: " + inforPersonalCliente.getDatosUsuario().getApellido());
	        lblApellido.setBounds(10, yPosition, 400, 20);
	        lblApellido.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblApellido);
	        yPosition += yIncrement;

	        JLabel lblTel = new JLabel("Teléfono: " + inforPersonalCliente.getDatosUsuario().getTelefono());
	        lblTel.setBounds(10, yPosition, 400, 20);
	        lblTel.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblTel);
	        yPosition += yIncrement;

	        JLabel lblEdad = new JLabel("Edad: " + inforPersonalCliente.getDatosUsuario().getEdad());
	        lblEdad.setBounds(10, yPosition, 400, 20);
	        lblEdad.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblEdad);
	        yPosition += yIncrement;

	        JLabel lblEmail = new JLabel("Email: " + inforPersonalCliente.getDatosUsuario().getEmail());
	        lblEmail.setBounds(10, yPosition, 400, 20);
	        lblEmail.setFont(new Font("Arial", Font.PLAIN, 10));
	        getContentPane().add(lblEmail);
	        yPosition += yIncrement;

	        JLabel lblObjet = new JLabel("Tipo de objetivo: " + inforPersonalCliente.getObjetivoUsuario().getTipo_objetivo());
	        lblObjet.setBounds(10, yPosition, 400, 20);
	        lblObjet.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblObjet);
	        yPosition += yIncrement;

	        JLabel lblFechaObjet = new JLabel("Fecha inicial del objetivo: " + inforPersonalCliente.getObjetivoUsuario().getFechaInicial());
	        lblFechaObjet.setBounds(10, yPosition, 400, 20);
	        lblFechaObjet.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblFechaObjet);
	        yPosition += yIncrement;

	        JLabel lblEspacio = new JLabel("Espacio de entrenamiento: " + inforPersonalCliente.getLugarEntrenamiento().getEspacio());
	        lblEspacio.setBounds(10, yPosition, 400, 20);
	        lblEspacio.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblEspacio);
	        yPosition += yIncrement;

	        JLabel lblBarrio = new JLabel("Barrio: " + inforPersonalCliente.getLugarEntrenamiento().getBarrio());
	        lblBarrio.setBounds(10, yPosition, 400, 20);
	        lblBarrio.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblBarrio);
	        yPosition += yIncrement;

	        JLabel lblDireccion = new JLabel("Dirección: " + inforPersonalCliente.getLugarEntrenamiento().getDireccion());
	        lblDireccion.setBounds(10, yPosition, 400, 20);
	        lblDireccion.setFont(new Font("Arial", Font.PLAIN, 11));
	        getContentPane().add(lblDireccion);

	        
	    	
		JButton btnModInfo = new JButton("Modificar informacion");
		btnModInfo.setBounds(10, 213, 171, 23);
		getContentPane().add(btnModInfo);
		btnModInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormInfoCliente frame = new FormInfoCliente(usser);
				frame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnCambiarContrasea = new JButton("Cambiar Contraseña");
		btnCambiarContrasea.setBounds(253, 213, 171, 23);
		getContentPane().add(btnCambiarContrasea);
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormPass frame = new FormPass(usser);
				frame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(315, 36, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_cliente frame = new Menu_cliente(usser);
				frame.setVisible(true);
				dispose();
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
