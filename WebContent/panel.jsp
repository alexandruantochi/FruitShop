<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="eu.ubis.eshop.bfcl.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="demoBean" class="eu.ubis.eshop.pf.admin.ProductsCRUD"></jsp:useBean>
	USER NAME :
	<c:out value="${username}" />
	<form action="DemoServlet?action=addProduct" method="post">

		<div>
			<div>Product name</div>
			<input type="text" name="name">
		</div>
		<div>
			<div>Product description</div>
			<input type="text" name="description">
		</div>
		<div>
			<div>Category</div>
			<select name="category">
				<c:forEach items="${categories}" var="category">
					<option value="${category}" selected><c:out
							value="${category}" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<div>Subcategory</div>
			<select name="subcategory">
				<c:forEach items="${subcategories}" var="subcategory">
					<option value="${subcategory}" selected><c:out
							value="${subcategory}" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<div>Price</div>
			<input type="number" name="price" />
		</div>

		<input type="submit" value="Submit">
	</form>
</body>
</html>