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
	final String path="log2.png";
	Connection c=null;
	Acquisitore acquisitore=null;

	public AcquisitoreGui(Connection c,Utente a){
		this.c=c;
		this.acquisitore=(Acquisitore)a;
		initialize();
	}
	
	public void initialize(){
		
		//BOTTONE NUOVA OPERA
		Opera newOpera=this.acquisitore.addOpera(c, 1695, "Buch2","Paolo","b-u-c-h-2","unknown");
		//BOTTONE AGGIUNGI IMMAGINE
		try{
			newOpera.addImmagine(c, path, newOpera.getTitolo(),(new ImageIcon(path)).getImage());
			JOptionPane.showMessageDialog(null, newOpera.getImmagini().values().toString());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		} 
	} 
	
}
