package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.EjerciciosControlador;
import Model.Ejercicio;
import Model.Rutina;

public class ver_ejercicios_index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	
	public ver_ejercicios_index(Rutina rutinaSeleccionada ,String volver,int id_usuario) {
		setTitle("Buscar");
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
		
		JLabel lblMensajeEjercicio= new JLabel("");
		lblMensajeEjercicio.setBackground(new Color(240, 240, 240));
		lblMensajeEjercicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeEjercicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeEjercicio.setForeground(Color.PINK);
		lblMensajeEjercicio.setBounds(138, 141, 528, 65);
		panel.add(lblMensajeEjercicio);
		
	
		JLabel lblEjerciciostitle= new JLabel("Rutina :"+ rutinaSeleccionada.getTitulo());
		lblEjerciciostitle.setBackground(new Color(240, 240, 240));
		lblEjerciciostitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblEjerciciostitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEjerciciostitle.setForeground(new Color(255, 255, 255));
		lblEjerciciostitle.setBounds(140, 22, 228, 33);
		panel.add(lblEjerciciostitle);
		
		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				if(volver.equals("I") && id_usuario==0) {
					
					buscar_index frame = new buscar_index();
					frame.setVisible(true);
					dispose();
				}else {
					
					buscar_menu frame = new buscar_menu(id_usuario);
					frame.setVisible(true);
					dispose();
				}
					
			
				

			}
		});
		
		
		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(773, 31, 40, 30);
		panel.add(btnAtras);
		
		JLabel lblMisEjercicios= new JLabel("MIS EJERCICIOS");
		lblMisEjercicios.setBackground(new Color(240, 240, 240));
		lblMisEjercicios.setHorizontalAlignment(SwingConstants.CENTER);
		lblMisEjercicios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMisEjercicios.setForeground(Color.PINK);
		lblMisEjercicios.setBounds(335, 66, 160, 36);
		panel.add(lblMisEjercicios);
		
		
		ArrayList<Ejercicio>ejercicios=EjerciciosControlador.obteniendoEjerciciosDeLaRutina(rutinaSeleccionada.getId_rutina());
		
		if(!ejercicios.isEmpty()) {
			
			String[] column_nombres = { "Nombre", "Serie", "Repeticiones", "Descanso" };
			Object[][] data = new Object[ejercicios.size()][4];
			
			for (int i = 0; i < ejercicios.size(); i++) {
				Ejercicio ejercicio = ejercicios.get(i);
				data[i][0] = ejercicio.getNombre();
				data[i][1] = ejercicio.getSerie();
				data[i][2] = ejercicio.getRepeteticiones();
				data[i][3] = ejercicio.getDescanso();
			}

			  DefaultTableModel tableModel = new DefaultTableModel(data, column_nombres) {
			        @Override
			        public boolean isCellEditable(int row, int column) {
			            return false; 
			        }
			    };
			
				JTable tablaRutinas = new JTable(tableModel);
				tablaRutinas.setBounds(30, 50, 550, 100);
				
				 int[] anchosColumnas = {180, 100, 130, 130}; 
				 
				    for (int i = 0; i < tablaRutinas.getColumnCount(); i++) {
				        tablaRutinas.getColumnModel().getColumn(i).setPreferredWidth(anchosColumnas[i]);
				        tablaRutinas.getColumnModel().getColumn(i).setMinWidth(anchosColumnas[i]);
				        tablaRutinas.getColumnModel().getColumn(i).setMaxWidth(anchosColumnas[i]);
				    }

				    tablaRutinas.getTableHeader().setResizingAllowed(false);
				    tablaRutinas.getTableHeader().setReorderingAllowed(false);
				    
				    
				JScrollPane scrollPane = new JScrollPane(tablaRutinas);
				scrollPane.setBounds(140, 100, 540, 200);

				panel.add(scrollPane);
				panel.revalidate();
				panel.repaint();
			
		}else {
			lblMensajeEjercicio.setText("LA RUTINA SELECCIONADA NO PRESENTA EJERCICIOS");
			
		}
		
		
	}
	
	
	

}
