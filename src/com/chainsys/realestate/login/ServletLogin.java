package com.chainsys.realestate.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.constant.Constant;
import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Login;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.LoginImpl;
import com.chainsys.realestate.service.impl.ServiceLandImpl;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users users = new Users();
		users.setEmail(email);
		users.setPassword(password);
		Login login = new LoginImpl();
		boolean isValid = login.loginValidate(users);
		if (isValid) {
			boolean loginResult = login.checkLogin(users);
			if (loginResult) {
				ServiceLand land=new ServiceLandImpl();
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("email", users.getEmail());
				List<Property> propertyList=land.getAllProperty();
				List<City> cityList=land.getAllCity();
				request.setAttribute("email", users.getEmail());	
				request.setAttribute("PROPERTYINFO", propertyList);
				request.setAttribute("CITY", cityList);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("home.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("MESSAGE", Constant.loginValidateMessage);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("MESSAGE", Constant.loginInputValidateMessage);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
