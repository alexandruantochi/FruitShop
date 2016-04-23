package eu.ubis.eshop.pf.admin;

import java.io.IOException;
import java.io.Console;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ubis.eshop.bfcl.FacadeFactory;
import eu.ubis.eshop.bfcl.ProductDTO;
import eu.ubis.eshop.bfcl.ProductFacade;

@WebServlet("/ProductsCRUDServlet")
public class ProductsCRUD extends HttpServlet {

	private static final String SESSIONID = "SESSIONID";
	private static final long serialVersionUID = 1L;
	
	private static ProductFacade productFacade = FacadeFactory.getProductFacade();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("addProduct") != null) {
			addProduct(request, response);
			return;
		} else if (request.getParameter("editId") != null) {
			showProductById(request, response);
            pullCategories(request, response);
		    return;
		} else if (request.getParameter("editProduct") != null) {
			editProduct(request, response);
		    return;
		} else if (request.getParameter("delProduct") != null) {
		    delProduct(request, response);
		    return;
		} else if (request.getParameter("refresh")!= null)
		{
			showProducts(request, response);
			return;
		}
		  
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productName = request.getParameter("name");
		String productDescription = request.getParameter("description");
		String productUM = request.getParameter("um");
		String productCategory = request.getParameter("category");
		String productSubcategory = request.getParameter("subcategory");
		String productPrice = request.getParameter("price");

		ProductDTO product = new ProductDTO();
		product.setName(productName);
		product.setDescription(productDescription);
		product.setUm(productUM);
		product.setCategory(productCategory);
		product.setSubcategory(productSubcategory);
		product.setPrice(Float.parseFloat(productPrice));

		productFacade.saveProduct(product);
		showProducts(request, response);
	}
	
	private void showProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id=Integer.parseInt(request.getParameter("editId"));
		
		ProductDTO productDTO = productFacade.getProductById(id);
		session.setAttribute("product", productDTO);
		
		response.sendRedirect(request.getContextPath() + "/editProduct.jsp");
	}
	
	private void editProduct (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("id");
		String productName = request.getParameter("name");
		String productDescription = request.getParameter("description");
		String productUM = request.getParameter("um");
		String productCategory = request.getParameter("category");
		String productSubcategory = request.getParameter("subcategory");
		String productPrice = request.getParameter("price");

		ProductDTO product = new ProductDTO();
		
		product.setProductId(Integer.parseInt(productId));
		product.setName(productName);
		product.setDescription(productDescription);
		product.setUm(productUM);
		product.setCategory(productCategory);
		product.setSubcategory(productSubcategory);
		product.setPrice(Float.parseFloat(productPrice));

		productFacade.editProduct(product);
		showProducts(request, response);
	}
	
	private void delProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId=request.getParameter("id");
		productFacade.delProduct(productId);
		showProducts(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String action = request.getParameter("action");
		
		if (action.equals("getProducts")) {
			showProducts(request, response);
		}
	}


	private void pullCategories(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<String> categories = productFacade.getAllCategories();
		List<String> subcategories = productFacade.getAllSubcategories();
		session.setAttribute("categories", categories);
		session.setAttribute("subcategories", subcategories);
	
	}
	private void showProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		List<ProductDTO> products = productFacade.getAllProducts();
		List<String> categories = productFacade.getAllCategories();
		List<String> subcategories = productFacade.getAllSubcategories();

		session.setAttribute("products", products);
		session.setAttribute("categories", categories);
		session.setAttribute("subcategories", subcategories);
		session.setAttribute("username", session.getId());

		if (request.getParameter(SESSIONID) != null) {
			Cookie userCookie = new Cookie(SESSIONID, request.getParameter(SESSIONID));
			response.addCookie(userCookie);
		} else {
			String sessionId = session.getId();
			Cookie userCookie = new Cookie(SESSIONID, sessionId);
			response.addCookie(userCookie);
		}

		response.sendRedirect(request.getContextPath() + "/admin-panel-bootstrap.jsp");
	}
	
	
}
