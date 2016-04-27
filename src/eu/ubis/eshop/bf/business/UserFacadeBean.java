package eu.ubis.eshop.bf.business;

import java.util.List;

import eu.ubis.eshop.bf.domain.model.User;
import eu.ubis.eshop.bf.domain.model.UserTransformer;
import eu.ubis.eshop.bf.domain.repo.UserRepository;
import eu.ubis.eshop.bfcl.UserDTO;
import eu.ubis.eshop.bfcl.UserFacade;

public class UserFacadeBean implements UserFacade {
	
	@Override
	public UserDTO getUserDetails(String username, String pwd) {
		
		User model = UserRepository.getUserDetails(username, pwd);
		UserDTO userDTO = new UserDTO();
		userDTO = UserTransformer.modelToDto(model);
		return userDTO;
		
	}

	@Override
	public List<Integer> getUserOrders(int id) {
		return UserRepository.getUserOrders(id);
	}

	@Override
	public List<Integer> getUserFavs(int id) {
		return UserRepository.getUserFavs(id);
	}



}
