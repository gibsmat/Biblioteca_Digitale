package presentation;

import java.sql.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

import business.implementation.DbConnection;
import business.model.*;
import listener.ListenerEventi;

public class AdminGui {
	JFrame frame,frame1,frame2;
	Connection c= DbConnection.dbConnector();
	static Admin admin=new Admin();
	
public AdminGui(){
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
			showUsers();
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
			frame1.dispose();
			ListenerEventi.changePage("Admin", null);
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
			ListenerEventi.addUtente(admin,Utenza.getSelectedItem().toString(),Username.getText(),Password.getText(),nome.getText(),cognome.getText());			
			frame1.dispose();
			ListenerEventi.changePage("Admin", null);
		}
	});	
	this.frame1.setVisible(true);
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
			ListenerEventi.changePage("Admin",null);
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
			frame3.dispose();
			ListenerEventi.deleteOpera(admin,codice.getText());			
		}
	});
	
	frame3.setVisible(true);
}


public void showUsers(){
	JFrame frame4 = new JFrame();
	JTable table;
	
	frame4.setBounds(100, 100, 920, 811);
	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame4.getContentPane().setLayout(new MigLayout("", "[343px][2px][480px]", "[57px][76px][496px][47px]"));
	
	JScrollPane scrollPane_1 = new JScrollPane();
	frame4.getContentPane().add(scrollPane_1, "cell 0 2 3 1,grow");
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane_1.setViewportView(scrollPane);
	
	table = new JTable();
	table.setFont(new Font("Roboto Black", Font.PLAIN, 13));
	scrollPane.setViewportView(table);
	
	JButton btnVisualizza = new JButton("visualizza");
	btnVisualizza.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
		}
	});
	
	btnVisualizza.setFont(new Font("Roboto Black", Font.PLAIN, 24));
	frame4.getContentPane().add(btnVisualizza, "cell 0 3 2 1,alignx center,growy");
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("img/log2.png"));
	frame4.getContentPane().add(label, "cell 0 0 1 2,alignx center,aligny center");
	
	JComboBox<String> comboBox = new JComboBox<String>();
	comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Utente Base", "Utente Avanzato ", "Trascrittore", "Acquisitore", "Revisore Immagini", "Revisore Trascrizioni"}));
	comboBox.setToolTipText("");
	frame4.getContentPane().add(comboBox, "cell 2 1,growx,aligny center");
	
	JButton btnRimuovi = new JButton("Rimuovi");
	btnRimuovi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteUtente();
		}
	});
	
	btnRimuovi.setFont(new Font("Roboto Black", Font.PLAIN, 24));
	frame4.getContentPane().add(btnRimuovi, "cell 2 3,alignx center,growy");
	
	JLabel lblSelezionaLaTabella = new JLabel("Seleziona la tabella da visualizzare ");
	lblSelezionaLaTabella.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	frame4.getContentPane().add(lblSelezionaLaTabella, "cell 1 0 2 1,alignx center,aligny bottom");
	
	frame4.setVisible(true);
}

public void deleteUtente(){
	JTextField nome;
	
	frame2 = new JFrame();
	frame2.setBounds(100, 100, 527, 613);
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.getContentPane().setLayout(null);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("img/log2.png"));
	label.setBounds(140, 13, 207, 179);
	frame2.getContentPane().add(label);
	
	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	lblUsername.setBounds(62, 227, 160, 38);
	frame2.getContentPane().add(lblUsername);
	
	JComboBox<String> utenza = new JComboBox<String>();
	utenza.setModel(new DefaultComboBoxModel<String>(new String[] {"Utente Base", "Utente Avanzato ", "Trascrittore", "Acquisitore", "Revisore Immagini", "Revisore Trascrizioni"}));
	utenza.setToolTipText("");
	utenza.setFont(new Font("Roboto Black", Font.PLAIN, 15));
	utenza.setBounds(228, 336, 211, 42);
	frame2.getContentPane().add(utenza);
	
	JLabel label_3 = new JLabel("Utente");
	label_3.setFont(new Font("Roboto Black", Font.PLAIN, 30));
	label_3.setBounds(62, 323, 160, 57);
	frame2.getContentPane().add(label_3);
	
	nome = new JTextField();
	nome.setBounds(233, 227, 196, 43);
	frame2.getContentPane().add(nome);
	nome.setColumns(10);
	
	JButton btnRimuovi = new JButton("Rimuovi");
	btnRimuovi.setFont(new Font("Roboto Black", Font.PLAIN, 15));
	btnRimuovi.setBounds(173, 438, 148, 45);
	frame2.getContentPane().add(btnRimuovi);
	
	btnRimuovi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {	
			frame2.dispose();
			ListenerEventi.deleteUtente(admin,utenza.getSelectedItem().toString(),nome.getText());					
		}
	});

	
/*	JButton button = new JButton("Back");
	button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
	button.setBounds(12, 25, 97, 25);
	frame2.getContentPane().add(button);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame2.dispose();
			showUsers();			
		}
	});	*/

	this.frame2.setVisible(true);
}

public void close(){
	this.frame.dispose();
}

}