package com.chainsys.realestate.validate;

import com.chainsys.realestate.model.Users;

public class ProfileValidation {

	public static boolean userValidation(Users users)
	{
		boolean isValid=false;
		String userName=users.getName();
		String email=users.getEmail();
		String mobileNumber=String.valueOf(users.getMobilenumber());
		String password=users.getPassword();
		if(!userName.isEmpty()&&userName!=null&&Validate.checkIsString(userName))
		{
			if(!email.isEmpty()&&email!=null&&Validate.emailValidate(email))
			{
				if(mobileNumber.length()==10&&Validate.numberValidation(mobileNumber))
				{
					if(!password.isEmpty()&&password!=null&&Validate.passwordValidate(password))
					{
						isValid=true;
					}
				}	
			}
		}
		return isValid;
	}
	
}
