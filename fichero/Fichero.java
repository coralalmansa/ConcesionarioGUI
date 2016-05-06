package fichero;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import concesionario.Concesionario;
import concesionario.NoColorException;
import concesionario.NoPlateException;

public class Fichero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static File fichero;  

	
	public Fichero(File file){
		super();
		
		fichero = file;
	}
	
	
	public static void guardarFichero(File file,Concesionario concesionario){
		
		try {
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(file));
			salida.writeObject(concesionario);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void guardarFicheroExistente(File file, Concesionario concesionario){
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(file));
			salida.writeObject(concesionario);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Concesionario leerFichero(File file) throws NoColorException, NoPlateException{
		Concesionario tmp = new Concesionario();

		
		try {
			ObjectInputStream salida = new ObjectInputStream(new FileInputStream(file));
			try {
				
				tmp = (Concesionario) salida.readObject();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
}
