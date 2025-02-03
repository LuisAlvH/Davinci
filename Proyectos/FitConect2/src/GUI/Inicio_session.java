package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;
import DLL.ControllerCliente;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Inicio_session extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField input_pass;

	public Inicio_session() {
		setTitle("Inicio sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel icon = new JLabel("icono");
		icon.setBounds(239, 18, 25, 14);
		contentPane.add(icon);

		JLabel tittle = new JLabel("FitConnect");
		tittle.setFont(new Font("Candara", Font.BOLD, 16));
		tittle.setBounds(158, 17, 75, 20);
		contentPane.add(tittle);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(124, 64, 60, 14);
		contentPane.add(lblNewLabel);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(122, 89, 75, 41);
		contentPane.add(lblContrasea);

		input_pass = new JPasswordField();
		input_pass.setBounds(207, 102, 75, 14);
		contentPane.add(input_pass);

		JLabel lblMensajeError = new JLabel("");
		lblMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMensajeError.setForeground(Color.RED);
		lblMensajeError.setBounds(36, 106, 346, 53);
		contentPane.add(lblMensajeError);
		JTextArea input_usuario = new JTextArea();
		input_usuario.setBounds(207, 64, 75, 14);
		contentPane.add(input_usuario);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(158, 147, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = input_usuario.getText();
				String pass = new String(input_pass.getPassword());
				Usuario usuarioEncontrad;
				usuarioEncontrad = ControllerCliente.encontrandoUsuarioExistente(usuario, pass);

				if (usuarioEncontrad == null) {

					lblMensajeError.setText("Usuario inexistente..");
				} else {
					Menu_cliente frame = new Menu_cliente(usuarioEncontrad);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(btnNewButton);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(320, 216, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index frame = new index();
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAtras);
	}
}
