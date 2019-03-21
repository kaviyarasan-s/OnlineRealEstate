package com.chainsys.realestate.validate;

import com.chainsys.realestate.model.Users;

public class LoginValidate {
	public static boolean loginValidation(Users users) {
		boolean isValid = false;
		if (users.getEmail() != null && !users.getEmail().isEmpty()) {
			if (users.getPassword() != null && !users.getPassword().isEmpty()) {
				isValid = true;
			}
		}
		return isValid;
	}
	public static boolean emailPasswordValidation(Users users)
	{
		boolean isValid=false;
		if(Validate.emailValidate(users.getEmail()))
		{
			if(Validate.passwordValidate(users.getPassword()))
			{
				isValid=true;
			}
		}
		return isValid;
	}
}
