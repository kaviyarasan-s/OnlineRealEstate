package com.chainsys.realestate.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.realestate.dao.FilterDAO;
import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.util.ConnectionUtil;

public class FilterDAOImpl implements FilterDAO {
	@Override
	public List<Land> filerLandByBhkPriceTrnType(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Land> landDetailsList = new ArrayList<Land>();
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname ,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where lu.bhk=? and lu.transaction_type=? and lu.price=? and "
					+ "lu.purchasetype=? and lu.property_id=? and lu.location_id in (select location_id from RL_EST_LOCATION where city_id=?) and u.user_id!=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, land.getBhk());
			preparedStatement.setString(2, land.getTransactionType());
			preparedStatement.setBigDecimal(3, land.getPrice());
			preparedStatement.setString(4, land.getPurchaseType());
			preparedStatement.setInt(5, land.getProperty().getId());
			preparedStatement.setInt(6, land.getLocation().getCity().getId());
			preparedStatement.setLong(7, land.getUser().getId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Land addLandDetails = new Land();
				Users user = new Users();
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setMobilenumber(resultSet.getLong("phonenumber"));
				addLandDetails.setUser(user);
				Property property = new Property();
				property.setName(resultSet.getString("propertyname"));
				addLandDetails.setProperty(property);
				Location location = new Location();
				City city = new City();
				city.setName(resultSet.getString("cityname"));
				location.setCity(city);
				location.setName(resultSet.getString("locationname"));
				addLandDetails.setLocation(location);
				addLandDetails.setBhk(resultSet.getInt("bhk"));
				addLandDetails.setPrice(BigDecimal.valueOf(resultSet
						.getLong("price")));
				addLandDetails.setBuildingName(resultSet
						.getString("building_name"));
				addLandDetails.setSize(resultSet.getInt("land_size"));
				addLandDetails.setTransactionType(resultSet
						.getString("transaction_type"));
				addLandDetails.setPurchaseType(resultSet
						.getString("purchasetype"));
				addLandDetails.setDescription(resultSet
						.getString("description"));
				addLandDetails.setStatus(resultSet.getString("status"));
				addLandDetails.setDiscount(resultSet.getInt("discount"));
				landDetailsList.add(addLandDetails);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return landDetailsList;
	}

	@Override
	public List<Land> filerLandByBhkPrice(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Land> landDetailsList = new ArrayList<Land>();
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname ,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where lu.bhk=?  and lu.price=? and u.user_id!=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, land.getBhk());
			preparedStatement.setBigDecimal(2, land.getPrice());
			preparedStatement.setLong(3, land.getUser().getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Land addLandDetails = new Land();
					Users user = new Users();
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setMobilenumber(resultSet.getLong("phonenumber"));
					addLandDetails.setUser(user);
					Property property = new Property();
					property.setName(resultSet.getString("propertyname"));
					addLandDetails.setProperty(property);
					Location location = new Location();
					City city = new City();
					city.setName(resultSet.getString("cityname"));
					location.setCity(city);
					location.setName(resultSet.getString("locationname"));
					addLandDetails.setLocation(location);
					addLandDetails.setBhk(resultSet.getInt("bhk"));
					addLandDetails.setPrice(BigDecimal.valueOf(resultSet
							.getLong("price")));
					addLandDetails.setBuildingName(resultSet
							.getString("building_name"));
					addLandDetails.setSize(resultSet.getInt("land_size"));
					addLandDetails.setTransactionType(resultSet
							.getString("transaction_type"));
					addLandDetails.setPurchaseType(resultSet
							.getString("purchasetype"));
					addLandDetails.setDescription(resultSet
							.getString("description"));
					addLandDetails.setStatus(resultSet.getString("status"));
					addLandDetails.setDiscount(resultSet.getInt("discount"));
					landDetailsList.add(addLandDetails);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return landDetailsList;
	}

	@Override
	public List<Land> filerLandByBhkTrnType(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Land> landDetailsList = new ArrayList<Land>();
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where lu.transaction_type=? and lu.bhk=?  and u.user_id!=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, land.getTransactionType());
			preparedStatement.setInt(2, land.getBhk());
			preparedStatement.setLong(3, land.getUser().getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Land addLandDetails = new Land();
					Users user = new Users();
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setMobilenumber(resultSet.getLong("phonenumber"));
					addLandDetails.setUser(user);
					Property property = new Property();
					property.setName(resultSet.getString("propertyname"));
					addLandDetails.setProperty(property);
					Location location = new Location();
					City city = new City();
					city.setName(resultSet.getString("cityname"));
					location.setCity(city);
					location.setName(resultSet.getString("locationname"));
					addLandDetails.setLocation(location);
					addLandDetails.setBhk(resultSet.getInt("bhk"));
					addLandDetails.setPrice(BigDecimal.valueOf(resultSet
							.getLong("price")));
					addLandDetails.setBuildingName(resultSet
							.getString("building_name"));
					addLandDetails.setSize(resultSet.getInt("land_size"));
					addLandDetails.setTransactionType(resultSet
							.getString("transaction_type"));
					addLandDetails.setPurchaseType(resultSet
							.getString("purchasetype"));
					addLandDetails.setDescription(resultSet
							.getString("description"));
					addLandDetails.setStatus(resultSet.getString("status"));
					addLandDetails.setDiscount(resultSet.getInt("discount"));
					landDetailsList.add(addLandDetails);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return landDetailsList;
	}

	@Override
	public List<Land> filerLandByPriceTrnType(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Land> landDetailsList = new ArrayList<Land>();
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where lu.transaction_type=? and lu.price=? and u.user_id!=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, land.getTransactionType());
			preparedStatement.setBigDecimal(2, land.getPrice());
			preparedStatement.setLong(3, land.getUser().getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Land addLandDetails = new Land();
					Users user = new Users();
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setMobilenumber(resultSet.getLong("phonenumber"));
					addLandDetails.setUser(user);
					Property property = new Property();
					property.setName(resultSet.getString("propertyname"));
					addLandDetails.setProperty(property);
					Location location = new Location();
					City city = new City();
					city.setName(resultSet.getString("cityname"));
					location.setCity(city);
					location.setName(resultSet.getString("locationname"));
					addLandDetails.setLocation(location);
					addLandDetails.setBhk(resultSet.getInt("bhk"));
					addLandDetails.setPrice(BigDecimal.valueOf(resultSet
							.getLong("price")));
					addLandDetails.setBuildingName(resultSet
							.getString("building_name"));
					addLandDetails.setSize(resultSet.getInt("land_size"));
					addLandDetails.setTransactionType(resultSet
							.getString("transaction_type"));
					addLandDetails.setPurchaseType(resultSet
							.getString("purchasetype"));
					addLandDetails.setDescription(resultSet
							.getString("description"));
					addLandDetails.setStatus(resultSet.getString("status"));
					addLandDetails.setDiscount(resultSet.getInt("discount"));
					landDetailsList.add(addLandDetails);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return landDetailsList;
	}

	public List<Land> basicFiler(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		List<Land> landDetailsList = new ArrayList<Land>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where lu.purchasetype=? and lu.property_id=? and lu.location_id in (select location_id from RL_EST_LOCATION where city_id=?) and u.user_id!=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, land.getPurchaseType());
			preparedStatement.setInt(2, land.getProperty().getId());
			preparedStatement.setInt(3, land.getLocation().getCity().getId());
			preparedStatement.setLong(4, land.getUser().getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Land addLandDetails = new Land();
					Users user = new Users();
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setMobilenumber(resultSet.getLong("phonenumber"));
					addLandDetails.setUser(user);
					Property property = new Property();
					property.setName(resultSet.getString("propertyname"));
					addLandDetails.setProperty(property);
					Location location = new Location();
					City city = new City();
					city.setName(resultSet.getString("cityname"));
					location.setCity(city);
					location.setName(resultSet.getString("locationname"));
					addLandDetails.setLocation(location);
					addLandDetails.setBhk(resultSet.getInt("bhk"));
					addLandDetails.setPrice(BigDecimal.valueOf(resultSet
							.getLong("price")));
					addLandDetails.setBuildingName(resultSet
							.getString("building_name"));
					addLandDetails.setSize(resultSet.getInt("land_size"));
					addLandDetails.setTransactionType(resultSet
							.getString("transaction_type"));
					addLandDetails.setPurchaseType(resultSet
							.getString("purchasetype"));
					addLandDetails.setDescription(resultSet
							.getString("description"));
					addLandDetails.setStatus(resultSet.getString("status"));
					addLandDetails.setDiscount(resultSet.getInt("discount"));
					landDetailsList.add(addLandDetails);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return landDetailsList;
	}

	@Override
	public List<Land> filerLandByBhkOrPriceOrTrnType(Land land) {
		Connection connection = ConnectionUtil.getConnection();
		List<Land> landDetailsList = new ArrayList<Land>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname ,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where (lu.bhk=? or lu.transaction_type=?  or lu.price=?) and "
					+ "(lu.purchasetype=? and lu.property_id=? and lu.location_id in (select location_id from RL_EST_LOCATION where city_id=?)) and u.user_id!=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, land.getBhk());
			preparedStatement.setString(2, land.getTransactionType());
			preparedStatement.setBigDecimal(3, land.getPrice());
			preparedStatement.setString(4, land.getPurchaseType());
			preparedStatement.setInt(5, land.getProperty().getId());
			preparedStatement.setInt(6, land.getLocation().getCity().getId());
			preparedStatement.setLong(7, land.getUser().getId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Land addLandDetails = new Land();
				Users user = new Users();
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setMobilenumber(resultSet.getLong("phonenumber"));
				addLandDetails.setUser(user);
				Property property = new Property();
				property.setName(resultSet.getString("propertyname"));
				addLandDetails.setProperty(property);
				Location location = new Location();
				City city = new City();
				city.setName(resultSet.getString("cityname"));
				location.setCity(city);
				location.setName(resultSet.getString("locationname"));
				addLandDetails.setLocation(location);
				addLandDetails.setBhk(resultSet.getInt("bhk"));
				addLandDetails.setPrice(BigDecimal.valueOf(resultSet
						.getLong("price")));
				addLandDetails.setBuildingName(resultSet
						.getString("building_name"));
				addLandDetails.setSize(resultSet.getInt("land_size"));
				addLandDetails.setTransactionType(resultSet
						.getString("transaction_type"));
				addLandDetails.setPurchaseType(resultSet
						.getString("purchasetype"));
				addLandDetails.setDescription(resultSet
						.getString("description"));
				addLandDetails.setStatus(resultSet.getString("status"));
				addLandDetails.setDiscount(resultSet.getInt("discount"));
				landDetailsList.add(addLandDetails);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return landDetailsList;
	}

	@Override
	public List<Land> filerOwnLandByUserId(Users userDetails) {
		Connection connection = ConnectionUtil.getConnection();
		List<Land> landDetailsList = new ArrayList<Land>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			String query = "select "
					+ "u.name,u.phonenumber,u.email, "
					+ "p.name as propertyname, "
					+ "lu.price,lu.bhk,lu.building_name,lu.land_size,lu.transaction_type,lu.purchasetype,lu.discount,lu.description,lu.status, "
					+ "c.name as cityname ,l.name as locationname  from RL_EST_LAND lu "
					+ "join RL_EST_PROPERTYTYPE p on lu.property_id=p.property_id "
					+ "join RL_EST_LOCATION l on lu.location_id=l.location_id "
					+ "join RL_EST_CITY c on c.city_id = l.city_id "
					+ "join RL_EST_LAND_USER u on u.user_id=lu.user_id "
					+ "where u.user_id=?";
			preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, userDetails.getId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Land addLandDetails = new Land();
				Users user = new Users();
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setMobilenumber(resultSet.getLong("phonenumber"));
				addLandDetails.setUser(user);
				Property property = new Property();
				property.setName(resultSet.getString("propertyname"));
				addLandDetails.setProperty(property);
				Location location = new Location();
				City city = new City();
				city.setName(resultSet.getString("cityname"));
				location.setCity(city);
				location.setName(resultSet.getString("locationname"));
				addLandDetails.setLocation(location);
				addLandDetails.setBhk(resultSet.getInt("bhk"));
				addLandDetails.setPrice(BigDecimal.valueOf(resultSet
						.getLong("price")));
				addLandDetails.setBuildingName(resultSet
						.getString("building_name"));
				addLandDetails.setSize(resultSet.getInt("land_size"));
				addLandDetails.setTransactionType(resultSet
						.getString("transaction_type"));
				addLandDetails.setPurchaseType(resultSet
						.getString("purchasetype"));
				addLandDetails.setDescription(resultSet
						.getString("description"));
				addLandDetails.setStatus(resultSet.getString("status"));
				addLandDetails.setDiscount(resultSet.getInt("discount"));
				landDetailsList.add(addLandDetails);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				ConnectionUtil.closeConnection(connection, preparedStatement,
						resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return landDetailsList;
	}
}
