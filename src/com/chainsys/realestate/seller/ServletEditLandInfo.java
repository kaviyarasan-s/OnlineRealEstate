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

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.ServiceLandImpl;

@WebServlet("/ServletEditLandInfo")
public class ServletEditLandInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int landId=Integer.parseInt(request.getParameter("editland"));
		Land land=new Land();
		land.setId(landId);
		ServiceLand serviceLand=new ServiceLandImpl();
		Land landInformations=serviceLand.getLandDetailsByLandId(land);
		List<City> cityDetails = serviceLand.getAllCity();
		List<Property> propertyTypes = serviceLand.getAllProperty();
		request.setAttribute("PROPERTYINFO", propertyTypes);
		request.setAttribute("CITY", cityDetails);
		request.setAttribute("propertytype", landInformations.getProperty().getId());
		request.setAttribute("price", landInformations.getPrice());
		request.setAttribute("cityname", landInformations.getLocation().getCity().getId());
		request.setAttribute("buildingname", landInformations.getBuildingName());
		request.setAttribute("landsize", landInformations.getSize());
		request.setAttribute("discount", landInformations.getDiscount());
		request.setAttribute("description", landInformations.getDescription());
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("editlandinfo.jsp");
		request.setAttribute("ISEDITLAND", true);
		requestDispatcher = request
				.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);
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
