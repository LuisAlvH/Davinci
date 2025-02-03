package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Menu_cliente(Usuario usser) {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		;
		setResizable(false);
		setLocationRelativeTo(null);

		JButton btnVerRutinas = new JButton("Rutinas");
		btnVerRutinas.setBounds(28, 93, 150, 40);
		btnVerRutinas.setBackground(new Color(0, 128, 192));
		btnVerRutinas.setForeground(Color.WHITE);
		contentPane.add(btnVerRutinas);
		btnVerRutinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Menu_rutina frame = new Menu_rutina(usser);
				frame.setVisible(true);
				dispose();

			}
		});

		JButton btnVerDesafios = new JButton("Desafios");
		btnVerDesafios.setBounds(207, 93, 150, 40);
		btnVerDesafios.setBackground(new Color(0, 128, 192));
		btnVerDesafios.setForeground(Color.WHITE);
		contentPane.add(btnVerDesafios);
		btnVerDesafios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "¡Próximamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(0, 128, 192));
		btnSalir.setBounds(284, 210, 150, 40);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				index frame = new index();
				frame.setVisible(true);
				dispose();
			}
		});

		JButton btnCuenta = new JButton("Cuenta");
		btnCuenta.setForeground(Color.WHITE);
		btnCuenta.setBackground(new Color(0, 128, 192));
		btnCuenta.setBounds(328, 0, 106, 46);
		contentPane.add(btnCuenta);
		btnCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cuenta_cliente frame = new Cuenta_cliente(usser);

				frame.setVisible(true);
				dispose();
			}
		});
	}
}
