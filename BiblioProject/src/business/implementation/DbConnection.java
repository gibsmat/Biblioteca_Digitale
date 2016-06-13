package business.implementation;

import java.sql.*;

import business.Eccezioni;

// TODO: Auto-generated Javadoc
/**
 * The Class DbConnection.
 */
public class DbConnection {
	
	/** The Constant db. */
	private static final String db ="jdbc:sqlite:biblioDb.db";
	
	/** The conn. */
	private static Connection conn;

	/**
	 * Instantiates a new db connection.
	 */
	public DbConnection(){
	}
	
	/**
	 * Db connector.
	 *
	 * @return the connection
	 */
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(db);			
			//JOptionPane.showMessageDialog(null, "Connection successfull");	
			return conn;			
		}catch(Exception e){
			new Eccezioni("Errore connessione al DB.\n"+e);
			return null;
		}
	}
}
