package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Datos_personalesControlador;
import Controller.usuarioControlador;
import Model.Datos_personales;
import Model.Usuario;

import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class register_create_account extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtCuenta;
	private JTextField textPass;
	private JTextField textRePass;
	private JPasswordField passwordField;

	public register_create_account(Datos_personales datos) {

		setTitle("Creando cuenta");
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

		JLabel lblNombre = new JLabel("Cuenta");
		lblNombre.setFont(new Font("Serif", Font.BOLD, 14));
		lblNombre.setForeground(new Color(255, 128, 64));
		lblNombre.setBounds(28, 121, 115, 14);
		panel1.add(lblNombre);

		txtCuenta = new JTextField();
		txtCuenta.setBackground(new Color(240, 240, 240));
		txtCuenta.setBounds(153, 115, 105, 20);
		txtCuenta.setColumns(10);
		txtCuenta.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));

		panel1.add(txtCuenta);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(255, 128, 64));
		lblContrasea.setFont(new Font("Serif", Font.BOLD, 14));
		lblContrasea.setBounds(28, 158, 115, 14);
		panel1.add(lblContrasea);

		textPass = new JPasswordField();
		textPass.setColumns(10);
		textPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));
		textPass.setBackground(UIManager.getColor("Button.background"));
		textPass.setBounds(153, 152, 105, 20);
		panel1.add(textPass);
		
		
		
		

		JLabel lblNombre_1_1 = new JLabel("Repita-contraseña");
		lblNombre_1_1.setForeground(new Color(255, 128, 64));
		lblNombre_1_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNombre_1_1.setBounds(28, 193, 115, 14);
		panel1.add(lblNombre_1_1);

		textRePass = new JPasswordField();
		textRePass.setColumns(10);
		textRePass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64)));
		textRePass.setBackground(UIManager.getColor("Button.background"));
		textRePass.setBounds(153, 187, 105, 20);
		panel1.add(textRePass);

		JLabel lblCompletarDatos = new JLabel("Crear cuenta");
		lblCompletarDatos.setForeground(new Color(128, 128, 255));
		lblCompletarDatos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblCompletarDatos.setBounds(28, 77, 188, 27);
		panel1.add(lblCompletarDatos);
		
		JLabel lblErrorPass = new JLabel("");
		lblErrorPass.setForeground(Color.RED);
		lblErrorPass.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorPass.setBounds(268, 160, 252, 14);
		panel1.add(lblErrorPass);
		
		
		JLabel lblErrorCuenta = new JLabel("");
		lblErrorCuenta.setForeground(new Color(255, 0, 0));
		lblErrorCuenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorCuenta.setBounds(268, 121, 252, 14);
		panel1.add(lblErrorCuenta);
		JButton btnCrearCuenta = new JButton("Confirmando cuenta");
		Border border = new LineBorder(new Color(255, 128, 64), 1, true);
		btnCrearCuenta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lblErrorCuenta.setText("");
				if(!usuarioControlador.usuarioExistenteEnlaBd(txtCuenta.getText())) {
				
					
					if(textPass.getText().equals(textRePass.getText())) {
					
						usuarioControlador.creandoCuentaNuevaUsuario(datos,txtCuenta.getText() , textPass.getText());
						Menu su;
						
						
						login frame = new login();
						frame.setVisible(true);
						dispose();
						
					}else {
						
						lblErrorPass.setText("revisa.. por que los password no coinciden");
					}
					
					
				}else {
					
					lblErrorCuenta.setText("Cuenta ya existente en el sistema..");
					
				}
				
				
				
				
				
				
				

			}
		});
		btnCrearCuenta.setBackground(new Color(240, 240, 240));
		btnCrearCuenta.setBounds(81, 236, 147, 33);
		btnCrearCuenta.setBorder(border);
		panel1.add(btnCrearCuenta);
		
		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
					
					

					int respuesta = JOptionPane.showConfirmDialog(null, "Volver atras, perderia la informacion",
							"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {
						register frame = new register();
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
