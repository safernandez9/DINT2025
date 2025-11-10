package tarea10jdialogintercambiodatos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProvinciasJDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel pnlProvincias;
	private JComboBox cmbProvincias;

	/**
	 * Constructor JDialog
	 * 
	 * @param parent como JDialog no es lo mismo que frame y el padre de esta
	 *               ventana es otro JDialog en el constructor se pone JDialog
	 * 
	 * @param modal  Modos, explicado en actividad 9
	 */
	public ProvinciasJDialog(JDialog parent, boolean modal) {
		super(parent, modal);
		crearVentana();
		setTitle("Provincia");
	}

	/**
	 * Crear a ventana
	 */
	public void crearVentana() {
		setBounds(100, 100, 442, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.rowHeights = new int[] { 0 };
		gbl_contentPanel.columnWidths = new int[] { 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0 };
		gbl_contentPanel.rowWeights = new double[] { 1.0 };
		contentPanel.setLayout(gbl_contentPanel);

		pnlProvincias = new JPanel();
		pnlProvincias.setBorder(new TitledBorder(null, "Seleccione unha provincia", TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, null));
		GridBagConstraints gbc_pnlProvincias = new GridBagConstraints();
		gbc_pnlProvincias.fill = GridBagConstraints.BOTH;
		gbc_pnlProvincias.gridx = 0;
		gbc_pnlProvincias.gridy = 0;
		contentPanel.add(pnlProvincias, gbc_pnlProvincias);
		GridBagLayout gbl_pnlProvincias = new GridBagLayout();
		gbl_pnlProvincias.columnWidths = new int[] { 197 };
		gbl_pnlProvincias.rowHeights = new int[] { 22 };
		gbl_pnlProvincias.columnWeights = new double[] { 1.0 };
		gbl_pnlProvincias.rowWeights = new double[] { 0.0 };
		pnlProvincias.setLayout(gbl_pnlProvincias);

		cmbProvincias = new JComboBox();
		cmbProvincias.setModel(new DefaultComboBoxModel(new String[] { "Lugo", "Pontevedra", "A Coruña", "Ourense" }));
		GridBagConstraints gbc_cmbProvincias = new GridBagConstraints();
		gbc_cmbProvincias.insets = new Insets(0, 20, 0, 20);
		gbc_cmbProvincias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbProvincias.gridx = 0;
		gbc_cmbProvincias.gridy = 0;
		pnlProvincias.add(cmbProvincias, gbc_cmbProvincias);

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
		if (e.getSource() == btnAceptar) {
			btnAceptarActionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			dispose();
		}

	}

	/**
	 * Codigo del boton aceptar. Convierte a string la opción seleccionada en el comboBox
	 * y llama al metodo del dialogo padre para establecer la provincia en el con
	 * EstablecerProvincia
	 * 
	 * @param evt
	 */
	private void btnAceptarActionPerformed(ActionEvent evt) {
		String provincia = (String) cmbProvincias.getModel().getElementAt(cmbProvincias.getSelectedIndex());
		((DatosNovoUsuarioJDialog) getParent()).establecerProvincia(provincia);
		dispose();
	}
}
