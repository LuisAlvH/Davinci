package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.RutinasControlador;
import Controller.usuarioControlador;
import Model.Rutina;

import javax.swing.UIManager;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public index() {
	setTitle("index");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 850, 394);
		setLocationRelativeTo(null);///CENTRA LA VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 587, 355);
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitleFitconect = new JLabel("Fit conect");
		lblTitleFitconect.setForeground(new Color(255, 128, 64));
		lblTitleFitconect.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblTitleFitconect.setBounds(10, 42, 188, 27);
		panel.add(lblTitleFitconect);
		Border border = new LineBorder(new Color(255, 128, 64), 1, true);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 128, 64));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnSalir.setBackground(new Color(128, 128, 192));
		btnSalir.setBounds(644, 305, 164, 23);
		
		btnSalir.setBorder(border);
		contentPane.add(btnSalir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar_index frame = new buscar_index();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnBuscar.setForeground(new Color(255, 128, 64));
		btnBuscar.setBackground(new Color(128, 128, 192));
		btnBuscar.setBounds(644, 141, 164, 23);
		btnBuscar.setBorder(border);
		contentPane.add(btnBuscar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 128, 64));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBackground(new Color(128, 128, 192));
		btnLogin.setBounds(644, 107, 164, 23);
		btnLogin.setBorder(border);
		contentPane.add(btnLogin);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensaje.setForeground(Color.PINK);
		lblMensaje.setBounds(35, 75, 353, 65);
		panel.add(lblMensaje);
		
		
		ArrayList<Rutina> rutinasCompartidas =RutinasControlador.obteniendoRutinasCompartidas();
		
		if (rutinasCompartidas == null || rutinasCompartidas.isEmpty()) {
			lblMensaje.setText("No hay rutinas cargadas....");
		}else {
			String[] columnas_nombres = { "Titulo", "Dificultad", "Actividad", "Creador" };
			Object[][] data = new Object[rutinasCompartidas.size()][4];
			
			for (int i = 0; i < rutinasCompartidas.size(); i++) {
				Rutina rutina = rutinasCompartidas.get(i);
				if (rutina != null) {
					data[i][0] = rutina.getTitulo();
					data[i][1] = rutina.getDificultad();
					data[i][2] = rutina.getActividad_deportiva();
					data[i][3] = rutina.getUsuario_creador();
				} 
			}
			
			

		    DefaultTableModel tableModel = new DefaultTableModel(data, columnas_nombres) {
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
			scrollPane.setBounds(10, 100, 550, 200);

			panel.add(scrollPane);
			panel.revalidate();
			panel.repaint();
		}
		
	}
}
