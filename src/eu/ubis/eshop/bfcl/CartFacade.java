package eu.ubis.eshop.bfcl;

public interface CartFacade {
	public void addToCart(int userId, int productId);
	public void removeCart (int userId, int productId);
	public void checkOut (int userId);
	public void getCart(int userId);
	public void addFav (int userId, int productId);
	public void remFav (int userId, int productId);
	
}
