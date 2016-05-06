package entornoGrafico;
/**
 * @author Coral Almansa
 * @version 1.0
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setBounds(100, 100, 433, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextArea txtrAplicacinConLa = new JTextArea();
		txtrAplicacinConLa.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtrAplicacinConLa.setText("- Aplicaci\u00F3n con la que podr\u00E1 dar de alta coches; \r\nespecificando la matr\u00EDcula, el color, la marca y \r\nel modelo.\r\n\r\n- El formato de la matr\u00EDcula es: un grupo de cuatro \r\nn\u00FAmeros (excluido el 0000) y otro de tres letras \r\nmay\u00FAsculas (excluidas las vocales, la LL, la \u00D1 y la Q).\r\n\r\n- Tambi\u00E9n se podr\u00E1 dar de baja a los coches\r\nintroduciendo la matr\u00EDcula.\r\n\r\n- Tanto para que se pueda dar de alta como de baja \r\nun coche, la matr\u00EDcula debe ser correcta.\r\n\r\n- Esta aplicaci\u00F3n tambi\u00E9n permite hacer una b\u00FAsqueda \r\nde los coches dados de alta por color o por la matr\u00EDcula.");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrAplicacinConLa, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrAplicacinConLa, GroupLayout.PREFERRED_SIZE, 263, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton salirButton = new JButton("Salir");
				salirButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);		
					}
				});
				salirButton.setActionCommand("Cancel");
				buttonPane.add(salirButton);
			}
		}
	}
}
