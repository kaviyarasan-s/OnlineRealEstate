package com.chainsys.realestate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
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
	}

	@Override
	public boolean addLand(Land land) {
		boolean success = false;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			int result = (int) session.save(land);
			if (result > 0) {
				success = true;
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

	@Override
	public boolean editLand(Land land) {
		boolean success = true;
		session.beginTransaction();
		session.saveOrUpdate(land);
		return success;
	}

	@Override
	public City getCityById(City city) {
		City cityDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<City> query = session.createQuery(
					"from City where city_id=:id", City.class);
			query.setParameter("id", city.getId());
			List<City> cityList = query.list();
			if (!cityList.isEmpty() && cityList != null) {
				cityDetails = cityList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Location getLocationByIdAndCityId(Location location) {
		Location locationDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<Location> query = session
					.createQuery("from Location where city_id=:cityid and location_id=:locationid");
			query.setParameter("cityid", location.getCity().getId());
			query.setParameter("locationid", location.getId());
			List<Location> locationList = query.list();
			if (!locationList.isEmpty() && locationList != null) {
				locationDetails = locationList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return locationDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Location> getAllLocationByCityId(City city) {
		List<Location> locationDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<Location> query = session
					.createQuery("from Location where city_id=:cityid");
			query.setParameter("cityid", city.getId());
			locationDetails = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return locationDetails;
	}

	@Override
	public Property getPropertyById(Property property) {
		Property propertyDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<Property> query = session.createQuery(
					"from Property where property_id=:id", Property.class);
			query.setParameter("id", property.getId());
			List<Property> propertyList = query.list();
			if (!propertyList.isEmpty() && propertyList != null) {
				propertyDetails = propertyList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return propertyDetails;
	}

	@Override
	public List<City> getAllCityDetails() {
		List<City> cityDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<City> query = session.createQuery("from City", City.class);
			cityDetails = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityDetails;
	}

	@Override
	public List<Property> getAllPropertyDetails() {
		List<Property> propertyDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<Property> query = session.createQuery("from Property",
					Property.class);
			propertyDetails = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return propertyDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Location getLocationIdByName(Location location) {
		Location locationDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		try {
			Query<Location> query = session
					.createQuery("from Location where name=:locationname");
			query.setParameter("locationname", location.getName());
			List<Location> locationList = query.list();
			if (!locationList.isEmpty() && locationList != null) {
				locationDetails = locationList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return locationDetails;
	}

}
