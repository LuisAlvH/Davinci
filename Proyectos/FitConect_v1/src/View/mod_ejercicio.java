package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Controller.EjerciciosControlador;

import Model.Ejercicio;
import Model.Rutina;
import View.mis_rutinas.RadioButtonEditor;
import View.mis_rutinas.RadioButtonRenderer;

public class mod_ejercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaRutinas;
	private ArrayList<Ejercicio> misEjercicios = new ArrayList<Ejercicio>();

	public mod_ejercicio(Rutina rutina, int id_usuario, String volver) {
		setTitle("Mis ejercicio");
		setResizable(false);
		setBounds(100, 100, 850, 394);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);

		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (volver.equals("COMP")) {
					mis_rutinas_compartidas frame = new mis_rutinas_compartidas(id_usuario);
					frame.setVisible(true);
					dispose();

				} else {
					mis_rutinas frame = new mis_rutinas(id_usuario);
					frame.setVisible(true);
					dispose();

				}

			}
		});
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(773, 31, 40, 30);
		panel.add(btnAtras);

		JLabel lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(new Color(255, 0, 128));
		lblMensaje.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblMensaje.setBounds(100, 126, 529, 28);
		panel.add(lblMensaje);

		JButton btnEditarEjer = new JButton("EDITAR EJERCICIO");
		btnEditarEjer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = -1;

				if (tablaRutinas != null) {
					for (int i = 0; i < tablaRutinas.getRowCount(); i++) {
						Boolean isSelected = (Boolean) tablaRutinas.getValueAt(i, 0);
						if (isSelected != null && isSelected) {
							selectedRow = i;
							break;
						}
					}

					if (selectedRow != -1) {

						Ejercicio ejercicioSeleccionado = misEjercicios.get(selectedRow);
						edit_ejer frame = new edit_ejer(rutina, id_usuario, ejercicioSeleccionado, volver);
						frame.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para ver", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "No ha buscado ninguna rutina", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnEditarEjer.setForeground(Color.WHITE);
		btnEditarEjer.setFont(new Font("Serif", Font.PLAIN, 15));
		btnEditarEjer.setBackground(new Color(255, 128, 64));
		btnEditarEjer.setBounds(185, 274, 201, 29);
		panel.add(btnEditarEjer);

		JButton btnAgregarEjer = new JButton("AGREGAR EJERCICIO");
		btnAgregarEjer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				agregar_ejercicio_SE frame = new agregar_ejercicio_SE(id_usuario, rutina, volver);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAgregarEjer.setForeground(Color.WHITE);
		btnAgregarEjer.setFont(new Font("Serif", Font.PLAIN, 15));
		btnAgregarEjer.setBackground(new Color(255, 128, 64));
		btnAgregarEjer.setBounds(471, 274, 201, 29);
		panel.add(btnAgregarEjer);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = -1;

				if (tablaRutinas != null) {
					for (int i = 0; i < tablaRutinas.getRowCount(); i++) {
						Boolean isSelected = (Boolean) tablaRutinas.getValueAt(i, 0);
						if (isSelected != null && isSelected) {
							selectedRow = i;
							break;
						}
					}

					if (selectedRow != -1) {

						Ejercicio ejercicioSeleccionado = misEjercicios.get(selectedRow);

						EjerciciosControlador.eliminandoEjercicioDeLaRutina(ejercicioSeleccionado.getId_ejercicio());
						misEjercicios.remove(selectedRow);
						actualizarTablaRutinas(panel, misEjercicios, lblMensaje);
						JOptionPane.showMessageDialog(null, "Se ha eliminado el ejercicio..", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Por favor, selecciona un ejercicio para ver",
								"Advertencia", JOptionPane.WARNING_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "No ha buscado ninguna ejercicio", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Serif", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(255, 128, 64));
		btnEliminar.setBounds(326, 315, 201, 29);
		panel.add(btnEliminar);

		misEjercicios = EjerciciosControlador.obteniendoEjerciciosDeLaRutina(rutina.getId_rutina());

		if (misEjercicios == null || misEjercicios.isEmpty()) {
			lblMensaje.setText("NO HAY EJERCICIOS CARGADOS");
		} else {

			String[] column_names = { "Seleccionar", "Nombre", "Repeticiones", "Serie", "Descanso" };

			Object[][] data = new Object[misEjercicios.size()][5];

			for (int i = 0; i < misEjercicios.size(); i++) {
				Ejercicio ejercicio = misEjercicios.get(i);

				if (ejercicio != null) {
					data[i][0] = false;
					data[i][1] = ejercicio.getNombre();
					data[i][2] = ejercicio.getRepeteticiones();
					data[i][3] = ejercicio.getSerie();
					data[i][4] = ejercicio.getDescanso();
				} else {

				}
			}

			DefaultTableModel tableModel = new DefaultTableModel(data, column_names) {

				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 0;
				}

				@Override
				public Class<?> getColumnClass(int column) {
					return column == 0 ? Boolean.class : String.class;
				}
			};

			Component[] components = panel.getComponents();
			for (Component comp : components) {
				if (comp instanceof JScrollPane) {
					panel.remove(comp);
				}
			}
			tablaRutinas = new JTable(tableModel);

			tablaRutinas.getColumn("Seleccionar").setCellRenderer(new RadioButtonRenderer());
			tablaRutinas.getColumn("Seleccionar").setCellEditor(new RadioButtonEditor(new JCheckBox(), tablaRutinas));
			tablaRutinas.setBounds(20, 100, 1000, 100);
			tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);

			tablaRutinas.setBounds(30, 50, 550, 100);

			int[] anchosColumnas = { 150, 200, 150, 150, 150 };

			for (int i = 0; i < tablaRutinas.getColumnCount(); i++) {
				tablaRutinas.getColumnModel().getColumn(i).setPreferredWidth(anchosColumnas[i]);
				tablaRutinas.getColumnModel().getColumn(i).setMinWidth(anchosColumnas[i]);
				tablaRutinas.getColumnModel().getColumn(i).setMaxWidth(anchosColumnas[i]);
			}

			tablaRutinas.getTableHeader().setResizingAllowed(false);
			tablaRutinas.getTableHeader().setReorderingAllowed(false);
			JScrollPane scrollPane = new JScrollPane(tablaRutinas);
			scrollPane.setBounds(20, 100, 800, 100);
			panel.add(scrollPane);

		}

	}

	class RadioButtonEditor extends DefaultCellEditor {
		private JRadioButton button;
		private JTable table;

		public RadioButtonEditor(JCheckBox checkBox, JTable table) {
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

	class RadioButtonRenderer extends JRadioButton implements TableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setSelected(value != null && (boolean) value);
			setHorizontalAlignment(JLabel.CENTER);
			return this;
		}
	}

	private void actualizarTablaRutinas(JPanel panel, ArrayList<Ejercicio> misEjercicios, JLabel lblMensaje) {
		if (misEjercicios.size() == 0) {

			lblMensaje.setText("NO HAY EJERCICIOS CARGADOS");
			Component[] components = panel.getComponents();
			for (Component comp : components) {
				if (comp instanceof JScrollPane) {
					panel.remove(comp);
				}
			}

			panel.revalidate();
			panel.repaint();

		} else {

			String[] column_names = { "Seleccionar", "Nombre", "Repeticiones", "Serie", "Descanso" };

			Object[][] data = new Object[misEjercicios.size()][5];

			for (int i = 0; i < misEjercicios.size(); i++) {
				Ejercicio ejercicio = misEjercicios.get(i);

				if (ejercicio != null) {
					data[i][0] = false;
					data[i][1] = ejercicio.getNombre();
					data[i][2] = ejercicio.getRepeteticiones();
					data[i][3] = ejercicio.getSerie();
					data[i][4] = ejercicio.getDescanso();
				} else {

				}
			}
			// Crear el modelo de tabla

			DefaultTableModel tableModel = new DefaultTableModel(data, column_names) {

				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 0;
				}

				@Override
				public Class<?> getColumnClass(int column) {
					return column == 0 ? Boolean.class : String.class;
				}
			};

			Component[] components = panel.getComponents();
			for (Component comp : components) {
				if (comp instanceof JScrollPane) {
					panel.remove(comp);
				}
			}
			tablaRutinas = new JTable(tableModel);

			tablaRutinas.getColumn("Seleccionar").setCellRenderer(new RadioButtonRenderer());
			tablaRutinas.getColumn("Seleccionar").setCellEditor(new RadioButtonEditor(new JCheckBox(), tablaRutinas));
			tablaRutinas.setBounds(20, 100, 1000, 100);
			tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);

			tablaRutinas.setBounds(30, 50, 550, 100);

			int[] anchosColumnas = { 150, 200, 150, 150, 150 };

			for (int i = 0; i < tablaRutinas.getColumnCount(); i++) {
				tablaRutinas.getColumnModel().getColumn(i).setPreferredWidth(anchosColumnas[i]);
				tablaRutinas.getColumnModel().getColumn(i).setMinWidth(anchosColumnas[i]);
				tablaRutinas.getColumnModel().getColumn(i).setMaxWidth(anchosColumnas[i]);
			}

			tablaRutinas.getTableHeader().setResizingAllowed(false);
			tablaRutinas.getTableHeader().setReorderingAllowed(false);
			JScrollPane scrollPane = new JScrollPane(tablaRutinas);
			scrollPane.setBounds(20, 100, 800, 100);
			panel.add(scrollPane);
		}
	}

}
