/**
 * 
 */
package listener;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.TableModel;

import business.Eccezioni;
import business.implementation.*;
import business.model.*;
import presentation.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ListenerEventi.
 *
 * @author antony
 */

public class ListenerEventi {
	
	/** The Constant INSERT. */
	final static String INSERT="Inserisci il titolo o l'isbn dell'opera";
	
	/** The Constant PAGE. */
	final static String PAGE = "Page";
	
	/** The Constant WIDTH. */
	final static int WIDTH = 333;
	
	/** The Constant HEIGHT. */
	final static int HEIGHT = 520;

	/**
	 * Instantiates a new listener eventi.
	 */
	public ListenerEventi(){		
	}	
	
	/**
	 * Change page.
	 *
	 * @param page the page
	 * @param utente the utente
	 */
	public static void changePage(String page,Utente utente){
		switch(page){
		
		case "Registrazione":
			new Registrazione();
			break;
			
		case "Login" :
			new Login();
			break;
			
		case "Admin":
			new AdminGui();
			break;
			
		case "Acquisitore":
			new AcquisitoreGui(utente);
			break;
			
		case "Trascrittore":
			new TrascrittoreGui(utente);
			break;
			
		case "Revisore Immagini":
			new RevisoreI_Gui(utente);
			break;
			
		case "Revisore Trascrizioni":
			new RevisoreT_Gui(utente);
			break;
			
		case "PersonalPage":
			if(utente instanceof UtenteAvanzato){
				new PersonalGui((UtenteAvanzato)utente);
				break;
			}else{
				new PersonalGui((UtenteBase)utente);
				break;
			}
			
		case "UserPage":
			if(utente instanceof UtenteAvanzato){
				new UserGui((UtenteAvanzato)utente);
				break;
			}else{
				new UserGui((UtenteBase)utente);
				break;
			}
			
		case "Ricerca":
			if(utente instanceof UtenteAvanzato){
				new Ricerca((UtenteAvanzato)utente);
				break;
			}else{
				new Ricerca((UtenteBase)utente);
				break;
			}
			
		default:
			new Eccezioni("Pagina non presente.");
			break;
		}
	}
	
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param psw the psw
	 */
	public static void login(String username,JPasswordField psw){

		if(username.equals("") || psw.getPassword().length == 0){					
			new Eccezioni("Inserire password e username!");
			 changePage("Login",null); 
		}
		else if(username.equals("ADMIN") && psw.getText().equals("ADMIN")){		
			changePage("Admin",null);
		}
		else{ 
			Utente utente = new UserManagement().getUtente(username, psw);	//get utente dal db
			
			if(utente instanceof UtenteAvanzato){
				changePage("UserPage",(UtenteAvanzato)utente);
			}
			else if(utente instanceof UtenteBase){
				changePage("UserPage",(UtenteBase)utente);
			}
			else if(utente instanceof Trascrittore){
				changePage("Trascrittore",utente);
			}
			else if(utente instanceof Acquisitore){
				changePage("Acquisitore",utente);
			}
			else if(utente instanceof RevisoreTrascrizioni){
				changePage("Revisore Trascrizioni",utente);
			}
			else if(utente instanceof RevisoreImmagine){
				changePage("Revisore Immagini",utente);
			}
			else{
				new Eccezioni("Username e password non validi.");
				changePage("Login",null);
			}	
		}
	}

	/**
	 * Adds the utente.
	 *
	 * @param admin the admin
	 * @param type the type
	 * @param Username the username
	 * @param Password the password
	 * @param nome the nome
	 * @param cognome the cognome
	 */
	public static void addUtente(Admin admin,String type,String Username,String Password,String nome,String cognome){
		switch (type) {
			case "Trascrittore":
				admin.addTrascrittore(Username, Password, nome, cognome);				
				break;
			case "Acquisitore":
				admin.addAcquisitore(Username, Password, nome, cognome);
				break;
			case "Revisore Immagini" :
				admin.addRevisoreImm(Username, Password, nome, cognome);
				break;
			case "Revisore Trascrizioni" :
				admin.addRevisoreTr(Username, Password, nome, cognome);
				break;
			default:
				new Eccezioni("Errore aggiunta utente");
				break;
		}
	}
	
