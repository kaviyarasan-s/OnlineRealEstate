package com.chainsys.realestate.service.impl;

import com.chainsys.realestate.dao.LandDAO;
import com.chainsys.realestate.dao.impl.LandDAOImpl;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.service.ServiceLand;
import com.chainsys.realestate.validate.LandInfoValidation;

public class ServiceLandImpl implements ServiceLand {

	@Override
	public boolean validateLandInfo() {

		return LandInfoValidation.landValidation();
	}

	@Override
	public boolean addLandInfo(Land land) {
		boolean success = false;
		if (validateLandInfo()) {
			LandDAO landDAO = new LandDAOImpl();
			success = landDAO.addLand(land);

		}

		return success;
	}

}
