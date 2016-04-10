package eu.ubis.eshop.pf;

import java.util.List;

import javax.servlet.http.HttpSession;

import eu.ubis.eshop.bfcl.FacadeFactory;
import eu.ubis.eshop.bfcl.OrderDTO;
import eu.ubis.eshop.bfcl.OrdersFacade;
import eu.ubis.eshop.bfcl.ProductDTO;
import eu.ubis.eshop.bfcl.ProductFacade;

public class DemoBean   {

	// productFacade = new ProductFacadeBean;
	private static ProductFacade productFacade = FacadeFactory.getProductFacade();

	private static OrdersFacade ordersFacade = FacadeFactory.getOrderFacade();

	public List<ProductDTO> getAllProducts() {
		return productFacade.getAllProducts();
	}

	public List<OrderDTO> getAllOrders() {
		return ordersFacade.getAllOrders();
	}

}
