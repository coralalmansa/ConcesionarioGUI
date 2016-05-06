package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionario.Coche;
import concesionario.Concesionario;
import concesionario.NoPlateException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarPorMatricula extends VentanaPadre {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Create the dialog.
	 */
	public BuscarPorMatricula(final Concesionario concesionario) {
		
		setBounds(100, 100, 450, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		lblmatriculaNoValida.setVisible(false);

		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche = null;
				try {
					coche = concesionario.get(textMatricula.getText());
				} catch (NoPlateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (coche != null){
					mostrarCocheMatricula (coche);
					
				}else{
					JOptionPane.showMessageDialog(contentPanel,
							"No existe ningún coche con esa matricula.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
	}
	
	private void mostrarCocheMatricula(Coche coche) {
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
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
	}
	
}