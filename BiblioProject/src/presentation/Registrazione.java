package presentation;

import business.model.*;
import business.implementation.*;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.Font;
import java.awt.Component;
import java.awt.Choice;
import java.awt.List;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.*;

public class Registrazione {
		private JFrame frame;
		private JTextField txtNome;
		private JTextField txtCognome;
		private JTextField txtUsername;
		private JPasswordField passwordField;
		private JLabel lblCognome;
		private JButton btnRegistrati;

		/**
		 * Create the application.
		 */
		public Registrazione(Connection c) {
			initialize(c);
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize(Connection c) {
			frame = new JFrame();
			frame.setBounds(100, 100, 562, 630);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblCreaIlTuo = new JLabel("Crea il tuo account !!!");
			lblCreaIlTuo.setFont(new Font("Roboto Black", Font.PLAIN, 29));
			lblCreaIlTuo.setBounds(226, 23, 377, 76);
			frame.getContentPane().add(lblCreaIlTuo);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("img/log2.png"));
			lblNewLabel.setBounds(12, -40, 223, 192);
			frame.getContentPane().add(lblNewLabel);
			
			txtNome = new JTextField();
			txtNome.setBounds(226, 136, 243, 35);
			frame.getContentPane().add(txtNome);
			txtNome.setColumns(10);
			
			txtCognome = new JTextField();
			txtCognome.setBounds(226, 208, 243, 35);
			frame.getContentPane().add(txtCognome);
			txtCognome.setColumns(10);
			
			txtUsername = new JTextField();
			txtUsername.setBounds(226, 282, 243, 35);
			frame.getContentPane().add(txtUsername);
			txtUsername.setColumns(10);
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 20));
			lblNome.setBounds(113, 136, 158, 35);
			frame.getContentPane().add(lblNome);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 20));
			lblUsername.setBounds(113, 282, 216, 35);
			frame.getContentPane().add(lblUsername);
			
			JLabel lblPassword = new JLabel("Password\r\n");
			lblPassword.setToolTipText("");
			lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 20));
			lblPassword.setBounds(113, 344, 178, 49);
			frame.getContentPane().add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(226, 355, 243, 35);
			frame.getContentPane().add(passwordField);
			
			lblCognome = new JLabel("Cognome");
			lblCognome.setFont(new Font("Roboto Black", Font.PLAIN, 20));
			lblCognome.setBounds(113, 205, 223, 35);
			frame.getContentPane().add(lblCognome);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setToolTipText("");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Utente Base", "Utente Avanzato"}));
			comboBox.setBounds(226, 441, 243, 19);
			frame.getContentPane().add(comboBox);
			//frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, txtNome, txtCognome, txtUsername, lblNome, lblUsername, lblPassword, passwordField, lblCognome, btnRegistrati}));
		
			
			JLabel lblUtente = new JLabel("Utente");
			lblUtente.setFont(new Font("Roboto Black", Font.PLAIN, 20));
			lblUtente.setBounds(113, 437, 122, 23);
			frame.getContentPane().add(lblUtente);
			
			//BOTTONE REGISTRATI
			btnRegistrati = new JButton("Registrati");
			btnRegistrati.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {	
					if(txtUsername.getText().equals("") || passwordField.getPassword().length == 0){
						JOptionPane.showMessageDialog(null, "I campi username e password sono obbligatori!");
						close();	
						new Registrazione(c);
					}
					else if(passwordField.getText().length() < 5){
						JOptionPane.showMessageDialog(null, "La password deve contenere almeno 5 caratteri.");
						close(); 
						new Registrazione(c);
					}
					else if(txtUsername.getText().equals("ADMIN")){
						JOptionPane.showMessageDialog(null, "Username non disponibile.");
						close(); 
						new Registrazione(c);
					}
					else{											
						if(comboBox.getSelectedItem().toString().equals("Utente Base")){	
							//creazione utente base
							if(new UserManagement(c).nuovoUtente(txtUsername.getText(),txtNome.getText(),txtCognome.getText(),passwordField.getText()))
							{
								JOptionPane.showMessageDialog(null, "Registrazione effettuata.");
								close();
								new Login(c);
							}
							else{
								close();
								new Registrazione(c);
							}
						}
						else{	//creazione utente avanzato
							if(new UserManagement(c).nuovoUtente(txtUsername.getText(),txtNome.getText(),txtCognome.getText(),passwordField.getText(),'a'))
							{
							JOptionPane.showMessageDialog(null, "Registrazione effettuata.");
							close();
							new Login(c);
							}
							else{
								close();
								new Registrazione(c);
							}
						}
					}
				}
			});
			btnRegistrati.setBounds(119, 515, 275, 35);
			frame.getContentPane().add(btnRegistrati);
			
			JLabel lblalmenoCaratteri = new JLabel("(almeno 5 caratteri)");
			lblalmenoCaratteri.setToolTipText("");
			lblalmenoCaratteri.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblalmenoCaratteri.setBounds(101, 365, 178, 49);
			frame.getContentPane().add(lblalmenoCaratteri);
					
			this.frame.setVisible(true);
		}

		public void close(){
			this.frame.dispose();
		}
}

