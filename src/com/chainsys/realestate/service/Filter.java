package com.chainsys.realestate.service;

import java.util.List;

import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Users;

public interface Filter {
	List<Land> filterLandsDetails(Land land);
	boolean validateFilterDetails();
	List<Land> filterOwnLandsDetails(Users userDetails);
}
