package tarea5componentesbasicos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;

public class Tarea5ComponentesBasicos extends JFrame {

	private static final double DESCUENTO1150 = 5;
	private static final double DESCUENTO50 = 15;
	private static final double DESCUENTOEMPLEADO = 10;
	private static final double DESCUENTOPREMIUM = 5;
	
	private JPanel contentPane;
    private JPanel pnlMain;
    private JPanel pnlDatos;
    private JPanel pnlPiezas;
    private JLabel lblPeza;
    private JTextField tfPeza;
    private JLabel lblPrezo;
    private JTextField tfPrezo;

    private JPanel pnlUnidades;
    private JRadioButton rbtn110;
    private JRadioButton rbtn1150;
    private JRadioButton rbtn50;
    private ButtonGroup btnOpciones;

    private JPanel pnlDescontos;
    private JCheckBox cbEmpregado;
    private JCheckBox cbPremium;

    private JPanel pnlResultados;
    private JTextPane tpResultados;

    private JPanel pnlOpciones;
    private JButton btnNovoCalculo;
    private JButton btnCalcular;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea5ComponentesBasicos frame = new Tarea5ComponentesBasicos();
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
	public Tarea5ComponentesBasicos() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnlMain = new JPanel();
		contentPane.add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new GridLayout(0, 2, 10, 0));
		
		pnlDatos = new JPanel();
		pnlMain.add(pnlDatos);
		GridBagLayout gbl_pnlDatos = new GridBagLayout();
		gbl_pnlDatos.columnWidths = new int[]{0, 0};
		gbl_pnlDatos.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDatos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlDatos.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlDatos.setLayout(gbl_pnlDatos);
		
		// APARTADO DE LAS PIEZAS 
		
		pnlPiezas = new JPanel();
		GridBagConstraints gbc_pnlPiezas = new GridBagConstraints();
		gbc_pnlPiezas.insets = new Insets(0, 0, 5, 0);
		gbc_pnlPiezas.fill = GridBagConstraints.BOTH;
		gbc_pnlPiezas.gridx = 0;
		gbc_pnlPiezas.gridy = 0;
		pnlDatos.add(pnlPiezas, gbc_pnlPiezas);
		GridBagLayout gbl_pnlPiezas = new GridBagLayout();
		gbl_pnlPiezas.columnWidths = new int[]{0, 0, 0};
		gbl_pnlPiezas.rowHeights = new int[]{0, 0, 0};
		gbl_pnlPiezas.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlPiezas.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pnlPiezas.setLayout(gbl_pnlPiezas);
		
		lblPeza = new JLabel("Peza");
		GridBagConstraints gbc_lblPeza = new GridBagConstraints();
		gbc_lblPeza.anchor = GridBagConstraints.WEST;
		gbc_lblPeza.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeza.gridx = 0;
		gbc_lblPeza.gridy = 0;
		pnlPiezas.add(lblPeza, gbc_lblPeza);
		
		tfPeza = new JTextField();
		GridBagConstraints gbc_tfPeza = new GridBagConstraints();
		gbc_tfPeza.insets = new Insets(0, 0, 5, 0);
		gbc_tfPeza.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPeza.gridx = 1;
		gbc_tfPeza.gridy = 0;
		pnlPiezas.add(tfPeza, gbc_tfPeza);
		tfPeza.setColumns(10);
		
		lblPrezo = new JLabel("Prezo/Unidade");
		GridBagConstraints gbc_lblPrezo = new GridBagConstraints();
		gbc_lblPrezo.anchor = GridBagConstraints.EAST;
		gbc_lblPrezo.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrezo.gridx = 0;
		gbc_lblPrezo.gridy = 1;
		pnlPiezas.add(lblPrezo, gbc_lblPrezo);
		
		tfPrezo = new JTextField();
		GridBagConstraints gbc_tfPrezo = new GridBagConstraints();
		gbc_tfPrezo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrezo.gridx = 1;
		gbc_tfPrezo.gridy = 1;
		pnlPiezas.add(tfPrezo, gbc_tfPrezo);
		tfPrezo.setColumns(7);
		
		// Para que solo acepte caracteres
		tfPrezo.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        // Solo permitir dígitos
		        if (!Character.isDigit(c)) {
		            e.consume(); // Ignora la tecla
		        }
		    }
		  });
	
		
		// APARTADO RADIOBUTTONS (SOLO SE PODRA SELECCIONAR 1)
		
		pnlUnidades = new JPanel();
		pnlUnidades.setBorder(new TitledBorder(null, "Unidades Adquiridas", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlUnidades = new GridBagConstraints();
		gbc_pnlUnidades.insets = new Insets(0, 0, 5, 0);
		gbc_pnlUnidades.fill = GridBagConstraints.BOTH;
		gbc_pnlUnidades.gridx = 0;
		gbc_pnlUnidades.gridy = 1;
		pnlDatos.add(pnlUnidades, gbc_pnlUnidades);
		GridBagLayout gbl_pnlUnidades = new GridBagLayout();
		gbl_pnlUnidades.columnWidths = new int[]{0, 0};
		gbl_pnlUnidades.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlUnidades.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlUnidades.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlUnidades.setLayout(gbl_pnlUnidades);
		
		rbtn110 = new JRadioButton("1 - 10");
		GridBagConstraints gbc_rbtn110 = new GridBagConstraints();
		gbc_rbtn110.anchor = GridBagConstraints.WEST;
		gbc_rbtn110.insets = new Insets(0, 0, 5, 0);
		gbc_rbtn110.gridx = 0;
		gbc_rbtn110.gridy = 0;
		pnlUnidades.add(rbtn110, gbc_rbtn110);
		
		rbtn1150 = new JRadioButton("11 - 50 (Desconto 5%)");
		GridBagConstraints gbc_rbtn1150 = new GridBagConstraints();
		gbc_rbtn1150.anchor = GridBagConstraints.WEST;
		gbc_rbtn1150.insets = new Insets(0, 0, 5, 0);
		gbc_rbtn1150.gridx = 0;
		gbc_rbtn1150.gridy = 1;
		pnlUnidades.add(rbtn1150, gbc_rbtn1150);
		
		rbtn50 = new JRadioButton("> 50 (Desconto 15%)");
		GridBagConstraints gbc_rbtn50 = new GridBagConstraints();
		gbc_rbtn50.anchor = GridBagConstraints.WEST;
		gbc_rbtn50.gridx = 0;
		gbc_rbtn50.gridy = 2;
		pnlUnidades.add(rbtn50, gbc_rbtn50);
		
		// Añado botones a buttongroup para que solo pueda escogerse 1
		btnOpciones = new ButtonGroup();
		btnOpciones.add(rbtn110);
		btnOpciones.add(rbtn1150);
		btnOpciones.add(rbtn50);
		
		// APARTADO DESCUENTOS
		
		pnlDescontos = new JPanel();
		pnlDescontos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descontos Adicionais", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlDescontos = new GridBagConstraints();
		gbc_pnlDescontos.fill = GridBagConstraints.BOTH;
		gbc_pnlDescontos.gridx = 0;
		gbc_pnlDescontos.gridy = 2;
		pnlDatos.add(pnlDescontos, gbc_pnlDescontos);
		GridBagLayout gbl_pnlDescontos = new GridBagLayout();
		gbl_pnlDescontos.columnWidths = new int[]{0, 0};
		gbl_pnlDescontos.rowHeights = new int[]{0, 0, 0};
		gbl_pnlDescontos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlDescontos.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pnlDescontos.setLayout(gbl_pnlDescontos);
		
		cbEmpregado = new JCheckBox("Empregado (Desconto 10%)");
		GridBagConstraints gbc_cbEmpregado = new GridBagConstraints();
		gbc_cbEmpregado.anchor = GridBagConstraints.WEST;
		gbc_cbEmpregado.insets = new Insets(0, 0, 5, 0);
		gbc_cbEmpregado.gridx = 0;
		gbc_cbEmpregado.gridy = 0;
		pnlDescontos.add(cbEmpregado, gbc_cbEmpregado);
		
		cbPremium = new JCheckBox("Cliente Premium (Desconto 5%)");
		GridBagConstraints gbc_cbPremium = new GridBagConstraints();
		gbc_cbPremium.anchor = GridBagConstraints.WEST;
		gbc_cbPremium.gridx = 0;
		gbc_cbPremium.gridy = 1;
		pnlDescontos.add(cbPremium, gbc_cbPremium);
		
		
		// APARTADO DE RESULTADOS (NO EDITABLE)
		
		pnlResultados = new JPanel();
		pnlResultados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultado do c\u00E1lculo", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		pnlMain.add(pnlResultados);
		pnlResultados.setLayout(new GridLayout(1, 0, 0, 0));
		
	    tpResultados = new JTextPane();
		tpResultados.setBackground(new Color(255, 255, 128));
		tpResultados.setEditable(false);
		pnlResultados.add(tpResultados);
		
		
		// APARTADO INFERIOR
		
		//BOTON RESETEAR
		
		pnlOpciones = new JPanel();
		contentPane.add(pnlOpciones, BorderLayout.SOUTH);
		pnlOpciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNovoCalculo = new JButton("Novo cálculo");
		pnlOpciones.add(btnNovoCalculo);
		
		btnNovoCalculo.addActionListener(e-> {
			reiniciarFormulario();
		});
		
		// BOTON CALCULAR 
		
		btnCalcular = new JButton("Calcular");
		pnlOpciones.add(btnCalcular);
		
		// TRIM PARA EVITAR QUE PONGA SOLO ESPACIOS EN BLANCO
		btnCalcular.addActionListener(e->{
			if(tfPeza.getText().trim().isEmpty() || tfPrezo.getText().trim().isEmpty()) {
				
			}
			else {
				realizarCalculo();
			}
			
			
		});
		
		
	
}

	private void realizarCalculo() {
		StringBuilder descuentos = new StringBuilder();
		int descuentoUnidades = 0;
		int descuentoAdicional = 0;
		int descuentoTotal = 0;
		int precioFinal;
		
		descuentos.append("Peza: ").append(tfPeza.getText()).append("\n");
		descuentos.append("Prezo / unidade sen desconto: ").append(tfPrezo.getText()).append("\n");
		
		// Si no hay descuentos
		
		if(!rbtn1150.isSelected() && !rbtn50.isSelected() && !cbEmpregado.isSelected() && !cbPremium.isSelected()) {
			descuentos.append("Non hai descontos aplicables sobre o prezo final");
			tpResultados.setText(descuentos.toString());
			return;
		}
		
		// Si los hay
		else {
			descuentos.append("Descontos aplicados: \n-------------------------\n");
			//Descuentos por unidades
			if(rbtn1150.isSelected()) {
				descuentoUnidades += DESCUENTO1150;
				descuentos.append("Desconto por unidades adquiridas: ").append(descuentoUnidades).append("%\n");
			}
			else if(rbtn50.isSelected()) {
				descuentoUnidades += DESCUENTO50;
				descuentos.append("Desconto por unidades adquiridas: ").append(descuentoUnidades).append("%\n");
			}
			
			//Descuentos adicionales
			if(cbEmpregado.isSelected()) {
				descuentoAdicional += DESCUENTOEMPLEADO;
			}
			if(cbPremium.isSelected()) {
				descuentoAdicional += DESCUENTOPREMIUM;
			}
			
			if(descuentoAdicional != 0) {
				descuentos.append("Descontos adicionais: ").append(descuentoAdicional).append("%\n");
			}
			
			descuentoTotal = descuentoUnidades + descuentoAdicional;
			 descuentos.append("Desconto total sobre o prezo final: ").append(descuentoTotal).append("%\n");
			
			precioFinal = Integer.parseInt(tfPrezo.getText()) - (Integer.parseInt(tfPrezo.getText()) * descuentoTotal / 100);
			descuentos.append("Prezo con desconto: ").append(precioFinal);
			
			tpResultados.setText(descuentos.toString());
			return;
			
		}
		
		
	}
	
	private void reiniciarFormulario() {
	    // Limpiar campos de texto
	    tfPeza.setText("");
	    tfPrezo.setText("");
	    
	    // Deseleccionar radio buttons
	    btnOpciones.clearSelection();
	    
	    // Deseleccionar checkboxes
	    cbEmpregado.setSelected(false);
	    cbPremium.setSelected(false);
	    
	    // Limpiar resultados
	    tpResultados.setText("");
	}
	}
