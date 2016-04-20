package eu.ubis.eshop.bf.integration.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import eu.ubis.eshop.bf.integration.model.UserEntity;

public class UserDAOBeen {
	private static final String GET_USER_DETAILS = "SELECT * FROM `users` WHERE `username`=? AND `password`=?";
	private static final String GET_USER_ORDERS = "SELECT `orderID` FROM `orders` where `userID`=?";


	public List<UserEntity> getUserDetails() {

		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();

		try {
			ResultSet resultSet = con.createStatement().executeQuery(GET_USER_DETAILS);
			while (resultSet.next()) {
				UserEntity userEntity = new UserEntity();
				userEntity.setId(resultSet.getInt("id"));
				userEntity.setName(resultSet.getString("name"));
				userEntity.setFirst_name(resultSet.getString("first_name"));
				userEntity.setAdress(resultSet.getString("adress"));
				userEntity.setEmail(resultSet.getString("email"));
				userEntity.setPhone(resultSet.getString("phone"));
				userEntities.add(userEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return userEntities;
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
		return (new ArrayList<Integer>());
	}
}
