package tresEnRaya;

import javax.swing.JButton;

import java.awt.Color;
import java.util.Arrays;

public class Juego {

	final int FILAS = 3;
	final int COLUMNAS = 3;
	final int VICTORIA = 3;
	
	private static Juego j = null;

	int turno = 1;
	JButton[][] tablero = new JButton[FILAS][COLUMNAS];
	int[][] tableroMatriz = new int[FILAS][COLUMNAS];
	
	
	// Uso un singleton para que solo pueda haber un objeto partida
	private Juego() {
	}
	
	public static Juego getInstance() {
		if(j == null) {
			j = new Juego();
		}	
		return j;	
	}

	/**
	 * INICIA LA PARTIDA CON TURNO 1 Y LA MATRIZ AUXILIAR A 0
	 */
	
	public void iniciarPartida() {
		inicializarTableroMatriz(tableroMatriz, 0);
		this.turno = 1;
		inicializarBotones(tablero);

	}

	/**
	 * INICIALIZO LOS BOTONES A LA SITUACION INICIAL
	 * @param tablero
	 */
	private void inicializarBotones(JButton[][] tablero) {
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				JButton btn = this.getBoton(i, j);
				btn.setText("-");
				btn.setBackground(new Color(255,255,255));
				btn.setEnabled(true);
			}
		}
		
		
	}

	/**
	 * INICIA LA MATRIZ AUXILIAR AL VALOR RECIBIDO
	 * 
	 * @param tableroMatriz
	 * @param valorInicial
	 */
	private void inicializarTableroMatriz(int[][] tableroMatriz, int valorInicial) {
		for (int i = 0; i < FILAS; i++) {
			Arrays.fill(tableroMatriz[i], valorInicial);
		}
	}
	
	/**
	 * ASOCIA EL JUGADOR QUE PULSA UN BOTON A SU POSICION EN LA MATRIZ AUXILIAR
	 * @param boton
	 * @param usuario
	 */
	public void asociarJugadorBoton(JButton boton) {
		for(int i = 0; i< FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				if(tablero[i][j] == boton) {
					tableroMatriz[i][j] = this.turno;
				}
			}
		}	
	}

	/**
	 * COMPRUEBA SI UNA FILA TIENE TODOS LOS BOTONES PULSADOS POR UN USUARIO
	 * 
	 * @return
	 */
	public boolean comprobarFilas() {

		int punto = 0;

		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (!getBoton(i, j).isEnabled() && getCasilla(i, j) == this.turno) {
					punto++;
				}
			}
			if (punto == VICTORIA) {
				return true;
			}
			punto = 0;
		}

		return false;
	}

	/**
	 * COMPRUEBA SI UNA COLUMNA TIENE TODOS LOS BOTONES PULSADOS POR UN USUARIO
	 * 
	 * @return
	 */
	public boolean comprobarColumnas() {

		int punto = 0;

		for (int i = 0; i < COLUMNAS; i++) {
			for (int j = 0; j < FILAS; j++) {
				if (!getBoton(j, i).isEnabled() && getCasilla(j, i) == this.turno) {
					punto++;
				}
			}
			if (punto == VICTORIA) {
				return true;
			}
			punto = 0;
		}

		return false;

	}

	/**
	 * COMPRUEBA SI UNA DIAGONAL TIENE TODOS SUS BOTONES PULSADOS POR UN USUARIO
	 * 
	 * @return
	 */
	public boolean comprobarDiagonal() {

		int punto = 0;

		// DIAGONAL PRINCIPAL

		for (int i = 0; i < FILAS; i++) {
			{
				if (!getBoton(i, i).isEnabled() && getCasilla(i, i) == this.turno) {
					punto++;
				}
			}

			if (punto == VICTORIA) {
				return true;
			}

		}

		// DIAGONAL SECUNDARIA

		punto = 0;

		for (int i = 0; i < FILAS; i++) {
			if (!getBoton(i, FILAS - 1 - i).isEnabled() && getCasilla(i, FILAS - i - 1) == this.turno) {
				punto++;
			}
		}

		if (punto == VICTORIA) {
			return true;
		}

		return false;

	}

	/**
	 * COMPRUEBA SI HAY UNA COMBINACION GANADORA
	 * @return
	 */
	public boolean comprobarTablero() {

		if (this.comprobarFilas() || this.comprobarColumnas() || this.comprobarDiagonal()) {
			return true;
		}

		return false;

	}
	
	/**
	 * Comrueba si hay un empate
	 * @return
	 */
	public boolean comprobarEmpate() {
	    for (int i = 0; i < FILAS; i++) {
	        for (int j = 0; j < COLUMNAS; j++) {
	            if (getBoton(i, j).isEnabled()) {
	                return false; // hay una casilla libre, no hay empate
	            }
	        }
	    }
	    // Si todas están ocupadas y no hay ganador, empate
	    return !comprobarTablero();
	}
	
	// GETTERS Y SETTERS

	public int getCasilla(int i, int j) {
		return this.tableroMatriz[i][j];
	}

	public void setCasilla(int i, int j, int valor) {
		this.tableroMatriz[i][j] = valor;
	}

	public JButton getBoton(int i, int j) {
		return tablero[i][j];
	}

	public void setBoton(JButton boton, int i, int j) {
		this.tablero[i][j] = boton;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}



}
