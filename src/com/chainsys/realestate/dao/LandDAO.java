package com.chainsys.realestate.dao;

import java.util.List;

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;

public interface LandDAO {

	boolean addLand(Land land);
	boolean editLand(Land land);
	City getCityById(City city);
	Location getLocationByIdAndCityId(Location location);
	Location getLocationIdByName(Location location);
	List<Location> getAllLocationByCityId(City city);
	Property getPropertyById(Property property);
	List<City> getAllCityDetails();
	List<Property> getAllPropertyDetails();
}
