package com.chainsys.realestate.buyer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.service.Filter;
import com.chainsys.realestate.service.impl.FilterImpl;

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
		String propertyType = request.getParameter("propertytype");
		if (!propertyType.isEmpty() && propertyType != null) {
			Property property = new Property();
			property.setName(propertyType);
			land.setProperty(property);
		}
		String city=request.getParameter("city");
		if (!city.isEmpty() && city != null) {
			City cityDetails = new City();
			cityDetails.setName(propertyType);
			Location location=new Location();
			location.setCity(cityDetails);
			land.setLocation(location);
		}
		String purchaseType=request.getParameter("purchasetype");
		if (!purchaseType.isEmpty() && purchaseType != null) {
			land.setPurchaseType(purchaseType);
		}
		int bhk = Integer.parseInt(request.getParameter("bhk"));
		String price = request.getParameter("price");
		double priceAmount = 0;
		String transactionType = request.getParameter("transactiontype");
		if (!price.isEmpty() && price != null)
			land.setPrice(BigDecimal.valueOf(priceAmount));
		if (bhk > 0)
			land.setBhk(bhk);
		if (!transactionType.isEmpty() && transactionType != null)
			land.setTransactionType(transactionType);
		Filter filter = new FilterImpl();
//		System.out.println("propertyType"+propertyType);
//		System.out.println("purchaseType"+purchaseType);
//		System.out.println("city"+city);
//		System.out.println("bhk"+bhk);
//		System.out.println("price"+price);
//		System.out.println("transactionType"+transactionType);
		List<Land> landDetails = filter.filterLandsDetails(land);
//		System.out.println(landDetails);
	}
}
