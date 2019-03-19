package com.chainsys.realestate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.realestate.dao.LoginDAO;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean checkLoginCreandcials(Users users) {

		Connection connection = ConnectionUtil.getConnection();
		boolean success=false;
		try {
			String query = "select name,email,password,phonenumber from rl_est_land_user where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.equals(null)) {
				if (resultSet.next()) {
					success=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

}
