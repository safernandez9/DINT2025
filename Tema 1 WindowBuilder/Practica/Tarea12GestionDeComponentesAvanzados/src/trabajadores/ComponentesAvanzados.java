package trabajadores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ComponentesAvanzados extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApe1;
	private JTextField tfApe2;
	private JTextField tfProfesion;
	private JTable tblTrabajadores;
	private JList lstProfesion;
	private JTextArea textArea;
	private JButton btnEliminarProfesion;
	private JButton btnAñadirProfesion;
	private JButton btnAñadirTrabajador;
	private JButton btnEliminarTrabajador;
	private JButton btnAñadirProvincia;
	private JButton btnEliminarProvincia;
	private JComboBox combProvincia;
	private JScrollPane scpTrabajadores;
	private JMenuItem mntmEliminarTrabajador;
	private JMenuItem mntmAñadirTrabajador;
	private JMenuItem mntmLimpiarDatos;
	private JMenuItem mntmValidacionDatos;
	private JRadioButtonMenuItem rdbtnmntmModoOffline;
	private JRadioButtonMenuItem rdbtnmntmModoOnline;
	private JMenuItem mntmDetallesSesion;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmSalirAplicacion;

	
	private DefaultComboBoxModel<String> modeloProvincias = new DefaultComboBoxModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentesAvanzados frame = new ComponentesAvanzados();
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
	public ComponentesAvanzados() {
		setTitle("Compoñentes Avanzados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 611);

		// MENU
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		/*
		 * MENU SUPERIOR SESIÓN
		 */
		JMenu menuSesion = new JMenu("Sesión");
		menu.add(menuSesion);
		
		mntmDetallesSesion = new JMenuItem("Detalles sesión");
		menuSesion.add(mntmDetallesSesion);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		menuSesion.add(mntmCerrarSesion);
		
		mntmSalirAplicacion = new JMenuItem("Salir de la aplicación");
		menuSesion.add(mntmSalirAplicacion);

		
		/*
		 * MENU SUPERIOR ACCIONES
		 * 
		 * 2 opciones con una de menú desplegable (mnTrabajador)
		 */
		
		JMenu menuAcciones = new JMenu("Acciones");
		menu.add(menuAcciones);
		
		JMenu mnTrabajador = new JMenu("Trabajador");
		menuAcciones.add(mnTrabajador);
		
		JMenuItem mntmResetTotal = new JMenuItem("Reset total");
		menuAcciones.add(mntmResetTotal);
		
		// Submenú de Trabajador
		
		mntmValidacionDatos = new JMenuItem("Validación datos del trabajador");
		mnTrabajador.add(mntmValidacionDatos);
		mntmValidacionDatos.addActionListener(this);
		
		mntmLimpiarDatos = new JMenuItem("Limpiar datos del trabajador");
		mnTrabajador.add(mntmLimpiarDatos);
		mntmLimpiarDatos.addActionListener(this);
		
		mntmAñadirTrabajador = new JMenuItem("Añadir trabajador");
		mnTrabajador.add(mntmAñadirTrabajador);
		mntmAñadirTrabajador.addActionListener(this);
		
		mntmEliminarTrabajador = new JMenuItem("Eliminar trabajador");
		mnTrabajador.add(mntmEliminarTrabajador);
		mntmEliminarTrabajador.addActionListener(this);
		
		

		
		/*
		 * MENU SUPERIOR MODO
		 * 2 checkbox de menú, solo una a la vez (ButtonGroup), modo offline preseleccionado
		 */
		
		JMenu menuModo = new JMenu("Modo");
		menu.add(menuModo);
		
		rdbtnmntmModoOffline = new JRadioButtonMenuItem("Modo offline");
		rdbtnmntmModoOffline.setSelected(true);
		menuModo.add(rdbtnmntmModoOffline);
		
		rdbtnmntmModoOnline = new JRadioButtonMenuItem("Modo online");
		menuModo.add(rdbtnmntmModoOnline);
		
		ButtonGroup modoOnlineOfflineButtonGroup = new ButtonGroup();
		modoOnlineOfflineButtonGroup.add(rdbtnmntmModoOffline);
		modoOnlineOfflineButtonGroup.add(rdbtnmntmModoOnline);
		
		
		// VENTANA PRINCIPAL
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnlIzq = new JPanel();
		contentPane.add(pnlIzq);
		GridBagLayout gbl_pnlIzq = new GridBagLayout();
		gbl_pnlIzq.columnWidths = new int[] { 0, 0 };
		gbl_pnlIzq.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlIzq.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlIzq.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		pnlIzq.setLayout(gbl_pnlIzq);

		JPanel pnlIdentificacion = new JPanel();
		pnlIdentificacion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Identificaci\u00F3n del trabajador", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlIdentificacion = new GridBagConstraints();
		gbc_pnlIdentificacion.insets = new Insets(0, 0, 5, 0);
		gbc_pnlIdentificacion.fill = GridBagConstraints.BOTH;
		gbc_pnlIdentificacion.gridx = 0;
		gbc_pnlIdentificacion.gridy = 0;
		pnlIzq.add(pnlIdentificacion, gbc_pnlIdentificacion);
		GridBagLayout gbl_pnlIdentificacion = new GridBagLayout();
		gbl_pnlIdentificacion.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlIdentificacion.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlIdentificacion.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlIdentificacion.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		pnlIdentificacion.setLayout(gbl_pnlIdentificacion);

		JLabel lblDNI = new JLabel("DNI");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.fill = GridBagConstraints.BOTH;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 0;
		pnlIdentificacion.add(lblDNI, gbc_lblDNI);

		tfDNI = new JTextField();
		tfDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		GridBagConstraints gbc_tfDNI = new GridBagConstraints();
		gbc_tfDNI.insets = new Insets(0, 0, 5, 0);
		gbc_tfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDNI.gridx = 1;
		gbc_tfDNI.gridy = 0;
		pnlIdentificacion.add(tfDNI, gbc_tfDNI);
		tfDNI.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		pnlIdentificacion.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		pnlIdentificacion.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblApe1 = new JLabel("Apellido1");
		GridBagConstraints gbc_lblApe1 = new GridBagConstraints();
		gbc_lblApe1.fill = GridBagConstraints.BOTH;
		gbc_lblApe1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApe1.gridx = 0;
		gbc_lblApe1.gridy = 2;
		pnlIdentificacion.add(lblApe1, gbc_lblApe1);

		tfApe1 = new JTextField();
		GridBagConstraints gbc_tfApe1 = new GridBagConstraints();
		gbc_tfApe1.insets = new Insets(0, 0, 5, 0);
		gbc_tfApe1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApe1.gridx = 1;
		gbc_tfApe1.gridy = 2;
		pnlIdentificacion.add(tfApe1, gbc_tfApe1);
		tfApe1.setColumns(10);

		JLabel lblApe2 = new JLabel("Apellido 2");
		GridBagConstraints gbc_lblApe2 = new GridBagConstraints();
		gbc_lblApe2.fill = GridBagConstraints.BOTH;
		gbc_lblApe2.insets = new Insets(0, 0, 0, 5);
		gbc_lblApe2.gridx = 0;
		gbc_lblApe2.gridy = 3;
		pnlIdentificacion.add(lblApe2, gbc_lblApe2);

		tfApe2 = new JTextField();
		GridBagConstraints gbc_tfApe2 = new GridBagConstraints();
		gbc_tfApe2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApe2.gridx = 1;
		gbc_tfApe2.gridy = 3;
		pnlIdentificacion.add(tfApe2, gbc_tfApe2);
		tfApe2.setColumns(10);

		JPanel pnlProvincia = new JPanel();
		pnlProvincia.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Provincia del trabajador", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlProvincia = new GridBagConstraints();
		gbc_pnlProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_pnlProvincia.fill = GridBagConstraints.BOTH;
		gbc_pnlProvincia.gridx = 0;
		gbc_pnlProvincia.gridy = 1;
		pnlIzq.add(pnlProvincia, gbc_pnlProvincia);
		GridBagLayout gbl_pnlProvincia = new GridBagLayout();
		gbl_pnlProvincia.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlProvincia.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlProvincia.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlProvincia.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		pnlProvincia.setLayout(gbl_pnlProvincia);

		combProvincia = new JComboBox();
		GridBagConstraints gbc_combProvincia = new GridBagConstraints();
		combProvincia.setModel(modeloProvincias);
		combProvincia.setSelectedIndex(-1);
		gbc_combProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_combProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_combProvincia.gridx = 0;
		gbc_combProvincia.gridy = 0;
		pnlProvincia.add(combProvincia, gbc_combProvincia);

		btnEliminarProvincia = new JButton("Eliminar provincia");
		btnEliminarProvincia.setEnabled(false);
		GridBagConstraints gbc_btnEliminarProvincia = new GridBagConstraints();
		gbc_btnEliminarProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarProvincia.gridx = 1;
		gbc_btnEliminarProvincia.gridy = 0;
		btnEliminarProvincia.addActionListener(this);
		pnlProvincia.add(btnEliminarProvincia, gbc_btnEliminarProvincia);

		btnAñadirProvincia = new JButton("Añadir provincia");
		GridBagConstraints gbc_btnAñadirProvincia = new GridBagConstraints();
		gbc_btnAñadirProvincia.gridwidth = 2;
		gbc_btnAñadirProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAñadirProvincia.gridx = 0;
		gbc_btnAñadirProvincia.gridy = 1;
		btnAñadirProvincia.addActionListener(this);
		pnlProvincia.add(btnAñadirProvincia, gbc_btnAñadirProvincia);

		JPanel pnlProfesion = new JPanel();
		pnlProfesion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Profesi\u00F3n del trabajador", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlProfesion = new GridBagConstraints();
		gbc_pnlProfesion.insets = new Insets(0, 0, 5, 0);
		gbc_pnlProfesion.fill = GridBagConstraints.BOTH;
		gbc_pnlProfesion.gridx = 0;
		gbc_pnlProfesion.gridy = 2;
		pnlIzq.add(pnlProfesion, gbc_pnlProfesion);
		GridBagLayout gbl_pnlProfesion = new GridBagLayout();
		gbl_pnlProfesion.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlProfesion.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlProfesion.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_pnlProfesion.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0 };
		pnlProfesion.setLayout(gbl_pnlProfesion);

		JScrollPane scpProfesion = new JScrollPane();
		GridBagConstraints gbc_scpProfesion = new GridBagConstraints();
		gbc_scpProfesion.gridheight = 4;
		gbc_scpProfesion.insets = new Insets(0, 0, 5, 5);
		gbc_scpProfesion.fill = GridBagConstraints.BOTH;
		gbc_scpProfesion.gridx = 0;
		gbc_scpProfesion.gridy = 0;
		pnlProfesion.add(scpProfesion, gbc_scpProfesion);

		lstProfesion = new JList();
		scpProfesion.setViewportView(lstProfesion);

		btnEliminarProfesion = new JButton("Eliminar profesión");
		GridBagConstraints gbc_btnEliminarProfesion = new GridBagConstraints();
		gbc_btnEliminarProfesion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarProfesion.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarProfesion.gridx = 1;
		gbc_btnEliminarProfesion.gridy = 0;
		btnEliminarProfesion.addActionListener(this);
		pnlProfesion.add(btnEliminarProfesion, gbc_btnEliminarProfesion);

		tfProfesion = new JTextField();
		GridBagConstraints gbc_tfProfesion = new GridBagConstraints();
		gbc_tfProfesion.insets = new Insets(0, 0, 0, 5);
		gbc_tfProfesion.fill = GridBagConstraints.BOTH;
		gbc_tfProfesion.gridx = 0;
		gbc_tfProfesion.gridy = 4;
		pnlProfesion.add(tfProfesion, gbc_tfProfesion);
		tfProfesion.setColumns(10);

		btnAñadirProfesion = new JButton("Añadir profesión");
		GridBagConstraints gbc_btnAñadirProfesion = new GridBagConstraints();
		gbc_btnAñadirProfesion.fill = GridBagConstraints.BOTH;
		gbc_btnAñadirProfesion.gridx = 1;
		gbc_btnAñadirProfesion.gridy = 4;
		btnAñadirProfesion.addActionListener(this);
		pnlProfesion.add(btnAñadirProfesion, gbc_btnAñadirProfesion);

		btnAñadirTrabajador = new JButton("Añadir trabajador");
		GridBagConstraints gbc_btnAñadirTrabajador = new GridBagConstraints();
		gbc_btnAñadirTrabajador.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAñadirTrabajador.gridx = 0;
		gbc_btnAñadirTrabajador.gridy = 3;
		btnAñadirTrabajador.addActionListener(this);
		pnlIzq.add(btnAñadirTrabajador, gbc_btnAñadirTrabajador);

		JPanel pnlDerecho = new JPanel();
		contentPane.add(pnlDerecho);
		GridBagLayout gbl_pnlDerecho = new GridBagLayout();
		gbl_pnlDerecho.columnWidths = new int[] { 0 };
		gbl_pnlDerecho.rowHeights = new int[] { 0 };
		gbl_pnlDerecho.columnWeights = new double[] { 1.0 };
		gbl_pnlDerecho.rowWeights = new double[] { 1.0, 0.0, 1.0 };
		pnlDerecho.setLayout(gbl_pnlDerecho);

		JPanel pnlTrabajadores = new JPanel();
		pnlTrabajadores.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Trabajadores disponibles", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlTrabajadores = new GridBagConstraints();
		gbc_pnlTrabajadores.insets = new Insets(0, 0, 5, 0);
		gbc_pnlTrabajadores.fill = GridBagConstraints.BOTH;
		gbc_pnlTrabajadores.gridx = 0;
		gbc_pnlTrabajadores.gridy = 0;
		pnlDerecho.add(pnlTrabajadores, gbc_pnlTrabajadores);
		GridBagLayout gbl_pnlTrabajadores = new GridBagLayout();
		gbl_pnlTrabajadores.columnWidths = new int[] { 0, 0 };
		gbl_pnlTrabajadores.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTrabajadores.rowWeights = new double[] { 1.0 };
		pnlTrabajadores.setLayout(gbl_pnlTrabajadores);

		scpTrabajadores = new JScrollPane();
		GridBagConstraints gbc_scpTrabajadores = new GridBagConstraints();
		gbc_scpTrabajadores.anchor = GridBagConstraints.NORTH;
		gbc_scpTrabajadores.fill = GridBagConstraints.BOTH;
		gbc_scpTrabajadores.insets = new Insets(0, 0, 5, 0);
		gbc_scpTrabajadores.gridx = 0;
		gbc_scpTrabajadores.gridy = 0;
		pnlTrabajadores.add(scpTrabajadores, gbc_scpTrabajadores);

		tblTrabajadores = new JTable();
		tblTrabajadores.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre y apellidos", "Provincia", "Profesi\u00F3n" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scpTrabajadores.setViewportView(tblTrabajadores);

		btnEliminarTrabajador = new JButton("Eliminar trabajador");
		GridBagConstraints gbc_btnEliminarTrabajador = new GridBagConstraints();
		gbc_btnEliminarTrabajador.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarTrabajador.gridx = 0;
		gbc_btnEliminarTrabajador.gridy = 1;
		btnEliminarTrabajador.addActionListener(this);
		pnlDerecho.add(btnEliminarTrabajador, gbc_btnEliminarTrabajador);

		JPanel pnlDetalles = new JPanel();
		pnlDetalles.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Detalle del trabajador", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlDetalles = new GridBagConstraints();
		gbc_pnlDetalles.insets = new Insets(0, 0, 5, 0);
		gbc_pnlDetalles.fill = GridBagConstraints.BOTH;
		gbc_pnlDetalles.gridx = 0;
		gbc_pnlDetalles.gridy = 2;
		pnlDerecho.add(pnlDetalles, gbc_pnlDetalles);
		GridBagLayout gbl_pnlDetalles = new GridBagLayout();
		gbl_pnlDetalles.columnWidths = new int[] { 452, 0 };
		gbl_pnlDetalles.rowHeights = new int[] { 22 };
		gbl_pnlDetalles.columnWeights = new double[] { 1.0 };
		gbl_pnlDetalles.rowWeights = new double[] { 1.0 };
		pnlDetalles.setLayout(gbl_pnlDetalles);

		JScrollPane scpDetalle = new JScrollPane();
		GridBagConstraints gbc_scpDetalle = new GridBagConstraints();
		gbc_scpDetalle.fill = GridBagConstraints.BOTH;
		gbc_scpDetalle.gridx = 0;
		gbc_scpDetalle.gridy = 0;
		pnlDetalles.add(scpDetalle, gbc_scpDetalle);

		textArea = new JTextArea();
		scpDetalle.setViewportView(textArea);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		ResultadoFormulario resultadoFormulario = comprobacionesAñadirTrabajador();;
		
		if (src == btnAñadirTrabajador || src == mntmValidacionDatos) {			
			if(!resultadoFormulario.getResultado()) {
				JOptionPane.showMessageDialog(this, resultadoFormulario.getMensaje(), "Validación de datos", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, resultadoFormulario.getMensaje(), "Validación de datos", JOptionPane.INFORMATION_MESSAGE);
			}	
		}
		else if (src == btnAñadirProvincia) {
			ProvinciasJDialog provDgDialog = new ProvinciasJDialog(this, true);
			provDgDialog.setVisible(true);

		} else if (src == btnEliminarProvincia) {

		}
		if (src == btnEliminarTrabajador) {

		} else if (src == btnEliminarProfesion) {

		} else if (src == btnAñadirProfesion) {

		}
		
	}
	
	
	/**
	 * Comprueba que las credenciales del trabajador sean correctas y genera el mensaje para el JDialog
	 * @return true si ha habido errores, false si no
	 */
	public ResultadoFormulario comprobacionesAñadirTrabajador() {
		boolean error = false;	
		StringBuilder sb = new StringBuilder();
		
		sb.append("Problemas de validación:\n");
		
		if(tfDNI.getText().isEmpty()) {
			sb.append("\n- DNI no puede estar vacío");
			error = true;
		}
		else if ( !validarDNI(tfDNI.getText())) {
			sb.append("\n- DMI carece del formato correcto");
		}
		if(tfNombre.getText().isEmpty()) {
			sb.append("\n- Nombre no puede estar vacío");
			error = true;
		}
		if(tfApe1.getText().isEmpty()) {
			sb.append("\n- Apellido 1 no puede estar vacío");
			error = true;
		}
		if(tfApe2.getText().isEmpty()) {
			sb.append("\n- Apellido 2 no puede estar vacío.");
			error = true;
		}
		
		if(!error) {
			sb.setLength(0);
			sb.append("Validación exitosa");
		}
		
		return new ResultadoFormulario(sb.toString(), error);
		
	
		
	}

	/**
	 * Devuelve true si el DNI es válido y false si no
	 * @param string
	 * @return
	 */
	private boolean validarDNI(String string) {
		if (!(tfDNI.getText().matches("([0-9]{8})[A-Z]"))) {
			return false;
		}
		return true;
	}
	
	private void añadirTrabajador() {
		
	}
	
}
