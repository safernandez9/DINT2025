package calculadora;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pantalla;
    private String operacion = "";

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
	        
	        // Pantalla
	        pantalla = new JTextField();
	        pantalla.setEditable(false);
	        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
	        add(pantalla, BorderLayout.NORTH);

	        // Panel de botones
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 4, 5, 5));
	        
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

	        add(panel, BorderLayout.CENTER);

	
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