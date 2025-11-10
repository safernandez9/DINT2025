package tarea10jdialogintercambiodatos;

public class Usuario {
	private int id;
	private String nombre;
	private String apellidos;
	private String provincia;

	public Usuario(int id, String nombre, String apellidos, String provincia) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.provincia = provincia;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getProvincia() {
		return provincia;
	}

	@Override
	public String toString() {
		return "Usuario ID " + id + "-" + nombre + " " + apellidos + " (" + provincia + ")";
	}
}
