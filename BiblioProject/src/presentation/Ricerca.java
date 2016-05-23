package presentation;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;

public class Ricerca {
	JFrame frame;
	JTextField txtRicercaIlTuo;
	Connection c=null;

	public Ricerca(Connection c) {
		this.c=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 931, 779);
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
		
		txtRicercaIlTuo = new JTextField();
		txtRicercaIlTuo.setBounds(23, 229, 682, 22);
		txtRicercaIlTuo.setText("Ricerca il tuo libro....");
		frame.getContentPane().add(txtRicercaIlTuo);
		txtRicercaIlTuo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 196, 444, 2);
		frame.getContentPane().add(separator);
		
		JButton RicercaButtton = new JButton("Ricerca");
		RicercaButtton.setBounds(751, 228, 97, 25);
		RicercaButtton.setForeground(Color.WHITE);
		RicercaButtton.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(RicercaButtton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 282, 745, 421);
		frame.getContentPane().add(scrollPane);
	
		this.frame.setVisible(true);
	}
}