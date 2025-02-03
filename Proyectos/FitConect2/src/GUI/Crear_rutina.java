package GUI;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.EntradaYsalida;
import BLL.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crear_rutina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	    private JTextArea textAreaRutinas;

	public Crear_rutina(Usuario usser) {
		   setTitle("Crear rutina");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(100, 100, 450, 300);
		    contentPane = new JPanel();
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setResizable(false);
		    setLocationRelativeTo(null);
		    setContentPane(contentPane);
		    contentPane.setLayout(null);

		    JLabel labelTitulo = new JLabel("Título de la rutina:");
		    labelTitulo.setBounds(20, 30, 150, 25);
		    contentPane.add(labelTitulo);

		    JLabel labelActividad = new JLabel("Actividad deportiva:");
		    labelActividad.setBounds(20, 70, 150, 25);
		    contentPane.add(labelActividad);

		    JTextField textTitulo = new JTextField();
		    textTitulo.setBounds(180, 30, 200, 25);
		    contentPane.add(textTitulo);

		    JTextField textActividad = new JTextField();
		    textActividad.setBounds(180, 70, 200, 25);
		    contentPane.add(textActividad);
		    
		    JLabel labelDificultad = new JLabel("Dificultad:");
		    labelDificultad.setBounds(20, 110, 150, 25);  // Ajustado para mejor visibilidad
		    contentPane.add(labelDificultad);

		    JTextField textDificultad = new JTextField();
		    textDificultad.setBounds(180, 110, 200, 25);  // Ajustado para mejor visibilidad
		    contentPane.add(textDificultad);

		    JButton buttonAgregar = new JButton("Agregar Ejercicio");
		    buttonAgregar.setBounds(20, 171, 150, 30);
		    contentPane.add(buttonAgregar);
		    
		    JButton btnVolver = new JButton("Volver");
		    btnVolver.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 Menu_rutina frame = new Menu_rutina( usser);
		                frame.setVisible(true);
		                dispose();
		    		
		    	}
		    	
		    });
		    btnVolver.setBounds(220, 171, 150, 30);
		    contentPane.add(btnVolver);

		    buttonAgregar.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            // Validación de los campos
		            if (textTitulo.getText().isEmpty() || textActividad.getText().isEmpty() || textDificultad.getText().isEmpty()) {
		                // Si algún campo está vacío, mostrar un mensaje de advertencia
		                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		            } else {
		                // Si todos los campos están completos, guardar la rutina
		                int id_rutina = EntradaYsalida.GuardandoRutinaInicial(usser.getIdUsuario(), textActividad.getText(),
		                        textTitulo.getText(), textDificultad.getText(), 0, 0);

		                // Abrir la siguiente ventana (Agregar ejercicio)
		                Agregar_ejercicio frame = new Agregar_ejercicio(id_rutina, usser);
		                frame.setVisible(true);
		                dispose();
		            }
		        }
		    });
		}
}
