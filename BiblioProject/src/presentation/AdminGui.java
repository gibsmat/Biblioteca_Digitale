package presentation;

import java.sql.*;
import java.util.*;
import business.implementation.*;
import business.model.*;

public class AdminGui {
	Connection c;
	
public AdminGui(Connection c){
	this.c=c;
	initialize();
}

public void initialize(){
	//finestra admin
	
	/* dentro al bottone cancella utente
	* TreeSet<String> ss =new UserManagement(c).findUsers();
	* showUsers(ss);
	* click sul bottone cancella utente
	*  new Admin(c).clearUtente("usern");  
	*/
	
	/* bottone aggiungi trascrittore
	 new Admin(c).addTrascrittore("trascrittore2","psw","nome","cognome");
	*/
	
	/* bottone cancella trascrittore
	  TreeSet<String> st=new UserManagement(c).findTr();
	  for(String s : st){
		  System.out.println(s);
	  }
	  showUsers(st);
		BOTTONE CANCELLA TRASCRITTORE
	  new Admin(c).clearTrascrittore("trascrittore");
	 */
}

public void showUsers(TreeSet<String> utenti){
	//mostrare lista username degli utenti
}

}
