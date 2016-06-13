package presentation;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import business.model.RevisoreImmagine;
import business.model.Utente;
import listener.ListenerEventi;
import net.miginfocom.swing.MigLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class RevisoreI_Gui.
 *
 * @author antony
 */
public class RevisoreI_Gui implements FocusListener{
	
	/** The rev i. */
	RevisoreImmagine revI = null;
	
	/** The txt titolo. */
	JTextField txtTitolo;
	
	/** The titolo. */
	final String TITOLO="Titolo/isbn..";
	
	/** The width. */
	final int WIDTH=559;
	
	/** The height. */
	final int HEIGHT=477;
	
	/**
	 * Instantiates a new revisore i_ gui.
	 *
	 * @param utente the utente
	 */
	public RevisoreI_Gui(Utente utente){
		this.revI=(RevisoreImmagine)utente;
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	private void initialize(){
		JFrame frame;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 917, 590);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(185, 27, 235, 212);
		frame.getContentPane().add(label);
		
		JLabel lblWelcom = new JLabel("Benvenuto Revisore!");
		lblWelcom.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblWelcom.setBounds(432, 122, 436, 59);
		frame.getContentPane().add(lblWelcom);
		
		//commenti
		JButton button = new JButton("Aggiungi commento");
		button.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		button.setBounds(519, 300, 176, 59);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				commenta();
			}
		});
		
		
		//visualizza opere
		JButton btnVisualizzaOpere = new JButton("Visualizza opere");
		btnVisualizzaOpere.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnVisualizzaOpere.setBounds(148, 300, 176, 59);
		frame.getContentPane().add(btnVisualizzaOpere);
		
		btnVisualizzaOpere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AcquisitoreGui().viewOpere();
			}
		});		
		
		//visualizza immagini
		JButton btnVisualizzaImmagine = new JButton("Visualizza Immagine");
		btnVisualizzaImmagine.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnVisualizzaImmagine.setBounds(326, 432, 206, 59);
		frame.getContentPane().add(btnVisualizzaImmagine);
		
		btnVisualizzaImmagine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				viewImm();
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(148, 252, 542, 2);
		frame.getContentPane().add(separator);
		
		
		//log-out
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
	
	/**
	 * View imm.
	 */
	private void viewImm(){
		JFrame frame;
		JTextField txtNumber;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 591);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel();
		label.setBounds(240, 13, 559, 477);
		frame.getContentPane().add(label);
				
		JButton button = new JButton();
		button.setIcon(new ImageIcon("img/indietro.png"));
		button.setBounds(319, 501, 39, 30);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon("img/log2.png"));
		label_1.setBounds(31, 23, 211, 141);
		frame.getContentPane().add(label_1);
		
		txtTitolo = new JTextField();
		txtTitolo.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		txtTitolo.setText(TITOLO);
		txtTitolo.setBounds(45, 222, 172, 22);
		frame.getContentPane().add(txtTitolo);
		txtTitolo.setColumns(10);
		txtTitolo.addFocusListener(this);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(381, 501, 33, 30);
		txtNumber.setEditable(false);
		txtNumber.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		frame.getContentPane().add(txtNumber);
		txtNumber.setColumns(10);		

		//bottone Ricerca
		JButton button_2 = new JButton("Ricerca");
		button_2.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button_2.setBounds(81, 282, 97, 25);
		frame.getContentPane().add(button_2);		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image img=ListenerEventi.getFirstImm(txtTitolo.getText(),WIDTH,HEIGHT);
				if(img!= null){
					label.setIcon(new ImageIcon(img));	
					txtNumber.setText("1");
				}
			}
		});
		
		//Immagine precedente
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=txtNumber.getText();				
				Image img=ListenerEventi.getImm(txtTitolo.getText(),num,'-',WIDTH,HEIGHT);
				int n=Integer.parseInt(num);
				if(img==null){
					label.setIcon(null);
					txtNumber.setText(Integer.toString(n-1));
				}else{
					label.setIcon(new ImageIcon(img));
					txtNumber.setText(Integer.toString(n-1));
				}
			}
		});		
		
		//Immagine successiva
		JButton button_1 = new JButton();
		button_1.setIcon(new ImageIcon("img/avanti.png"));
		button_1.setBounds(434, 501, 39, 30);
		frame.getContentPane().add(button_1);		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=txtNumber.getText();
				Image img=ListenerEventi.getImm(txtTitolo.getText(),num,'+',WIDTH,HEIGHT);
				int n=Integer.parseInt(num);
				if(img==null){
					label.setIcon(null);
					txtNumber.setText(Integer.toString(n+1));
				}else{
					label.setIcon(new ImageIcon(img));
					
					txtNumber.setText(Integer.toString(n+1));
				}
			}
		});
		
		// Approva immagine
		JButton btnApprova = new JButton("Approva");
		btnApprova.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApprova.setBounds(600, 501, 140, 34);
		frame.getContentPane().add(btnApprova);
		btnApprova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListenerEventi.approvaImm(revI,txtTitolo.getText(),txtNumber.getText());
				//btnApprova.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Immagine approvata.");
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
				initialize();
			}
		});
		
		frame.setVisible(true);
	}

	/**
	 * Commenta.
	 */
	private void commenta(){
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
				ListenerEventi.addCommento(revI,Commenti.getText().toString());
				frame.dispose();
				initialize();
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
				TableModel commenti=ListenerEventi.getCommenti(revI);
				table.setModel(commenti);
				table.setRowHeight(55);
			}
		});
		
		button.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		button.setBounds(133, 501, 173, 38);
		frame.getContentPane().add(button);
		
		//back
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
	
	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent arg0) {
		if(txtTitolo.hasFocus() && txtTitolo.getText().equals(TITOLO)){
			txtTitolo.setText("");
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
