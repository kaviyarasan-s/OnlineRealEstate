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
	LandDAO landDAO = new LandDAOImpl();

	@Override
	public boolean validateLandInfo(Land land) {

		return LandInfoValidation.landValidation(land);
	}

	@Override
	public boolean addLandInfo(Land land) {
		boolean success = false;
		if (validateLandInfo(land)) {
			success = landDAO.addLand(land);

		}

		return success;
	}

	@Override
	public boolean editLandInfo(Land land) {
		boolean success = false;

		if (validateLandInfo(land)) {
			success = landDAO.editLand(land);
		}
		return success;
	}

	@Override
	public City getCityDetails(City city) {
		City cityDetails = null;
		if (city.getId() > 0) {
			cityDetails = landDAO.getCityById(city);
		}
		return cityDetails;
	}

	@Override
	public Location getLocationDetails(Location location) {
		Location locationDetails = null;
		if (location.getId() > 0) {
			locationDetails = landDAO.getLocationByIdAndCityId(location);
		}
		return locationDetails;
	}

	public Location getLocationDetailsByName(Location location) {
		Location locationDetails = landDAO.getLocationIdByName(location);

		return locationDetails;
	}

	public List<Location> getAllLocationDetailsByCityId(City city) {
		List<Location> locationList = landDAO.getAllLocationByCityId(city);
		return locationList;
	}

	@Override
	public Property getPropertyDetails(Property property) {
		Property propertyDetails = null;
		if (property.getId() > 0) {
			propertyDetails = landDAO.getPropertyById(property);
		}
		return propertyDetails;
	}

	@Override
	public List<City> getAllCity() {

		List<City> cityList = landDAO.getAllCityDetails();
		return cityList;
	}

	@Override
	public List<Property> getAllProperty() {
		List<Property> propertyList = landDAO.getAllPropertyDetails();
		return propertyList;
	}

	@Override
	public Land getLandDetailsByLandId(Land land) {
		Land landDetails = landDAO.getLandDetailsByLandId(land);
		return landDetails;
	}

}
