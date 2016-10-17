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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmJugar extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frmJugar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblJugador1 = new JLabel("JUGADOR 1");
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox cmbJugador1 = new JComboBox();
		
		
		JLabel lblVs = new JLabel("vs.");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblJugador2 = new JLabel("JUGADOR 2");
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox cmbJugador2 = new JComboBox();
		
		
		JButton btnJugar = new JButton("Jugar");
		
		
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
					.addComponent(btnJugar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblJugador1, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(cmbJugador2, 0, 140, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblVs, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblJugador2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cmbJugador1, 0, 140, Short.MAX_VALUE))
					.addGap(38))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador2)
						.addComponent(lblJugador1)
						.addComponent(lblVs))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras)
						.addComponent(btnJugar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
