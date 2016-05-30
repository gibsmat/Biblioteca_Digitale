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
			String query="INSERT INTO Opera(anno,titolo,autore,isbn,editore,imm) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,anno);
			pst.setString(2,titolo);
			pst.setString(3,autore);
			pst.setString(4,isbn);
			pst.setString(5, editore);
			pst.setString(6, "");
			
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
	
	public void addImmagine(String opera,String path,Integer page){
		Opera o=getOpera(opera);
		try{
			String query="UPDATE Opera SET imm=? WHERE isbn=?";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1, path);
			pst.setString(2,o.getIsbn());
			
			pst.execute();
			pst.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}
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
			new Eccezioni(e);
		}
	}
	
	public void deleteImmagine(String opera,int page){		
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Immagini WHERE opera=? AND page=?");
			pst.setString(1, getOpera(opera).getIsbn());
			pst.setInt(2, page);
			pst.execute();
			pst.close();
			
		}catch(SQLException e){
			new Eccezioni(e);
		}	
		String path=getPath(getOpera(opera).getIsbn(),page);
		try{
			String query1="UPDATE Opera SET imm=? WHERE imm=?";
			PreparedStatement pst1=c.prepareStatement(query1);
			pst1.setString(1,"");
			pst1.setString(2,path);
			
			pst1.execute();
			pst1.close();
			c.close();
			
			JOptionPane.showMessageDialog(null,"Immagine eliminata.");	
			
		}catch(SQLException e){
			new Eccezioni(e);
		}	
	}
	
	public String getPath(String opera,int page){
		try{
			String query="SELECT path FROM Immagini where opera=? AND page=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, opera);
			pst.setInt(2, page);
			
			ResultSet rs=pst.executeQuery();
			return rs.getString("path");
			
		}catch(SQLException e){
			new Eccezioni(e);
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
			String query="INSERT INTO Commenti(autore,testo,data,immagine) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,comm.getAutore());
			pst.setString(2,comm.getText());
			pst.setString(3,comm.getData());
			pst.setString(4,comm.getTitolo());
			
			pst.execute();
			pst.close();
			c.close();
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
			new Eccezioni(e);
			return null;
		}
	}

	public ArrayList<String> getTitles(String stringa){
		List<String> listaTitoli = new ArrayList<String>();
		//ricerca e restituzione dei titoli di tutte le opere nel DB
		return null;
	} 
}
