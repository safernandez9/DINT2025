//Saúl Fernández Salgado

package calculadora;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import javax.swing.*;

public class Calculadora extends JFrame {


	private static final long serialVersionUID = 1L;
	private JTextField pantalla;
	private String operacionActual = ""; // cadena que muestra la operación (con espacios entre tokens)
	private boolean mostrarResultado = false; // si se mostró un resultado y el siguiente número debe reemplazar

	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(6, 6));

		// PANTALLA (muestra siempre la operación en curso)
		pantalla = new JTextField();
		pantalla.setEditable(false);
		pantalla.setFont(new Font("SansSerif", Font.BOLD, 26));
		pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		pantalla.setPreferredSize(new Dimension(0, 70));
		pantalla.setBackground(Color.WHITE);
		add(pantalla, BorderLayout.NORTH);

		// PANEL DE BOTONES (5 filas x 4 columnas)
		JPanel panelBotones = new JPanel(new GridLayout(5, 4, 8, 8));
		panelBotones.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
		add(panelBotones, BorderLayout.CENTER);

		String[] botones = { "7", "8", "9", "+", "6", "5", "4", "-", "3", "2", "1", "/", "C", "0", "=", "X" };

		for (String texto : botones) {
			JButton boton = new JButton(texto);
			boton.setFont(new Font("SansSerif", Font.BOLD, 20));
			boton.setFocusPainted(false);
			// Colores aproximados según la imagen
			if (texto.equals("C")) {
				boton.setBackground(new Color(255, 182, 193)); // rosita
			} else if (texto.equals("=")) {
				boton.setBackground(new Color(180, 255, 200)); // verde claro
			} else if ("+-/X".contains(texto)) {
				boton.setBackground(new Color(224, 176, 255)); // lila
			} else {
				boton.setBackground(new Color(174, 214, 241)); // azul claro para números
			}
			boton.setOpaque(true);
			boton.setBorderPainted(false);
			panelBotones.add(boton);

			// Listener sencillo
			boton.addActionListener(e -> manejarEntrada(texto));
		}
	}

	// Manejo de entradas de botones
	private void manejarEntrada(String entrada) {
		if (entrada.matches("[0-9]")) {
			// Si anteriormente mostramos un resultado y el usuario introduce un número,
			// comenzamos nueva operación
			if (mostrarResultado) {
				operacionActual = "";
				mostrarResultado = false;
			}
			operacionActual += entrada;
			pantalla.setText(operacionActual);
		} else if (entrada.matches("[+\\-X/]")) {
			// No permitimos empezar por operador vacío
			if (operacionActual.isEmpty())
				return;

			// Si ya hay un operador al final, lo reemplazamos
			if (ultimoEsOperador()) {
				operacionActual = operacionActual.substring(0, operacionActual.length() - 3) + " " + entrada + " ";
			} else {
				operacionActual += " " + entrada + " ";
			}
			pantalla.setText(operacionActual);
			mostrarResultado = false;
		} else if (entrada.equals("=")) {
			// Si está vacía o termina en operador, quitamos el operador final antes de
			// evaluar
			if (operacionActual.isEmpty())
				return;
			if (ultimoEsOperador()) {
				// quitar el operador final (" <op> ")
				operacionActual = operacionActual.substring(0, operacionActual.length() - 3).trim();
			}
			try {
				String resultado = evaluarExpresion(operacionActual);
				pantalla.setText(resultado);
				operacionActual = resultado; // permitir continuar operaciones con el resultado
				mostrarResultado = true;
			} catch (Exception ex) {
				pantalla.setText("Error");
				operacionActual = "";
				mostrarResultado = false;
			}
		} else if (entrada.equals("C")) {
			operacionActual = "";
			pantalla.setText("");
			mostrarResultado = false;
		}
	}

	// Comprueba si la operación acaba con " <op> " (espacio, operador, espacio)
	private boolean ultimoEsOperador() {
		return operacionActual.endsWith(" + ") || operacionActual.endsWith(" - ") || operacionActual.endsWith(" X ")
				|| operacionActual.endsWith(" / ");
	}

	// Evalúa la expresión en formato "Número [op Número]..."
	// Soporta operadores: +, -, X (o *), /
	// Aplica precedencia: primero X y /, luego + y -
	private String evaluarExpresion(String expr) throws Exception {
		expr = expr.trim();
		if (expr.isEmpty())
			throw new Exception("Vacía");

		String[] partes = expr.split("\\s+");
		ArrayList<String> tokens = new ArrayList<>(Arrays.asList(partes));

		// Primera pasada: multiplicación y división
		int i = 1;
		while (i < tokens.size() - 1) {
			String op = tokens.get(i);
			if (op.equals("X") || op.equals("*") || op.equals("/")) {
				BigDecimal a = new BigDecimal(tokens.get(i - 1));
				BigDecimal b = new BigDecimal(tokens.get(i + 1));
				BigDecimal r;
				if (op.equals("X") || op.equals("*")) {
					r = a.multiply(b);
				} else {
					if (b.compareTo(BigDecimal.ZERO) == 0)
						throw new ArithmeticException("División por cero");
					r = a.divide(b, 10, RoundingMode.HALF_UP);
				}
				// Reemplaza [i-1, i, i+1] por resultado
				tokens.set(i - 1, r.stripTrailingZeros().toPlainString());
				tokens.remove(i); // operador
				tokens.remove(i); // segundo operando (ahora en la misma posición)
				i = 1; // reinicia para buscar de nuevo
			} else {
				i += 2;
			}
		}

		// Segunda pasada: suma y resta
		i = 1;
		while (i < tokens.size() - 1) {
			String op = tokens.get(i);
			BigDecimal a = new BigDecimal(tokens.get(i - 1));
			BigDecimal b = new BigDecimal(tokens.get(i + 1));
			BigDecimal r;
			if (op.equals("+")) {
				r = a.add(b);
			} else if (op.equals("-")) {
				r = a.subtract(b);
			} else {
				throw new Exception("Operador desconocido: " + op);
			}
			tokens.set(i - 1, r.stripTrailingZeros().toPlainString());
			tokens.remove(i);
			tokens.remove(i);
			i = 1;
		}

		// Resultado final
		return tokens.get(0);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Calculadora calc = new Calculadora();
			calc.setVisible(true);
		});

	}
}

	
