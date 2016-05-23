/**
 * 
 */
package presentation;

import business.model.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author antony
 *
 */
public class UserGui {
	JFrame frame;
	Connection c=null;
	UtenteBase utente;
	
	public UserGui(Connection c,UtenteBase utente){
		this.c=c;
		this.utente=utente;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 963, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(130, -24, 398, 266);
		frame.getContentPane().add(label);
		
		JLabel lblBenvenuto = new JLabel("Tutta la cultura a portata di click...");
		lblBenvenuto.setFont(new Font("Roboto Black", Font.PLAIN, 29));
		lblBenvenuto.setBounds(364, 56, 506, 108);
		frame.getContentPane().add(lblBenvenuto);
		
		JButton btnPaginaPer = new JButton("Pagina Personale");
		btnPaginaPer.setFont(new Font("Roboto Black", Font.PLAIN, 19));
		btnPaginaPer.setForeground(new Color(255, 255, 255));
		btnPaginaPer.setBackground(new Color(0, 0, 255));
		
		//Bottone pagina personale
		btnPaginaPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				close();
				new PersonalGui(c,utente);				
			}
		});
		
		btnPaginaPer.setBounds(192, 348, 214, 58);
		frame.getContentPane().add(btnPaginaPer);
		
		JButton Ricerca = new JButton("Ricerca");
		Ricerca.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Ricerca.setForeground(new Color(0, 0, 255));
		Ricerca.setBackground(new Color(255, 255, 255));
		Ricerca.setBounds(504, 347, 228, 59);
		
		//Bottone ricerca
		Ricerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				close();
				new Ricerca(c);
			}
		});
		
		frame.getContentPane().add(Ricerca);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(173, 187, 591, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblBenvenuto_1 = new JLabel("Benvenuto");
		lblBenvenuto_1.setFont(new Font("Roboto Black", Font.ITALIC, 33));
		lblBenvenuto_1.setBounds(270, 199, 368, 68);
		frame.getContentPane().add(lblBenvenuto_1);		
		
		JLabel lblUsername = new JLabel(utente.getUserId());
		lblUsername.setForeground(new Color(105, 105, 105));
		lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		lblUsername.setBounds(482, 215, 228, 41);
		frame.getContentPane().add(lblUsername);			

		this.frame.setVisible(true);
	}	
	
	public void close(){		
		this.frame.dispose();
	}	

}