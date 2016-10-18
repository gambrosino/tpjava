package uiEscritorio;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import negocio.ControladorPersonaje;
import entidades.Personaje;

public class frmCargarPuntos extends JFrame {

	private JPanel contentPane;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtRestantes;
	private JTextField txtNombre;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtPuntosTotales;
	
	private Personaje pj;
	private ControladorPersonaje cp = new ControladorPersonaje();

	/**
	 * Create the frame.
	 */
	public frmCargarPuntos(Personaje personaje) {
		
		pj = personaje;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setText(pj.getNombre());
		
		
		JLabel lblRestantes = new JLabel("RESTANTES");
		
		txtRestantes = new JTextField();
		txtRestantes.setColumns(10);
		txtRestantes.setText(String.valueOf(pj.getPuntosDisponibles()));
		
		
		JLabel lblVida = new JLabel("VIDA:");
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setText(String.valueOf(pj.getVida()));
		
		
		JLabel lblEnergia = new JLabel("ENERGIA:");
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setText(String.valueOf(pj.getEnergia()));
		
		
		JLabel lblDefensa = new JLabel("DEFENSA:");
		
		
		JLabel lblEvasion = new JLabel("EVASION:");

		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrearPersonaje frmCP = new frmCrearPersonaje();
				frmCP.setLocationRelativeTo(null);
			    frmCP.setVisible(true);
			    setVisible(false);
			    dispose();
			}
		});
		
		JButton btnVidaU = new JButton("+");
		btnVidaU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				incrementar(txtVida);
			}
		});
		btnVidaU.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnVidaD = new JButton("-");
		btnVidaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decrementar(txtVida);
			}
		});
		btnVidaD.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnEnergiaD = new JButton("-");
		btnEnergiaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementar(txtEnergia);
			}
		});
		btnEnergiaD.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnEnergiaU = new JButton("+");
		btnEnergiaU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementar(txtEnergia);
			}
		});
		btnEnergiaU.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnDefensaD = new JButton("-");
		btnDefensaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementar(txtDefensa);
			}
		});
		btnDefensaD.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnDefensaU = new JButton("+");
		btnDefensaU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementar(txtDefensa);
			}
		});
		btnDefensaU.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnEvasionD = new JButton("-");
		btnEvasionD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementar(txtEvasion);
			}
		});
		btnEvasionD.setMargin(new Insets(2, 2, 2, 2));
		
		JButton btnEvasionU = new JButton("+");
		btnEvasionU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementar(txtEvasion);
			}
		});
		btnEvasionU.setMargin(new Insets(2, 2, 2, 2));
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setText(String.valueOf(pj.getDefensa()));
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setText(String.valueOf(pj.getEvasion()));
		
		JLabel lblPuntosTotales = new JLabel("PUNTOS TOTALES");
		
		txtPuntosTotales = new JTextField();
		txtPuntosTotales.setEditable(false);
		txtPuntosTotales.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNombre)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtRestantes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
										.addComponent(lblRestantes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtPuntosTotales, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
									.addGap(17))
								.addComponent(lblPuntosTotales))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
								.addComponent(txtNombre, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addGap(76)
							.addContainerGap(94, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
							.addComponent(btnGuardar)
							.addGap(32))))
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
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAtras)
								.addComponent(btnGuardar))
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPuntosTotales)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPuntosTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRestantes)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void incrementar(JTextField input) {
		int puntosDisponibles = Integer.parseInt(txtRestantes.getText());
		if(puntosDisponibles > 0) {
			int valorAtributo = Integer.parseInt(input.getText());
			input.setText(String.valueOf(++valorAtributo));	
			txtRestantes.setText(String.valueOf(--puntosDisponibles));
		}
	}
	
	private void decrementar(JTextField input) {
		int valorAtributo = Integer.parseInt(input.getText().toString());
		int puntosDisponibles = Integer.parseInt(txtRestantes.getText());
		if(valorAtributo > 0 ) {
			input.setText(String.valueOf(--valorAtributo));
			txtRestantes.setText(String.valueOf(++puntosDisponibles));
		}		
	}
	
	private void guardar() {
		Hashtable<String, String> atributos = getAtributos();
		
		cp.guardarPersonaje(pj, atributos);
		
		frmMenuPrincipal frmMP = new frmMenuPrincipal();
		frmMP.setLocationRelativeTo(null);
	    frmMP.setVisible(true);
	    setVisible(false);
	    dispose();
		
	}

	private Hashtable<String, String> getAtributos() {
		Hashtable<String, String> atributos = new Hashtable<String, String>();
		atributos.put("vida", txtVida.getText());
		atributos.put("energia", txtEnergia.getText());
		atributos.put("defensa", txtDefensa.getText());
		atributos.put("evasion", txtEvasion.getText());
		atributos.put("disponibles", txtRestantes.getText());
		
		return atributos;
	}
	
	
}
