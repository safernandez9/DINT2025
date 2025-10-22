package t6JList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;

public class T6JList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfModelo;
	private JTextField tfCor;
	private JTextField tfAncho;
	private JTextField tfAlto;
	private JList listaAlfombras;
	private JButton btnInformacion;
	private DefaultListModel<Alfombra> modelo = new DefaultListModel<Alfombra>();;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T6JList frame = new T6JList();
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
	public T6JList() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(new TitledBorder(null, "Alfombra", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		pnlDatos.setName("Nova Alfombra");
		GridBagConstraints gbc_pnlDatos = new GridBagConstraints();
		gbc_pnlDatos.insets = new Insets(0, 0, 5, 0);
		gbc_pnlDatos.fill = GridBagConstraints.BOTH;
		gbc_pnlDatos.gridx = 0;
		gbc_pnlDatos.gridy = 0;
		contentPane.add(pnlDatos, gbc_pnlDatos);
		GridBagLayout gbl_pnlDatos = new GridBagLayout();
		gbl_pnlDatos.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlDatos.rowHeights = new int[] {0, 0};
		gbl_pnlDatos.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDatos.rowWeights = new double[]{1.0, 1.0};
		pnlDatos.setLayout(gbl_pnlDatos);
		
		// FORMULARIO
		
		JLabel lblModelo = new JLabel("Modelo");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 0;
		pnlDatos.add(lblModelo, gbc_lblModelo);
		
		tfModelo = new JTextField();
		GridBagConstraints gbc_tfModelo = new GridBagConstraints();
		gbc_tfModelo.gridwidth = 7;
		gbc_tfModelo.insets = new Insets(0, 0, 5, 5);
		gbc_tfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfModelo.gridx = 1;
		gbc_tfModelo.gridy = 0;
		pnlDatos.add(tfModelo, gbc_tfModelo);
		tfModelo.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.anchor = GridBagConstraints.EAST;
		gbc_lblCor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCor.gridx = 0;
		gbc_lblCor.gridy = 1;
		pnlDatos.add(lblCor, gbc_lblCor);
		
		tfCor = new JTextField();
		GridBagConstraints gbc_tfCor = new GridBagConstraints();
		gbc_tfCor.insets = new Insets(0, 0, 5, 5);
		gbc_tfCor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCor.gridx = 1;
		gbc_tfCor.gridy = 1;
		pnlDatos.add(tfCor, gbc_tfCor);
		tfCor.setColumns(10);
		
		JLabel lblAncho = new JLabel("Ancho");
		GridBagConstraints gbc_lblAncho = new GridBagConstraints();
		gbc_lblAncho.insets = new Insets(0, 0, 5, 5);
		gbc_lblAncho.anchor = GridBagConstraints.EAST;
		gbc_lblAncho.gridx = 2;
		gbc_lblAncho.gridy = 1;
		pnlDatos.add(lblAncho, gbc_lblAncho);
		
		tfAncho = new JTextField();
		GridBagConstraints gbc_tfAncho = new GridBagConstraints();
		gbc_tfAncho.insets = new Insets(0, 0, 5, 5);
		gbc_tfAncho.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAncho.gridx = 3;
		gbc_tfAncho.gridy = 1;
		pnlDatos.add(tfAncho, gbc_tfAncho);
		tfAncho.setColumns(10);
		
		JLabel lblCM1 = new JLabel("(cm)");
		GridBagConstraints gbc_lblCM1 = new GridBagConstraints();
		gbc_lblCM1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCM1.gridx = 4;
		gbc_lblCM1.gridy = 1;
		pnlDatos.add(lblCM1, gbc_lblCM1);
		
		JLabel lblAlto = new JLabel("Alto");
		GridBagConstraints gbc_lblAlto = new GridBagConstraints();
		gbc_lblAlto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlto.anchor = GridBagConstraints.EAST;
		gbc_lblAlto.gridx = 5;
		gbc_lblAlto.gridy = 1;
		pnlDatos.add(lblAlto, gbc_lblAlto);
		
		tfAlto = new JTextField();
		GridBagConstraints gbc_tfAlto = new GridBagConstraints();
		gbc_tfAlto.insets = new Insets(0, 0, 5, 5);
		gbc_tfAlto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAlto.gridx = 6;
		gbc_tfAlto.gridy = 1;
		pnlDatos.add(tfAlto, gbc_tfAlto);
		tfAlto.setColumns(10);
		
		JLabel lblCM2 = new JLabel("(cm)");
		GridBagConstraints gbc_lblCM2 = new GridBagConstraints();
		gbc_lblCM2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCM2.gridx = 7;
		gbc_lblCM2.gridy = 1;
		pnlDatos.add(lblCM2, gbc_lblCM2);
		
		JButton btnEngadir = new JButton("Engadir");
		GridBagConstraints gbc_btnEngadir = new GridBagConstraints();
		gbc_btnEngadir.insets = new Insets(0, 0, 5, 0);
		gbc_btnEngadir.gridx = 8;
		gbc_btnEngadir.gridy = 0;
		
		pnlDatos.add(btnEngadir, gbc_btnEngadir);
		btnEngadir.addActionListener(e -> {
			if(!tfModelo.getText().trim().isEmpty() && !tfCor.getText().trim().isEmpty() && !tfAncho.getText().trim().isEmpty() && !tfAlto.getText().trim().isEmpty()) {
				Alfombra a = new Alfombra(tfModelo.getText(), tfCor.getText(), Integer.parseInt(tfAncho.getText()), Integer.parseInt(tfAlto.getText())); 
				añadirAlfombraLista(a);
			}
			else {
				//POPUP
			}
			
		});
		
		
		// PANEL INFERIOR
		
		JPanel pnlLista = new JPanel();
		pnlLista.setBorder(new TitledBorder(null, "Alfombras dispo\u00F1ibles", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		GridBagConstraints gbc_pnlLista = new GridBagConstraints();
		gbc_pnlLista.insets = new Insets(0, 0, 5, 0);
		gbc_pnlLista.weighty = 6.0;
		gbc_pnlLista.fill = GridBagConstraints.BOTH;
		gbc_pnlLista.gridx = 0;
		gbc_pnlLista.gridy = 1;
		contentPane.add(pnlLista, gbc_pnlLista);
		pnlLista.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlInferior = new JPanel();
		pnlLista.add(pnlInferior);
		pnlInferior.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		modelo = 
		
		modelo.addElement(null);
		
		modelo.remo
		
		
		listaAlfombras = new JList();
		listaAlfombras.setModel(modelo);
		pnlInferior.add(listaAlfombras);
		
		JPanel pnlOpcionesAlfombras = new JPanel();
		pnlInferior.add(pnlOpcionesAlfombras);
		GridBagLayout gbl_pnlOpcionesAlfombras = new GridBagLayout();
		gbl_pnlOpcionesAlfombras.columnWidths = new int[]{0, 0};
		gbl_pnlOpcionesAlfombras.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlOpcionesAlfombras.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlOpcionesAlfombras.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOpcionesAlfombras.setLayout(gbl_pnlOpcionesAlfombras);
		
		btnInformacion = new JButton("Información das alfombras");
		GridBagConstraints gbc_btnInformacion = new GridBagConstraints();
		gbc_btnInformacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInformacion.insets = new Insets(0, 20, 5, 20);
		gbc_btnInformacion.gridx = 0;
		gbc_btnInformacion.gridy = 0;
		pnlOpcionesAlfombras.add(btnInformacion, gbc_btnInformacion);
		
		JButton btnEliminarUna = new JButton("Eliminar alfombra");
		GridBagConstraints gbc_btnEliminarUna = new GridBagConstraints();
		gbc_btnEliminarUna.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarUna.insets = new Insets(0, 20, 5, 20);
		gbc_btnEliminarUna.gridx = 0;
		gbc_btnEliminarUna.gridy = 1;
		pnlOpcionesAlfombras.add(btnEliminarUna, gbc_btnEliminarUna);
		
		JButton btnEliminarTodas = new JButton("Eliminar todas");
		GridBagConstraints gbc_btnEliminarTodas = new GridBagConstraints();
		gbc_btnEliminarTodas.insets = new Insets(0, 20, 0, 20);
		gbc_btnEliminarTodas.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarTodas.gridx = 0;
		gbc_btnEliminarTodas.gridy = 2;
		pnlOpcionesAlfombras.add(btnEliminarTodas, gbc_btnEliminarTodas);

	}

	private void añadirAlfombraLista(Alfombra a) {
		
		
	}
}
