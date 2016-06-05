/**
 * 
 */
package presentation;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;

import business.model.*;
import listener.ListenerEventi;

/**
 * @author antony
 *
 */
public class TrascrittoreGui implements FocusListener{
	Trascrittore trascrittore;
	JFrame frameD=new JFrame();
	JFrame frameT=new JFrame();
	JTextPane txtTitle=new JTextPane();
	JTextPane txtanno=new JTextPane();
	JTextField id,Page,txtTitolo,txtNumber;
	final String insert="Inserisci l'Id dell'opera da cui eliminare il testo";
	final String page_s="Page";
	final String title="Titolo/isbn";
	final String titolo="...Titolo...";
	final String anno="...Anno...";
	final String rows=getRows(99);
	
	public TrascrittoreGui(Utente utente){
		this.trascrittore=(Trascrittore)utente;
		initialize();
	}
	
	public void initialize(){
		JFrame frame;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 989, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(208, 37, 235, 212);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Welcome !!!");
		label_1.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		label_1.setBounds(455, 126, 436, 59);
		frame.getContentPane().add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(127, 235, 638, 2);
		frame.getContentPane().add(separator);
		
		JButton btnAggiungiTrascrizione = new JButton("Aggiungi Trascrizione");
		btnAggiungiTrascrizione.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnAggiungiTrascrizione.setBounds(110, 302, 199, 59);
		frame.getContentPane().add(btnAggiungiTrascrizione);
		
		btnAggiungiTrascrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				trascrivi();
			}
		});
		
		JButton btnInserisciCommento = new JButton("Inserisci commento");
		btnInserisciCommento.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnInserisciCommento.setBounds(626, 302, 176, 59);
		frame.getContentPane().add(btnInserisciCommento);
		
		//aggiungi commento
		btnInserisciCommento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				commenta();
			}
		});
	
		JButton btnEliminaTrascrizione = new JButton("Elimina Trascrizione");
		btnEliminaTrascrizione.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnEliminaTrascrizione.setBounds(382, 302, 176, 59);
		frame.getContentPane().add(btnEliminaTrascrizione);
		
		//elimina trascrizione
		btnEliminaTrascrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				delete();
			}
		});
		
		// log-out
		JButton log_out_button = new JButton("Log-out");
		log_out_button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		log_out_button.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(log_out_button);
		
		log_out_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ListenerEventi.changePage("Login", null);
			}
		});
		
		frame.setVisible(true);		
	}
	
	public void trascrivi(){
		JLabel label;
		JButton button,button_1,btnSalva,btnRicerca;
		JScrollPane scrollPane;
		
		frameT = new JFrame();
		frameT.getContentPane().setEnabled(false);
		frameT.setBounds(100, 100, 963, 586);
		frameT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameT.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(523, 79, 372, 397);
		frameT.getContentPane().add(scrollPane);
		
		JTextPane txtNumeroRiga = new JTextPane();
		txtNumeroRiga.setPreferredSize(new Dimension(23, 20));
		txtNumeroRiga.setDisabledTextColor(new Color(153, 102, 255));
		txtNumeroRiga.setEditable(false);
		txtNumeroRiga.setEnabled(false);
		txtNumeroRiga.setBackground(Color.LIGHT_GRAY);
		txtNumeroRiga.setText(rows);		
		scrollPane.setRowHeaderView(txtNumeroRiga);
		
		JTextPane txtCorpo = new JTextPane();
		txtCorpo.setText("");
		scrollPane.setViewportView(txtCorpo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(147, 48, 359, 437);
		frameT.getContentPane().add(scrollPane_1);
		
		label = new JLabel("");
		scrollPane_1.setViewportView(label);
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 8));		
		
		txtTitolo = new JTextField();
		txtTitolo.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		txtTitolo.setText(title);
		txtTitolo.setBounds(12, 147, 116, 30);
		frameT.getContentPane().add(txtTitolo);
		txtTitolo.setColumns(10);
		txtTitolo.addFocusListener(this);
		
		btnRicerca = new JButton("Ricerca");
		btnRicerca.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnRicerca.setBounds(12, 208, 97, 30);
		frameT.getContentPane().add(btnRicerca);	
		
		txtNumber = new JTextField();
		txtNumber.setBounds(331, 496, 33, 30);
		txtNumber.setEditable(false);
		txtNumber.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		frameT.getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		
		txtTitle = new JTextPane();
		txtTitle.setDisabledTextColor(Color.DARK_GRAY);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTitle.setText(titolo);
		txtTitle.setBounds(523, 48, 211, 20);
		frameT.getContentPane().add(txtTitle);
		txtTitle.addFocusListener(this);
		
		txtanno = new JTextPane();
		txtanno.setText(anno);
		txtanno.setBounds(744, 48, 151, 20);
		frameT.getContentPane().add(txtanno);
		txtanno.addFocusListener(this);
		
		//bottone ricerca
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Image img=ListenerEventi.getFirstImm(txtTitolo.getText());
				label.setIcon(new ImageIcon(img));	
				txtNumber.setText("1");
				Opera o=ListenerEventi.getOpera(txtTitolo.getText());
				txtTitle.setText(o.getTitolo());
				txtanno.setText(o.getAnno());
			}
		});
		
		button = new JButton("");
		button.setSelectedIcon(new ImageIcon(""));
		button.setIcon(new ImageIcon("img/indietro.png"));
		button.setBounds(277, 496, 33, 30);
		frameT.getContentPane().add(button);
		
		//immagine precedente
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String num=txtNumber.getText().toString();				
				Image img=ListenerEventi.getImm(txtTitolo.getText(),num,'-');
				if(img.equals(null)){
					//new Eccezioni("Immagine non trovata.");
				}else{
					label.setIcon(new ImageIcon(img));
					int n=Integer.parseInt(num);
					txtNumber.setText(Integer.toString(n-1));
				}
			}
		});
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("img/avanti.png"));
		button_1.setSelectedIcon(new ImageIcon(""));
		button_1.setBounds(384, 496, 33, 30);
		frameT.getContentPane().add(button_1);
		
		// Immagine successiva
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String num=txtNumber.getText();
				Image img=ListenerEventi.getImm(txtTitolo.getText(),num,'+');
				if(img.equals(null)){
					//new Eccezioni("Immagine non trovata.");
				}else{
					label.setIcon(new ImageIcon(img));
					int n=Integer.parseInt(num);
					txtNumber.setText(Integer.toString(n+1));
				}
			}
		});	
		
		//back button
		JButton button_back = new JButton("Back");
		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameT.dispose();
				initialize();
			}
		});
		
		button_back.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button_back.setBounds(12, 13, 97, 25);
		frameT.getContentPane().add(button_back);
				
		btnSalva = new JButton("Salva");
		btnSalva.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnSalva.setBounds(637, 501, 97, 25);
		frameT.getContentPane().add(btnSalva);
		
		// bottone salva
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ListenerEventi.addTrascrizione(trascrittore,txtTitle.getText(),txtanno.getText(),txtCorpo.getText(),txtNumber.getText())){
					ListenerEventi.saveTrascrizione(txtTitle.getText(),txtanno.getText(), txtNumber.getText(),txtCorpo.getText());
				}
				
			}
		});	

		frameT.setVisible(true);			
	}
	
	public void delete(){
		JTable table;
		
		frameD = new JFrame();
		frameD.setBounds(100, 100, 640, 623);
		frameD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameD.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(171, 28, 211, 170);
		frameD.getContentPane().add(label);
		
		//back button
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameD.dispose();
				initialize();
			}
		});
		
		button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button.setBounds(12, 13, 97, 25);
		frameD.getContentPane().add(button);
		
		id = new JTextField();
		id.setText(insert);
		id.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		id.setColumns(10);
		id.setBounds(35, 214, 323, 33);
		id.addFocusListener(this);
		frameD.getContentPane().add(id);

		Page = new JTextField();
		Page.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		Page.setText(page_s);
		Page.setBounds(509, 214, 67, 33);
		frameD.getContentPane().add(Page);
		Page.setColumns(10);
		Page.addFocusListener(this);
		
		JButton button_1 = new JButton("Rimuovi");
		button_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		button_1.setBounds(418, 488, 173, 56);
		frameD.getContentPane().add(button_1);
		
		//bottone elimina trascrizione
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ListenerEventi.deleteTrascrizione(trascrittore,id.getText(),Page.getText());
				frameD.dispose();
				delete();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 275, 557, 192);
		frameD.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
			
		JButton btnVisualizzaOpere = new JButton("Visualizza Opere");
		btnVisualizzaOpere.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnVisualizzaOpere.setBounds(45, 488, 173, 56);
		frameD.getContentPane().add(btnVisualizzaOpere);
		
		//visualizza opere
		btnVisualizzaOpere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel opere=ListenerEventi.getOpere();
				table.setModel(opere);
			}
		});
		
		frameD.setVisible(true);
	}
		
	public void commenta(){
		JFrame frame;
		JTable table;
		JTextField Commenti;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 615);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		Commenti = new JTextField();
		Commenti.setBounds(63, 399, 565, 57);
		frame.getContentPane().add(Commenti);
		Commenti.setColumns(10);		
		
		JButton btnInserisciCommento = new JButton("Inserisci commento");
		btnInserisciCommento.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnInserisciCommento.setBounds(407, 501, 173, 38);
		frame.getContentPane().add(btnInserisciCommento);
		
		//aggiungi commento
		btnInserisciCommento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListenerEventi.addCommento(trascrittore,Commenti.getText().toString());
				frame.dispose();
				commenta();
			}
		});		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log.png"));
		label.setBounds(611, 484, 86, 84);
		frame.getContentPane().add(label);
		
		JLabel lblInserisciIlCommento = new JLabel("Inserisci il Commento");
		lblInserisciIlCommento.setFont(new Font("Roboto Black", Font.PLAIN, 27));
		lblInserisciIlCommento.setBounds(198, 32, 291, 32);
		frame.getContentPane().add(lblInserisciIlCommento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 104, 565, 248);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//visualizza commenti
		JButton button = new JButton("Visualizza commenti");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel commenti=ListenerEventi.getCommenti(trascrittore);
				table.setModel(commenti);
				table.setRowHeight(55);
			}
		});
		
		button.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		button.setBounds(133, 501, 173, 38);
		frame.getContentPane().add(button);
		
		//back button
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initialize();
			}
		});
		
		button_1.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button_1.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(button_1);
		
		frame.setVisible(true);
	}

	
	@Override
	public void focusGained(FocusEvent arg0) {
		if(frameD.isActive()){
			if(id.hasFocus() && id.getText().toString().equals(insert)){
				this.id.setText("");
			}			
			else if(Page.hasFocus() && Page.getText().toString().equals(page_s)){
				this.Page.setText("");
			}
		}
	/*	else if(frameT.isActive()){
			if(txtTitolo.hasFocus() && txtTitolo.getText().toString().equals(title)){
				this.txtTitolo.setText("");
			}
			else if(txtTitle.hasFocus() && txtTitle.getText().toString().equals(titolo)){
				this.txtTitle.setText("");
			}
			else if(txtanno.hasFocus() && txtanno.getText().toString().equals(anno)){
				this.txtanno.setText("");
			}
	 
		}	*/
		else{	
			if(txtTitolo.hasFocus() && txtTitolo.getText().toString().equals(title))
				this.txtTitolo.setText("");				
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}

	public String getRows(int limit){
		int i;
		String rows="1";
		for(i=2;i<=limit;i++){
			rows=rows +" "+ i;
		}
		return rows;		
	}
}
