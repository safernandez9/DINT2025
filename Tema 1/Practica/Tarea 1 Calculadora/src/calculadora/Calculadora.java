package calculadora;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private String operacion = "";
    private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		
	        setTitle("Calculadora");
	        setSize(300, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        GridBagLayout gridBagLayout = new GridBagLayout();
	        gridBagLayout.columnWidths = new int[]{0, 0};
	        gridBagLayout.rowHeights = new int[]{0, 0, 0};
	        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	        gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	        getContentPane().setLayout(gridBagLayout);
	        
	        JPanel panel = new JPanel();
	        GridBagConstraints gbc_panel = new GridBagConstraints();
	        gbc_panel.weighty = 1.0;
	        gbc_panel.weightx = 1.0;
	        gbc_panel.fill = GridBagConstraints.BOTH;
	        gbc_panel.gridx = 0;
	        gbc_panel.gridy = 0;
	        getContentPane().add(panel, gbc_panel);
	        GridBagLayout gbl_panel = new GridBagLayout();
	        gbl_panel.columnWidths = new int[]{0, 0};
	        gbl_panel.rowHeights = new int[]{0, 0, 0};
	        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	        gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	        panel.setLayout(gbl_panel);
	        
	        textField = new JTextField();
	        GridBagConstraints gbc_textField = new GridBagConstraints();
	        gbc_textField.insets = new Insets(20, 20, 20, 20);
	        gbc_textField.fill = GridBagConstraints.BOTH;
	        gbc_textField.gridheight = 0;
	        gbc_textField.gridwidth = 0;
	        gbc_textField.gridx = 0;
	        gbc_textField.gridy = 0;
	        panel.add(textField, gbc_textField);
	        textField.setColumns(10);
	        
	        JPanel panel_1 = new JPanel();
	        FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
	        flowLayout_1.setVgap(0);
	        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	        gbc_panel_1.weighty = 5.0;
	        gbc_panel_1.fill = GridBagConstraints.BOTH;
	        gbc_panel_1.gridx = 0;
	        gbc_panel_1.gridy = 1;
	        getContentPane().add(panel_1, gbc_panel_1);
	        
	        String[] botones = {
	            "7","8","9","+",
	            "6","5","4","-",
	            "3","2","1","/",
	            "C","0","=","*"
	        };

	        for (String texto : botones) {
	            JButton boton = new JButton(texto);
	            boton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    manejarEntrada(texto);
	                }
	            });
	            panel.add(boton);
	        }

	
}
	
	
	private void manejarEntrada(String texto) {
        if (texto.equals("C")) {
            operacion = "";
            pantalla.setText("");
        } else if (texto.equals("=")) {
            try {
                // Evaluar la operación con ScriptEngine
                javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
                javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
                Object resultado = engine.eval(operacion);
                pantalla.setText(resultado.toString());
                operacion = resultado.toString(); // permite seguir calculando
            } catch (Exception ex) {
                pantalla.setText("Error");
                operacion = "";
            }
        } else {
            // Si se pulsa un operador y el último ya era operador, se reemplaza
            if ("+-*/".contains(texto)) {
                if (!operacion.isEmpty() && "+-*/".contains(operacion.substring(operacion.length()-1))) {
                    operacion = operacion.substring(0, operacion.length()-1) + texto;
                } else {
                    operacion += texto;
                }
            } else {
                operacion += texto;
            }
            pantalla.setText(operacion);
        }
    }

	
}