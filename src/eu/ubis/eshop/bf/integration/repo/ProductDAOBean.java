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
	
	private static final String CATEGORY_SELECT_ALL = "SELECT `category` FROM `category`";
	private static final String CATEGORY_SELECT_BY_NAME = "SELECT `id` FROM `category` WHERE `category`=?";

	private static final String SUBCATEGORY_SELECT_ALL = "SELECT `subcategory` FROM `subcategory`";
	private static final String SUBCATEGORY_SELECT_BY_NAME = "SELECT `id` FROM `subcategory` WHERE `subcategory`=?";
	private static final String SUBCATEGORY_SELECT_BY_CATEGORY_ID = "SELECT `subcategory` FROM `subcategory` WHERE `categoryId`=?";
	
	
	private static final String PRODUCT_INSERT = "INSERT INTO `products` (`id`, `name`, `description`, `um`, `price`, `categoryID`, `subcategoryID`) VALUES (null, ?, ?, ?, ?, ?, ?)";
	private static final String PRODUCT_EDIT = "UPDATE `products` SET `name`=?,`description`=?,`um`=?,`price`=?,`categoryId`=?,`subcategoryId`=? WHERE `id`=?";
	private static final String DEL_PRODUCT = "DELETE FROM `products` WHERE id=?";
	
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

	public List<String> getAllCategories() {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<String> categories = new ArrayList<String>();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(CATEGORY_SELECT_ALL);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				categories.add(resultSet.getString("category"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public int getCategoryIdByName(String name) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(CATEGORY_SELECT_BY_NAME);
			prepareStatement.setString(1, name);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt("id");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getAllSubcategories() {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<String> subcategories = new ArrayList<String>();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(SUBCATEGORY_SELECT_ALL);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				subcategories.add(resultSet.getString("subcategory"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subcategories;
	}

	public int getSubcategoryIdByName(String name) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(SUBCATEGORY_SELECT_BY_NAME);
			prepareStatement.setString(1, name);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt("id");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<String> getSubcategoriesByCategoryName(String categoryName) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		List<String> subcategories = new ArrayList<String>();
		
		try {
			int categoryID = getCategoryIdByName(categoryName);
			PreparedStatement prepareStatement = con.prepareStatement(SUBCATEGORY_SELECT_BY_CATEGORY_ID);
			prepareStatement.setInt(1, categoryID);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				subcategories.add(resultSet.getString("subcategory"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return subcategories;
	}
	
	
	//image path not implemented
	public void saveProduct(ProductEntity product) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try 
		{
			PreparedStatement prepareStatement = con.prepareStatement(PRODUCT_INSERT);
			prepareStatement.setString(1, product.getName());
			prepareStatement.setString(2, product.getDescription());
			prepareStatement.setString(3, product.getUm());
			prepareStatement.setFloat(4, product.getPrice());
			prepareStatement.setInt(5, product.getCategory());
			prepareStatement.setInt(6, product.getSubcategory());
			prepareStatement.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void editProduct(ProductEntity product) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try
		{
			PreparedStatement prepareStatement = con.prepareStatement(PRODUCT_EDIT);
			prepareStatement.setString(1, product.getName());
			prepareStatement.setString(2, product.getDescription());
			prepareStatement.setString(3, product.getUm());
			prepareStatement.setFloat(4, product.getPrice());
			prepareStatement.setInt(5, product.getCategory());
			prepareStatement.setInt(6, product.getSubcategory());
			prepareStatement.setInt(7, product.getProductId());
			prepareStatement.execute();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static void delProduct(String productId) {
		Connection con = ConnectionHelperClass.getMysqlConnection();
		try
		{
			PreparedStatement prepareStatement = con.prepareStatement(DEL_PRODUCT);
			prepareStatement.setString(1, productId);
			prepareStatement.execute();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}


