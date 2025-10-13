package tarea0;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Tarea0 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea0 window = new Tarea0();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tarea0() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel pnlNombre = new JPanel();
		pnlNombre.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlNombre = new GridBagConstraints();
		gbc_pnlNombre.weighty = 3.0;
		gbc_pnlNombre.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNombre.fill = GridBagConstraints.BOTH;
		gbc_pnlNombre.gridx = 0;
		gbc_pnlNombre.gridy = 0;
		frame.getContentPane().add(pnlNombre, gbc_pnlNombre);
		
		JPanel pnlEmail = new JPanel();
		pnlEmail.setBorder(new TitledBorder(null, "Email", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlEmail = new GridBagConstraints();
		gbc_pnlEmail.weighty = 4.0;
		gbc_pnlEmail.insets = new Insets(0, 0, 5, 0);
		gbc_pnlEmail.fill = GridBagConstraints.BOTH;
		gbc_pnlEmail.gridx = 0;
		gbc_pnlEmail.gridy = 1;
		frame.getContentPane().add(pnlEmail, gbc_pnlEmail);
		
		JPanel pnlBotones = new JPanel();
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.fill = GridBagConstraints.BOTH;
		gbc_pnlBotones.gridx = 0;
		gbc_pnlBotones.gridy = 2;
		frame.getContentPane().add(pnlBotones, gbc_pnlBotones);
	}
}
