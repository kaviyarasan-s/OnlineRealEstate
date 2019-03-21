package com.chainsys.realestate.profile;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.constant.Constant;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.impl.ProfileImpl;

@WebServlet("/ServletEditProfile")
public class ServletEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEditProfile() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String number = request.getParameter("phonenumber");
		if (!number.isEmpty() && number != null) {
			user.setMobilenumber(Long.parseLong(number));
		}
		HttpSession httpSession = request.getSession();
		long userId = (long) httpSession.getAttribute("userid");
		user.setId(userId);
		user.setModifiedBy(userId);
		user.setModifiedDate(LocalDateTime.now());
		Profile profile = new ProfileImpl();
		boolean success = profile.editProfile(user);
		if (success) {
			request.setAttribute("MESSAGE", Constant.updateSuccessMessage);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("MESSAGE", Constant.updateFailureMessage);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
