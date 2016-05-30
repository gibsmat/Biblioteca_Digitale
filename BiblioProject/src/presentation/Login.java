package presentation;

import listener.ListenerEventi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login{
		public JFrame frame=new JFrame();
		private JTextField txtUsername;
		private JPasswordField passwordField;	
		
		public Login() {
			initialize();
		}
		/**
		 * Initialize the contents of the frame.
		 */
		
		private void initialize() {

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
					close();
					ListenerEventi.login(txtUsername.getText(),passwordField);	
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
					ListenerEventi.changePage("Registrazione",null);
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
