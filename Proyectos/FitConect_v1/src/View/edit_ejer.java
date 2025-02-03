package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import Controller.EjerciciosControlador;
import Controller.RutinasControlador;
import Model.Ejercicio;
import Model.Rutina;

public class edit_ejer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField  txtnombre,txtserie,txtRepe,txtDesca;
	
	

	public edit_ejer(Rutina rutina, int id_usuario ,Ejercicio ejercicio,String volver) {
		setTitle("Editar ejercicio");
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
		
		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mod_ejercicio frame = new mod_ejercicio(rutina,id_usuario,volver);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(773, 31, 40, 30);
		panel.add(btnAtras);
		
		JLabel lbltitulo = new JLabel("Nombre");
		lbltitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltitulo.setBounds(80, 105, 105, 41);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lbltitulo);
		txtnombre = new JTextField(ejercicio.getNombre());
		txtnombre.setBounds(222, 105, 382, 30);
		panel.add(txtnombre);
		
		
		
		
		JLabel lblSerie = new JLabel("Serie");
		lblSerie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerie.setBounds(80, 148, 105, 41);
		lblSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblSerie);
		txtserie = new JTextField(String.valueOf(ejercicio.getSerie()));
		txtserie.setBounds(222, 145, 382, 30);
		panel.add(txtserie);
		
		System.out.println(ejercicio.getSerie());
		
		JLabel lblRepeticiones = new JLabel("Repeticiones");
		lblRepeticiones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeticiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepeticiones.setBounds(80, 186, 105, 41);
		panel.add(lblRepeticiones);
		txtRepe = new JTextField(String.valueOf(ejercicio.getRepeteticiones()));
		txtRepe.setBounds(222, 186, 382, 30);
		panel.add(txtRepe);
		panel.add(lblRepeticiones);
		
	
		
		JLabel lblDescanso = new JLabel("Descanso");
		lblDescanso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescanso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescanso.setBounds(80, 227, 105, 41);
		panel.add(lblDescanso);
		txtDesca = new JTextField(String.valueOf(ejercicio.getDescanso()));
		txtDesca.setBounds(222, 227, 382, 30);
		panel.add(txtDesca);
		Border bordeRojo = BorderFactory.createLineBorder(Color.RED, 2);
		JButton btnGuardar = new JButton("GUARDAR CAMBIOS");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnombre.setBorder(BorderFactory.createEmptyBorder());
				txtserie.setBorder(BorderFactory.createEmptyBorder());
				txtRepe.setBorder(BorderFactory.createEmptyBorder());
				txtDesca.setBorder(BorderFactory.createEmptyBorder());
				boolean esValido = true;
				
				if (txtnombre.getText().trim().isEmpty()) {

					txtnombre.setBorder(bordeRojo);
					esValido = false;
				}
				
				if (!Datos_personalesControlador.validacionDeEdad(txtserie.getText())) {
					txtserie.setBorder(bordeRojo);
					esValido = false;
				}
				
				if (!Datos_personalesControlador.validacionDeEdad(txtRepe.getText())) {
					txtRepe.setBorder(bordeRojo);
					esValido = false;
				}
				if (!Datos_personalesControlador.validacionDeEdad(txtDesca.getText())) {
					txtDesca.setBorder(bordeRojo);
					esValido = false;
				}
				
				if (esValido) {
					
					
					ejercicio.setNombre(txtnombre.getText().trim());
					ejercicio.setRepeteticiones(Integer.parseInt(txtRepe.getText().trim()));
					ejercicio.setDescanso(Integer.parseInt(txtDesca.getText().trim()));
					ejercicio.setSerie(Integer.parseInt(txtserie.getText().trim()));
					
					EjerciciosControlador.actualizandoElEjercicioSeleccionado(ejercicio);
					JOptionPane.showMessageDialog(null,
						"EJERCICIO HA SIDO ACTUALIZADO", "INFORMACION",
							JOptionPane.INFORMATION_MESSAGE);
					
					mod_ejercicio frame = new mod_ejercicio(rutina,id_usuario,volver);
					frame.setVisible(true);
					dispose();


				} else {
					JOptionPane.showMessageDialog(null,
							"ERROR, POR FAVOR COMPLETAR CORRECTAMENTE LOS CAMPOS MARCADOS ..", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Serif", Font.PLAIN, 15));
		btnGuardar.setBackground(new Color(255, 128, 64));
		btnGuardar.setBounds(316, 297, 201, 29);
		panel.add(btnGuardar);
	}

}
