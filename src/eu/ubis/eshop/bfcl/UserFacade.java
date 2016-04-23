package eu.ubis.eshop.bfcl;

import java.util.List;

public interface UserFacade {
	public UserDTO getUserDetails();
	public List<Integer> getUserOrders();
}
