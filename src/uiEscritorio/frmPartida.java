package uiEscritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import negocio.ControladorPersonaje;
import entidades.Personaje;

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

	private JButton btnAtacar1;
	private JButton btnDefender1;
	private JButton btnAtacar2;
	private JButton btnDefender2;
	private ControladorPersonaje ctrlPersonaje;
	private Personaje jugador1;
	private Personaje jugador2;
	private JLabel lblJugador2;
	
	/**
	 * Create the frame.
	 */
	public frmPartida(Personaje jugador1, Personaje jugador2) {
		initialize();
		this.ctrlPersonaje = new ControladorPersonaje();
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.iniciarPartida();
	}

	/**
	 * Frame Methods
	 */
	public void actionPerformed(ActionEvent e) {
		actionHandler(e.getSource());	
	}
	
	private void actionHandler(Object source) {
		if(source == btnAtacar1) {
			
		}
		else if(source == btnDefender1) {
			
		}
		else if(source == btnAtacar2) {
			
		}
		else if(source == btnDefender2) {
			
		}
	}
	
	private void iniciarPartida() {
		// TODO
		// definir el turno
		// deshabilitar los botones segun sea el turno
		this.fillForm();
		
	}
	
	private void fillForm(){
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

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJugador1 = new JLabel("JUGADOR 1");
		lblJugador1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblJugador1.setBounds(82, 22, 87, 14);
		contentPane.add(lblJugador1);
		
		txtJugador1 = new JTextField();
		txtJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador1.setEditable(false);
		txtJugador1.setBounds(82, 47, 87, 20);
		contentPane.add(txtJugador1);
		txtJugador1.setColumns(10);
		
		JLabel lblVida1 = new JLabel("VIDA");
		lblVida1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVida1.setBounds(50, 95, 63, 14);
		contentPane.add(lblVida1);
		
		JLabel lblEnergia1 = new JLabel("ENERGIA");
		lblEnergia1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnergia1.setBounds(50, 120, 63, 14);
		contentPane.add(lblEnergia1);
		
		JLabel lblDefensa1 = new JLabel("DEFENSA");
		lblDefensa1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDefensa1.setBounds(50, 145, 63, 14);
		contentPane.add(lblDefensa1);
		
		JLabel lblEvasion1 = new JLabel("EVASION");
		lblEvasion1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEvasion1.setBounds(50, 170, 63, 14);
		contentPane.add(lblEvasion1);
		
		txtVida1 = new JTextField();
		txtVida1.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida1.setEditable(false);
		txtVida1.setBounds(123, 92, 46, 20);
		contentPane.add(txtVida1);
		txtVida1.setColumns(10);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia1.setEditable(false);
		txtEnergia1.setBounds(123, 117, 46, 20);
		contentPane.add(txtEnergia1);
		txtEnergia1.setColumns(10);
		
		txtDefensa1 = new JTextField();
		txtDefensa1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa1.setEditable(false);
		txtDefensa1.setBounds(123, 142, 46, 20);
		contentPane.add(txtDefensa1);
		txtDefensa1.setColumns(10);
		
		txtEvasion1 = new JTextField();
		txtEvasion1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion1.setEditable(false);
		txtEvasion1.setBounds(123, 167, 46, 20);
		contentPane.add(txtEvasion1);
		txtEvasion1.setColumns(10);
		
		btnAtacar1 = new JButton("Atacar");
		btnAtacar1.setBounds(111, 227, 89, 23);
		contentPane.add(btnAtacar1);
		
		btnDefender1 = new JButton("Defender");
		btnDefender1.setBounds(8, 227, 89, 23);
		contentPane.add(btnDefender1);
		
		txtJugador2 = new JTextField();
		txtJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador2.setEditable(false);
		txtJugador2.setColumns(10);
		txtJugador2.setBounds(265, 47, 87, 20);
		contentPane.add(txtJugador2);
		
		JLabel lblVida2 = new JLabel("VIDA");
		lblVida2.setBounds(321, 95, 63, 14);
		contentPane.add(lblVida2);
		
		JLabel lblEnergia2 = new JLabel("ENERGIA");
		lblEnergia2.setBounds(321, 120, 63, 14);
		contentPane.add(lblEnergia2);
		
		JLabel lblDefensa2 = new JLabel("DEFENSA");
		lblDefensa2.setBounds(321, 145, 63, 14);
		contentPane.add(lblDefensa2);
		
		JLabel lblEvasion2 = new JLabel("EVASION");
		lblEvasion2.setBounds(321, 170, 63, 14);
		contentPane.add(lblEvasion2);
		
		txtVida2 = new JTextField();
		txtVida2.setHorizontalAlignment(SwingConstants.CENTER);
		txtVida2.setEditable(false);
		txtVida2.setColumns(10);
		txtVida2.setBounds(265, 92, 46, 20);
		contentPane.add(txtVida2);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia2.setEditable(false);
		txtEnergia2.setColumns(10);
		txtEnergia2.setBounds(265, 117, 46, 20);
		contentPane.add(txtEnergia2);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa2.setEditable(false);
		txtDefensa2.setColumns(10);
		txtDefensa2.setBounds(265, 142, 46, 20);
		contentPane.add(txtDefensa2);
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion2.setEditable(false);
		txtEvasion2.setColumns(10);
		txtEvasion2.setBounds(265, 167, 46, 20);
		contentPane.add(txtEvasion2);
		
		btnAtacar2 = new JButton("Atacar");
		btnAtacar2.setBounds(335, 227, 89, 23);
		contentPane.add(btnAtacar2);
		
		btnDefender2 = new JButton("Defender");
		btnDefender2.setBounds(232, 227, 89, 23);
		contentPane.add(btnDefender2);
		
		lblJugador2 = new JLabel("JUGADOR 2");
		lblJugador2.setBounds(265, 22, 87, 14);
		contentPane.add(lblJugador2);
	}
}
