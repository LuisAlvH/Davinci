package GUI;

import java.awt.Component;
import java.awt.EventQueue;
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

import BLL.Ejercicio;
import BLL.EntradaYsalida;
import BLL.Usuario;

public class Mod_ejerC extends JFrame {

	private DefaultTableModel tableModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaRutinas;

	public Mod_ejerC(int id_rutina, Usuario usser) {
		setTitle("Modificar Ejercicios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = tablaRutinas.getSelectedRow();

				if (selectedRow != -1) {

					int id = (int) tablaRutinas.getValueAt(selectedRow, 1);
					String nombre = (String) tablaRutinas.getValueAt(selectedRow, 2);
					int repeticiones = Integer.parseInt(tablaRutinas.getValueAt(selectedRow, 3).toString());
					int serie = Integer.parseInt(tablaRutinas.getValueAt(selectedRow, 4).toString());
					int descanso = Integer.parseInt(tablaRutinas.getValueAt(selectedRow, 5).toString());

					Ejercicio ejercicioSeleccionado = new Ejercicio(nombre, serie, repeticiones, descanso, id);

					Modificando_ejercicioC frame = new Modificando_ejercicioC(ejercicioSeleccionado, id_rutina, usser);
					frame.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada.");
				}
			}
		});
		btnNewButton.setBounds(131, 227, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ver_rutinas_cuentaC frame = new Ver_rutinas_cuentaC(usser);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(281, 227, 89, 23);
		contentPane.add(btnVolver);

		ArrayList<Ejercicio> MisEjercicios = EntradaYsalida.obteniendoInformacionEjerciciosALL(id_rutina);

		if (MisEjercicios == null || MisEjercicios.isEmpty()) {

			System.out.println("Esta vacio");
		} else {

			String[] columnNames = { "Seleccionar", "ID", "Nombre", "Repeticiones", "Serie", "Descanso" };
			Object[][] data = new Object[MisEjercicios.size()][6];

			for (int i = 0; i < MisEjercicios.size(); i++) {
				Ejercicio ejercicio = MisEjercicios.get(i);

				if (ejercicio != null) {
					data[i][0] = false;
					data[i][1] = ejercicio.getId_ejercicio();
					data[i][2] = ejercicio.getNombre();
					data[i][3] = ejercicio.getRepeticiones();
					data[i][4] = ejercicio.getSerie();
					data[i][5] = ejercicio.getDescansoEntreSerie();
				} else {

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
			tablaRutinas.setBounds(20, 50, 400, 100);
			tablaRutinas.getColumnModel().getColumn(1).setMinWidth(0);
			tablaRutinas.getColumnModel().getColumn(1).setMaxWidth(0);
			tablaRutinas.getColumnModel().getColumn(1).setPreferredWidth(0);
			JScrollPane scrollPane = new JScrollPane(tablaRutinas);
			scrollPane.setBounds(20, 50, 400, 100);
			tablaRutinas.getColumn("Seleccionar").setCellRenderer(new RadioButtonRenderer2());
			tablaRutinas.getColumn("Seleccionar").setCellEditor(new RadioButtonEditor2(new JCheckBox(), tablaRutinas));
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
