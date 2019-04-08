package com.chainsys.realestate.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Filter;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.FilterImpl;
import com.chainsys.realestate.service.impl.ServiceLandImpl;

@WebServlet("/ServletGetOwnLand")
public class ServletGetOwnLand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();
		HttpSession httpSession = request.getSession();
		long userId = Long.parseLong(httpSession.getAttribute("userId")
				.toString());
		user.setId(userId);
		Filter filter = new FilterImpl();
		List<Land> landList = filter.filterOwnLandsDetails(user);
		if (!landList.isEmpty() && landList != null) {
			request.setAttribute("LANDDETAILS", landList);
		} else {
			request.setAttribute("LANDDETAILS", null);
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("ownland.jsp");
		request.setAttribute("OWNLAND", true);
		requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
