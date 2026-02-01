package tarea2;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import componentePersonalizado.MiComponenteJComboBox;
import componentes.BotonPersonalizado;
import crearComponente.Advanced_JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Tarea2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel lstElementosModel;
	MiComponenteJComboBox combCategorias;
	DefaultComboBoxModel cmbCategoriasModel;
	ArrayList<String> elementosDefault = new ArrayList<String>();
	private boolean panelDependeCombo = true;
	private boolean mostrarResumenAlConfirmar = true;
	private Advanced_JList lstElementos;
	private BotonPersonalizado btnSeguro;
	private int nSeleccionesGrados = 3;
	private JLabel lblGrado;
	private JLabel lblUniversidad;
	private ArrayList opcionesFinales = new ArrayList();
	private int pulsacionesActuales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea2 frame = new Tarea2();
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
	public Tarea2() {

		setTitle("Seleccion por Categorías");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[] { 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };
		panel.setLayout(gbl_panel);

		// Categorías

		lblUniversidad = new JLabel("Seleccione una categoría");
		GridBagConstraints gbc_lblUniversidad = new GridBagConstraints();
		gbc_lblUniversidad.insets = new Insets(5, 0, 5, 0);
		gbc_lblUniversidad.gridx = 0;
		gbc_lblUniversidad.gridy = 0;
		panel.add(lblUniversidad, gbc_lblUniversidad);

		combCategorias = new MiComponenteJComboBox();
		GridBagConstraints gbc_combUniversidades = new GridBagConstraints();
		gbc_combUniversidades.insets = new Insets(0, 0, 5, 0);
		gbc_combUniversidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_combUniversidades.gridx = 0;
		gbc_combUniversidades.gridy = 1;
		panel.add(combCategorias, gbc_combUniversidades);
		combCategorias.addActionListener(e -> {
			actualizarEstadoPanel();
		});

		cmbCategoriasModel = (DefaultComboBoxModel) combCategorias.getModel();
		cargarDefaultCategorias();
		combCategorias.addActionListener(e -> {
			actualizarEstadoPanel();
		});

		// Opciones

		lblGrado = new JLabel("Ordene las opciones en orden de preferencia");
		GridBagConstraints gbc_lblGrado = new GridBagConstraints();
		gbc_lblGrado.insets = new Insets(0, 0, 5, 0);
		gbc_lblGrado.gridx = 0;
		gbc_lblGrado.gridy = 2;
		panel.add(lblGrado, gbc_lblGrado);
		cargarDefaultOpciones();

		JScrollPane scpGrados = new JScrollPane();
		GridBagConstraints gbc_scpGrados = new GridBagConstraints();
		gbc_scpGrados.insets = new Insets(0, 0, 5, 0);
		gbc_scpGrados.fill = GridBagConstraints.BOTH;
		gbc_scpGrados.gridx = 0;
		gbc_scpGrados.gridy = 3;
		panel.add(scpGrados, gbc_scpGrados);

		lstElementos = new Advanced_JList();
		scpGrados.setViewportView(lstElementos);
		lstElementosModel = lstElementos.getModel();
		cargarLista(elementosDefault);
		lstElementos.setDesplazamientoDesc(false);
		if (panelDependeCombo) {
			lstElementos.setEnabled(false);
		}

		// BOTÓN

		btnSeguro = new BotonPersonalizado();
		GridBagConstraints gbc_btnSeguro = new GridBagConstraints();
		gbc_btnSeguro.gridx = 0;
		gbc_btnSeguro.gridy = 4;
		panel.add(btnSeguro, gbc_btnSeguro);
		if (panelDependeCombo) {
			btnSeguro.setEnabled(false);
		}
		pulsacionesActuales = 0;
		btnSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pulsacionesActuales++;
				String categoriaSeleccionada = (String) combCategorias.getSelectedItem();
				ArrayList<String> opcionesSeleccionadas = new ArrayList<String>();
				for (int i = 0; i < nSeleccionesGrados && i < lstElementos.getModel().getSize(); i++) {
					opcionesSeleccionadas.add((String) lstElementos.getModel().getElementAt(i));
				}

				opcionesFinales.add(categoriaSeleccionada);
				opcionesFinales.addAll(opcionesSeleccionadas);

				if (mostrarResumenAlConfirmar) {
					String mensaje = "Categoría seleccionada: " + categoriaSeleccionada + "\nOpciones seleccionadas:\n";
					for (String opcion : opcionesSeleccionadas) {
						mensaje += "- " + opcion + "\n";
					}
					JOptionPane.showMessageDialog(null, mensaje, "Resumen de selección",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Selección confirmada.", "Confirmación",
							JOptionPane.INFORMATION_MESSAGE);
				}

				if (btnSeguro.getMaxPulsaciones() >= pulsacionesActuales) {
					JOptionPane.showMessageDialog(null, "Selección confirmada.", "Ha acabado todas las selecciones",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	// Cargar DEFAULTS

	/**
	 * Cargar lista de categorias por defecto
	 */
	private void cargarDefaultCategorias() {
		cmbCategoriasModel.addElement("Categoría 1");
		cmbCategoriasModel.addElement("Categoría 2");
		cmbCategoriasModel.addElement("Categoría 3");
		cmbCategoriasModel.addElement("Categoría 4");
		cmbCategoriasModel.addElement("Categoría 5");
		cmbCategoriasModel.addElement("Categoría 6");
		cmbCategoriasModel.addElement("Categoría 7");
		cmbCategoriasModel.addElement("Categoría 8");
	}

	/*
	 * Cargar lista de opciones por defecto
	 */
	private void cargarDefaultOpciones() {
		elementosDefault.add("Opción 1");
		elementosDefault.add("Opción 2");
		elementosDefault.add("Opción 3");
		elementosDefault.add("Opción 4");
		elementosDefault.add("Opción 5");
		elementosDefault.add("Opción 6");
		elementosDefault.add("Opción 7");
		elementosDefault.add("Opción 8");
		elementosDefault.add("Opción 9");
		elementosDefault.add("Opción 10");

	}

	// Añadir/Eliminar categorías y opciones

	/*
	 * 
	 * /** Añadir categoría al comb
	 * 
	 * @param categoria Categoría a añadir
	 */
	public void añadirCategoriaComb(String categoria) {
		if (cmbCategoriasModel.getSize() == 0) {
			cmbCategoriasModel.addElement("Seleccione una opción");
		}

		cmbCategoriasModel.addElement(categoria);
	}

	/**
	 * Eliminar categoría del comb
	 * 
	 * @param categoria Categoría a eliminar
	 */
	public void eliminarCategoriaComb(String categoria) {
		if (categoria.equals("Seleccione una opción")) {
			return;
		}
		cmbCategoriasModel.removeElement(categoria);
	}

	/**
	 * Añadir opción a la lista
	 * 
	 * @param opcion Opción a añadir
	 */
	public void añadirOpcionLista(String opcion) {
		lstElementosModel.addElement(opcion);
	}

	/**
	 * Eliminar opción de la lista
	 * 
	 * @param opcion Opción a eliminar
	 */
	public void eliminarOpcionLista(String opcion) {
		lstElementosModel.removeElement(opcion);
	}

	/**
	 * Cargar una lista de categorías en el comb
	 * 
	 * @param categorias Categorías a cargar
	 */
	public void cargarCategoriasComb(ArrayList<String> categorias) {
		cmbCategoriasModel.removeAllElements();
		cmbCategoriasModel.addElement("Seleccione una opción");
		for (String categoria : categorias) {
			añadirCategoriaComb(categoria);
		}
	}

	/**
	 * Cargar una lista de opciones en la lista
	 * 
	 * @param opciones Opciones a cargar
	 */
	public void cargarLista(ArrayList<String> opciones) {
		lstElementosModel.clear();
		for (String opcion : opciones) {
			añadirOpcionLista(opcion);
		}
	}

	// Actualizar estado del panel según selección del comb
	private void actualizarEstadoPanel() {

		boolean categoriaValida = false;

		String s = (String) combCategorias.getSelectedItem();

		if (s != null && !s.equals("Seleccione una opción")) {
			categoriaValida = true;
		}

		boolean habilitar = !panelDependeCombo || categoriaValida;

		lstElementos.setEnabled(habilitar);
		btnSeguro.setEnabled(habilitar);
	}

	// Getters y Setters de las opciones

	public boolean isBloquearElementos() {
		return panelDependeCombo;
	}

	public void setBloquearElementos(boolean panelDependeCombo) {
		this.panelDependeCombo = panelDependeCombo;
	}

	public boolean isMostrarResumenAlConfirmar() {
		return mostrarResumenAlConfirmar;
	}

	public void setMostrarResumenAlConfirmar(boolean mostrarResumenAlConfirmar) {
		this.mostrarResumenAlConfirmar = mostrarResumenAlConfirmar;
	}

	public void setLabelCategoria(String text) {
		lblUniversidad.setText(text);
	}

	public void setLabelGrado(String text) {
		lblGrado.setText(text);
	}

}


   

  