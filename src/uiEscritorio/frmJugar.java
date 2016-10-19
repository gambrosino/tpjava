package uiEscritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidades.Personaje;
import negocio.ControladorPersonaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmJugar extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ControladorPersonaje ctrlPersonaje;

	private JComboBox cmbJugador1;
	private JComboBox cmbJugador2;
	
	private JButton btnJugar;
	private JButton btnAtras;
	
	private JLabel lblMensaje;
	
	/**
	 * Create the frame.
	 */
	public frmJugar() {
		initialize();
		this.ctrlPersonaje = new ControladorPersonaje();
		this.fillComboBox();
	}
	
	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) {
		actionHandler(e.getSource());
	}
	
	private void actionHandler(Object source) {
		if(source == btnAtras){
			volverMenuPrincipal();
		}else if(source == btnJugar){
			if(this.validarSeleccionPersonaje()) {
				comenzarPartida();
			}
		}
	}
	
	private void comenzarPartida() {
		frmPartida frmPartida = new frmPartida((Personaje)(cmbJugador1.getSelectedItem()),
				   								(Personaje)(cmbJugador2.getSelectedItem()));
		frmPartida.setLocationRelativeTo(null);
		frmPartida.setVisible(true);
		cerrarFormulario();
	}
	
	private void volverMenuPrincipal() {
		frmMenuPrincipal frmMP = new frmMenuPrincipal();
		frmMP.setLocationRelativeTo(null);
		frmMP.setVisible(true);
		cerrarFormulario();
	}
	
	private void cerrarFormulario() {
		setVisible(false);
		dispose();
	}
	
	private boolean validarSeleccionPersonaje() {
		int idJugador1 = ((Personaje)(cmbJugador1.getSelectedItem())).getId();
		int idJugador2 = ((Personaje)(cmbJugador2.getSelectedItem())).getId();
			
		if (idJugador1 == idJugador2){
			lblMensaje.setText("Debe seleccionar jugadores distintos");
			return false;
		}
		
		return true;
	}

	private void fillComboBox() {
	    ArrayList<Personaje> personajes = this.ctrlPersonaje.getAll();
	    for(Personaje personaje : personajes ){
	    	cmbJugador1.addItem(personaje);
	    	cmbJugador2.addItem(personaje);
	    }
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblJugador1 = new JLabel("JUGADOR 1");
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblVs = new JLabel("vs.");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblJugador2 = new JLabel("JUGADOR 2");
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);

		cmbJugador1 = new JComboBox();
		cmbJugador2 = new JComboBox();

		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(this);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		
		lblMensaje = new JLabel("");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
							.addComponent(btnJugar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblJugador1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMensaje, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbJugador1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblVs, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(lblJugador2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addComponent(cmbJugador2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador2)
						.addComponent(lblJugador1)
						.addComponent(lblVs))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras)
						.addComponent(btnJugar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
