/**
 * 
 */
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
import javax.swing.JTextPane;
import javax.swing.table.TableModel;

import business.model.RevisoreTrascrizioni;
import business.model.Utente;
import listener.ListenerEventi;

// TODO: Auto-generated Javadoc
/**
 * The Class RevisoreT_Gui.
 *
 * @author antony
 */
public class RevisoreT_Gui implements FocusListener {
	
	/** The rev t. */
	RevisoreTrascrizioni revT=null;
	
	/** The title s. */
	final String titleS="titolo/isbn..";
	
	/** The txt number. */
	JTextField textField,txtNumber;
	
	
	/**
	 * Instantiates a new revisore t_ gui.
	 *
	 * @param utente the utente
	 */
	public RevisoreT_Gui(Utente utente){
		this.revT=(RevisoreTrascrizioni)utente;
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	public void initialize(){
		JFrame frame;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 927, 561);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(210, 37, 235, 212);
		frame.getContentPane().add(label);
		
		JLabel lblWelcomeTranscriber = new JLabel("Welcome Revisore!");
		lblWelcomeTranscriber.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblWelcomeTranscriber.setBounds(438, 131, 436, 59);
		frame.getContentPane().add(lblWelcomeTranscriber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(175, 247, 542, 2);
		frame.getContentPane().add(separator);
		
		// Visualizza opere
		JButton button = new JButton("Visualizza opere");
		button.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		button.setBounds(161, 295, 176, 59);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AcquisitoreGui().viewOpere();
			}
		});
		
		//Aggiungi commento
		JButton button_1 = new JButton("Aggiungi commento");
		button_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		button_1.setBounds(526, 295, 176, 59);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				commenta();
			}
		});
		
		
		// Visualizza trascrizione 
		JButton btnVisualizzaTrascrizione = new JButton("Visualizza Trascrizione");
		btnVisualizzaTrascrizione.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnVisualizzaTrascrizione.setBounds(320, 419, 229, 59);
		frame.getContentPane().add(btnVisualizzaTrascrizione);
		btnVisualizzaTrascrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				viewTrascrizione();
			}
		});
		
		// Log-out button
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
	 * Commenta.
	 */
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
				ListenerEventi.addCommento(revT,Commenti.getText().toString());
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
				TableModel commenti=ListenerEventi.getCommenti(revT);
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
	
	/**
	 * View trascrizione.
	 */
	public void viewTrascrizione(){
		JFrame frame;
		
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
		textField.setText(titleS);
		textField.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(12, 128, 124, 22);
		textField.addFocusListener(this);
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
				Image img=ListenerEventi.getFirstImm(textField.getText(),333,520);
				if(img!=null){
					label.setIcon(new ImageIcon(img));
					txtNumber.setText("1");
					String testo=ListenerEventi.getTrascrizione(revT,textField.getText(),txtNumber.getText());
					if(testo!=null){
						textPane.setText(testo);
					}else
						textPane.setText("<br><br> <h1> Trascrizione non presente </h1>");				
				}				
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
				if(!(num.equals(""))){
					Image imm=ListenerEventi.getImm(textField.getText(),num,'+',333,520);
					int n=Integer.parseInt(num);
					if(imm==null){
						label.setIcon(null);
						txtNumber.setText(Integer.toString(n+1));
					}else{
						label.setIcon(new ImageIcon(imm));
						txtNumber.setText(Integer.toString(n+1));
						String testo=ListenerEventi.getTrascrizione(revT,textField.getText(),txtNumber.getText());
						if(testo!=null){
							textPane.setText(testo);
						}else
							textPane.setText("<br><br> <h1> Trascrizione non presente </h1>");
					}
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
				if(!(num.equals(""))){
					Image imm=ListenerEventi.getImm(textField.getText(),num,'-',333,520);
					int n=Integer.parseInt(num);
					if(imm==null){
						label.setIcon(null);
						txtNumber.setText(Integer.toString(n-1));
					}else{
						label.setIcon(new ImageIcon(imm));						
						txtNumber.setText(Integer.toString(n-1));
						String testo=ListenerEventi.getTrascrizione(revT,textField.getText(),txtNumber.getText());
						if(testo!=null){
							textPane.setText(testo);
						}else
							textPane.setText("<br><br> <h1> Trascrizione non presente </h1>");
					}
				}
			}
		});		
		
		// Approva trascrizione
		JButton btnApprova = new JButton("Approva");
		btnApprova.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApprova.setBounds(679, 563, 134, 30);
		frame.getContentPane().add(btnApprova);
		btnApprova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListenerEventi.approvaTras(revT,textField.getText(),txtNumber.getText());
				//btnApprova.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Trascrizione approvata.");
			}
		});		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("img/log.png"));
		label_1.setBounds(30, 27, 58, 56);
		frame.getContentPane().add(label_1);
		
		//back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initialize();
			}
		});
				
		backButton.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		backButton.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(backButton);

		frame.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent arg0) {
		if(textField.hasFocus() && textField.getText().equals(titleS)){
			textField.setText("");
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
