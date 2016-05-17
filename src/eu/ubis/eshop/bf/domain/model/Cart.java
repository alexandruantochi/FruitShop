package eu.ubis.eshop.bf.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
