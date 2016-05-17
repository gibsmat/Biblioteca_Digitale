package business.implementation;

import java.sql.*;
import javax.swing.*;
	
public class DbConnection {
	public static final String db ="jdbc:sqlite:biblioDb.db";
	Connection conn;
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection(db);			
			//JOptionPane.showMessageDialog(null, "Connection Successfull");	
			return conn;			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
