package com.chainsys.realestate.service;
import com.chainsys.realestate.model.Users;
/**
 * @author kavi2120
 *
 */
public interface Login {
	boolean loginValidate(Users users);
	boolean checkLoginInputValidOrNot(Users users);
	boolean checkLogin(Users users);
}
