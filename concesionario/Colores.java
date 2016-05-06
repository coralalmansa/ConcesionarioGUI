/**
 * 
 */
package concesionario;

/**
 * @author Coral Almansa
 * @version 1.0
 */
public enum Colores {
	
	PLATA, ROJO, AZUL;

	/**
	 * Array de colores
	 */
	private static final Colores[] VALUES = Colores.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del menú
	 * 
	 * @return Array de cadenas con las opciones del menú
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Colores color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de colores
	 * 
	 * @return Array de colores
	 */
	public static Colores[] getValues() {
		return VALUES;
	}

}