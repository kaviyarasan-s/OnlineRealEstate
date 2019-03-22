package com.chainsys.realestate.seller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.ProfileImpl;
import com.chainsys.realestate.service.impl.ServiceLandImpl;
@WebServlet("/ServletPostLand")
public class ServletPostLand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletPostLand() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServiceLand serviceLand = new ServiceLandImpl();
		List<City> cityDetails = serviceLand.getAllCity();
		List<Property> propertyTypes = serviceLand.getAllProperty();
		String value = request.getParameter("city");
		if (value == null) {
			request.setAttribute("PROPERTYINFO", propertyTypes);
			request.setAttribute("CITY", cityDetails);
			RequestDispatcher rd1 = request
					.getRequestDispatcher("LandDetail.jsp");
			rd1.forward(request, response);
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			int cityId = Integer.parseInt(request.getParameter("city"));
			if (cityId > 0) {
				City city = new City();
				city.setId(cityId);
				List<Location> locationList = serviceLand
						.getAllLocationDetailsByCityId(city);
				for (int i = 0; i < locationList.size(); i++) {
					stringBuilder.append(locationList.get(i).getId() + ",");
					stringBuilder.append(locationList.get(i).getName());
					if ((locationList.size() - 1) != i) {
						stringBuilder.append(',');
					}
				}
			}
			response.setContentType("text/plain");
			response.getWriter().write(stringBuilder.toString());
		}
	}
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
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		ServiceLand serviceLand = new ServiceLandImpl();
		Land land = new Land();
		HttpSession httpSession=request.getSession(); 
		Users users= new Users();
		users.setEmail(httpSession.getAttribute("email").toString());
//		users.setId(5);
//		users.setName("kavi");
//		users.setEmail("kavi@gmail.com");
//		users.setPassword("12345");
//		users.setMobilenumber(1231231231);
		Profile profile=new ProfileImpl();
		Users userDetails =profile.getUserDetailsByEmail(users);
		land.setUser(userDetails );
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
		land.setCreatedDate(LocalDateTime.now());
		land.setCreatedBy((long) 5);
		boolean postLandResult=serviceLand.addLandInfo(land);
		if(postLandResult)
		{
			request.setAttribute("MESSAGE",Constant.postLandSuccessMessage);
		}
		else
		{
			request.setAttribute("MESSAGE",Constant.postLandFailureMessage);
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("LandDetail.jsp");
		requestDispatcher.forward(request, response);
	}

}
