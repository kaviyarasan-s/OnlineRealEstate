package com.chainsys.realestate.service;

import com.chainsys.realestate.model.Land;

public interface ServiceLand {

	boolean validateLandInfo();
	boolean addLandInfo(Land land);
}
