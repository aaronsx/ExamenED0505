package aplicaciones.controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import aplicacion.entidades.Usuarios;
import aplicaciones.servicios.ImpUtilsMenu;
import aplicaciones.servicios.ImpVeterinarios;
import aplicaciones.servicios.IntUtilsMenu;
import aplicaciones.servicios.IntVeterinarios;

public class Main {

	public static void main(String[] args) {
		IntUtilsMenu menu=new ImpUtilsMenu();
		IntVeterinarios vete=new ImpVeterinarios();
		List<Usuarios> bd=new ArrayList<>();
		
		Boolean cerrarMenu = false; 
		File archivo = new File ("C:\\Users\\csi22-amunada\\git\\Usuarios.txt");
		 PreparacionDeFichero(archivo); 
		 int opcion=0;
		int coches=0;	
		
		
				while(!cerrarMenu) 
				{	
					try {
						 Scanner preguntar=new Scanner(System.in);
						//Mostramos el menú
						menu.Menu();
						System.out.println("Introduza la opción deseada: ");
						opcion = preguntar.nextInt();
						if(opcion>=0 && opcion<=2)
						{
							System.out.println("[INFO] - Has seleccionado la opcion " + opcion);
						}
						switch (opcion) 
						{			
							case 1:
								vete.InsertarUsuario(opcion, bd, archivo);
								
								break;
							
							case 2:
								vete.AbrirFicheroLeer(archivo);
								
								break;
							
							
							case 0:
								JOptionPane.showMessageDialog(null,"¡Gracias por visitar nuestra Veterinaria!");
								cerrarMenu = true;
								break;
							default:
								System.err.println("Solo se puede del 0 al 2");
						}
				}catch(InputMismatchException e) {
					System.err.println("***ERROR***No has introducido un entero");
				}
				catch(NullPointerException e) {
					System.err.println("***ERROR***No lo puedes dejar nuelo");
				}
				catch(Exception e) {
					System.err.println("***ERROR***Se ha surgido otro error");

				 }
					
				}
				
	}
	//Prear el fichero
			private static void PreparacionDeFichero(File archivo) 
			{
				
				
			      FileReader fr = null;
			      BufferedReader br = null;
				   try {
				        
				        //Si el fichero no exite lo crea y lo escribe si el fichero existe mira que si esta vacio y mete un encabezado 
				         if(!archivo.exists())
				         {
				        	 
				        	 if(archivo.createNewFile())
				        	 EscirbirEncabezado(archivo);
				         }else {
				        	 fr = new FileReader (archivo);
					         br = new BufferedReader(fr);
				        	 String linea;
				        	 int contador=0;
					         while((linea=br.readLine())!=null)
					            contador++;
					         
					         if(contador==0||contador==1)
					        	 EscirbirEncabezado(archivo);
					        	 
				         }
				         // Lectura del fichero
				        
				      }
				      catch(IOException e){
				       e.printStackTrace();
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion.
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				            e2.printStackTrace();
				         }
				      }
			}
			//Escribir el encabezado del fichero
			private static void EscirbirEncabezado(File archivo) {
				 FileWriter fichero = null;
			        PrintWriter pw = null;
			        try
			        {
			            fichero = new FileWriter(archivo);
			            
			            pw = new PrintWriter(fichero);

			                pw.println("nombre;apellidos;esVeterinario;numeroColegiado;numeroMascotas;");

			        }catch (IOException e) 
			        {
			        	System.err.println("***ERROR***No se pudo aceder el fichero.");
			        } 
			        catch (Exception e) {
			        	System.err.println("***ERROR***Se ha producido un error.");
			        } finally {
			           try {
			           if (null != fichero)
			              fichero.close();
			           } catch (Exception e2) {
			              e2.printStackTrace();
			           }
			        }
			}
}
