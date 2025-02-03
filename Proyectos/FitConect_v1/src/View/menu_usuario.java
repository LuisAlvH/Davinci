package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Datos_personalesControlador;
import Controller.MenuControlador;
import Controller.usuarioControlador;

import Model.Area_entrenamiento;
import Model.Datos_personales;
import Model.Menu;
import Model.Objetivo_cliente;
import Model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class menu_usuario extends JFrame {
	private JPanel contentPane;
	private JPanel panelCards; // Contenedor para los paneles con CardLayout
	private JTextField textApellido;
	private JTextField textEdad;
	private JTextField textTelefono;
	private JTextField txtEmail;
	private JTextField textObjetivo;
	private JTextField textEspacio;
	private JTextField textBarrio;
	private JTextField textDirec;
	private JTextField textNombre;
	private JPasswordField pass;
	private JPasswordField passNew;
	private JPasswordField passNew2;

	public menu_usuario(int id_usuario) {
		setTitle("Menu");
		setResizable(false);
		setBounds(100, 100, 850, 394);
		setLocationRelativeTo(null); // Centra la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Usuario cliente = usuarioControlador.obteniendoCliente(id_usuario);
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 834, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel pane2 = new JPanel();
		pane2.setBackground(new Color(255, 128, 64));
		pane2.setBounds(-2, 0, 826, 37);
		panel.add(pane2);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(225, 225, 225));
		panel3.setBounds(-2, 37, 154, 318);
		panel.add(panel3);
		panel3.setLayout(null);

		JLabel lblUsuario = new JLabel("New label");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Serif", Font.PLAIN, 14));
		lblUsuario.setForeground(new Color(255, 128, 0));
		lblUsuario.setBounds(23, 30, 97, 30);
		panel3.add(lblUsuario);

		// Botón "Rutinas"
		JButton btnMisRutinas = new JButton("Rutinas");
		btnMisRutinas.setFont(new Font("Serif", Font.PLAIN, 15));
		btnMisRutinas.setBounds(10, 85, 132, 23);
		btnMisRutinas.addActionListener(e -> showPanel("RutinasPanel"));
		panel3.add(btnMisRutinas);

		// Botón "Desafíos"
		JButton btnMisDesafios = new JButton("Desafíos");
		btnMisDesafios.setFont(new Font("Serif", Font.PLAIN, 15));
		btnMisDesafios.setBounds(10, 122, 132, 23);
		btnMisDesafios.addActionListener(e -> showPanel("DesafiosPanel"));
		panel3.add(btnMisDesafios);

		// Botón "Mi Cuenta"
		JButton btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.setFont(new Font("Serif", Font.PLAIN, 15));
		btnMiCuenta.setBounds(10, 159, 132, 23);
		btnMiCuenta.addActionListener(e -> showPanel("CuentaPanel"));
		panel3.add(btnMiCuenta);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSalir.setFont(new Font("Serif", Font.PLAIN, 15));
		btnSalir.setBounds(10, 284, 132, 23);
		panel3.add(btnSalir);

		// Contenedor para los paneles con CardLayout
		panelCards = new JPanel(new CardLayout());
		panelCards.setBounds(152, 37, 672, 318);
		panel.add(panelCards);

		// Panel "Rutinas"
		JPanel rutinasPanel = new JPanel();
		rutinasPanel.setBackground(new Color(128, 128, 255));
		panelCards.add(rutinasPanel, "RutinasPanel");
		rutinasPanel.setLayout(null);
		
		
		
		JButton btnBuscarRutina = new JButton("Buscar rutina");
		btnBuscarRutina.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnBuscarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar_menu frame = new buscar_menu(id_usuario);
				frame.setVisible(true);
				dispose();
				
			}
		});
	
		btnBuscarRutina.setForeground(new Color(255, 128, 64));
		btnBuscarRutina.setBackground(new Color(128, 128, 192));
		btnBuscarRutina.setBounds(143, 113, 394, 27);
		
		rutinasPanel.add(btnBuscarRutina);

		JLabel lblNewLabel = new JLabel("Rutinas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 21, 122, 27);
		rutinasPanel.add(lblNewLabel);
		
		JButton btnCrearRutina = new JButton("Crear rutina");
		btnCrearRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crear_rutina frame = new crear_rutina(id_usuario);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCrearRutina.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnCrearRutina.setForeground(new Color(255, 128, 64));
		btnCrearRutina.setBackground(new Color(128, 128, 192));
		btnCrearRutina.setBounds(143, 151, 394, 27);
		rutinasPanel.add(btnCrearRutina);
		
		
		
		
		JButton btnVerRutinaComp = new JButton("Ver rutinas compartidas");
		btnVerRutinaComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mis_rutinas_compartidas frame = new mis_rutinas_compartidas(id_usuario);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnVerRutinaComp.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnVerRutinaComp.setForeground(new Color(255, 128, 64));
		btnVerRutinaComp.setBackground(new Color(128, 128, 192));
		btnVerRutinaComp.setBounds(143, 189, 394, 27);
		rutinasPanel.add(btnVerRutinaComp);
		
		JButton btnBuscar_1_1_1 = new JButton("Mis rutinas");
		btnBuscar_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mis_rutinas frame = new mis_rutinas(id_usuario);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBuscar_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnBuscar_1_1_1.setForeground(new Color(255, 128, 64));
		btnBuscar_1_1_1.setBackground(new Color(128, 128, 192));
		btnBuscar_1_1_1.setBounds(143, 227, 394, 27);
		rutinasPanel.add(btnBuscar_1_1_1);

		// Panel "Desafíos"
		JPanel desafiosPanel = new JPanel();
		desafiosPanel.setBackground(new Color(128, 128, 255));
		panelCards.add(desafiosPanel, "DesafiosPanel");
		desafiosPanel.setLayout(null);

		JLabel lblDesafios = new JLabel("Desafios");
		lblDesafios.setForeground(Color.WHITE);
		lblDesafios.setFont(new Font("Serif", Font.PLAIN, 15));
		lblDesafios.setBounds(10, 11, 100, 48);
		desafiosPanel.add(lblDesafios);
		
		JLabel lblNewLabel_2 = new JLabel("PROXIMAMENTE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(118, 109, 426, 48);
		desafiosPanel.add(lblNewLabel_2);

		// Panel "Mi Cuenta"
		JPanel cuentaPanel = new JPanel();
		cuentaPanel.setBackground(new Color(128, 128, 255));
		panelCards.add(cuentaPanel, "CuentaPanel");
		cuentaPanel.setLayout(null);

		JPanel CambiarContraPanel = new JPanel();
		CambiarContraPanel.setBackground(new Color(128, 128, 255));
		panelCards.add(CambiarContraPanel, "CambiarContraPanel");
		CambiarContraPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cambiar contraseña");
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(43, 52, 150, 28);
		CambiarContraPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña actual :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(43, 106, 150, 28);
		CambiarContraPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Contraseña nueva:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(43, 145, 150, 28);
		CambiarContraPanel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Re-Contraseña nueva :");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(43, 184, 150, 28);
		CambiarContraPanel.add(lblNewLabel_1_1_1_1);

		JLabel lblMensaPassAc = new JLabel("");
		lblMensaPassAc.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblMensaPassAc.setForeground(new Color(255, 0, 0));
		lblMensaPassAc.setBackground(new Color(255, 255, 255));
		lblMensaPassAc.setBounds(357, 111, 230, 20);
		CambiarContraPanel.add(lblMensaPassAc);

		JLabel lblMensaRePass = new JLabel("");
		lblMensaRePass.setForeground(Color.RED);
		lblMensaRePass.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblMensaRePass.setBackground(Color.WHITE);
		lblMensaRePass.setBounds(357, 165, 305, 20);
		CambiarContraPanel.add(lblMensaRePass);

		JButton btnCambiarPass = new JButton("Cambiar contraseña");
		btnCambiarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensaPassAc.setText("");
				lblMensaRePass.setText("");
				String passAc = new String(pass.getPassword());
				String pass2 = new String(passNew.getPassword());
				String pass3 = new String(passNew2.getPassword());

				if (!passAc.trim().isEmpty() && !pass2.trim().isEmpty() && !pass3.trim().isEmpty()) {

					if (usuarioControlador.cambiarContraDelCLiente(passAc, pass2, pass3, cliente)) {

						JOptionPane.showMessageDialog(null, "La contraseña ha sido actualizada correctamente.",
								"Cambio Exitoso", JOptionPane.INFORMATION_MESSAGE);

						showPanel("CuentaPanel");

					} else if (!passAc.equals(cliente.getPass())) {

						lblMensaPassAc.setText("Error,Contraseña actual incorrecta");
					} else if (!pass2.equals(pass3)) {
						lblMensaRePass.setText("Error,No hay coincidencia en la contraseña nueva");
					}

				} else {

					JOptionPane.showMessageDialog(null, "Error,Hay valores sin completar...", "Cambio Exitoso",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCambiarPass.setBounds(103, 241, 203, 28);
		CambiarContraPanel.add(btnCambiarPass);

		pass = new JPasswordField();
		pass.setBounds(177, 111, 158, 20);
		CambiarContraPanel.add(pass);

		passNew = new JPasswordField();
		passNew.setBounds(177, 150, 158, 20);
		CambiarContraPanel.add(passNew);

		passNew2 = new JPasswordField();
		passNew2.setBounds(177, 189, 158, 20);
		CambiarContraPanel.add(passNew2);

		JLabel lblMiCuenta = new JLabel("Mi cuenta");
		lblMiCuenta.setBounds(10, 11, 100, 48);
		lblMiCuenta.setForeground(Color.WHITE);
		lblMiCuenta.setFont(new Font("Serif", Font.PLAIN, 15));
		cuentaPanel.add(lblMiCuenta);

		Datos_personales datos_cliente = Datos_personalesControlador
				.obteniendoDatosCliente(cliente.getIdDatosPersonales());

		Menu menu_cliente = MenuControlador.obteniendoMenuCliente(id_usuario);
		Objetivo_cliente objetivo_cliente = MenuControlador.obteniendoObjetivoCliente(menu_cliente.getId_objetivo());
		objetivo_cliente.setId_objetivo(menu_cliente.getId_objetivo());

		Area_entrenamiento area_cliente = MenuControlador
				.obteniendoAreaDeEntrenamiento(menu_cliente.getId_area_entrenamiento());

		area_cliente.setId_area(menu_cliente.getId_area_entrenamiento());

		System.out.println(menu_cliente.getId_area_entrenamiento());
		System.out.println(menu_cliente.getId_objetivo());

		// Etiqueta de "Nombre"
		JLabel lblApelli = new JLabel("Apellido:");
		lblApelli.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApelli.setBounds(40, 116, 100, 28);
		cuentaPanel.add(lblApelli);

		// Etiqueta de "Apellido"
		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(40, 80, 100, 28);
		cuentaPanel.add(lblNom);

		// Campo de texto editable para mostrar y modificar el nombre
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setBounds(130, 80, 200, 28);
		textNombre.setForeground(Color.BLACK);
		textNombre.setText(datos_cliente.getNombre()); // Mostrar el valor inicial
		cuentaPanel.add(textNombre);

		textApellido = new JTextField();
		textApellido.setText(datos_cliente.getApellido());
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textApellido.setForeground(Color.BLACK);
		textApellido.setBounds(130, 116, 200, 28);
		cuentaPanel.add(textApellido);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdad.setBounds(354, 116, 63, 28);
		cuentaPanel.add(lblEdad);

		textEdad = new JTextField();
		textEdad.setText(String.valueOf(datos_cliente.getEdad()));
		textEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEdad.setForeground(Color.BLACK);
		textEdad.setBounds(413, 117, 200, 28);
		cuentaPanel.add(textEdad);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(40, 155, 82, 28);
		cuentaPanel.add(lblTelefono);

		textTelefono = new JTextField();
		textTelefono.setText(datos_cliente.getTelefono());
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefono.setForeground(Color.BLACK);
		textTelefono.setBounds(130, 155, 200, 28);
		cuentaPanel.add(textTelefono);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(354, 155, 63, 28);
		cuentaPanel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText(datos_cliente.getEmail());
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setBounds(413, 155, 200, 28);
		cuentaPanel.add(txtEmail);

		JLabel lblTipoDeObjetivo = new JLabel("Objetivo:");
		lblTipoDeObjetivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeObjetivo.setBounds(40, 199, 120, 28);
		cuentaPanel.add(lblTipoDeObjetivo);

		textObjetivo = new JTextField();
		textObjetivo.setText(objetivo_cliente.getTipo_objetivo());
		textObjetivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textObjetivo.setBounds(130, 194, 200, 28);
		cuentaPanel.add(textObjetivo);

		textEspacio = new JTextField();
		textEspacio.setText(area_cliente.getEspacio());
		textEspacio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEspacio.setBounds(130, 232, 200, 28);
		cuentaPanel.add(textEspacio);

		JLabel lblEspacio = new JLabel("Espacio:");
		lblEspacio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEspacio.setBounds(40, 232, 82, 28);
		cuentaPanel.add(lblEspacio);

		JLabel lblBarrio = new JLabel("Barrio:");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarrio.setBounds(354, 194, 82, 28);
		cuentaPanel.add(lblBarrio);

		textBarrio = new JTextField();
		textBarrio.setText(area_cliente.getBarrio());
		textBarrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textBarrio.setBounds(413, 194, 200, 28);
		cuentaPanel.add(textBarrio);

		JButton btnCambiarContrasea = new JButton("Cambiar contraseña");
		btnCambiarContrasea.setFont(new Font("Serif", Font.PLAIN, 15));
		btnCambiarContrasea.addActionListener(e -> showPanel("CambiarContraPanel"));
		btnCambiarContrasea.setBounds(369, 284, 181, 28);
		cuentaPanel.add(btnCambiarContrasea);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(354, 232, 82, 28);
		cuentaPanel.add(lblDireccion);

		textDirec = new JTextField();
		textDirec.setText(area_cliente.getDireccion());
		textDirec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDirec.setBounds(413, 232, 200, 28);
		cuentaPanel.add(textDirec);

		JButton btnActualizar = new JButton("Actualizar formulario");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Border bordeRojo = BorderFactory.createLineBorder(Color.RED, 2);
				textNombre.setBorder(BorderFactory.createEmptyBorder());
				textApellido.setBorder(BorderFactory.createEmptyBorder());
				textEdad.setBorder(BorderFactory.createEmptyBorder());
				textTelefono.setBorder(BorderFactory.createEmptyBorder());
				txtEmail.setBorder(BorderFactory.createEmptyBorder());
				textObjetivo.setBorder(BorderFactory.createEmptyBorder());
				textEspacio.setBorder(BorderFactory.createEmptyBorder());
				textBarrio.setBorder(BorderFactory.createEmptyBorder());
				textDirec.setBorder(BorderFactory.createEmptyBorder());
				boolean esValido = true;

				// Validación de edad
				if (!Datos_personalesControlador.validacionDeEdad(textEdad.getText())) {
					textEdad.setBorder(bordeRojo);
					esValido = false;
				}

				// Validación de email
				if (!Datos_personalesControlador.validacionDeEmail(txtEmail.getText())) {
					txtEmail.setBorder(bordeRojo);
					esValido = false;
				}

				// Verificar si los campos están vacíos
				if (textNombre.getText().trim().isEmpty()) {

					textNombre.setBorder(bordeRojo);
					esValido = false;
				}

				if (textApellido.getText().trim().isEmpty()) {
					textApellido.setBorder(bordeRojo);
					esValido = false;
				}

				if (textTelefono.getText().trim().isEmpty()) {
					textTelefono.setBorder(bordeRojo);
					esValido = false;
				}

				if (textEdad.getText().trim().isEmpty()) {
					textEdad.setBorder(bordeRojo);
					esValido = false;
				}

				if (txtEmail.getText().trim().isEmpty()) {
					txtEmail.setBorder(bordeRojo);
					esValido = false;
				}
				if (textObjetivo.getText().trim().isEmpty()) {
					textObjetivo.setBorder(bordeRojo);
					esValido = false;
				}

				if (textEspacio.getText().trim().isEmpty()) {
					textEspacio.setBorder(bordeRojo);
					esValido = false;
				}
				if (textBarrio.getText().trim().isEmpty()) {
					textBarrio.setBorder(bordeRojo);
					esValido = false;
				}
				if (textDirec.getText().trim().isEmpty()) {
					textDirec.setBorder(bordeRojo);
					esValido = false;
				}

				if (esValido) {
					datos_cliente.setNombre(textNombre.getText().trim());
					datos_cliente.setEdad(Integer.parseInt(textEdad.getText().trim()));
					datos_cliente.setApellido(textApellido.getText().trim());
					datos_cliente.setTelefono(textTelefono.getText().trim());
					datos_cliente.setEmail(txtEmail.getText().trim());

					Datos_personalesControlador.actualizarDatosPersonalesCliente(datos_cliente);
					objetivo_cliente.setTipo_objetivo(textObjetivo.getText().trim());
					objetivo_cliente.setFecha_inicial(LocalDate.now());
					objetivo_cliente.setProgreso(0);
					MenuControlador.actualizarObjetivo(objetivo_cliente);
					area_cliente.setEspacio(textEspacio.getText().trim());
					area_cliente.setBarrio(textBarrio.getText().trim());
					area_cliente.setDireccion(textDirec.getText().trim());
					MenuControlador.actualizarArea(area_cliente);

					JOptionPane.showMessageDialog(null, "Cambios realizados", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					showPanel("CuentaPanel");

				} else {
					JOptionPane.showMessageDialog(null,
							"ERROR, POR FAVOR COMPLETAR CORRECTAMENTE LOS CAMPOS MARCADOS ..", "Información",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnActualizar.setFont(new Font("Serif", Font.PLAIN, 15));
		btnActualizar.setBounds(145, 284, 181, 28);
		cuentaPanel.add(btnActualizar);

		JButton btnReset = new JButton("Reset informacion");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNombre.setBorder(BorderFactory.createEmptyBorder());
				textApellido.setBorder(BorderFactory.createEmptyBorder());
				textEdad.setBorder(BorderFactory.createEmptyBorder());
				textTelefono.setBorder(BorderFactory.createEmptyBorder());
				txtEmail.setBorder(BorderFactory.createEmptyBorder());
				textObjetivo.setBorder(BorderFactory.createEmptyBorder());
				textEspacio.setBorder(BorderFactory.createEmptyBorder());
				textBarrio.setBorder(BorderFactory.createEmptyBorder());
				textDirec.setBorder(BorderFactory.createEmptyBorder());

				textNombre.setText(datos_cliente.getNombre());
				textApellido.setText(datos_cliente.getApellido());
				textEdad.setText(String.valueOf(datos_cliente.getEdad()));
				textTelefono.setText(datos_cliente.getTelefono());
				txtEmail.setText(datos_cliente.getEmail());
				textObjetivo.setText(objetivo_cliente.getTipo_objetivo());
				textEspacio.setText(area_cliente.getEspacio());
				textBarrio.setText(area_cliente.getBarrio());
				textDirec.setText(area_cliente.getDireccion());
				showPanel("CuentaPanel");

			}
		});
		btnReset.setFont(new Font("Serif", Font.PLAIN, 15));
		btnReset.setBounds(499, 11, 163, 28);
		cuentaPanel.add(btnReset);

	}

	// Método para mostrar un panel específico
	private void showPanel(String panelName) {
		CardLayout cl = (CardLayout) (panelCards.getLayout());
		cl.show(panelCards, panelName);
	}
}
