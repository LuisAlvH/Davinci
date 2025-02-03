package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Ejercicio;
import BLL.EntradaYsalida;
import BLL.Rutina;
import BLL.Usuario;

public class verInformacion_ejercicios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public verInformacion_ejercicios(int id_rutina, Usuario usser) {
		setTitle("Informacion ejercicios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		ArrayList<Ejercicio> ejercicios = EntradaYsalida.ObteniendoListaDeEjerci(id_rutina);

		if (!ejercicios.isEmpty()) {
			String[] columnNames = { "Nombre", "Serie", "Repeticiones", "Descanso entre Serie" };

			Object[][] data = new Object[ejercicios.size()][4];
			for (int i = 0; i < ejercicios.size(); i++) {
				Ejercicio ejercicio = ejercicios.get(i);
				data[i][0] = ejercicio.getNombre();
				data[i][1] = ejercicio.getSerie();
				data[i][2] = ejercicio.getRepeticiones();
				data[i][3] = ejercicio.getDescansoEntreSerie();
			}

			DefaultTableModel model = new DefaultTableModel(data, columnNames);
			JTable table = new JTable(model);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(table);
			contentPane.add(scrollPane, BorderLayout.CENTER);

			setVisible(true);
		} else {

			JLabel lblMensaje = new JLabel("No hay ejercicios disponibles para esta rutina.");
			lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblMensaje, BorderLayout.CENTER);
		}

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Buscar_rutina_menu frame = new Buscar_rutina_menu(usser);
				frame.setVisible(true);
				dispose();

			}
		});

		JPanel panelBoton = new JPanel();
		panelBoton.add(btnVolver);
		contentPane.add(panelBoton, BorderLayout.SOUTH);

		setVisible(true);
	}

}
