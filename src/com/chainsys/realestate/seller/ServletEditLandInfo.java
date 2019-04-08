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
import com.chainsys.realestate.service.Filter;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.service.impl.FilterImpl;
import com.chainsys.realestate.service.impl.ProfileImpl;
import com.chainsys.realestate.service.impl.ServiceLandImpl;

@WebServlet("/ServletEditLandInfo")
public class ServletEditLandInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int landId = Integer.parseInt(request.getParameter("editland"));
		Land land = new Land();
		land.setId(landId);
		ServiceLand serviceLand = new ServiceLandImpl();
		Land landInformations = serviceLand.getLandDetailsByLandId(land);
		List<City> cityDetails = serviceLand.getAllCity();
		List<Property> propertyTypes = serviceLand.getAllProperty();
		request.setAttribute("PROPERTYINFO", propertyTypes);
		request.setAttribute("CITY", cityDetails);
		request.setAttribute("landId", landInformations.getId());
		request.setAttribute("propertytype", landInformations.getProperty()
				.getId());
		request.setAttribute("price", landInformations.getPrice());
		request.setAttribute("cityname", landInformations.getLocation()
				.getCity().getId());
		request.setAttribute("buildingname", landInformations.getBuildingName());
		request.setAttribute("landsize", landInformations.getSize());
		request.setAttribute("discount", landInformations.getDiscount());
		request.setAttribute("description", landInformations.getDescription());
		request.setAttribute("bhk", landInformations.getBhk());
		request.setAttribute("trntype", landInformations.getTransactionType());
		request.setAttribute("purchase", landInformations.getPurchaseType());
		request.setAttribute("status", landInformations.getStatus());
		request.setAttribute("location", landInformations.getLocation()
				.getId());
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("editlandinfo.jsp");
		request.setAttribute("ISEDITLAND", true);
		requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String propertyType = request.getParameter("propertytype");
		int propertyId = 0;
		if (!propertyType.equals("0")) {
			propertyId = Integer.parseInt(propertyType);
		}
		String cityName = request.getParameter("city");
		int cityId = 0;
		if (!cityName.equals("0")) {
			cityId = Integer.parseInt(cityName);
		}
		String locationName = request.getParameter("locality");
		int locationId = 0;
		if (!locationName.equals("0")) {
			locationId = Integer.parseInt(locationName );
		}
		String landPrice = request.getParameter("price").trim();
		double price = 0;
		if (landPrice != null && !landPrice.isEmpty()) {
			price = Double.parseDouble(landPrice);
		}
		String landBHK = request.getParameter("bhk");
		int bhk = 0;
		if (!landBHK.equals("0")) {
			bhk = Integer.parseInt(landBHK);
		}
		String buildingName = request.getParameter("buildingname");
		String landSize = request.getParameter("landsize").trim();
		int size = 0;
		if (landSize != null && !landSize.isEmpty()) {
			size = Integer.parseInt(landSize);
		}
		String transactionType = request.getParameter("transactiontype");
		String purchaseType = request.getParameter("purchasetype");
		String landDiscount = request.getParameter("discount").trim();
		int discount = 0;
		if (landDiscount != null && !landDiscount.isEmpty()) {
			discount = Integer.parseInt(landDiscount);
		}
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		ServiceLand serviceLand = new ServiceLandImpl();
		Land land = new Land();
		land.setId(Integer.parseInt(request.getParameter("landId")));
		HttpSession httpSession = request.getSession();
		Users users = new Users();
		users.setEmail(httpSession.getAttribute("email").toString());
		users.setId(Long.parseLong(httpSession.getAttribute("userId").toString()));
		Profile profile = new ProfileImpl();
//		Users userDetails = profile.getUserDetailsByEmail(users);
		Users userDetails = profile.getUserDetailsById(users);
		land.setUser(userDetails);
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
		if (!transactionType.equals("0")) {
			land.setTransactionType(transactionType);
		}
		if (!purchaseType.equals("0")) {
			land.setPurchaseType(purchaseType);
		}
		land.setDiscount(discount);
		if (!status.equals("0")) {
			land.setStatus(status);
		}
		land.setDescription(description);
		land.setModifiedDate(LocalDateTime.now());
		land.setModifiedBy(userDetails.getId());
		boolean postLandResult = serviceLand.editLandInfo(land);
		if (postLandResult) {
			request.setAttribute("MESSAGE", Constant.updateLandInfoSuccessMessage);
		} else {
			request.setAttribute("MESSAGE", Constant.updateLandInfoFailureMessage);
		}
		//redirect to own land page
		Users user = new Users();
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

}
