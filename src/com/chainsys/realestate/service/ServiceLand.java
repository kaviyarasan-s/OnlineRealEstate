package com.chainsys.realestate.service;

import java.util.List;

import com.chainsys.realestate.model.City;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Location;
import com.chainsys.realestate.model.Property;

public interface ServiceLand {

	boolean validateLandInfo(Land land);
	boolean addLandInfo(Land land);
	boolean editLandInfo(Land land);
	City getCityDetails(City city);
	Location getLocationDetails(Location location);
	Location getLocationDetailsByName(Location location);
	Property getPropertyDetails(Property property);
	List<City> getAllCity();
	List<Property> getAllProperty();
	List<Location> getAllLocationDetailsByCityId(City city);
	
}
