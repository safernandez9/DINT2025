package tarea8jtable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Tarea8JTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField tfCor;
	private JTextField tfNome;
	private JTextField tfAlto;
	private JTextField tfFondo;
	private JTextField tfAncho;
	private JComboBox combMaterial;
	private JTable tbPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea8JTable frame = new Tarea8JTable();
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
	public Tarea8JTable() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel pnlNovoMoble = new JPanel();
		pnlNovoMoble.setBorder(new TitledBorder(null, "Novo moble", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		GridBagConstraints gbc_pnlNovoMoble = new GridBagConstraints();
		gbc_pnlNovoMoble.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNovoMoble.fill = GridBagConstraints.BOTH;
		gbc_pnlNovoMoble.gridx = 0;
		gbc_pnlNovoMoble.gridy = 0;
		getContentPane().add(pnlNovoMoble, gbc_pnlNovoMoble);
		GridBagLayout gbl_pnlNovoMoble = new GridBagLayout();
		gbl_pnlNovoMoble.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlNovoMoble.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlNovoMoble.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNovoMoble.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlNovoMoble.setLayout(gbl_pnlNovoMoble);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		pnlNovoMoble.add(lblNome, gbc_lblNome);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.gridwidth = 8;
		gbc_tfNome.insets = new Insets(0, 0, 5, 5);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		pnlNovoMoble.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JButton btnEngadir = new JButton("Engadir");
		GridBagConstraints gbc_btnEngadir = new GridBagConstraints();
		gbc_btnEngadir.insets = new Insets(0, 0, 5, 0);
		gbc_btnEngadir.gridx = 9;
		gbc_btnEngadir.gridy = 0;
		pnlNovoMoble.add(btnEngadir, gbc_btnEngadir);
		
		JLabel lblCor = new JLabel("Cor");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCor.gridx = 0;
		gbc_lblCor.gridy = 1;
		pnlNovoMoble.add(lblCor, gbc_lblCor);
		
		tfCor = new JTextField();
		GridBagConstraints gbc_tfCor = new GridBagConstraints();
		gbc_tfCor.gridwidth = 2;
		gbc_tfCor.insets = new Insets(0, 0, 5, 5);
		gbc_tfCor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCor.gridx = 1;
		gbc_tfCor.gridy = 1;
		pnlNovoMoble.add(tfCor, gbc_tfCor);
		tfCor.setColumns(10);
		
		JLabel lblMaterial = new JLabel("Material");
		GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
		gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterial.gridx = 3;
		gbc_lblMaterial.gridy = 1;
		pnlNovoMoble.add(lblMaterial, gbc_lblMaterial);
		
		combMaterial = new JComboBox();
		GridBagConstraints gbc_combMaterial = new GridBagConstraints();
		gbc_combMaterial.gridwidth = 5;
		gbc_combMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_combMaterial.fill = GridBagConstraints.HORIZONTAL;
		gbc_combMaterial.gridx = 4;
		gbc_combMaterial.gridy = 1;
		combMaterial.setModel(null);
		pnlNovoMoble.add(combMaterial, gbc_combMaterial);
		
		JLabel lblAncho = new JLabel("Ancho");
		GridBagConstraints gbc_lblAncho = new GridBagConstraints();
		gbc_lblAncho.insets = new Insets(0, 0, 0, 5);
		gbc_lblAncho.gridx = 0;
		gbc_lblAncho.gridy = 2;
		pnlNovoMoble.add(lblAncho, gbc_lblAncho);
		
		tfAncho = new JTextField();
		GridBagConstraints gbc_tfAncho = new GridBagConstraints();
		gbc_tfAncho.insets = new Insets(0, 0, 0, 5);
		gbc_tfAncho.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAncho.gridx = 1;
		gbc_tfAncho.gridy = 2;
		pnlNovoMoble.add(tfAncho, gbc_tfAncho);
		tfAncho.setColumns(10);
		
		JLabel lblcm1 = new JLabel("(cm)");
		GridBagConstraints gbc_lblcm1 = new GridBagConstraints();
		gbc_lblcm1.insets = new Insets(0, 0, 0, 5);
		gbc_lblcm1.gridx = 2;
		gbc_lblcm1.gridy = 2;
		pnlNovoMoble.add(lblcm1, gbc_lblcm1);
		
		JLabel lblAlto = new JLabel("Alto");
		GridBagConstraints gbc_lblAlto = new GridBagConstraints();
		gbc_lblAlto.insets = new Insets(0, 0, 0, 5);
		gbc_lblAlto.gridx = 3;
		gbc_lblAlto.gridy = 2;
		pnlNovoMoble.add(lblAlto, gbc_lblAlto);
		
		tfAlto = new JTextField();
		GridBagConstraints gbc_tfAlto = new GridBagConstraints();
		gbc_tfAlto.insets = new Insets(0, 0, 0, 5);
		gbc_tfAlto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAlto.gridx = 4;
		gbc_tfAlto.gridy = 2;
		pnlNovoMoble.add(tfAlto, gbc_tfAlto);
		tfAlto.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("(cm)");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 2;
		pnlNovoMoble.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblFondo = new JLabel("Fondo");
		GridBagConstraints gbc_lblFondo = new GridBagConstraints();
		gbc_lblFondo.insets = new Insets(0, 0, 0, 5);
		gbc_lblFondo.gridx = 6;
		gbc_lblFondo.gridy = 2;
		pnlNovoMoble.add(lblFondo, gbc_lblFondo);
		
		tfFondo = new JTextField();
		GridBagConstraints gbc_tfFondo = new GridBagConstraints();
		gbc_tfFondo.insets = new Insets(0, 0, 0, 5);
		gbc_tfFondo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFondo.gridx = 7;
		gbc_tfFondo.gridy = 2;
		pnlNovoMoble.add(tfFondo, gbc_tfFondo);
		tfFondo.setColumns(10);
		
		JLabel lblcm3 = new JLabel("(cm)");
		GridBagConstraints gbc_lblcm3 = new GridBagConstraints();
		gbc_lblcm3.insets = new Insets(0, 0, 0, 5);
		gbc_lblcm3.gridx = 8;
		gbc_lblcm3.gridy = 2;
		pnlNovoMoble.add(lblcm3, gbc_lblcm3);
		
		JPanel pnlDisponibles = new JPanel();
		pnlDisponibles.setBorder(new TitledBorder(null, "Mobles dispo\u00F1ibles", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		GridBagConstraints gbc_pnlDisponibles = new GridBagConstraints();
		gbc_pnlDisponibles.weighty = 5.0;
		gbc_pnlDisponibles.fill = GridBagConstraints.BOTH;
		gbc_pnlDisponibles.gridx = 0;
		gbc_pnlDisponibles.gridy = 1;
		getContentPane().add(pnlDisponibles, gbc_pnlDisponibles);
		GridBagLayout gbl_pnlDisponibles = new GridBagLayout();
		gbl_pnlDisponibles.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlDisponibles.rowHeights = new int[]{0, 0, 0};
		gbl_pnlDisponibles.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDisponibles.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlDisponibles.setLayout(gbl_pnlDisponibles);
		
		tbPrincipal = new JTable();
		GridBagConstraints gbc_tbPrincipal = new GridBagConstraints();
		gbc_tbPrincipal.gridwidth = 3;
		gbc_tbPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_tbPrincipal.fill = GridBagConstraints.BOTH;
		gbc_tbPrincipal.gridx = 0;
		gbc_tbPrincipal.gridy = 0;
		tbPrincipal.setVisible(false);
		pnlDisponibles.add(tbPrincipal, gbc_tbPrincipal);
		
		JButton btnInforme = new JButton("Informe dos mobles");
		btnInforme.setEnabled(false);
		GridBagConstraints gbc_btnInforme = new GridBagConstraints();
		gbc_btnInforme.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInforme.insets = new Insets(0, 0, 0, 5);
		gbc_btnInforme.gridx = 0;
		gbc_btnInforme.gridy = 1;
		pnlDisponibles.add(btnInforme, gbc_btnInforme);
		
		JButton btnEliminarUno = new JButton("Eliminar moble");
		btnEliminarUno.setEnabled(false);
		GridBagConstraints gbc_btnEliminarUno = new GridBagConstraints();
		gbc_btnEliminarUno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarUno.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminarUno.gridx = 1;
		gbc_btnEliminarUno.gridy = 1;
		pnlDisponibles.add(btnEliminarUno, gbc_btnEliminarUno);
		
		JButton btnEliminarTodos = new JButton("Eliminar todos");
		btnEliminarTodos.setEnabled(false);
		GridBagConstraints gbc_btnEliminarTodos = new GridBagConstraints();
		gbc_btnEliminarTodos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminarTodos.gridx = 2;
		gbc_btnEliminarTodos.gridy = 1;
		pnlDisponibles.add(btnEliminarTodos, gbc_btnEliminarTodos);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		JPanel panel = new JPanel();
//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.fill = GridBagConstraints.BOTH;
//		gbc_panel.gridx = 0;
//		gbc_panel.gridy = 0;
//		getContentPane().add(panel, gbc_panel);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		contentPane.add(scrollPane);
//		
//		// New JTable (DEBE ESTAR EN UN SCROLLPANE)
//		
//		table = new JTable();
//		
//		// Creo el modelo de la tabla
//		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null},
//			},
//			new String[] {
//				"C1", "C2", "C3", "C4"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		scrollPane.setViewportView(table);
//		
//		modelo = (DefaultTableModel) table.getModel();
//		
//		// Obtener numero de filas
//		System.out.println(modelo.getRowCount());
//
//		// Añadir fila
//		Object[] datos = new Object[]{"dato", null, null, null};
//		modelo.addRow(datos);
//		
//		// Añadir celda a celda
//		modelo.setRowCount(modelo.getRowCount() + 1);
//		modelo.setValueAt("valorMetidoPorCodigoCelda1", modelo.getRowCount() - 1, 0);
//		modelo.setValueAt("valorMetidoPorCodigoCelda2", modelo.getRowCount() - 1, 1);
//		
//		// Resetear Tabla
//		
//		// Nombre de las columnas
////		for(int i = 0; i < modeloMobles.getColumnCount(); i++) {
////			System.out.println("columna" + i   )
////		}
//		
		
		
	}

}
