package concesionario;

/**
 * @author Coral Almansa
 * @version 1.0
 */
public enum Modelo {

	SERIE1(Marca.BMW),
	SERIE2(Marca.BMW),
	SERIE3(Marca.BMW),
	SERIE5(Marca.BMW),
	CORDOBA(Marca.SEAT),
	IBIZA(Marca.SEAT),
	TOLEDO(Marca.SEAT);
	
	private Marca marca;

	/**
	 * Construye un nuevo modelo de marca especificada
	 * 
	 * @param marca
	 *            Representa la marca del nuevo modelo
	 */
	private Modelo(Marca marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve la marca del modelo
	 * 
	 * @return Marca del modelo
	 */
	public Marca getMarca() {
		return marca;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name();

	}
	
	/**
	 * Array de modelos
	 */
	private static final Modelo[] VALUES = Modelo.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del menú
	 * 
	 * @return Array de cadenas con las opciones del menú
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de modelos
	 * 
	 * @return Array de modelos
	 */
	public static Modelo[] getValues() {
		return VALUES;
	}
}