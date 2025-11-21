package tarea9jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import examen.GestorVentanas;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DatosAcademicosJDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Tarea9JDialog xanelaPai;
	private JButton btnAceptar;
	private JRadioButton rdbtESO;
	private JRadioButton rdbtBACH;
	private JRadioButton rdbtFP;
	private JRadioButton rdbtUNI;

	public DatosAcademicosJDialog(Frame padre, boolean modal) {
		super(padre, modal);
		
		// Añadir acción cuando se cierre una ventana
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GestorVentanas.eliminarVentanaDatosAcademicos((DatosAcademicosJDialog)e.getWindow());
				GestorVentanas.cerrarVentanasDatosAcademicos();
			}
		});
		xanelaPai = (Tarea9JDialog) padre;
		this.crearVentana();
	}

	/**
	 * Create the dialog.
	 */
	public void crearVentana() {
		setBounds(100, 100, 461, 182);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 445 };
		gridBagLayout.rowHeights = new int[] { 143 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0 };
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new TitledBorder(null, "Indique o maximo grado acadado", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		rdbtESO = new JRadioButton("ESO");
		GridBagConstraints gbc_rdbtESO = new GridBagConstraints();
		gbc_rdbtESO.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtESO.insets = new Insets(0, 10, 5, 0);
		gbc_rdbtESO.gridx = 0;
		gbc_rdbtESO.gridy = 0;
		contentPanel.add(rdbtESO, gbc_rdbtESO);

		rdbtBACH = new JRadioButton("Bacharelato");
		GridBagConstraints gbc_rdbtBACH = new GridBagConstraints();
		gbc_rdbtBACH.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtBACH.insets = new Insets(0, 10, 5, 0);
		gbc_rdbtBACH.gridx = 0;
		gbc_rdbtBACH.gridy = 1;
		contentPanel.add(rdbtBACH, gbc_rdbtBACH);

		rdbtFP = new JRadioButton("FP");
		GridBagConstraints gbc_rdbtFP = new GridBagConstraints();
		gbc_rdbtFP.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtFP.insets = new Insets(0, 10, 5, 0);
		gbc_rdbtFP.gridx = 0;
		gbc_rdbtFP.gridy = 2;
		contentPanel.add(rdbtFP, gbc_rdbtFP);

		rdbtUNI = new JRadioButton("Universidade");
		GridBagConstraints gbc_rdbtUNI = new GridBagConstraints();
		gbc_rdbtUNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtUNI.insets = new Insets(0, 10, 0, 0);
		gbc_rdbtUNI.gridx = 0;
		gbc_rdbtUNI.gridy = 3;
		contentPanel.add(rdbtUNI, gbc_rdbtUNI);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(5, 0, 0, 0);
		gbc_btnAceptar.anchor = GridBagConstraints.NORTH;
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 0;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
	}


	/**
	 * Gestor de botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			btnAceptarActionPerformed(e);
		}

	}

	/**
	 * Código del botón Aceptar
	 * Llama al método de la ventana padre para gestionar el mensaje e 
	 * imprimir el grado de estudios
	 * 
	 * @param e
	 */
	private void btnAceptarActionPerformed(ActionEvent e) {
		int grao;
		if (rdbtESO.isSelected())
			grao = 1;
		else if (rdbtBACH.isSelected())
			grao = 2;
		else if (rdbtFP.isSelected())
			grao = 3;
		else
			grao = 4;
		xanelaPai.gestionDeMensajesDeGradoAlcanzado(grao);

	}

}
