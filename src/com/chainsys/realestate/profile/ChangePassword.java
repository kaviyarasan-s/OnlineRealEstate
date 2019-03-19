package com.chainsys.realestate.profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.impl.ProfileImpl;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String buttonAction = request.getParameter("button");
		if ("reset".equals(buttonAction)) {
			String email=request.getParameter("email");
			Users user = new Users();
			user.setEmail(email);
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("email", email);
			Profile profile = new ProfileImpl();
			if (profile.checkForgotPasswordEmail(user)) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("changepassword.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("forgotpassword.jsp");
				requestDispatcher.forward(request, response);
			}
		} else if ("change".equals(buttonAction)) {
			Users user = new Users();
			HttpSession httpSession=request.getSession();
			user.setEmail(httpSession.getAttribute("email").toString());
			user.setPassword(request.getParameter("newpassword"));
			Profile profile = new ProfileImpl();
			if (profile.changePassword(user)) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}

}
