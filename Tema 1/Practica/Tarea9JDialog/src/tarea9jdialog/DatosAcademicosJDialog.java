package tarea9jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;

public class DatosAcademicosJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatosAcademicosJDialog dialog = new DatosAcademicosJDialog();
			dialog.setTitle("Datos académicos");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DatosAcademicosJDialog() {
		setBounds(100, 100, 461, 182);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {445};
		gridBagLayout.rowHeights = new int[] {143};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new TitledBorder(null, "Indique o maximo grado acadado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JRadioButton rdbtESO = new JRadioButton("ESO");
		GridBagConstraints gbc_rdbtESO = new GridBagConstraints();
		gbc_rdbtESO.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtESO.insets = new Insets(0, 10, 5, 0);
		gbc_rdbtESO.gridx = 0;
		gbc_rdbtESO.gridy = 0;
		contentPanel.add(rdbtESO, gbc_rdbtESO);
		
		JRadioButton rdbtBACH = new JRadioButton("Bacharelato");
		GridBagConstraints gbc_rdbtBACH = new GridBagConstraints();
		gbc_rdbtBACH.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtBACH.insets = new Insets(0, 10, 5, 0);
		gbc_rdbtBACH.gridx = 0;
		gbc_rdbtBACH.gridy = 1;
		contentPanel.add(rdbtBACH, gbc_rdbtBACH);
		
		JRadioButton rdbtFP = new JRadioButton("FP");
		GridBagConstraints gbc_rdbtFP = new GridBagConstraints();
		gbc_rdbtFP.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtFP.insets = new Insets(0, 10, 5, 0);
		gbc_rdbtFP.gridx = 0;
		gbc_rdbtFP.gridy = 2;
		contentPanel.add(rdbtFP, gbc_rdbtFP);
		
		JRadioButton rdbtUNI = new JRadioButton("Universidade");
		GridBagConstraints gbc_rdbtUNI = new GridBagConstraints();
		gbc_rdbtUNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtUNI.insets = new Insets(0, 10, 0, 0);
		gbc_rdbtUNI.gridx = 0;
		gbc_rdbtUNI.gridy = 3;
		contentPanel.add(rdbtUNI, gbc_rdbtUNI);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(5, 0, 0, 0);
		gbc_btnAceptar.anchor = GridBagConstraints.NORTH;
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 0;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
	}

}
