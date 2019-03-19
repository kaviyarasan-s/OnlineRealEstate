package com.chainsys.realestate.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Login;
import com.chainsys.realestate.service.impl.LoginImpl;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		Users users=new Users();
		users.setEmail(userName);
		users.setPassword(password);
		
		Login login=new LoginImpl();
		boolean loginResult=login.checkLogin(users);
		if(loginResult)
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);
		}
		else
		{			
			request.setAttribute("message", "Invalid username and passsword");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}

}
