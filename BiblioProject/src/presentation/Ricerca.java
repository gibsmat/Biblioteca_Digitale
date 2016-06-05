package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.TableModel;

import java.util.*;
import business.model.*;
import listener.ListenerEventi;
import business.implementation.*;

public class Ricerca implements MouseListener {
	JFrame frame;
	JTextField Titolo;
	JTable table;
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
		label.setBounds(33, 0, 260, 183);
		label.setIcon(new ImageIcon("img/log2.png"));
		frame.getContentPane().add(label);
		
		JLabel lblRicerca = new JLabel("...Ricerca...");
		lblRicerca.setBounds(434, 11, 326, 122);
		lblRicerca.setForeground(Color.RED);
		lblRicerca.setFont(new Font("Roboto Black", Font.PLAIN, 57));
		lblRicerca.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(lblRicerca);
		
		Titolo = new JTextField();
		Titolo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Titolo.setBounds(44, 251, 617, 22);
		Titolo.setText("Ricerca per titolo o isbn....");
		frame.getContentPane().add(Titolo);
		Titolo.setColumns(10);
		Titolo.addMouseListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(347, 146, 489, 2);
		frame.getContentPane().add(separator);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 296, 764, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton RicercaButtton = new JButton("Ricerca");
		RicercaButtton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RicercaButtton.setBounds(727, 243, 109, 32);
		frame.getContentPane().add(RicercaButtton);
		
		JTextField txtOppure = new JTextField();
		txtOppure.setBorder(null);
		txtOppure.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtOppure.setEditable(false);
		txtOppure.setText("oppure");
		txtOppure.setBounds(219, 207, 86, 20);
		frame.getContentPane().add(txtOppure);
		txtOppure.setColumns(10);
		
		JButton btnAll = new JButton("Visualizza tutto");
		btnAll.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAll.setBounds(43, 183, 158, 44);
		frame.getContentPane().add(btnAll);
		
		//visualizza tutto
		btnAll.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			TableModel tm=ListenerEventi.getOpere();
			table.setModel(tm);
			}
		});
		
		RicercaButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel tm=ListenerEventi.getOperaModel(Titolo.getText());
				table.setModel(tm);
			}
		});
		
		//back button
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		backButton.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListenerEventi.changePage("UserPage", utente);
			}
		});
							
		frame.setVisible(true);
	}
	
	public void close(){		
		this.frame.dispose();
	}

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(Titolo.getText().equals("Ricerca per titolo o isbn....")){
			Titolo.setText("");	
		}
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