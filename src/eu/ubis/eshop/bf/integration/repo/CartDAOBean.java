package eu.ubis.eshop.bf.integration.repo;

public class CartDAOBean {
	
	private static final String ADD_CART = "INSERT INTO `cart`(`id`, `userid`, `productid`) VALUES (null,?,?)";
	private static final String GET_CART = "SELECT * FROM `cart` where `userid`=?";
	private static final String ADD_FAV = "INSERT INTO `favs`(`id`, `userid`, `productId`) VALUES (null,?,?)";
	private static final String CHECKOUT = "DELETE FROM `cart` WHERE userId=?";
	private static final String DELETE_FAV = "DELETE FROM `fav` WHERE id=?";
	
	
	
	
	
	
}