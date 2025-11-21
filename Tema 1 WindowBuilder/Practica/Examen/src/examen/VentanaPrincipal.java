package examen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;

import jdialogs.RegistroJDialog;
import jdialogs.ReporteJDialog;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class VentanaPrincipal extends JFrame implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEntra;
	private JButton btnSale;
	private JList listaPersonas;
	private JList listaHistorial;
	private JButton btnLimpiarHistorial;
	private JButton btnRegistro;
	private JButton btnReporte;
	private JComboBox cbControlAcceso;
	private DefaultComboBoxModel<Usuario> modeloControl = new DefaultComboBoxModel<Usuario>();
	private DefaultListModel<Usuario> modeloListaPersonas = new DefaultListModel<Usuario>();
	private DefaultListModel<Usuario> modeloListaHistorial = new DefaultListModel<Usuario>();
	Usuario debugUsuario = new Usuario("77013586H", "Saul", "Fdez", 25);
	private Usuario usuarioSeleccionado;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmReporte;
	private JMenuItem mntmLimpiarHistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setMinimumSize(frame.getSize());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {

		modeloControl.addElement(debugUsuario);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 420);

		// MENU

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenu mnControlAcceso = new JMenu("Control de acceso");
		mnMenu.add(mnControlAcceso);

		// TECLAS CON FUNCION

		mntmRegistro = new JMenuItem("Registro  Ctrl+R");
		mntmRegistro.addActionListener(this);
		mnControlAcceso.add(mntmRegistro);

		KeyStroke ks = KeyStroke.getKeyStroke("control r");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ks, "accionRegistro");
		getRootPane().getActionMap().put("accionRegistro", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mntmRegistro.doClick();
			}
		});

		mntmReporte = new JMenuItem("Reporte  Alt+R");
		mntmReporte.addActionListener(this);
		mnControlAcceso.add(mntmReporte);

		mntmLimpiarHistorial = new JMenuItem("Limpiar historial  Ctrl+L");
		mntmLimpiarHistorial.addActionListener(this);
		mnMenu.add(mntmLimpiarHistorial);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control l"),
				"accionBorrar");

		getRootPane().getActionMap().put("accionBorrar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mntmRegistro.doClick();
			}
		});

		// PANE

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel plnIzquierdo = new JPanel();
		plnIzquierdo.setBackground(Color.WHITE);
		contentPane.add(plnIzquierdo);
		GridBagLayout gbl_plnIzquierdo = new GridBagLayout();
		gbl_plnIzquierdo.columnWidths = new int[] { 0, 0 };
		gbl_plnIzquierdo.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_plnIzquierdo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_plnIzquierdo.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		plnIzquierdo.setLayout(gbl_plnIzquierdo);

		JPanel pnlControlAcceso = new JPanel();
		pnlControlAcceso.setBackground(Color.WHITE);
		pnlControlAcceso.setBorder(
				new TitledBorder(null, "Control de acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlControlAcceso = new GridBagConstraints();
		gbc_pnlControlAcceso.insets = new Insets(0, 0, 5, 0);
		gbc_pnlControlAcceso.fill = GridBagConstraints.BOTH;
		gbc_pnlControlAcceso.gridx = 0;
		gbc_pnlControlAcceso.gridy = 0;
		plnIzquierdo.add(pnlControlAcceso, gbc_pnlControlAcceso);
		GridBagLayout gbl_pnlControlAcceso = new GridBagLayout();
		gbl_pnlControlAcceso.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlControlAcceso.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_pnlControlAcceso.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_pnlControlAcceso.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlControlAcceso.setLayout(gbl_pnlControlAcceso);

		cbControlAcceso = new JComboBox();
		cbControlAcceso.setModel(modeloControl);
		cbControlAcceso.setSelectedIndex(-1);
		cbControlAcceso.addItemListener(this);
		GridBagConstraints gbc_cbControlAcceso = new GridBagConstraints();
		gbc_cbControlAcceso.gridwidth = 2;
		gbc_cbControlAcceso.insets = new Insets(0, 0, 5, 5);
		gbc_cbControlAcceso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbControlAcceso.gridx = 0;
		gbc_cbControlAcceso.gridy = 0;
		pnlControlAcceso.add(cbControlAcceso, gbc_cbControlAcceso);

		btnEntra = new JButton("ENTRA");
		btnEntra.setEnabled(false);
		btnEntra.addActionListener(this);
		GridBagConstraints gbc_btnEntra = new GridBagConstraints();
		gbc_btnEntra.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntra.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntra.gridx = 0;
		gbc_btnEntra.gridy = 1;
		pnlControlAcceso.add(btnEntra, gbc_btnEntra);

		btnSale = new JButton("SALE");
		btnSale.setEnabled(false);
		btnSale.addActionListener(this);
		GridBagConstraints gbc_btnSale = new GridBagConstraints();
		gbc_btnSale.insets = new Insets(0, 0, 5, 5);
		gbc_btnSale.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSale.gridx = 1;
		gbc_btnSale.gridy = 1;
		pnlControlAcceso.add(btnSale, gbc_btnSale);

		btnReporte = new JButton("REPORTE");
		btnReporte.addActionListener(this);
		GridBagConstraints gbc_btnReporte = new GridBagConstraints();
		gbc_btnReporte.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReporte.gridwidth = 2;
		gbc_btnReporte.insets = new Insets(0, 0, 0, 5);
		gbc_btnReporte.gridx = 0;
		gbc_btnReporte.gridy = 2;
		pnlControlAcceso.add(btnReporte, gbc_btnReporte);

		btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(this);
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistro.gridx = 0;
		gbc_btnRegistro.gridy = 1;
		plnIzquierdo.add(btnRegistro, gbc_btnRegistro);

		JPanel pnlPersonas = new JPanel();
		pnlPersonas.setBackground(Color.WHITE);
		pnlPersonas.setBorder(
				new TitledBorder(null, "Personas en el gimnasio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlPersonas = new GridBagConstraints();
		gbc_pnlPersonas.fill = GridBagConstraints.BOTH;
		gbc_pnlPersonas.gridx = 0;
		gbc_pnlPersonas.gridy = 2;
		plnIzquierdo.add(pnlPersonas, gbc_pnlPersonas);
		GridBagLayout gbl_pnlPersonas = new GridBagLayout();
		gbl_pnlPersonas.columnWidths = new int[] { 0, 0 };
		gbl_pnlPersonas.rowHeights = new int[] { 0, 0 };
		gbl_pnlPersonas.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlPersonas.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlPersonas.setLayout(gbl_pnlPersonas);

		JScrollPane scpListaPersonas = new JScrollPane();
		GridBagConstraints gbc_scpListaPersonas = new GridBagConstraints();
		gbc_scpListaPersonas.fill = GridBagConstraints.BOTH;
		gbc_scpListaPersonas.gridx = 0;
		gbc_scpListaPersonas.gridy = 0;
		pnlPersonas.add(scpListaPersonas, gbc_scpListaPersonas);

		listaPersonas = new JList();
		listaPersonas.setModel(modeloListaPersonas);
		scpListaPersonas.setViewportView(listaPersonas);

		JPanel pnlDerecho = new JPanel();
		contentPane.add(pnlDerecho);
		GridBagLayout gbl_pnlDerecho = new GridBagLayout();
		gbl_pnlDerecho.columnWidths = new int[] { 0, 0 };
		gbl_pnlDerecho.rowHeights = new int[] { 0, 0 };
		gbl_pnlDerecho.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlDerecho.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlDerecho.setLayout(gbl_pnlDerecho);

		JPanel pnlHistorial = new JPanel();
		pnlHistorial.setBorder(new TitledBorder(null, "Historial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlHistorial = new GridBagConstraints();
		gbc_pnlHistorial.fill = GridBagConstraints.BOTH;
		gbc_pnlHistorial.gridx = 0;
		gbc_pnlHistorial.gridy = 0;
		pnlDerecho.add(pnlHistorial, gbc_pnlHistorial);
		GridBagLayout gbl_pnlHistorial = new GridBagLayout();
		gbl_pnlHistorial.columnWidths = new int[] { 0 };
		gbl_pnlHistorial.rowHeights = new int[] { 0, 0 };
		gbl_pnlHistorial.columnWeights = new double[] { 1.0 };
		gbl_pnlHistorial.rowWeights = new double[] { 1.0, 0.0 };
		pnlHistorial.setLayout(gbl_pnlHistorial);

		JScrollPane scpListaHistorial = new JScrollPane();
		GridBagConstraints gbc_scpListaHistorial = new GridBagConstraints();
		gbc_scpListaHistorial.insets = new Insets(0, 0, 5, 0);
		gbc_scpListaHistorial.fill = GridBagConstraints.BOTH;
		gbc_scpListaHistorial.gridx = 0;
		gbc_scpListaHistorial.gridy = 0;
		pnlHistorial.add(scpListaHistorial, gbc_scpListaHistorial);

		listaHistorial = new JList();
		listaHistorial.setModel(modeloListaHistorial);
		scpListaHistorial.setViewportView(listaHistorial);

		btnLimpiarHistorial = new JButton("Limpiar historial");
		btnLimpiarHistorial.addActionListener(this);
		GridBagConstraints gbc_btnLimpiarHistorial = new GridBagConstraints();
		gbc_btnLimpiarHistorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpiarHistorial.gridx = 0;
		gbc_btnLimpiarHistorial.gridy = 1;
		pnlHistorial.add(btnLimpiarHistorial, gbc_btnLimpiarHistorial);

	}

	// LISTENERS

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbControlAcceso) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				usuarioSeleccionado = (Usuario) cbControlAcceso.getSelectedItem();
			}
			if (usuarioEstaDentro()) {
				btnSale.setEnabled(true);
			} else {
				btnEntra.setEnabled(true);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnEntra) {
			entrarUsuario();
			reiniciarCBox();
		}
		if (src == btnSale) {
			salirUsuario();
			reiniciarCBox();

		}
		if (src == btnReporte || src == mntmReporte) {
			if (GestorVentanas.abrirVentanaReportes()) {
				ReporteJDialog dialogReportesDialog = new ReporteJDialog(this, false, modeloControl.getSize(),
						modeloListaPersonas.getSize(), modeloListaHistorial.getSize(), calcularEdadMediaTotal(),
						calcularEdadMediaDentro());
				dialogReportesDialog.setMinimumSize(dialogReportesDialog.getSize());
				dialogReportesDialog.setVisible(true);
			}
		}
		if (src == btnRegistro || src == mntmRegistro) {
			RegistroJDialog dialogRegistro = new RegistroJDialog(this, false);
			dialogRegistro.setMinimumSize(dialogRegistro.getSize());
			dialogRegistro.setVisible(true);

		}
		if (src == btnLimpiarHistorial || src == mntmLimpiarHistorial) {
			limpiarHistorial();
		}

	}

	// METODOS PROPIOS

	private boolean usuarioEstaDentro() {
		return usuarioSeleccionado.isDentro();
	}

	private void entrarUsuario() {
		modeloControl.removeElement(usuarioSeleccionado);
		usuarioSeleccionado.setDentro(true);
		modeloControl.addElement(usuarioSeleccionado);
		modeloListaPersonas.addElement(usuarioSeleccionado);
		modeloListaHistorial.addElement(usuarioSeleccionado);

	}

	private void salirUsuario() {
		modeloControl.removeElement(usuarioSeleccionado);
		usuarioSeleccionado.setDentro(false);
		modeloControl.addElement(usuarioSeleccionado);
		modeloListaPersonas.removeElement(usuarioSeleccionado);
		modeloListaHistorial.addElement(usuarioSeleccionado);

	}

	private void limpiarHistorial() {
		modeloListaHistorial.removeAllElements();
	}

	private void reiniciarCBox() {
		cbControlAcceso.setSelectedIndex(-1);
		btnEntra.setEnabled(false);
		btnSale.setEnabled(false);
	}

	public void añadirUsuarioDeRegistro(Usuario usuario) {
		modeloControl.addElement(usuario);
	}

	// ESTADISTICAS

	private int calcularEdadMediaTotal() {
		int edad = 0;

		for (int i = 0; i < modeloControl.getSize(); i++) {
			edad += modeloControl.getElementAt(i).getEdad();
		}

		return edad;

	}

	private int calcularEdadMediaDentro() {
		int edad = 0;

		for (int i = 0; i < modeloListaPersonas.getSize(); i++) {
			edad += modeloListaPersonas.getElementAt(i).getEdad();
		}

		return edad;
	}

}
