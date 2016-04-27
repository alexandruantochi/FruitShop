package eu.ubis.eshop.bf.domain.model;

import eu.ubis.eshop.bfcl.UserDTO;

public class UserTransformer {
	
	public static User dtoToModel(UserDTO dto) {
		User model = new User();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setFirst_name(dto.getFirst_name());
		model.setAdress(dto.getAdress());
		model.setEmail(dto.getEmail());
		model.setPhone(dto.getPhone());
		return model;
	}

	public static UserDTO modelToDto(User model) {
		UserDTO dto = new UserDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setFirst_name(model.getFirst_name());
		dto.setAdress(model.getAdress());
		dto.setEmail(model.getEmail());
		dto.setPhone(model.getPhone());
		return dto;
	}
}
