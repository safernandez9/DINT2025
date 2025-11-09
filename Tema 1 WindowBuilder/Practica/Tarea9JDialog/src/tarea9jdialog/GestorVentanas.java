package tarea9jdialog;

import java.awt.Frame;
import java.util.Vector;

public class GestorVentanas {

	// VECTOR PARA IR GUARDANDO LAS REFERENCIAS A LAS VENTANAS DATOSPERSOAIS CREADAS
	static private Vector ventanasDatosPersoais = new Vector();

	// VENTOR PARA IR GUARDANDO LAS REFERENCIAS A LAS VENTANAS DATOSACADEMICOS
	// CREADAS
	static private Vector ventanasDatosAcademicos = new Vector();

	// METODOS DE CONTEO DE VENTANAS ABIERTAS
	// Se llaman al abrir (pulsar el boton) y cerrar (WindowEvent) las ventanas

	// Variables que llevan cuenta de las ventanas abiertas de cada tipo
	static private int numVentanasDatosPersoais = 0;
	static private int numVentanasDatosAcademicos = 0;

	public static void cerrarVentanasDatosPersoais() {
		numVentanasDatosPersoais--;
	}

	/**
	 * Se llama cada vez que se pulsa el boton datosPersoais Devuelve true o false
	 * en función del límite de ventanas abiertas que quiera
	 * 
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

	/**
	 * Se llama cada vez que se pulsa el boton datosAcademicos Devuelve true si no
	 * hay ninguna y false si ya hay ventanas abiertas
	 * 
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

	// Los siguientes metodos se llamaran cuando se abra o cierre una ventana

	// Metodos de manejo del Vector de ventanas DatosPersoais

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

	// Metodos de manejo del Vector de ventanas DatosAcademicos

	public static void añadirVentanaDatosAcademicos(DatosAcademicosJDialog xanela) {
		ventanasDatosAcademicos.add(xanela);
	}

	public static void eliminarVentanaDatosAcademicos(DatosAcademicosJDialog xanela) {
		for (int i = 0; i < ventanasDatosAcademicos.size(); i++) {
			if (ventanasDatosAcademicos.elementAt(i) == xanela) {
				ventanasDatosAcademicos.removeElementAt(i);
				break;
			}
		}
		System.out.println(ventanasDatosAcademicos.size());
	}

	public static Vector getVentanasDatosAcademicos() {
		return ventanasDatosAcademicos;
	}

}
