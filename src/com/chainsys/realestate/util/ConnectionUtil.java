package com.chainsys.realestate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void closeConnection(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException	
	{
		if(connection!=null)
		{
			connection.close();
		}
		if(preparedStatement!=null)
		{
			preparedStatement.close();
		}
		if(resultSet!=null)
		{
			resultSet.close();
		}
	}

}
