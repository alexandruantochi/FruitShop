package eu.ubis.eshop.bf.integration.repo;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;

//import org.omg.CORBA.PRIVATE_MEMBER;

//import com.mysql.jdbc.SQLError;

import eu.ubis.eshop.bf.domain.model.User;
import eu.ubis.eshop.bf.integration.model.UserEntity;
//import jdk.internal.dynalink.beans.StaticClass;
//import sun.security.util.Password;

public class UserDAOBean {
	private static final String GET_USER_DETAILS = "SELECT * FROM `users` WHERE `username`=? AND `password`=?";
	private static final String GET_USER_ORDERS = "SELECT `orderId` FROM `orders` WHERE `userID`=?";
	private static final String GET_USER_FAVS = "SELECT `productId` from `favs` WHERE `userID`=?";
	private static final String CHECK_USER = "SELECT `username` from `users` WHERE `username`=?";
	private static final String REGISTER_USER ="INSERT INTO `users`(`id`, `name`, `first_name`, `address`, `username`, `password`, `email`, `phone`) VALUES (null,?,?,?,?,?,?,?)";

	// this is user for catching duplicate entry on user-name
	private final static int SQL_DUPLICATE_ENTRY = 1062;

	
	public UserEntity getUserDetails(String username, String pwd) {

		Connection con = ConnectionHelperClass.getMysqlConnection();
		UserEntity userEntity = new UserEntity();

		try {
			PreparedStatement prepareStatement = con.prepareStatement(GET_USER_DETAILS);
			prepareStatement.setString(1, username);
			prepareStatement.setString(2, pwd);
			
			ResultSet resultSet = prepareStatement.executeQuery();
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
	
	public List<Integer> getUserFavs(int id) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<Integer> favList = new ArrayList<Integer>();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(GET_USER_FAVS);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next())
				favList.add(resultSet.getInt("productId"));
			return favList;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return favList;
	}

	public static boolean checkUser(String username) {
		/* this function would check if there is already a user in the
		   database, but I used the SQL Exception ERROR 1062 for this */
		
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(CHECK_USER);
			prepareStatement.setString(1, username);
	
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			if (resultSet.next()){
				return true;
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public void register(UserEntity user) {
		
			Connection con = ConnectionHelperClass.getMysqlConnection();
			
			try {
				PreparedStatement prepareStatement = con.prepareStatement(REGISTER_USER);
				prepareStatement.setString(1, user.getName());
				prepareStatement.setString(2, user.getFirst_name());
				prepareStatement.setString(3, user.getAdress());
				prepareStatement.setString(4, user.getUsername());
				prepareStatement.setString(5, user.getPassword());
				prepareStatement.setString(6, user.getEmail());
				prepareStatement.setString(7, user.getPhone());
				prepareStatement.executeUpdate();
				
				
			} 
			catch (SQLException e) {
				if (e.getErrorCode()==SQL_DUPLICATE_ENTRY){
					e.printStackTrace();
				} else{
					e.printStackTrace();
				}
				
			} 
	}
	
	
	
	
}
