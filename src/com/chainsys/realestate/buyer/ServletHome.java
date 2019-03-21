package com.chainsys.realestate.buyer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.ServiceLandImpl;


@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletHome() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();		
		ServiceLand land=new ServiceLandImpl();
		List<Property> propertyList=land.getAllProperty();
		List<City> cityList=land.getAllCity();
		request.setAttribute("email", httpSession.getAttribute("email"));	
		request.setAttribute("PROPERTYINFO", propertyList);
		request.setAttribute("CITY", cityList);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
