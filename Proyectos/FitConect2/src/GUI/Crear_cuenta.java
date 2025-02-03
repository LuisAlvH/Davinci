package GUI;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.EntradaYsalida;
import DLL.ControllerCliente;

public class Crear_cuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Crear_cuenta(int id_datos_personales) {
		setTitle("Crear cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		setResizable(false);
		setLocationRelativeTo(null);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);

		JLabel lblCrearCuenta = new JLabel("Crear cuenta");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1.0;
		gbc.weighty = 0.1;
		contentPane.add(lblCrearCuenta, gbc);

		JLabel lblUsuario = new JLabel("Usuario:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		contentPane.add(lblUsuario, gbc);

		JTextField txtUsuario = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(txtUsuario, gbc);

		JLabel lblContrasena = new JLabel("Contraseña:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(lblContrasena, gbc);

		JPasswordField txtContrasena = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(txtContrasena, gbc);

		JButton btnCrearCuenta = new JButton("Crear cuenta");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		contentPane.add(btnCrearCuenta, gbc);

		btnCrearCuenta.addActionListener(e -> {
			String usuario = txtUsuario.getText();
			char[] contrasena = txtContrasena.getPassword();
			String contrasenaString = new String(contrasena);

			if (usuario.isEmpty() || contrasena.length == 0) {
				JOptionPane.showMessageDialog(null, "Error, completa todos los campos.");
				return;
			}

			if (EntradaYsalida.VerificandoExistenciaDelUsuario(usuario, contrasenaString)) {
				JOptionPane.showMessageDialog(null, "Usuario existente.");
				return;
			}

			EntradaYsalida.creandoCuentaDelUsuarioNuevo(usuario, new String(contrasena), id_datos_personales);

			JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.");
			index frame = new index();
			frame.setVisible(true);

			dispose();
		});

		setVisible(true);

	}

}