	/**
	 * Delete opera.
	 *
	 * @param admin the admin
	 * @param cod the cod
	 * @return true, if successful
	 */
	public static boolean deleteOpera(Admin admin,String cod){
		if(cod.equals("")){
			new Eccezioni("Codice isbn non può essere vuoto!");
			return false;
		}else{
			Opera op=getOpera(cod);
			admin.clearOpera(cod);
			deleteDir(new File("img/"+op.getTitolo()));
			deleteDir(new File("trascrizioni/"+op.getTitolo()));
			changePage("Admin",null);
			return true;
		}
	}
	
	/**
	 * Delete directory/
	 * 
	 * @param file
	 */
	public static void deleteDir(File file){
		File[]temp= file.listFiles();
		if(temp != null){
			for(File f : temp){
				deleteDir(f);
			}
		}
		file.delete();
	}

	/**
	 * Delete utente.
	 *
	 * @param admin the admin
	 * @param type the type
	 * @param nome the nome
	 */
	public static void deleteUtente(Admin admin,String type,String nome){
		if(nome.equals("")){
			new Eccezioni("Inserire l'username");
		}
		else{
			switch (type) {
			case "Utente Base":
				admin.clearUtente(nome);				
				break;
			case "Utente Avanzato":
				admin.clearUtente(nome);					
				break;
			case "Trascrittore":
				admin.clearTrascrittore(nome);			
				break;
			case "Acquisitore":
				admin.clearAcquisitore(nome);
				break;
			case "Revisore Immagini" :
				admin.clearRevisoreImm(nome);
				break;
			case "Revisore Trascrizioni" :
				admin.clearRevisoreTr(nome);
				break;
			default:
				new Eccezioni("Errore nella cancellazione dell'utente");
				break;
			}
		changePage("Admin",null);
		}
	}
	
	/**
	 * Sets the utente.
	 *
	 * @param utente the utente
	 * @param username the username
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param password the password
	 * @return true, if successful
	 */
	public static boolean setUtente(UtenteBase utente,String username,String nome,String cognome,String password){
		if(username.equals("") || password.equals("")){
			new Eccezioni("Username e password non possono essere lasciati vuoti.");
			return false;
		}
		return new UserManagement().setUtente(utente,username,nome,cognome,password);
	}
	
	/**
	 * Registrati.
	 *
	 * @param username the username
	 * @param psw the psw
	 * @param type the type
	 * @param nome the nome
	 * @param cognome the cognome
	 */
	public static void registrati(String username,JPasswordField psw,String type,String nome,String cognome){
	
		if(username.equals("") || psw.getPassword().length == 0){
			new Eccezioni("I campi username e password sono obbligatori!");	
			changePage("Registrazione",null);
		}
		else if(psw.getText().length() < 5){
			new Eccezioni("La password deve contenere almeno 5 caratteri.");			 
			changePage("Registrazione",null);
		}
		else if(username.equals("ADMIN")){
			new Eccezioni("Username non disponibile.");			 
			changePage("Registrazione",null);
		}
		else{											
			if(type.equals("Utente Base")){	
				//creazione utente base
				if(new UserManagement().nuovoUtente(username,nome,cognome,psw.getText()))
				{
					JOptionPane.showMessageDialog(null, "Registrazione effettuata.");					
					changePage("Login",null);
				}
				else{					
					changePage("Registrazione",null);
				}
			}
			else{	
				//creazione utente avanzato
				if(new UserManagement().nuovoUtente(username,nome,cognome,psw.getText(),'a'))
				{
				JOptionPane.showMessageDialog(null, "Registrazione effettuata.");				
				changePage("Login",null);
				}
				else{					
					changePage("Registrazione",null);
				}
			}
		}
	}

