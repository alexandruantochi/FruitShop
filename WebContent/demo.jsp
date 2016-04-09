<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="eu.ubis.eshop.bfcl.ProductDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="demoBean" class="eu.ubis.eshop.pf.DemoBean"></jsp:useBean>
	<table >
	<tr>
	<th style="border:1px solid black">Subcategorie</th>
	<th style="border:1px solid black">Categorie</th>
	<th style="border:1px solid black">Denumire Produs</th>
	</tr>
		<%
			for (ProductDTO prod : demoBean.getAllProducts()) {
		%>
		<tr>
			<td style="border:1px solid black"><%=prod.getSubcategory() %></td>
			<td style="border:1px solid black"><%=prod.getCategory() %></td>
			<td style="border:1px solid black"><%=prod.getName() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>