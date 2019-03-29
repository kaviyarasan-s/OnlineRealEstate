package com.chainsys.realestate.validate;

import java.math.BigDecimal;

import com.chainsys.realestate.model.Land;

public class LandInfoValidation {

	public static boolean landValidation(Land land)
	{
		boolean isValid=false;
		if(land.getProperty()!=null)
		{
			if(land.getPrice()!=BigDecimal.ZERO)
			{
				if(land.getBhk()>0)
				{
					if(land.getLocation()!=null)
					{
						if(land.getLocation().getCity()!=null)
						{
							if(land.getBuildingName()!=null&&!land.getBuildingName().isEmpty()){
								if(land.getSize()>0){
									if(land.getTransactionType()!=null&&!land.getTransactionType().isEmpty())
									{
										if(land.getPurchaseType()!=null&&!land.getPurchaseType().isEmpty())
										{
											if(land.getStatus()!=null&&!land.getStatus().isEmpty())
											{
												isValid=true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return isValid;
	}
}
