package business.implementation;

import business.model.*;
import business.Eccezioni;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class OperaManagement {
	Connection c = DbConnection.dbConnector();;
	
	public OperaManagement(){
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
			JOptionPane.showMessageDialog(null, "Opera aggiunta correttamente.");
			return new Opera(anno,titolo,autore,isbn,editore);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public boolean deleteOpera(String isbn){
		try{
		PreparedStatement pst=c.prepareStatement("DELETE FROM Opera WHERE isbn=?");
		pst.setString(1, isbn);
		pst.execute();
		pst.close();
		return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
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
	
	public ArrayList<Opera> getOpera(String stringa){
		List<Opera>listaOpera = new ArrayList<Opera>();
		//ricerca opera nel DB per titolo o isbn o autore
		//return oggetto Opera trovato
		return null;
	}

	public ArrayList<String> getTitle(String stringa){
		List<String> listaTitoli = new ArrayList<String>();
		//ricerca e restituzione dei titoli di tutte le opere nel DB
		return null;
	} 
}
