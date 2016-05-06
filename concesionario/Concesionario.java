/**
 * 
 */
package concesionario;

import java.util.ArrayList;

/**
 * @author Coral Almansa
 * @version 1.0
 */
public class Concesionario {
	
	/**
	 * Colecci�n de coches. No puede tener null.
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	

	private boolean nuevo = true;
	
	
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capit�n";

	/**
	 * A�ade un coche al almacen
	 * 
	 * @param matricula
	 *            Representa la matr�cula del coche a a�adir
	 * @param color
	 *            Representa el color del coche a a�adir
	 * @param modelo
	 *            Representa el modelo del coche a a�adir
	 * @return true si el coche se a�ade, false en otro caso (el coche es null o
	 *         el coche ya est� contenido en el almacen)
	 */
	public boolean annadir(String matricula, Colores color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almacen
	 * 
	 * @param matricula
	 *            Representa la matr�cula del coche a eliminar
	 * @return true si el coche se elimina, false en otro caso (el coche no est�
	 *         en el almacen)
	 */
	public boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
	}

	/**
	 * Devuelve el n�mero de coches del almacen
	 * 
	 * @return N�mero de coches del almacen
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche indicado por la matr�cula
	 * 
	 * @param matricula
	 *            Representa la matr�cula a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 */
	public Coche get(String matricula) throws NoPlateException{
		int i = 0;
		
		for (Coche coche : almacen) {
			i++;
			if(coche.getMatricula().equals(matricula))
				return coche;
			if(i == almacen.size() - 1)
				throw new NoPlateException("No hay coches con es matricula");
		}

		return null;
	}
	
	public Coche get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return almacen.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	/**
	 * Genera una lista de coches de un determinado color
	 * 
	 * @param color
	 *            Representa el color a buscar
	 * @return Lista de coches de un determinado color
	 */
	public ArrayList<Coche> getCochesColor(Colores color) throws NoColorException{
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
			else throw new NoColorException("No hay coches de ese color");
		}
		return arrCochesColor;
	}
	
	
	/**
	 * M�todo que nos vac�a el arraylist
	 */
	public void vaciarListado(){
		almacen.clear();
	}

	/**
	 * M�todo para obtener el estado nuevo(si est� guardado o no el concesionario)
	 * @return
	 */
	public boolean getNuevo() {
		return nuevo;
	}

	/**
	 * M�todo para establecer el estado nuevo
	 * @param nuevo true si es nuevo, false si ya ha sido guardado
	 */
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	
	

}
