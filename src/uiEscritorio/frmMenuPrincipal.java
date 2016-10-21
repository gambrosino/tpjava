package uiEscritorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JButton btnPersonajes;
	private JButton btnJugar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuPrincipal frame = new frmMenuPrincipal();
					frame.pack();
				    frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMenuPrincipal() {
		setTitle("Juego Por Turnos");
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
		if(accion == btnJugar) {
			abrirJugar();
		}
		else if(accion == btnPersonajes) {
			abrirPersonaje();
		} 

		cerrarVentana();
	}

	private void cerrarVentana() {
		setVisible(false);
		dispose();
	}

	private void abrirPersonaje() {
		frmPersonaje frmPersonaje = new frmPersonaje();
		frmPersonaje.setLocationRelativeTo(null);
		frmPersonaje.setVisible(true);
	}

	private void abrirJugar() {
		frmJugar frmJugar = new frmJugar();
		frmJugar.setLocationRelativeTo(null);
		frmJugar.setVisible(true);
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
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(this);
		
		btnPersonajes = new JButton("Personajes");
		btnPersonajes.addActionListener(this);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSalir, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPersonajes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnJugar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(btnJugar)
					.addGap(18)
					.addComponent(btnPersonajes)
					.addGap(66)
					.addComponent(btnSalir)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}	
}
