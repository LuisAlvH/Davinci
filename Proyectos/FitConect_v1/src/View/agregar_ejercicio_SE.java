package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.EjerciciosControlador;
import Controller.RutinasControlador;
import Model.Ejercicio;
import Model.Rutina;
import java.awt.Font;

public class agregar_ejercicio_SE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre, textSerie, textDescanso, textRepeticiones;
	int puntos_progre_ejerci = 0;


	public agregar_ejercicio_SE(int id_usuario, Rutina ruti ,String volver) {
		setTitle("Agregar ejercicio");
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

		ImageIcon iconoAtras = new ImageIcon(login.class.getResource("/img/flecha-atras.png"));
		Image scaledAtras = iconoAtras.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(scaledAtras));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String serie = textSerie.getText();
				String descanso = textDescanso.getText();
				String repeticiones = textRepeticiones.getText();
				
				if (!nombre.isEmpty() || !serie.isEmpty() ||  !descanso.isEmpty() ||  !repeticiones.isEmpty()) {
					
					
					int confirmacion = JOptionPane.showConfirmDialog(null,
							"Esta seguro de volver atras? [perdera la informacion]", "Confirmar acción",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (confirmacion == JOptionPane.YES_OPTION) {
						mod_ejercicio frame = new mod_ejercicio(ruti,id_usuario,volver);
						frame.setVisible(true);
						dispose();
			
					}
					
					
					
					
				}else {
					
					mod_ejercicio frame = new mod_ejercicio(ruti,id_usuario,volver);
					frame.setVisible(true);
					dispose();
					
				}
				

				

			}
		});

		btnAtras.setBackground(new Color(128, 128, 192));
		btnAtras.setBorder(null);
		btnAtras.setBounds(763, 32, 40, 30);

		panel.add(btnAtras);

		JLabel labelNombre = new JLabel("Nombre del ejercicio:");
		labelNombre.setForeground(new Color(255, 255, 255));
		labelNombre.setFont(new Font("Roboto", Font.BOLD, 14));
		labelNombre.setBounds(259, 25, 200, 25);
		panel.add(labelNombre);

		textNombre = new JTextField();
		textNombre.setBounds(259, 51, 300, 25);
		panel.add(textNombre);

		JLabel labelSerie = new JLabel("Cantidad total de series:");
		labelSerie.setForeground(new Color(255, 255, 255));
		labelSerie.setBackground(new Color(255, 255, 255));
		labelSerie.setFont(new Font("Roboto", Font.BOLD, 14));
		labelSerie.setBounds(259, 74, 200, 25);
		panel.add(labelSerie);

		textSerie = new JTextField();
		textSerie.setBounds(259, 100, 300, 25);
		panel.add(textSerie);

		JLabel labelDescanso = new JLabel("Tiempo de descanso (seg):");
		labelDescanso.setForeground(new Color(255, 255, 255));
		labelDescanso.setFont(new Font("Roboto", Font.BOLD, 14));
		labelDescanso.setBounds(259, 124, 200, 25);
		panel.add(labelDescanso);

		textDescanso = new JTextField();
		textDescanso.setBounds(259, 149, 300, 25);
		panel.add(textDescanso);

		JLabel labelRepeticiones = new JLabel("Cantidad de repeticiones:");
		labelRepeticiones.setFont(new Font("Roboto", Font.BOLD, 14));
		labelRepeticiones.setForeground(new Color(255, 255, 255));
		labelRepeticiones.setBounds(259, 173, 200, 25);
		panel.add(labelRepeticiones);

		textRepeticiones = new JTextField();
		textRepeticiones.setBounds(259, 198, 300, 25);
		panel.add(textRepeticiones);

		JButton btnAgregarEjercicio = new JButton("Agregar  otro ejercicio");
		btnAgregarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						Ejercicio ejer = new Ejercicio();
						ejer.setNombre(nombre);
						ejer.setSerie(series);
						ejer.setRepeteticiones(repeticionesValue);
						ejer.setDescanso(descansoValue);
						ejer.setPuntos_progre_ejerci(puntos_progre_ejerci);

						if (ruti.getId_rutina() != 0) {

							EjerciciosControlador.agregarEjercicioNuevoAlaRutina(ejer, ruti.getId_rutina());
							JOptionPane.showMessageDialog(null, textNombre.getText()+" ha sido agregado", "INFOMARCION",
									JOptionPane.INFORMATION_MESSAGE);
							
							

						} 
						textNombre.setText("");
						textSerie.setText("");
						textDescanso.setText("");
						textRepeticiones.setText("");

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Por favor, ingrese valores numéricos válidos para series, descanso y repeticiones.",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnAgregarEjercicio.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnAgregarEjercicio.setForeground(new Color(255, 128, 64));
		btnAgregarEjercicio.setBackground(new Color(226, 226, 226));
		btnAgregarEjercicio.setBounds(284, 259, 254, 41);
		panel.add(btnAgregarEjercicio);

	}

}