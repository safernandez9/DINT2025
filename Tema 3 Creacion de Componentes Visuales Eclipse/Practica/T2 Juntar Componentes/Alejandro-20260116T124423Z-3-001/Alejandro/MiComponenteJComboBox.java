package componentePersonalizado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MiComponenteJComboBox extends JComboBox<String> {

	private boolean seleccionObligatoria = true;
	private String textoPorDefecto = "Seleccione una opción";
	private Color colorError = new Color(255, 200, 200);
	private Color colorNormal;

	// Guardamos las opciones reales
	private String[] opciones = new String[0];

	// =====================
	// CONSTRUCTOR VACÍO (NECESARIO PARA ECLIPSE)
	// =====================
	public MiComponenteJComboBox() {
		super();
		inicializar();
	}

	// =====================
	// CONSTRUCTOR CON OPCIONES
	// =====================
	public MiComponenteJComboBox(String[] opciones) {
		super();
		this.opciones = opciones;
		inicializar();
	}

	// =====================
	// INICIALIZACIÓN COMÚN
	// =====================
	private void inicializar() {
		colorNormal = getBackground();
		reconstruirItems();
		setSelectedIndex(0);
		addActionListener(validarSeleccionListener());
	}

	// =====================
	// RECONSTRUIR CONTENIDO
	// =====================
	private void reconstruirItems() {
		removeAllItems();
		addItem(textoPorDefecto);

		for (String opcion : opciones) {
			addItem(opcion);
		}
	}

	// =====================
	// VALIDACIÓN
	// =====================
	private ActionListener validarSeleccionListener() {
		return e -> validar();
	}

	private void validar() {
		if (!seleccionObligatoria) {
			setBackground(colorNormal);
			return;
		}

		String seleccion = (String) getSelectedItem();

		if (seleccion == null || seleccion.equals(textoPorDefecto)) {
			setBackground(colorError);
		} else {
			setBackground(colorNormal);
		}
	}

	// =====================
	// GETTERS Y SETTERS
	// =====================
	public boolean isSeleccionObligatoria() {
		return seleccionObligatoria;
	}

	public void setSeleccionObligatoria(boolean seleccionObligatoria) {
		this.seleccionObligatoria = seleccionObligatoria;
		validar();
	}

	public String getTextoPorDefecto() {
		return textoPorDefecto;
	}

	// 👇 ESTE YA FUNCIONA BIEN EN EL DISEÑADOR
	public void setTextoPorDefecto(String textoPorDefecto) {
		this.textoPorDefecto = textoPorDefecto;
		reconstruirItems();
		setSelectedIndex(0);
		validar();
	}

	public Color getColorError() {
		return colorError;
	}

	public void setColorError(Color colorError) {
		this.colorError = colorError;
		validar();
	}

	// =====================
	// MÉTODO ÚTIL
	// =====================
	public boolean esSeleccionValida() {
		String seleccion = (String) getSelectedItem();
		return seleccion != null && !seleccion.equals(textoPorDefecto);
	}

	// =====================
	// OPCIONAL: CAMBIAR OPCIONES
	// =====================
	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
		reconstruirItems();
		setSelectedIndex(0);
		validar();
	}
}