	/**
	 * Adds the opera.
	 *
	 * @param acquisitore the acquisitore
	 * @param titolo the titolo
	 * @param anno the anno
	 * @param autore the autore
	 * @param editore the editore
	 * @param isbn the isbn
	 */
	public static void addOpera(Acquisitore acquisitore,String titolo,String anno,String autore,String editore,String isbn){
		if(titolo.equals("") || isbn.equals("")){
			new Eccezioni("I campi titolo e isbn sono obbligatori!");
		}
		else{
			acquisitore.addOpera(anno,titolo, autore, isbn, editore);
			try{
				(new File("img/"+titolo)).mkdir();
				(new File("trascrizioni/"+titolo)).mkdir();
			}catch(Exception e){
				new Eccezioni("errore creazione cartella");
			}
		}
	}
	
	/**
	 * Gets the opera.
	 *
	 * @param opera the opera
	 * @return the opera
	 */
	public static Opera getOpera(String opera){
		return new OperaManagement().getOpera(opera,'c');
	}
	
	/**
	 * Gets the opera model.
	 *
	 * @param opera the opera
	 * @return the opera model
	 */
	public static TableModel getOperaModel(String opera){
		return new OperaManagement().getOperaModel(opera);
	}
	
	/**
	 * Gets the opere.
	 *
	 * @return the opere
	 */
	public static TableModel getOpere(){
		return new OperaManagement().getOpere();		
	}
	
	/**
	 * Gets the utenti.
	 *
	 * @param type the type
	 * @return the utenti
	 */
	public static TableModel getUtenti(String type){
		return new UserManagement().getUtenti(type);		
	}

	/**
	 * Delete immagine.
	 *
	 * @param ac the ac
	 * @param opera the opera
	 * @param page the page
	 */
	public static void deleteImmagine(Acquisitore ac,String opera,String page){
		if(opera.equals("") || page.equals("") || opera.equals(INSERT) || page.equals(PAGE)){
			new Eccezioni("Completare tutti i campi!");
		}
		else{
			try{
				Opera o=getOpera(opera);
				String path = getImm(o.getIsbn(),page);
				File ImmFile = new File(path);
				ImmFile.delete();				
				int p=Integer.parseInt(page);
				ac.deleteImmagine(opera,p);
			}catch(Exception e){
				new Eccezioni("Page deve essere un numero intero!");
			}
		}
	}

	/**
	 * Gets the commenti.
	 *
	 * @param utente the utente
	 * @return the commenti
	 */
	public static TableModel getCommenti(Utente utente){
		if(utente instanceof Acquisitore){
			return ((Acquisitore) utente).viewCommenti();
		}
		else if(utente instanceof RevisoreImmagine){
			return ((RevisoreImmagine)utente).viewCommenti();
		}
		else if(utente instanceof Trascrittore){
			return ((Trascrittore)utente).viewCommenti();
		}
		else if(utente instanceof RevisoreTrascrizioni){
			return ((RevisoreTrascrizioni)utente).viewCommenti();
		}
		else
			return null;
	}
	
	/**
	 * Adds the commento.
	 *
	 * @param utente the utente
	 * @param text the text
	 */
	public static void addCommento(Utente utente,String text){
		if(!(text.equals(""))){
			if(utente instanceof Acquisitore){
				((Acquisitore) utente).addCommento(text);
			}
			else if(utente instanceof Trascrittore){
				((Trascrittore)utente).addCommento(text);
			}	
			else if(utente instanceof RevisoreImmagine){
				((RevisoreImmagine)utente).commenta(text);
			}
			else if(utente instanceof RevisoreTrascrizioni){
				((RevisoreTrascrizioni)utente).commenta(text);
			}
		}
		else
			new Eccezioni("Inserire il commento.");
	}

