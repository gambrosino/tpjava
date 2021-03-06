package uiEscritorio;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import negocio.ControladorPersonaje;
import entidades.Personaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class frmBuscarPersonaje extends JFrame implements ActionListener{

	private ControladorPersonaje ctrlPersonaje;
	
	private JPanel contentPane;
	private JComboBox cmbPersonaje;
	
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnBorrar;
	
	/**
	 * Create the frame.
	 */
	public frmBuscarPersonaje() {
		setTitle("Modificar o Borrar Personaje");
		inicializar();
		this.ctrlPersonaje = new ControladorPersonaje();
		cargarComboBox();
	}
	
	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) {
		manejador(e.getSource());
	}
	
	private void manejador(Object accion) {
		if(accion == btnModificar) {
			abrirCargarPuntos();
		} 
		else if(accion == btnBorrar) {		
			eliminarPersonaje((Personaje)(cmbPersonaje.getSelectedItem()));
		} 
		else if(accion == btnCancelar) {
			abrirPersonaje();
		}
	}
	
	private void abrirCargarPuntos() {
		frmCargarPuntos frmCargarPuntos = new frmCargarPuntos((Personaje)(cmbPersonaje.getSelectedItem()));
		frmCargarPuntos.setLocationRelativeTo(null);
		frmCargarPuntos.setVisible(true);
		
	    cerrarVentana();
	}
	
	private void abrirPersonaje() {
		frmPersonaje frmPersonaje = new frmPersonaje();
		frmPersonaje.setLocationRelativeTo(null);
		frmPersonaje.setVisible(true);

	    cerrarVentana();
	}
	
	private void cerrarVentana() {
		setVisible(false);
	    dispose();
	}
	
	private void cargarComboBox() {
		ArrayList<Personaje> personajes = this.ctrlPersonaje.traerTodos();
		
		cmbPersonaje.removeAllItems();
		
		for (Personaje personaje : personajes) {
			cmbPersonaje.addItem(personaje);
		}
	}
	
	private void eliminarPersonaje(Personaje personaje)
	{
		if (confirmarEliminacion()) {
			ctrlPersonaje.eliminar(personaje);
			cargarComboBox();
		}
	}
	
	private boolean confirmarEliminacion() {
		
		int dialogButton = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminar el personaje?","WARNING", JOptionPane.YES_NO_OPTION);
		
		if (dialogButton == 0)
			return true;
		
		return false;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void inicializar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		cmbPersonaje = new JComboBox();
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(56, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(150))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cmbPersonaje, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbPersonaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))))
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
