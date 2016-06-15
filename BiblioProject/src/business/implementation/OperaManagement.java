package business.implementation;

import business.model.*;
import net.proteanit.sql.DbUtils;
import business.Eccezioni;

import java.sql.*;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class OperaManagement.
 */
public class OperaManagement {
	
	/** The connection. */
	Connection c=DbConnection.dbConnector();
	
	/**
	 * Instantiates a new opera management.
	 */
	public OperaManagement(){
	}
	
	/**
	 * Insert opera.
	 *
	 * @param anno the anno
	 * @param titolo the titolo
	 * @param autore the autore
	 * @param isbn the isbn
	 * @param editore the editore
	 */
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
	
	/**
	 * Delete opera.
	 *
	 * @param isbn the isbn
	 * @return true, if successful
	 */
	public boolean deleteOpera(String isbn){
		Opera op=getOpera(isbn);
		if(op!=null){
			try{
				PreparedStatement pst=c.prepareStatement("DELETE FROM Opera WHERE isbn=?");
				pst.setString(1, isbn);
				pst.execute();
				pst.close();
				
				pst=c.prepareStatement("DELETE FROM Immagini WHERE opera=?");
				pst.setString(1, isbn);
				pst.execute();
				pst.close();
				
				pst=c.prepareStatement("DELETE FROM Trascrizioni WHERE opera=?");
				pst.setString(1,op.getTitolo());
				pst.execute();
				pst.close();
				c.close();
				return true;
			
			}catch(Exception e){
				new Eccezioni(e);
				return false;
			}
		}
		else{
			try{
				c.close();
			}catch(Exception e){
				new Eccezioni(e);
			}
			return false;
		}
	}
	
