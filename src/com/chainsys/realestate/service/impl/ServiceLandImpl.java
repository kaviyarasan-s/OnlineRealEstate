package com.chainsys.realestate.service.impl;

import java.util.List;

import com.chainsys.realestate.dao.LandDAO;
import com.chainsys.realestate.dao.impl.LandDAOImpl;
import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.validate.LandInfoValidation;

public class ServiceLandImpl implements ServiceLand {

	@Override
	public boolean validateLandInfo(Land land) {

		return LandInfoValidation.landValidation(land);
	}

	@Override
	public boolean addLandInfo(Land land) {
		boolean success = false;
		if (validateLandInfo(land)) {
			LandDAO landDAO = new LandDAOImpl();
			success = landDAO.addLand(land);

		}

		return success;
	}

	@Override
	public boolean editLandInfo(Land land) {
		boolean success = false;
		
		if (validateLandInfo(land)) {
			LandDAO landDAO = new LandDAOImpl();
			success = landDAO.editLand(land);
		}
		return success;
	}

	@Override
	public City getCityDetails(City city) {
		City cityDetails=null;
		if(city.getId()>0)
		{
			LandDAO landDAO=new LandDAOImpl();
			cityDetails=landDAO.getCityById(city);
		}
		return cityDetails;
	}

	@Override
	public Location getLocationDetails(Location location) {
		Location locationDetails=null;
		if(location.getId()>0)
		{
			LandDAO landDAO=new LandDAOImpl();
			locationDetails=landDAO.getLocationByIdAndCityId(location);
		}
		return locationDetails;
	}
	public Location getLocationDetailsByName(Location location) {
			LandDAO landDAO=new LandDAOImpl();
			Location locationDetails=landDAO.getLocationIdByName(location);
		
		return locationDetails;
	}

	public List<Location> getAllLocationDetailsByCityId(City city)
	{
		LandDAO landDAO=new LandDAOImpl();
		List<Location> locationList=landDAO.getAllLocationByCityId(city);
		return locationList;
	}
	@Override
	public Property getPropertyDetails(Property property) {
		Property propertyDetails=null;
		if(property.getId()>0)
		{
			LandDAO landDAO=new LandDAOImpl();
			propertyDetails=landDAO.getPropertyById(property);
		}
		return propertyDetails;
	}

	@Override
	public List<City> getAllCity() {		
		LandDAO landDAO=new LandDAOImpl();
		List<City> cityList=landDAO.getAllCityDetails();
		return cityList;
	}

	@Override
	public List<Property> getAllProperty() {
		LandDAO landDAO=new LandDAOImpl();
		List<Property> propertyList=landDAO.getAllPropertyDetails();
		return propertyList;
	}

}
