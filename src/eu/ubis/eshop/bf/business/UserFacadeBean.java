package eu.ubis.eshop.bf.business;

import java.util.List;

import eu.ubis.eshop.bf.domain.repo.UserRepository;
import eu.ubis.eshop.bfcl.UserDTO;
import eu.ubis.eshop.bfcl.UserFacade;

public class UserFacadeBean implements UserFacade {
	
	@Override
	public UserDTO getUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getUserOrders() {
		return UserRepository.getUserOrders();
	}

}
