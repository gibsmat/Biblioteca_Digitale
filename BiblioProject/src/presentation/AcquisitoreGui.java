/**
 * 
 */
package presentation;


import java.sql.*;
import javax.swing.*;

import business.model.*;
import business.Eccezioni;
import business.implementation.*;
/**
 * @author antony
 *
 */
public class AcquisitoreGui extends JFrame{
	final String path="img/hidan.jpg";
	Connection c=DbConnection.dbConnector();;
	Acquisitore acquisitore=null;

	public AcquisitoreGui(Utente a){
		this.acquisitore=(Acquisitore)a;
		initialize();
	}
	
	public void initialize(){
		
		//BOTTONE NUOVA OPERA
		Opera newOpera=this.acquisitore.addOpera(1695, "Title","Paoletto","b-u-c-h-4","unknown");
		//BOTTONE AGGIUNGI IMMAGINE
		try{
			newOpera.addImmagine(path,"nomeImm");
		}catch(Exception e){
			new Eccezioni(e);
		} 
	} 
	
}
