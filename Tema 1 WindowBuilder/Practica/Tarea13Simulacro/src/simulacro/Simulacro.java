package simulacro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;

public class Simulacro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbAlumnos;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAñadirAlumno;
	private JMenu mnAlumnos;
	private JMenu mnResultados;
	private DefaultTableModel modelo;
	private JMenuItem mntmAñadirAlumno;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmActualizar;
	private Alumno alumnoDefault = new Alumno("77013586H", "NOMBRE", "APELLIDOS");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulacro frame = new Simulacro();
					frame.setVisible(true);
					frame.setTitle("Gestión alumnos");
					frame.setMinimumSize(frame.getSize());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// AÑADIR CTRL + X

	/**
	 * Create the frame.
	 */
	public Simulacro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 632);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAlumnos = new JMenu("Alumnos");
		menuBar.add(mnAlumnos);

		mntmAñadirAlumno = new JMenuItem("Añadir alumno  Ctrl+1");
		mnAlumnos.add(mntmAñadirAlumno);
		mntmAñadirAlumno.addActionListener(this);

		// --- ATAJOS DE TECLADO

		KeyStroke ks = KeyStroke.getKeyStroke("control 1");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ks, "accionAñadir");
		getRootPane().getActionMap().put("accionAñadir", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mntmAñadirAlumno.doClick();
			}
		});

		mnResultados = new JMenu("Resultados");
		menuBar.add(mnResultados);

		mntmActualizar = new JMenuItem("Actualizar  Ctrl+2");
		mnResultados.add(mntmActualizar);
		mntmActualizar.addActionListener(this);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control 2"),
				"accionActualizar");

		getRootPane().getActionMap().put("accionActualizar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mntmActualizar.doClick();
			}
		});

		mntmEliminar = new JMenuItem("Eliminar Ctrl+3");
		mnResultados.add(mntmEliminar);
		mntmEliminar.addActionListener(this);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control 3"),
				"accionEliminar");

		getRootPane().getActionMap().put("accionEliminar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mntmEliminar.doClick();
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel pnlGestionAlumnos = new JPanel();
		pnlGestionAlumnos.setBorder(
				new TitledBorder(null, "Gesti\u00F3n alumnos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlGestionAlumnos = new GridBagConstraints();
		gbc_pnlGestionAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGestionAlumnos.fill = GridBagConstraints.BOTH;
		gbc_pnlGestionAlumnos.gridx = 0;
		gbc_pnlGestionAlumnos.gridy = 0;
		contentPane.add(pnlGestionAlumnos, gbc_pnlGestionAlumnos);
		GridBagLayout gbl_pnlGestionAlumnos = new GridBagLayout();
		gbl_pnlGestionAlumnos.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlGestionAlumnos.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlGestionAlumnos.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlGestionAlumnos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlGestionAlumnos.setLayout(gbl_pnlGestionAlumnos);

		JLabel lblDNI = new JLabel("DNI");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.WEST;
		gbc_lblDNI.insets = new Insets(20, 20, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 0;
		pnlGestionAlumnos.add(lblDNI, gbc_lblDNI);

		tfDNI = new JTextField();
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
		gbc_lblApellidos.insets = new Insets(0, 20, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 2;
		pnlGestionAlumnos.add(lblApellidos, gbc_lblApellidos);

		tfApellidos = new JTextField();
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.insets = new Insets(0, 0, 5, 20);
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 2;
		pnlGestionAlumnos.add(tfApellidos, gbc_tfApellidos);
		tfApellidos.setColumns(10);

		btnAñadirAlumno = new JButton("Añadir alumno");
		btnAñadirAlumno.addActionListener(this);
		GridBagConstraints gbc_btnAñadirAlumno = new GridBagConstraints();
		gbc_btnAñadirAlumno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAñadirAlumno.gridwidth = 2;
		gbc_btnAñadirAlumno.insets = new Insets(0, 20, 20, 20);
		gbc_btnAñadirAlumno.gridx = 0;
		gbc_btnAñadirAlumno.gridy = 3;
		pnlGestionAlumnos.add(btnAñadirAlumno, gbc_btnAñadirAlumno);

		JPanel pnlResultados = new JPanel();
		pnlResultados
				.setBorder(new TitledBorder(null, "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlResultados = new GridBagConstraints();
		gbc_pnlResultados.fill = GridBagConstraints.BOTH;
		gbc_pnlResultados.gridx = 0;
		gbc_pnlResultados.gridy = 1;
		contentPane.add(pnlResultados, gbc_pnlResultados);
		GridBagLayout gbl_pnlResultados = new GridBagLayout();
		gbl_pnlResultados.columnWidths = new int[] { 0, 0 };
		gbl_pnlResultados.rowHeights = new int[] { 0, 0 };
		gbl_pnlResultados.columnWeights = new double[] { 1.0, 1.0 };
		gbl_pnlResultados.rowWeights = new double[] { 1.0, 0.0 };
		pnlResultados.setLayout(gbl_pnlResultados);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlResultados.add(scrollPane, gbc_scrollPane);

		
		// TABLA
		
		tbAlumnos = new JTable();
		tbAlumnos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "DNI", "Nombre", "Apellidos" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		modelo = (DefaultTableModel) tbAlumnos.getModel();
		
		// Añadir un default para pruebas
		modelo.addRow(new Object[]{alumnoDefault.getDNI(), alumnoDefault.getNombre(), alumnoDefault.getApellidos()});
		
		
		// Centrar Nombres de las columnas de la tabla y permitir seleccion solo de una fila
		
		((DefaultTableCellRenderer) tbAlumnos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		tbAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbAlumnos);
		

		

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnActualizar.anchor = GridBagConstraints.NORTH;
		gbc_btnActualizar.gridx = 0;
		gbc_btnActualizar.gridy = 1;
		pnlResultados.add(btnActualizar, gbc_btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 1;
		pnlResultados.add(btnEliminar, gbc_btnEliminar);

	}

	// LEER DE TABLA
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadirAlumno || e.getSource() == mntmAñadirAlumno) {
			if (comprobacionesAlumno()) {
				añadirAlumno();
			}
		}
		if (e.getSource() == btnActualizar || e.getSource() == mntmActualizar) {
			if (tbAlumnos.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Alumno a = leerAlumnoTabla();
				ActualizarDatosJDialog dlgActualizarDatos = new ActualizarDatosJDialog(this, true, a.getDNI(),
						a.getNombre(), a.getApellidos(), tbAlumnos.getSelectedRow());
				dlgActualizarDatos.setVisible(true);
			}
		}
		if (e.getSource() == btnEliminar || e.getSource() == mntmEliminar) {
			if (tbAlumnos.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else {

				modelo.removeRow(tbAlumnos.getSelectedRow());
				JOptionPane.showMessageDialog(this, "Alumno eliminado correctamente");
			}

		}

	}
	

	private Alumno leerAlumnoTabla() {
		String dni = (String) modelo.getValueAt(tbAlumnos.getSelectedRow(), 0);
		String nom = (String) modelo.getValueAt(tbAlumnos.getSelectedRow(), 1);
		String ape = (String) modelo.getValueAt(tbAlumnos.getSelectedRow(), 2);
		return new Alumno(dni, nom, ape);
	}

	/**
	 * Comprueba dentro si los campos del panel de formulario están vacíos y si el
	 * DNI no es váido. Llama a otro método para comprobar si el DNI está repetido
	 * en la tabla. Muestra en caso de error un mensaje con los errores que ha
	 * habido y devuelve un boolean en función del resultado de las comprobaciones.
	 * 
	 * @return
	 */
	private boolean comprobacionesAlumno() {

		boolean valido = true;
		StringBuilder sb = new StringBuilder();

		if (tfDNI.getText().trim().isEmpty() || tfNombre.getText().trim().isEmpty() || tfApellidos.getText().trim().isEmpty()) {
			sb.append("\nTodos los campos de texto deben estar cubiertos");
			valido = false;
		}
		if (!(tfDNI.getText().matches("([0-9]{8})[A-Za-z]"))) {
			sb.append("\nEl DNI está en formato erróneo");
			valido = false;
		}
		if (comprobarRepetido()) {
			sb.append("\nEl alumno con DNI" + tfDNI.getText() + " ya ha sido añadido previamente");
			valido = false;
		}

		if (!valido) {
			JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.WARNING_MESSAGE);
		}

		return valido;

	}

	/**
	 * Comprueba si un dni está en la tabla
	 * 
	 * @return
	 */
	private boolean comprobarRepetido() {

		for (int i = 0; i < modelo.getRowCount(); i++) {
			String dni = modelo.getValueAt(i, 0).toString();
			if (dni.equals(tfDNI.getText().toUpperCase())) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Añade un alumno al modelo
	 */
	private void añadirAlumno() {

		String dni = tfDNI.getText();
		String nombre = tfNombre.getText();
		String apellidos = tfApellidos.getText();

		// Crear Alumno
		Alumno alumno = new Alumno(dni, nombre, apellidos);

		// Añadir alumno a la tabla
		//  o bien, modelo.addRow(new Object[]{a.getNombre(), a.getDni(), a.getEdad()});
		
		modelo.setRowCount(modelo.getRowCount() + 1);
		modelo.setValueAt(alumno.getDNI().toUpperCase(), modelo.getRowCount() - 1, 0);
		modelo.setValueAt(alumno.getNombre(), modelo.getRowCount() - 1, 1);
		modelo.setValueAt(alumno.getApellidos(), modelo.getRowCount() - 1, 2);

	}

	public void actualizarTabla(String dato, int fila, int tipoDato) {
		
		int columna = tipoDato;
		
			modelo.setValueAt(dato, fila, columna);
	}
}
