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
import javax.swing.text.html.HTML;
import javax.websocket.Session;

import eu.ubis.eshop.bfcl.FacadeFactory;
import eu.ubis.eshop.bfcl.CartDTO;
import eu.ubis.eshop.bfcl.CartFacade;
import javafx.beans.binding.SetExpression;

@WebServlet("/CartCRUDServlet")


public class CartCRUD extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static CartFacade cartFacade = FacadeFactory.getCartFacade();
	


}
