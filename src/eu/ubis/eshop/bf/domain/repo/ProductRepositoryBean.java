package eu.ubis.eshop.bf.domain.repo;

import java.util.ArrayList;
import java.util.List;

import eu.ubis.eshop.bf.domain.model.Product;
import eu.ubis.eshop.bf.integration.model.Mapper;
import eu.ubis.eshop.bf.integration.model.ProductEntity;
import eu.ubis.eshop.bf.integration.repo.ProductDAOBean;

public class ProductRepositoryBean {

	private static final ProductDAOBean productDAOBean = new ProductDAOBean();

	public List<Product> getAllProducts() {

		List<ProductEntity> allProducts = productDAOBean.getAllProducts();

		List<Product> productList = new ArrayList<Product>();
		for (ProductEntity entity : allProducts) {
			Product model = Mapper.entityToModel(entity);

			String category = productDAOBean.getCategoryById(entity.getCategory());
			String subCategory = productDAOBean.getSubCategoryById(entity.getSubcategory());

			model.setCategory(category);
			model.setSubcategory(subCategory);
			productList.add(model);
		}
		return productList;
	}

}