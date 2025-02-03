package GUI;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.Ejercicio;
import BLL.EntradaYsalida;
import BLL.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agregar_ejercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	 private JPanel contentPane;
	    private JTextField textNombre, textSerie, textDescanso, textRepeticiones;
	    int puntos_progre_ejerci = 0; 
	    
	public Agregar_ejercicio(int id_rutina ,Usuario usser) {
		
        setTitle("Agregar Ejercicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);  
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
        setResizable(false); 
        setLocationRelativeTo(null);  
        setContentPane(contentPane);
        contentPane.setLayout(null);  


        JLabel labelNombre = new JLabel("Nombre del ejercicio:");
        labelNombre.setBounds(20, 20, 200, 25); 
        contentPane.add(labelNombre);

        textNombre = new JTextField();
        textNombre.setBounds(20, 50, 300, 25); 
        contentPane.add(textNombre);


        JLabel labelSerie = new JLabel("Cantidad total de series:");
        labelSerie.setBounds(20, 80, 200, 25);
        contentPane.add(labelSerie);

        textSerie = new JTextField();
        textSerie.setBounds(20, 110, 300, 25);
        contentPane.add(textSerie);

        
        JLabel labelDescanso = new JLabel("Tiempo de descanso (seg):");
        labelDescanso.setBounds(20, 140, 200, 25);
        contentPane.add(labelDescanso);

        textDescanso = new JTextField();
        textDescanso.setBounds(20, 170, 300, 25);
        contentPane.add(textDescanso);

       
        JLabel labelRepeticiones = new JLabel("Cantidad de repeticiones:");
        labelRepeticiones.setBounds(20, 200, 200, 25);
        contentPane.add(labelRepeticiones);

        textRepeticiones = new JTextField();
        textRepeticiones.setBounds(20, 230, 300, 25);
        contentPane.add(textRepeticiones);

        
        JButton buttonGuardar = new JButton("Agregar otro ejercicio");
        buttonGuardar.setBounds(98, 266, 211, 30);  
        contentPane.add(buttonGuardar);
        
        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Se ha creado la rutina");
        		Menu_rutina frame = new Menu_rutina(usser);
				frame.setVisible(true);
				dispose();
        		
        	}
        });
        btnFinalizar.setBounds(98, 307, 211, 30);
        contentPane.add(btnFinalizar);


        buttonGuardar.addActionListener(e -> {
            String nombre = textNombre.getText();
            String serie = textSerie.getText();
            String descanso = textDescanso.getText();
            String repeticiones = textRepeticiones.getText();

         
            if (!nombre.isEmpty() && !serie.isEmpty() && !descanso.isEmpty() && !repeticiones.isEmpty()) {
                try {
                    int series = Integer.parseInt(serie);
                    int descansoValue = Integer.parseInt(descanso);
                    int repeticionesValue = Integer.parseInt(repeticiones);
                

            
                    puntos_progre_ejerci += series * repeticionesValue; 
                    Ejercicio ejerc=new Ejercicio(nombre,series,repeticionesValue,descansoValue,puntos_progre_ejerci);
           
                    EntradaYsalida.AgregandoEjercicioRtis(ejerc,id_rutina);
                	Agregar_ejercicio frame = new Agregar_ejercicio(id_rutina ,usser);
    				frame.setVisible(true);
    				dispose();
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para series, descanso y repeticiones.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
