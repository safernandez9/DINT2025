package simulacro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ActualizarDatosJDialog extends JDialog implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDatosAlumno;
	private JComboBox cbParametros;
	private JButton btnAplicarCambio;
	private JButton btnDescartar;
	private Simulacro padre;
	private String dni;
	private String nombre;
	private String apellidos;
	private int filaElemento;
	
	
	
// PARAMETROS POR EL CONSTRUCTOR CREADO POR MI
	
	public ActualizarDatosJDialog(Frame padre, boolean modal, String dni, String nombre, String apellidos, int filaElemento) {
		super(padre, modal);
		this.padre = (Simulacro) padre;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.filaElemento = filaElemento;
		this.crearVentana();
	}


	// CONVIERTO LA CREACION A UN METODO
	
	private void crearVentana() {
		setBounds(100, 100, 533, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel pnlGestionAlumnos = new JPanel();
		pnlGestionAlumnos.setBorder(
				new TitledBorder(null, "Gesti\u00F3n alumnos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlGestionAlumnos = new GridBagConstraints();
		gbc_pnlGestionAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGestionAlumnos.fill = GridBagConstraints.BOTH;
		gbc_pnlGestionAlumnos.gridx = 0;
		gbc_pnlGestionAlumnos.gridy = 0;
		contentPanel.add(pnlGestionAlumnos, gbc_pnlGestionAlumnos);
		GridBagLayout gbl_pnlGestionAlumnos = new GridBagLayout();
		gbl_pnlGestionAlumnos.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlGestionAlumnos.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlGestionAlumnos.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlGestionAlumnos.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlGestionAlumnos.setLayout(gbl_pnlGestionAlumnos);

		JLabel lblDNI = new JLabel("DNI");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.WEST;
		gbc_lblDNI.insets = new Insets(20, 20, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 0;
		pnlGestionAlumnos.add(lblDNI, gbc_lblDNI);

		tfDNI = new JTextField();
		tfDNI.setEditable(false);
		tfDNI.setText(dni);
		GridBagConstraints gbc_tfDNI = new GridBagConstraints();
		gbc_tfDNI.insets = new Insets(20, 0, 5, 20);
		gbc_tfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDNI.gridx = 1;
		gbc_tfDNI.gridy = 0;
		pnlGestionAlumnos.add(tfDNI, gbc_tfDNI);
		tfDNI.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 20, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		pnlGestionAlumnos.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setText(nombre);
		GridBagConstraints gbc_rfNombre = new GridBagConstraints();
		gbc_rfNombre.insets = new Insets(0, 0, 5, 20);
		gbc_rfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_rfNombre.gridx = 1;
		gbc_rfNombre.gridy = 1;
		pnlGestionAlumnos.add(tfNombre, gbc_rfNombre);
		tfNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 20, 20, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 2;
		pnlGestionAlumnos.add(lblApellidos, gbc_lblApellidos);

		tfApellidos = new JTextField();
		tfApellidos.setEditable(false);
		tfApellidos.setText(apellidos);
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.insets = new Insets(0, 0, 20, 20);
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 2;
		pnlGestionAlumnos.add(tfApellidos, gbc_tfApellidos);
		tfApellidos.setColumns(10);
		
		JPanel pnlInteraccion = new JPanel();
		GridBagConstraints gbc_pnlInteraccion = new GridBagConstraints();
		gbc_pnlInteraccion.fill = GridBagConstraints.BOTH;
		gbc_pnlInteraccion.gridx = 0;
		gbc_pnlInteraccion.gridy = 1;
		contentPanel.add(pnlInteraccion, gbc_pnlInteraccion);
		GridBagLayout gbl_pnlInteraccion = new GridBagLayout();
		gbl_pnlInteraccion.columnWidths = new int[] {0};
		gbl_pnlInteraccion.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pnlInteraccion.columnWeights = new double[]{1.0};
		gbl_pnlInteraccion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		pnlInteraccion.setLayout(gbl_pnlInteraccion);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 20, 5, 20);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlInteraccion.add(scrollPane, gbc_scrollPane);
		
		// COMBOBOX
		
		cbParametros = new JComboBox();
		cbParametros.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Apellidos"}));
		scrollPane.setViewportView(cbParametros);
		cbParametros.setSelectedIndex(-1);
		cbParametros.addItemListener(this);
		
		
		
		tfDatosAlumno = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 20, 5, 20);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		pnlInteraccion.add(tfDatosAlumno, gbc_textField);
		tfDatosAlumno.setColumns(10);
		tfDatosAlumno.getDocument().addDocumentListener(new DocumentListener() {
		    void actualizar() { actualizarBotones();}
		    public void insertUpdate(DocumentEvent e) { actualizar(); }
		    public void removeUpdate(DocumentEvent e) { actualizar(); }
		    
		    public void changedUpdate(DocumentEvent e) { actualizar(); }
		});

		
		btnAplicarCambio = new JButton("Aplicar cambio");
		btnAplicarCambio.setEnabled(false);
		btnAplicarCambio.addActionListener(this);
		GridBagConstraints gbc_btnAplicarCambio = new GridBagConstraints();
		gbc_btnAplicarCambio.fill = GridBagConstraints.BOTH;
		gbc_btnAplicarCambio.insets = new Insets(0, 20, 5, 20);
		gbc_btnAplicarCambio.gridx = 0;
		gbc_btnAplicarCambio.gridy = 2;
		pnlInteraccion.add(btnAplicarCambio, gbc_btnAplicarCambio);
		
		btnDescartar = new JButton("Descartar cambio");
		btnDescartar.setEnabled(false);
		btnDescartar.addActionListener(this);
		GridBagConstraints gbc_btnDescartar = new GridBagConstraints();
		gbc_btnDescartar.insets = new Insets(0, 20, 0, 20);
		gbc_btnDescartar.fill = GridBagConstraints.BOTH;
		gbc_btnDescartar.gridx = 0;
		gbc_btnDescartar.gridy = 3;
		pnlInteraccion.add(btnDescartar, gbc_btnDescartar);
	}


	// Actualiza los botones si se cambia el dato
	protected void actualizarBotones() {
		if (cbParametros.getSelectedIndex() == 0) {
			if (!tfNombreCoincide() && !tfDatosAlumnoVacio()) {
				activarBotones();
			} else {
				desactivarBotones();
			}
		} else if (cbParametros.getSelectedIndex() == 1) {
			if (!tfApellidosCoincide() && !tfDatosAlumnoVacio()) {
				activarBotones();
			} else {
				desactivarBotones();
			}
		}
	}

	private boolean tfNombreCoincide() {
		return tfDatosAlumno.getText().toLowerCase().equals(this.nombre.toLowerCase());
	}
	
	private boolean tfApellidosCoincide() {
		return tfDatosAlumno.getText().toLowerCase().equals(this.apellidos.toLowerCase());
	}


	private boolean tfDatosAlumnoVacio() {
		return(tfDatosAlumno.getText().trim().isEmpty());
	}

	private void activarBotones() {
		btnDescartar.setEnabled(true);
		btnAplicarCambio.setEnabled(true);
	}

	private void desactivarBotones() {
		btnDescartar.setEnabled(false);
		btnAplicarCambio.setEnabled(false);
	}

	@Override
	/**
	 *  Listener comboBox
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cbParametros) {
			actualizarTextFieldPnlDatos();
		}
		
	}

	@Override
	/**
	 * Listener botones
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAplicarCambio) {
			aplicarCambiosYDevolver();
		}
		if (e.getSource() == btnDescartar) {
			actualizarTextFieldPnlDatos();

		}
	}


	/**
	 * Aplica los cambios a la etiqueta de esta ventana y a la tabla de la otra
	 */
	private void aplicarCambiosYDevolver() {
		int tipoDato = -1;
		String datoEnviado = null;
		if (cbParametros.getSelectedIndex() == 0) {
			this.nombre = tfDatosAlumno.getText().trim().toUpperCase();
			tfNombre.setText(this.nombre);
			tipoDato = 1;
			datoEnviado = this.nombre;
		} else if (cbParametros.getSelectedIndex() == 1) {
			this.apellidos = tfDatosAlumno.getText().trim().toUpperCase();
			tfApellidos.setText(this.apellidos);
			tipoDato = 2;
			datoEnviado = this.apellidos;
		}
		btnDescartar.setEnabled(false);
		btnAplicarCambio.setEnabled(false);
		
		// Actualizo a la ventana padre usando su metodo actualizarTabla
		if(tipoDato != -1) {
			((Simulacro) getParent()).actualizarTabla(datoEnviado, filaElemento, tipoDato);
		}
		

		
	}
	
	/**
	 * Actualiza el textField del Panel inferior según lo que esté seleccionado en el combobox
	 */
	private void actualizarTextFieldPnlDatos() {
		if(cbParametros.getSelectedIndex() == 0) {
			tfDatosAlumno.setText(this.nombre);
		}
		else if(cbParametros.getSelectedIndex() == 1) {
			tfDatosAlumno.setText(this.apellidos);
		}
	}

}
