<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="eu.ubis.eshop.bfcl.ProductDTO, eu.ubis.eshop.bfcl.UserDTO"%>

<!-- Ca sa lucram cu HTML5 si functionalitatile lui, trebuie sa includem cel mai recent doctype, ca mai jos -->
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toki eShop</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>

	<jsp:useBean id="demoBean" class="eu.ubis.eshop.pf.DemoBean"></jsp:useBean>

	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">FruitShop</a>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<% if (session.getAttribute("logged")=="yes")  { %>
				<ul class="nav navbar-nav">

					<li class="active"><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right" action="UserCRUDServlet" method="post">
				<p class="nav navbar-nav" style="font-size:1.5em">Welcome, <c:out value="${first_name}" /> !
				<button type="submit" class="btn btn-warning" name="logout">Log Out</button>
				<button type="submit" class="btn btn-success" name="cart">Your cart (<c:out value="${cart_items}"/>)</button>
				</p>
				
				</form>
				<% } else if (session.getAttribute("logged")=="fail"){%>
				<form class="navbar-form navbar-right" action="UserCRUDServlet" method="post">
				<button type="submit" class="btn btn-warning" name="logout">Invalid username or password, click here to retry</button>
				</form>
				<% }  else { %>
				<a href="register.jsp" class="navbar-form navbar-right"> <button type="submit" class="btn btn-default">Register</button> </a>
				<form class="navbar-form navbar-right" action="UserCRUDServlet" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="username" placeholder="Username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="pwd" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-success" name="login">Sign In</button>
				</form>
				
				<%} %>
			</div>
		</div>
	</div>




	<div class="col-md-3">
		<p class="lead">Products</p>

		<!-- Aducem subcategoriile in functie de ID-ul categoriei 
         			 pretty incurcat, pentru ca se alterneaza cod Java cu tag-uri HTML-->
		<%
    			 	for (String category : demoBean.getAllCategories()) {
    			 %>
		<div class="list-group">
			<a href="#" class="list-group-item category"><strong> <%=category%>
			</strong></a>

			<%
    			 		for (String subcategory : demoBean.getSubcategoriesByCategoryName(category)) {
    			 	%>
			<a href="#" class="list-group-item subcategory"> <%=subcategory%>
			</a>
			<%
    			 		}
    			 	%>
		</div>
		<%
    			 	}
    			 %>

		<input type="button" class="btn btn-primary"
			onClick="location.href='ProductsCRUDServlet?action=getProducts'"
			value='Admin'>
	</div>

	<div class="col-md-9">
		<!-- Un exemplu a ce va ofera Bootstrap - carusel cu imagini (in cazul meu, am luat imaginile de pe net :-)
            		 usor de configurat. Exemplu pe site-ul lor. -->
		<div class="row carousel-holder">
			<div class="col-md-12">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img class="slide-image"
								src="https://andyfood.com/wp-content/uploads/2015/07/Grilled-Fruit-Sangria-800x300.jpg"
								alt="">
						</div>
						<div class="item">
							<img class="slide-image"
								src="http://www.ebuyfsoft.com/photo/wp-content/uploads/2015/07/Red-Pomegranate-Fruit-Wallpaper-HD-800x300.jpg"
								alt="">
						</div>
						<div class="item">
							<img class="slide-image"
								src="http://www.paleoeffect.com/wp-content/uploads/2014/07/paleo_jam_strawberry_recipe-800x300@2x.jpg"
								alt="">
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>

		<div class="row">

			<%
						for (ProductDTO prod : demoBean.getAllProducts()) {
					%>
			<!-- clase responsive din Bootstrap -->
			<div class="col-sm-4 col-lg-4 col-md-4">
				<div class="thumbnail">
					<img src="http://www.dietasyperderpeso.com/images/static/16.jpg"
						alt="">
					<!-- prod.getImage(), daca aveti -->
					<div class="caption">
						<h4 class="pull-right"><%= prod.getPrice() %>
							RON
						</h4>
						<!-- prod.getPrice(), daca aveti implementat -->
						<h4><%= prod.getName() %></h4>
						<p>
							<strong>Category:</strong>
							<%= prod.getCategory() %></p>
						<p>
							<strong>Sub-category:</strong>
							<%= prod.getSubcategory() %></p>
						<p>
							<i><%= prod.getDescription() %></i>
						</p>
					</div>
					<form action="CartCRUDServlet" method="post">
						<input class="btn btn-success" type="submit" name="addToCart"
							value="Buy"> <input class="btn btn-success" type="submit"
							name="fav" value="Fav">
						<!--/<div class="form-group">
								<label for="id"></label>--->
						<input type="hidden" class="form-control" name="id" />
						<!--	</div>  -->
					</form>
				</div>
			</div>
			<%	
						}
                    %>

		</div>

	</div>
	</div>
	</div>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>