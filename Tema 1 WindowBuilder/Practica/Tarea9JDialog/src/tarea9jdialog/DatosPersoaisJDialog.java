package tarea9jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.GestorVentanas;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DatosPersoaisJDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNome;
	private JTextField tfApellidos;
	private Tarea9JDialog xanelaPai;
	private JButton btnAceptar;

	/**
	 * Una superclase gestiona con el padre y un boolean si la ventana será modal o
	 * no Convierto padre al tipo concreto en vez del Frame genérico que uso
	 * ???????????? Creo la interfaz de la ventana convirtiendo en metodo lo que
	 * solemos usar de constructor
	 * 
	 * @param padre
	 * @param modal
	 */
	public DatosPersoaisJDialog(Frame padre, boolean modal) {
		super(padre, modal);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GestorVentanas.eliminarVentanaDatosPersoais((DatosPersoaisJDialog) e.getWindow());
				GestorVentanas.cerrarVentanasDatosPersoais();
			}
		});
		xanelaPai = (Tarea9JDialog) padre;
		this.crearVentana();
	}

	public void crearVentana() {
		setBounds(100, 100, 460, 138);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		contentPanel.add(lblNome, gbc_lblNome);

		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		contentPanel.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);

		JLabel lblApelidos = new JLabel("Apelidos");
		GridBagConstraints gbc_lblApelidos = new GridBagConstraints();
		gbc_lblApelidos.insets = new Insets(0, 0, 0, 5);
		gbc_lblApelidos.gridx = 0;
		gbc_lblApelidos.gridy = 1;
		contentPanel.add(lblApelidos, gbc_lblApelidos);

		tfApellidos = new JTextField();
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 1;
		contentPanel.add(tfApellidos, gbc_tfApellidos);
		tfApellidos.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnAceptar = new JButton("Aceptar");
		buttonPane.add(btnAceptar);
		btnAceptar.addActionListener(this);

	}
	
	/**
	 * Gestor de botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			btnAceoptarActionPerformed(e);
		}

	}

	/**
	 * Accion del boton Aceptar
	 * @param e
	 */
	private void btnAceoptarActionPerformed(ActionEvent e) {
		if (tfNome.getText().trim().compareTo("") == 0) {
			((Tarea9JDialog) getParent()).gestionMensajesError(1);
			return;
		}
		if (tfApellidos.getText().trim().compareTo("") == 0) {
			((Tarea9JDialog) getParent()).gestionMensajesError(2);
			return;
		}

	}
}
