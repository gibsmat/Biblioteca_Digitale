package business.implementation;

import java.sql.*;
import javax.swing.*;
	
public class DbConnection {
	private static final String db ="jdbc:sqlite:biblioDb.db";
	private static Connection conn;
	
	public DbConnection(){
	}
	
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(db);			
			//JOptionPane.showMessageDialog(null, "Connection successfull");	
			return conn;			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
