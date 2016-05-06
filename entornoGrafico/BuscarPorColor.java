package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import java.util.ArrayList;

import concesionario.Coche;
import concesionario.Concesionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarPorColor extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Concesionario concesionario;
	private int indice = -1;

	/**
	 * Create the dialog.
	 */
	public BuscarPorColor(ArrayList<Coche> cochesPorColor) {
		super();
		
		setTitle("Mostrar por color");

		concesionario = crearConcesionario(cochesPorColor);
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buscar.setVisible(false);
		textMatricula.setEnabled(false);
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		lblmatriculaNoValida.setVisible(false);

		
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
	}
	
	void actualizar() {
		if (concesionario.size() == 0) {
			return;
		}
		indice = 0;
		mostrarCoche(concesionario.get(indice));
		manejarBotones();
	}
	
	private void mostrarSiguiente() {
		mostrarCoche(concesionario.get(++indice));
		manejarBotones();
	}

	private void mostrarAnterior() {
		mostrarCoche(concesionario.get(--indice));
		manejarBotones();				
	}

	private void mostrarCoche(Coche coche) {
		textMatricula.setText(coche.getMatricula());
		switch (coche.getColor()) {
		case PLATA:
			radioButtonPlata.setSelected(true);
			break;
		case ROJO:
			radioButtonRojo.setSelected(true);
			break;
		case AZUL:
			radioButtonAzul.setSelected(true);
		}
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());				
	}

	private void manejarBotones() {
		if (concesionario.get(indice + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);

		if (concesionario.get(indice - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);				
	}

	private Concesionario crearConcesionario(ArrayList<Coche> concesionario) {
		Concesionario porColor = new Concesionario();
		for (Coche coche : concesionario) {
			porColor.annadir(coche.getMatricula(),coche.getColor(), coche.getModelo());	
		}	
		return porColor;
	}
}
