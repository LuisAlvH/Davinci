package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import Controller.usuarioControlador;
import Model.Rutina;
import Model.Usuario;

public class crear_rutina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Rutina rutinaNueva=new Rutina();


	public crear_rutina(int id_usuario) {
		setTitle("Crear rutina");
		setResizable(false);
		setBounds(100, 100, 850, 394);
		setLocationRelativeTo(null);/// CENTRA LA VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Título de la rutina:");
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setFont(new Font("Roboto", Font.BOLD, 14));
	    labelTitulo.setBounds(240, 113, 150, 25);
	    panel.add(labelTitulo);

	    JLabel labelActividad = new JLabel("Actividad deportiva:");
	    labelActividad.setForeground(new Color(255, 255, 255));
	    labelActividad.setFont(new Font("Roboto", Font.BOLD, 14));
	    labelActividad.setBounds(240, 167, 150, 25);
	    panel.add(labelActividad);
	    JTextField textTitulo = new JTextField();
	    textTitulo.setBounds(400, 114, 200, 25);
	    textTitulo.setText(rutinaNueva.getTitulo());
	    panel.add(textTitulo);

	    JTextField textActividad = new JTextField();
	    textActividad.setBounds(400, 168, 200, 25);
	    textActividad.setText(rutinaNueva.getActividad_deportiva());
	    panel.add(textActividad);
	    
	    JLabel labelDificultad = new JLabel("Dificultad:");
	    labelDificultad.setForeground(new Color(255, 255, 255));
	    labelDificultad.setFont(new Font("Roboto", Font.BOLD, 14));
	    labelDificultad.setBounds(240, 218, 150, 25);  // Ajustado para mejor visibilidad
	    panel.add(labelDificultad);
	    JTextField textDificultad = new JTextField();
	    textDificultad.setBounds(400, 219, 200, 25);  // Ajustado para mejor visibilidad
	    textDificultad.setText(rutinaNueva.getDificultad());
	    panel.add(textDificultad);
	    
	    
	    Border border = new LineBorder(new Color(255, 128, 64), 1, true);
		JButton btnBuscarRutina = new JButton("Crear rutina");
		btnBuscarRutina.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnBuscarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textTitulo.getText().isEmpty() || textActividad.getText().isEmpty() || textDificultad.getText().isEmpty()) {
	             
	                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	            
	            	
	            	rutinaNueva.setTitulo(textTitulo.getText());
	            	rutinaNueva.setDificultad(textDificultad.getText());
	            	rutinaNueva.setActividad_deportiva(textActividad.getText());
	            	
	            
	         
	            	
	            	
	            	
	     
	            	
	            	agregar_ejercicio frame = new agregar_ejercicio(id_usuario,rutinaNueva);
					frame.setVisible(true);
					dispose();
	            }
				
				
			}
		});
		btnBuscarRutina.setForeground(new Color(255, 128, 64));
		btnBuscarRutina.setBackground(new Color(226, 226, 226));
		btnBuscarRutina.setBounds(240, 274, 360, 31);
		btnBuscarRutina.setBorder(border);
		panel.add(btnBuscarRutina);
		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menu_usuario frame = new menu_usuario(id_usuario);
				frame.setVisible(true);
				dispose();
					
				
				

			}
		});
		
		
		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(763, 32, 40, 30);
		
		panel.add(btnAtras);
		
	}

}
