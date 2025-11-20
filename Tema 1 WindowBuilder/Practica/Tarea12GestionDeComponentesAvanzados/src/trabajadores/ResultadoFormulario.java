package trabajadores;

public class ResultadoFormulario {
	private String mensaje;
	private boolean resultado;
	
	public ResultadoFormulario(String mensaje, boolean resultado) {
		this.mensaje = mensaje;
		this.resultado = resultado;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
	
	public boolean getResultado() {
		return this.resultado;
	}
}
