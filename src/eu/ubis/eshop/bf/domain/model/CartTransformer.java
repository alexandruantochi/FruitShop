package eu.ubis.eshop.bf.domain.model;

import com.sun.xml.internal.bind.v2.runtime.output.C14nXmlOutput;

import eu.ubis.eshop.bfcl.ProductDTO;

public class CartTransformer {
	private CartTransformer() {
	}

	public static Cart dtoToModel(Cart dto) {
		Cart model = new Cart();
		model.setcartId(dto.getcartId());
		model.setName(dto.getName());
		model.setPrice(dto.getPrice());
		model.setCategory(dto.getCategory());
		model.setSubcategory(dto.getSubcategory());
		model.setDescription(dto.getDescription());
		model.setUm(dto.getUm());
		return model;
	}

	public static CartDTO modelToDto(Cart model) {
		cartDTO dto = new cartDTO();
		dto.setcartId(model.getcartId());
		dto.setName(model.getName());
		dto.setPrice(model.getPrice());
		dto.setCategory(model.getCategory());
		dto.setSubcategory(model.getSubcategory());
		dto.setDescription(model.getDescription());
		dto.setUm(model.getUm());
		return dto;
	}

}
