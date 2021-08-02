package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBConnect;
import bean.RegisterBean;

public class RegisterDao {

	public String registerUser(RegisterBean registerBean)
    {
        String userName = registerBean.getUserName();
        String userEmail = registerBean.getUserEmail();
        String userPass = registerBean.getUserPass();
         
        
        Connection con = null;
        PreparedStatement preparedStatement = null;         
        try
        {
            con = DBConnect.dbCon();
            String query = "insert into register_user values (?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userEmail);
            preparedStatement.setString(3, userPass);
            
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
}
