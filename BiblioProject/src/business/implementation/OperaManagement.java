package business.implementation;

import business.model.*;
import net.proteanit.sql.DbUtils;
import business.Eccezioni;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class OperaManagement {
	Connection c = DbConnection.dbConnector();
	
	public OperaManagement(){
	}
	
	public void insertOpera(String anno,String titolo,String autore,String isbn,String editore){
		try{
			String query="INSERT INTO Opera(anno,titolo,autore,isbn,editore) VALUES (?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,anno);
			pst.setString(2,titolo);
			pst.setString(3,autore);
			pst.setString(4,isbn);
			pst.setString(5, editore);
			
			pst.execute();
			pst.close();
			c.close();
			JOptionPane.showMessageDialog(null,"Opera aggiunta correttamente.");
			//return new Opera(anno,titolo,autore,isbn,editore);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			//new Eccezioni("Errore nell'aggiunta dell'opera.",e);
			//return null;
		}
	}
	
	public boolean deleteOpera(String isbn){
		try{
		PreparedStatement pst=c.prepareStatement("DELETE FROM Opera WHERE isbn=?");
		pst.setString(1, isbn);
		pst.execute();
		pst.close();
		c.close();
		return true;
		
		}catch(Exception e){
			new Eccezioni(e);
			return false;
		}
	}
	
	public void addImmagine(String opera,String path1,Integer page){
		Opera o=getOpera(opera);
		String path="img/"+o.getTitolo()+"/"+path1;
		try{
			String query1 = "INSERT INTO Immagini(path,page,stato,opera) VALUES(?,?,?,?)";
			PreparedStatement pst1=c.prepareStatement(query1);
			pst1.setString(1,path);
			pst1.setInt(2,page.intValue());
			pst1.setInt(3, 0);
			pst1.setString(4,o.getIsbn());
			
			pst1.execute();
			pst1.close();
			c.close();
			
			JOptionPane.showMessageDialog(null,"Immagine aggiunta correttamente.");
			
		}catch(SQLException e){
			new Eccezioni("Errore nell'aggiunta dell'immagine",e);
		}
	}
	
	public void deleteImmagine(String opera,int page){	
		Opera op=getOpera(opera);
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Immagini WHERE opera=? AND page=?");
			pst.setString(1, op.getIsbn());
			pst.setInt(2, page);
			pst.execute();
			pst.close();
			c.close();
			
			JOptionPane.showMessageDialog(null,"Immagine eliminata.");
			
		}catch(SQLException e){
			new Eccezioni("Db error",e);
		}		
	}
	
	public String getPath(String opera,int page){
		try{
			String query="SELECT path FROM Immagini where opera=? AND page=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, opera);
			pst.setInt(2, page);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				return rs.getString("path");
			}else{
				return "";
			}
			
		}catch(SQLException e){
			new Eccezioni(e);
			return null;
		}		
	}
	
	public String getPath(String opera,int page,char close){
		try{
			String query="SELECT path FROM Immagini where opera=? AND page=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, opera);
			pst.setInt(2, page);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				String p=rs.getString("path");
				c.close();
				return p;
			}else{
				c.close();
				return "";
			}
		}catch(Exception e){
			new Eccezioni("Immagine non trovata");
			return null;
		}		
	}
	
	public String getPathT(String opera,int page){
		try{
			String query="SELECT path FROM Trascrizioni where opera=? AND page=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, opera);
			pst.setInt(2, page);
			
			ResultSet rs=pst.executeQuery();
			return rs.getString("path");
			
		}catch(SQLException e){
			new Eccezioni("Db error.",e);
			return null;
		}		
	}
	
	public int getStatoImm(String name){
		try{
			String query="SELECT stato FROM Immagini where nomeImm=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, name);
			
			ResultSet rs=pst.executeQuery();
			int ris= rs.getInt("stato");
			c.close();
			return ris;
			
			
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
			c.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	public void addCommentoI(Commento comm){
		try{
			String query="INSERT INTO Commenti(autore,testo,data,type) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,comm.getAutore());
			pst.setString(2,comm.getText());
			pst.setString(3,comm.getData());
			pst.setInt(4,1);
			
			pst.execute();
			pst.close();
			c.close();
			JOptionPane.showMessageDialog(null,"Commento aggiunto.");
			
		}catch(Exception e){
			new Eccezioni("errore nell'aggiunta del commento",e);
		}
	}
	
	public void addCommentoT(Commento comm){
		try{
			String query="INSERT INTO Commenti(autore,testo,data,type) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,comm.getAutore());
			pst.setString(2,comm.getText());
			pst.setString(3,comm.getData());
			pst.setInt(4,0);
			
			pst.execute();
			pst.close();
			c.close();
			JOptionPane.showMessageDialog(null,"Commento aggiunto.");
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	public TableModel getOpere(){
		try{
			String query="SELECT anno,titolo,autore,isbn,editore FROM Opera";
			Statement st = c.createStatement();
			ResultSet rs=st.executeQuery(query);			
			TableModel tm= DbUtils.resultSetToTableModel(rs);	
			c.close();
			return tm;			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e);
			new Eccezioni(e);
			return null;
		}
	}
	
	public TableModel getCommentiI(){
		try{
			String query="SELECT autore,testo,data FROM Commenti WHERE type=1";
			Statement st = c.createStatement();
			ResultSet rs=st.executeQuery(query);			
			TableModel tm= DbUtils.resultSetToTableModel(rs);	
			c.close();
			return tm;			
		}catch(SQLException e){
			new Eccezioni("Errore Db",e);
			return null;
		}
	}
	
	public TableModel getCommentiT(){
		try{
			String query="SELECT autore,testo,data FROM Commenti WHERE type=0";
			Statement st = c.createStatement();
			ResultSet rs=st.executeQuery(query);			
			TableModel tm= DbUtils.resultSetToTableModel(rs);	
			c.close();
			return tm;			
		}catch(SQLException e){
			new Eccezioni("Errore Db",e);
			return null;
		}
	}
	
	public Opera getOpera(String op){
		String anno,titolo,autore,isbn,editore;
		
		try{
			String query="SELECT * FROM Opera where isbn=? OR titolo=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, op);
			pst.setString(2, op);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				anno=rs.getString("anno");
				titolo=rs.getString("titolo");
				autore=rs.getString("autore");
				isbn=rs.getString("isbn");
				editore=rs.getString("editore");
				return new Opera(anno,titolo,autore,isbn,editore);
			}
			rs.close();
			c.close();
			return null;			
		}catch(SQLException e){
			new Eccezioni("Db error",e);
			return null;
		}
	}

	public void deleteTrascrizione(String opera,int page){
		Opera op=getOpera(opera);				
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Trascrizioni WHERE opera=? AND page=?");
			pst.setString(1, op.getIsbn());
			pst.setInt(2, page);
			pst.execute();
			pst.close();			
			c.close();
			
			JOptionPane.showMessageDialog(null,"Trascrizione eliminata con successo.");
			
		}catch(SQLException e){
			new Eccezioni("Errore Db",e);
		}			
	}
	
	public ArrayList<String> getTitles(String stringa){
		List<String> listaTitoli = new ArrayList<String>();
		//ricerca e restituzione dei titoli di tutte le opere nel DB
		return null;
	} 
}
