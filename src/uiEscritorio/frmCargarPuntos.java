package uiEscritorio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import entidades.Personaje;
import negocio.ControladorPersonaje;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class frmCargarPuntos extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JTextField txtNombre;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtPuntosDisponibles;
	private JTextField txtPuntosTotales;
	
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	private JButton btnVidaU;
	private JButton btnVidaD;
	private JButton btnEnergiaU;
	private JButton btnEnergiaD;
	private JButton btnDefensaU;
	private JButton btnDefensaD;
	private JButton btnEvasionU;
	private JButton btnEvasionD;
	
	private Personaje personaje;
	private ControladorPersonaje ctrlPersonaje;

	/**
	 * Create the frame.
	 */
	public frmCargarPuntos(Personaje personaje) {
		setTitle("Cargar Puntos");
		inicializar();
		this.ctrlPersonaje = new ControladorPersonaje();
		this.personaje = personaje;
		llenarCampos();
	}
	
	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) { 
		manejador(e.getSource());
	}
	
	private void manejador(Object accion) 
	{
		if (accion == btnGuardar) guardar();
		else if(accion == btnVidaU) incrementar(txtVida);
		else if(accion == btnVidaD) decrementar(txtVida);
		else if(accion == btnEnergiaU) incrementar(txtEnergia);
		else if(accion == btnEnergiaD) decrementar(txtEnergia);
		else if(accion == btnDefensaU) {incrementar(txtDefensa); validarDefensa();}
		else if(accion == btnDefensaD) decrementar(txtDefensa);
		else if(accion == btnEvasionU) incrementar(txtEvasion);
		else if(accion == btnEvasionD) decrementar(txtEvasion);
		
		if (accion == btnGuardar || accion == btnCancelar) {
			abrirPersonaje();
		}
    }
	
	private void validarDefensa(){
		if(Integer.parseInt(txtDefensa.getText())> 20){
			btnDefensaU.setEnabled(false);
		}	
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
	
	private void guardar() {
		Hashtable<String, String> atributos = getAtributos();
		
		ctrlPersonaje.actualizar(personaje, atributos);
	}

	private Hashtable<String, String> getAtributos() {
		Hashtable<String, String> atributos = new Hashtable<String, String>();
		atributos.put("vida", txtVida.getText());
		atributos.put("energia", txtEnergia.getText());
		atributos.put("defensa", txtDefensa.getText());
		atributos.put("evasion", txtEvasion.getText());
		atributos.put("puntosDisponibles", txtPuntosDisponibles.getText());
		
		return atributos;
	}
	
	public void llenarCampos() {
		txtNombre.setText(personaje.getNombre());
		txtPuntosTotales.setText(String.valueOf(personaje.getPuntosTotales()));
		txtPuntosDisponibles.setText(String.valueOf(personaje.getPuntosDisponibles()));
		txtVida.setText(String.valueOf(personaje.getVida()));
		txtEnergia.setText(String.valueOf(personaje.getEnergia()));
		txtDefensa.setText(String.valueOf(personaje.getDefensa()));
		txtEvasion.setText(String.valueOf(personaje.getEvasion()));
	}
	
	private void incrementar(JTextField input) {
		int puntosDisponibles = Integer.parseInt(txtPuntosDisponibles.getText());
		if(puntosDisponibles > 0) {
			int valorAtributo = Integer.parseInt(input.getText());
			input.setText(String.valueOf(++valorAtributo));	
			txtPuntosDisponibles.setText(String.valueOf(--puntosDisponibles));
		}
	}
	
	private void decrementar(JTextField input) {
		int valorAtributo = Integer.parseInt(input.getText().toString());
		int puntosDisponibles = Integer.parseInt(txtPuntosDisponibles.getText());
		if(valorAtributo > 0 ) {
			input.setText(String.valueOf(--valorAtributo));
			txtPuntosDisponibles.setText(String.valueOf(++puntosDisponibles));
		}		
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
		
		JLabel lblNombre = new JLabel("NOMBRE");
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		
		JLabel lblRestantes = new JLabel("RESTANTES");
		txtPuntosDisponibles = new JTextField();
		txtPuntosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosDisponibles.setEditable(false);
		txtPuntosDisponibles.setColumns(10);
		
		JLabel lblVida = new JLabel("VIDA:");
		txtVida = new JTextField();
		txtVida.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida.setColumns(10);
		txtVida.setEditable(false);

		JLabel lblEnergia = new JLabel("ENERGIA:");
		txtEnergia = new JTextField();
		txtEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia.setColumns(10);
		txtEnergia.setEditable(false);
		
		JLabel lblDefensa = new JLabel("DEFENSA:");
		txtDefensa = new JTextField();
		txtDefensa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa.setColumns(10);
		txtDefensa.setEditable(false);
		
		JLabel lblEvasion = new JLabel("EVASION:");
		txtEvasion = new JTextField();
		txtEvasion.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion.setColumns(10);
		txtEvasion.setEditable(false);
		
		JLabel lblPuntosTotales = new JLabel("PUNTOS TOTALES");
		txtPuntosTotales = new JTextField();
		txtPuntosTotales.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosTotales.setEditable(false);
		txtPuntosTotales.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		btnVidaU = new JButton("+");
		btnVidaU.setMargin(new Insets(2, 2, 2, 2));
		btnVidaU.addActionListener(this);
		
		btnVidaD = new JButton("-");
		btnVidaD.setMargin(new Insets(2, 2, 2, 2));
		btnVidaD.addActionListener(this);
		
		btnEnergiaU = new JButton("+");
		btnEnergiaU.setMargin(new Insets(2, 2, 2, 2));
		btnEnergiaU.addActionListener(this);
		
		btnEnergiaD = new JButton("-");
		btnEnergiaD.setMargin(new Insets(2, 2, 2, 2));
		btnEnergiaD.addActionListener(this);
		
		btnDefensaU = new JButton("+");
		btnDefensaU.setMargin(new Insets(2, 2, 2, 2));
		btnDefensaU.addActionListener(this);
		
		btnDefensaD = new JButton("-");
		btnDefensaD.setMargin(new Insets(2, 2, 2, 2));
		btnDefensaD.addActionListener(this);
		
		btnEvasionU = new JButton("+");
		btnEvasionU.setMargin(new Insets(2, 2, 2, 2));
		btnEvasionU.addActionListener(this);
		
		btnEvasionD = new JButton("-");
		btnEvasionD.setMargin(new Insets(2, 2, 2, 2));
		btnEvasionD.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNombre)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtPuntosDisponibles, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
										.addComponent(lblRestantes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtPuntosTotales, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
									.addGap(17))
								.addComponent(lblPuntosTotales))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblEnergia)
												.addComponent(lblEvasion)
												.addComponent(lblDefensa))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(btnEvasionD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
													.addComponent(btnEnergiaD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnDefensaD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblVida)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnVidaD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnVidaU, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnEvasionU, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDefensaU, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnEnergiaU, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(94, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(19))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVidaU)
								.addComponent(btnVidaD)
								.addComponent(lblVida))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEnergiaU)
								.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEnergiaD)
								.addComponent(lblEnergia))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDefensaD, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDefensaU)
								.addComponent(lblDefensa))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEvasionD)
								.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion)
								.addComponent(btnEvasionU))
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnGuardar))
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPuntosTotales)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPuntosTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRestantes)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPuntosDisponibles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
