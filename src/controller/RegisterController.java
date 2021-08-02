package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegisterBean;
import dao.RegisterDao;

 
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
		 
        String userName = request.getParameter("usernamesignup");
        String userEmail=request.getParameter("emailsignup");
        String userPass = request.getParameter("passwordsignup");
        
		RegisterBean regBean=new RegisterBean();
		
		regBean.setUserName(userName);
		regBean.setUserEmail(userEmail);
		regBean.setUserPass(userPass);
		
		RegisterDao regDao=new RegisterDao();
		
		String userRegistered = regDao.registerUser(regBean);
        
        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
           request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", userRegistered);
           request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
		
	}

}
