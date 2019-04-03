package com.chainsys.realestate.service.impl;

import com.chainsys.realestate.dao.LoginDAO;
import com.chainsys.realestate.dao.impl.LoginDAOImpl;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Login;
import com.chainsys.realestate.validate.LoginValidate;

/**
 * @author kavi2120
 *
 */
public class LoginImpl implements Login {
	
	/*
	 * Validate login details
	 * 
	 * @see
	 * com.chainsys.realestate.service.Login#loginValidate(com.chainsys.realestate
	 * .model.Users)
	 */
	@Override
	public boolean loginValidate(Users users) {
		return LoginValidate.loginValidation(users);
	}

	/*
	 * Check login credentials valid or not
	 * 
	 * @see
	 * com.chainsys.realestate.service.Login#checkLogin(com.chainsys.realestate
	 * .model.Users)
	 */
	public boolean checkLogin(Users users) {
		boolean loginSuccess = false;
		Login login = new LoginImpl();
		if (login.checkLoginInputValidOrNot(users)) {
			LoginDAO loginDAO = new LoginDAOImpl();
			loginSuccess = loginDAO.checkLoginCredentials(users);
		}

		return loginSuccess;
	}

	@Override
	public boolean checkLoginInputValidOrNot(Users users) {
		return LoginValidate.emailPasswordValidation(users);
	}
}
