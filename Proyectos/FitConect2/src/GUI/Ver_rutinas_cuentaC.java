package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BLL.EntradaYsalida;
import BLL.Rutina;
import BLL.Usuario;

public class Ver_rutinas_cuentaC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Rutina> rutinas;
	private JTable tablaRutinas = new JTable();
	private JLabel lblMensaje;

	public Ver_rutinas_cuentaC(Usuario usser) {
		setTitle("Mis rutinas compartidas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensaje.setBounds(86, 115, 273, 28);
		contentPane.add(lblMensaje);

		JLabel lblNewLabel = new JLabel("FitConnect");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(193, 22, 94, 28);
		contentPane.add(lblNewLabel);

		JButton btnModEjer = new JButton("Modificar Ejercicios");
		btnModEjer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = -1;
				for (int i = 0; i < tablaRutinas.getRowCount(); i++) {
					Boolean isSelected = (Boolean) tablaRutinas.getValueAt(i, 0);
					if (isSelected != null && isSelected) {
						selectedRow = i;
						break;
					}
				}

				if (selectedRow != -1) {

					Rutina rutinaSeleccionada = rutinas.get(selectedRow);
					int idRutina = rutinaSeleccionada.getId_rutina();

					Mod_ejerC frame = new Mod_ejerC(idRutina, usser);
					frame.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnModEjer.setBounds(21, 266, 145, 23);
		contentPane.add(btnModEjer);

		JButton btnElim = new JButton("Eliminar");
		btnElim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = -1;
				for (int i = 0; i < tablaRutinas.getRowCount(); i++) {
					Boolean isSelected = (Boolean) tablaRutinas.getValueAt(i, 0);
					if (isSelected != null && isSelected) {
						selectedRow = i;
						break;
					}
				}

				if (selectedRow != -1) {

					Rutina rutinaSeleccionada = rutinas.get(selectedRow);
					int idRutina = rutinaSeleccionada.getId_rutina();

					EntradaYsalida.eliminarRutna(idRutina);
					JOptionPane.showMessageDialog(null, "Rutina Eliminada.", "Advertencia",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnElim.setBounds(345, 266, 89, 23);
		contentPane.add(btnElim);

		JButton btnCompartir = new JButton("Descompartir");
		btnCompartir.setBounds(467, 266, 111, 23);
		contentPane.add(btnCompartir);
		btnCompartir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = -1;
				for (int i = 0; i < tablaRutinas.getRowCount(); i++) {
					Boolean isSelected = (Boolean) tablaRutinas.getValueAt(i, 0);
					if (isSelected != null && isSelected) {
						selectedRow = i;
						break;
					}
				}

				if (selectedRow != -1) {

					Rutina rutinaSeleccionada = rutinas.get(selectedRow);
					int idRutina = rutinaSeleccionada.getId_rutina();

					EntradaYsalida.actualizarRutnaAtributoCompartida(idRutina, 0);
					JOptionPane.showMessageDialog(null, "Rutina Descompartida.", "Advertencia",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_rutina frame = new Menu_rutina(usser);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(356, 11, 89, 23);
		contentPane.add(btnVolver);

		JButton btnModRut = new JButton("Modificar Rutina");
		btnModRut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = -1;
				for (int i = 0; i < tablaRutinas.getRowCount(); i++) {
					Boolean isSelected = (Boolean) tablaRutinas.getValueAt(i, 0);
					if (isSelected != null && isSelected) {
						selectedRow = i;
						break;
					}
				}

				if (selectedRow != -1) {

					Rutina rutinaSeleccionada = rutinas.get(selectedRow);
					int idRutina = rutinaSeleccionada.getId_rutina();

					Modificando_rutisC frame = new Modificando_rutisC(idRutina, usser);
					frame.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnModRut.setBounds(189, 266, 126, 23);
		contentPane.add(btnModRut);

		ArrayList<Integer> MisRutinas = EntradaYsalida.obteneniendoRutiCompa(usser.getIdUsuario());

		rutinas = new ArrayList<Rutina>();
		rutinas.clear();

		if (MisRutinas.size() != 0) {
			int contador = 0;
			for (int id_rutina : MisRutinas) {
				rutinas.add(EntradaYsalida.obteniendoRutinaSinComp(id_rutina));
				contador++;
			}
		}

		if (rutinas == null || rutinas.isEmpty()) {
			lblMensaje.setText("NO HAY RUTINAS CARGADAS");
		} else {
			String[] columnNames = { "Seleccionar", "Titulo", "Dificultad", "Actividad Deportiva", "Popularidad" };
			Object[][] data = new Object[rutinas.size()][5];

			for (int i = 0; i < rutinas.size(); i++) {
				Rutina rutina = rutinas.get(i);
				if (rutina != null) {
					data[i][0] = false;
					data[i][1] = rutina.getTituloRutina();
					data[i][2] = rutina.getDificultad();
					data[i][3] = rutina.getActividad_deportiva();
					data[i][4] = rutina.getPopularidadRutina();
				} else {

					System.out.println("Rutina nula en la posición " + i);
				}
			}

			DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 0;
				}

				@Override
				public Class<?> getColumnClass(int column) {
					return column == 0 ? Boolean.class : String.class;
				}
			};

			tablaRutinas = new JTable(tableModel);
			tablaRutinas.getColumn("Seleccionar").setCellRenderer(new RadioButtonRenderer2());
			tablaRutinas.getColumn("Seleccionar").setCellEditor(new RadioButtonEditor2(new JCheckBox(), tablaRutinas));

			tablaRutinas.setBounds(20, 50, 800, 100);
			tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);

			JScrollPane scrollPane = new JScrollPane(tablaRutinas);
			scrollPane.setBounds(20, 50, 700, 100);
			contentPane.add(scrollPane);
		}

		contentPane.revalidate();
		contentPane.repaint();

	}

	class RadioButtonEditor2 extends DefaultCellEditor {
		private JRadioButton button;
		private JTable table;

		public RadioButtonEditor2(JCheckBox checkBox, JTable table) {
			super(checkBox);
			this.table = table;
			button = new JRadioButton();
			button.setHorizontalAlignment(JLabel.CENTER);
			button.addActionListener(e -> {
				int selectedRow = table.getEditingRow();
				for (int i = 0; i < table.getRowCount(); i++) {
					table.setValueAt(i == selectedRow, i, 0);
				}
				table.repaint();
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			button.setSelected(value != null && (boolean) value);
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			return button.isSelected();
		}
	}

	class RadioButtonRenderer2 extends JRadioButton implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setSelected(value != null && (boolean) value);
			setHorizontalAlignment(JLabel.CENTER);
			return this;
		}
	}

}
