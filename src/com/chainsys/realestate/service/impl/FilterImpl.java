package com.chainsys.realestate.service.impl;

import java.util.List;

import com.chainsys.realestate.dao.FilterDAO;
import com.chainsys.realestate.dao.impl.FilterDAOImpl;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.service.Filter;

public class FilterImpl implements Filter {

	@Override
	public List<Land> filterLandsDetails(Land land) {

		List<Land> landDetails = null;
		
		if (validateFilterDetails()) {
			FilterDAO filterDAO = new FilterDAOImpl();
			if (land.getBhk() > 0 && land.getPrice() != null
					&& "".equals(land.getTransactionType())
					&& !land.getTransactionType().isEmpty()) {

				landDetails = filterDAO.filerLandByBhkPriceTrnType(land);

			} else if (land.getBhk() > 0 && land.getPrice() != null) {

				landDetails = filterDAO.filerLandByBhkPrice(land);

			} else if (land.getPrice() != null
					&& "".equals(land.getTransactionType())
					&& !land.getTransactionType().isEmpty()) {

				landDetails = filterDAO.filerLandByPriceTrnType(land);

			} else if (land.getBhk() > 0
					&& "".equals(land.getTransactionType())
					&& !land.getTransactionType().isEmpty()) {

				landDetails = filterDAO.filerLandByBhkTrnType(land);
			}

		}
		return landDetails;
	}

	@Override
	public boolean validateFilterDetails() {

		return true;
	}

}
