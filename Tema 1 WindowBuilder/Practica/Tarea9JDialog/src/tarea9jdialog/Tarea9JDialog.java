package tarea9jdialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.event.WindowEvent;

public class Tarea9JDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSair;
	private JButton btnDatosAcademicos;
	private JButton btnDatosPersoais;
	private JButton btnCascada;

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
		gbl_contentPane.rowHeights = new int[] { 31, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnDatosPersoais = new JButton("Datos persoais");
		btnDatosPersoais.addActionListener(this);
		GridBagConstraints gbc_btnDatosPersoais = new GridBagConstraints();
		gbc_btnDatosPersoais.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDatosPersoais.insets = new Insets(0, 0, 5, 5);
		gbc_btnDatosPersoais.gridx = 0;
		gbc_btnDatosPersoais.gridy = 0;
		contentPane.add(btnDatosPersoais, gbc_btnDatosPersoais);

		btnDatosAcademicos = new JButton("Datos académicos");
		btnDatosAcademicos.addActionListener(this);
		GridBagConstraints gbc_btnDatosAcademicos = new GridBagConstraints();
		gbc_btnDatosAcademicos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDatosAcademicos.insets = new Insets(0, 0, 5, 5);
		gbc_btnDatosAcademicos.gridx = 2;
		gbc_btnDatosAcademicos.gridy = 0;
		contentPane.add(btnDatosAcademicos, gbc_btnDatosAcademicos);

		btnCascada = new JButton("Cascada");
		btnCascada.addActionListener(this);
		GridBagConstraints gbc_btnCascada = new GridBagConstraints();
		gbc_btnCascada.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCascada.insets = new Insets(0, 0, 5, 5);
		gbc_btnCascada.gridx = 1;
		gbc_btnCascada.gridy = 0;
		contentPane.add(btnCascada, gbc_btnCascada);

		btnSair = new JButton("Saír");
		btnSair.addActionListener(this);
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.insets = new Insets(0, 0, 0, 5);
		gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSair.gridx = 1;
		gbc_btnSair.gridy = 1;
		contentPane.add(btnSair, gbc_btnSair);

	}

	/**
	 * instanciar un obxecto da clase DlgDatosPersoais empregando o seu construtor.
	 * O construtor ten dous parámetros. O primeiro parámetro emprégase para indicar
	 * quen é a xanela pai da que estamos creando (neste caso é o propio chamador, é
	 * dicir, this). O segundo parámetro indica se a xanela aberta será amosada en
	 * modo modal (true) ou non modal (false). Unha xanela aberta en modo modal
	 * bloquea ao resto da aplicación. Creado pero no visible, para que sea visible
	 * setvisible
	 */

	// LLAMO A METODOS ABRIR VENTANAS
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDatosPersoais) {
			if (GestorVentanas.abrirVentanasDatosPersoais()) {
				DatosPersoaisJDialog dlgDatosPersoais = new DatosPersoaisJDialog(this, false);
				GestorVentanas.añadirVentanaDatosPersoais(dlgDatosPersoais);
				dlgDatosPersoais.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Non é posible abrir máis xanelas deste tipo");
				return;
			}
		} else if (e.getSource() == btnDatosAcademicos) {
			if (GestorVentanas.abrirVentanasDatosAcademicos()) {
				DatosAcademicosJDialog dlgDatosAcademicos = new DatosAcademicosJDialog(this, false);
				dlgDatosAcademicos.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Non é posible abrir máis xanelas deste tipo");
				return;
			}

		} else if (e.getSource() == btnCascada) {

		} else if (e.getSource() == btnSair) {
			return;
		}

	}

}
