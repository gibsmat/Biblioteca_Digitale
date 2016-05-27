package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import business.model.*;
import business.implementation.*;

public class Ricerca implements MouseListener {
	JFrame frame;
	JTextField Titolo;
	JTable table;
	Connection c=new DbConnection().dbConnector();;
	UtenteBase utente=null;

	public Ricerca(UtenteBase utente) {
		this.utente=utente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 931, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(62, 0, 244, 216);
		label.setIcon(new ImageIcon("img/log2.png"));
		frame.getContentPane().add(label);
		
		JLabel lblRicerca = new JLabel("...Ricerca...");
		lblRicerca.setBounds(369, 13, 326, 122);
		lblRicerca.setForeground(Color.RED);
		lblRicerca.setFont(new Font("Roboto Black", Font.PLAIN, 57));
		lblRicerca.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(lblRicerca);
		
		Titolo = new JTextField();
		Titolo.setBounds(23, 229, 682, 22);
		Titolo.setText("Ricerca per titolo o isbn....");
		frame.getContentPane().add(Titolo);
		Titolo.setColumns(10);
		Titolo.addMouseListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 196, 444, 2);
		frame.getContentPane().add(separator);
		
		JButton RicercaButtton = new JButton("Ricerca");
		
		RicercaButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperaManagement opm=new OperaManagement();
				if(utente instanceof UtenteAvanzato){
					showOpere(opm.getOpera(Titolo.getText()));
				}else{
					showTitoli(opm.getTitle(Titolo.getText()));
				}				
			}
		});
		
		RicercaButtton.setBounds(751, 228, 97, 25);
		RicercaButtton.setForeground(Color.WHITE);
		RicercaButtton.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(RicercaButtton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 296, 764, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
			
		this.frame.setVisible(true);
	}
	
	public void close(){		
		this.frame.dispose();
	}
	

	public void showOpere(ArrayList<Opera> opere){
		
	}
	public void showTitoli(ArrayList<String> titoli){
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Titolo.setText("");		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}