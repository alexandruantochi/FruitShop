package eu.ubis.eshop.bfcl;

import eu.ubis.eshop.bf.business.OrderFacadeBean;
import eu.ubis.eshop.bf.business.ProductFacadeBean;
import eu.ubis.eshop.bf.business.UserFacadeBean;
import eu.ubis.eshop.bf.business.CartFacadeBean;

public final class FacadeFactory {

	private FacadeFactory() {

	}

	private static ProductFacade productFacade;
	private static OrdersFacade ordersFacade;
	private static UserFacade userFacade;
	private static CartFacade cartFacade;

	public static ProductFacade getProductFacade() {
		if (productFacade == null) {
			productFacade = new ProductFacadeBean();
		}
		return productFacade;
	}
	
	public static UserFacade getUserFacade(){
		if (userFacade==null)
			userFacade=new UserFacadeBean();
		return userFacade;
	}

	public static OrdersFacade getOrderFacade() {
		if (ordersFacade == null) {
			ordersFacade = new OrderFacadeBean();
		}
		return ordersFacade;
	}

	public static CartFacade getCartFacade() {
		if (cartFacade == null) {
			cartFacade = new CartFacadeBean();
		}
		return cartFacade;
	}

}
