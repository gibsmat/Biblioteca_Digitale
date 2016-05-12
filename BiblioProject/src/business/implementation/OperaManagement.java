package business.implementation;

import java.sql.*;

public class OperaManagement {
	Connection c1 = null;
	
	public void connectdb(){		
	try {
	      c1 = DriverManager.getConnection("jdbc:sqlite:test.db");  //connessione con db "test"
	      System.out.println("Opened database successfully");      
		 
		 c1.close();
	    
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	}
}
