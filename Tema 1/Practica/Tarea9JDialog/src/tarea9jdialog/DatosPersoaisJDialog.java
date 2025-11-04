package tarea9jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JTextField;

public class DatosPersoaisJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private Tarea9JDialog xanelaPai;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DatosPersoaisJDialog dialog = new DatosPersoaisJDialog();
//			dialog.setTitle("Datos persoais");
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
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
		{
			JLabel lblNome = new JLabel("Nome");
			GridBagConstraints gbc_lblNome = new GridBagConstraints();
			gbc_lblNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblNome.gridx = 0;
			gbc_lblNome.gridy = 0;
			contentPanel.add(lblNome, gbc_lblNome);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblApelidos = new JLabel("Apelidos");
			GridBagConstraints gbc_lblApelidos = new GridBagConstraints();
			gbc_lblApelidos.insets = new Insets(0, 0, 0, 5);
			gbc_lblApelidos.gridx = 0;
			gbc_lblApelidos.gridy = 1;
			contentPanel.add(lblApelidos, gbc_lblApelidos);
		}
		{
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				buttonPane.add(btnAceptar);
			}
		}
	}

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
		xanelaPai = (Tarea9JDialog) padre;
		this.crearVentana();
	}

}
