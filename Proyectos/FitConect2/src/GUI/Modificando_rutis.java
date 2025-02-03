package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.Ejercicio;
import BLL.EntradaYsalida;
import BLL.Rutina;
import BLL.Usuario;

public class Modificando_rutis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId, txtTitulo, txtActividad, txtDificultad;
	private Rutina rutina;
	private JButton btnVolver;

	public Modificando_rutis(int id_rutina, Usuario usser) {
		setTitle("Modificando rutinas");

		rutina = EntradaYsalida.obteniendoRutinaSinComp(id_rutina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(5, 7, 387, 41);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblId);
		txtId = new JTextField(String.valueOf(rutina.getId_rutina()));
		txtId.setBounds(392, 7, 387, 41);
		txtId.setEditable(false);
		contentPane.add(txtId);

		JLabel lbltitulo = new JLabel("titulo");
		lbltitulo.setBounds(5, 48, 387, 41);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltitulo);
		txtTitulo = new JTextField(rutina.getTituloRutina());
		txtTitulo.setBounds(392, 48, 387, 41);
		contentPane.add(txtTitulo);

		JLabel lblActividad = new JLabel("Actividad deportiva");
		lblActividad.setBounds(5, 89, 387, 41);
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblActividad);
		txtActividad = new JTextField(rutina.getActividad_deportiva());
		txtActividad.setBounds(392, 89, 387, 41);
		contentPane.add(txtActividad);

		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setBounds(5, 130, 387, 41);
		lblDificultad.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDificultad);
		txtDificultad = new JTextField(String.valueOf(rutina.getDificultad()));
		txtDificultad.setBounds(392, 130, 387, 41);
		contentPane.add(txtDificultad);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(392, 198, 387, 41);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_rutinas_cuenta frame = new Ver_rutinas_cuenta(usser);
				frame.setVisible(true);
				dispose();

			}
		});

		contentPane.add(btnVolver);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(5, 198, 387, 41);
		contentPane.add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String titulo = txtTitulo.getText();
					String difultad = txtDificultad.getText();
					String actividad = txtActividad.getText();

					if (titulo != null && !titulo.trim().isEmpty()) {

						rutina.setTituloRutina(titulo);
						rutina.setActividad_deportiva(actividad);
						rutina.setDificultad(difultad);

						EntradaYsalida.ActualizarRutina(rutina.getId_rutina(), rutina.getDificultad(),
								rutina.getActividad_deportiva(), rutina.getTituloRutina());

						JOptionPane.showMessageDialog(null, "Rutina actualizado correctamente.");
						Ver_rutinas_cuenta frame = new Ver_rutinas_cuenta(usser);
						frame.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
					}
				} catch (NumberFormatException ex) {

					JOptionPane.showMessageDialog(null,
							"Por favor, ingresa un número válido en los campos correspondientes.");
				}
			}
		});
	}

}
