package tarea8jtable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tarea8JTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		// New JTable (DEBE ESTAR EN UN SCROLLPANE)
		
		table = new JTable();
		
		// Creo el modelo de la tabla
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"C1", "C2", "C3", "C4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		modelo = (DefaultTableModel) table.getModel();
		
		// Obtener numero de filas
		System.out.println(modelo.getRowCount());

		// Añadir fila
		Object[] datos = new Object[]{"dato", null, null, null};
		modelo.addRow(datos);
		
		// Añadir celda a celda
		modelo.setRowCount(modelo.getRowCount() + 1);
		modelo.setValueAt("valorMetidoPorCodigoCelda1", modelo.getRowCount() - 1, 0);
		modelo.setValueAt("valorMetidoPorCodigoCelda2", modelo.getRowCount() - 1, 1);
		
		// Resetear Tabla
		
		// Nombre de las columnas
		for(int i = 0; i < modeloMobles.getColumnCount(); i++) {
			System.out.println("columna" + i   )
		}
		
		
		
	}

}
