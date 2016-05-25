package presentation;

import java.sql.*;
import java.util.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import business.implementation.*;
import business.model.*;

public class AdminGui {
	JFrame frame,frame1,frame2;
	Connection c=null;
	Admin admin;
	
public AdminGui(Connection c,Admin admin){
	this.c=c;
	this.admin=admin;
	initialize();
}

public void initialize(){
	frame = new JFrame();
	frame.setBounds(100, 100, 1005, 619);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon("img/log2.png"));
	lblNewLabel.setBounds(174, 13, 235, 212);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblWelcomAdmin = new JLabel("Welcome Admin!");
	lblWelcomAdmin.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	lblWelcomAdmin.setBounds(483, 103, 436, 59);
	frame.getContentPane().add(lblWelcomAdmin);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(216, 212, 542, 2);
	frame.getContentPane().add(separator);
	
	JButton btnAggiungiUtente = new JButton("Aggiungi Utente");
	btnAggiungiUtente.setFont(new Font("Roboto Black", Font.PLAIN, 16));
	btnAggiungiUtente.setBounds(210, 281, 176, 59);
	frame.getContentPane().add(btnAggiungiUtente);
	
	//bottone aggiungi utente
	btnAggiungiUtente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			close();
			addUtente();
		}
	});
	
	JButton btnNewButton = new JButton("Cancellazione Utente");
	btnNewButton.setFont(new Font("Roboto Black", Font.PLAIN, 16));
	btnNewButton.setBounds(557, 281, 193, 59);
	frame.getContentPane().add(btnNewButton);
	
	//bottone cancella utente
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			close();
			deleteUtente();
		}
	});
	
	
	JButton btnCancellazioneOpera = new JButton("Cancellazione Opera");
	btnCancellazioneOpera.setFont(new Font("Roboto Black", Font.PLAIN, 16));
	btnCancellazioneOpera.setBounds(383, 398, 209, 59);
	frame.getContentPane().add(btnCancellazioneOpera);
	
	//bottone cancella opera
	btnCancellazioneOpera.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			close();
			deleteOpera();
		}
	});
	
	
	this.frame.setVisible(true);
}

