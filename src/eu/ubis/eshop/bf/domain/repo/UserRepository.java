package eu.ubis.eshop.bf.domain.repo;


import java.util.List;

import eu.ubis.eshop.bf.domain.model.User;
import eu.ubis.eshop.bf.integration.model.Mapper;
import eu.ubis.eshop.bf.integration.model.UserEntity;
import eu.ubis.eshop.bf.integration.model.UserMapper;
import eu.ubis.eshop.bf.integration.repo.UserDAOBean;
import eu.ubis.eshop.bfcl.UserDTO;


public class UserRepository {

		private static final UserDAOBean userDAOBean = new UserDAOBean();
		
		public static User getUserDetails(String username, String pwd)
		{
			UserEntity userDetails = userDAOBean.getUserDetails(username, pwd);
			User model = UserMapper.entityToModel(userDetails);
			return model;
		}

		public static List<Integer> getUserOrders(int id) {

			List<Integer> orders = userDAOBean.getUserOrders(id);
			return orders;
		}

		public static List<Integer> getUserFavs(int id) {
			List<Integer> favs = userDAOBean.getUserFavs(id);
			return null;
		}

		public void register(User user) {
			UserEntity userEntity = UserMapper.modelToEnt(user);
			userDAOBean.register(userEntity);
		}
}