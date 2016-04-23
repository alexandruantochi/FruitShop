package eu.ubis.eshop.bf.integration.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import eu.ubis.eshop.bf.integration.model.UserEntity;

public class UserDAOBean {
	private static final String GET_USER_DETAILS = "SELECT `username` FROM `users` WHERE `username`=? AND `password`=?";
	private static final String GET_USER_ORDERS = "SELECT `orderID` FROM `orders` where `userID`=?";


	public UserEntity getUserDetails() {

		Connection con = ConnectionHelperClass.getMysqlConnection();
		UserEntity userEntity = new UserEntity();

		try {
			ResultSet resultSet = con.createStatement().executeQuery(GET_USER_DETAILS);
			while (resultSet.next()) {
				userEntity.setId(resultSet.getInt("id"));
				userEntity.setName(resultSet.getString("name"));
				userEntity.setFirst_name(resultSet.getString("first_name"));
				userEntity.setAdress(resultSet.getString("address"));
				userEntity.setEmail(resultSet.getString("email"));
				userEntity.setPhone(resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return userEntity;
	}

	public List<Integer> getUserOrders(int id) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<Integer> orderList = new ArrayList<Integer>();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(GET_USER_ORDERS);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next())
				orderList.add(resultSet.getInt("orderID"));
			return orderList;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return orderList;
	}
}
