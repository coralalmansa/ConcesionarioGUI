package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import concesionario.Marca;
import concesionario.Modelo;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class VentanaPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textMatricula;
	protected JLabel lblMatricula;
	protected JLabel lblmatriculaNoValida;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	
	protected JRadioButton radioButtonPlata;
	protected JRadioButton radioButtonRojo;
	protected JRadioButton radioButtonAzul;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton annadir;
	protected JButton eliminar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton buscar;
	protected JButton salir;
	private JPanel panel;
	

	public VentanaPadre() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 447, 327);
		
		lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(53, 11, 76, 30);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(126, 16, 152, 20);
		textMatricula.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(53, 83, 49, 14);
		
		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBounds(90, 108, 92, 22);
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(90, 207, 92, 22);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(53, 183, 49, 14);
		
		
		annadir = new JButton("A\u00F1adir");
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		annadir.setBounds(222, 253, 86, 23);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(222, 253, 86, 23);
		
		buttonAnterior = new JButton("<<");
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAnterior.setBounds(217, 253, 56, 23);
		
		buttonSiguiente = new JButton(">>");
		buttonSiguiente.setBounds(283, 253, 56, 23);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(222, 253, 86, 23);
		
		salir = new JButton("Salir");
		salir.setBounds(348, 253, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblMatricula);
		getContentPane().add(annadir);
		getContentPane().add(eliminar);
		getContentPane().add(buttonAnterior);
		getContentPane().add(buttonSiguiente);
		getContentPane().add(buscar);
		getContentPane().add(salir);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(textMatricula);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Colores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(262, 83, 103, 125);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBounds(23, 58, 65, 23);
		panel.add(radioButtonPlata);
		buttonGroup.add(radioButtonPlata);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBounds(23, 32, 65, 23);
		panel.add(radioButtonRojo);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBounds(23, 84, 65, 23);
		panel.add(radioButtonAzul);
		buttonGroup.add(radioButtonAzul);
		
		lblmatriculaNoValida = new JLabel("\u00A1Matr\u00EDcula no v\u00E1lida!");
		lblmatriculaNoValida.setForeground(Color.RED);
		lblmatriculaNoValida.setBounds(296, 19, 117, 14);
		getContentPane().add(lblmatriculaNoValida);
		
	
	}
}
