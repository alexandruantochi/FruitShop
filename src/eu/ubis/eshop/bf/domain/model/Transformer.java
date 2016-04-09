package eu.ubis.eshop.bf.domain.model;

import eu.ubis.eshop.bfcl.ProductDTO;

public class Transformer {

	private Transformer() {
	}

	public static Product dtoToModel(ProductDTO dto) {
		Product model = new Product();
		model.setName(dto.getName());
		model.setPrice(dto.getPrice());
		model.setCategory(dto.getCategory());
		model.setSubcategory(dto.getSubcategory());
		return model;
	}

	public static ProductDTO modelToDto(Product model) {
		ProductDTO dto = new ProductDTO();
		dto.setName(model.getName());
		dto.setPrice(model.getPrice());
		dto.setCategory(model.getCategory());
		dto.setSubcategory(model.getSubcategory());
		return dto;
	}
}
