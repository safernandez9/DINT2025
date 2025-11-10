package tarea10jdialogintercambiodatos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Puntos de la taarea 10: Crear una aplicacin con varias ventanas JDialog que
 * intercambien datos entre si. - Establecer un constructor en el JDialog que
 * reciba parámetros desde su ventana padre e inicialice el componente grafico.
 * - Enviar datos desde un JDialog a su ventana padre creando un setter en el
 * padre que reciba los datos y los actualice.
 *
 */

public class Tarea10JDialogIntercambioDatos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea taUsuarios;
	private JButton btnNovoUsuario;
	private JButton btnSair;
	private int idUsuario = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea10JDialogIntercambioDatos frame = new Tarea10JDialogIntercambioDatos();
					frame.setTitle("Exemplo multixanela JDialog2");
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
	public Tarea10JDialogIntercambioDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel pnlUsuarios = new JPanel();
		pnlUsuarios.setBorder(new TitledBorder(null, "Informaci\u00F3n dos usuarios creados", TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, null));
		GridBagConstraints gbc_pnlUsuarios = new GridBagConstraints();
		gbc_pnlUsuarios.gridwidth = 2;
		gbc_pnlUsuarios.insets = new Insets(0, 0, 0, 5);
		gbc_pnlUsuarios.fill = GridBagConstraints.BOTH;
		gbc_pnlUsuarios.gridx = 0;
		gbc_pnlUsuarios.gridy = 0;
		contentPane.add(pnlUsuarios, gbc_pnlUsuarios);
		GridBagLayout gbl_pnlUsuarios = new GridBagLayout();
		gbl_pnlUsuarios.columnWidths = new int[] { 162, 5, 0 };
		gbl_pnlUsuarios.rowHeights = new int[] { 22, 0 };
		gbl_pnlUsuarios.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlUsuarios.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlUsuarios.setLayout(gbl_pnlUsuarios);

		taUsuarios = new JTextArea();
		GridBagConstraints gbc_taUsuarios = new GridBagConstraints();
		gbc_taUsuarios.gridwidth = 2;
		gbc_taUsuarios.fill = GridBagConstraints.BOTH;
		gbc_taUsuarios.gridx = 0;
		gbc_taUsuarios.gridy = 0;
		pnlUsuarios.add(taUsuarios, gbc_taUsuarios);

		JPanel pnlBotones = new JPanel();
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.fill = GridBagConstraints.BOTH;
		gbc_pnlBotones.gridx = 2;
		gbc_pnlBotones.gridy = 0;
		contentPane.add(pnlBotones, gbc_pnlBotones);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[] { 0, 0 };
		gbl_pnlBotones.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlBotones.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlBotones.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnlBotones.setLayout(gbl_pnlBotones);

		btnNovoUsuario = new JButton("Novo usuario (ID - " + taUsuarios.getLineCount()  + ")");
		btnNovoUsuario.addActionListener(this);

		GridBagConstraints gbc_btnNovoUsuario = new GridBagConstraints();
		gbc_btnNovoUsuario.fill = GridBagConstraints.BOTH;
		gbc_btnNovoUsuario.insets = new Insets(14, 0, 5, 0);
		gbc_btnNovoUsuario.gridx = 0;
		gbc_btnNovoUsuario.gridy = 0;
		pnlBotones.add(btnNovoUsuario, gbc_btnNovoUsuario);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.fill = GridBagConstraints.BOTH;
		gbc_btnSair.gridx = 0;
		gbc_btnSair.gridy = 1;
		pnlBotones.add(btnSair, gbc_btnSair);

	}

	/**
	 * Gestor de botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Envío al nuevo JDialog los parámetros que necesite creando en él un
		// constructor adecuado
		if (e.getSource() == btnNovoUsuario) {
			DatosNovoUsuarioJDialog dlgDatosNovoUsuario = new DatosNovoUsuarioJDialog(this, false, idUsuario);
			dlgDatosNovoUsuario.setVisible(true);
		}
		if (e.getSource() == btnSair) {
			System.exit(0);
		}
	}

	/**
	 * Añade la información del nuevo usuario recibida desde el otro JDialog al
	 * JTextArea
	 * 
	 * @param usuario Objeto usuario creado en el otro JDialog
	 */
	public void engadirInfoNovoUsuario(Usuario usuario) {
		taUsuarios.setText(usuario.toString() + "\n" + taUsuarios.getText());
		btnNovoUsuario.setText("Novo usuario (ID - " + (usuario.getId() + 1) + ")");
	}

}
