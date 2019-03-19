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
 * Servlet implementation class ServletPostLand
 */
@WebServlet("/ServletPostLand")
public class ServletPostLand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostLand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Land land=new Land();
		
		Users users=new Users();
		users.setId(5);
		users.setName("kavi");
		users.setEmail("kavi@gmail.com");
		users.setPassword("123");
		users.setMobilenumber(1231231231);
		land.setUser(users);
		Property property=new Property();
		property.setId(1);
		property.setName("Villa/House");
		land.setProperty(property);		
		Location location=new Location();
		City city=new City();
		city.setId(1);
		city.setName("Chennai");
		location.setCity(city);
		location.setId(4);
		location.setName("Guindy");
		land.setLocation(location);
		land.setPrice(BigDecimal.ZERO);
		land.setBhk(2);
		land.setBuildingName("Krish");
		land.setSize(1000);
		land.setTransactionType("New house");
		land.setPurchaseType("Sale");
		land.setDiscount(0);
		land.setDescription("Good one");
		land.setCreatedDate(LocalDateTime.now());
		land.setCreatedBy((long)5);
		
		ServiceLand serviceLand=new ServiceLandImpl();
		serviceLand.addLandInfo(land);
		
	}

}
