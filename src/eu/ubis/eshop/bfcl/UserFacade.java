package eu.ubis.eshop.bfcl;

import java.util.List;

//import eu.ubis.eshop.bf.domain.model.User;

public interface UserFacade {
	public UserDTO getUserDetails(String username, String pwd);
	public List<Integer> getUserOrders(int id);
	public List<Integer> getUserFavs(int id);
	public void register(UserDTO user);
}
