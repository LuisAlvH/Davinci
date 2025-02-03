package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controller.Datos_personalesControlador;
import Controller.MenuControlador;
import Controller.RutinasControlador;
import Model.Rutina;

public class modif_rutina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField  txtTitulo, txtActividad, txtDificultad;

	
	
	public modif_rutina(int id_usuario,Rutina rutina) {
		setTitle("Modificar rutina");
		setResizable(false);
		setBounds(100, 100, 850, 394);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFICAR RUTINA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 31, 162, 37);
		panel.add(lblNewLabel);
		
		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mis_rutinas frame = new mis_rutinas(id_usuario);
				frame.setVisible(true);
				dispose();
				
				
			}
		});
		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(773, 31, 40, 30);
		panel.add(btnAtras);
		
		
		
		
		
		JLabel lbltitulo = new JLabel("Titulo");
		lbltitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltitulo.setBounds(72, 98, 105, 41);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lbltitulo);
		txtTitulo = new JTextField(rutina.getTitulo());
		txtTitulo.setBounds(218, 93, 382, 30);
		panel.add(txtTitulo);
		
		JLabel lblActividadDeportiva = new JLabel("Actividad Deportiva");
		lblActividadDeportiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblActividadDeportiva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActividadDeportiva.setBounds(23, 137, 154, 41);
		panel.add(lblActividadDeportiva);
		
		txtActividad = new JTextField(rutina.getActividad_deportiva());
		txtActividad.setBounds(218, 134, 382, 30);
		panel.add(txtActividad);
		
		
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDificultad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDificultad.setBounds(23, 178, 154, 41);
		panel.add(lblDificultad);
		txtDificultad = new JTextField(rutina.getDificultad());
		txtDificultad.setBounds(218, 177, 382, 30);
		panel.add(txtDificultad);
		
		Border bordeRojo = BorderFactory.createLineBorder(Color.RED, 2);
		
		
		
		JButton btnEliminar = new JButton("GUARDAR CAMBIOS");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtTitulo.setBorder(BorderFactory.createEmptyBorder());
				txtActividad.setBorder(BorderFactory.createEmptyBorder());
				txtDificultad.setBorder(BorderFactory.createEmptyBorder());
				boolean esValido = true;
				
				// Verificar si los campos están vacíos
				if (txtTitulo.getText().trim().isEmpty()) {

					txtTitulo.setBorder(bordeRojo);
					esValido = false;
				}

				if (txtActividad.getText().trim().isEmpty()) {
					txtActividad.setBorder(bordeRojo);
					esValido = false;
				}

				if (txtDificultad.getText().trim().isEmpty()) {
					txtDificultad.setBorder(bordeRojo);
					esValido = false;
				}
				
				if (esValido) {
					rutina.setTitulo(txtTitulo.getText().trim());
					rutina.setActividad_deportiva(txtActividad.getText().trim());
					rutina.setDificultad(txtDificultad.getText().trim());
					RutinasControlador.actualizarDTA(rutina);
					JOptionPane.showMessageDialog(null,
						"RUTINA HA SIDO ACTUALIZADA", "INFORMACION",
							JOptionPane.INFORMATION_MESSAGE);


				} else {
					JOptionPane.showMessageDialog(null,
							"ERROR, POR FAVOR COMPLETAR CORRECTAMENTE LOS CAMPOS MARCADOS ..", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Serif", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(255, 128, 64));
		btnEliminar.setBounds(316, 260, 201, 29);
		panel.add(btnEliminar);
	}
}
