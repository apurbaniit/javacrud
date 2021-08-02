package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("username");
		String userPass=request.getParameter("password");
		LoginBean loginbean=new LoginBean();
		loginbean.setUserName(userName);
		loginbean.setUserPass(userPass);
		LoginDao loginDao=new LoginDao();
		String valid=loginDao.validate(loginbean);
		if(valid.equals("SUCCESS"))
		{
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/index.html").forward(request, response);
	
		}
		
		
		
		
		
		
	}

}
