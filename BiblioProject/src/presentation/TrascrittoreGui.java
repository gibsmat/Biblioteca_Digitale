/**
 * 
 */
package presentation;

import javax.swing.*;

import business.model.*;

/**
 * @author antony
 *
 */

public class TrascrittoreGui {
	Trascrittore trascrittore;
	
	public TrascrittoreGui(Utente utente){
		this.trascrittore=(Trascrittore)utente;
		initialize();
	}
	
	public void initialize(){
		//mostra tutte le opere
		showOpere();
		
		//scegli opera
		trascrivi();
	}
	
	public void trascrivi(){
		//apri finestra con immagine e box per trascrizione
		
	}
	public void showOpere(){
		
	}

}
