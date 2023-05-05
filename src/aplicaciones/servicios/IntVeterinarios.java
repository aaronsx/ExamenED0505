package aplicaciones.servicios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import aplicacion.entidades.Usuarios;

public interface IntVeterinarios {

	/**
	 * Método InsertarUsuario
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void InsertarUsuario(int opccion, List<Usuarios>bd,File archivo);
	//Escribir Fichero
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void AbrirFicheroEscrito(File archivo,List<Usuarios> bd);
	/**
	 * Método escribir un fichero
	 * @param db Arraylista actual,fileReader para leer el fichero
	 * @return nada
	 */
	public void EscribirFichero(FileWriter fichero,List<Usuarios> bd);
	/**
	 * Método cierrar un fichero
	 * @param file para cerrar el fichero
	 * @return 
	 */
	public void CerrarFichero(FileWriter fichero);
	//Leer Fichero
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void AbrirFicheroLeer(File archivo);
	/**
	 * Método escribir un fichero
	 * @param db Arraylista actual,fileReader para leer el fichero
	 * @return nada
	 */
	public void LeerFichero(FileReader  fr);
	/**
	 * Método cierrar un fichero
	 * @param file para cerrar el fichero
	 * @return 
	 */
	public void CerrarFicheroLeido(FileReader  fr);
}
