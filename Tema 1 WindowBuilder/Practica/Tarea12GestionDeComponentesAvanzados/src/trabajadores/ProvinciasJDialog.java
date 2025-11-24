package trabajadores;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class ProvinciasJDialog extends JDialog implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final String[] provincias = { "Álava", "Albacete", "Alicante", "Almería", "Asturias",
			"Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón",
			"Ciudad Real", "Córdoba", "Cuenca", "Girona", "Granada", "Guadalajara", "Guipúzcoa",
			"Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña", "La Rioja", "Las Palmas",
			"León", "Lleida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Palencia",
			"Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona",
			"Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza", "Ceuta", "Melilla" 
			};
	
	private DefaultComboBoxModel<String> modeloCb = new DefaultComboBoxModel<String>(provincias);
	private ComponentesAvanzados padre;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox cbProvincias;

	/**
	 * Launch the application.
	 */
	public ProvinciasJDialog(Frame padre, boolean modal) {
		super(padre, modal);
		setMinimumSize(getSize());
		crearInterfaz();

	}

	/**
	 * Create the dialog.
	 */
	private void crearInterfaz() {

		setBounds(100, 100, 454, 104);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);

		cbProvincias = new JComboBox();
		cbProvincias.setModel(modeloCb);
		cbProvincias.setSelectedIndex(-1);
		cbProvincias.addItemListener(this);
		scrollPane.setViewportView(cbProvincias);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_buttonPane.rowWeights = new double[] { 0.0 };
		buttonPane.setLayout(gbl_buttonPane);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("OK");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		buttonPane.add(btnAceptar, gbc_btnAceptar);
		getRootPane().setDefaultButton(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("Cancel");
		btnCancelar.addActionListener(this);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		buttonPane.add(btnCancelar, gbc_btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			((ComponentesAvanzados) getParent()).actualizarProvincias((String)cbProvincias.getSelectedItem());
		}
		if (e.getSource() == btnCancelar) {
			dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cbProvincias) {
			btnAceptar.setEnabled(true);
		}
		
	}

}
