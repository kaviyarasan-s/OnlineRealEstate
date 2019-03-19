package com.chainsys.realestate.service.impl;

import java.time.LocalDateTime;

import com.chainsys.realestate.dao.UserDAO;
import com.chainsys.realestate.dao.impl.UserDAOImpl;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.validate.ProfileValidation;

public class ProfileImpl implements Profile {

	@Override
	public boolean userRegistration(Users user) {
		boolean registerResult = false;

		if (validateUserInfo()) {
			UserDAO userDAO = new UserDAOImpl();

			registerResult = userDAO.addUserDetails(user);
		} else {
			registerResult = false;
		}
		return registerResult;
	}

	@Override
	public boolean validateUserInfo() {

		return ProfileValidation.userValidation();
	}

	@Override
	public boolean changePassword(Users user) {
		boolean success = false;
		UserDAO userDAO = new UserDAOImpl();
		Users updatedUserDetails = userDAO.getUserDetailsByEmail(user);
		if (updatedUserDetails != null) {
			updatedUserDetails.setPassword(user.getPassword());
		}
		
		if (validateUserInfo()) {
			success = userDAO.changePassword(updatedUserDetails);
		}
		return success;
	}

	@Override
	public boolean checkForgotPasswordEmail(Users user) {
		boolean valid = false;
		UserDAO userDAO = new UserDAOImpl();
		Users updatedUserDetails = userDAO.getUserDetailsByEmail(user);
		if (validateUserInfo()) {
			if (updatedUserDetails == null) {
				valid = false;
			} else {
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public boolean editProfile(Users user) {
		boolean success = false;
		UserDAO userDAO = new UserDAOImpl();		
		Users updatedUserDetails = userDAO.getUserDetailsById(user);
		if (user.getName() != null && !user.getName().isEmpty()) {
			updatedUserDetails.setName(user.getName());
		}
		if (user.getEmail() != null && !user.getEmail().isEmpty()) {
			updatedUserDetails.setEmail(user.getEmail());
		}
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			updatedUserDetails.setPassword(user.getPassword());
		}
		if (user.getMobilenumber()>0&&String.valueOf(user.getMobilenumber()).length()==10) {
			updatedUserDetails.setMobilenumber(user.getMobilenumber());
		}
		updatedUserDetails.setCreatedDate(user.getCreatedDate());
		updatedUserDetails.setModifiedBy(user.getId());
		updatedUserDetails.setModifiedDate(LocalDateTime.now());
		if (validateUserInfo()) {
			success= userDAO.editProfileInfo(updatedUserDetails);
		}
		
		
		return success;
	}
}
