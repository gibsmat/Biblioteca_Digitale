/**
 * 
 */
package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import business.Eccezioni;
import business.model.*;
import listener.ListenerEventi;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalGui.
 *
 * @author antony
 */
public class PersonalGui {	
	
	/** The utentebase. */
	UtenteBase utentebase=null;
	
	/**
	 * Instantiates a new personal gui.
	 *
	 * @param utente the utente
	 */
	public PersonalGui(UtenteBase utente){
		this.utentebase=utente;
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	private void initialize(){
		JFrame frame;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
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
		
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				modifica();
			}
		});
		
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
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnBack.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ListenerEventi.changePage("UserPage", utentebase);
			}
		});
		
		frame.setVisible(true);
	}
	
	/**
	 * Modifica.
	 */
	private void modifica(){
		JFrame frame;
		JTextField Username;
		JTextField Nome;
		JTextField Cognome;
		JTextField Password;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 693);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(128, 13, 225, 190);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListenerEventi.changePage("PersonalPage", utentebase);
			}			
		});
		button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		label_1.setBounds(35, 209, 160, 38);
		frame.getContentPane().add(label_1);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblNome.setBounds(35, 306, 160, 38);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblCognome.setBounds(35, 400, 160, 38);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblPassword.setBounds(35, 502, 160, 38);
		frame.getContentPane().add(lblPassword);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(207, 216, 211, 38);
		frame.getContentPane().add(Username);
		
		Nome = new JTextField();
		Nome.setColumns(10);
		Nome.setBounds(180, 306, 211, 38);
		frame.getContentPane().add(Nome);
		
		Cognome = new JTextField();
		Cognome.setColumns(10);
		Cognome.setBounds(207, 400, 211, 38);
		frame.getContentPane().add(Cognome);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(207, 502, 211, 38);
		frame.getContentPane().add(Password);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ListenerEventi.setUtente(utentebase,Username.getText(),Nome.getText(),Cognome.getText(),Password.getText())){
					JOptionPane.showMessageDialog(null,"Dati modificati con successo.");
					frame.dispose();
					ListenerEventi.changePage("Login", null);
				}else{
					
				}
			}
		});
		btnModifica.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnModifica.setBounds(149, 577, 173, 56);
		frame.getContentPane().add(btnModifica);
		
		frame.setVisible(true);
	}
	
}
