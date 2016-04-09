package eu.ubis.eshop.bf.integration.model;

import eu.ubis.eshop.bf.domain.model.Product;

public final class Mapper {

	private Mapper() {
	}

	public static Product entityToModel(ProductEntity entity) {
		Product model = new Product();
		model.setProductId(entity.getProductId());
		model.setName(entity.getName());
		model.setPrice(entity.getPrice());
		return model;
	}

	public static ProductEntity modelToEnt(Product model) {
		ProductEntity entity = new ProductEntity();
		entity.setProductId(model.getProductId());
		entity.setName(model.getName());
		entity.setPrice(model.getPrice());
		return entity;
	}

}
