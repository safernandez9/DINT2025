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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		gbl_pnlForm.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0};
		gbl_pnlForm.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		pnlForm.setLayout(gbl_pnlForm);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		pnlForm.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		pnlForm.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		pnlForm.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 1;
		pnlForm.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		pnlForm.add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3_4 = new GridBagConstraints();
		gbc_lblNewLabel_3_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_4.gridx = 2;
		gbc_lblNewLabel_3_4.gridy = 1;
		pnlForm.add(lblNewLabel_3_4, gbc_lblNewLabel_3_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 1;
		pnlForm.add(textField_3, gbc_textField_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_2.gridx = 0;
		gbc_lblNewLabel_3_2.gridy = 2;
		pnlForm.add(lblNewLabel_3_2, gbc_lblNewLabel_3_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 2;
		pnlForm.add(textField_5, gbc_textField_5);
		
		JLabel lblNewLabel_3_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3_3 = new GridBagConstraints();
		gbc_lblNewLabel_3_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3.gridx = 0;
		gbc_lblNewLabel_3_3.gridy = 3;
		pnlForm.add(lblNewLabel_3_3, gbc_lblNewLabel_3_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		pnlForm.add(textField_4, gbc_textField_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 0;
		pnlForm.add(textField_2, gbc_textField_2);
		
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
		gbc_taDescripcion.gridheight = 2;
		gbc_taDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_taDescripcion.fill = GridBagConstraints.BOTH;
		gbc_taDescripcion.gridx = 0;
		gbc_taDescripcion.gridy = 5;
		pnlForm.add(taDescripcion, gbc_taDescripcion);
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(new Color(25, 25, 112));
		contentPane.add(pnlCentro, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Tarea3CombinarLayouts.class.getResource("/tarea3combinarlayouts/Captura de pantalla 2025-10-13 120728.png")));
		lblNewLabel_1.setBackground(new Color(25, 25, 112));
		pnlCentro.add(lblNewLabel_1);

	}

}
