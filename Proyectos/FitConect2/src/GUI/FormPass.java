package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.EntradaYsalida;
import BLL.Usuario;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;

public class FormPass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField input_pass;
	private JPasswordField input_pass2;
	private JPasswordField input_pass3;

	public FormPass(Usuario usser) {
		setTitle("Cambiar contraseña");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 280);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblTittle = new JLabel("Cambiar contraseña");
		lblTittle.setBounds(105, 11, 200, 20);
		lblTittle.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(lblTittle);

		JLabel lblPassActual = new JLabel("Contraseña actual :");
		lblPassActual.setBounds(55, 50, 112, 20);
		lblPassActual.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblPassActual);

		input_pass = new JPasswordField();
		input_pass.setBounds(177, 53, 100, 14);
		getContentPane().add(input_pass);

		JLabel lblContraseaNueva = new JLabel("Contraseña nueva :");
		lblContraseaNueva.setFont(new Font("Arial", Font.PLAIN, 10));
		lblContraseaNueva.setBounds(55, 81, 100, 20);
		getContentPane().add(lblContraseaNueva);

		input_pass2 = new JPasswordField();
		input_pass2.setBounds(177, 84, 100, 14);
		getContentPane().add(input_pass2);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(293, 12, 81, 20);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cuenta_cliente frame = new Cuenta_cliente(usser);
				frame.setVisible(true);
				dispose();

			}

		});

		JLabel lblRepitaContrasena = new JLabel("Repita contraseña :");
		lblRepitaContrasena.setFont(new Font("Arial", Font.PLAIN, 10));
		lblRepitaContrasena.setBounds(55, 112, 100, 20);
		getContentPane().add(lblRepitaContrasena);
		input_pass3 = new JPasswordField();
		input_pass3.setBounds(177, 115, 100, 14);
		getContentPane().add(input_pass3);

		JLabel mensajeLabel = new JLabel("", JLabel.CENTER);
		mensajeLabel.setForeground(new Color(255, 0, 0));
		mensajeLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		mensajeLabel.setBounds(65, 138, 235, 20);

		getContentPane().add(mensajeLabel);

		JButton btnGuardar = new JButton("Guarda cambio");
		btnGuardar.setBounds(124, 158, 125, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(input_pass.getPassword());
				String pass2 = new String(input_pass2.getPassword());
				String pass3 = new String(input_pass3.getPassword());

				if (EntradaYsalida.cambiarPassword(pass, usser.getIdUsuario()) && pass2.equals(pass3)) {

					EntradaYsalida.actualizarPassword(usser.getIdUsuario(), pass2);
					JOptionPane.showMessageDialog(null, "La contraseña ha sido actualizada correctamente.",
							"Cambio Exitoso", JOptionPane.INFORMATION_MESSAGE);

					Cuenta_cliente frame = new Cuenta_cliente(usser);
					frame.setVisible(true);
					dispose();
				} else {

					if (!EntradaYsalida.cambiarPassword(pass2, usser.getIdUsuario())) {
						mensajeLabel.setText("La contraseña actual es incorrecta.");
					}
					if (!pass2.equals(pass3)) {
						mensajeLabel.setText("No coincide la contraseña nueva...");
					}

				}

			}

		});
	}
}
