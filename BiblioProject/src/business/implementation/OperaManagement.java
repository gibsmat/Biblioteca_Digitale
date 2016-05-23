package business.implementation;

import business.model.*;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class OperaManagement {
	Connection c = null;
	
	public OperaManagement(Connection c){
		this.c=c;
	}
	
	public Opera insertOpera(int anno,String titolo,String autore,String isbn,String editore){
		try{
			String query="INSERT INTO Opera(anno,titolo,autore,isbn,editore,path) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setInt(1,anno);
			pst.setString(2,titolo);
			pst.setString(3,autore);
			pst.setString(4,isbn);
			pst.setString(5, editore);
			pst.setString(6, "");
			
			pst.execute();
			pst.close();
			
			return new Opera(anno,titolo,autore,isbn,editore);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public void deleteOpera(Opera op){
		// cancellazione opera dal DB
	}
	
	public void addImmagine(Opera o,String path){
		try{
			String query="UPDATE Opera SET path=? WHERE isbn=?";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1, path);
			pst.setString(2,o.getIsbn());
			
			pst.execute();
			pst.close();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void deleteImmagine(Opera o,String path){
		
	}
/*	public ArrayList<Opera> getOpera(String stringa){
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
	*/
}
