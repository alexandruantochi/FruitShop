package eu.ubis.eshop.bf.domain.repo;


import java.util.List;

import eu.ubis.eshop.bf.domain.model.User;
import eu.ubis.eshop.bf.integration.model.UserEntity;
import eu.ubis.eshop.bf.integration.model.UserMapper;
import eu.ubis.eshop.bf.integration.repo.UserDAOBean;


public class UserRepository {

		private static final UserDAOBean userDAOBean = new UserDAOBean();
		
		public User getUserDetails()
		{
			UserEntity userDetails = userDAOBean.getUserDetails();
			User model = UserMapper.entityToModel(userDetails);
			return model;
		}

		public static List<Integer> getUserOrders() {

			List<Integer> orders = userDAOBean.getUserOrders();
			return orders;
		}
}