public void addUtente(){
	JTextField nome;
	JTextField Username;
	JTextField Password;
	JTextField cognome;
	
	frame1 = new JFrame();
	frame1.setBounds(100, 100, 546, 817);
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.getContentPane().setLayout(null);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("img/log2.png"));
	label.setBounds(148, 24, 211, 170);
	frame1.getContentPane().add(label);
	
	JButton btnBack = new JButton("Back");
	btnBack.setFont(new Font("Roboto Black", Font.PLAIN, 14));
	btnBack.setBounds(12, 30, 97, 25);
	frame1.getContentPane().add(btnBack);
	//Bottone Back
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			close();
			new AdminGui(c,admin);
		}	
	});
	
	JLabel lblNome = new JLabel("Nome :");
	lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	lblNome.setBounds(67, 233, 160, 38);
	frame1.getContentPane().add(lblNome);
	
	JLabel label_1 = new JLabel("Cognome:");
	label_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_1.setBounds(67, 307, 157, 43);
	frame1.getContentPane().add(label_1);
	
	JLabel label_3 = new JLabel("Password:");
	label_3.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_3.setBounds(67, 472, 142, 43);
	frame1.getContentPane().add(label_3);
	
	JLabel label_2 = new JLabel("Username:");
	label_2.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_2.setBounds(67, 394, 160, 38);
	frame1.getContentPane().add(label_2);
	
	JLabel label_4 = new JLabel("Utente");
	label_4.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_4.setBounds(67, 545, 160, 57);
	frame1.getContentPane().add(label_4);
	
	nome = new JTextField();
	nome.setBounds(243, 240, 211, 38);
	frame1.getContentPane().add(nome);
	nome.setColumns(10);
	
	cognome = new JTextField();
	cognome.setColumns(10);
	cognome.setBounds(243, 312, 211, 38);
	frame1.getContentPane().add(cognome);
	
	Username = new JTextField();
	Username.setColumns(10);
	Username.setBounds(243, 394, 211, 38);
	frame1.getContentPane().add(Username);
	
	Password = new JTextField();
	Password.setColumns(10);
	Password.setBounds(243, 477, 211, 38);
	frame1.getContentPane().add(Password);
	
	JComboBox<String> Utenza = new JComboBox<String>();
	Utenza.setFont(new Font("Roboto Black", Font.PLAIN, 15));
	Utenza.setModel(new DefaultComboBoxModel<String>(new String[] {"Trascrittore", "Acquisitore", "Revisore Immagini", "Revisore Trascrizioni"}));
	Utenza.setToolTipText("");
	Utenza.setBounds(243, 570, 211, 42);
	frame1.getContentPane().add(Utenza);
	
	JButton btnNewButton = new JButton("Aggiungi");
	btnNewButton.setFont(new Font("Roboto Black", Font.PLAIN, 16));
	btnNewButton.setBounds(171, 671, 173, 56);
	frame1.getContentPane().add(btnNewButton);
	
	//bottone aggiungi
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			switch (Utenza.getSelectedItem().toString()) {
				case "Trascrittore":
					admin.addTrascrittore(Username.getText(), Password.getText(), nome.getText(), cognome.getText());				
					break;
				case "Acquisitore":
					admin.addAcquisitore(Username.getText(), Password.getText(), nome.getText(), cognome.getText());
					break;
				case "Revisore Immagini" :
					admin.addRevisoreImm(Username.getText(), Password.getText(), nome.getText(), cognome.getText());
					break;
				case "Revisore Trascrizioni" :
					admin.addRevisoreTr(Username.getText(), Password.getText(), nome.getText(), cognome.getText());
					break;
				default:
					JOptionPane.showMessageDialog(null, "Errore aggiunta utente");
					break;
			}
			frame1.dispose();
			new AdminGui(c,admin);
		}
	});	
	this.frame1.setVisible(true);
}

public void deleteUtente(){
	JTextField nome;
	JTextField cognome;	
	
	frame2 = new JFrame();
	frame2.setBounds(100, 100, 527, 613);
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.getContentPane().setLayout(null);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("img/log2.png"));
	label.setBounds(140, 13, 207, 179);
	frame2.getContentPane().add(label);
	
	JLabel label_1 = new JLabel("Nome :");
	label_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_1.setBounds(62, 227, 160, 38);
	frame2.getContentPane().add(label_1);
	
	JLabel label_2 = new JLabel("Cognome:");
	label_2.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_2.setBounds(62, 297, 157, 43);
	frame2.getContentPane().add(label_2);
	
	JComboBox<String> utenza = new JComboBox<String>();
	utenza.setModel(new DefaultComboBoxModel<String>(new String[] {"Utente Base", "Utente Avanzato ", "Trascrittore", "Acquisitore", "Revisore Immagini", "Revisore Trascrizioni"}));
	utenza.setToolTipText("");
	utenza.setFont(new Font("Roboto Black", Font.PLAIN, 15));
	utenza.setBounds(234, 391, 211, 42);
	frame2.getContentPane().add(utenza);
	
	JLabel label_4 = new JLabel("Utente");
	label_4.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_4.setBounds(62, 378, 160, 57);
	frame2.getContentPane().add(label_4);
	
	nome = new JTextField();
	nome.setBounds(233, 227, 196, 43);
	frame2.getContentPane().add(nome);
	nome.setColumns(10);
	
	cognome = new JTextField();
	cognome.setColumns(10);
	cognome.setBounds(233, 297, 196, 43);
	frame2.getContentPane().add(cognome);
	
	JButton btnRimuovi = new JButton("Rimuovi");
	btnRimuovi.setFont(new Font("Roboto Black", Font.PLAIN, 15));
	btnRimuovi.setBounds(179, 496, 148, 45);
	frame2.getContentPane().add(btnRimuovi);
	
	//bottone rimuovi
	btnRimuovi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			switch (utenza.getSelectedItem().toString()) {
				case "Utente Base":
					admin.clearUtente(nome.getText());				
					break;
				case "Utente Avanzato":
					admin.clearUtente(nome.getText());					
					break;
				case "Trascrittore":
					admin.clearTrascrittore(nome.getText());			
					break;
				case "Acquisitore":
					admin.clearAcquisitore(nome.getText());
					break;
				case "Revisore Immagini" :
					admin.clearRevisoreImm(nome.getText());
					break;
				case "Revisore Trascrizioni" :
					admin.clearRevisoreTr(nome.getText());
					break;
				default:
					JOptionPane.showMessageDialog(null, "Errore nella cancellazione dell'utente");
					break;
			}
		frame2.dispose();
		new AdminGui(c,admin);			
		}
	});
	
	JButton button = new JButton("Back");
	button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
	button.setBounds(12, 25, 97, 25);
	frame2.getContentPane().add(button);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame2.dispose();
			new AdminGui(c,admin);			
		}
	});
	
	this.frame2.setVisible(true);
}

