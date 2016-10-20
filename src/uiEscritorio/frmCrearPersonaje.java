package uiEscritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import negocio.ControladorPersonaje;
import entidades.Personaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class frmCrearPersonaje extends JFrame implements ActionListener{

	private Personaje personaje;
	private ControladorPersonaje ctrlPersonaje;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	
	private JButton btnCrear;
	private JButton btnCancelar;
	private JLabel lblMensaje;

	/**
	 * Create the frame.
	 */
	public frmCrearPersonaje() {
		initialize();
		this.ctrlPersonaje = new ControladorPersonaje();
	}
	
	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) { 
		actionHandler(e.getSource()); 
	}
	
	private void actionHandler(Object source) 
	{
		if(source == btnCrear) {
			create();
			frmCargarPuntos frmCPts = new frmCargarPuntos(ctrlPersonaje.getActual());
			frmCPts.setLocationRelativeTo(null);
			frmCPts.setVisible(true);
		}
		else if (source == btnCancelar) {
			frmPersonaje frmP = new frmPersonaje();
			frmP.setLocationRelativeTo(null);
		    frmP.setVisible(true);
		}
		
	    setVisible(false);
	    dispose();
    }
	
	private void create() 
	{
		// TODO validar que ese nombre de personaje no exista
		String nombre = txtNombre.getText();
		ctrlPersonaje.add(nombre);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");

		btnCancelar.addActionListener(this);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(232)
							.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(138))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(lblNombre)
					.addGap(195))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNombre)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(lblMensaje)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnCrear))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
