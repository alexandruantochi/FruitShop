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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import eu.ubis.eshop.bfcl.FacadeFactory;
import eu.ubis.eshop.bfcl.UserDTO;
import eu.ubis.eshop.bfcl.UserFacade;

@WebServlet("/UserCRUDServlet")
public class UserCRUD extends HttpServlet {

	private static final String SESSIONID = "SESSIONID";
	private static final long serialVersionUID = 1L;

	private static UserFacade userFacade = FacadeFactory.getUserFacade();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("login") != null) {
			login(request, response);
			return;
		} else if (request.getParameter("logout") != null) {
			logout(request, response);
			return;
		} else if (request.getParameter("editProduct") != null) {
			// editProduct(request, response);
			return;
		} else if (request.getParameter("delProduct") != null) {
			// delProduct(request, response);
			return;
		} else if (request.getParameter("refresh") != null) {
			// showProducts(request, response);
			return;
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		if (request.getParameter(SESSIONID) != null) {
			Cookie userCookie = new Cookie(SESSIONID, request.getParameter(SESSIONID));
			response.addCookie(userCookie);
		} else {
			String sessionId = session.getId();
			Cookie userCookie = new Cookie(SESSIONID, sessionId);
			response.addCookie(userCookie);
		}
		session.setAttribute("logged", "no");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		UserDTO userDTO = userFacade.getUserDetails(username, pwd);
		if (userDTO.getFirst_name() == null){
			session.setAttribute("logged", "fail");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		} else {
				session.setAttribute("first_name", userDTO.getFirst_name());
				session.setAttribute("userId", userDTO.getFirst_name());
				session.setAttribute("logged", "yes");
				response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session != null) {
		    session.invalidate();
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
