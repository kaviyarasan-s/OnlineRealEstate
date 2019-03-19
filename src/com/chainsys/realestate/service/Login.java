package com.chainsys.realestate.service;

import com.chainsys.realestate.model.Users;

public interface Login {

	
	boolean loginValidate();
	boolean checkLogin(Users users);
}
