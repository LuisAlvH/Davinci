package GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BLL.EntradaYsalida;
import BLL.Rutina;
import BLL.Usuario;
import DLL.ControllerRutina;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Buscar_rutina_menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaRutinas = new JTable();
	private ArrayList<Rutina> rutinas;

	public Buscar_rutina_menu(Usuario usser) {
		setTitle("Buscador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 180, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel panelResultados = new JPanel();
		panelResultados.setBounds(10, 60, 800, 400);
		panelResultados.setLayout(null);
		contentPane.add(panelResultados);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(174, 200, 100, 30);
		btnAgregar.addActionListener(new ActionListener() {
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

					EntradaYsalida.agregandoRutina(idRutina, usser.getIdUsuario());
					System.out.println(idRutina);
					JOptionPane.showMessageDialog(null, "Rutina agregada...",
							"Advertencia", JOptionPane.INFORMATION_MESSAGE);	
					
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}

			    
			    
			    
			}	    
		});

		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(320, 200, 100, 30);
		btnVer.addActionListener(new ActionListener() {
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

					verInformacion_ejercicios frame =new verInformacion_ejercicios(idRutina,usser);
					frame.setVisible(true);
					dispose();
					
					

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
				
				

				
	
		});

		JButton btnLike = new JButton("Like");
		btnLike.setBounds(478, 200, 100, 30);
		btnLike.addActionListener(new ActionListener() {
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

					EntradaYsalida.darLikeRutina(idRutina);
					JOptionPane.showMessageDialog(null, "Like Cargado",
							"Advertencia", JOptionPane.INFORMATION_MESSAGE);
					
					

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para agregarla.",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
				
				
				
				
				
				
				
				
				
		
			
		});

		panelResultados.add(btnAgregar);
		panelResultados.add(btnVer);
		panelResultados.add(btnLike);

		JLabel lblNewLabel = new JLabel("FitConnect");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(163, 0, 90, 24);
		contentPane.add(lblNewLabel);

		JTextField txtBuscar = new JTextField();
		txtBuscar.setBounds(222, 30, 200, 25);
		getContentPane().add(txtBuscar);

		JLabel lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensaje.setForeground(Color.PINK);
		lblMensaje.setBounds(35, 75, 353, 65);
		contentPane.add(lblMensaje);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(433, 30, 80, 25);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

		

		JLabel lblNewLabel_1 = new JLabel("Actividad deportiva :");
		lblNewLabel_1.setBounds(20, 32, 176, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(668, 30, 90, 25);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu_rutina frame =new Menu_rutina(usser);
		    	frame.setVisible(true);
				dispose();
			}
		});

	
		
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResultados.removeAll();
				panelResultados.add(btnAgregar);
				panelResultados.add(btnVer);
				panelResultados.add(btnLike);

				panelResultados.setLayout(null);
				
				
				if (txtBuscar.getText().length() >= 3) {
					String busqueda = txtBuscar.getText();

					ArrayList<Integer> MisRutinas = EntradaYsalida.obteniendoRutinasBuscador(busqueda);
					rutinas = new ArrayList<Rutina>();
					rutinas.clear();
					if (MisRutinas.size() != 0) {

						int contador = 0;
						int opcion = 0;
						for (int id_rutina : MisRutinas) {

							rutinas.add(Rutina.obteniendoRutina(id_rutina));
							contador++;

						}

					}

					if (rutinas == null || rutinas.isEmpty()) {

						lblMensaje.setText("NO SE ENCONTRO NADA EN LA BUSQUEDA");
					} else {

						String[] columnNames = { "Seleccionar", "Titulo", "Dificultad", "Actividad", "Creador",
								"Popularidad" };
						Object[][] data = new Object[rutinas.size()][6];

						for (int i = 0; i < rutinas.size(); i++) {
							Rutina rutina = rutinas.get(i);
							data[i][0] = false;
							data[i][1] = rutina.getTituloRutina();
							data[i][2] = rutina.getDificultad();
							data[i][3] = rutina.getActividad_deportiva();
							data[i][4] = rutina.getUsuarioCreador();
							data[i][5] = rutina.getPopularidadRutina();
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
						tablaRutinas.getColumn("Seleccionar").setCellRenderer(new RadioButtonRenderer());
						tablaRutinas.getColumn("Seleccionar")
								.setCellEditor(new RadioButtonEditor(new JCheckBox(), tablaRutinas));
						tablaRutinas.setBounds(20, 50, 800, 100);

						tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);
						JScrollPane scrollPane = new JScrollPane(tablaRutinas);
						scrollPane.setBounds(20, 50, 700, 100);
						panelResultados.add(scrollPane);

					}

				} else {

					JLabel lblMensaje = new JLabel("INGRESA AL MENOS 3 CARACTERES");
					lblMensaje.setBounds(20, 20, 400, 25);
					panelResultados.add(lblMensaje);
				}

				panelResultados.revalidate();
				panelResultados.repaint();

			}
		});

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
