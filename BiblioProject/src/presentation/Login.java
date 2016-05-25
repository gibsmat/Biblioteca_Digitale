package presentation;

import business.implementation.*;
import business.model.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login{
		public JFrame frame=new JFrame();
		private JTextField txtUsername;
		private JPasswordField passwordField;	
		
		public Login(Connection c) {
			initialize(c);
		}
		/**
		 * Initialize the contents of the frame.
		 */
		
		private void initialize(Connection c) {

			frame.setBounds(100, 100, 525, 398);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			txtUsername = new JTextField();
			txtUsername.setBounds(277, 45, 204, 40);
			frame.getContentPane().add(txtUsername);
			txtUsername.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(277, 164, 204, 40);
			frame.getContentPane().add(passwordField);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 13));
			lblUsername.setBounds(181, 51, 107, 28);
			frame.getContentPane().add(lblUsername);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 13));
			lblPassword.setBounds(181, 170, 100, 28);
			frame.getContentPane().add(lblPassword);
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setFont(new Font("Roboto Black", Font.PLAIN, 13));
			
			// BOTTONE LOGIN
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {										
					if(txtUsername.getText().equals("") || passwordField.getPassword().length == 0){					
						JOptionPane.showMessageDialog(null, "Inserire password e username!");
						close(); new Login(c); 
					}
					else if(txtUsername.getText().equals("ADMIN") && passwordField.getText().equals("ADMIN")){
						close();
						new AdminGui(c,new Admin(c,"ADMIN","ADMIN"));
					}
					else{ 
						Utente utente = new UserManagement(c).getUtente(txtUsername.getText(), passwordField);
						if(utente instanceof UtenteAvanzato){
							close();
							new UserGui(c,(UtenteAvanzato)utente);
						}
						else if(utente instanceof UtenteBase){
							close();
							new UserGui(c,(UtenteBase)utente);
						}
						else if(utente instanceof Trascrittore){
							JOptionPane.showMessageDialog(null, "Trascrittore Loggato.");
							close();
							//apri home trascrittore
						}
						else if(utente instanceof Acquisitore){
							JOptionPane.showMessageDialog(null, "Acquisitore Loggato.");
							close();
							new AcquisitoreGui(c,utente);
						}
						else if(utente instanceof RevisoreTrascrizioni){
							JOptionPane.showMessageDialog(null, "Revisore Trascrizioni loggato.");
							close();
						}
						else if(utente instanceof RevisoreImmagine){
							JOptionPane.showMessageDialog(null, "Revisore immagini loggato.");
							close();
						}
						else{
							JOptionPane.showMessageDialog(null, "Username e password non validi.");
							close();
							new Login(c);
						}
					}
				}
			});		

			
			btnNewButton.setBounds(153, 242, 176, 40);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("img/log2.png"));
			lblNewLabel.setBounds(26, 0, 215, 229);
			frame.getContentPane().add(lblNewLabel);
			
			//Registrati
			JButton btnRegistrati = new JButton("Registrati");
			btnRegistrati.setFont(new Font("Roboto Black", Font.PLAIN, 13));
			btnRegistrati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					close();
					new Registrazione(c);
				}
			});
			btnRegistrati.setBackground(UIManager.getColor("Button.light"));
			btnRegistrati.setBounds(354, 300, 97, 25);
			frame.getContentPane().add(btnRegistrati);
			
			JLabel lblNonHaiUn = new JLabel("Non hai un account ?");
			lblNonHaiUn.setFont(new Font("Roboto Black", Font.PLAIN, 13));
			lblNonHaiUn.setBounds(197, 302, 181, 21);
			frame.getContentPane().add(lblNonHaiUn);
			
			this.frame.setVisible(true);
		}
		
public void close(){
	this.frame.dispose();
}
	}
