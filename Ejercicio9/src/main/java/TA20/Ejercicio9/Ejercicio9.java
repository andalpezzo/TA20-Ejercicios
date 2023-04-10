package TA20.Ejercicio9;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Ejercicio9 extends JFrame {

	private JPanel contentPane;
	JButton btn1, btn2, btn3 , btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
	private String[] dibujos = {"★", "✿", "☺", "♡", "👁", "🖍", "☾", "☀"};

	/**
	 * Create the frame.
	 */
	public Ejercicio9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 2, 2));
		
		btn1 = new JButton("");
		btn1.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn1);
		
		btn2 = new JButton("");
		btn2.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn2);
		
		btn3 = new JButton("");
		btn3.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn3);
		
		btn4 = new JButton("");
		btn4.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn4);
		
		btn5 = new JButton("");
		btn5.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn5);
		
		btn6 = new JButton("");
		btn6.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn6);
		
		btn7 = new JButton("");
		btn7.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn7);
		
		btn8 = new JButton("");
		btn8.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn8);
		
		btn9 = new JButton("");
		btn9.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn9);
		
		btn10 = new JButton("");
		btn10.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn10);
		
		btn11 = new JButton("");
		btn11.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn11);
		
		btn12 = new JButton("");
		btn12.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn12);
		
		btn13 = new JButton("");
		btn13.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn13);
		
		btn14 = new JButton("");
		btn14.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn14);
		
		btn15 = new JButton("");
		btn15.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn15);
		
		btn16 = new JButton("");
		btn16.setFont(new Font("", Font.PLAIN, 50));
		contentPane.add(btn16);
		
		llenarBotones();
		
		setVisible(true);
	}

	public void llenarBotones() {
		int index;
		ArrayList<String> dibujosRnd = new ArrayList<String>();
		
		Random rnd = new Random();
		
		for(int i=0; i <= 16; i++) {
			index = rnd.nextInt(dibujos.length);
			dibujosRnd.add(dibujos[index]);
			System.out.println(dibujosRnd.get(i));
			
			if(i > 0) {
				for(int x=0; x < dibujosRnd.size(); x++) {
					if(dibujosRnd.get(i) == dibujosRnd.get(x)) {
						i--;
					}
				}
			}
		}		
	
		/*btn1.setText(dibujosRnd[0]);
		btn2.setText(dibujosRnd[1]);
		btn3.setText(dibujosRnd[2]);
		btn4.setText(dibujosRnd[3]);
		btn5.setText(dibujosRnd[4]);
		btn6.setText(dibujosRnd[5]);
		btn7.setText(dibujosRnd[6]);
		btn8.setText(dibujosRnd[7]);
		btn9.setText(dibujosRnd[8]);
		btn10.setText(dibujosRnd[9]);
		btn11.setText(dibujosRnd[10]);
		btn12.setText(dibujosRnd[11]);
		btn13.setText(dibujosRnd[12]);
		btn14.setText(dibujosRnd[13]);
		btn15.setText(dibujosRnd[14]);
		btn16.setText(dibujosRnd[15]);*/
	}
}