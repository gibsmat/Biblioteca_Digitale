/**
 * 
 */
package presentation;


import java.sql.*;
import javax.swing.*;

import business.model.*;
/**
 * @author antony
 *
 */
public class AcquisitoreGui extends JFrame{
	final String path="img/hidan.jpg";
	Connection c=null;
	Acquisitore acquisitore=null;

	public AcquisitoreGui(Connection c,Utente a){
		this.c=c;
		this.acquisitore=(Acquisitore)a;
		initialize();
	}
	
	public void initialize(){
		
		//BOTTONE NUOVA OPERA
		Opera newOpera=this.acquisitore.addOpera(c, 1695, "Buch4","Paoletto","b-u-c-h-4","unknown");
		//BOTTONE AGGIUNGI IMMAGINE
		try{
			newOpera.addImmagine(c, path,new ImageIcon(path));
			JOptionPane.showMessageDialog(null, newOpera.getImmagini().values().toString());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		} 
	} 
	
}
