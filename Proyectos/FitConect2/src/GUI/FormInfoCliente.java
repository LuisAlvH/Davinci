package GUI;

import java.awt.BorderLayout;
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

import BLL.Cliente;
import BLL.EntradaYsalida;
import BLL.Usuario;
import DLL.ControllerDatosPersonales;

public class FormInfoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FormInfoCliente(Usuario usser) {
		setTitle("Actualizar información");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblTittle = new JLabel("Actualizar información");
		lblTittle.setBounds(105, 11, 200, 20);
		lblTittle.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(lblTittle);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 50, 80, 20);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblNombre);
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(120, 50, 180, 20);
		getContentPane().add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 81, 80, 20);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblApellido);
		JTextField txtApellido = new JTextField();
		txtApellido.setBounds(120, 80, 180, 20);
		getContentPane().add(txtApellido);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(20, 112, 80, 20);
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblTelefono);
		JTextField txtTelefono = new JTextField();
		txtTelefono.setBounds(120, 110, 180, 20);
		getContentPane().add(txtTelefono);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 141, 80, 20);
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblEdad);
		JTextField txtEdad = new JTextField();
		txtEdad.setBounds(120, 140, 180, 20);
		getContentPane().add(txtEdad);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 171, 80, 20);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblEmail);
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(120, 170, 180, 20);
		getContentPane().add(txtEmail);

		JLabel lblObjetivo = new JLabel("Tipo de objetivo:");
		lblObjetivo.setBounds(20, 200, 100, 20);
		lblObjetivo.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblObjetivo);
		JTextField txtObjetivo = new JTextField();
		txtObjetivo.setBounds(120, 200, 180, 20);
		getContentPane().add(txtObjetivo);

		JLabel lblEspacio = new JLabel("Espacio físico:");
		lblEspacio.setBounds(20, 230, 100, 20);
		lblEspacio.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblEspacio);
		JTextField txtEspacio = new JTextField();
		txtEspacio.setBounds(120, 230, 180, 20);
		getContentPane().add(txtEspacio);

		JLabel lblBarrio = new JLabel("Barrio:");
		lblBarrio.setBounds(20, 260, 80, 20);
		lblBarrio.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblBarrio);
		JTextField txtBarrio = new JTextField();
		txtBarrio.setBounds(120, 260, 180, 20);
		getContentPane().add(txtBarrio);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(20, 290, 80, 20);
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 10));
		getContentPane().add(lblDireccion);
		JTextField txtDireccion = new JTextField();
		txtDireccion.setBounds(120, 290, 180, 20);
		getContentPane().add(txtDireccion);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(152, 330, 90, 20);
		getContentPane().add(btnEnviar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(294, 12, 80, 20);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cuenta_cliente frame = new Cuenta_cliente(usser);
				frame.setVisible(true);
				dispose();

			}

		});

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EntradaYsalida.modificandoInformacion(usser.getIdUsuario(), txtNombre.getText(),
							txtApellido.getText(), Integer.parseInt(txtEdad.getText()), txtTelefono.getText(),
							txtEmail.getText(), txtObjetivo.getText(), txtEspacio.getText(), txtBarrio.getText(),
							txtDireccion.getText());

					JOptionPane.showMessageDialog(null, "La información se ha actualizado correctamente.",
							"Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);

					Cuenta_cliente frame = new Cuenta_cliente(usser);
					frame.setVisible(true);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, completa el formulario correctamente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}