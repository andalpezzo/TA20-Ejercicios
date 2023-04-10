package TA20.Ejercicio3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio3 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl1, lbl2;
	private JButton btn1, btn2;
	private int contBoton1 = 1;
	private int contBoton2 = 1;

	/**
	 * Create the frame.
	 */
	public Ejercicio3() {
		setTitle("Ventana con más interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl1 = new JLabel("Boton 1: ");
		lbl1.setBounds(34, 11, 120, 25);
		contentPane.add(lbl1);

		lbl2 = new JLabel("Boton 2: ");
		lbl2.setBounds(164, 11, 120, 25);
		contentPane.add(lbl2);

		btn1 = new JButton("Boton 1");
		btn1.addActionListener(btnClicked);
		btn1.setBounds(34, 35, 120, 23);
		contentPane.add(btn1);

		btn2 = new JButton("Boton 2");
		btn2.addActionListener(btnClicked);
		btn2.setBounds(164, 35, 120, 23);
		contentPane.add(btn2);

		setVisible(true);
	}

	ActionListener btnClicked = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btn1)) {
				lbl1.setText("Boton 1: " + (contBoton1++) + " veces");
			} else {
				lbl2.setText("Boton 2: " + (contBoton2++) + " veces"); 
			}
		}
	};
}
