package com.chainsys.realestate.profile;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.realestate.constant.Constant;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.impl.ProfileImpl;

@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRegister() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("phonenumber");
		long mobilenumber=0;
		if (!number.isEmpty() && number != null) {
			mobilenumber = Long.parseLong(number);
		}
		Users users = new Users();
		users.setName(name);
		users.setEmail(email);
		users.setPassword(password);
		users.setMobilenumber(mobilenumber);
		users.setCreatedDate(LocalDateTime.now());
		Profile profile = new ProfileImpl();
		boolean isValid = profile.validateUserInfo(users);
		if (isValid) {
			boolean registerResult = profile.userRegistration(users);
			if (registerResult) {
				request.setAttribute("MESSAGE", Constant.regiterSuccessMessage);
			} else {
				request.setAttribute("MESSAGE", Constant.regiterFailedMessage);
			}
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("MESSAGE", Constant.inputNotValidMessage);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
