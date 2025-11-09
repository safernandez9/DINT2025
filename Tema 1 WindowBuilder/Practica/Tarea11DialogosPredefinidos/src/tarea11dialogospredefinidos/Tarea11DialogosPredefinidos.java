package tarea11dialogospredefinidos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tarea11DialogosPredefinidos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnMetodo1;
	private JButton btnMetodo2;
	private JButton btnMetodo3;
	private JButton btn2Metodo1;
	private JButton btn2Metodo2;
	private JButton btn2Metodo3;
	private JButton btn2Metodo4;
	private JButton btn2Metodo5;
	private JButton btn2Metodo6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea11DialogosPredefinidos frame = new Tarea11DialogosPredefinidos();
					frame.setTitle("Exemplo showMessageDialog");
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
	public Tarea11DialogosPredefinidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		// SECCION 1: showInputDialog
		
		// Botón método 1 
		// public static void showMessageDialog(Component parentComponent, Object message)
		btnMetodo1 = new JButton("Mostrar showMessageDialog (método 1)"); 
		GridBagConstraints gbc_btnMetodo1 = new GridBagConstraints();
		gbc_btnMetodo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMetodo1.insets = new Insets(0, 0, 5, 0);
		gbc_btnMetodo1.gridx = 0;
		gbc_btnMetodo1.gridy = 0;
		btnMetodo1.addActionListener(this);
		contentPane.add(btnMetodo1, gbc_btnMetodo1);
		
		// Botón método 2 
		// public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
		btnMetodo2 = new JButton("Mostrar showMessageDialog (método 2)");
		GridBagConstraints gbc_btnMetodo2 = new GridBagConstraints();
		gbc_btnMetodo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMetodo2.insets = new Insets(0, 0, 5, 0);
		gbc_btnMetodo2.gridx = 0;
		gbc_btnMetodo2.gridy = 1;
		btnMetodo2.addActionListener(this);
		contentPane.add(btnMetodo2, gbc_btnMetodo2);
		
		// Botón método 3 
		// public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon)
		btnMetodo3 = new JButton("Mostrar showMessageDialog (método 3)");
		GridBagConstraints gbc_btnMetodo3 = new GridBagConstraints();
		gbc_btnMetodo3.insets = new Insets(0, 0, 5, 0);
		gbc_btnMetodo3.fill = GridBagConstraints.BOTH;
		gbc_btnMetodo3.gridx = 0;
		gbc_btnMetodo3.gridy = 2;
		btnMetodo3.addActionListener(this);
		contentPane.add(btnMetodo3, gbc_btnMetodo3);

		
		
		// SECCION 2: showInputDialog. Diálogo de entrada de datos.
		
		// Botón método 1
		// public static String showInputDialog(Object message)
		btn2Metodo1 = new JButton("Mostrar showInputDialog (método 1)");
		GridBagConstraints gbc_btn2Metodo1 = new GridBagConstraints();
		gbc_btn2Metodo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo1.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo1.gridx = 0;
		gbc_btn2Metodo1.gridy = 3;
		contentPane.add(btn2Metodo1, gbc_btn2Metodo1);
		
		// Botón método 2
		// public static String showInputDialog(Object message, Object initialSelectionValue)
		btn2Metodo2 = new JButton("Mostrar showInputDialog (método 2)");
		GridBagConstraints gbc_btn2Metodo2 = new GridBagConstraints();
		gbc_btn2Metodo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo2.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo2.gridx = 0;
		gbc_btn2Metodo2.gridy = 4;
		contentPane.add(btn2Metodo2, gbc_btn2Metodo2);
		
		// Botón método 3
		// public static String showInputDialog(Component parentComponent, Object message)
		btn2Metodo3 = new JButton("Mostrar showInputDialog (método 3)");
		GridBagConstraints gbc_btn2Metodo3 = new GridBagConstraints();
		gbc_btn2Metodo3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo3.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo3.gridx = 0;
		gbc_btn2Metodo3.gridy = 5;
		contentPane.add(btn2Metodo3, gbc_btn2Metodo3);
		
		
		btn2Metodo4 = new JButton("Mostrar showInputDialog (método 4)");
		GridBagConstraints gbc_btn2Metodo4 = new GridBagConstraints();
		gbc_btn2Metodo4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo4.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo4.gridx = 0;
		gbc_btn2Metodo4.gridy = 6;
		contentPane.add(btn2Metodo4, gbc_btn2Metodo4);
		
		btn2Metodo5 = new JButton("Mostrar showInputDialog (método 5)");
		GridBagConstraints gbc_btn2Metodo5 = new GridBagConstraints();
		gbc_btn2Metodo5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo5.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo5.gridx = 0;
		gbc_btn2Metodo5.gridy = 7;
		contentPane.add(btn2Metodo5, gbc_btn2Metodo5);
		
		btn2Metodo6 = new JButton("Mostrar showInputDialog (método 6)");
		GridBagConstraints gbc_btn2Metodo6 = new GridBagConstraints();
		gbc_btn2Metodo6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo6.gridx = 0;
		gbc_btn2Metodo6.gridy = 8;
		contentPane.add(btn2Metodo6, gbc_btn2Metodo6);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMetodo1){
			JOptionPane.showMessageDialog(this, "O botón foi premido");
		}
		// El último parámetro (messageType) marcará el icono predefinido que se mostrará en el diálogo
		if(e.getSource() == btnMetodo2){
			JOptionPane.showMessageDialog(this, "O botón foi premido", "Método 2", JOptionPane.WARNING_MESSAGE);
		}
		if(e.getSource() == btnMetodo3){
			ImageIcon icono = Icons.convertImage("/imaxes/icona.png", 64, 64);
			JOptionPane.showMessageDialog(this, "O botón foi premido", "Método 3",JOptionPane.WARNING_MESSAGE, icono);
		}
	}

}
