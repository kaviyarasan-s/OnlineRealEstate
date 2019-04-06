package com.chainsys.realestate.dao;

import java.util.List;

import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.model.Users;

public interface FilterDAO {

	List<Land> filerLandByBhkPriceTrnType(Land land);
	List<Land> filerLandByBhkPrice(Land land);
	List<Land> filerLandByBhkTrnType(Land land);
	List<Land> filerLandByPriceTrnType(Land land);
//	List<Land> getLandDetailsById(Land land);
	List<Land> basicFiler(Land land);
	List<Land> filerLandByBhkOrPriceOrTrnType(Land land);
	List<Land> filerOwnLandByUserId(Users user);
	
}
