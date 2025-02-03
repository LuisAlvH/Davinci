package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.EntradaYsalida;
import BLL.Rutina;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {

		index frame = new index();
		frame.setVisible(true);

	}

	public index() {
		setTitle("FitConnect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		JLabel icon = new JLabel("icono");
		icon.setBounds(256, 20, 46, 14);
		contentPane.add(icon);

		JLabel tittle = new JLabel("FitConnect");
		tittle.setFont(new Font("Candara", Font.BOLD, 16));
		tittle.setBounds(171, 11, 87, 37);
		contentPane.add(tittle);
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensaje.setForeground(Color.PINK);
		lblMensaje.setBounds(35, 75, 353, 65);
		contentPane.add(lblMensaje);

		ArrayList<Rutina> rutinas = EntradaYsalida.arrayPerfilesInicioSesion();

		if (rutinas == null || rutinas.isEmpty()) {

			lblMensaje.setText("No hay rutinas cargadas....");
		} else {

			String[] columnNames = { "Titulo", "Dificultad", "Actividad", "Creador" };
			Object[][] data = new Object[rutinas.size()][4];

			for (int i = 0; i < rutinas.size(); i++) {
				Rutina rutina = rutinas.get(i);
				if (rutina != null) {
					data[i][0] = rutina.getTituloRutina();
					data[i][1] = rutina.getDificultad();
					data[i][2] = rutina.getActividad_deportiva();
					data[i][3] = rutina.getUsuarioCreador();
				} else {

				}
			}

			DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

			JTable tablaRutinas = new JTable(tableModel);
			tablaRutinas.setBounds(20, 50, 400, 100);

			tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);
			JScrollPane scrollPane = new JScrollPane(tablaRutinas);
			scrollPane.setBounds(20, 50, 400, 100);

			contentPane.add(scrollPane);
			contentPane.revalidate();
			contentPane.repaint();
		}

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(0, 128, 192));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(0, 128, 192));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Datos_personales frame = new Datos_personales();
				frame.setVisible(true);
				dispose();

			}
		});
		btnRegistrar.setBounds(10, 227, 89, 23);
		contentPane.add(btnRegistrar);
		JButton btnIniciarSession = new JButton("Iniciar session");
		btnIniciarSession.setBackground(new Color(0, 128, 192));
		btnIniciarSession.setForeground(new Color(255, 255, 255));
		btnIniciarSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_session frame = new Inicio_session();
				frame.setVisible(true);
				dispose();
			}
		});
		btnIniciarSession.setBounds(158, 227, 113, 23);
		contentPane.add(btnIniciarSession);
	}
}
