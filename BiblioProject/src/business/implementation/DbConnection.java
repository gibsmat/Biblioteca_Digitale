package business.implementation;

import java.sql.*;

import business.Eccezioni;

// TODO: Auto-generated Javadoc
/**
 * The Class DbConnection.
 */
public class DbConnection {
	
	/** The Constant db. */
	private static final String DB ="jdbc:sqlite:biblioDb.db";
	
	/** The conn. */
	private static Connection conn=null;

	/**
	 * Instantiates a new db connection.
	 */
	private DbConnection(){
	}
	
	/**
	 * Db connector.
	 *
	 * @return the connection
	 */
	public static Connection dbConnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(DB);			
			return conn;			
		}catch(Exception e){
			new Eccezioni("Errore connessione al DB.\n"+e);
			return null;
		}
	}
}
