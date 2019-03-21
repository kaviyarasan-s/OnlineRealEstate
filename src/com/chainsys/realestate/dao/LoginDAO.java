package com.chainsys.realestate.dao;

import com.chainsys.realestate.model.Users;

public interface LoginDAO {

	boolean checkLoginCredentials(Users users);
}
