package aplicaciones.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Propietarios;
import aplicacion.entidades.Usuarios;
import aplicacion.entidades.Veterinarios;

public class ImpVeterinarios implements IntVeterinarios {

	@Override
	public void InsertarUsuario(int opccion, List<Usuarios> bd, File archivo) {
		//Insertar usuario
		Scanner pregunta=new Scanner(System.in);
		  String nombre="aaaaaaaaaaaaaaaa";
		  String apellidos="aaaaaaaaaaaaaaaa";
		  String apellido1="aaaaaaaaaaaaaaaa";
		  String apellidos2="aaaaaaaaaaaaaaaa";
		  String SioNo="aaaaaaaaaaaaaaaa";
		  int id=0;
		  boolean siEsVeterinario=false;
		  try {
			  
				  id=calculoId(bd);
				  System.out.println("Dime el nombre:");
				  nombre=pregunta.next();
				  System.out.println("Dime el Apellido:");
				  apellido1=pregunta.next();
				  apellidos2=pregunta.next();
				  apellidos=apellido1+" "+apellidos2;
				  siEsVeterinario=MetodoSiono("¿El veterinario?[Si o No]:",SioNo);
				  //Controlamos si el usuario le dio a si o no 
				  if(siEsVeterinario)
				  {
					  System.out.println("Dime el numero de colegiado:");
					  String numeroColegiado =pregunta.next(); 
					  bd.add(new Veterinarios(id,nombre,apellidos,siEsVeterinario,numeroColegiado));
				  }else 
				  {
					  System.out.println("Dime el numero de perros:");
					 int numeroMascotas =pregunta.nextInt();
					 bd.add(new Propietarios(id,nombre,apellidos,siEsVeterinario,numeroMascotas));
				  }
			  
			  
				  
				 
				 
		  }catch(InputMismatchException e) {
				 System.err.println("***ERROR***El valor introducido no es compatible");
			}
			catch(NullPointerException e) {
				System.err.println("***ERROR***No lo puedes dejar nulo");
			}
			catch(Exception e) {
				System.err.println("***ERROR***Se ha surgido otro error");

			 }
		  
		  AbrirFicheroEscrito(archivo, bd);

	}
	private int calculoId(List<Usuarios> listaAntigua) {
		//Calculamos ids
		int auxiliar = 0;
		for(int i = 0; i< listaAntigua.size(); i++) {
			int j = listaAntigua.get(i).getCodigoIdentificador();
			if(auxiliar<j) {
				auxiliar = j;
			}
		}
		return auxiliar + 1;
	}
	private boolean MetodoSiono(String txt,String SioNo) 
	{
		//Preguntar si o si no
		Scanner pregunta=new Scanner(System.in);
		boolean cerrarmenu=true;
		do {
			System.out.println(txt);
			  SioNo=pregunta.next().toLowerCase();
			  
			  switch(SioNo)
			  {
				  case "si":
					  return true;
				  case "no":
					  return false;
					default:
						System.err.println("***ERROR*** solo se puede si o no.");
						cerrarmenu=false;
			  }
			  
		}while(!cerrarmenu);
		return true;
		
	}
	@Override
	public void AbrirFicheroEscrito(File archivo, List<Usuarios> bd) {
		FileWriter fichero=null;
	       //Try para abrir el fichero escrito
        try
        {
        	fichero = new FileWriter(archivo,true);


        } catch (Exception e) {
        	System.err.println("***ERROR***No se pudo abrir el fichero.");
        } 
        EscribirFichero(fichero,bd);
	}

	

	@Override
	public void EscribirFichero(FileWriter fichero, List<Usuarios> bd) {
		List<Veterinarios> veteri= new ArrayList<>();
		List<Propietarios> propie= new ArrayList<>();
		//Try para escribir en fichero y si es de de Clase Propietarios se guarda de otra forma si el usuario es un Veterinario
		 try
	        {
			 
	        	PrintWriter pw= new PrintWriter(fichero,true);

	        	for(Usuarios usu:bd) 
				 {
	        		if (bd.indexOf(usu) == bd.size() - 1) {
	        	        
	        	    
	        		if(usu.getClass().getSimpleName().equals("Propietarios")) {
	        			propie.add((Propietarios)usu);
		        		for(Propietarios propi:propie)
		        		{
		        			pw.println(propi.getNombre()+";"+propi.getApellidos()+";"+propi.isEsVeterinario()+";-;"+propi.getNumeroMascotas()+";");
		        		}
	        		}
	        		if(usu.getClass().getSimpleName().equals("Veterinarios")) {
	        			veteri.add((Veterinarios)usu);
			        		for(Veterinarios vete:veteri)
			        		{
			        			pw.println(vete.getNombre()+";"+vete.getApellidos()+";"+vete.isEsVeterinario()+";"+vete.getNumeroColegiado()+";-;");
			        		}
		        		}
	        		
				 }
				 }
	                
	        	
	        } catch (Exception e) {
	        	System.err.println("***ERROR***No se pudo escribir en el fichero.");
	        } finally {
	        	CerrarFichero(fichero);
	        }
	}

	@Override
	public void CerrarFichero(FileWriter fichero) {
		try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	        	   System.err.println("***ERROR***No se pudo cerrar el fichero.");
	           }

	}

	@Override
	public void AbrirFicheroLeer(File archivo) {
		 FileReader fr = null;
		 //Try Abrir fichero leido
			try {
				fr = new FileReader (archivo);
				LeerFichero(fr);
				}catch(Exception e){
					System.err.println("***ERROR***No se pudo abrir el fichero.");
		      }

	}

	@Override
	public void LeerFichero(FileReader fr) {
		 BufferedReader br = null;
		 //Try leer fichero
			try {
				 br = new BufferedReader(fr);
				 //Saltar la primera linea
				 String primeraLinea=br.readLine();
				 String linea;
		         while((linea=br.readLine())!=null)
		         {	//Creo un vCampos y lo divido en ; para luego si el campo de colegiado es - te lo pone como propietario y si no como veterianrio
		        	 String [] vCampos;
			 		vCampos=linea.split(";");
			 		if(vCampos[3].equals("-"))
			 		 {	
			 			
			 			System.out.println(vCampos[0]+" "+vCampos[1]+" es propietario y tiene "+vCampos[4]+" mascotas registradas.");
			 		 }else {
			 			
			 			
			 			System.out.println(vCampos[0]+" "+vCampos[1]+" es veterinario y su número de colegiado es "+vCampos[3]+".");
			 		 }
			 		
					
		         }    
			}catch(ArrayIndexOutOfBoundsException e)
			{
				System.err.println("***ERROR***El numero de lista no coincide.");
			}
			catch(Exception e){
				System.err.println("***ERROR***Se ha producido un error.");
		      }finally {
		    	  CerrarFicheroLeido(fr);
		        }

	}

	@Override
	public void CerrarFicheroLeido(FileReader fr) {
		//Try para cerrar el fichero leido
		try {
			 if (null != fr)
				 fr.close();
	          } catch (Exception e2) {
	             e2.printStackTrace();
	          }

	}

}
