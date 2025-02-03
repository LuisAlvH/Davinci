package GUI;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.AttributeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;

import BLL.EntradaYsalida;

public class Datos_personales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Datos_personales() {

		setTitle("Datos Personales");

		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);
		setResizable(false);
		setLocationRelativeTo(null);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel lblNombre = new JLabel("Nombre:");
		add(lblNombre, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		JTextField txtNombre = new JTextField(15);
		add(txtNombre, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblApellido = new JLabel("Apellido:");
		add(lblApellido, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		JTextField txtApellido = new JTextField(15);
		add(txtApellido, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblEdad = new JLabel("Edad:");
		add(lblEdad, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		JTextField txtEdad = new JTextField(15);
		add(txtEdad, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel lblEmail = new JLabel("Email:");
		add(lblEmail, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		JTextField txtEmail = new JTextField(15);
		add(txtEmail, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		JLabel lblTelefono = new JLabel("Teléfono:");
		add(lblTelefono, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		JTextField txtTelefono = new JTextField(15);
		add(txtTelefono, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		JButton btnVolver = new JButton("Volver");
		add(btnVolver, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		add(btnCrearCuenta, gbc);

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				index frame = new index();
				frame.setVisible(true);
				
				dispose();
			}
		});

		btnCrearCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String email = txtEmail.getText();
				String telefono = txtTelefono.getText();
				String edadStr = txtEdad.getText();

				if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty()
						|| edadStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los datos.");
				} else {
					try {
						int edad = Integer.parseInt(edadStr);

						Crear_cuenta frame = new Crear_cuenta(EntradaYsalida.registrandoDatosPersonalesUsuario(nombre,
								apellido, edad, telefono, email));
						frame.setVisible(true);
						dispose();

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.");
					}
				}
			}
		});

		setVisible(true);
	}
}
