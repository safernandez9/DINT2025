package tarea10jdialogintercambiodatos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatosNovoUsuarioJDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfProvincia;
	private JButton btnSeleccionar;
	private int idUsuario;

	/**
	 * Constructor JDialog
	 * 
	 * @param parent
	 * @param modal  Modos, explicado en actividad 9
	 * @param id     Id para o novo usuario
	 */
	public DatosNovoUsuarioJDialog(Frame parent, boolean modal, int id) {
		super(parent, modal);
		idUsuario = id;
		crearVentana();
		setTitle("Datos novo usuario - ID " + idUsuario);
	}

	/**
	 * Crear a ventana
	 */
	public void crearVentana() {
		setBounds(100, 100, 422, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNombre = new JLabel("Nome");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPanel.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.gridwidth = 2;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 0;
		contentPanel.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblApleidos = new JLabel("Apelidos");
		GridBagConstraints gbc_lblApleidos = new GridBagConstraints();
		gbc_lblApleidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApleidos.gridx = 0;
		gbc_lblApleidos.gridy = 1;
		contentPanel.add(lblApleidos, gbc_lblApleidos);

		tfApellidos = new JTextField();
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.gridwidth = 2;
		gbc_tfApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 1;
		contentPanel.add(tfApellidos, gbc_tfApellidos);
		tfApellidos.setColumns(10);

		JLabel lblProvincia = new JLabel("Provincia");
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.insets = new Insets(0, 10, 0, 10);
		gbc_lblProvincia.gridx = 0;
		gbc_lblProvincia.gridy = 2;
		contentPanel.add(lblProvincia, gbc_lblProvincia);

		tfProvincia = new JTextField();
		GridBagConstraints gbc_tfProvincia = new GridBagConstraints();
		gbc_tfProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProvincia.insets = new Insets(0, 0, 0, 5);
		gbc_tfProvincia.gridx = 1;
		gbc_tfProvincia.gridy = 2;
		contentPanel.add(tfProvincia, gbc_tfProvincia);
		tfProvincia.setColumns(10);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.gridx = 2;
		gbc_btnSeleccionar.gridy = 2;
		contentPanel.add(btnSeleccionar, gbc_btnSeleccionar);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand("OK");
		buttonPane.add(btnAceptar);
		getRootPane().setDefaultButton(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("Cancel");
		buttonPane.add(btnCancelar);

	}

	/**
	 * Gestor de botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSeleccionar) {
			btnSeleccionarActionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			btnAceptarActionPerformed(e);
		}
		// Cierra el diálogo sin guardar
		if (e.getSource() == btnCancelar) {
			dispose();
		}

	}

	/**
	 * Código del botón seleccionar Abre el JDialog de provincias
	 * 
	 * @param e
	 */
	private void btnSeleccionarActionPerformed(ActionEvent e) {
		ProvinciasJDialog provinciasDialog = new ProvinciasJDialog((JDialog) this, false);
		provinciasDialog.setVisible(true);
	}

	/**
	 * Código del boton aceptar Crea un objeto usuario con los datos introducidos y
	 * llama al método set del diálogo padre (engadirInfoNovoUsuario) para añadir el
	 * usuario al JTextArea
	 * 
	 * @param evt
	 */
	private void btnAceptarActionPerformed(ActionEvent e) {
		String nombre = tfNombre.getText().trim();
		String apellidos = tfApellidos.getText().trim();
		String provincia = tfProvincia.getText().trim();
		if (nombre.compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Debe indicar o nome do usuario");
			return;
		}
		if (apellidos.compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Debe indicar os apelidos do usuario");
			return;
		}
		if (provincia.compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Debe indicar a provincia do usuario");
			return;
		}
		Usuario usuario = new Usuario(idUsuario, nombre, apellidos, provincia);
		((Tarea10JDialogIntercambioDatos) getParent()).engadirInfoNovoUsuario(usuario);
		dispose();
	}

	/**
	 * Settea la provincia seleccionada en el otro JDialog
	 * 
	 * @param provincia
	 */
	public void establecerProvincia(String provincia) {
		tfProvincia.setText(provincia);
	}
}