	/**
	 * Adds the immagine.
	 *
	 * @param opera the opera
	 * @param path1 the path1
	 * @param page the page
	 */
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
			new Eccezioni("Errore nell'aggiunta dell'immagine.\n"+e);
		}
	}
	
	/**
	 * Delete immagine.
	 *
	 * @param isbn
	 *            the isbn
	 * @param page
	 *            the page
	 */
	public void deleteImmagine(String isbn,int page){	
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Immagini WHERE opera=? AND page=?");
			pst.setString(1, isbn);
			pst.setInt(2, page);
			pst.execute();
			pst.close();
			c.close();
			
			JOptionPane.showMessageDialog(null,"Immagine eliminata.");
			
		}catch(SQLException e){
			new Eccezioni("Db error",e);
		}		
	}
	
	/**
	 * Gets the path.
	 *
	 * @param opera the opera
	 * @param page the page
	 * @return the path
	 */
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
	
	/**
	 * Gets the path.
	 *
	 * @param opera
	 *            the opera
	 * @return the path
	 */
	public TreeMap <Integer,String> getPath(String opera){
		TreeMap <Integer,String> temp=new TreeMap <Integer,String>();
		try{
			String query="SELECT path,page FROM Immagini where opera=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, opera);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				temp.put(rs.getInt("page"), rs.getString("path"));
			}
			pst.close();
			rs.close();
			return temp;
			
		}catch(SQLException e){
			new Eccezioni(e);
			return null;
		}		
	}
	
	/**
	 * Gets the path.
	 *
	 * @param opera the opera
	 * @param page the page
	 * @param close the close
	 * @return the path
	 */
	public String getPath(String opera,int page,char close){
		if(close=='r'){
			try{
				String query="SELECT path FROM Immagini where opera=? AND page=?";
				PreparedStatement pst = c.prepareStatement(query);
				pst.setString(1, opera);
				pst.setInt(2, page);
				
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()){
					String p=rs.getString("path");					
					pst.close();
					rs.close();
					c.close();
					return p;
				}else{
					pst.close();
					rs.close();
					c.close();
					return "";
				}
			}
			catch(Exception e){
				new Eccezioni("Immagine non trovata");
				return null;
			}
		}
		else{
			try{
				String query="SELECT path FROM Immagini where opera=? AND page=? AND stato=1";
				PreparedStatement pst = c.prepareStatement(query);
				pst.setString(1, opera);
				pst.setInt(2, page);
				
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					String p=rs.getString("path");
					pst.close();
					rs.close();
					c.close();
					return p;
				}else{
					pst.close();					
					rs.close();
					c.close();
					return "";
				}
			}catch(Exception e){
				new Eccezioni("Immagine non trovata");
				return null;
			}	
		}
	}
	
	/**
	 * Gets the path t.
	 *
	 * @param opera the opera
	 * @param page the page
	 * @param rev the rev
	 * @return the path t
	 */
	public String getPathT(String opera,int page,char rev){
			try{
				String query="SELECT path FROM Trascrizioni where opera=? AND page=?";
				PreparedStatement pst = c.prepareStatement(query);
				pst.setString(1, opera);
				pst.setInt(2, page);
				
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					String path= rs.getString("path");
					rs.close();
					return path;
				}else
					return null;
				
			}catch(SQLException e){
				new Eccezioni("Db error.",e);
				return null;
			}
		}
	
	/**
	 * Gets the path t.
	 *
	 * @param opera the opera
	 * @param page the page
	 * @return the path t
	 */
	public String getPathT(String opera,int page){
			try{
				String query="SELECT path FROM Trascrizioni where opera=? AND page=? AND stato=1";
				PreparedStatement pst = c.prepareStatement(query);
				pst.setString(1, opera);
				pst.setInt(2, page);
				
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					String path= rs.getString("path");
					rs.close();
					return path;
				}else
					return null;
				
			}catch(SQLException e){
				new Eccezioni("Db error.",e);
				return null;
			}
	}
	
	/**
	 * Gets the stato imm.
	 *
	 * @param path the path
	 * @return the stato imm
	 */
	public int getStatoImm(String path){
		try{
			String query="SELECT stato FROM Immagini where path=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, path);
			
			ResultSet rs=pst.executeQuery();
			int ris= rs.getInt("stato");
			c.close();
			return ris;
			
			
		}catch(Exception e){
			new Eccezioni(e);
			return -1;
		}
		
	}
	
	/**
	 * Change stato imm.
	 *
	 * @param path the path
	 * @param s the s
	 */
	public void changeStatoImm(String path,int s){
		try{
			String query="UPDATE Immagini SET stato=? WHERE path=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setInt(1, s);
			pst.setString(2, path);
			
			pst.execute();
			pst.close();
			c.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	/**
	 * Change stato t.
	 *
	 * @param path the path
	 * @param s the s
	 */
	public void changeStatoT(String path,int s){
		try{
			String query="UPDATE Trascrizioni SET stato=? WHERE path=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setInt(1, s);
			pst.setString(2, path);
			
			pst.execute();
			pst.close();
			c.close();
			
		}catch(Exception e){
			new Eccezioni(e);
		}
	}
	
	/**
	 * Adds the commento i.
	 *
	 * @param comm the comm
	 */
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
	
	/**
	 * Adds the commento t.
	 *
	 * @param comm the comm
	 */
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
	
	/**
	 * Gets the opere.
	 *
	 * @return the opere
	 */
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
	
	/**
	 * Gets the commenti i.
	 *
	 * @return the commenti i
	 */
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
	
	/**
	 * Gets the commenti t.
	 *
	 * @return the commenti t
	 */
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
	
	/**
	 * Gets the opera.
	 *
	 * @param op the op
	 * @return the opera
	 */
	public Opera getOpera(String op){
		String anno="",titolo="",autore="",isbn="",editore="";
		try{
			String query="SELECT * FROM Opera where isbn=? OR titolo=? OR editore=? OR autore=? OR anno=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, op);
			pst.setString(2, op);
			pst.setString(3, op);
			pst.setString(4, op);
			pst.setString(5, op);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				anno=rs.getString("anno");
				titolo=rs.getString("titolo");
				autore=rs.getString("autore");
				isbn=rs.getString("isbn");
				editore=rs.getString("editore");				
			}
			rs.close();			
			return new Opera(anno,titolo,autore,isbn,editore,getPath(isbn));
		
		}catch(SQLException e){
			new Eccezioni("Db error",e);
			return null;
		}
	}
	
	/**
	 * Gets the opera.
	 *
	 * @param op the op
	 * @param close the close
	 * @return the opera
	 */
	public Opera getOpera(String op,char close){
		String anno="",titolo="",autore="",isbn="",editore="";
		
		try{
			String query="SELECT * FROM Opera where isbn=? OR titolo=? OR anno=? OR editore=? or autore=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, op);
			pst.setString(2, op);
			pst.setString(3, op);
			pst.setString(4, op);
			pst.setString(5, op);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				anno=rs.getString("anno");
				titolo=rs.getString("titolo");
				autore=rs.getString("autore");
				isbn=rs.getString("isbn");
				editore=rs.getString("editore");
			}
			rs.close();
			Opera o=new Opera(anno,titolo,autore,isbn,editore,getPath(isbn));
			c.close();
			return o;		
		}
		catch(SQLException e){
			new Eccezioni("Db error",e);
			return null;
		}
	}

	/**
	 * Gets the opera model.
	 *
	 * @param op the op
	 * @return the opera model
	 */
	public TableModel getOperaModel(String op){
		
		try{
			String query="SELECT anno,titolo,autore,isbn,editore FROM Opera where isbn=? OR titolo=? OR anno=? OR editore=? or autore=?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, op);
			pst.setString(2, op);
			pst.setString(3, op);
			pst.setString(4, op);
			pst.setString(5, op);
			
			ResultSet rs=pst.executeQuery();
			TableModel tm= DbUtils.resultSetToTableModel(rs);	
			c.close();
			return tm;	
			
		}catch(SQLException e){
			new Eccezioni("Db error \n"+e);
			return null;
		}
	}
	
	/**
	 * Adds the trascrizione.
	 *
	 * @param t the t
	 * @param titolo the titolo
	 * @param anno the anno
	 * @param page the page
	 */
	public void addTrascrizione(String t,String titolo,String anno,int page){
		String path="trascrizioni/" +titolo+ "/" + titolo + page + ".html";

		try{
			String query="INSERT INTO Trascrizioni(path,stato,opera,page,trascrittore) VALUES (?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1, path);
			pst.setInt(2,0);
			pst.setString(3,titolo);
			pst.setInt(4,page);
			pst.setString(5,t);
			
			pst.execute();
			pst.close();
			c.close();
			JOptionPane.showMessageDialog(null,"Trascrizione aggiunta.");
			
		}catch(Exception e){
			new Eccezioni("errore nell'aggiunta della trascrizione \n"+e);
		}		
	}
	
	/**
	 * Delete trascrizione.
	 *
	 * @param opera the opera
	 * @param page the page
	 */
	public void deleteTrascrizione(String opera,int page){			
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Trascrizioni WHERE opera=? AND page=?");
			pst.setString(1, opera);
			pst.setInt(2, page);
			pst.execute();
			pst.close();			
			c.close();
			
			JOptionPane.showMessageDialog(null,"Trascrizione eliminata con successo.");
			
		}catch(SQLException e){
			new Eccezioni("Errore Db. \n"+e);
		}			
	}

}
