/**
 * 
 */
package listener;

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

/**
 * @author antony
 *
 */

public class ListenerEventi {

	public ListenerEventi(){		
	}	
	
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
			//new RevisoreI_Gui(utente);
			break;
			
		case "Revisore Trascrizioni":
			//new RevisoreT_Gui(utente);
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
	
	public static void deleteOpera(Admin admin,String cod){
		admin.clearOpera(cod);
		changePage("Admin",null);
	}

	public static void deleteUtente(Admin admin,String type,String nome){
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

	public static void addOpera(Acquisitore acquisitore,String titolo,String anno,String autore,String editore,String isbn){
		acquisitore.addOpera(anno,titolo, autore, isbn, editore);
		try{
			(new File("img/"+titolo)).mkdir();
		}catch(Exception e){
			new Eccezioni("errore creazione cartella");
		}
	}
	
	public static boolean addImmagine(Acquisitore acquisitore,String path,String opera,String page1){
		if(path.equals("") || opera.equals("") || page1.equals("")){
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

	public static TableModel getOpere(){
		return new OperaManagement().getOpere();		
	}

	public static void deleteImmagine(Acquisitore ac,String opera,String page){
		if(opera.equals("") || page.equals("")){
			new Eccezioni("Completare tutti i campi!");
		}
		else{
			try{
				int p=Integer.parseInt(page);
				ac.deleteImmagine(opera,p);
			}catch(Exception e){
				new Eccezioni("Page deve essere un numero intero!");
			}
		}
	}

	public static void saveImage(File file,String opera){
		String title=new OperaManagement().getOpera(opera).getTitolo();
		try{
			BufferedImage bi=ImageIO.read(file);
			File outfile= new File("img/"+ title +"/" +file.getName());
			ImageIO.write(bi, "jpg", outfile);
		}catch(IOException e){
			new Eccezioni("error",e);
		}
	}

	public static TableModel getCommenti(Utente utente){
		if(utente instanceof Acquisitore){
			return ((Acquisitore) utente).viewCommenti();
		}
		else if(utente instanceof Trascrittore){
			return ((Trascrittore)utente).viewCommenti();
		}
		else
			return null;
	}
	
	public static void addCommento(Utente utente,String text){
		if(utente instanceof Acquisitore){
			((Acquisitore) utente).addCommento(text);
		}
		else if(utente instanceof Trascrittore){
			((Trascrittore)utente).addCommento(text);
		}		
		
	}

	public static void deleteTrascrizione(Trascrittore tr,String opera,String page){
		if(opera.equals("") || page.equals("")){
			new Eccezioni("Completare tutti i campi!");
		}
		else{
			try{
				int p=Integer.parseInt(page);
				tr.deleteTrascrizione(opera,p);
			}catch(Exception e){
				new Eccezioni("Page deve essere un numero intero!");
			}
		}
		
	}
	
	public static String getFirstImm(String opera){
		OperaManagement om=new OperaManagement();
		String isbn=om.getOpera(opera).getIsbn();
		return om.getPath(isbn, 1,'c');
	}

	public static String getImmPrec(String opera){
		OperaManagement om = new OperaManagement();
		String isbn = om.getOpera(opera).getIsbn();
		
		
	}
}