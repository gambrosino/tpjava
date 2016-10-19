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
import javax.swing.SwingConstants;
import javax.swing.JButton;

import entidades.Personaje;
import negocio.ControladorPersonaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

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
		// TODO llenar formulario con los puntos de los personajes
		// definimos el turno
		// desabilitamos los botones
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblJugador1 = new JLabel("JUGADOR 1");
		
		txtJugador1 = new JTextField();
		txtJugador1.setEditable(false);
		txtJugador1.setColumns(10);
		
		JLabel lblVida = new JLabel("VIDA");
		lblVida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEnergia = new JLabel("ENERGIA");
		lblEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblDefensa = new JLabel("DEFENSA");
		lblDefensa.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEvasion = new JLabel("EVASION");
		lblEvasion.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtVida1 = new JTextField();
		txtVida1.setEditable(false);
		txtVida1.setColumns(10);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setEditable(false);
		txtEnergia1.setColumns(10);
		
		txtDefensa1 = new JTextField();
		txtDefensa1.setEditable(false);
		txtDefensa1.setColumns(10);
		
		txtEvasion1 = new JTextField();
		txtEvasion1.setEditable(false);
		txtEvasion1.setColumns(10);
		
		btnAtacar1 = new JButton("Atacar");
		btnAtacar1.addActionListener(this);
		
		btnDefender1 = new JButton("Defender");
		btnDefender1.setMargin(new Insets(2, 7, 2, 7));
		btnDefender1.addActionListener(this);

		JLabel lblJugador2 = new JLabel("JUGADOR 2");

		txtJugador2 = new JTextField();
		txtJugador2.setEditable(false);
		txtJugador2.setColumns(10);
		
		JLabel lblVida2 = new JLabel("VIDA");
		lblVida2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEnergia2 = new JLabel("ENERGIA");
		lblEnergia2.setHorizontalAlignment(SwingConstants.RIGHT);		
		
		JLabel lblEvasion2 = new JLabel("EVASION");
		lblEvasion2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblDefensa2 = new JLabel("DEFENSA");
		lblDefensa2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtVida2 = new JTextField();
		txtVida2.setEditable(false);
		txtVida2.setColumns(10);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setEditable(false);
		txtEnergia2.setColumns(10);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setEditable(false);
		txtDefensa2.setColumns(10);
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setEditable(false);
		txtEvasion2.setColumns(10);
		
		btnAtacar2 = new JButton("Atacar");
		btnAtacar2.addActionListener(this);
		
		btnDefender2 = new JButton("Defender");
		btnDefender2.setMargin(new Insets(2, 7, 2, 7));
		btnDefender2.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnDefender1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAtacar1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(33)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblEvasion)
											.addGap(18)
											.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblDefensa)
												.addComponent(lblEnergia))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblVida)
											.addGap(18)
											.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblJugador1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtJugador1))))
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(lblVida2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblEnergia2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(lblDefensa2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblEvasion2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnDefender2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAtacar2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblJugador2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
									.addGap(59))
								.addComponent(txtJugador2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblJugador1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAtacar1)
								.addComponent(btnDefender1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblJugador2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblVida2))
								.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblEnergia2))
								.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDefensa2))
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblEvasion2))
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDefender2)
								.addComponent(btnAtacar2))))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
