package com.chainsys.realestate.profile;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.realestate.dao.UserDAO;
import com.chainsys.realestate.dao.impl.UserDAOImpl;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.impl.ProfileImpl;

/**
 * Servlet implementation class ServletRegister
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Users user=new Users();
		user.setId(5);
		UserDAO userDAO=new UserDAOImpl();
		Users userInfo=userDAO.getUserDetailsById(user);
		System.out.println(userInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long mobilenumber =Long.parseLong(request.getParameter("phonenumber"));
		Users users=new Users();
		users.setName(name);
		users.setEmail(email);
		users.setPassword(password);
		users.setMobilenumber(mobilenumber);
		users.setCreatedDate(LocalDateTime.now());
		Profile profile = new ProfileImpl();
		boolean registerResult = profile.userRegistration(users);
		if (registerResult) {
			request.setAttribute("message", "Registered successfully");
		} else {
			request.setAttribute("message", "Registration failed");
		}

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(request, response);
	}

}
