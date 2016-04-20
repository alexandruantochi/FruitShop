package eu.ubis.eshop.bf.business;

import java.util.ArrayList;
import java.util.List;

import eu.ubis.eshop.bf.domain.model.Product;
import eu.ubis.eshop.bf.domain.model.Transformer;
import eu.ubis.eshop.bf.domain.repo.ProductRepositoryBean;
import eu.ubis.eshop.bf.integration.repo.ProductDAOBean;
import eu.ubis.eshop.bfcl.ProductDTO;
import eu.ubis.eshop.bfcl.ProductFacade;

public class ProductFacadeBean implements ProductFacade {

	private static final ProductRepositoryBean productRepository = new ProductRepositoryBean();

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.getAllProducts();
		List<ProductDTO> productList = new ArrayList<ProductDTO>();

		for (Product product : products) {
			productList.add(Transformer.modelToDto(product));
		}

		return productList;
	}

	@Override
	public List<String> getAllCategories() {
		return productRepository.getAllCategories();
	}

	@Override
	public List<String> getAllSubcategories() {
		return productRepository.getAllSubcategories();
	}
	
	@Override
	public List<String> getSubcategoriesByCategoryName(String categoryName) {
		return productRepository.getSubcategoriesByCategoryName(categoryName);
	}

	@Override
	public void saveProduct(ProductDTO dto) {
		Product product = Transformer.dtoToModel(dto);
		productRepository.saveProduct(product);

	}
	
	@Override
	public void editProduct(ProductDTO dto) {
		Product product = Transformer.dtoToModel(dto);
		productRepository.editProduct(product);
	}
	
	@Override
	public void delProduct(String productId){
		ProductDAOBean.delProduct(productId);
	}
	

}
