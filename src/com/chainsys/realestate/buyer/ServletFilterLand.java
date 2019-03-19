package com.chainsys.realestate.buyer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.service.Filter;
import com.chainsys.realestate.service.impl.FilterImpl;

/**
 * Servlet implementation class ServletFilterLand
 */
@WebServlet("/ServletFilterLand")
public class ServletFilterLand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFilterLand() {
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
		land.setBhk(2);
		land.setPrice(BigDecimal.ZERO);
//		land.setTransactionType("New house");
		Filter filter=new FilterImpl();
		List<Land> landDetails=filter.filterLandsDetails(land);
		System.out.println(landDetails);
	}

}
