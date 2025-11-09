package tarea0;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class TareaLayout {

	private JFrame frmFlowlayoutdemo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TareaLayout window = new TareaLayout();
					window.frmFlowlayoutdemo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TareaLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlowlayoutdemo = new JFrame();
		frmFlowlayoutdemo.setTitle("FlowLayoutDemo");
		frmFlowlayoutdemo.setBounds(100, 100, 337, 300);
		frmFlowlayoutdemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout ContentPane = new FlowLayout(FlowLayout.CENTER, 5, 5);
		frmFlowlayoutdemo.getContentPane().setLayout(ContentPane);
		
		JButton btnNewButton = new JButton("New button");
		frmFlowlayoutdemo.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		frmFlowlayoutdemo.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		frmFlowlayoutdemo.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		frmFlowlayoutdemo.getContentPane().add(btnNewButton_3).setPreferredSize(new Dimension(200, 23));;
		
		JButton btnNewButton_4 = new JButton("New button");
		frmFlowlayoutdemo.getContentPane().add(btnNewButton_4);
		
		
		JRadioButton rbtnLTR = new JRadioButton("Left To Right");
		buttonGroup.add(rbtnLTR);
		frmFlowlayoutdemo.getContentPane().add(rbtnLTR);
		
		JRadioButton rbtnRTL = new JRadioButton("Right To Left");
		buttonGroup.add(rbtnRTL);
		frmFlowlayoutdemo.getContentPane().add(rbtnRTL);
		
		JButton btnApply = new JButton("Apply Orientation");
		frmFlowlayoutdemo.getContentPane().add(btnApply);
		
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtnLTR.isSelected()) {
					ContentPane.setAlignment(FlowLayout.LEFT);
					frmFlowlayoutdemo.getContentPane().setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
				} else if (rbtnRTL.isSelected()) {
					ContentPane.setAlignment(FlowLayout.RIGHT);
					frmFlowlayoutdemo.getContentPane().setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
				}
				frmFlowlayoutdemo.getContentPane().revalidate();
				frmFlowlayoutdemo.getContentPane().repaint();
			}
		});
		
	}

}
