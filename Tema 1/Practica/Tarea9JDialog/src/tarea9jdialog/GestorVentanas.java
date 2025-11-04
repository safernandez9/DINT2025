package tarea9jdialog;

import java.awt.Frame;
import java.util.Vector;

public class GestorVentanas {
	
	static private Vector ventanasDatosPersoais = new Vector();
	
	// METODOS DE CONTEO DE VENTANAS ABIERTAS
	// Se llaman al abrir (pulsar el boton) y cerrar (WindowEvent) las ventanas

	// Variables que llevan cuenta de las ventanas abiertas de cada tipo
	static private int numVentanasDatosPersoais = 0;
	static private int numVentanasDatosAcademicos = 0;

	public static void cerrarVentanasDatosPersoais() {
		numVentanasDatosPersoais--;
	}

	/** Se llama cada vez que se pulsa el boton datosPersoais
	 * Devuelve true o false en función del límite de ventanas abiertas que quiera
	 * @return
	 */
	public static boolean abrirVentanasDatosPersoais() {
		if (numVentanasDatosPersoais < 5) {
			numVentanasDatosPersoais++;
			return true;
		} else {
			return false;
		}
	}

	public static void cerrarVentanasDatosAcademicos() {
		numVentanasDatosAcademicos--;
	}

	/** Se llama cada vez que se pulsa el boton datosAcademicos
	 * Devuelve true si no hay ninguna y false si ya hay ventanas abiertas
	 * @return
	 */
	public static boolean abrirVentanasDatosAcademicos() {
		if (numVentanasDatosAcademicos < 2) {
			numVentanasDatosAcademicos++;
			return true;
		} else {
			return false;
		}

	}
	
	
	// METODOS PARA IR GUARDANDO LAS REFERENCIAS A LAS VENTANAS DATOSPERSOAIS CREADAS
	// Se llaman al abrir (pulsar el boton) y cerrar (WindowEvent) las ventanas

	public static void añadirVentanaDatosPersoais(DatosPersoaisJDialog xanela) {
		ventanasDatosPersoais.add(xanela);
	}

	public static void eliminarVentanaDatosPersoais(DatosPersoaisJDialog xanela) {
		for (int i = 0; i < ventanasDatosPersoais.size(); i++) {
			if (ventanasDatosPersoais.elementAt(i) == xanela) {
				ventanasDatosPersoais.removeElementAt(i);
				break;
			}
		}
		System.out.println(ventanasDatosPersoais.size());
	}

	public static Vector getVentanasDatosPersoais() {
		return ventanasDatosPersoais;
	}
	
}
