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
		String button = request.getParameter("button");
		request.setAttribute(button, true);
		Profile profile=new ProfileImpl();
		HttpSession httpSession=request.getSession();
		String email=httpSession.getAttribute("email").toString();
		Users user=new Users();
		user.setEmail(email);
		Users userDetails=profile.getUserDetailsByEmail(user);
		request.setAttribute("USERDETAILS", userDetails);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("profile.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		request.setAttribute(button, false);
		Users user = new Users();
		if (request.getParameter("button").equals("editname")) {
			user.setName(request.getParameter("name"));
		}
		if (request.getParameter("button").equals("editemail")) {
			user.setEmail(request.getParameter("email"));
		}
		if (request.getParameter("button").equals("editpassword")) {
			user.setPassword(request.getParameter("password"));
		}
		if (request.getParameter("button").equals("editphonenumber")) {
			String number = request.getParameter("phonenumber");
			if (!number.isEmpty() && number != null) {
				user.setMobilenumber(Long.parseLong(number));
			}
		}		
		Profile profile = new ProfileImpl();
		HttpSession httpSession = request.getSession();
		String email = httpSession.getAttribute("email").toString();
		user.setEmail(email);
				boolean success = profile.editProfile(user);
		Users userDetails=profile.getUserDetailsByEmail(user);
		request.setAttribute("USERDETAILS", userDetails);
		if (success) {
			request.setAttribute("MESSAGE", Constant.updateSuccessMessage);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("profile.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("MESSAGE", Constant.updateFailureMessage);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("profile.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
