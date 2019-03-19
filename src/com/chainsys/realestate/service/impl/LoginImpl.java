package com.chainsys.realestate.service.impl;

import com.chainsys.realestate.dao.LoginDAO;
import com.chainsys.realestate.dao.impl.LoginDAOImpl;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Login;
import com.chainsys.realestate.validate.LoginValidate;

public class LoginImpl implements Login {

	@Override
	public boolean loginValidate() {
		return LoginValidate.loginValidation();
	}
	
	
	public boolean checkLogin(Users users) {
		boolean loginSuccess = false;
		if (loginValidate()) {
			LoginDAO loginDAO = new LoginDAOImpl();

			loginSuccess = loginDAO.checkLoginCreandcials(users);
		} else {
			loginSuccess = false;
		}
		return loginSuccess;
	}

}
