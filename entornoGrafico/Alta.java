package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import concesionario.Coche;
import concesionario.Colores;
import concesionario.Concesionario;
import concesionario.Marca;
import concesionario.Modelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.Color;


public class Alta extends VentanaPadre {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Alta(final Concesionario concesionario) {
		super();
		
		setTitle("Alta");
		
		eliminar.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		lblmatriculaNoValida.setVisible(false);

		
		
		FocusListener focus = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				textMatricula.setForeground(Color.BLACK);
				lblmatriculaNoValida.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!Coche.esValida(textMatricula.getText())) {
					textMatricula.setForeground(Color.RED);
					lblmatriculaNoValida.setVisible(true);
				}
				else
					{
					textMatricula.setForeground(Color.BLACK);
					lblmatriculaNoValida.setVisible(false);
					
					}	
								
			}
		
		};
		textMatricula.addFocusListener(focus);
		
	
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		
		
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.annadir(textMatricula.getText(), getColor(),
						(Modelo) comboBoxModelo.getSelectedItem()))
					JOptionPane.showMessageDialog(contentPanel,
							"Coche añadido con éxito.");
				else
					JOptionPane.showMessageDialog(contentPanel,
							"El coche no se ha podido añadir.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
			
	private Colores getColor() {
		if(radioButtonPlata.isSelected()) return Colores.PLATA;
		if(radioButtonAzul.isSelected()) return Colores.AZUL;
		if(radioButtonRojo.isSelected()) return Colores.ROJO;
		return null;
	}
		
}
