package aplicacion.entidades;

public class Usuarios {
	private int codigoIdentificador;
	
	private String nombre;
	private String apellidos;
	private boolean esVeterinario;
	//-----------------CONSTRUCTORES-----------------
	public Usuarios(int codigoIdentificador, String nombre, String apellidos, boolean esVeterinario) {
		super();
		this.codigoIdentificador = codigoIdentificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.esVeterinario = esVeterinario;
	}
	
	//----------GETTERS AND SETTERS-------------------
	public int getCodigoIdentificador() {
		return codigoIdentificador;
	}
	public void setCodigoIdentificador(int codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isEsVeterinario() {
		return esVeterinario;
	}
	public void setEsVeterinario(boolean esVeterinario) {
		this.esVeterinario = esVeterinario;
	}
	
}
