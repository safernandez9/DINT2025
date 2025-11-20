package tarea7jcombobox2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/*
 * Tarea 7: JComboBox 2
 * Metodología: Crear un JFrame con dos JComboBox y una JLabel.
 * Creo ComboBox y le asocio un modelo para guardar sus datos. (O añado de modo grafico un modelo)
 * Asocio un ItemListener a los ComboBox
 * Creo el metodo necesario de la interfaz ItemListener
 * Asocio los eventos según su procedencia con getSource() a un metodo concreto
 * Compruebo que el evento es de selección de un item (ItemEvent.SELECTED)
 * Según el ComboBox que genera el evento, actúo en consecuencia:
 * - Si es el de provincias, cargo los concellos correspondientes en el otro ComboBox
 * - Si es el de concellos, muestro el concello seleccionado en la JLabel
 */
public class Tarea7ComboBox2 extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConcelloSeleccionado;
	private JComboBox combConcellos;
	private JComboBox combProvincias;
	private DefaultComboBoxModel<String> modeloConcellos = new DefaultComboBoxModel<String>();
	// o DefaultComboModel modeloConcellos = new DefaultComboModel(); y casteo
	// cuando reciba datos

	// Pequena "base de datos" de concellos por provincias
	private String[] concellosCorunha = { "Betanzos", "Ferrol", "Pontedeume" };
	private String[] concellosLugo = { "Foz", "Quiroga", "Triacastela" };
	private String[] concellosOurense = { "Bande", "Castro Caldelas", "Maside" };
	private String[] concellosPontevedra = { "Cangas", "Bueu", "Mar n", "Pontevedra", "Tomi o" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea7ComboBox2 frame = new Tarea7ComboBox2();
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
	public Tarea7ComboBox2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblProvincia = new JLabel("Provincia");
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.anchor = GridBagConstraints.WEST;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 0;
		gbc_lblProvincia.gridy = 0;
		contentPane.add(lblProvincia, gbc_lblProvincia);

		
		// CARGAR UN COMBOBOX CON UN ARRAY DE ARRAYS y añadirle un Listener de Items al Combobox 
		
		combProvincias = new JComboBox();
		combProvincias.setModel(new DefaultComboBoxModel(new String[] {"A Coruña", "Lugo", "Ourense", "Pontevedra"}));
		GridBagConstraints gbc_combProvincia = new GridBagConstraints();
		gbc_combProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_combProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_combProvincia.gridx = 1;
		gbc_combProvincia.gridy = 0;
		combProvincias.addItemListener(this);
		contentPane.add(combProvincias, gbc_combProvincia);

		
		
		JLabel lblConcello = new JLabel("Concello");
		GridBagConstraints gbc_lblConcello = new GridBagConstraints();
		gbc_lblConcello.anchor = GridBagConstraints.WEST;
		gbc_lblConcello.insets = new Insets(0, 0, 5, 5);
		gbc_lblConcello.gridx = 0;
		gbc_lblConcello.gridy = 1;
		contentPane.add(lblConcello, gbc_lblConcello);

		combConcellos = new JComboBox();
		GridBagConstraints gbc_combConcello = new GridBagConstraints();
		gbc_combConcello.insets = new Insets(0, 0, 5, 0);
		gbc_combConcello.fill = GridBagConstraints.HORIZONTAL;
		gbc_combConcello.gridx = 1;
		gbc_combConcello.gridy = 1;
		combConcellos.setModel(modeloConcellos);
		combConcellos.addItemListener(this);
		contentPane.add(combConcellos, gbc_combConcello);

		lblConcelloSeleccionado = new JLabel("");
		GridBagConstraints gbc_lblConcelloSeleccionado = new GridBagConstraints();
		gbc_lblConcelloSeleccionado.gridwidth = 2;
		gbc_lblConcelloSeleccionado.insets = new Insets(20, 0, 20, 5);
		gbc_lblConcelloSeleccionado.gridx = 0;
		gbc_lblConcelloSeleccionado.gridy = 2;
		contentPane.add(lblConcelloSeleccionado, gbc_lblConcelloSeleccionado);

	}

	// Métodos para gestionar los eventos de los ComboBox. Si el cambio es la selección, de un item, se actúa en consecuencia
	// Cojo la posición del item seleccionado en el combo de provincias (introducidas en orden de modo gráfico desde la opción model del combo)
	// y cargo os concellos correspondentes no combo de concellos
	private void cmbProvinciasItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			int posicionProvincia = combProvincias.getSelectedIndex();
			cargarConcellos(posicionProvincia);
		}
	}

	// Lo mismo, pero la accion consecuencia es mostrar el concello seleccionado en la etiqueta
	private void cmbConcellosItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			lblConcelloSeleccionado.setText("Concello seleccionado: "
					+ modeloConcellos.getElementAt(combConcellos.getSelectedIndex()).toUpperCase());
		}
	}

	private void cargarConcellos(int codProvincia) {

		modeloConcellos.removeAllElements();

		switch (codProvincia) {
		case 0:
			for (int i = 0; i < concellosCorunha.length; i++) {
				modeloConcellos.addElement(concellosCorunha[i]);
			}
			break;
		case 1:
			for (int i = 0; i < concellosLugo.length; i++) {
				modeloConcellos.addElement(concellosLugo[i]);
			}
			break;
		case 2:
			for (int i = 0; i < concellosOurense.length; i++) {
				modeloConcellos.addElement(concellosOurense[i]);
			}
			break;
		case 3:
			for (int i = 0; i < concellosPontevedra.length; i++) {
				modeloConcellos.addElement(concellosPontevedra[i]);
			}
			break;
		}
	}

	// Funciona igual que el ActionListener, pero para eventos de tipo ItemEvent
	// (ComboBox)
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == combProvincias) {
			cmbProvinciasItemStateChanged(e);
		}
		if (e.getSource() == combConcellos) {
			cmbConcellosItemStateChanged(e);
		}

	}
}
