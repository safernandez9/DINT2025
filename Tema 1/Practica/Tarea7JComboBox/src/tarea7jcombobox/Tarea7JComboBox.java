package tarea7jcombobox;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tarea7JComboBox extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea7JComboBox frame = new Tarea7JComboBox();
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
	public Tarea7JComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

	private void cargarConcellos(int codProvincia) {

		modeloConcellos.removeAllElements();

		switch (codProvincia) {
		case 0:
			for (int i = 0; i < concellosCorunha.length; i++) {
				modeloConcellos.addElement(concellosCorunha[i]);
			}
			break;
		case 1:
			for (int i = 0; i < concellosLugo.length; i++) {
				modeloConcellos.addElement(concellosLugo[i]);
			}
			break;
		case 2:
			for (int i = 0; i < concellosOurense.length; i++) {
				modeloConcellos.addElement(concellosOurense[i]);
			}
			break;
		case 3:
			for (int i = 0; i < concellosPontevedra.length; i++) {
				modeloConcellos.addElement(concellosPontevedra[i]);
			}
			break;
		}
	}

	// Pequena "base de datos" de concellos por provincias
	private String[] concellosCorunha = { "Betanzos", "Ferrol", "Pontedeume" };
	private String[] concellosLugo = { "Foz", "Quiroga", "Triacastela" };
	private String[] concellosOurense = { "Bande", "Castro Caldelas", "Maside" };
	private String[] concellosPontevedra = { "Cangas", "Bueu", "Mar n", "Pontevedra", "Tomi o" };
}
