package uiEscritorio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import negocio.ControladorPersonaje;
import entidades.Personaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPartida extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private JTextField txtVida1;
	private JTextField txtEnergia1;
	private JTextField txtDefensa1;
	private JTextField txtEvasion1;
	private JTextField txtVida2;
	private JTextField txtEnergia2;
	private JTextField txtDefensa2;
	private JTextField txtEvasion2;
	private JTextField txtAtaque1;
	private JTextField txtAtaque2;
	
	private JButton btnAtacar1;
	private JButton btnDefender1;
	private JButton btnAtacar2;
	private JButton btnDefender2;
	
	private ControladorPersonaje ctrlPersonaje;
	private Personaje jugador1;
	private Personaje jugador2;
	private JLabel lblAtaqueEvadido;
	private JLabel lblDefensaEfectuada;

	
	/**
	 * Create the frame.
	 */
	public frmPartida(Personaje jugador1, Personaje jugador2) {
		setTitle("Partida");
		inicializar();
		this.ctrlPersonaje = new ControladorPersonaje();
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.iniciarPartida();
	}

	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) {
		manejador(e.getSource());	
	}
	
	private void manejador(Object accion) {
		if(accion == btnAtacar1) {
			
		}
		else if(accion == btnDefender1) {
			
		}
		else if(accion == btnAtacar2) {
			
		}
		else if(accion == btnDefender2) {
			
		}
	}
	
	private void iniciarPartida() {
		// TODO
		// definir el turno
		// deshabilitar los botones segun sea el turno
		llenarCampos();	
	}
	
	private void llenarCampos(){
		txtJugador1.setText(jugador1.getNombre());
		txtJugador2.setText(jugador2.getNombre());
		
		txtVida1.setText(String.valueOf(jugador1.getVida()));
		txtEnergia1.setText(String.valueOf(jugador1.getEnergia()));
		txtDefensa1.setText(String.valueOf(jugador1.getDefensa()));
		txtEvasion1.setText(String.valueOf(jugador1.getEvasion()));

		txtVida2.setText(String.valueOf(jugador2.getVida()));;
		txtEnergia2.setText(String.valueOf(jugador2.getEnergia()));
		txtDefensa2.setText(String.valueOf(jugador2.getDefensa()));
		txtEvasion2.setText(String.valueOf(jugador2.getEvasion()));
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJugador1 = new JLabel("JUGADOR 1");
		lblJugador1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblJugador1.setBounds(10, 11, 79, 14);
		contentPane.add(lblJugador1);
		
		txtJugador1 = new JTextField();
		txtJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador1.setEditable(false);
		txtJugador1.setBounds(99, 8, 87, 20);
		txtJugador1.setColumns(10);
		contentPane.add(txtJugador1);
		
		JLabel lblVida1 = new JLabel("VIDA");
		lblVida1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVida1.setBounds(67, 36, 63, 14);
		contentPane.add(lblVida1);
		
		JLabel lblEnergia1 = new JLabel("ENERGIA");
		lblEnergia1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnergia1.setBounds(67, 61, 63, 14);
		contentPane.add(lblEnergia1);
		
		JLabel lblDefensa1 = new JLabel("DEFENSA");
		lblDefensa1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDefensa1.setBounds(67, 86, 63, 14);
		contentPane.add(lblDefensa1);
		
		JLabel lblEvasion1 = new JLabel("EVASION");
		lblEvasion1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEvasion1.setBounds(67, 111, 63, 14);
		contentPane.add(lblEvasion1);
		
		txtVida1 = new JTextField();
		txtVida1.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida1.setEditable(false);
		txtVida1.setBounds(140, 33, 46, 20);
		txtVida1.setColumns(10);
		contentPane.add(txtVida1);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia1.setEditable(false);
		txtEnergia1.setBounds(140, 58, 46, 20);
		txtEnergia1.setColumns(10);
		contentPane.add(txtEnergia1);
		
		txtDefensa1 = new JTextField();
		txtDefensa1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa1.setEditable(false);
		txtDefensa1.setBounds(140, 83, 46, 20);
		txtDefensa1.setColumns(10);
		contentPane.add(txtDefensa1);
		
		txtEvasion1 = new JTextField();
		txtEvasion1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion1.setEditable(false);
		txtEvasion1.setBounds(140, 108, 46, 20);
		txtEvasion1.setColumns(10);
		contentPane.add(txtEvasion1);
		
		btnAtacar1 = new JButton("Atacar");
		btnAtacar1.setBounds(123, 141, 87, 23);
		btnDefender1 = new JButton("Defender");
		btnDefender1.setBounds(123, 202, 87, 23);
		contentPane.add(btnAtacar1);
		contentPane.add(btnDefender1);
		
		JLabel lblJugador2 = new JLabel("JUGADOR 2");
		lblJugador2.setBounds(337, 11, 87, 14);
		contentPane.add(lblJugador2);
		
		txtJugador2 = new JTextField();
		txtJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador2.setEditable(false);
		txtJugador2.setColumns(10);
		txtJugador2.setBounds(240, 8, 87, 20);
		contentPane.add(txtJugador2);
		
		JLabel lblVida2 = new JLabel("VIDA");
		lblVida2.setBounds(296, 36, 63, 14);
		contentPane.add(lblVida2);
		
		JLabel lblEnergia2 = new JLabel("ENERGIA");
		lblEnergia2.setBounds(296, 61, 63, 14);
		contentPane.add(lblEnergia2);
		
		JLabel lblDefensa2 = new JLabel("DEFENSA");
		lblDefensa2.setBounds(296, 86, 63, 14);
		contentPane.add(lblDefensa2);
		
		JLabel lblEvasion2 = new JLabel("EVASION");
		lblEvasion2.setBounds(296, 111, 63, 14);
		contentPane.add(lblEvasion2);
		
		txtVida2 = new JTextField();
		txtVida2.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida2.setEditable(false);
		txtVida2.setColumns(10);
		txtVida2.setBounds(240, 33, 46, 20);
		contentPane.add(txtVida2);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia2.setEditable(false);
		txtEnergia2.setColumns(10);
		txtEnergia2.setBounds(240, 58, 46, 20);
		contentPane.add(txtEnergia2);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa2.setEditable(false);
		txtDefensa2.setColumns(10);
		txtDefensa2.setBounds(240, 83, 46, 20);
		contentPane.add(txtDefensa2);
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion2.setEditable(false);
		txtEvasion2.setColumns(10);
		txtEvasion2.setBounds(240, 108, 46, 20);
		contentPane.add(txtEvasion2);
		
		btnAtacar2 = new JButton("Atacar");
		btnAtacar2.setBounds(222, 141, 87, 23);
		btnDefender2 = new JButton("Defender");
		btnDefender2.setBounds(222, 202, 87, 23);
		
		contentPane.add(btnAtacar2);
		contentPane.add(btnDefender2);
		
		txtAtaque1 = new JTextField();
		txtAtaque1.setBounds(67, 142, 46, 20);
		contentPane.add(txtAtaque1);
		txtAtaque1.setColumns(10);
		
		txtAtaque2 = new JTextField();
		txtAtaque2.setColumns(10);
		txtAtaque2.setBounds(319, 142, 46, 20);
		contentPane.add(txtAtaque2);
		
		JLabel lblAtaque1 = new JLabel("ATAQUE");
		lblAtaque1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAtaque1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaque1.setBounds(10, 145, 57, 14);
		contentPane.add(lblAtaque1);
		
		JLabel lblAtaque2 = new JLabel("ATAQUE");
		lblAtaque2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAtaque2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaque2.setBounds(367, 145, 57, 14);
		contentPane.add(lblAtaque2);
		
		//esto aparece solo si el ataque es evadido. Msj: "Ataque Evadido"
		lblAtaqueEvadido = new JLabel("");
		lblAtaqueEvadido.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaqueEvadido.setBounds(123, 175, 186, 14);
		contentPane.add(lblAtaqueEvadido);
		
		//esto aparece al pulsar boton Defender, donde el msj es "Defensa efectuada"
		lblDefensaEfectuada = new JLabel("");
		lblDefensaEfectuada.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefensaEfectuada.setBounds(123, 236, 186, 14);
		contentPane.add(lblDefensaEfectuada);
	}
}
