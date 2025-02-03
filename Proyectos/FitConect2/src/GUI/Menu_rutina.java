package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;

public class Menu_rutina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Menu_rutina(Usuario usser) {
		setTitle("Menu rutina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnBuscarRut = new JButton("Buscar rutina");
		btnBuscarRut.setBounds(30, 45, 150, 40);
		btnBuscarRut.setBackground(new Color(0, 128, 192));
		btnBuscarRut.setForeground(Color.WHITE);
		contentPane.add(btnBuscarRut);
		btnBuscarRut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Buscar_rutina_menu frame = new Buscar_rutina_menu(usser);
				frame.setVisible(true);
				dispose();
			}
		});

		JButton btnCre = new JButton("Crear rutina");
		btnCre.setForeground(Color.WHITE);
		btnCre.setBackground(new Color(0, 128, 192));
		btnCre.setBounds(213, 45, 150, 40);
		contentPane.add(btnCre);
		btnCre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Crear_rutina frame = new Crear_rutina(usser);
				frame.setVisible(true);
				dispose();
			}
		});

		JButton btnVerRutinasCompartidas = new JButton("Ver rutinas compartidas");
		btnVerRutinasCompartidas.setForeground(Color.WHITE);
		btnVerRutinasCompartidas.setBackground(new Color(0, 128, 192));
		btnVerRutinasCompartidas.setBounds(30, 122, 150, 40);
		contentPane.add(btnVerRutinasCompartidas);
		btnVerRutinasCompartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ver_rutinas_cuentaC frame = new Ver_rutinas_cuentaC(usser);
				frame.setVisible(true);
				dispose();
			}
		});
		JButton btnMisRutinas = new JButton("Mis rutinas");
		btnMisRutinas.setForeground(Color.WHITE);
		btnMisRutinas.setBackground(new Color(0, 128, 192));
		btnMisRutinas.setBounds(213, 122, 150, 40);
		btnMisRutinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ver_rutinas_cuenta frame = new Ver_rutinas_cuenta(usser);
				frame.setVisible(true);
				dispose();

			}
		});
		contentPane.add(btnMisRutinas);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(90, 196, 201, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Menu_cliente frame = new Menu_cliente(usser);
				frame.setVisible(true);
				dispose();

			}
		});

	}
}
