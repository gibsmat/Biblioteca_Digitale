/**
 * 
 */
package presentation;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import business.model.*;

/**
 * @author antony
 *
 */
public class PersonalGui {
	JFrame frame;
	Connection c=null;
	UtenteBase utentebase=null;
	
	public PersonalGui(Connection c,UtenteBase utente){
		this.c=c;
		this.utentebase=utente;
		initialize();
	}
	
	public void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		User();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(125, -25, 225, 190);
		frame.getContentPane().add(label);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblNome.setBounds(86, 260, 92, 43);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblCognome.setBounds(86, 333, 157, 43);
		frame.getContentPane().add(lblCognome);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setForeground(Color.WHITE);
		btnModifica.setBackground(Color.DARK_GRAY);
		btnModifica.setFont(new Font("Roboto Black", Font.PLAIN, 22));
		btnModifica.setBounds(147, 487, 203, 57);
		frame.getContentPane().add(btnModifica);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblPassword.setBounds(86, 405, 142, 43);
		frame.getContentPane().add(lblPassword);
		
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblUsername.setBounds(86, 195, 160, 38);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblBenvenutoNellaTua = new JLabel("Benvenuto nella tua pagina personale....");
		lblBenvenutoNellaTua.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblBenvenutoNellaTua.setBounds(71, 138, 354, 27);
		frame.getContentPane().add(lblBenvenutoNellaTua);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnBack.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnBack);
		
		this.frame.setVisible(true);
	}
	
	public void User(){		
			
				JLabel lblNome_1 = new JLabel(utentebase.getNome());
				lblNome_1.setForeground(new Color(192, 192, 192));
				lblNome_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
				lblNome_1.setBounds(190, 257, 185, 48);
				frame.getContentPane().add(lblNome_1);			
				
				JLabel lblCognome_1 = new JLabel(utentebase.getCognome());
				lblCognome_1.setForeground(new Color(192, 192, 192));
				lblCognome_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
				lblCognome_1.setBounds(240, 333, 185, 43);
				frame.getContentPane().add(lblCognome_1);			
				
				JLabel lblPassword_1 = new JLabel(utentebase.getPassword().getText());
				lblPassword_1.setForeground(new Color(192, 192, 192));
				lblPassword_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
				lblPassword_1.setBounds(240, 405, 185, 43);
				frame.getContentPane().add(lblPassword_1);			
				
				JLabel lblUsername_1 = new JLabel(utentebase.getUserId());
				lblUsername_1.setForeground(new Color(192, 192, 192));
				lblUsername_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
				lblUsername_1.setBounds(240, 193, 185, 43);
				frame.getContentPane().add(lblUsername_1);			
			}		
	
	public void close(){
		frame.dispose();
	}
}
