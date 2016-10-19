package uiEscritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	
	private JButton btnBuscar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 */
	public frmBuscarPersonaje() {
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
		if(source == btnBuscar) {
			frmCargarPuntos frmCPts = new frmCargarPuntos((Personaje)(cmbPersonaje.getSelectedItem()));
			frmCPts.setLocationRelativeTo(null);
			frmCPts.setVisible(true);
		} else if(source == btnCancelar) {
			frmPersonaje frmP = new frmPersonaje();
			frmP.setLocationRelativeTo(null);
		    frmP.setVisible(true);
		}
		
	    setVisible(false);
	    dispose();	
	}
	
	private void fillComboBox() {
		ArrayList<Personaje> personajes = this.ctrlPersonaje.getAll();
		for (Personaje personaje : personajes) {
			cmbPersonaje.addItem(personaje);
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		cmbPersonaje = new JComboBox();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(188)
							.addComponent(lblNombre)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(cmbPersonaje, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(129))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNombre)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbPersonaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnBuscar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
