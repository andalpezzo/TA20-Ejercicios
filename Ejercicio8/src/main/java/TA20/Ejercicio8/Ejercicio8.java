package TA20.Ejercicio8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComponentInputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class Ejercicio8 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtResultado;
	private JButton btnEurosPtas;
	private JButton btnPtasEuros;
	private JButton btnCambiar;
	private JButton btnBorrar;
	private double cantidad;
	private final double euro = 166.386;

	/**
	 * Create the frame.
	 */
	public Ejercicio8() {
		setTitle("Calculadora cambio de monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCantidad = new JLabel("Cantidad a covertir");
		lblCantidad.setBounds(10, 11, 133, 23);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(122, 12, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(218, 11, 83, 23);
		contentPane.add(lblResultado);

		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(283, 12, 105, 20);
		contentPane.add(txtResultado);

		btnEurosPtas = new JButton("Euros a ptas");
		btnEurosPtas.addActionListener(cambiarBtn);
		btnEurosPtas.setBounds(20, 45, 113, 23);
		contentPane.add(btnEurosPtas);

		btnPtasEuros = new JButton("Ptas a Euro");
		btnPtasEuros.addActionListener(cambiarBtn);
		btnPtasEuros.setBounds(20, 45, 113, 23);
		contentPane.add(btnPtasEuros);

		btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(cambiar);
		btnCambiar.setBounds(143, 45, 113, 23);
		contentPane.add(btnCambiar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(borrar);
		btnBorrar.setBounds(266, 45, 113, 23);
		contentPane.add(btnBorrar);

		eventosTeclado();
		
		setVisible(true);
	}

	ActionListener cambiarBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnEurosPtas)) {
				btnEurosPtas.setVisible(true);
				btnPtasEuros.setVisible(false);
			} else {
				btnEurosPtas.setVisible(false);
				btnPtasEuros.setVisible(true);
			}
		}
	};

	ActionListener cambiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtResultado.setText("");
			double conversion = 0.0;

			if (e.getSource().equals(btnCambiar)) {
				if (btnEurosPtas.isVisible()) {
					cantidad = Double.parseDouble(txtCantidad.getText());
					conversion = Math.round((euro * cantidad) * 100d) / 100d;
					txtResultado.setText("" + conversion);
				} else {
					conversion = Math.round((cantidad / euro) * 100d) / 100d;
					txtResultado.setText("" + conversion);
				}
			}
		}
	};
	
	ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnBorrar)) {
				txtCantidad.setText("");
				txtResultado.setText("");
			}
		}
	};

	private void eventosTeclado() {
		//Usaremos ComponentInputMap para los eventos de teclado
		ComponentInputMap entradaTeclado = new ComponentInputMap(contentPane);
		contentPane.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, entradaTeclado);

		//Creamos las conbinaciones de teclas
		KeyStroke ctrlE = KeyStroke.getKeyStroke("ctrl E");
		KeyStroke ctrlP = KeyStroke.getKeyStroke("ctrl P");
		KeyStroke ctrlM = KeyStroke.getKeyStroke("ctrl M");
		KeyStroke ctrlB = KeyStroke.getKeyStroke("ctrl B");

		//Asignamos las conbinaciones a los botones
		entradaTeclado.put(ctrlE, "EuroPtas");
		entradaTeclado.put(ctrlP, "PtasEuro");
		entradaTeclado.put(ctrlM, "Cambiar");
		entradaTeclado.put(ctrlB, "Borrar");

		ActionMap mapaAccion = contentPane.getActionMap();
		
		//Para que btnEurosPtas responda a los eventos de teclado
		mapaAccion.put("EuroPtas", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				cambiarBtn.actionPerformed(new ActionEvent(btnEurosPtas, ActionEvent.ACTION_PERFORMED, null));
			}
		});
		
		//Para que btnPtasEuro responda a los eventos de teclado
	    mapaAccion.put("PtasEuro", new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	        	cambiarBtn.actionPerformed(new ActionEvent(btnPtasEuros, ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	  	    
	    //Para que btnCambiar responda a los eventos de teclado
	    mapaAccion.put("Cambiar", new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	            cambiar.actionPerformed(new ActionEvent(btnCambiar, ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	    
	    //Para que btnBorrar responda a los eventos de teclado
	    mapaAccion.put("Borrar", new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	            borrar.actionPerformed(new ActionEvent(btnBorrar, ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	}
}