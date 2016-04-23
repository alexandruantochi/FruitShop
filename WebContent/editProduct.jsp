<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/shop-homepage.css" rel="stylesheet">

<title>Edit product</title>
</head>
<body>
	<div class="container">
	
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				
				<form action="ProductsCRUDServlet?action=editProduct" method="post">
				
				<div class="form-group">
						<label for="id">ID</label>
						<input type="text" class="form-control" name="id" value="${product.productId}"/>
					</div>
				
					<div class="form-group">
						<label for="name">Product name</label>
						<input type="text" class="form-control" name="name" value="${product.name}"/>
					</div>
					
					<div class="form-group">
						<label for="description">Description</label>
						<input type="text" class="form-control" name="description" value="${product.description}"/>
					</div>
					
					<div class="form-group">
						<label for="category">Category</label>
						<select class="form-control" name="category">
						
							<c:forEach items="${categories}" var="category">
								<option value="${category}" selected><c:out
										value="${category}" /></option>
							</c:forEach>
							<option value="${product.category}" selected>${product.category}</option>
		
						</select>
					</div>
					
					<div class="form-group">
						<label for="subcategory">Sub-category</label>
						<select class="form-control" name="subcategory">
							<c:forEach items="${subcategories}" var="subcategory">
								<option value="${subcategory}" selected><c:out
										value="${subcategory}" /></option>
							</c:forEach>
							<option value="${product.subcategory}" selected>${product.subcategory}</option>
						</select>
					</div>
					
					<div class="form-group">
						<label for="um">Unit of measure</label>
						<input type="text" class="form-control" name="um" value="${product.um}"/>
					</div>
					
					<div class="form-group">
						<label for="price">Price</label>
						<input type="text" class="form-control" name="price" value="${product.price}"/>
					</div>
					
					<input class="btn btn-primary" type="submit" name="editProduct" value="Edit">
					
				
				</form>
				
			</div>
		</div>
</div>
</body>
</html>