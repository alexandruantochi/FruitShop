package eu.ubis.eshop.bf.integration.model;

import eu.ubis.eshop.bf.domain.model.User;

public final class UserMapper {

	private UserMapper() {
	}

	public static User entityToModel(UserEntity entity) {
		User model = new User();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setFirst_name(entity.getFirst_name());
		model.setAdress(entity.getAdress());
		model.setEmail(entity.getEmail());
		model.setPhone(entity.getPhone());
		model.setUsername(entity.getUsername());
		model.setPassword(entity.getPassword());
		return model;
	}

	public static UserEntity modelToEnt(User model) {
		UserEntity entity = new UserEntity();
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setFirst_name(model.getFirst_name());
		entity.setAdress(model.getAdress());
		entity.setEmail(model.getEmail());
		entity.setPhone(model.getPhone());
		entity.setUsername(model.getUsername());
		entity.setPassword(model.getPassword());
		
		return entity;
	}

}