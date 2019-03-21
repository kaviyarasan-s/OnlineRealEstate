package com.chainsys.realestate.dao;

import com.chainsys.realestate.model.Users;

public interface UserDAO {
	boolean addUserDetails(Users user);
	Users getUserDetailsById(Users user);
	Users getUserDetailsByEmail(Users user);
	boolean changePassword(Users user);
	boolean editProfileInfo(Users user);
}
