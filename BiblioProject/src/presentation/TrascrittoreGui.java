/**
 * 
 */
package presentation;

import java.sql.*;
import javax.swing.*;

import business.implementation.DbConnection;
import business.model.*;

/**
 * @author antony
 *
 */

public class TrascrittoreGui {
	Connection c=DbConnection.dbConnector();;
	Trascrittore trascrittore;
	
	public TrascrittoreGui(Utente utente){
		this.trascrittore=(Trascrittore)utente;
		initialize();
	}
	
	public void initialize(){
		//scegli opera
		trascrivi();
	}
	
	public void trascrivi(){
		//apri finestra con immagine e box per trascrizione
		
		//JTextPane.setContentType("text/html")
	}

}
