package business.implementation;

import business.model.*;
import business.Eccezioni;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class OperaManagement {
	Connection c = DbConnection.dbConnector();
	
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
			JOptionPane.showMessageDialog(null,"Opera aggiunta correttamente.");
			return new Opera(anno,titolo,autore,isbn,editore);
			
		}catch(Exception e){
			new Eccezioni(e);
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
			new Eccezioni(e);
			return false;
		}
	}
	
	public void addImmagine(Opera o,String path,String nomeI){
		try{
			String query="UPDATE Opera SET imm=? WHERE isbn=?";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1, nomeI);
			pst.setString(2,o.getIsbn());
			
			pst.execute();
			pst.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}
		try{
			String query1 = "INSERT INTO Immagini(path,nomeImm,stato) VALUES(?,?,?)";
			PreparedStatement pst1=c.prepareStatement(query1);
			pst1.setString(1,path);
			pst1.setString(2,nomeI);
			pst1.setInt(3, 0);
			
			pst1.execute();
			pst1.close();
			
			JOptionPane.showMessageDialog(null,"Immagine aggiunta correttamente.");
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	public void deleteImmagine(String name){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Immagini WHERE nomeImm=?");
			pst.setString(1, name);
			pst.execute();
			pst.close();	
			
			JOptionPane.showMessageDialog(null,"Immagine eliminata.");	
			
		}catch(Exception e){
			new Eccezioni(e);
		}		
		try{
			String query1="UPDATE Opera SET imm=? WHERE imm=?";
			PreparedStatement pst1=c.prepareStatement(query1);
			pst1.setString(1,"");
			pst1.setString(2,name);
			
			pst1.execute();
			pst1.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}	
	}
	
	public int getStatoImm(String name){
		try{
			String query="SELECT stato FROM Immagini where nomeImm=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, name);
			
			ResultSet rs=pst.executeQuery();
			return rs.getInt("stato");			
			
		}catch(Exception e){
			new Eccezioni(e);
			return -1;
		}
		
	}
	
	public void changeStatoImm(String name,int s){
		try{
			String query="UPDATE Immagini SET stato=? WHERE nomeImm=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setInt(1, s);
			pst.setString(2, name);
			
			pst.execute();
			pst.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	public void addCommentoI(Commento comm){
		try{
			String query="INSERT INTO Commenti(autore,testo,data,immagine) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,comm.getAutore());
			pst.setString(2,comm.getText());
			pst.setString(3,comm.getData());
			pst.setString(4,comm.getTitolo());
			
			pst.execute();
			pst.close();
			JOptionPane.showMessageDialog(null,"Commento aggiunto.");
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	public void addCommentoT(Commento comm){
		try{
			String query="INSERT INTO Commenti(autore,testo,data,trascrizione) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,comm.getAutore());
			pst.setString(2,comm.getText());
			pst.setString(3,comm.getData());
			pst.setString(4,comm.getTitolo());
			
			pst.execute();
			pst.close();
			JOptionPane.showMessageDialog(null,"Commento aggiunto.");
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	public Opera getOpera(String stringa){
		List<Opera>listaOpera = new ArrayList<Opera>();
		//ricerca opera nel DB per titolo o isbn o autore
		//return oggetto Opera trovato
		return null;
	}

	public ArrayList<String> getTitles(String stringa){
		List<String> listaTitoli = new ArrayList<String>();
		//ricerca e restituzione dei titoli di tutte le opere nel DB
		return null;
	} 
}
