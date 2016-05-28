package presentation;

import business.implementation.*;
import listener.ListenerEventi;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrazione {
		private JFrame frame;
		private JTextField txtNome;
		private JTextField txtCognome;
		private JTextField txtUsername;
		private JPasswordField passwordField;
		private JLabel lblCognome;
		private JButton btnRegistrati;
		Connection c=DbConnection.dbConnector();

		/**
		 * Create the application.
		 */
		public Registrazione(){
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
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
			
			JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setToolTipText("");
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Utente Base", "Utente Avanzato"}));
			comboBox.setBounds(226, 441, 243, 19);
			frame.getContentPane().add(comboBox);
			//frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, txtNome, txtCognome, txtUsername, lblNome, lblUsername, lblPassword, passwordField, lblCognome, btnRegistrati}));
		
			
			JLabel lblUtente = new JLabel("Utente");
			lblUtente.setFont(new Font("Roboto Black", Font.PLAIN, 20));
			lblUtente.setBounds(113, 437, 122, 23);
			frame.getContentPane().add(lblUtente);			

			btnRegistrati = new JButton("Registrati");
			btnRegistrati.setBounds(119, 515, 275, 35);
			frame.getContentPane().add(btnRegistrati);
			
			//BOTTONE REGISTRATI
			btnRegistrati.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent arg0) {	
					close();
					ListenerEventi.registrati(txtUsername.getText(),passwordField,comboBox.getSelectedItem().toString(),txtNome.getText(),txtCognome.getText());						
				}
			});
			
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

