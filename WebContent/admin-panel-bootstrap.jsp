<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Toki eShop - Admin panel</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
 
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index-bootstrap-figures.jsp">FruitShop</a>
            </div>
       
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">USERNAME: <c:out value="${username}" /> </a>
                    </li>
                </ul>      
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<div class="container">
	
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				
				<form action="ProductsCRUDServlet" method="post">
				
					<div class="form-group">
						<label  for="id">Product ID (for deletion or edit)</label>
						<input type="number" name="id" />
					</div>
				
					<div class="form-group">
						<label for="name">Product name</label>
						<input type="text" class="form-control" name="name" />
					</div>
					
					<div class="form-group">
						<label for="description">Description</label>
						<input type="text" class="form-control" name="description" />
					</div>
					
					<div class="form-group">
						<label for="um">Unit of measure</label>
						<input type="text" class="form-control" name="um" />
					</div>
					
					<div class="form-group">
						<label for="category">Category</label>
						<select class="form-control" name="category">
							<c:forEach items="${categories}" var="category">
								<option value="${category}" selected><c:out
										value="${category}" /></option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="subcategory">Sub-category</label>
						<select class="form-control" name="subcategory">
							<c:forEach items="${subcategories}" var="subcategory">
								<option value="${subcategory}" selected><c:out
										value="${subcategory}" /></option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="price">Price</label>
						<input type="text" class="form-control" name="price" />
					</div>
					
					<input class="btn btn-primary" type="submit" name="addProduct" value="Submit">
					<input class="btn btn-primary" type="submit" name="editProduct" value="Edit">
					<input class="btn btn-primary" type="submit" name="delProduct" value="Delete">
					<input class="btn btn-primary" type="submit" name="refresh" value="Refresh">
				</form>
				
			</div>
		</div>
		
		<br/><br/>
		
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-hover">
		           		<thead>
							<tr>
								<th>ID</th>
								<th>Product</th>
								<th>Category</th>								
								<th>Sub-category</th>
								<th>Price</th>
							</tr>
						</thead>
							
						<tbody>
							<c:forEach items="${products}" var="product">
								<tr>
									<td><c:out value="${product.productId}" /></td>
									<td><c:out value="${product.name}" /></td>
									<td><c:out value="${product.category}" /></td>									
									<td><c:out value="${product.subcategory}" /></td>
									<td><c:out value="${product.price}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
		</div>
	</div>

	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
</body>
</html>