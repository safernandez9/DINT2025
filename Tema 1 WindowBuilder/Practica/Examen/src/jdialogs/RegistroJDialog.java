package jdialogs;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import examen.Usuario;
import examen.VentanaPrincipal;

import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class RegistroJDialog extends JDialog implements ActionListener, DocumentListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfDNI;
	private JTextField tfApellidos;
	private JTextField tfEdad;
	private JTextField tfNombre;
	private JMenu mnMenu;
	private JButton btnValidar;
	private JButton btnRegistrar;
	private JCheckBox cboxValidacion;
	private JMenuItem mntmValidar;
	private JMenuItem mntmRegistrar;

	/**
	 * Launch the application.
	 */
	public RegistroJDialog(Frame padre, boolean modal) {
		super(padre, modal);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		mntmValidar = new JMenuItem("Validar datos  Ctrl+V");
		mnMenu.add(mntmValidar);
		mntmValidar.addActionListener(this);

		mntmRegistrar = new JMenuItem("Registrar   Ctrl+R");
		mntmRegistrar.setEnabled(false);
		mntmRegistrar.addActionListener(this);
		mnMenu.add(mntmRegistrar);
		inicializarComponentes();

	}

	/**
	 * Create the dialog.
	 */
	public void inicializarComponentes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JPanel pnlRegistro = new JPanel();
		pnlRegistro.setBorder(
				new TitledBorder(null, "Registro usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlRegistro = new GridBagConstraints();
		gbc_pnlRegistro.fill = GridBagConstraints.BOTH;
		gbc_pnlRegistro.gridx = 0;
		gbc_pnlRegistro.gridy = 0;
		contentPanel.add(pnlRegistro, gbc_pnlRegistro);
		GridBagLayout gbl_pnlRegistro = new GridBagLayout();
		gbl_pnlRegistro.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlRegistro.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlRegistro.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlRegistro.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		pnlRegistro.setLayout(gbl_pnlRegistro);

		JLabel lblDNI = new JLabel("DNI");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 0;
		pnlRegistro.add(lblDNI, gbc_lblDNI);

		tfDNI = new JTextField();
		GridBagConstraints gbc_tfDNI = new GridBagConstraints();
		gbc_tfDNI.gridwidth = 2;
		gbc_tfDNI.insets = new Insets(0, 0, 5, 20);
		gbc_tfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDNI.gridx = 1;
		gbc_tfDNI.gridy = 0;
		pnlRegistro.add(tfDNI, gbc_tfDNI);
		tfDNI.setColumns(10);
		tfDNI.getDocument().addDocumentListener(this);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		pnlRegistro.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.gridwidth = 2;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 20);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		pnlRegistro.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		tfNombre.getDocument().addDocumentListener(this);

		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 20, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 2;
		pnlRegistro.add(lblApellidos, gbc_lblApellidos);

		tfApellidos = new JTextField();
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.gridwidth = 2;
		gbc_tfApellidos.insets = new Insets(0, 0, 5, 20);
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 2;
		pnlRegistro.add(tfApellidos, gbc_tfApellidos);
		tfApellidos.setColumns(10);
		tfApellidos.getDocument().addDocumentListener(this);

		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 3;
		pnlRegistro.add(lblEdad, gbc_lblEdad);

		tfEdad = new JTextField();
		GridBagConstraints gbc_tfEdad = new GridBagConstraints();
		gbc_tfEdad.gridwidth = 2;
		gbc_tfEdad.insets = new Insets(0, 0, 5, 20);
		gbc_tfEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEdad.gridx = 1;
		gbc_tfEdad.gridy = 3;
		pnlRegistro.add(tfEdad, gbc_tfEdad);
		tfEdad.setColumns(10);
		tfEdad.getDocument().addDocumentListener(this);

		cboxValidacion = new JCheckBox("Forzar validación positiva");
		GridBagConstraints gbc_cboxValidacion = new GridBagConstraints();
		gbc_cboxValidacion.insets = new Insets(0, 0, 5, 20);
		gbc_cboxValidacion.gridx = 2;
		gbc_cboxValidacion.gridy = 4;
		pnlRegistro.add(cboxValidacion, gbc_cboxValidacion);
		cboxValidacion.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JOptionPane.showMessageDialog(RegistroJDialog.this, "Datos validados a la fuerza.",
							"Validación forzada", JOptionPane.WARNING_MESSAGE);
					btnRegistrar.setEnabled(true);
					cboxValidacion.setSelected(true);
				} else {
					btnRegistrar.setEnabled(false);
					cboxValidacion.setSelected(false);
					
				}

			}
		});

		btnValidar = new JButton("Validar");
		GridBagConstraints gbc_btnValidar = new GridBagConstraints();
		btnValidar.addActionListener(this);
		gbc_btnValidar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValidar.gridwidth = 3;
		gbc_btnValidar.insets = new Insets(0, 20, 5, 20);
		gbc_btnValidar.gridx = 0;
		gbc_btnValidar.gridy = 5;
		pnlRegistro.add(btnValidar, gbc_btnValidar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(this);
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrar.gridwidth = 3;
		gbc_btnRegistrar.insets = new Insets(0, 20, 0, 20);
		gbc_btnRegistrar.gridx = 0;
		gbc_btnRegistrar.gridy = 6;
		pnlRegistro.add(btnRegistrar, gbc_btnRegistrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnRegistrar || src == mntmRegistrar) {
			((VentanaPrincipal) getParent()).añadirUsuarioDeRegistro(new Usuario(tfDNI.getText(), tfNombre.getText(),
					tfApellidos.getText(), Integer.parseInt(tfEdad.getText())));
			dispose();

		}
		if (src == btnValidar || src == mntmValidar) {
			if (comprobacionesUsuario()) {
				btnRegistrar.setEnabled(true);
				mntmRegistrar.setEnabled(true);
			}

		}

	}

	private boolean comprobacionesUsuario() {

		boolean valido = true;
		StringBuilder sb = new StringBuilder();

		if (tfDNI.getText().trim().isEmpty() || tfNombre.getText().trim().isEmpty()
				|| tfApellidos.getText().trim().isEmpty() || tfEdad.getText().trim().isEmpty()) {
			sb.append("\nTodos los campos son obligatorios");
			valido = false;
		}
		if (!(tfDNI.getText().matches("([0-9]{8})[A-Za-z]"))) {
			sb.append("\nEl DNI debe tener 8 números y una letra final (ej: 12345678AA).");
			valido = false;
		}
		if (Integer.parseInt(tfEdad.getText()) < 0 || Integer.parseInt(tfEdad.getText()) > 100) {
			sb.append("\nLa edad debe ser un número entero válido");
			valido = false;
		}

		if (!valido) {
			JOptionPane.showMessageDialog(this, sb.toString(), "Errores de validación", JOptionPane.WARNING_MESSAGE);
		}

		return valido;

	}

	// DOCUMENT LISTENER

	@Override
	public void insertUpdate(DocumentEvent e) {
		actualizarBotones();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		actualizarBotones();

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		actualizarBotones();

	}

	private void actualizarBotones() {
		btnRegistrar.setEnabled(false);
		mntmRegistrar.setEnabled(false);
	}

}
