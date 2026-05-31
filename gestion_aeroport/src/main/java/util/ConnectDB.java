package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static Connection connection ;
	
	//information connextion
	
	private static final String URL = "jdbc:mysql://localhost:3306/gestionaeroport";
	private static final String USERNAME="root";
	private static final String PASSWORD="";
	
	//connection prive
	 private ConnectDB() {
	      try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  //etablir la connection
	    	  connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	 }
	 public static Connection getConnection() {
		 if(connection==null) {
			new ConnectDB();
		 }
		 return connection;
	 }
}

