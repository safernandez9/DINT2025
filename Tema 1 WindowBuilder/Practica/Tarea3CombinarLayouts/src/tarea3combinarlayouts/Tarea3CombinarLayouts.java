package tarea3combinarlayouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;

public class Tarea3CombinarLayouts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfContrasena;
	private JTextField tfDocumento;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfNIF;
	private JTextField tfTelefono;
	private JTextField tfCurso;
	private JTextField tfDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea3CombinarLayouts frame = new Tarea3CombinarLayouts();
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
	public Tarea3CombinarLayouts() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlFlow = new JPanel();
		pnlFlow.setBackground(new Color(128, 255, 0));
		contentPane.add(pnlFlow, BorderLayout.NORTH);
		pnlFlow.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 10));
		
		JPanel pnlGrid = new JPanel();
		pnlGrid.setBackground(new Color(124, 252, 0));
		pnlFlow.add(pnlGrid);
		pnlGrid.setLayout(new GridLayout(2, 3, 10, 5));
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBackground(new Color(128, 255, 0));
		pnlGrid.add(lblDocumento);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		pnlGrid.add(lblContrasena);
		
		JPanel pnlVacio1 = new JPanel();
		pnlVacio1.setBackground(new Color(124, 252, 0));
		pnlGrid.add(pnlVacio1);
		
		tfDocumento = new JTextField();
		pnlGrid.add(tfDocumento);
		tfDocumento.setColumns(10);
		
		tfContrasena = new JTextField();
		pnlGrid.add(tfContrasena);
		tfContrasena.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		pnlGrid.add(btnIniciarSesion);
		
		JPanel pnlSouth = new JPanel();
		FlowLayout fl_pnlSouth = (FlowLayout) pnlSouth.getLayout();
		fl_pnlSouth.setVgap(10);
		pnlSouth.setBackground(new Color(124, 252, 0));
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JLabel lblDesarrollado = new JLabel("Desarrollado por: Saúl Fernández Salgado - DAM2 Curso 2025");
		lblDesarrollado.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlSouth.add(lblDesarrollado);
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(new Color(0, 0, 128));
		contentPane.add(pnlWest, BorderLayout.EAST);
		pnlWest.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlRegistro = new JPanel();
		pnlWest.add(pnlRegistro, BorderLayout.NORTH);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		pnlRegistro.add(lblRegistro);
		
		JPanel pnlRegistrar = new JPanel();
		pnlWest.add(pnlRegistrar, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		pnlRegistrar.add(btnRegistrar);
		
		JPanel pnlForm = new JPanel();
		pnlForm.setBackground(new Color(153, 0, 102));
		pnlWest.add(pnlForm, BorderLayout.CENTER);
		GridBagLayout gbl_pnlForm = new GridBagLayout();
		gbl_pnlForm.rowHeights = new int[] {60, 60, 60, 60, 60, 60, 60};
		gbl_pnlForm.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_pnlForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		pnlForm.setLayout(gbl_pnlForm);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		pnlForm.add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 0;
		pnlForm.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNIF = new JLabel("Documento");
		GridBagConstraints gbc_lblNIF = new GridBagConstraints();
		gbc_lblNIF.insets = new Insets(0, 0, 5, 5);
		gbc_lblNIF.gridx = 2;
		gbc_lblNIF.gridy = 0;
		pnlForm.add(lblNIF, gbc_lblNIF);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 1;
		pnlForm.add(lblApellidos, gbc_lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 1;
		pnlForm.add(tfApellidos, gbc_tfApellidos);
		
		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 2;
		gbc_lblTelefono.gridy = 1;
		pnlForm.add(lblTelefono, gbc_lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		GridBagConstraints gbc_tfTelefono = new GridBagConstraints();
		gbc_tfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_tfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelefono.gridx = 3;
		gbc_tfTelefono.gridy = 1;
		pnlForm.add(tfTelefono, gbc_tfTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 2;
		pnlForm.add(lblDireccion, gbc_lblDireccion);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		GridBagConstraints gbc_tfDireccion = new GridBagConstraints();
		gbc_tfDireccion.gridwidth = 3;
		gbc_tfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_tfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDireccion.gridx = 1;
		gbc_tfDireccion.gridy = 2;
		pnlForm.add(tfDireccion, gbc_tfDireccion);
		
		JLabel lblCurso = new JLabel("Curso");
		GridBagConstraints gbc_lblCurso = new GridBagConstraints();
		gbc_lblCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurso.gridx = 0;
		gbc_lblCurso.gridy = 3;
		pnlForm.add(lblCurso, gbc_lblCurso);
		
		tfCurso = new JTextField();
		tfCurso.setColumns(10);
		GridBagConstraints gbc_tfCurso = new GridBagConstraints();
		gbc_tfCurso.gridwidth = 3;
		gbc_tfCurso.insets = new Insets(0, 0, 5, 5);
		gbc_tfCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCurso.gridx = 1;
		gbc_tfCurso.gridy = 3;
		pnlForm.add(tfCurso, gbc_tfCurso);
		
		tfNIF = new JTextField();
		tfNIF.setColumns(10);
		GridBagConstraints gbc_tfNIF = new GridBagConstraints();
		gbc_tfNIF.insets = new Insets(0, 0, 5, 0);
		gbc_tfNIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNIF.gridx = 3;
		gbc_tfNIF.gridy = 0;
		pnlForm.add(tfNIF, gbc_tfNIF);
		
		JLabel lblDescripcion = new JLabel("Descripcion corta");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.gridwidth = 4;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 4;
		pnlForm.add(lblDescripcion, gbc_lblDescripcion);
		
		JTextArea taDescripcion = new JTextArea();
		GridBagConstraints gbc_taDescripcion = new GridBagConstraints();
		gbc_taDescripcion.gridwidth = 4;
		gbc_taDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_taDescripcion.fill = GridBagConstraints.BOTH;
		gbc_taDescripcion.gridx = 0;
		gbc_taDescripcion.gridy = 5;
		pnlForm.add(taDescripcion, gbc_taDescripcion);
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(new Color(25, 25, 112));
		contentPane.add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Tarea3CombinarLayouts.class.getResource("/tarea3combinarlayouts/Captura de pantalla 2025-10-13 120728.png")));
		lblNewLabel_1.setBackground(new Color(25, 25, 112));
		pnlCentro.add(lblNewLabel_1);

	}

}
