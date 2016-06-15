package presentation;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;
import business.model.*;
import listener.ListenerEventi;
// TODO: Auto-generated Javadoc

/**
 * The Class AcquisitoreGui.
 *
 * @author antony
 */
public class AcquisitoreGui extends JFrame implements FocusListener{
	
	/** The acquisitore. */
	Acquisitore acquisitore=null;
	
	/** The frame. */
	JFrame frame;
	
	/** The frame d. */
	JFrame frameD = new JFrame();
	
	/** The table. */
	JTable table;
	
	/** The Page1. */
	JTextField txtInserisciIlTitolo,Id,Page,id,Page1;
	
	/** The insert. */
	final String insert="Inserisci il titolo o l'isbn dell'opera";
	
	/** The page_st. */
	final String page_st = "Page";
	
	/** The x. */
	JFileChooser x;

	/**
	 * Instantiates a new acquisitore gui.
	 */
	public AcquisitoreGui(){
	}
	
	/**
	 * Instantiates a new acquisitore gui.
	 *
	 * @param a the acquisitore
	 */
	public AcquisitoreGui(Utente a){
		this.acquisitore=(Acquisitore)a;
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(176, 26, 235, 212);
		frame.getContentPane().add(label);
		
		JLabel lblWelcom = new JLabel("Welcome !!!");
		lblWelcom.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblWelcom.setBounds(440, 113, 436, 59);
		frame.getContentPane().add(lblWelcom);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(166, 236, 542, 2);
		frame.getContentPane().add(separator);
		
		//aggiungi immagini
		JButton btnAggiungiImmagine = new JButton("Aggiungi immagine");
		btnAggiungiImmagine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				addImmagini();
			}
		});
		btnAggiungiImmagine.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnAggiungiImmagine.setBounds(142, 315, 176, 59);
		frame.getContentPane().add(btnAggiungiImmagine);
		
		//commenti
		JButton btnAggiungiCommento = new JButton("Aggiungi commento");
		btnAggiungiCommento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				commenta();
			}
		});
		btnAggiungiCommento.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnAggiungiCommento.setBounds(499, 315, 176, 59);
		frame.getContentPane().add(btnAggiungiCommento);
		
		//nuova opera
		JButton btnAggiungiOpera = new JButton("Aggiungi Opera");
		btnAggiungiOpera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				newOpera();
			}
		});
		btnAggiungiOpera.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnAggiungiOpera.setBounds(142, 419, 176, 59);
		frame.getContentPane().add(btnAggiungiOpera);
		
		//elimina immagine
		JButton btnEliminaImagine = new JButton("Elimina Immagine");
		btnEliminaImagine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				deleteImmagini();
			}
		});
		btnEliminaImagine.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnEliminaImagine.setBounds(499, 419, 176, 59);
		frame.getContentPane().add(btnEliminaImagine);
		
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
	
	/**
	 * Adds the immagini.
	 */
	private void addImmagini(){
		JFrame frame;
		JTextField path;
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Roboto Black", Font.PLAIN, 18));
		frame.setBounds(100, 100, 605, 499);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBrowser = new JButton("Browser");
		btnBrowser.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		
		path = new JTextField();
		path.setBounds(207, 315, 324, 33);
		frame.getContentPane().add(path);
		path.setColumns(10);
		
		btnBrowser.addActionListener(new ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {				
				x= new JFileChooser();				
				if(x.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
					path.setText(x.getSelectedFile().getName());
				}
			}
		});
		
		btnBrowser.setBounds(84, 319, 97, 25);
		frame.getContentPane().add(btnBrowser);
	
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(61, 23, 218, 161);
		frame.getContentPane().add(label);
		
		JLabel lblBenvenutoAcquisitore = new JLabel("Benvenuto Acquisitore!!");
		lblBenvenutoAcquisitore.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblBenvenutoAcquisitore.setBounds(319, 104, 324, 41);
		frame.getContentPane().add(lblBenvenutoAcquisitore);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(146, 197, 306, 2);
		frame.getContentPane().add(separator);

		Page = new JTextField();
		Page.setText(page_st);
		Page.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		Page.setColumns(10);
		Page.setBounds(457, 225, 67, 33);
		frame.getContentPane().add(Page);
		Page.addFocusListener(this);

		Id = new JTextField();
		Id.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		Id.setText(insert);
		Id.setBounds(69, 225, 323, 33);
		frame.getContentPane().add(Id);
		Id.setColumns(10);
		Id.addFocusListener(this);
		
		JLabel lblSelezionaLimmmagineDa = new JLabel("Seleziona l'imagine da caricare");
		lblSelezionaLimmmagineDa.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSelezionaLimmmagineDa.setBounds(251, 286, 365, 26);
		frame.getContentPane().add(lblSelezionaLimmmagineDa);
		
		JButton btnCarica = new JButton("Carica");
		
		// Carica immagine
		btnCarica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ListenerEventi.addImmagine(path.getText(),Id.getText(),Page.getText())){
					ListenerEventi.saveImage(x.getSelectedFile(),Id.getText());
				}
				frame.dispose();
				addImmagini();				
			}
		});
		
		btnCarica.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnCarica.setBounds(360, 386, 171, 41);
		frame.getContentPane().add(btnCarica);
		
		JButton btnVisualizzaOpere = new JButton("Visualizza opere");
		btnVisualizzaOpere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOpere();
			}
		});
		btnVisualizzaOpere.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnVisualizzaOpere.setBounds(75, 386, 171, 41);
		frame.getContentPane().add(btnVisualizzaOpere);
		
		//back button
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initialize();
			}
		});
		
		button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		button.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(button);
		
		
		frame.setVisible(true);
		
	}
	
	/**
	 * View opere.
	 */
	public void viewOpere(){
		JFrame frame2;
		TableModel model=ListenerEventi.getOpere();
		
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 920, 811);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(new MigLayout("", "[343px][2px][][480px]", "[57px][76px][496px][47px]"));
		
		JLabel lblVisualizzaLeOpere = new JLabel("Visualizza le opere!!");
		lblVisualizzaLeOpere.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		frame2.getContentPane().add(lblVisualizzaLeOpere, "cell 3 1,alignx center");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame2.getContentPane().add(scrollPane_1, "cell 0 2 4 1,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		frame2.getContentPane().add(label, "cell 0 0 1 2,alignx center,aligny center");		
		
		
		frame2.setVisible(true);		
	}				

	/**
	 * New opera.
	 */
	private void newOpera(){
		JFrame frame;
		 JTextField Titolo;
		 JTextField Anno;
		 JTextField Autore;
		 JTextField Editore;
		 JTextField ISBN;
		 
		 	frame = new JFrame();
			frame.setBounds(100, 100, 499, 672);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			//back button
			JButton button = new JButton("Back");
			button.setFont(new Font("Roboto Black", Font.PLAIN, 14));
			button.setBounds(12, 13, 97, 25);
			frame.getContentPane().add(button);			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					initialize();
				}
			});
			
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("img/log2.png"));
			label.setBounds(207, 13, 217, 161);
			frame.getContentPane().add(label);
			
			JLabel lblTitolo = new JLabel("* Titolo :");
			lblTitolo.setFont(new Font("Roboto Black", Font.PLAIN,26));
			lblTitolo.setBounds(12, 206, 160, 38);
			frame.getContentPane().add(lblTitolo);
			
			JLabel lblAnno = new JLabel("Anno :");
			lblAnno.setFont(new Font("Roboto Black", Font.PLAIN, 28));
			lblAnno.setBounds(12, 281, 160, 38);
			frame.getContentPane().add(lblAnno);
			
			JLabel lblAutore = new JLabel("Autore :");
			lblAutore.setFont(new Font("Roboto Black", Font.PLAIN, 28));
			lblAutore.setBounds(12, 358, 160, 38);
			frame.getContentPane().add(lblAutore);
			
			JLabel lblEditore = new JLabel("Editore :");
			lblEditore.setFont(new Font("Roboto Black", Font.PLAIN, 28));
			lblEditore.setBounds(12, 434, 160, 38);
			frame.getContentPane().add(lblEditore);
			
			JLabel lblCodiceIsbn = new JLabel("* Codice ISBN :");
			lblCodiceIsbn.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblCodiceIsbn.setBounds(12, 510, 211, 38);
			frame.getContentPane().add(lblCodiceIsbn);
			
			Titolo = new JTextField();
			Titolo.setColumns(10);
			Titolo.setBounds(189, 206, 211, 38);
			frame.getContentPane().add(Titolo);
			
			Anno = new JTextField();
			Anno.setColumns(10);
			Anno.setBounds(189, 281, 211, 38);
			frame.getContentPane().add(Anno);
			
			Autore = new JTextField();
			Autore.setColumns(10);
			Autore.setBounds(189, 358, 211, 38);
			frame.getContentPane().add(Autore);
			
			Editore = new JTextField();
			Editore.setColumns(10);
			Editore.setBounds(189, 434, 211, 38);
			frame.getContentPane().add(Editore);
			
			ISBN = new JTextField();
			ISBN.setColumns(10);
			ISBN.setBounds(189, 510, 211, 38);
			frame.getContentPane().add(ISBN);			
			
			JButton button_1 = new JButton("Aggiungi");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					ListenerEventi.addOpera(Titolo.getText(),Anno.getText(),Autore.getText(),Editore.getText(),ISBN.getText());
					newOpera();
				}
			});
			button_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
			button_1.setBounds(157, 573, 160, 50);
			frame.getContentPane().add(button_1);			
			
			frame.setVisible(true);
	}

	/**
	 * Delete immagini.
	 */
	private void deleteImmagini(){
		JTable table;
		
		frameD=new JFrame();
		frameD.setBounds(100, 100, 640, 623);
		frameD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameD.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/log2.png"));
		label.setBounds(171, 28, 211, 170);
		frameD.getContentPane().add(label);
		
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
		id.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		id.setColumns(10);
		id.setBounds(35, 214, 323, 33);
		frameD.getContentPane().add(id);
		id.addFocusListener(this);

		Page1 = new JTextField();
		Page1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		Page1.setText(page_st);
		Page1.setBounds(509, 214, 67, 33);
		frameD.getContentPane().add(Page1);
		Page1.setColumns(10);
		Page1.addFocusListener(this);
		
		JButton button_1 = new JButton("Rimuovi");
		button_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		button_1.setBounds(418, 488, 173, 56);
		frameD.getContentPane().add(button_1);
	
		// Rimuovi immagine
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListenerEventi.deleteImmagine(id.getText(),Page1.getText());
				frameD.dispose();
				deleteImmagini();	
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
				ListenerEventi.addCommento(acquisitore,Commenti.getText().toString());
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
				TableModel commenti=ListenerEventi.getCommenti(acquisitore);
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
		if(frameD.isActive()){
			if(id.hasFocus() && id.getText().toString().equals(insert)){
				this.id.setText("");
			}			
			else if(Page1.hasFocus() && Page1.getText().toString().equals(page_st)){
				this.Page1.setText("");
			}
		}
		else{	
			if(Id.hasFocus() && Id.getText().toString().equals(insert)){
				this.Id.setText("");	
			}			
			else if(Page.hasFocus() && Page.getText().toString().equals(page_st)){
				this.Page.setText("");
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent arg0) {	
	}


} 
