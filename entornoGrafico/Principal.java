package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import concesionario.Concesionario;
import concesionario.NoColorException;
import concesionario.NoPlateException;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;

import fichero.Fichero;


public class Principal {

	private JFrame frmsinTtulo;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnCoche;
	private JMenu mnBuscar;
	private JMenu mnAyuda;
	private Concesionario concesionario = new Concesionario();
	private Alta alta;
	private Baja baja;
	private Mostrar mostrar;
	private ElegirColor elegirColor;
	private BuscarPorMatricula buscarPorMatricula;
	private AcercaDe acercaDe;
	private Ayuda ayuda;
	
	final JFileChooser guardar;
	Fichero fichero;
	private JPanel contentPane;
	File file;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmsinTtulo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		JFileChooser abrir = new JFileChooser();
		guardar = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Concesionario(*.obj)", "obj");
		abrir.setFileFilter(filtro);
		guardar.setFileFilter(filtro);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmsinTtulo = new JFrame();
		frmsinTtulo.setResizable(false);
		frmsinTtulo.setTitle("\"Sin t\u00EDtulo\" - Concesionario ");
		frmsinTtulo.setBounds(100, 100, 450, 300);
		frmsinTtulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frmsinTtulo.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTituloSinGuardar();
				concesionario.vaciarListado();
				
				
			}
		});
		mntmNuevoConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevoConcesionario);
		
		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir");
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			private JFileChooser abrir;

			public void actionPerformed(ActionEvent e) {
				int opcion = 0;
				abrir = null;
				opcion = abrir.showOpenDialog(contentPane);
				if(opcion == abrir.APPROVE_OPTION){
					try {
					    file = abrir.getSelectedFile();
						concesionario = Fichero.leerFichero(abrir.getSelectedFile());
						JOptionPane.showMessageDialog(contentPane, "Concesionario abierto con éxito.");
						//setTitle("Concesionario - "+file.getName());
					} catch (NoColorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoPlateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		mnArchivo.add(mntmAbrirConcesionario);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarConcesionario(guardar);
			}
		});
		
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo(guardar);
			}
		});
		mnArchivo.add(mntmGuardarComo);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		mnArchivo.add(mntmSalir);
		
		mnCoche = new JMenu("Coche");
		mnCoche.setMnemonic('C');
		menuBar.add(mnCoche);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta();
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCoche.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnCoche.add(mntmBaja);
		
		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar concesionario");
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		
		JSeparator separator = new JSeparator();
		mnCoche.add(separator);
		mnCoche.add(mntmMostrarConcesionario);
		
		mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('B');
		menuBar.add(mnBuscar);
		
		JMenuItem mntmCochePorMatricula = new JMenuItem("Por matr\u00EDcula");
		mntmCochePorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorMatricula();
			}
		});
		mnBuscar.add(mntmCochePorMatricula);
		
		JMenuItem mntmCochePorColor = new JMenuItem("Por color");
		mntmCochePorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorColor();
			}
		});
		mnBuscar.add(mntmCochePorColor);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmSobreConcesionario = new JMenuItem("Acerca De");
		mntmSobreConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmSobreConcesionario);
		
		frmsinTtulo.getContentPane().setLayout(null);
	}

	private void alta() {
		alta = new Alta(concesionario);
		alta.setVisible(true);
	}
	
	private void baja() {
		baja = new Baja(concesionario);
		baja.setVisible(true);
	}
	
	
	private void mostrar() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frmsinTtulo.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrar = new Mostrar(concesionario);
		mostrar.setVisible(true);
	}

	private void buscarPorColor() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frmsinTtulo.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		elegirColor = new ElegirColor(concesionario);
		elegirColor.setVisible(true);
	}
	
	private void mostrarPorMatricula() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frmsinTtulo.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		buscarPorMatricula = new BuscarPorMatricula(concesionario);
		buscarPorMatricula.setVisible(true);
	}
	
	
	
	
	private void guardarComo(final JFileChooser guardar){
		int opc = 0;
		opc = guardar.showSaveDialog(contentPane);
		if(opc == guardar.APPROVE_OPTION){
			file = guardar.getSelectedFile();
			fichero = new Fichero(file);
		}
		try {
			Fichero.guardarFichero(file, concesionario);
			concesionario.setNuevo(false);
			if(!concesionario.getNuevo())
			{
				JOptionPane.showMessageDialog(contentPane, "Guardado.");
				//setTitle("Concesionario - "+file.getName());
			}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	private void setTituloSinGuardar() {
		setTitle("Concesionario - Sin Guardar");
	}
	
	

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	private void guardarConcesionario(final JFileChooser guardar) {
		if(concesionario.getNuevo())
			guardarComo(guardar);
		else
			{
			Fichero.guardarFicheroExistente(file, concesionario);
			}
	}
	
	
	
	private void estaFicheroModificado() throws NoPlateException{
		
		try {
			if(concesionario.equals(Fichero.leerFichero(file)))
				;
			else {
				int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Guardar antes de salir?","Concesionario sin guardar", JOptionPane.YES_NO_OPTION);
				if(opcion == 0){
					Fichero.guardarFicheroExistente(file, concesionario);
				}
				
			}
		} catch (NoColorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