	/**
	 * Delete trascrizione.
	 *
	 * @param tr the tr
	 * @param opera the opera
	 * @param page the page
	 */
	public static void deleteTrascrizione(Trascrittore tr,String opera,String page){
		if(opera.equals("") || page.equals("")){
			new Eccezioni("Completare tutti i campi!");
		}
		else{
			try{
				Opera o=getOpera(opera);
				File tFile = new File("trascrizioni/"+o.getTitolo()+"/"+o.getTitolo()+page+".html");
				tFile.delete();
				int p=Integer.parseInt(page);				
				tr.deleteTrascrizione(opera,p);
			}catch(Exception e){
				new Eccezioni("Page deve essere un numero intero!");
			}
		}
		
	}
	
	/**
	 * Gets the first imm.
	 *
	 * @param opera the opera
	 * @return the first imm
	 */
	public static Image getFirstImm(String opera){
		Opera op=new OperaManagement().getOpera(opera,'c');
		if(op!=null){
			String path=new OperaManagement().getPath(op.getIsbn(), 1,'c');
			if(path.equals("")){
				new Eccezioni("L'immagine non è stata ancora approvata.");
				return null;
			}
			try{
				BufferedImage srcIm = ImageIO.read(new File(path));
				Image scaledIm = srcIm.getScaledInstance(WIDTH, HEIGHT, BufferedImage.SCALE_DEFAULT);		
				return scaledIm;
			}
			catch(Exception e){
				new Eccezioni("Errore :\n"+e);
				return null;
			}	
		}
		else{
			new Eccezioni("Opera non presente");
			return null;
		}
	}
	
