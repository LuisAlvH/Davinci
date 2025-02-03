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
import BLL.Usuario;

public class Modificando_ejercicioC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId, txtNombre, txtRepeticiones, txtSerie, txtDescanso;
	private Ejercicio ejercicio;
	private JButton btnVolver;

	public Modificando_ejercicioC(Ejercicio ejer, int id_rutina, Usuario usser) {
		ejercicio = ejer;
		setTitle("Modificando Ejercicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2));

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblId);
		txtId = new JTextField(String.valueOf(ejer.getId_ejercicio()));
		txtId.setEditable(false);
		contentPane.add(txtId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNombre);
		txtNombre = new JTextField(ejer.getNombre());
		contentPane.add(txtNombre);

		JLabel lblRepeticiones = new JLabel("Repeticiones");
		lblRepeticiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblRepeticiones);
		txtRepeticiones = new JTextField(String.valueOf(ejer.getRepeticiones()));
		contentPane.add(txtRepeticiones);

		JLabel lblSerie = new JLabel("Serie");
		lblSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSerie);
		txtSerie = new JTextField(String.valueOf(ejer.getSerie()));
		contentPane.add(txtSerie);

		JLabel lblDescanso = new JLabel("Descanso");
		lblDescanso.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDescanso);
		txtDescanso = new JTextField(String.valueOf(ejer.getDescansoEntreSerie()));
		contentPane.add(txtDescanso);

		JButton btnGuardar = new JButton("Guardar");
		contentPane.add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mod_ejerC frame = new Mod_ejerC(id_rutina, usser);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVolver);

		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String nombre = txtNombre.getText();
					int repeticiones = Integer.parseInt(txtRepeticiones.getText());
					int serie = Integer.parseInt(txtSerie.getText());
					int descanso = Integer.parseInt(txtDescanso.getText());

					if (nombre != null && !nombre.trim().isEmpty()) {

						ejercicio.setNombre(nombre);
						ejercicio.setRepeticiones(repeticiones);
						ejercicio.setSerie(serie);
						ejercicio.setDescansoEntreSerie(descanso);

						EntradaYsalida.ActualziarEjercicio(ejercicio);
						JOptionPane.showMessageDialog(null, "Ejercicio actualizado correctamente.");
						Mod_ejerC frame = new Mod_ejerC(id_rutina, usser);
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

		contentPane.revalidate();
		contentPane.repaint();
	}

}
