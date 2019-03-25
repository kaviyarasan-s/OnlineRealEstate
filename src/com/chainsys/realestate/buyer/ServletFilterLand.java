package com.chainsys.realestate.buyer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.service.Filter;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.FilterImpl;
import com.chainsys.realestate.service.impl.ServiceLandImpl;

@WebServlet("/ServletFilterLand")
public class ServletFilterLand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletFilterLand() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Land land = new Land();
		ServiceLand serviceLand = new ServiceLandImpl();
		String propertyId = request.getParameter("propertytype");
		if (propertyId != null && !propertyId.isEmpty()) {
			Property property = new Property();
			property.setId(Integer.parseInt(propertyId));
			Property propertyDetails = serviceLand.getPropertyDetails(property);
			land.setProperty(propertyDetails);
		}
		String cityId = request.getParameter("city");
		if (cityId != null && !cityId.isEmpty()) {
			City city = new City();
			city.setId(Integer.parseInt(cityId));
			City cityDetails = serviceLand.getCityDetails(city);
			Location location = new Location();
			location.setCity(cityDetails);
			land.setLocation(location);
		}
		String purchaseType = request.getParameter("purchasetype");
		if (purchaseType != null && !purchaseType.isEmpty()) {
			land.setPurchaseType(purchaseType);
		}
		int bhk = Integer.parseInt(request.getParameter("bhk"));
		String price = request.getParameter("price");
		double priceAmount = 0;
		if (price != null && !price.isEmpty()) {
			priceAmount = Double.parseDouble(price);
			land.setPrice(BigDecimal.valueOf(priceAmount));
		}
		else
		{
			land.setPrice(BigDecimal.valueOf(0));
		}
		String transactionType = request.getParameter("transactiontype");
		if (bhk > 0) {
			land.setBhk(bhk);
		}
		else
		{
			land.setBhk(0);
		}
		System.out.println(transactionType);
		if (transactionType != null && !transactionType.isEmpty()) {
			land.setTransactionType(transactionType);
		}
		else
		{
			land.setTransactionType("");
		}
		Filter filter = new FilterImpl();
		if (land.getProperty() != null && land.getPurchaseType() != null
				&& !land.getPurchaseType().isEmpty()
				&& land.getLocation().getCity() != null) {
			List<Land> landDetails = filter.filterLandsDetails(land);
			if (landDetails != null && !landDetails.isEmpty()) {
				request.setAttribute("LANDDETAILS", landDetails);
			}
		}
		HttpSession httpSession = request.getSession();
		List<Property> propertyList = serviceLand.getAllProperty();
		List<City> cityList = serviceLand.getAllCity();
		request.setAttribute("email", httpSession.getAttribute("email"));
		request.setAttribute("proprtype", propertyId);
		request.setAttribute("cityid", cityId);
		request.setAttribute("bhk", bhk);
		request.setAttribute("price", priceAmount);
		request.setAttribute("trntype", transactionType);
		request.setAttribute("purchase", purchaseType);
		request.setAttribute("PROPERTYINFO", propertyList);
		request.setAttribute("CITY", cityList);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);

	}
}
