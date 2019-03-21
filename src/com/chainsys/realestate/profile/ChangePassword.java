package com.chainsys.realestate.profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.constant.Constant;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Login;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.impl.LoginImpl;
import com.chainsys.realestate.service.impl.ProfileImpl;
import com.chainsys.realestate.validate.Validate;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassword() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String buttonAction = request.getParameter("button");
		if ("reset".equals(buttonAction)) {
			String email = request.getParameter("email");
			Users user = new Users();
			user.setEmail(email);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("email", email);
			Profile profile = new ProfileImpl();
			if (Validate.emailValidate(user.getEmail())) {
				if (profile.checkForgotPasswordEmail(user)) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("changepassword.jsp");
					requestDispatcher.forward(request, response);
				} else {
					request.setAttribute("MESSAGE",
							Constant.emailValidateMessage);
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("forgotpassword.jsp");
					requestDispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("MESSAGE", Constant.emailValidateMessage);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("forgotpassword.jsp");
				requestDispatcher.forward(request, response);
			}
		} else if ("change".equals(buttonAction)) {
			Users user = new Users();
			HttpSession httpSession = request.getSession();
			user.setEmail(httpSession.getAttribute("email").toString());
			user.setPassword(request.getParameter("newpassword"));
			Profile profile = new ProfileImpl();
			Login login = new LoginImpl();
			boolean isValid = login.checkLoginInputValidOrNot(user);
			if (isValid) {
				if (profile.changePassword(user)) {
					httpSession.invalidate();
					request.setAttribute("MESSAGE", Constant.forgotPasswordSuccessMessage);
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("login.jsp");
					requestDispatcher.forward(request, response);
				}
			}
		}
	}

}
