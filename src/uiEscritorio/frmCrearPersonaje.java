package uiEscritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Personaje;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import negocio.ControladorPersonaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import negocio.ControladorPersonaje;

public class frmCrearPersonaje extends JFrame implements ActionListener{

	private Personaje personaje;
	private ControladorPersonaje ctrlPersonaje;
	
	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Create the frame.
	 */
	public frmCrearPersonaje() {
		initialize();
		ctrlPersonaje = new ControladorPersonaje();
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
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(232)
							.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(136))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addComponent(lblNombre)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNombre)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(227, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnCrear))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent e) { 
		actionHandler(e.getActionCommand()); 
	}
	
	private void cleanFields() 
	{
		txtNombre.setText("");
	}
	
	private void create() 
	{
		String nombre = txtNombre.getText();
		ctrlPersonaje.add(nombre);
	}
	
	private void actionHandler(String action) 
	{
		if(action == "Crear") {
			create();
			frmCargarPuntos frmCPts = new frmCargarPuntos(ctrlPersonaje.getActual());
			frmCPts.setLocationRelativeTo(null);
			frmCPts.setVisible(true);
		}
		else if (action == "Cancelar") {
			frmPersonaje frmP = new frmPersonaje();
			frmP.setLocationRelativeTo(null);
		    frmP.setVisible(true);
		}
		
		cleanFields();
	    setVisible(false);
	    dispose();
    }
}
