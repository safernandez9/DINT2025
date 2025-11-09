package tarea7jcombobox;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JComboBox;

public class Tarea7JComboBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JTextField tfModelo;
	private JLabel lblCor;
	private JTextField tfCor;
	private JLabel lblAncho;
	private JTextField tfAncho;
	private JLabel lblCM1;
	private JLabel lblAlto;
	private JTextField tfAlto;
	private JLabel lblCM2;
	private JButton btnEngadir;
	private JScrollPane scpAlfombras;
	private JComboBox comboBoxAlfombras;
	private JButton btnInformacion;
	private JButton btnEliminarUna;
	private JButton btnEliminarTodas;

	// Pequena "base de datos" de concellos por provincias

	private String[] concellosCorunha = { "Betanzos", "Ferrol", "Pontedeume" };
	private String[] concellosLugo = { "Foz", "Quiroga", "Triacastela" };
	private String[] concellosOurense = { "Bande", "Castro Caldelas", "Maside" };
	private String[] concellosPontevedra = { "Cangas", "Bueu", "Mar n", "Pontevedra", "Tomi o" };

	// Modelo de datos para la lista de concellos de cada provincia
	private DefaultListModel<String[]> modeloConcellos = new DefaultListModel<String[]>();

	// Modelo de datos para la lista de alfombras. En combobox no le tipamos un tipo
	// concreto <Alfombra>.
	// Admite cualquier tipo de objeto pero a cambio requiere casteos al obtener los
	// elementos
	private DefaultComboBoxModel modeloAlfombras = new DefaultComboBoxModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea7JComboBox frame = new Tarea7JComboBox();
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
	public Tarea7JComboBox() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setName("Alfombras");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(
				new TitledBorder(null, "Alfombra", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		pnlDatos.setName("Nova Alfombra");
		GridBagConstraints gbc_pnlDatos = new GridBagConstraints();
		gbc_pnlDatos.insets = new Insets(0, 0, 5, 0);
		gbc_pnlDatos.fill = GridBagConstraints.BOTH;
		gbc_pnlDatos.gridx = 0;
		gbc_pnlDatos.gridy = 0;
		contentPane.add(pnlDatos, gbc_pnlDatos);
		GridBagLayout gbl_pnlDatos = new GridBagLayout();
		gbl_pnlDatos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlDatos.rowHeights = new int[] { 0, 0 };
		gbl_pnlDatos.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_pnlDatos.rowWeights = new double[] { 1.0, 1.0 };
		pnlDatos.setLayout(gbl_pnlDatos);

		// FORMULARIO

		lblModelo = new JLabel("Modelo");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.fill = GridBagConstraints.BOTH;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 0;
		pnlDatos.add(lblModelo, gbc_lblModelo);

		tfModelo = new JTextField();
		GridBagConstraints gbc_tfModelo = new GridBagConstraints();
		gbc_tfModelo.gridwidth = 7;
		gbc_tfModelo.insets = new Insets(0, 0, 5, 5);
		gbc_tfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfModelo.gridx = 1;
		gbc_tfModelo.gridy = 0;
		pnlDatos.add(tfModelo, gbc_tfModelo);
		tfModelo.setColumns(10);

		lblCor = new JLabel("Cor");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.anchor = GridBagConstraints.EAST;
		gbc_lblCor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCor.gridx = 0;
		gbc_lblCor.gridy = 1;
		pnlDatos.add(lblCor, gbc_lblCor);

		tfCor = new JTextField();
		GridBagConstraints gbc_tfCor = new GridBagConstraints();
		gbc_tfCor.insets = new Insets(0, 0, 5, 5);
		gbc_tfCor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCor.gridx = 1;
		gbc_tfCor.gridy = 1;
		pnlDatos.add(tfCor, gbc_tfCor);
		tfCor.setColumns(10);

		lblAncho = new JLabel("Ancho");
		GridBagConstraints gbc_lblAncho = new GridBagConstraints();
		gbc_lblAncho.insets = new Insets(0, 0, 5, 5);
		gbc_lblAncho.anchor = GridBagConstraints.EAST;
		gbc_lblAncho.gridx = 2;
		gbc_lblAncho.gridy = 1;
		pnlDatos.add(lblAncho, gbc_lblAncho);

		tfAncho = new JTextField();
		GridBagConstraints gbc_tfAncho = new GridBagConstraints();
		tfAncho.setDocument(new LimiteLonxitudeJTextField(5));
		gbc_tfAncho.insets = new Insets(0, 0, 5, 5);
		gbc_tfAncho.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAncho.gridx = 3;
		gbc_tfAncho.gridy = 1;
		pnlDatos.add(tfAncho, gbc_tfAncho);
		tfAncho.setColumns(10);

		lblCM1 = new JLabel("(cm)");
		GridBagConstraints gbc_lblCM1 = new GridBagConstraints();
		gbc_lblCM1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCM1.gridx = 4;
		gbc_lblCM1.gridy = 1;
		pnlDatos.add(lblCM1, gbc_lblCM1);

		lblAlto = new JLabel("Alto");
		GridBagConstraints gbc_lblAlto = new GridBagConstraints();
		gbc_lblAlto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlto.anchor = GridBagConstraints.EAST;
		gbc_lblAlto.gridx = 5;
		gbc_lblAlto.gridy = 1;
		pnlDatos.add(lblAlto, gbc_lblAlto);

		tfAlto = new JTextField();
		GridBagConstraints gbc_tfAlto = new GridBagConstraints();
		tfAncho.setDocument(new LimiteLonxitudeJTextField(5));
		gbc_tfAlto.insets = new Insets(0, 0, 5, 5);
		gbc_tfAlto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAlto.gridx = 6;
		gbc_tfAlto.gridy = 1;
		pnlDatos.add(tfAlto, gbc_tfAlto);
		tfAlto.setColumns(10);

		lblCM2 = new JLabel("(cm)");
		GridBagConstraints gbc_lblCM2 = new GridBagConstraints();
		gbc_lblCM2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCM2.gridx = 7;
		gbc_lblCM2.gridy = 1;
		pnlDatos.add(lblCM2, gbc_lblCM2);

		btnEngadir = new JButton("Engadir");
		GridBagConstraints gbc_btnEngadir = new GridBagConstraints();
		gbc_btnEngadir.insets = new Insets(0, 0, 5, 0);
		gbc_btnEngadir.gridx = 8;
		gbc_btnEngadir.gridy = 0;

		// Lo asocio al ActionListener para que detecte cuano se pulsa
		btnEngadir.addActionListener(this);
		pnlDatos.add(btnEngadir, gbc_btnEngadir);

		// PANEL INFERIOR

		JPanel pnlCombo = new JPanel();
		pnlCombo.setBorder(new TitledBorder(null, "Alfombras dispo\u00F1ibles", TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, null));
		GridBagConstraints gbc_pnlCombo = new GridBagConstraints();
		gbc_pnlCombo.insets = new Insets(0, 0, 5, 0);
		gbc_pnlCombo.fill = GridBagConstraints.BOTH;
		gbc_pnlCombo.gridx = 0;
		gbc_pnlCombo.gridy = 1;
		contentPane.add(pnlCombo, gbc_pnlCombo);
		pnlCombo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlInferior = new JPanel();
		pnlCombo.add(pnlInferior);
		GridBagLayout gbl_pnlInferior = new GridBagLayout();
		gbl_pnlInferior.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlInferior.rowHeights = new int[] { 0, 0 };
		gbl_pnlInferior.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_pnlInferior.rowWeights = new double[] { 0.0, 0.0 };
		pnlInferior.setLayout(gbl_pnlInferior);

		scpAlfombras = new JScrollPane();
		GridBagConstraints gbc_scpAlfombras = new GridBagConstraints();
		gbc_scpAlfombras.fill = GridBagConstraints.HORIZONTAL;
		gbc_scpAlfombras.anchor = GridBagConstraints.NORTH;
		gbc_scpAlfombras.gridwidth = 3;
		gbc_scpAlfombras.insets = new Insets(0, 0, 5, 0);
		gbc_scpAlfombras.gridx = 0;
		gbc_scpAlfombras.gridy = 0;
		pnlInferior.add(scpAlfombras, gbc_scpAlfombras);

		// Le adjunto al JComboBox el modelo de datos
		comboBoxAlfombras = new JComboBox();
		comboBoxAlfombras.setModel(modeloAlfombras);
		scpAlfombras.setViewportView(comboBoxAlfombras);

		btnInformacion = new JButton("Información da alfombra");
		GridBagConstraints gbc_btnInformacion = new GridBagConstraints();
		gbc_btnInformacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInformacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnInformacion.gridx = 0;
		gbc_btnInformacion.gridy = 1;
		pnlInferior.add(btnInformacion, gbc_btnInformacion);

		btnEliminarUna = new JButton("Eliminar Alfombra");
		GridBagConstraints gbc_btnEliminarUna = new GridBagConstraints();
		gbc_btnEliminarUna.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarUna.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarUna.gridx = 1;
		gbc_btnEliminarUna.gridy = 1;
		pnlInferior.add(btnEliminarUna, gbc_btnEliminarUna);

		btnEliminarTodas = new JButton("Eliminar todas");
		GridBagConstraints gbc_btnEliminarTodas = new GridBagConstraints();
		gbc_btnEliminarTodas.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarTodas.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarTodas.gridx = 2;
		gbc_btnEliminarTodas.gridy = 1;
		pnlInferior.add(btnEliminarTodas, gbc_btnEliminarTodas);

	}

	// Metodo que recibe todos los ActionEvents y actua según quien se los envíe
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnEngadir) {
			engadir();
		}
		if (e.getSource() == btnInformacion) {
			mostrarInfo();
		}
		if (e.getSource() == btnEliminarUna) {
			borrarAlfombraSeleccionada();
		}
		if (e.getSource() == btnEliminarTodas) {
			borrarTodasAlfombras();
		}
	}

	// Añadir alfombra
	private void engadir() {

		// Comprobar que se han rellenado todos los campos
		if (!tfModelo.getText().trim().isEmpty() && !tfCor.getText().trim().isEmpty()
				&& !tfAncho.getText().trim().isEmpty() && !tfAlto.getText().trim().isEmpty()) {
			Alfombra a = new Alfombra(tfModelo.getText(), tfCor.getText(), Integer.parseInt(tfAncho.getText()),
					Integer.parseInt(tfAlto.getText()));

			// Añadir alfombra al modelo de datos del JComboBox
			modeloAlfombras.addElement(a);

			// Limpar campos de texto
			tfModelo.setText("");
			tfCor.setText("");
			tfAncho.setText("");
			tfAlto.setText("");

		} else {
			// Primer campo contexto en el que se mostrará el pop-up. Segundo campo mensaje.
			// Tercer campo título. Cuarto campo tipo de mensaje.
			JOptionPane.showMessageDialog(this, "Rellene todos os campos para engadir unha alfombra.", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Mostrar información das alfombras seleccionadas
	private void mostrarInfo() {

		// Comprobamos que haya alfombras en el modelo
		if (modeloAlfombras.getSize() == 0) {
			JOptionPane.showMessageDialog(this, "Non hai alfombras dispoñibles");
			return;
		}

		// Compruebo si hay alguna seleccionada, si no la hay, getIndex devolverá -1
		if (comboBoxAlfombras.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar ao menos unha alfombra");
			return;
		}

		String mensaxe = "";

		// En este caso al ser seleccion simple, cojemos el elemento seleccionado.
		// Recordar el casteo.
		Alfombra alfombra = (Alfombra) modeloAlfombras.getElementAt(comboBoxAlfombras.getSelectedIndex());

		mensaxe = mensaxe + "MODELO: " + alfombra.getModelo() + "\nCOR: " + alfombra.getCor() + "\nANCHO: "
				+ alfombra.getAncho() + " cm\nALTO: " + alfombra.getAlto() + " cm\n\n";

		// Mostras información das alfombra por pantalla
		JOptionPane.showMessageDialog(this, mensaxe, "Información das alfombras", JOptionPane.INFORMATION_MESSAGE);

	}

	// Borrar unha alfombra seleccionada
	private void borrarAlfombraSeleccionada() {

		// Comprobamos que haya alfombras
		if (modeloAlfombras.getSize() == 0) {
			JOptionPane.showMessageDialog(this, "Non hai alfombras dispoñibles");
			return;
		}

		// Compruebo si hay alguna seleccionada, si no la hay, getIndex devolverá -1
		if (comboBoxAlfombras.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar unha alfombra para eliminarla.");
			return;
		}

		modeloAlfombras.removeElementAt(comboBoxAlfombras.getSelectedIndex());

	}

	// Borrar todas as alfombras
	private void borrarTodasAlfombras() {

		// Comprobamos que haya alfombras
		if (modeloAlfombras.getSize() == 0) {
			JOptionPane.showMessageDialog(this, "Non hai alfombras dispoñibles");
			return;
		}

		modeloAlfombras.removeAllElements();
	}

}