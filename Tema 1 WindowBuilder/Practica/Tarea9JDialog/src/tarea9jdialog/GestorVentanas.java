package examen;


public class GestorVentanas {

	// Variables que llevan cuenta de las ventanas abiertas de cada tipo
	static private int numVentanasReportes = 0;

	public static void cerrarVentanaReportes() {
		numVentanasReportes--;
	}

	/**
	 * Se llama cada vez que se pulsa el boton Reportes Devuelve true o false en
	 * función del límite de ventanas abiertas que quiera
	 * 
	 * @return
	 */
	public static boolean abrirVentanaReportes() {
		if (numVentanasReportes < 1) {
			numVentanasReportes++;
			return true;
		} else {
			return false;
		}
	}


}