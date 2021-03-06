package uiEscritorio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import negocio.ControladorPersonaje;
import entidades.Personaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Crear Personaje");
		inicializar();
		this.ctrlPersonaje = new ControladorPersonaje();
	}
	
	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) { 
		manejador(e.getSource()); 
	}
	
	private void manejador(Object accion) 
	{
		lblMensaje.setText("");
		
		if(accion == btnCrear) {
			if(ctrlPersonaje.crear(txtNombre.getText())) {
				abrirCargarPuntos();
			}else {
				lblMensaje.setText("Ya existe un personaje con ese nombre");
			}
		}
		else if (accion == btnCancelar) {
			abrirPersonaje();
		}
    }

	private void cerrarVentana() {
		setVisible(false);
	    dispose();
	}

	private void abrirPersonaje() {
		frmPersonaje frmPersonaje = new frmPersonaje();
		frmPersonaje.setLocationRelativeTo(null);
		frmPersonaje.setVisible(true);

	    cerrarVentana();
	}

	private void abrirCargarPuntos() {
		frmCargarPuntos frmCargarPuntos = new frmCargarPuntos(ctrlPersonaje.traerActual());
		frmCargarPuntos.setLocationRelativeTo(null);
		frmCargarPuntos.setVisible(true);

	    cerrarVentana();
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
