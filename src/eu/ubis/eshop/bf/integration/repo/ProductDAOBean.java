package eu.ubis.eshop.bf.integration.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eu.ubis.eshop.bf.integration.model.ProductEntity;

public class ProductDAOBean {
	private static final String GET_ALL_PRODUCTS = "SELECT * FROM `products` ORDER BY `id`";

	private static final String CATEGORY_SELECT = "SELECT `category` FROM `category` WHERE `id`=?";
	private static final String SUBCATEGORY_SELECT = "SELECT `subcategory` FROM `subcategory` WHERE `id`=?";

	public List<ProductEntity> getAllProducts() {

		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<ProductEntity> productList = new ArrayList<ProductEntity>();

		try {
			ResultSet resultSet = con.createStatement().executeQuery(GET_ALL_PRODUCTS);
			while (resultSet.next()) {
				ProductEntity product = new ProductEntity();
				product.setProductId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getInt("categoryId"));
				product.setSubcategory(resultSet.getInt("subcategoryId"));
				product.setDescription(resultSet.getString("description"));
				product.setUm(resultSet.getString("um"));
				product.setPrice(resultSet.getFloat("price"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return productList;
	}

	public String getCategoryById(int id) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(CATEGORY_SELECT);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			return resultSet.getString("category");

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String getSubCategoryById(int id) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try {

			PreparedStatement prepareStatement = con.prepareStatement(SUBCATEGORY_SELECT);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			return resultSet.getString("subcategory");

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return null;
	}
}
