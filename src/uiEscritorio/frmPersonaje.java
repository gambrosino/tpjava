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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPersonaje extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frmPersonaje() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCrearPersonaje = new JButton("Crear Personaje");
		btnCrearPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrearPersonaje frmCP = new frmCrearPersonaje();
				frmCP.setLocationRelativeTo(null);
				frmCP.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnModificarPersonaje = new JButton("Modificar Personaje");
		btnModificarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBuscarPersonaje frmBP = new frmBuscarPersonaje();
				frmBP.setLocationRelativeTo(null);
				frmBP.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenuPrincipal frmMP = new frmMenuPrincipal();
				frmMP.setLocationRelativeTo(null);
			    frmMP.setVisible(true);
			    setVisible(false);
			    dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAtras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCrearPersonaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModificarPersonaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(btnCrearPersonaje)
					.addGap(18)
					.addComponent(btnModificarPersonaje)
					.addGap(67)
					.addComponent(btnAtras)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
