package TA20.Ejercicio2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio2 extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JLabel lblBtnClicked;

	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		setTitle("Ventana con interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 87);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBtnClicked = new JLabel("Has pulsado: ");
		lblBtnClicked.setBounds(10, 11, 124, 27);
		contentPane.add(lblBtnClicked);

		btn1 = new JButton("Boton 1");
		btn1.addActionListener(clicked);
		btn1.setBounds(144, 13, 89, 23);
		contentPane.add(btn1);

		btn2 = new JButton("Boton 2");
		btn2.addActionListener(clicked);
		btn2.setBounds(238, 13, 89, 23);
		contentPane.add(btn2);

		setVisible(true);
	}

	ActionListener clicked = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btn1)) {
				lblBtnClicked.setText("Has pulsado: " + btn1.getText().toString());
			} else {
				lblBtnClicked.setText("Has pulsado: " + btn2.getText().toString());
			}
		}
	};
}
