package com.chainsys.realestate.seller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.ServiceLandImpl;

/**
 * Servlet implementation class ServletEditLandInfo
 */
@WebServlet("/ServletEditLandInfo")
public class ServletEditLandInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEditLandInfo() {
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
		int propertyId = Integer.parseInt(request.getParameter("propertytype"));
		int cityId = Integer.parseInt(request.getParameter("city"));
		int locationId = Integer.parseInt(request.getParameter("locality"));
		double price = Double.parseDouble(request.getParameter("price"));
		int bhk = Integer.parseInt(request.getParameter("bhk"));
		String buildingName = request.getParameter("buildingname");
		int size = Integer.parseInt(request.getParameter("landsize"));
		String transactionType = request.getParameter("transactiontype");
		String purchaseType = request.getParameter("purchasetype");
		int discount = Integer.parseInt(request.getParameter("discount"));
		String description=request.getParameter("description");
		String status=request.getParameter("status");
		ServiceLand serviceLand = new ServiceLandImpl();
		Land land = new Land();
		Users users = new Users();
		users.setId(5);
		users.setName("kavi");
		users.setEmail("kavi@gmail.com");
		users.setPassword("12345");
		users.setMobilenumber(1231231231);
		land.setUser(users);
		Property property = new Property();
		property.setId(propertyId);
		property = serviceLand.getPropertyDetails(property);
		land.setProperty(property);
		Location location = new Location();
		City city = new City();
		city.setId(cityId);		
		city = serviceLand.getCityDetails(city);		
		location.setCity(city);		
		location.setId(locationId);
		location = serviceLand.getLocationDetails(location);
		land.setLocation(location);
		land.setPrice(BigDecimal.valueOf(price));
		land.setBhk(bhk);
		land.setBuildingName(buildingName);
		land.setSize(size);
		land.setTransactionType(transactionType);
		land.setPurchaseType(purchaseType);
		land.setDiscount(discount);
		land.setStatus(status);
		land.setDescription(description);
		land.setModifiedDate(LocalDateTime.now());
		land.setModifiedBy((long) 5);
		serviceLand.editLandInfo(land);
	}

}
