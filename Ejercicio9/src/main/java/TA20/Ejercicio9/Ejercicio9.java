package TA20.Ejercicio9;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class Ejercicio9 extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private JButton primerBtn;
	private JButton clickedBtn;
	private int contDibujos = 0;
	private int contClickados = 0;
	private int parejasFormadas = 0;
	private JLabel lblHasGanado;
	private ArrayList<String> dibujosRnd = new ArrayList<String>();
	private String dibujoRandom = "";
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
		
		generarBotones();
		setVisible(true);
	}
	
	public String dibujoRandom() {
		contDibujos++;
		Random rnd = new Random();
		int index = rnd.nextInt(dibujos.length);
		
		while (dibujosRnd.contains(dibujos[index])) {
			index = rnd.nextInt(dibujos.length);
		}
		
		dibujosRnd.add(dibujos[index]);
		dibujoRandom = dibujos[index];
		
		if(contDibujos == 8) {
			dibujosRnd.clear();
		}
		
		System.out.println(dibujosRnd.toString());
		return dibujoRandom;
	}
	
	public void generarBotones() {
		for (int i=0; i < 16; i++) {
			btn = new JButton("");
			btn.setFont(new Font("", Font.PLAIN, 50));
			btn.setForeground(new Color(0,0,0, 0));
			//Llenamos cada boton con un dibujo generado de manera random
			btn.setText(dibujoRandom());
			btn.addActionListener(clicked);
			btn.putClientProperty("btnIndex", 0);
			contentPane.add(btn);
		}
	}
	
	//Eventos del los botones
	ActionListener clicked = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("btn clicked");
			
			primerBtn = clickedBtn;
			clickedBtn = (JButton) e.getSource();
			int btnIndex = (int) clickedBtn.getClientProperty("btnIndex");
			
			clickedBtn.putClientProperty("btnIndex", btnIndex);
			clickedBtn.setForeground(Color.black);
			
			contClickados ++;
			
			//Contamos si se han clickado 2 botones para comparar los dibujos
			if(contClickados == 2) {
				primerBtn.setForeground(Color.black);
				
				if(primerBtn.getText() == clickedBtn.getText()) {
					//Si son iguales los desabilitamos para que no se puedan clickar
					clickedBtn.setEnabled(false);
					primerBtn.setEnabled(false);
				
					parejasFormadas++;
					if(parejasFormadas == 8) {
						final JDialog dialog = new JDialog();  
						setDefaultCloseOperation(dialog.EXIT_ON_CLOSE);
						lblHasGanado = new JLabel("¡HAS GANADO!");
						lblHasGanado.setHorizontalAlignment(JLabel.CENTER);
					    dialog.setSize(200, 100);
					    dialog.setUndecorated(true);
					    dialog.setLocationRelativeTo(contentPane);
					    ((JComponent) dialog.getContentPane()).setOpaque(true);
					    dialog.getContentPane().setBackground(new Color(193, 219, 245));
					    Border raisedbevel = BorderFactory.createRaisedBevelBorder();
					    dialog.getRootPane().setBorder(raisedbevel);
					    dialog.add(lblHasGanado);
					    dialog.setVisible(true);
					  }
				} else {
					//Hacemos un delay de 1 segundo para que nos de tiempo de mirar que dibujos habia
					new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	//Si no eran iguales ponemos el dibujo en transparente
				            	clickedBtn.setForeground(new Color(0,0,0, 0));
								primerBtn.setForeground(new Color(0,0,0, 0));
				            }
				        }, 
				        800 
					);
				}
				contClickados = 0;
			}
		}
	};
}

