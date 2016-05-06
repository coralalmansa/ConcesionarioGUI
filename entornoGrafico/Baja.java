package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;

import concesionario.Coche;
import concesionario.Concesionario;
import concesionario.NoPlateException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Baja extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the dialog.
	 */
	public Baja(final Concesionario concesionario) {
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche = null;
				try {
					coche = concesionario.get(textMatricula.getText());
				} catch (NoPlateException e1) {
					e1.printStackTrace();
				}
				if(coche != null){
					mostrarCoche(coche);
					int c = JOptionPane.showOptionDialog(contentPanel,
							"¿Está seguro de que desea eliminarlo?", "Confirmar",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					switch (c) {
					case JOptionPane.YES_OPTION:
						concesionario.eliminar(textMatricula.getText());
						clear();
						break;
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha podido eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
		
			}
		});
		

		setTitle("Baja");
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		annadir.setVisible(false);
		lblmatriculaNoValida.setVisible(false);
		
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		setBounds(100, 100, 450, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 311, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	private void clear() {
		textMatricula.setText("");
		buttonGroup.clearSelection();
		comboBoxMarca.setSelectedItem(null);
		comboBoxModelo.setSelectedItem(null);	
	}

	private void mostrarCoche(Coche coche) {
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
}
