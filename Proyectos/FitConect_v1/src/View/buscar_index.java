package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Controller.RutinasControlador;

import Model.Rutina;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class buscar_index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBuscar;
	JTable tablaRutinas;
	ArrayList<Rutina> rutinas_busqueda;

	public buscar_index() {
		setTitle("Buscar");
		setResizable(false);
		setBounds(100, 100, 850, 394);
		setLocationRelativeTo(null);/// CENTRA LA VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);

		textBuscar = new JTextField();
		textBuscar.setBounds(220, 32, 332, 29);
		textBuscar.setBorder(null);
		panel.add(textBuscar);
		textBuscar.setColumns(10);

		ImageIcon iconoInicioSesion = new ImageIcon(login.class.getResource("/img/lupa.png"));
		Image scaledImageIcon = iconoInicioSesion.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		panel.setLayout(null);
		JButton btnBuscar = new JButton();

		btnBuscar.setBounds(551, 32, 30, 29);
		btnBuscar.setOpaque(true);
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setIcon(new ImageIcon(scaledImageIcon));
		panel.add(btnBuscar);

		JLabel lblMensajeBuscar = new JLabel("");
		lblMensajeBuscar.setBackground(new Color(240, 240, 240));
		lblMensajeBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeBuscar.setForeground(Color.PINK);
		lblMensajeBuscar.setBounds(220, 96, 353, 65);
		panel.add(lblMensajeBuscar);

		JLabel lblMensajeBusqueda = new JLabel("");
		lblMensajeBusqueda.setBackground(new Color(240, 240, 240));
		lblMensajeBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeBusqueda.setForeground(Color.PINK);
		lblMensajeBusqueda.setBounds(220, 96, 353, 65);
		panel.add(lblMensajeBusqueda);

		textBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnBuscar.doClick();
				textBuscar.setText("");
			}
		});

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
		btnAtras.setBounds(773, 31, 40, 30);
		panel.add(btnAtras);

		JButton btnVerRutina = new JButton("VER");
		btnVerRutina.setFont(new Font("Serif", Font.PLAIN, 15));
		btnVerRutina.addActionListener(new ActionListener() {
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

						Rutina rutinaSeleccionada = rutinas_busqueda.get(selectedRow);

						ver_ejercicios_index frame = new ver_ejercicios_index(rutinaSeleccionada,"I",0);
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
		btnVerRutina.setForeground(new Color(255, 255, 255));
		btnVerRutina.setBackground(new Color(255, 128, 64));
		btnVerRutina.setBounds(304, 288, 173, 29);
		panel.add(btnVerRutina);

		iconoInicioSesion = new ImageIcon(login.class.getResource("/img/ojo.png"));
		scaledImageIcon = iconoInicioSesion.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		panel.setLayout(null);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensajeBusqueda.setText("");
				lblMensajeBuscar.setText("");

				if (textBuscar.getText().length() >= 3) {
					String busqueda = textBuscar.getText();
					rutinas_busqueda = new ArrayList<Rutina>();
					rutinas_busqueda = RutinasControlador.obteniendoRutinasDeLaBusqueda(busqueda);

					if (rutinas_busqueda == null || rutinas_busqueda.isEmpty()) {

						Component[] components = panel.getComponents();
						for (Component comp : components) {
							if (comp instanceof JScrollPane) {
								panel.remove(comp);
							}
						}
						lblMensajeBusqueda.setText("NO SE ENCONTRO NADA EN LA BUSQUEDA");
					} else {

						String[] column_names = { "Seleccionar", "Titulo", "Dificultad", "Actividad", "Creador",
								"Popularidad" };

						Object[][] data = new Object[rutinas_busqueda.size()][6];

						for (int i = 0; i < rutinas_busqueda.size(); i++) {
							Rutina rutina = rutinas_busqueda.get(i);
							data[i][0] = false;
							data[i][1] = rutina.getTitulo();
							data[i][2] = rutina.getDificultad();
							data[i][3] = rutina.getActividad_deportiva();
							data[i][4] = rutina.getUsuario_creador();
							data[i][5] = rutina.getPopularidad_rutina();
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
						tablaRutinas.getColumn("Seleccionar")
								.setCellEditor(new RadioButtonEditor(new JCheckBox(), tablaRutinas));
						tablaRutinas.setBounds(20, 100, 1000, 100);
						tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);

						tablaRutinas.setBounds(30, 50, 550, 100);

						int[] anchosColumnas = { 100, 200, 100, 150, 150, 100 };

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

				} else {

					Component[] components = panel.getComponents();
					for (Component comp : components) {
						if (comp instanceof JScrollPane) {
							panel.remove(comp);
						}
					}

					lblMensajeBuscar.setText("ERROR,INGRESA AL MENOS 3 CARACTERES!");

				}

				panel.revalidate();
				panel.repaint();
			}
		});

		JLabel lblNewLabel = new JLabel("ACTIVIDAD DEPORTIVA :");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 32, 211, 29);
		panel.add(lblNewLabel);

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

}
