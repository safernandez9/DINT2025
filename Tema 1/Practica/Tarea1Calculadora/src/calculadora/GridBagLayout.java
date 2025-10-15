package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GridBagLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfApellido1;
	private JTextField tfApellido2;
	private JTextField tfIdade;
	private JTextField tfFixo;
	private JTextField tfMobil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridBagLayout frame = new GridBagLayout();
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
	public GridBagLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		java.awt.GridBagLayout gbl_contentPane = new java.awt.GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		contentPane.add(lblNome, gbc_lblNome);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.insets = new Insets(0, 0, 5, 5);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		contentPane.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblApellido1 = new JLabel("Apellido 1");
		GridBagConstraints gbc_lblApellido1 = new GridBagConstraints();
		gbc_lblApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido1.anchor = GridBagConstraints.EAST;
		gbc_lblApellido1.gridx = 2;
		gbc_lblApellido1.gridy = 0;
		contentPane.add(lblApellido1, gbc_lblApellido1);
		
		tfApellido1 = new JTextField();
		GridBagConstraints gbc_tfApellido1 = new GridBagConstraints();
		gbc_tfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_tfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellido1.gridx = 3;
		gbc_tfApellido1.gridy = 0;
		contentPane.add(tfApellido1, gbc_tfApellido1);
		tfApellido1.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Apellido 2");
		GridBagConstraints gbc_lblApellido2 = new GridBagConstraints();
		gbc_lblApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido2.anchor = GridBagConstraints.EAST;
		gbc_lblApellido2.gridx = 4;
		gbc_lblApellido2.gridy = 0;
		contentPane.add(lblApellido2, gbc_lblApellido2);
		
		tfApellido2 = new JTextField();
		GridBagConstraints gbc_tfApellido2 = new GridBagConstraints();
		gbc_tfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_tfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellido2.gridx = 5;
		gbc_tfApellido2.gridy = 0;
		contentPane.add(tfApellido2, gbc_tfApellido2);
		tfApellido2.setColumns(10);
		
		JButton btnGardar = new JButton("Gardar");
		GridBagConstraints gbc_btnGardar = new GridBagConstraints();
		gbc_btnGardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGardar.gridx = 6;
		gbc_btnGardar.gridy = 0;
		contentPane.add(btnGardar, gbc_btnGardar);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.NORTH;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 0;
		gbc_lblObservaciones.gridy = 1;
		contentPane.add(lblObservaciones, gbc_lblObservaciones);
		
		JTextArea taMain = new JTextArea();
		GridBagConstraints gbc_taMain = new GridBagConstraints();
		gbc_taMain.weighty = 5.0;
		gbc_taMain.gridheight = 3;
		gbc_taMain.gridwidth = 5;
		gbc_taMain.insets = new Insets(0, 0, 5, 5);
		gbc_taMain.fill = GridBagConstraints.BOTH;
		gbc_taMain.gridx = 1;
		gbc_taMain.gridy = 1;
		contentPane.add(taMain, gbc_taMain);
		
		JButton btnLimpar = new JButton("Limpar");
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.anchor = GridBagConstraints.NORTH;
		gbc_btnLimpar.insets = new Insets(0, 0, 5, 0);
		gbc_btnLimpar.gridx = 6;
		gbc_btnLimpar.gridy = 1;
		contentPane.add(btnLimpar, gbc_btnLimpar);
		
		JButton btnPechar = new JButton("Pechar");
		GridBagConstraints gbc_btnPechar = new GridBagConstraints();
		gbc_btnPechar.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnPechar.insets = new Insets(0, 0, 5, 0);
		gbc_btnPechar.gridx = 6;
		gbc_btnPechar.gridy = 2;
		contentPane.add(btnPechar, gbc_btnPechar);
		
		JLabel lblIdade = new JLabel("Idade");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.anchor = GridBagConstraints.WEST;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 0;
		gbc_lblIdade.gridy = 4;
		contentPane.add(lblIdade, gbc_lblIdade);
		
		tfIdade = new JTextField();
		GridBagConstraints gbc_tfIdade = new GridBagConstraints();
		gbc_tfIdade.insets = new Insets(0, 0, 5, 5);
		gbc_tfIdade.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIdade.gridx = 1;
		gbc_tfIdade.gridy = 4;
		contentPane.add(tfIdade, gbc_tfIdade);
		tfIdade.setColumns(10);
		
		JLabel lblFixo = new JLabel("Tlf. Fixo");
		GridBagConstraints gbc_lblFixo = new GridBagConstraints();
		gbc_lblFixo.anchor = GridBagConstraints.WEST;
		gbc_lblFixo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFixo.gridx = 0;
		gbc_lblFixo.gridy = 5;
		contentPane.add(lblFixo, gbc_lblFixo);
		
		tfFixo = new JTextField();
		GridBagConstraints gbc_tfFixo = new GridBagConstraints();
		gbc_tfFixo.gridwidth = 5;
		gbc_tfFixo.insets = new Insets(0, 0, 5, 5);
		gbc_tfFixo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFixo.gridx = 1;
		gbc_tfFixo.gridy = 5;
		contentPane.add(tfFixo, gbc_tfFixo);
		tfFixo.setColumns(10);
		
		JLabel lblMobil = new JLabel("Tlf. Móbil");
		GridBagConstraints gbc_lblMobil = new GridBagConstraints();
		gbc_lblMobil.anchor = GridBagConstraints.WEST;
		gbc_lblMobil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobil.gridx = 0;
		gbc_lblMobil.gridy = 6;
		contentPane.add(lblMobil, gbc_lblMobil);
		
		tfMobil = new JTextField();
		GridBagConstraints gbc_tfMobil = new GridBagConstraints();
		gbc_tfMobil.gridwidth = 5;
		gbc_tfMobil.insets = new Insets(0, 0, 5, 5);
		gbc_tfMobil.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMobil.gridx = 1;
		gbc_tfMobil.gridy = 6;
		contentPane.add(tfMobil, gbc_tfMobil);
		tfMobil.setColumns(10);

	}

}
