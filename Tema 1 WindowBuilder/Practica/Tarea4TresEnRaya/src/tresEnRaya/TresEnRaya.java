package tresEnRaya;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;

public class TresEnRaya extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRaya frame = new TresEnRaya();
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
	public TresEnRaya() {

		// CREO INTERFAZ Y PARTIDA

		Juego partida = Juego.getInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// MENU Y BOTONES DEL MENU (setAccelerator sirve para que las combinaciones de teclas se escuchen)
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar partida       Ctrl + R");
		mntmReiniciar.setAccelerator(KeyStroke.getKeyStroke("control R"));
		mntmReiniciar.addActionListener(e -> {
			partida.iniciarPartida();
		});
		mnMenu.add(mntmReiniciar);

		JMenuItem mntmSalir = new JMenuItem("Salir              Ctrl + X");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke("control X"));
		mntmSalir.addActionListener(e -> {
			System.exit(0);
		});
		mnMenu.add(mntmSalir);
		
		
		// PANEL JUEGO
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlTurno = new JPanel();
		pnlTurno.setBackground(Color.WHITE);
		contentPane.add(pnlTurno, BorderLayout.NORTH);

		JLabel lblTurno = new JLabel("Es el turno de Usuario 1");
		pnlTurno.add(lblTurno);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		// Creo botones y le asocio botones a un array bidimensional tablero
		// LLamo a turno con el boton, natrççç

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton("-");
				btn.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_btn = new GridBagConstraints();
				gbc_btn.fill = GridBagConstraints.BOTH;
				gbc_btn.gridx = j;
				gbc_btn.gridy = i;
				panel_1.add(btn, gbc_btn);
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						turno((JButton) e.getSource(), partida, lblTurno);

					}
				});
				partida.setBoton(btn, i, j);
			}
		}

	}

	public void turno(JButton boton, Juego partida, JLabel lblTurno) {

		boton.setEnabled(false);

		if (partida.getTurno() == 1) {

			boton.setText("1");
			boton.setBackground(new Color(0, 200, 0));
			partida.asociarJugadorBoton(boton);

			if (partida.comprobarTablero()) {
				JOptionPane.showMessageDialog(null, // componente padre (null = centrado en pantalla)
						"Ganador el usuario " + partida.getTurno(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);

				// Código que se ejecuta después de cerrar el pop-up
				partida.iniciarPartida();
				lblTurno.setText("Es el turno de Usuario 1");
				return;

			}
			
			if (partida.comprobarEmpate()) {
			    JOptionPane.showMessageDialog(null, "¡Empate!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			    partida.iniciarPartida();
			    lblTurno.setText("Es el turno de Usuario 1");
			    return;
			}
			partida.setTurno(2);

		} else if (partida.getTurno() == 2) {

			boton.setBackground(new Color(200, 0, 0));
			boton.setText("2");
			partida.asociarJugadorBoton(boton);

			if (partida.comprobarTablero()) {
				JOptionPane.showMessageDialog(null, // componente padre (null = centrado en pantalla)
						"Ganador el usuario " + partida.getTurno() + "!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

				// Código que se ejecuta después de cerrar el pop-up
				partida.iniciarPartida();
				lblTurno.setText("Es el turno de Usuario 1");
				return;

			}
			
			if (partida.comprobarEmpate()) {
			    JOptionPane.showMessageDialog(null, "¡Empate!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			    partida.iniciarPartida();
			    lblTurno.setText("Es el turno de Usuario 1");
			    return;
			}
			partida.setTurno(1);
		}

		lblTurno.setText("Es el turno de Usuario " + partida.getTurno());
	}

}
