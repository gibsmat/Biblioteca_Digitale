package business.implementation;

import business.model.*;
import presentation.*;
import java.sql.*;

public class UserManagement{
	
	public void UserManagement(){
	}
	
	public void nuovoUtenteBase(Connection c, String id,String nome,String cognome,String psw){
		PreparedStatement pstm = null;
		try{
		
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    } 
	}
	public void nuovoUtenteBase(Connection c,String id,String psw){
		
	} 
    
       
}

  /*
   * CREAZIONE TABELLA
   
   Statement stmt = null;
   stmt = c.createStatement();
  
  String sql = "CREATE TABLE UTENTEBASE " +
          "(USERID 		   TEXT PRIMARY KEY     NOT NULL," +
		  " PASSWORD	   CHAR(32) NOT NULL" +	
          " NOME           TEXT " + 
          " COGNOME        TEXT)" ; 
 stmt.executeUpdate(sql);
 
 stmt.close();  */

/* QUERY
 *  String query = "select NOME" + "from" + "test.db" + ".UTENTEBASE";
	 ResultSet rs = stmt.executeQuery(query);
  while (rs.next()) {
      String TestName = rs.getString("NOME");
      System.out.println(TestName);
  }	 */



