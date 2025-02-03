package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Datos_personalesControlador;
import Model.Datos_personales;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textEdad;

	public register() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 654, 394);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel1 = new JPanel();
		panel1.setBounds(42, 29, 555, 302);
		panel1.setBackground(new Color(240, 240, 240));
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Serif", Font.BOLD, 14));
		lblNombre.setForeground(new Color(255, 128, 64));
		lblNombre.setBounds(49, 103, 115, 14);
		panel1.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 240, 240));
		txtNombre.setBounds(123, 97, 105, 20);
		txtNombre.setColumns(10);
		txtNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));

		panel1.add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(255, 128, 64));
		lblApellido.setFont(new Font("Serif", Font.BOLD, 14));
		lblApellido.setBounds(49, 128, 115, 14);
		panel1.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));
		textApellido.setBackground(UIManager.getColor("Button.background"));
		textApellido.setBounds(123, 122, 105, 20);
		panel1.add(textApellido);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(255, 128, 64));
		lblEdad.setFont(new Font("Serif", Font.BOLD, 14));
		lblEdad.setBounds(49, 206, 115, 14);
		panel1.add(lblEdad);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 128, 64));
		lblTelefono.setFont(new Font("Serif", Font.BOLD, 14));
		lblTelefono.setBounds(49, 153, 115, 14);
		panel1.add(lblTelefono);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(255, 128, 64));
		lblEmail.setFont(new Font("Serif", Font.BOLD, 14));
		lblEmail.setBounds(49, 178, 115, 14);
		panel1.add(lblEmail);

		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));
		textTelefono.setBackground(UIManager.getColor("Button.background"));
		textTelefono.setBounds(123, 147, 105, 20);
		panel1.add(textTelefono);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));
		textEmail.setBackground(UIManager.getColor("Button.background"));
		textEmail.setBounds(123, 175, 105, 20);
		panel1.add(textEmail);

		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));
		textEdad.setBackground(UIManager.getColor("Button.background"));
		textEdad.setBounds(123, 200, 105, 20);
		panel1.add(textEdad);

		JLabel lblCompletarDatos = new JLabel("Completar datos");
		lblCompletarDatos.setForeground(new Color(255, 128, 64));
		lblCompletarDatos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblCompletarDatos.setBounds(74, 59, 188, 27);
		panel1.add(lblCompletarDatos);

		ImageIcon iconoInicioSesion = new ImageIcon(login.class.getResource("/img/registro.png"));
		Image scaledImageIcon = iconoInicioSesion.getImage().getScaledInstance(21, 20, Image.SCALE_SMOOTH);
		panel1.setLayout(null);
		JLabel imangeRegister = new JLabel("");
		imangeRegister.setBounds(48, 59, 28, 33);
		imangeRegister.setIcon(new ImageIcon(scaledImageIcon));
		panel1.add(imangeRegister);
		
		
		JLabel lblErrorEmail = new JLabel("");
		lblErrorEmail.setForeground(new Color(255, 0, 0));
		lblErrorEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorEmail.setBounds(262, 180, 204, 14);
		panel1.add(lblErrorEmail);
		
		JLabel lblErrorEdad = new JLabel("");
		lblErrorEdad.setForeground(new Color(255, 0, 0));
		lblErrorEdad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorEdad.setBounds(262, 208, 252, 14);
		panel1.add(lblErrorEdad);

		JButton btnCrearCuenta = new JButton("Crear cuenta");
		Border border = new LineBorder(new Color(255, 128, 64), 1, true);
		btnCrearCuenta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblErrorEdad.setText("");
				lblErrorEmail.setText("");
				
				
				if(!Datos_personalesControlador.validacionDeEdad(textEdad.getText()) ) {
					
					
					lblErrorEdad.setText("Error , ingresas un valor que no es numerico...");
				}
				
				if(!Datos_personalesControlador.validacionDeEmail(textEmail.getText()) ) {
					
					
					lblErrorEmail.setText("Error , no ingresaste un email valido...");
				}
				
				
				
				
				if (!txtNombre.getText().trim().isEmpty() && !textApellido.getText().trim().isEmpty()
						&& !textTelefono.getText().trim().isEmpty() && Datos_personalesControlador.validacionDeEdad(textEdad.getText())
						&& Datos_personalesControlador.validacionDeEmail(textEmail.getText())) {
					Datos_personales datos=new Datos_personales();
					
					datos.setNombre(txtNombre.getText());
					datos.setApellido(textApellido.getText());
					datos.setTelefono(textTelefono.getText());
					datos.setEdad(Integer.parseInt(textEdad.getText()));
					datos.setEmail(textEmail.getText());
					
					register_create_account frame = new register_create_account(datos);
					frame.setVisible(true);
					dispose();
					
					
				}else {
					
					 JOptionPane.showMessageDialog(
					            null, 
					            "Porfavor , ingresa datos faltantes...", 
					            "Error de datos", 
					            JOptionPane.ERROR_MESSAGE
					        );
					
				}
				

			}
		});
		btnCrearCuenta.setBackground(new Color(240, 240, 240));
		btnCrearCuenta.setBounds(202, 244, 147, 33);
		btnCrearCuenta.setBorder(border);
		panel1.add(btnCrearCuenta);

		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtNombre.getText().trim().isEmpty() || !textApellido.getText().trim().isEmpty()
						|| !textEmail.getText().trim().isEmpty() || !textEdad.getText().trim().isEmpty()
						|| !textEmail.getText().trim().isEmpty()) {
					
					

					int respuesta = JOptionPane.showConfirmDialog(null, "Volver atras, perderia la informacion",
							"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {
						login frame = new login();
						frame.setVisible(true);
						dispose();
					}

				} else {
					login frame = new login();
					frame.setVisible(true);
					dispose();
				}

			}
		});

		btnAtras.setBackground(new Color(240, 240, 240));
		btnAtras.setBorder(null);
		btnAtras.setBounds(491, 23, 40, 30);
		btnAtras.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(138, 43, 226));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(240, 240, 240));
			}

		});

		panel1.add(btnAtras);
		
		

	}
}
