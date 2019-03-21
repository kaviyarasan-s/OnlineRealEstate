package com.chainsys.realestate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.realestate.dao.FilterDAO;
import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.util.ConnectionUtil;
import com.chainsys.realestate.util.HibernateConnectionUtil;

public class FilterDAOImpl implements FilterDAO {
	static SessionFactory sessionFactory;
	static Session session;

	public FilterDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateConnectionUtil.getSessionFactory();
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByBhkPriceTrnType(Land land) {

		Query<Land> query = session
				.createQuery("from Land where bhk=:bhk and price=:price and transactionType=:trntype and "
						+ "propertyType.name=:prpertype and location.id=:location and purchaseType=:purchasetype");
		query.setParameter("bhk", land.getBhk());
		query.setParameter("price", land.getPrice());
		query.setParameter("trntype", land.getTransactionType());
		query.setParameter("prpertype", land.getProperty().getName());
		query.setParameter("location", land.getLocation().getId());
		query.setParameter("purchasetype", land.getPurchaseType());
		List<Land> landDetails = query.list();
		return landDetails;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByBhkPrice(Land land) {

		Query<Land> query = session
				.createQuery("from Land where bhk=:bhk and price=:price");
		query.setParameter("bhk", land.getBhk());
		query.setParameter("price", land.getPrice());

		List<Land> landDetails = query.list();
		return landDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByBhkTrnType(Land land) {
		Query<Land> query = session
				.createQuery("from Land where bhk=:bhk and transactionType=:trntype");
		query.setParameter("bhk", land.getBhk());
		query.setParameter("trntype", land.getTransactionType());
		List<Land> landDetails = query.list();
		return landDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByPriceTrnType(Land land) {
		Query<Land> query = session
				.createQuery("from Land where price=:price and transactionType=:trntype");

		query.setParameter("price", land.getPrice());
		query.setParameter("trntype", land.getTransactionType());
		List<Land> landDetails = query.list();
		return landDetails;
	}

	@Override
	public List<Land> getLandDetailsById(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		String query = "select "
				+ "u.name,u.email,u.password,u.PHONENUMBER, "
				+ "land.price,land.bhk,land.BUILDING_NAME,land.LAND_SIZE,land.TRANSACTION_TYPE,land.PURCHASETYPE,land.DISCOUNT,land.DESCRIPTION, "
				+ "location.NAME as locationname,c.NAME as cityname,p.name as propertyname "
				+ "from rl_est_land land "
				+ "join rl_est_land_user u on u.user_id =land.user_id "
				+ "join RL_EST_LOCATION location on land.LOCATION_ID =location.LOCATION_ID "
				+ "join rl_est_city c on c.city_id=location.CITY_ID "
				+ "join rl_est_propertytype p on p.property_id=land.property_id "
				+ "where land.USER_ID=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, land.getUser().getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet!=null)
			{
				List<Land> landDetailsList=new ArrayList<Land>();
				while(resultSet.next())
				{
					Land addLandDetails=new Land();
					Users user=new Users();
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setMobilenumber(resultSet.getLong("phonenumber"));
					land.setUser(user);
					Property property=new Property();
					property.setName(resultSet.getString("propertyname"))	;
					land.setProperty(property);
					Location location=new Location();
					City city=new City();
					city.setName(resultSet.getString("cityname"));
					location.setCity(city);
					location.setName(resultSet.getString("locationname"));
					land.setLocation(location);
					land.setBhk(resultSet.getInt("bhk"));
					land.setBuildingName(resultSet.getString("building_name"));
					land.setSize(resultSet.getInt("land_size"));
					land.setTransactionType(resultSet.getString("transaction_type"));
					land.setPurchaseType(resultSet.getString("purchasetype"));
					land.setDescription(resultSet.getString("description"));
					land.setDiscount(resultSet.getInt("discount"));
					landDetailsList.add(land);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
