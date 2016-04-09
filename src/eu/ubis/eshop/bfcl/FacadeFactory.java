package eu.ubis.eshop.bfcl;

import eu.ubis.eshop.bf.business.OrderFacadeBean;
import eu.ubis.eshop.bf.business.ProductFacadeBean;

public final class FacadeFactory {

	private FacadeFactory() {

	}

	private static ProductFacade productFacade;
	private static OrdersFacade ordersFacade;

	public static ProductFacade getProductFacade() {
		if (productFacade == null) {
			productFacade = new ProductFacadeBean();
		}
		return productFacade;
	}

	public static OrdersFacade getOrderFacade() {
		if (ordersFacade == null) {
			ordersFacade = new OrderFacadeBean();
		}
		return ordersFacade;
	}

}
