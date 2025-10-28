package tarea9jdialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tarea9JDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSair;
	private JButton btnDatosAcademicos;
	private JButton btnDatosPersoais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea9JDialog frame = new Tarea9JDialog();
					frame.setTitle("Exemplo multixanela JDialog");
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
	public Tarea9JDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 80);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 145, 145, 145, 0 };
		gbl_contentPane.rowHeights = new int[] { 31, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnDatosPersoais = new JButton("Datos persoais");
		GridBagConstraints gbc_btnDatosPersoais = new GridBagConstraints();
		gbc_btnDatosPersoais.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDatosPersoais.insets = new Insets(0, 0, 0, 5);
		gbc_btnDatosPersoais.gridx = 0;
		gbc_btnDatosPersoais.gridy = 0;
		contentPane.add(btnDatosPersoais, gbc_btnDatosPersoais);

		btnDatosAcademicos = new JButton("Datos académicos");
		GridBagConstraints gbc_btnDatosAcademicos = new GridBagConstraints();
		gbc_btnDatosAcademicos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDatosAcademicos.insets = new Insets(0, 0, 0, 5);
		gbc_btnDatosAcademicos.gridx = 1;
		gbc_btnDatosAcademicos.gridy = 0;
		contentPane.add(btnDatosAcademicos, gbc_btnDatosAcademicos);

		btnSair = new JButton("Saír");
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSair.gridx = 2;
		gbc_btnSair.gridy = 0;
		contentPane.add(btnSair, gbc_btnSair);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDatosPersoais) {
			DatosPersoaisJDialog dlgDatosPersoais = new DatosPersoaisJDialog(this, false);
			dlgDatosPersoais.setVisible(true);
		} else if (e.getSource() == btnDatosAcademicos) {
			DlgDatosAcademicos dlgDatosAcademicos = new DlgDatosAcademicos(this, false);
			dlgDatosAcademicos.setVisible(true);

		} else if (e.getSource() == btnSair) {

		} else {
			return;
		}

	}

}
