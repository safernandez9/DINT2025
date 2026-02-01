package componentes;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BotonPersonalizado extends JButton {

	private static final long serialVersionUID = 1L;
	private int numPulsaciones = 0;
	private int maxPulsaciones = 5;

	public BotonPersonalizado() {
		super("Púlsame");
		inicializarPropiedades();
		configurarListeners();
	}

	/**
	 * Inicializar propiedades visuales del botón
	 */
	private void inicializarPropiedades() {

		setBackground(new Color(70, 130, 180));
		setFont(new Font("Arial", Font.BOLD, 14));
		setFocusPainted(false);
	}

	/**
	 * Configurar Listeners del botón (addMouseListener, ActionListener)
	 */
	private void configurarListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(70, 130, 180));
			}
		});

		addActionListener(e -> {
			contabilizarPulsaciones();
		});
	}

	/**
	 * Acción al pulsar el botón: contabilizar pulsaciones y mostrar toast
	 */
	private void contabilizarPulsaciones() {
		
	
		
		numPulsaciones = (numPulsaciones < maxPulsaciones) ? numPulsaciones + 1 : numPulsaciones;

		if (numPulsaciones >= maxPulsaciones) {
			setEnabled(false);
		}

	}

	/**
	 * Resetear contador de pulsaciones y habilitar botón
	 */
	public void resetPulsaciones() {
		numPulsaciones = 0;
		setEnabled(true);
	}

	// Getters y Setters

	public int getMaxPulsaciones() {
		return maxPulsaciones;
	}

	public void setMaxPulsaciones(int maxPulsaciones) {
		this.maxPulsaciones = maxPulsaciones;
	}

}
	

