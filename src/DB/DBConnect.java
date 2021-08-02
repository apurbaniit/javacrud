package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	
	private static Connection conn = null;

public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CRUD";
public static final String USERNAME = "sa";
public static final String PASSWORD = "rony";
	public static Connection dbCon()
	{
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println(conn);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
	}
		return conn;
}
}

