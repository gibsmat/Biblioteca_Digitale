package presentation;

import business.implementation.*;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login{
		public JFrame frame=new JFrame();
		private JTextField textField;
		private JPasswordField pwdPassword;	
		
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
			
			textField = new JTextField();
			textField.setBounds(277, 45, 204, 40);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			pwdPassword = new JPasswordField();
			pwdPassword.setBounds(277, 164, 204, 40);
			frame.getContentPane().add(pwdPassword);
			
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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try{
						
						String query="select * from User where Password=? and Username=?";
						PreparedStatement pst= c.prepareStatement(query);
						pst.setString(1,pwdPassword.getText());
						pst.setString(2,textField.getText() );
						
						
						ResultSet rs=pst.executeQuery();
						int count=0;
						while(rs.next())
						{
							count= count+1;
						}
						
						if(count==1)
						{
							JOptionPane.showMessageDialog(null, "Password e Username sono corretti!!!");
							
						}
						
						else if(count > 1)
						{
							JOptionPane.showMessageDialog(null, "Ci sono Più persone con la stessa Password e Username!!");
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "Password o Username non sono corretti");
						}
						
						
						rs.close();
						pst.close();
						
						
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);


					}
				}
			});
			btnNewButton.setBounds(153, 242, 176, 40);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("img/log2.png"));
			lblNewLabel.setBounds(26, 0, 215, 229);
			frame.getContentPane().add(lblNewLabel);
			
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
			this.frame.setVisible(false);
		}
	}
