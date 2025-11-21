package jdialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.FocusTraversalPolicy;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Vector;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import examen.Dato;

public class ReporteJDialog extends JDialog implements MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaReportes;
	private int numRegistrados;
	private int numDentro;
	private int movHistorial;
	private int edadMediaTotal;
	private int edadMediaDentro;
	private DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Launch the application.
	 */

	public ReporteJDialog(Frame padre, boolean modal, int numRegistrados, int numDentro, int movHistorial,
			int edadMediaTotal, int edadMediaDentro) {
		super(padre, modal);
		this.numRegistrados = numRegistrados;
		this.numDentro = numDentro;
		this.movHistorial = movHistorial;
		this.edadMediaTotal = edadMediaTotal;
		this.edadMediaDentro = edadMediaDentro;
		inicializarComponentes();
	}

	/**
	 * Create the dialog.
	 */
	public void inicializarComponentes() {
		setBounds(100, 100, 441, 456);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JPanel pnlReportes = new JPanel();
		pnlReportes.setBorder(new TitledBorder(null, "Reportes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlReportes = new GridBagConstraints();
		gbc_pnlReportes.fill = GridBagConstraints.BOTH;
		gbc_pnlReportes.gridx = 0;
		gbc_pnlReportes.gridy = 0;
		contentPanel.add(pnlReportes, gbc_pnlReportes);
		GridBagLayout gbl_pnlReportes = new GridBagLayout();
		gbl_pnlReportes.columnWidths = new int[] { 452, 0 };
		gbl_pnlReportes.rowHeights = new int[] { 427, 0 };
		gbl_pnlReportes.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlReportes.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlReportes.setLayout(gbl_pnlReportes);

		JScrollPane scpReportes = new JScrollPane();
		GridBagConstraints gbc_scpReportes = new GridBagConstraints();
		gbc_scpReportes.fill = GridBagConstraints.BOTH;
		gbc_scpReportes.gridx = 0;
		gbc_scpReportes.gridy = 0;
		pnlReportes.add(scpReportes, gbc_scpReportes);

		tablaReportes = new JTable();
		tablaReportes.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Item", "Valor" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		((DefaultTableCellRenderer) tablaReportes.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		scpReportes.setViewportView(tablaReportes);

		cargarTabla();
	}

	private void cargarTabla() {

		// COMENTADO POR QUE DA ERROR EN LA ASIGNACION DE LAS FILAS
		
		/*Dato[] datos = new Dato[] { new Dato("Nº de usuarios totales", numRegistrados),
				new Dato("Nº usuarios en el gimnasio", numDentro),
				new Dato("Nº de movimientos en el historial", movHistorial),
				new Dato("Edad media usuarios registrados", edadMediaTotal),
				new Dato("Edad media usuarios en el gimnasio", edadMediaDentro)

		};

		for (Dato d : datos) {
			modeloTabla.setRowCount(modeloTabla.getRowCount() + 1); // Engadir unha fila
			modeloTabla.setValueAt(d.getDato(), modeloTabla.getRowCount() - 1, 0);
			modeloTabla.setValueAt(d.getDato(), modeloTabla.getRowCount() - 1, 1);
		}
*/
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	};

}