public void deleteOpera(){
	JFrame frame3;
	JTextField titolo;
	JTextField codice;
	JTextField autore;
	
	frame3 = new JFrame();
	frame3.setBounds(100, 100, 569, 593);
	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame3.getContentPane().setLayout(null);
	
	JButton button = new JButton("Back");
	button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
	button.setBounds(12, 28, 97, 25);
	frame3.getContentPane().add(button);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame3.dispose();
			new AdminGui(c,admin);
		}
	});
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("img/log2.png"));
	label.setBounds(192, 13, 221, 206);
	frame3.getContentPane().add(label);
	
	JLabel lblTitolo = new JLabel("Titolo :");
	lblTitolo.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	lblTitolo.setBounds(54, 215, 160, 38);
	frame3.getContentPane().add(lblTitolo);
	
	JLabel lblCodice = new JLabel("Codice isbn :");
	lblCodice.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	lblCodice.setBounds(54, 292, 160, 38);
	frame3.getContentPane().add(lblCodice);
	
	JLabel lblAutore = new JLabel("Autore :");
	lblAutore.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	lblAutore.setBounds(54, 370, 160, 38);
	frame3.getContentPane().add(lblAutore);
	
	titolo = new JTextField();
	titolo.setBounds(220, 215, 193, 44);
	frame3.getContentPane().add(titolo);
	titolo.setColumns(10);
	
	codice = new JTextField();
	codice.setColumns(10);
	codice.setBounds(220, 292, 193, 44);
	frame3.getContentPane().add(codice);
	
	autore = new JTextField();
	autore.setColumns(10);
	autore.setBounds(220, 364, 193, 44);
	frame3.getContentPane().add(autore);
	
	//bottone rimuovi
	JButton btnRimuovi = new JButton("Rimuovi");
	btnRimuovi.setFont(new Font("Roboto Black", Font.PLAIN, 15));
	btnRimuovi.setBounds(192, 471, 177, 44);
	frame3.getContentPane().add(btnRimuovi);
	
	btnRimuovi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			admin.clearOpera(codice.getText());
			frame3.dispose();
			new AdminGui(c,admin);
		}
	});
	
	frame3.setVisible(true);
}

	/* dentro al bottone cancella utente
	* TreeSet<String> ss =new UserManagement(c).findUsers();
	* showUsers(ss);
	* click sul bottone cancella utente
	*  new Admin(c).clearUtente("usern");  
	*/
	
	/* bottone aggiungi trascrittore
	 new Admin(c).addTrascrittore("trascrittore2","psw","nome","cognome");
	*/
	
	/* bottone cancella trascrittore
	  TreeSet<String> st=new UserManagement(c).findTr();
	  for(String s : st){
		  System.out.println(s);
	  }
	  showUsers(st);
		BOTTONE CANCELLA TRASCRITTORE
	  new Admin(c).clearTrascrittore("trascrittore");
	 */

public void showUsers(TreeSet<String> utenti){
	//mostrare lista username degli utenti
}

public void close(){
	this.frame.dispose();
}

}
