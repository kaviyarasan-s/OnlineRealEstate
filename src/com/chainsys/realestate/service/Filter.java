package com.chainsys.realestate.service;

import java.util.List;

import com.chainsys.realestate.model.Land;

public interface Filter {

	
	List<Land> filterLandsDetails(Land land);
	boolean validateFilterDetails();
	
}