	/**
	 * Gets the first imm.
	 *
	 * @param opera the opera
	 * @param width the width
	 * @param height the height
	 * @return the first imm
	 */
	public static Image getFirstImm(String opera,int width,int height){
		Opera op=new OperaManagement().getOpera(opera,'c');
		if(op!=null){
			String path=new OperaManagement().getPath(op.getIsbn(), 1,'r');
			if(path.equals("")){
				new Eccezioni("L'immagine non è stata ancora approvata.");
				return null;
			}
			try{
				BufferedImage srcIm = ImageIO.read(new File(path));
				Image scaledIm = srcIm.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);		
				return scaledIm;
			}
			catch(Exception e){
				new Eccezioni("Errore :\n"+e);
				return null;
			}	
		}
		else{
			new Eccezioni("Opera non presente");
			return null;
		}
	}

	/**
	 * Gets the imm.
	 *
	 * @param opera the opera
	 * @param number the number
	 * @param s the s
	 * @return the imm
	 */
	public static Image getImm(String opera, String number,char s){
		String isbn = new OperaManagement().getOpera(opera,'c').getIsbn();
		String path;
		int n=Integer.parseInt(number);
		if(s=='-'){
			if(n > 1){
				path= new OperaManagement().getPath(isbn, n-1, 'c');
			}else{
				new Eccezioni("Immagine inesistente.");
				return null;
			}
		}
		else{
			path= new OperaManagement().getPath(isbn, n+1, 'c');
		}
		if(path.equals("")){
			new Eccezioni("L'immagine non è stata ancora approvata.");
			return null;
		}
		else{
			try{
				BufferedImage srcIm = ImageIO.read(new File(path));
				Image scaledIm = srcIm.getScaledInstance(WIDTH, HEIGHT, BufferedImage.SCALE_DEFAULT); 			
				return scaledIm;
			}
			catch(Exception e){
				new Eccezioni("Errore :\n"+e);
				return null;
			}
		}
	}
	
	/**
	 * Gets the imm.
	 *
	 * @param opera the opera
	 * @param number the number
	 * @param s the s
	 * @param width the width
	 * @param height the height
	 * @return the imm
	 */
	public static Image getImm(String opera, String number,char s,int width,int height){
		String isbn = new OperaManagement().getOpera(opera,'c').getIsbn();
		String path;
		int n=Integer.parseInt(number);
		if(s=='-'){
			if(n > 1){
				path= new OperaManagement().getPath(isbn, n-1, 'r');
			}else{
				return null;
			}
		}
		else{
			path= new OperaManagement().getPath(isbn, n+1, 'r');
		}
		if(path.equals("")){
			return null;
		}
		else{
			try{
				BufferedImage srcIm = ImageIO.read(new File(path));
				Image scaledIm = srcIm.getScaledInstance(width,height, BufferedImage.SCALE_DEFAULT); 			
				return scaledIm;
			}
			catch(Exception e){
				new Eccezioni("Errore :\n"+e);
				return null;
			}
		}
	}
	
	/**
	 * Gets the imm.
	 *
	 * @param isbn the isbn
	 * @param number the number
	 * @return the imm
	 */
	public static String getImm(String isbn, String number){
		Integer n=Integer.parseInt(number);
		return new OperaManagement().getPath(isbn, n.intValue(), 'c');										
	}

	/**
	 * Adds the immagine.
	 *
	 * @param acquisitore the acquisitore
	 * @param path the path
	 * @param opera the opera
	 * @param page1 the page1
	 * @return true, if successful
	 */
	public static boolean addImmagine(Acquisitore acquisitore,String path,String opera,String page1){
		if(path.equals("") || opera.equals("") || opera.equals(INSERT) || page1.equals("") || page1.equals(PAGE)){
			new Eccezioni("Completare tutti i campi");
			return false;
		}
		else{
			try{
				Integer page = Integer.parseInt(page1);	
				acquisitore.addImmagine(path,opera,page);
				return true;
			}catch(Exception e){
				new Eccezioni("Page deve essere un numero intero");
				return false;
			}				
		}
	}
	
	/**
	 * Save image.
	 *
	 * @param file the file
	 * @param opera the opera
	 */
	public static void saveImage(File file,String opera){
		String title=new OperaManagement().getOpera(opera,'c').getTitolo();
		try{
			BufferedImage bi=ImageIO.read(file);
			File outfile= new File("img/"+ title +"/" +file.getName());
			ImageIO.write(bi, "jpg", outfile);
		}
		catch(IOException e){
			new Eccezioni("error",e);
		}
	}
	
	/**
	 * Approva imm.
	 *
	 * @param rev the rev
	 * @param opera the opera
	 * @param page the page
	 */
	public void approvaImm(RevisoreTrascrizioni rev,String opera,String page){
		Opera op=new OperaManagement().getOpera(opera,'c');
		String isbn=op.getIsbn();
		Integer p=Integer.parseInt(page);
		String path=new OperaManagement().getPath(isbn, p.intValue(),'c');
		rev.acceptIm(path);
		
	}
	
	/**
	 * Adds the trascrizione.
	 *
	 * @param trasc the trasc
	 * @param titolo the titolo
	 * @param anno the anno
	 * @param text the text
	 * @param page1 the page1
	 * @return true, if successful
	 */
	public static boolean addTrascrizione(Trascrittore trasc,String titolo,String anno,String text,String page1){
		if(titolo.equals("") || anno.equals("") || text.equals("")){
			new Eccezioni("Completare tutti i campi");
			return false;
		}
		else{
			try{
				Integer page = Integer.parseInt(page1);	
				trasc.addTrascrizione(titolo,anno,page.intValue());
				return true;
			}catch(Exception e){
				new Eccezioni("Page deve essere un numero intero");
				return false;
			}				
		}
	}
	
	/**
	 * Save trascrizione.
	 *
	 * @param titolo the titolo
	 * @param anno the anno
	 * @param page the page
	 * @param text the text
	 */
	public static void saveTrascrizione(String titolo,String anno,String page,String text){
		try{
			FileOutputStream file;
			file = new FileOutputStream("trascrizioni/" +titolo+ "/" +titolo + page+ ".html");
		     PrintStream Output = new PrintStream(file);
		     
		     Output.println("<h1>Titolo : " +titolo+ "</h1> <h2>Anno : "+ anno+"</h2> <h3>Testo : </h3>" +text);
		     Output.close();
			
		}catch(Exception e){
			new Eccezioni("error \n"+e);
		}
	}
	
	public static void setTrascrizione(String titolo,String page,String text){
		try{
			File old = new File("trascrizioni/" +titolo+ "/" +titolo + page+ ".html");
			if (old.exists()){
				old.delete();			
				
				FileOutputStream file;
				file = new FileOutputStream("trascrizioni/" +titolo+ "/" +titolo + page+ ".html");
			     PrintStream Output = new PrintStream(file);
			     
			     Output.println(text);
			     Output.close();
			}
		}
		catch(Exception e){
			new Eccezioni(e);
		}
	}

	/**
	 * Gets the trascrizione.
	 *
	 * @param utente the utente
	 * @param opera the opera
	 * @param number the number
	 * @return the trascrizione
	 */
	public static String getTrascrizione(Utente utente,String opera,String number){
		Opera op=new OperaManagement().getOpera(opera,'c');		
		if(op!=null){			
			String titolo=op.getTitolo();
			if(utente instanceof UtenteAvanzato){
				try {
					Integer n=Integer.parseInt(number);				
					String path= new OperaManagement().getPathT(titolo, n.intValue());
					if(path==null){
						new Eccezioni("La trascizione deve essere ancora approvata.");
						return null;
					}
					BufferedReader br = new BufferedReader(new FileReader(path));
				    StringBuilder sb = new StringBuilder();
				    String line = br.readLine();
	
				    while (line != null) {
					   sb.append(line);
					   sb.append(System.lineSeparator());
					   line = br.readLine();
					}
				    br.close();
					return sb.toString();
					}
				catch(Exception e) {
				    new Eccezioni(e);
				    return null;
				}
				
			}
			else{
				try {
						Integer n=Integer.parseInt(number);				
						String path= new OperaManagement().getPathT(titolo, n.intValue(),'r');
						if(path==null){
							return null;
						}
						BufferedReader br = new BufferedReader(new FileReader(path));
					    StringBuilder sb = new StringBuilder();
					    String line = br.readLine();
		
					    while (line != null) {
						   sb.append(line);
						   sb.append(System.lineSeparator());
						   line = br.readLine();
						}
					    br.close();
						return sb.toString();
						}
					catch(Exception e) {
					    new Eccezioni(e);
					    return null;
					}
			}
		}
		else
			return null;
	}

	/**
	 * Approva imm.
	 *
	 * @param rev the rev
	 * @param opera the opera
	 * @param pageN the page n
	 */
	public static void approvaImm(RevisoreImmagine rev,String opera,String pageN){
		Opera op=new OperaManagement().getOpera(opera,'c');
		try{
			Integer page=Integer.parseInt(pageN);
			String path=new OperaManagement().getPath(op.getIsbn(), page.intValue(), 'r');
			rev.acceptIm(path);
		}catch(Exception e){
			new Eccezioni("Page dev'essere un numero intero");
		}		
	}

	/**
	 * Approva tras.
	 *
	 * @param rev the rev
	 * @param opera the opera
	 * @param pageN the page n
	 */
	public static void approvaTras(RevisoreTrascrizioni rev,String opera,String pageN){
		Opera op=new OperaManagement().getOpera(opera,'c');
		try{
			Integer page=Integer.parseInt(pageN);
			String path=new OperaManagement().getPathT(op.getTitolo(), page.intValue(), 'r');
			rev.acceptT(path);
		}catch(Exception e){
			new Eccezioni("Page dev'essere un numero intero");
		}	
	}
	
}