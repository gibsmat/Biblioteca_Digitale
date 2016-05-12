package business.implementation;

import business.model.*;
import java.sql.*;
import java.util.*;

public class OperaManagement {
	Connection c1 = null;
	
	public void connectdb(){		
	try {
	      c1 = DriverManager.getConnection("jdbc:sqlite:test.db");  //connessione con db "test"
	      System.out.println("Opened database successfully");      
		 
		 c1.close();
	    
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	}
	
	public void insertOpera(Opera op){
		// aggiunta opera al DB
	}
	public void deleteOpera(Opera op){
		// cancellazione opera dal DB
	}
	public ArrayList<Opera> getOpera(String stringa){
		List<Opera>listaOpera = new ArrayList<Opera>();
		//ricerca opera nel DB per titolo o isbn o autore
		//return oggetto Opera trovato
	}
	public ArrayList<Opera> getOpera(int anno){
		List<Opera>listaOpera = new ArrayList<Opera>();
		//ricerca opera per anno
		//return opera
	}
	public ArrayList<String> getTitles(){
		List<String> listaTitoli = new ArrayList<String>();
		//ricerca e restituzione dei titoli di tutte le opere nel DB
	}
}
