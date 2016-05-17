package presentation;

import business.model.*;
import business.implementation.*;
import java.sql.*;

public class Biblio{ 
	
	public static void avvio(Connection con){
		new Login(con);
		
	}

	public static void main(String[] args) {				
		avvio(new DbConnection().dbConnector());		
	}
}


/* CURRENT TIME
 * String time;
CURRENT TIME :  Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
time=currentTimestamp.toString();*/