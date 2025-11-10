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
	private JButton btn3Metodo1;
	private JButton btn3Metodo2;
	private JButton btn3Metodo3;
	private JButton btn3Metodo4;
	private JButton btn3Metodo5;

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
		setBounds(100, 100, 573, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		contentPane.setLayout(gbl_contentPane);

		// SECCION 1: showInputDialog

		// Botón método 1
		// public static void showMessageDialog(Component parentComponent, Object
		// message)
		btnMetodo1 = new JButton("Mostrar showMessageDialog (método 1)");
		GridBagConstraints gbc_btnMetodo1 = new GridBagConstraints();
		gbc_btnMetodo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMetodo1.insets = new Insets(0, 0, 5, 0);
		gbc_btnMetodo1.gridx = 0;
		gbc_btnMetodo1.gridy = 0;
		btnMetodo1.addActionListener(this);
		contentPane.add(btnMetodo1, gbc_btnMetodo1);

		// Botón método 2
		// public static void showMessageDialog(Component parentComponent, Object
		// message, String title, int messageType)
		btnMetodo2 = new JButton("Mostrar showMessageDialog (método 2)");
		GridBagConstraints gbc_btnMetodo2 = new GridBagConstraints();
		gbc_btnMetodo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMetodo2.insets = new Insets(0, 0, 5, 0);
		gbc_btnMetodo2.gridx = 0;
		gbc_btnMetodo2.gridy = 1;
		btnMetodo2.addActionListener(this);
		contentPane.add(btnMetodo2, gbc_btnMetodo2);

		// Botón método 3
		// public static void showMessageDialog(Component parentComponent, Object
		// message, String title, int messageType, Icon icon)
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
		btn2Metodo1.addActionListener(this);
		contentPane.add(btn2Metodo1, gbc_btn2Metodo1);

		// Botón método 2
		// public static String showInputDialog(Object message, Object
		// initialSelectionValue)
		btn2Metodo2 = new JButton("Mostrar showInputDialog (método 2)");
		GridBagConstraints gbc_btn2Metodo2 = new GridBagConstraints();
		gbc_btn2Metodo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo2.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo2.gridx = 0;
		gbc_btn2Metodo2.gridy = 4;
		btn2Metodo2.addActionListener(this);
		contentPane.add(btn2Metodo2, gbc_btn2Metodo2);

		// Botón método 3
		// public static String showInputDialog(Component parentComponent, Object
		// message)
		btn2Metodo3 = new JButton("Mostrar showInputDialog (método 3)");
		GridBagConstraints gbc_btn2Metodo3 = new GridBagConstraints();
		gbc_btn2Metodo3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo3.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo3.gridx = 0;
		gbc_btn2Metodo3.gridy = 5;
		btn2Metodo3.addActionListener(this);
		contentPane.add(btn2Metodo3, gbc_btn2Metodo3);

		// Botón método 4
		// public static String showInputDialog(Component parentComponent, Object
		// message, Object initialSelectionValue)

		btn2Metodo4 = new JButton("Mostrar showInputDialog (método 4)");
		GridBagConstraints gbc_btn2Metodo4 = new GridBagConstraints();
		gbc_btn2Metodo4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo4.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo4.gridx = 0;
		gbc_btn2Metodo4.gridy = 6;
		btn2Metodo4.addActionListener(this);
		contentPane.add(btn2Metodo4, gbc_btn2Metodo4);

		// Botón método 5
		// public static String showInputDialog(Component parentComponent, Object
		// message, String title, int messageType)

		btn2Metodo5 = new JButton("Mostrar showInputDialog (método 5)");
		GridBagConstraints gbc_btn2Metodo5 = new GridBagConstraints();
		gbc_btn2Metodo5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo5.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo5.gridx = 0;
		gbc_btn2Metodo5.gridy = 7;
		btn2Metodo5.addActionListener(this);
		contentPane.add(btn2Metodo5, gbc_btn2Metodo5);

		// Botón método 6
		// public static String showInputDialog(Component parentComponent, Object
		// message, String title, int messageType, Icon icon, Object[] selectionValues,
		// Object initialSelectionValue)

		btn2Metodo6 = new JButton("Mostrar showInputDialog (método 6)");
		GridBagConstraints gbc_btn2Metodo6 = new GridBagConstraints();
		gbc_btn2Metodo6.insets = new Insets(0, 0, 5, 0);
		gbc_btn2Metodo6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2Metodo6.gridx = 0;
		gbc_btn2Metodo6.gridy = 8;
		btn2Metodo6.addActionListener(this);
		contentPane.add(btn2Metodo6, gbc_btn2Metodo6);

		// SECCION 3: showOptionDialog

		// public static int showOptionDialog(Component parentComponent, Object
		// message,String title, int optionType, int messageType, Icon icon,
		// Object [] options, Object initialValue)

		// Botón método 1
		// Diálogo con opciones Sí / No
		btn3Metodo1 = new JButton("Mostrar showOptionDialog (Si / Non)");
		btn3Metodo1.addActionListener(this);
		GridBagConstraints gbc_btn3Metodo1 = new GridBagConstraints();
		gbc_btn3Metodo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3Metodo1.insets = new Insets(0, 0, 5, 0);
		gbc_btn3Metodo1.gridx = 0;
		gbc_btn3Metodo1.gridy = 9;
		contentPane.add(btn3Metodo1, gbc_btn3Metodo1);

		// Botón método 2
		// Diálogo con opciones Sí / No / Cancelar
		btn3Metodo2 = new JButton("Mostrar showOptionDialog (Si / Non / Cancelar a icona predefinida)");
		btn3Metodo2.addActionListener(this);
		GridBagConstraints gbc_btn3Metodo2 = new GridBagConstraints();
		gbc_btn3Metodo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3Metodo2.insets = new Insets(0, 0, 5, 0);
		gbc_btn3Metodo2.gridx = 0;
		gbc_btn3Metodo2.gridy = 10;
		contentPane.add(btn3Metodo2, gbc_btn3Metodo2);

		// Botón método 3
		// Diálogo con opciones Sí / No / Cancelar y un icono personalizado
		btn3Metodo3 = new JButton("Mostrar showOptionDialog (Si / Non / Cancelar a icona personalizada)");
		btn3Metodo3.addActionListener(this);
		GridBagConstraints gbc_btn3Metodo3 = new GridBagConstraints();
		gbc_btn3Metodo3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3Metodo3.insets = new Insets(0, 0, 5, 0);
		gbc_btn3Metodo3.gridx = 0;
		gbc_btn3Metodo3.gridy = 11;
		contentPane.add(btn3Metodo3, gbc_btn3Metodo3);

		// Botón método 4
		// Diálogo con botones personalizados
		btn3Metodo4 = new JButton("Mostrar showOptionDialog (botóns personalizados)");
		btn3Metodo4.addActionListener(this);
		GridBagConstraints gbc_btn3Metodo4 = new GridBagConstraints();
		gbc_btn3Metodo4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3Metodo4.insets = new Insets(0, 0, 5, 0);
		gbc_btn3Metodo4.gridx = 0;
		gbc_btn3Metodo4.gridy = 12;
		contentPane.add(btn3Metodo4, gbc_btn3Metodo4);

		// Botón método 5
		// Diálogo con botones personalizados y valor preseleccionado
		btn3Metodo5 = new JButton("Mostrar showOptionDialog (botóns personalizados e valor preseleccionado)");
		btn3Metodo5.addActionListener(this);
		GridBagConstraints gbc_btn3Metodo5 = new GridBagConstraints();
		gbc_btn3Metodo5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3Metodo5.gridx = 0;
		gbc_btn3Metodo5.gridy = 13;
		contentPane.add(btn3Metodo5, gbc_btn3Metodo5);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMetodo1) {
			JOptionPane.showMessageDialog(this, "O botón foi premido");
		}
		// El último parámetro (messageType) marcará el icono predefinido que se
		// mostrará en el diálogo
		if (e.getSource() == btnMetodo2) {
			JOptionPane.showMessageDialog(this, "O botón foi premido", "Método 2", JOptionPane.WARNING_MESSAGE);
		}
		// El ultimo parámetro (icon) permitirá definir un icono personalizado que se
		// mostrará en el diálogo
		if (e.getSource() == btnMetodo3) {
			ImageIcon icono = Icons.convertImage("/imaxes/icona.png", 64, 64);
			JOptionPane.showMessageDialog(this, "O botón foi premido", "Método 3", JOptionPane.WARNING_MESSAGE, icono);
		}
		if (e.getSource() == btn2Metodo1) {
			btn2Metodo1ActionPerformed(e);
		}
		if (e.getSource() == btn2Metodo2) {
			btn2Metodo1ActionPerformed(e);
		}
		if (e.getSource() == btn2Metodo3) {
			btnMetodo3ActionPerformed(e);
		}
		if (e.getSource() == btn2Metodo4) {
			btnMetodo4ActionPerformed(e);
		}
		if (e.getSource() == btn2Metodo5) {
			btnMetodo5ActionPerformed(e);
		}
		if (e.getSource() == btn2Metodo6) {
			btnMetodo6ActionPerformed(e);
		}
		if (e.getSource() == btn3Metodo1) {
			btn3Metodo1ActionPerformed(e);
		}
		if (e.getSource() == btn3Metodo2) {
			btn3Metodo2ActionPerformed(e);
		}
		if (e.getSource() == btn3Metodo3) {
			btn3Metodo3ActionPerformed(e);
		}
		if (e.getSource() == btn3Metodo4) {
			btn3Metodo4ActionPerformed(e);
		}
		if (e.getSource() == btn3Metodo5) {
			btn3Metodo5ActionPerformed(e);
		}

	}

	// Métodos para los botones de showInputDialog.
	// Todos leen en domicilio lo que se escriba en el InputDialog.
	// Todos validan si se ha pulsado Cancelar (domicilio == null) o si se ha dejado
	// en blanco
	// Si se ha escrito algo, lo muestran en un MessageDialog.

	/**
	 * Forma 1. Solo indico el mensaje.
	 * 
	 * @param e
	 */
	private void btn2Metodo1ActionPerformed(ActionEvent e) {

		String domicilio = JOptionPane.showInputDialog("Indique o seu domicilio");

		if (domicilio == null) {
			JOptionPane.showMessageDialog(this, "Acción anulada polo usuario", "Atención", JOptionPane.ERROR_MESSAGE);
		} else {
			if (domicilio.trim().compareTo("") == 0) {
				JOptionPane.showMessageDialog(this, "A caixa de texto está baleira", "Atención",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "O seu domicilio é " + domicilio, "Atención",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		System.out.println(domicilio);

	}

	/**
	 * Forma 2. Indico el mensaje y un valor inicial.
	 * 
	 * @param e
	 */
	private void btn2Metodo2ActionPerformed(ActionEvent e) {

		String domicilio = JOptionPane.showInputDialog("Indique o seu domicilio",
				"Rúa Descoñecida s/n, 15001, A Coruña");
		if (domicilio == null) {
			JOptionPane.showMessageDialog(this, "Acción anulada polo usuario", "Atención", JOptionPane.ERROR_MESSAGE);
		} else {

			if (domicilio.trim().compareTo("") == 0) {
				JOptionPane.showMessageDialog(this, "A caixa de texto está baleira", "Atención",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "O seu domicilio é " + domicilio, "Atención",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		System.out.println(domicilio);
	}

	/**
	 * Forma 3. Indico el componente padre y el mensaje.
	 * 
	 * @param e
	 */
	private void btnMetodo3ActionPerformed(ActionEvent e) {

		String domicilio = JOptionPane.showInputDialog(this, "Indique o seu domicilio");

		if (domicilio == null) {
			JOptionPane.showMessageDialog(this, "Acción anulada polo usuario", "Atención", JOptionPane.ERROR_MESSAGE);
		} else {
			if (domicilio.trim().compareTo("") == 0) {
				JOptionPane.showMessageDialog(this, "A caixa de texto está baleira", "Atención",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "O seu domicilio é " + domicilio, "Atención",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		System.out.println(domicilio);
	}

	/**
	 * Forma 4. Indico el componente padre, el mensaje y un valor inicial.
	 * 
	 * @param e
	 */
	private void btnMetodo4ActionPerformed(ActionEvent e) {

		String domicilio = JOptionPane.showInputDialog(this, "Indique o seu domicilio",
				"Rúa Descoñecida s/n, 15001, A Coruña");
		if (domicilio == null) {
			JOptionPane.showMessageDialog(this, "Acción anulada polo usuario", "Atención", JOptionPane.ERROR_MESSAGE);
		} else {
			if (domicilio.trim().compareTo("") == 0) {
				JOptionPane.showMessageDialog(this, "A caixa de texto está baleira", "Atención",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "O seu domicilio é " + domicilio, "Atención",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		System.out.println(domicilio);
	}

	/**
	 * Forma 5. Indico el componente padre, el mensaje, el título y el tipo de
	 * mensaje (icono predefinido).
	 * 
	 * @param e
	 */
	private void btnMetodo5ActionPerformed(ActionEvent e) {
		String domicilio = JOptionPane.showInputDialog(this, "Indique o seu domicilio", "Domicilio",
				JOptionPane.WARNING_MESSAGE);

		if (domicilio == null) {
			JOptionPane.showMessageDialog(this, "Acción anulada polo usuario", "Atención", JOptionPane.ERROR_MESSAGE);
		} else {
			if (domicilio.trim().compareTo("") == 0) {
				JOptionPane.showMessageDialog(this, "A caixa de texto está baleira", "Atención",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "O seu domicilio é " + domicilio, "Atención",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		System.out.println(domicilio);
	}

	/**
	 * Forma 6. Indico el componente padre, el mensaje, el título, el tipo de
	 * mensaje (icono predefinido), un icono personalizado, un array de
	 * selección(spinner) y un valor inicial.
	 * 
	 * @param e
	 */
	private void btnMetodo6ActionPerformed(ActionEvent e) {

		ImageIcon icona = Icons.convertImage("/imaxes/icona.png", 64, 64);
		String provincias[] = { "A Coruña", "Lugo", "Ourense", "Pontevedra" };
		Object seleccion = JOptionPane.showInputDialog(this, "Indique a súa provincia de nacemento", "Nacemento",
				JOptionPane.QUESTION_MESSAGE, icona, provincias, "Lugo");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(this, "Acción anulada polo usuario", "Atención", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "A súa provincia seleccionada é " + seleccion, "Atención",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Métodos para los botones de showOptionDialog.

	/**
	 * Método 1. Diálogo con opciones Sí / No Recojo en selección el botón pulsado.
	 * String mensaxe por si cierro En el switch, según el botón pulsado, cambio el
	 * valor de mensaxe y muestro un MessageDialog con el resultado.
	 * 
	 * @param e
	 */
	private void btn3Metodo1ActionPerformed(ActionEvent e) {
		int seleccion = JOptionPane.showOptionDialog(this, "Selecciona unha opción", "Exemplo 1",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

		String mensaxe = "Xanela pechada polo usuario";
		switch (seleccion) {
		case JOptionPane.YES_OPTION:
			mensaxe = "Pulsado o botón Sí";
			break;
		case JOptionPane.NO_OPTION:
			mensaxe = "Pulsado o botón Non";
			break;
		}
		JOptionPane.showMessageDialog(this, mensaxe, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método 2. Diálogo con opciones Sí / No / Cancelar e icono predefinido
	 * 
	 * @param e
	 */
	private void btn3Metodo2ActionPerformed(ActionEvent e) {
		int seleccion = JOptionPane.showOptionDialog(this, "Selecciona unha opción", "Exemplo 2",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		String mensaxe = "Xanela pechada polo usuario";
		switch (seleccion) {
		case JOptionPane.YES_OPTION:
			mensaxe = "Pulsado o botón Sí";
			break;
		case JOptionPane.NO_OPTION:
			mensaxe = "Pulsado o botón Non";
			break;
		case JOptionPane.CANCEL_OPTION:
			mensaxe = "Pulsado o botón Cancelar";
			break;
		}
		JOptionPane.showMessageDialog(this, mensaxe, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método 3. Diálogo con opciones Sí / No / Cancelar e icono personalizado
	 * 
	 * @param e
	 */
	private void btn3Metodo3ActionPerformed(ActionEvent e) {

		ImageIcon icona = Icons.convertImage("/imaxes/icona.png", 64, 64);
		int seleccion = JOptionPane.showOptionDialog(this, "Selecciona unha opción", "Exemplo 3",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icona, null, null);
		String mensaxe = "Xanela pechada polo usuario";
		switch (seleccion) {
		case JOptionPane.YES_OPTION:
			mensaxe = "Pulsado o botón Sí";
			break;
		case JOptionPane.NO_OPTION:
			mensaxe = "Pulsado o botón Non";
			break;
		case JOptionPane.CANCEL_OPTION:
			mensaxe = "Pulsado o botón Cancelar";
			break;
		}
		JOptionPane.showMessageDialog(this, mensaxe, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método 4. Diálogo con botones personalizados Metiendo un array de String con
	 * los nombres de los botones en una YES_NO_CANCEL_OPTION.
	 * 
	 * @param e
	 */
	private void btn3Metodo4ActionPerformed(ActionEvent e) {

		String botons[] = { "Chove", "Non chove", "Poidera ser" };
		int seleccion = JOptionPane.showOptionDialog(this, "¿Choverá pola tarde?", "Exemplo 4",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botons, null);
		String mensaxe = "Xanela pechada polo usuario";
		switch (seleccion) {
		case 0:
			mensaxe = "Vai chover";
			break;
		case 1:
			mensaxe = "Non vai chover";
			break;
		case 2:
			mensaxe = "Poidera ser que chova. Xa veremos";
			break;
		}
		JOptionPane.showMessageDialog(this, mensaxe, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método 5. Diálogo con botones personalizados y valor preseleccionado Metiendo
	 * un array de String con los nombres de los botones en una
	 * YES_NO_CANCEL_OPTION. El último parámetro indica el botón que aparecerá
	 * seleccionado por defecto.
	 * 
	 * @param e
	 */
	private void btn3Metodo5ActionPerformed(ActionEvent e) {
		// TODO add your handling code here:
		String botons[] = { "Chove", "Non chove", "Poidera ser" };
		int seleccion = JOptionPane.showOptionDialog(this, "¿Choverá pola tarde?", "Exemplo 4",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botons, botons[2]);
		String mensaxe = "Xanela pechada polo usuario";
		switch (seleccion) {
		case 0:
			mensaxe = "Vai chover";
			break;
		case 1:
			mensaxe = "Non vai chover";
			break;
		case 2:
			mensaxe = "Poidera ser que chova. Xa veremos";
			break;
		}
		JOptionPane.showMessageDialog(this, mensaxe, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
}
