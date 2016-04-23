package eu.ubis.eshop.bfcl;

import java.util.List;

public interface ProductFacade {

	public List<ProductDTO> getAllProducts();

	public ProductDTO getProductById(int id);
	
	public List<String> getAllCategories();

	public List<String> getAllSubcategories();
	
	public List<String> getSubcategoriesByCategoryName(String categoryName);

	public void saveProduct(ProductDTO product);
	
	public void editProduct(ProductDTO product);
	
	public void delProduct(String productId);

}

