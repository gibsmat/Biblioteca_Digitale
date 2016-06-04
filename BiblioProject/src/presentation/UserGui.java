/**
 * 
 */
package presentation;

import business.model.*;
import listener.ListenerEventi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

/**
 * @author antony
 *
 */
public class UserGui implements FocusListener {
	JFrame frame;
	JTextField textField,txtNumber;
	UtenteBase utente;
	final String titleS="Titolo/isbn";
	
	public UserGui(UtenteBase utente){
		this.utente=utente;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(utente instanceof UtenteAvanzato){
			
			frame = new JFrame();
			frame.setBounds(100, 100, 646, 506);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("img/log2.png"));
			label.setBounds(194, 13, 235, 212);
			frame.getContentPane().add(label);
			
			JButton btnPaginaPer = new JButton("Pagina Personale");
			btnPaginaPer.setFont(new Font("Roboto Black", Font.PLAIN, 19));
			btnPaginaPer.setForeground(new Color(255, 255, 255));
			btnPaginaPer.setBackground(new Color(0, 0, 255));
			
			//Bottone pagina personale
			btnPaginaPer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {				
					close();
					ListenerEventi.changePage("PersonalPage", utente);				
				}
			});
			
			btnPaginaPer.setBounds(181, 370, 214, 58);
			frame.getContentPane().add(btnPaginaPer);
			
			JButton btnElencoOpere = new JButton("Elenco opere");
			btnElencoOpere.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					//elenco opere nel db
				}
			});
			btnElencoOpere.setFont(new Font("Roboto Black", Font.PLAIN, 16));
			btnElencoOpere.setBounds(45, 270, 199, 59);
			frame.getContentPane().add(btnElencoOpere);
			
			JButton btnVisualizzaOpera = new JButton("Visualizza Opera");
			btnVisualizzaOpera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					viewOpera();
				}
			});
			btnVisualizzaOpera.setFont(new Font("Roboto Black", Font.PLAIN, 16));
			btnVisualizzaOpera.setBounds(350, 270, 199, 59);
			frame.getContentPane().add(btnVisualizzaOpera);
			
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
		
		else{
			
			frame = new JFrame();
			frame.setBounds(100, 100, 963, 586);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("img/log2.png"));
			label.setBounds(130, -24, 398, 266);
			frame.getContentPane().add(label);
			
			JLabel lblBenvenuto = new JLabel("Tutta la cultura a portata di click...");
			lblBenvenuto.setFont(new Font("Roboto Black", Font.PLAIN, 29));
			lblBenvenuto.setBounds(364, 56, 506, 108);
			frame.getContentPane().add(lblBenvenuto);
			
			JButton btnPaginaPer = new JButton("Pagina Personale");
			btnPaginaPer.setFont(new Font("Roboto Black", Font.PLAIN, 19));
			btnPaginaPer.setForeground(new Color(255, 255, 255));
			btnPaginaPer.setBackground(new Color(0, 0, 255));
			
			//Bottone pagina personale
			btnPaginaPer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {				
					close();
					ListenerEventi.changePage("PersonalPage", utente);				
				}
			});
			
			btnPaginaPer.setBounds(192, 348, 214, 58);
			frame.getContentPane().add(btnPaginaPer);
			
			JButton Ricerca = new JButton("Ricerca");
			Ricerca.setFont(new Font("Tahoma", Font.PLAIN, 19));
			Ricerca.setForeground(new Color(0, 0, 255));
			Ricerca.setBackground(new Color(255, 255, 255));
			Ricerca.setBounds(504, 347, 228, 59);
			
			//Bottone ricerca
			Ricerca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {				
					close();
					ListenerEventi.changePage("Ricerca", utente);
				}
			});
			
			frame.getContentPane().add(Ricerca);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(173, 187, 591, 2);
			frame.getContentPane().add(separator);
			
			JLabel lblBenvenuto_1 = new JLabel("Benvenuto");
			lblBenvenuto_1.setFont(new Font("Roboto Black", Font.ITALIC, 33));
			lblBenvenuto_1.setBounds(270, 199, 368, 68);
			frame.getContentPane().add(lblBenvenuto_1);		
			
			JLabel lblUsername = new JLabel(utente.getUserId());
			lblUsername.setForeground(new Color(105, 105, 105));
			lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 26));
			lblUsername.setBounds(482, 215, 228, 41);
			frame.getContentPane().add(lblUsername);	
			
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
	
			this.frame.setVisible(true);
		}
	}
	   //query... che restuisce il testo della trascrizione
/*		
		try {
			//file � il risutlato della query 
		      file = new FileOutputStream("file.html");
		      PrintStream Output = new PrintStream(file);
		      
		      Output.println(t1);
		      Output.close();
		      
		      System.out.println(t1);
		  
		    } catch (Exception e) {
		      System.out.println("Errore: " + e);
		      System.exit(1);
		    }
*/		
	public void viewOpera(){
		
		frame = new JFrame();
		frame.setBounds(100, 100, 897, 642);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(494, 27, 377, 525);
		frame.getContentPane().add(scrollPane_1);
	
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		textPane.setText("");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 27, 336, 525);
		frame.getContentPane().add(scrollPane);

		JLabel label = new JLabel("");
		scrollPane.setViewportView(label);
		
		textField = new JTextField();
		textField.setText("");
		textField.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(12, 128, 124, 22);
		frame.getContentPane().add(textField);
		
		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtNumber.setColumns(10);
		txtNumber.setBounds(289, 563, 33, 30);
		frame.getContentPane().add(txtNumber);
		
		JButton button = new JButton("Ricerca");
		button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button.setBounds(23, 190, 97, 25);
		frame.getContentPane().add(button);
		
		//bottone ricerca opera
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstImm=ListenerEventi.getFirstImm(textField.getText());
				label.setIcon(new ImageIcon(firstImm));
				txtNumber.setText("1");
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("img/avanti.png"));
		button_1.setBounds(352, 563, 41, 30);
		frame.getContentPane().add(button_1);
		
		//immagine successiva
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=txtNumber.getText();
				String pathIP=ListenerEventi.getImm(textField.getText(),num,'+');
				if(pathIP.equals("")){
					//new Eccezioni("Immagine non trovata.");
				}else{
					label.setIcon(new ImageIcon(pathIP));
					int n=Integer.parseInt(num);
					txtNumber.setText(Integer.toString(n+1));
				}
			}
		});
		
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("img/indietro.png"));
		button_2.setBounds(220, 563, 41, 30);
		frame.getContentPane().add(button_2);
		
		//immagine precedente
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=txtNumber.getText().toString();				
				String pathIP=ListenerEventi.getImm(textField.getText(),num,'-');
				if(pathIP.equals("")){
					//new Eccezioni("Immagine non trovata.");
				}else{
					label.setIcon(new ImageIcon(pathIP));
					int n=Integer.parseInt(num);
					txtNumber.setText(Integer.toString(n-1));
				}
			}
		});		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("img/log.png"));
		label_1.setBounds(30, 27, 58, 56);
		frame.getContentPane().add(label_1);

		frame.setVisible(true);
	}
	
	public void close(){		
		this.frame.dispose();
	}
	
	
	@Override
	public void focusGained(FocusEvent arg0) {
		if(textField.hasFocus() && textField.getText().equals(titleS)){
			textField.setText("");
		}		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}