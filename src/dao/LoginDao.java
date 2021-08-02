package dao;

import java.sql.*;

import DB.DBConnect;
import bean.LoginBean;

public class LoginDao {
	
	public String validate(LoginBean loginbean)  
	{
		
		String userName=loginbean.getUserName();
		String userPass=loginbean.getUserPass();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
		conn=DBConnect.dbCon();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select username,user_pass from register_user");
		
		while(rs.next())
		{
			 userName = rs.getString(userName);
			userPass = rs.getString(userPass);
			
			if(userName.equals(userName) && userPass.equals(userPass))
			{
				return "SUCCESS";
			}
		 
		
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();	
		}
		
		
	
	
		return "Invalid input";
}
}