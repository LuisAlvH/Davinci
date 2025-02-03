package View;

import java.awt.Color;
import java.awt.Component;

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

import Controller.RutinasControlador;
import Model.Rutina;


public class mis_rutinas_compartidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable tablaRutinas;
	ArrayList<Rutina> misRutinas;

	
	public mis_rutinas_compartidas(int id_usuario) {
		setTitle("Mis rutinas compartidas");
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

		
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(new Color(255, 0, 128));
		lblMensaje.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblMensaje.setBounds(100, 126, 529, 28);
		panel.add(lblMensaje);
		
		
		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu_usuario frame = new menu_usuario(id_usuario);
				frame.setVisible(true);
				dispose();
				
				
			}
		});
		
		misRutinas=RutinasControlador.obteniendoRutinasCompartirDelUsuario(id_usuario);
		
		
		
		if (misRutinas == null || misRutinas.isEmpty()) {
			lblMensaje.setText("NO HAY RUTINAS CARGADAS");
		}else {
			
			String[] column_names = { "Seleccionar", "Titulo", "Dificultad", "Actividad", "Creador",
			"Popularidad" };
			
			
			Object[][] data = new Object[misRutinas.size()][6];
			
			for (int i = 0; i < misRutinas.size(); i++) {
				Rutina rutina = misRutinas.get(i);
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
			 tablaRutinas.getColumn("Seleccionar").setCellEditor(new RadioButtonEditor(new JCheckBox(), tablaRutinas));
			 tablaRutinas.setBounds(20, 100, 1000, 100);
			 tablaRutinas.getColumnModel().getColumn(0).setPreferredWidth(180);
			 
			 
				tablaRutinas.setBounds(30, 50, 550, 100);
				
				 int[] anchosColumnas = {100, 200, 100, 150,150,100}; 
				 
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
		
		
		
		
		
		
		
		
		
		
		
		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(773, 31, 40, 30);
		panel.add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("MIS RUTINAS COMPARTIDAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 31, 213, 37);
		panel.add(lblNewLabel);
		JButton btnMisEjer = new JButton("MIS EJERCICIOS");
		btnMisEjer.addActionListener(new ActionListener() {
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

						Rutina rutinaSeleccionada = misRutinas.get(selectedRow);
						
						mod_ejercicio frame = new mod_ejercicio(rutinaSeleccionada,id_usuario,"COMP");///PASAMOS UN STRING PARA EL VOLVER.. ASI NO CREAMOS OTRO JFRAME 
						frame.setVisible(true);
						dispose();
						

					} else {
						JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para ver", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "No presenta rutinas para esta accion!", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}

				

				
			}
		});
		btnMisEjer.setForeground(Color.WHITE);
		btnMisEjer.setFont(new Font("Serif", Font.PLAIN, 15));
		btnMisEjer.setBackground(new Color(255, 128, 64));
		btnMisEjer.setBounds(128, 315, 201, 29);
		panel.add(btnMisEjer);
		
		JButton btnModificarRutina = new JButton("MODIFICAR RUTINA");
		btnModificarRutina.addActionListener(new ActionListener() {
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

						Rutina rutinaSeleccionada = misRutinas.get(selectedRow);
						
						modif_rutina frame = new modif_rutina(id_usuario,rutinaSeleccionada);
						frame.setVisible(true);
						dispose();
						

					} else {
						JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para ver", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "No presenta rutinas para esta accion!", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnModificarRutina.setForeground(Color.WHITE);
		btnModificarRutina.setFont(new Font("Serif", Font.PLAIN, 15));
		btnModificarRutina.setBackground(new Color(255, 128, 64));
		btnModificarRutina.setBounds(428, 315, 201, 29);
		panel.add(btnModificarRutina);
		
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
					        Rutina rutinaSeleccionada = misRutinas.get(selectedRow);
					        RutinasControlador.eliminarRutina(rutinaSeleccionada.getId_rutina());
					        misRutinas.remove(selectedRow);
					        tablaRutinas=actualizarTablaRutinas(panel, misRutinas, lblMensaje);
					        
					        JOptionPane.showMessageDialog(null, "Rutina Eliminada.", "Información", JOptionPane.INFORMATION_MESSAGE);
					       
					    } else {
					        JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					        System.out.println("rutian seleccionada  "+ selectedRow);
					    }

				} else {

					JOptionPane.showMessageDialog(null, "No presenta rutinas para esta accion!", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			
				
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Serif", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(255, 128, 64));
		btnEliminar.setBounds(128, 266, 201, 29);
		panel.add(btnEliminar);
		
		JButton btnCompartir = new JButton("DESCOMP-RUTINA");
		btnCompartir.addActionListener(new ActionListener() {
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

						Rutina rutinaSeleccionada = misRutinas.get(selectedRow);
						
						RutinasControlador.actualizandoCompartir(rutinaSeleccionada,0);
						misRutinas.remove(selectedRow);
						tablaRutinas=actualizarTablaRutinas(panel, misRutinas,lblMensaje);
						 
						JOptionPane.showMessageDialog(null, "Rutina Descompartida", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
						
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, selecciona una rutina para ver", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "No presenta rutinas para esta accion!", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				
				
				
				
			}
		});
		btnCompartir.setForeground(Color.WHITE);
		btnCompartir.setFont(new Font("Serif", Font.PLAIN, 15));
		btnCompartir.setBackground(new Color(255, 128, 64));
		btnCompartir.setBounds(428, 266, 201, 29);
		panel.add(btnCompartir);
		
		
		
		
		
		
		
		
		
		
		
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
	
	private JTable actualizarTablaRutinas(JPanel panel, ArrayList<Rutina> rutinasBusqueda ,JLabel lblMensaje ) {
		
		
		
		if(rutinasBusqueda.size()==0) {
			
			
			lblMensaje.setText("NO HAY RUTINAS CARGADAS");
			Component[] components = panel.getComponents();
	        for (Component comp : components) {
	            if (comp instanceof JScrollPane) {
	                panel.remove(comp); 
	            }
	        }
	        
	        
	        panel.revalidate();
	        panel.repaint();
	        return null; 
			
		}
		
		
		
		
		
		
	    String[] columnNames = { "Seleccionar", "Titulo", "Dificultad", "Actividad", "Creador", "Popularidad" };

	    Object[][] data = new Object[rutinasBusqueda.size()][6];
	    for (int i = 0; i < rutinasBusqueda.size(); i++) {
	        Rutina rutina = rutinasBusqueda.get(i);
	        data[i][0] = false; // Asumiendo que la primera columna es para seleccionar
	        data[i][1] = rutina.getTitulo();
	        data[i][2] = rutina.getDificultad();
	        data[i][3] = rutina.getActividad_deportiva();
	        data[i][4] = rutina.getUsuario_creador();
	        data[i][5] = rutina.getPopularidad_rutina();
	    }

	    // Crear el modelo de tabla
	    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return column == 0; // Solo la columna "Seleccionar" es editable
	        }

	        @Override
	        public Class<?> getColumnClass(int column) {
	            return column == 0 ? Boolean.class : String.class;
	        }
	    };

	    // Eliminar los componentes previos de la tabla
	    Component[] components = panel.getComponents();
	    for (Component comp : components) {
	        if (comp instanceof JScrollPane) {
	            panel.remove(comp);
	        }
	    }

	    // Crear la nueva tabla y configurarla
	    JTable tablaRutinas = new JTable(tableModel);
	    tablaRutinas.getColumn("Seleccionar").setCellRenderer(new RadioButtonRenderer());
	    tablaRutinas.getColumn("Seleccionar").setCellEditor(new RadioButtonEditor(new JCheckBox(), tablaRutinas));

	    // Configuración de anchos de las columnas
	    int[] anchosColumnas = { 100, 200, 100, 150, 150, 100 };
	    for (int i = 0; i < tablaRutinas.getColumnCount(); i++) {
	        tablaRutinas.getColumnModel().getColumn(i).setPreferredWidth(anchosColumnas[i]);
	        tablaRutinas.getColumnModel().getColumn(i).setMinWidth(anchosColumnas[i]);
	        tablaRutinas.getColumnModel().getColumn(i).setMaxWidth(anchosColumnas[i]);
	    }

	    tablaRutinas.getTableHeader().setResizingAllowed(false);
	    tablaRutinas.getTableHeader().setReorderingAllowed(false);

	    // Crear el JScrollPane y agregarlo al panel
	    JScrollPane scrollPane = new JScrollPane(tablaRutinas);
	    scrollPane.setBounds(20, 100, 800, 100);
	    panel.add(scrollPane);

	    // Refrescar el panel
	    panel.revalidate();
	    panel.repaint();
	    
	    
	    
		return tablaRutinas;
	    
		}
	
	
	}


