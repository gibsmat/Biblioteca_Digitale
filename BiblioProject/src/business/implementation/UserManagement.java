package business.implementation;

import java.sql.*;

public class UserManagement
{
  public static void main(String args[])
  { 
    Connection c = null;
    Statement stmt = null;
    
    try {
      Class.forName("org.sqlite.JDBC");  //caricamento driver sqlite
      c = DriverManager.getConnection("jdbc:sqlite:test.db");  //connessione con db "test"
      System.out.println("Opened database successfully");      
      stmt = c.createStatement();
    
      //CREAZIONE TABELLA
      
      String sql = "CREATE TABLE UTENTEBASE " +
              "(USERID 		   TEXT PRIMARY KEY     NOT NULL," +
    		  " PASSWORD	   CHAR(32) NOT NULL" +	
              " NOME           TEXT " + 
              " COGNOME        TEXT)" ; 
	 stmt.executeUpdate(sql);
	 
	 stmt.close();
	 c.close();
    
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    
    System.out.println("Table created successfully");
  }

/* QUERY
 *  String query = "select NOME" + "from" + "test.db" + ".UTENTEBASE";
	 ResultSet rs = stmt.executeQuery(query);
  while (rs.next()) {
      String TestName = rs.getString("NOME");
      System.out.println(TestName);
  }	 */



}