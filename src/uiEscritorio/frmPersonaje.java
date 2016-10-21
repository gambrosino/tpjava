package uiEscritorio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPersonaje extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JButton btnCrearPersonaje;
	private JButton btnModificarBorrar;
	private JButton btnAtras;

	/**
	 * Create the frame.
	 */
	public frmPersonaje() {
		setTitle("Menu Personajes");
		inicializar();
	}
	
	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) { 
		manejador(e.getSource()); 
	}
	
	private void manejador(Object accion) 
	{
		if(accion == btnCrearPersonaje) {
			abrirCrearPersonaje();
		}
		else if(accion == btnModificarBorrar) { 
			abrirBuscarPersonaje();
		}
		else if(accion == btnAtras) { 
			abrirMenuPrincipal();
		}
		
		cerrarVentana();
	}

	private void abrirMenuPrincipal() {
		frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
		frmMenuPrincipal.setLocationRelativeTo(null);
		frmMenuPrincipal.setVisible(true);
	}

	private void abrirBuscarPersonaje() {
		frmBuscarPersonaje frmBuscarPersonaje = new frmBuscarPersonaje();
		frmBuscarPersonaje.setLocationRelativeTo(null);
		frmBuscarPersonaje.setVisible(true);
	}
	
	private void abrirCrearPersonaje() {
		frmCrearPersonaje frmCrearPersonaje = new frmCrearPersonaje();
		frmCrearPersonaje.setLocationRelativeTo(null);
		frmCrearPersonaje.setVisible(true);
	}
	
	private void cerrarVentana(){
		setVisible(false);
		dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void inicializar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCrearPersonaje = new JButton("Crear Personaje");
		btnCrearPersonaje.addActionListener(this);
		
		btnModificarBorrar = new JButton("Modificar o Borrar Personaje");
		btnModificarBorrar.addActionListener(this);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAtras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCrearPersonaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModificarBorrar, Alignment.LEADING))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(btnCrearPersonaje)
					.addGap(18)
					.addComponent(btnModificarBorrar)
					.addGap(67)
					.addComponent(btnAtras)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
