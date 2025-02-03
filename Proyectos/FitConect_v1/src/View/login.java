package View;

import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import Controller.usuarioControlador;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPass;



	public login() {
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 654, 394);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(57, 22, 291, 306);
		panel.add(panel2);
		


	
		ImageIcon iconoInicioSesion = new ImageIcon(login.class.getResource("/img/5987420.png"));
		 Image scaledImageIcon= iconoInicioSesion.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			panel2.setLayout(null);
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(120, 39, 50, 50);
			lblNewLabel.setIcon(new ImageIcon(scaledImageIcon));
			panel2.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Usuario");
			lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 14));
			lblNewLabel_1.setForeground(new Color(255, 128, 64));
			lblNewLabel_1.setBounds(35, 107, 115, 14);
			panel2.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Contraseña");
			lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 14));
			lblNewLabel_2.setForeground(new Color(255, 128, 64));
			lblNewLabel_2.setBounds(35, 167, 115, 14);
			panel2.add(lblNewLabel_2);
			
			
			txtUsuario = new JTextField();
			txtUsuario.setBackground(new Color(240, 240, 240));
			txtUsuario.setBounds(35, 124, 173, 20);
			txtUsuario.setColumns(10);
			txtUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64))); // Borde inferior de color naranja

			panel2.add(txtUsuario);

			
			txtPass = new JPasswordField();
			txtPass.setToolTipText("");
			txtPass.setBackground(new Color(240, 240, 240));
			txtPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 64))); // Borde inferior de color naranja
			txtPass.setBounds(35, 180, 173, 20);

			
			panel2.add(txtPass);
			
			JLabel mensajeError3 = new JLabel("");
			mensajeError3.setFont(new Font("Serif", Font.BOLD, 11));
			mensajeError3.setForeground(Color.RED); 
			mensajeError3.setBounds(35, 256, 228, 39);
			panel2.add(mensajeError3);
			
		

			JSeparator separator_1 = new JSeparator();
			separator_1.setBackground(new Color(255, 128, 64));
			separator_1.setForeground(new Color(255, 128, 64));
			separator_1.setBounds(35, 198, 135, 3);

	
			
			JButton btnNewButton = new JButton("Sing in");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
				        mensajeError3.setText(""); 
					
					String usuario = txtUsuario.getText();
					String pass = new String(txtPass.getPassword());
					txtUsuario.setText("");     
			        txtPass.setText(""); 
			        int idUsuario=usuarioControlador.LoginIngreso(pass, usuario);
					
					if(idUsuario>0) {
						
						
						menu_usuario frame = new menu_usuario(idUsuario);
						frame.setVisible(true);
						dispose();
						
					
					}else if (idUsuario==0) {
						mensajeError3.setText("Error, en la contraseña..Vuelva a intentarlo");
						
					}else if(idUsuario==-1) {
						mensajeError3.setText("Error, usuario y contraseña erroneos");
						
					}
					
					
				}
			});
			btnNewButton.setBackground(new Color(240, 240, 240));
			btnNewButton.setBounds(37, 224, 89, 23);
			Border border = new LineBorder(new Color(255, 128, 64), 1, true); 
			btnNewButton.setBorder(border);
			panel2.add(btnNewButton);
			
			JButton btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					register frame = new register();
					frame.setVisible(true);
					dispose();
					
				}
			});
			btnRegister.setBackground(new Color(240, 240, 240));
			btnRegister.setBounds(153, 224, 89, 23);
			btnRegister.setBorder(border);
			panel2.add(btnRegister);
			
			
			
			
			
			ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
			Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
			JButton btnAtras = new JButton("");
			btnAtras.setIcon(new ImageIcon(scaledAtras));
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
						
					index frame = new index();
					frame.setVisible(true);
					dispose();
					

				}
			});
			
			
			btnAtras.setBackground(new Color(128, 128, 192));
			btnAtras.setBorder(null);
			btnAtras.setBounds(382, 29, 40, 30);
			
			panel.add(btnAtras);
			
			
		 
		 
		ImageIcon imgInicioSesion = new ImageIcon(login.class.getResource("/img/full-shot-woman-doing-sport.jpg"));
	    Image scaledImage = imgInicioSesion.getImage().getScaledInstance(210, 355, Image.SCALE_SMOOTH);///REDIMENSIONAMOS LA IMANGEN AL TAMAÑO DEL LABEL
	    JLabel inicio_label_img = new JLabel("");
	    inicio_label_img.setBounds(428, 0, 210, 355);
	    inicio_label_img.setIcon(new ImageIcon(scaledImage));
		contentPane.add(inicio_label_img);
		
		
	}
}
