package com.chainsys.realestate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.realestate.dao.LandDAO;
import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.util.HibernateConnectionUtil;

public class LandDAOImpl implements LandDAO {
	static SessionFactory sessionFactory;
	static Session session;

	public LandDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateConnectionUtil.getSessionFactory();
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
	}

	@Override
	public boolean addLand(Land land) {
		boolean success = false;
		int result = (int) session.save(land);
		if (result > 0) {
			success = true;
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return success;
	}

	@Override
	public boolean editLand(Land land) {
		boolean success = true;

		session.beginTransaction();
		session.saveOrUpdate(land);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return success;
	}

	@Override	
	public City getCityById(City city) {

		Query<City> query = session.createQuery("from City where city_id=:id",
				City.class);
		query.setParameter("id", city.getId());
		City cityDetails = null;
		List<City> cityList = query.list();
		if (!cityList.isEmpty() && cityList != null) {
			cityDetails = cityList.get(0);
		}
		return cityDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Location getLocationByIdAndCityId(Location location) {
		Query<Location> query = session
				.createQuery("from Location where city_id=:cityid and location_id=:locationid");
		query.setParameter("cityid", location.getCity().getId());
		query.setParameter("locationid", location.getId());
		Location locationDetails = null;
		List<Location> locationList = query.list();
		if (!locationList.isEmpty() && locationList != null) {
			locationDetails = locationList.get(0);
		}
		return locationDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Location> getAllLocationByCityId(City city) {
		Query<Location> query = session
				.createQuery("from Location where city_id=:cityid");
		query.setParameter("cityid", city.getId());
		List<Location> locationDetails = query.list();
		return locationDetails;
	}

	
	@Override
	public Property getPropertyById(Property property) {
		Query<Property> query = session.createQuery(
				"from Property where property_id=:id", Property.class);
		query.setParameter("id", property.getId());
		Property propertyDetails = null;
		List<Property> propertyList = query.list();
		if (!propertyList.isEmpty() && propertyList != null) {
			propertyDetails = propertyList.get(0);
		}
		return propertyDetails;
	}

	@Override
	public List<City> getAllCityDetails() {
		Query<City> query = session.createQuery("from City", City.class);
		List<City> cityDetails = query.list();
		return cityDetails;
	}

	@Override
	public List<Property> getAllPropertyDetails() {
		Query<Property> query = session.createQuery("from Property",
				Property.class);
		List<Property> propertyDetails = query.list();
		return propertyDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Location getLocationIdByName(Location location) {
		Query<Location> query = session
				.createQuery("from Location where name=:locationname");
		query.setParameter("locationname", location.getName());
		Location locationDetails = null;
		List<Location> locationList = query.list();
		if (!locationList.isEmpty() && locationList != null) {
			locationDetails = locationList.get(0);
		}
		return locationDetails;
	}

}
