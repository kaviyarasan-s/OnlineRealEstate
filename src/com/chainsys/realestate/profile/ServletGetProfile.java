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
@WebServlet("/ServletGetProfile")
public class ServletGetProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletGetProfile() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profile profile=new ProfileImpl();
		HttpSession httpSession=request.getSession(false);
		String email=httpSession.getAttribute("email").toString();
		long userId=Long.parseLong(httpSession.getAttribute("userId").toString()); 
		Users user=new Users();
		user.setEmail(email);
		user.setId(userId);
		Users userDetails=profile.getUserDetailsById(user);
//		request.setAttribute("email",httpSession.getAttribute("email"));
		request.setAttribute("USERDETAILS", userDetails);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("profile.jsp");
		requestDispatcher=request.getRequestDispatcher("home.jsp");
		request.setAttribute("ISPROFILE", true);
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
