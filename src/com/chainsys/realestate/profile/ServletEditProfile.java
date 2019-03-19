package com.chainsys.realestate.profile;

import java.io.IOException;
import java.time.LocalDateTime;

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
 * Servlet implementation class ServletEditProfile
 */
@WebServlet("/ServletEditProfile")
public class ServletEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEditProfile() {
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
		Users user = new Users();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setMobilenumber(Long.parseLong(request.getParameter("phonenumber")));
		HttpSession httpSession = request.getSession();
		// long userId=(long) httpSession.getAttribute("userid");
		user.setId(6);		
		user.setModifiedBy(6);
		user.setModifiedDate(LocalDateTime.now());
		Profile profile = new ProfileImpl();
		boolean success = profile.editProfile(user);
		if (success) {
			System.out.println("updated");
		}

	}

}
