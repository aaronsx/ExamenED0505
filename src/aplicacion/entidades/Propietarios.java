package aplicacion.entidades;

public class Propietarios extends Usuarios {
	private int numeroMascotas;
	//-----------------CONSTRUCTORES-----------------
	public Propietarios(int codigoIdentificador, String nombre, String apellidos, boolean esVeterinario,int numeroMascotas) {
		super(codigoIdentificador, nombre, apellidos, esVeterinario);
		this.numeroMascotas = numeroMascotas;
	}
	//----------GETTERS AND SETTERS-------------------
	public int getNumeroMascotas() {
		return numeroMascotas;
	}

	public void setNumeroMascotas(int numeroMascotas) {
		this.numeroMascotas = numeroMascotas;
	}
}
