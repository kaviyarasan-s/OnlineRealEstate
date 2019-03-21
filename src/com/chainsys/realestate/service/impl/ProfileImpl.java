package com.chainsys.realestate.service.impl;

import java.time.LocalDateTime;

import com.chainsys.realestate.dao.UserDAO;
import com.chainsys.realestate.dao.impl.UserDAOImpl;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.service.Profile;
import com.chainsys.realestate.validate.ProfileValidation;

public class ProfileImpl implements Profile {
	/*
	 * Register user details
	 * 
	 * @see
	 * com.chainsys.realestate.service.Profile#userRegistration(com.chainsys
	 * .realestate.model.Users)
	 */
	@Override
	public boolean userRegistration(Users user) {
		boolean registerResult = false;
		UserDAO userDAO = new UserDAOImpl();
		registerResult = userDAO.addUserDetails(user);
		return registerResult;
	}
	/*
	 * Validate user information
	 * @see
	 * com.chainsys.realestate.service.Profile#validateUserInfo(com.chainsys
	 * .realestate.model.Users)
	 */
	@Override
	public boolean validateUserInfo(Users user) {
		return ProfileValidation.userValidation(user);
	}
	/*
	 * Change password
	 * @see com.chainsys.realestate.service.Profile#changePassword(com.chainsys.
	 * realestate.model.Users)
	 */
	@Override
	public boolean changePassword(Users user) {
		boolean success = false;
		UserDAO userDAO = new UserDAOImpl();
		Users updatedUserDetails = userDAO.getUserDetailsByEmail(user);
		if (updatedUserDetails != null) {
			updatedUserDetails.setPassword(user.getPassword());
		}
		success = userDAO.changePassword(updatedUserDetails);
		return success;
	}
	/*
	 * Check forgot password is present or not
	 * @see
	 * com.chainsys.realestate.service.Profile#checkForgotPasswordEmail(com.
	 * chainsys.realestate.model.Users)
	 */
	@Override
	public boolean checkForgotPasswordEmail(Users user) {
		boolean valid = false;
		UserDAO userDAO = new UserDAOImpl();
		Users updatedUserDetails = userDAO.getUserDetailsByEmail(user);
		if (updatedUserDetails == null) {
			valid = false;
		} else {
			valid = true;
		}
		return valid;
	}
	/*
	 * Edit profile informations
	 * @see
	 * com.chainsys.realestate.service.Profile#editProfile(com.chainsys.realestate
	 * .model.Users)
	 */
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
		if (String.valueOf(user.getMobilenumber()).length() == 10) {
			updatedUserDetails.setMobilenumber(user.getMobilenumber());
		}
		updatedUserDetails.setCreatedDate(user.getCreatedDate());
		updatedUserDetails.setModifiedBy(user.getId());
		updatedUserDetails.setModifiedDate(LocalDateTime.now());
		if (validateUserInfo(user)) {
			success = userDAO.editProfileInfo(updatedUserDetails);
		}

		return success;
	}
}
