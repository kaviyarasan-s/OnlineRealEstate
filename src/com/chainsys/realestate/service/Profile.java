package com.chainsys.realestate.service;

import com.chainsys.realestate.model.Users;

public interface Profile {
	
	boolean validateUserInfo();

	boolean userRegistration(Users user);
	
	boolean changePassword(Users user);
	
	boolean checkForgotPasswordEmail(Users user);
	
	boolean editProfile(Users user);
	
}
