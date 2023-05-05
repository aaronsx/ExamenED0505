package aplicacion.entidades;

public class Veterinarios extends Usuarios {
	private String numeroColegiado;
	//-----------------CONSTRUCTORES-----------------
	public Veterinarios(int codigoIdentificador, String nombre, String apellidos, boolean esVeterinario,String numeroColegiado) {
		super(codigoIdentificador, nombre, apellidos, esVeterinario);
		this.numeroColegiado = numeroColegiado;
	}
	//----------GETTERS AND SETTERS-------------------
	public String getNumeroColegiado() {
		return numeroColegiado;
	}

	public void setNumeroColegiado(String numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}
	
}
