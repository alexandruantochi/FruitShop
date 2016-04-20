<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="eu.ubis.eshop.bfcl.ProductDTO"%>

<!-- Ca sa lucram cu HTML5 si functionalitatile lui, trebuie sa includem cel mai recent doctype, ca mai jos -->
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>John's shop</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>

	<jsp:useBean id="demoBean" class="eu.ubis.eshop.pf.DemoBean"></jsp:useBean>
	
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
 
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index-bootstrap-table.jsp">John's shop</a>
            </div>
       
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Despre John</a>
                    </li>
                    <li>
                        <a href="#">Ferme</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <div class="container">
    	<div class="row">
    	
    		<div class="col-md-3">
                <p class="lead">Noi avem</p>
                
         		<!-- Aducem subcategoriile in functie de ID-ul categoriei 
         			 pretty incurcat, pentru ca se alterneaza cod Java cu tag-uri HTML-->
    			 <%
    			 	for (String category : demoBean.getAllCategories()) {
    			 %>
    			 	<div class="list-group">
    			 	<a href="#" class="list-group-item category"><strong> <%=category%> </strong></a>
    			 	
    			 	<%
    			 		for (String subcategory : demoBean.getSubcategoriesByCategoryName(category)) {
    			 	%>
    			 		<a href="#" class="list-group-item subcategory"> <%=subcategory%> </a>
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
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="https://andyfood.com/wp-content/uploads/2015/07/Grilled-Fruit-Sangria-800x300.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://www.ebuyfsoft.com/photo/wp-content/uploads/2015/07/Red-Pomegranate-Fruit-Wallpaper-HD-800x300.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://www.paleoeffect.com/wp-content/uploads/2014/07/paleo_jam_strawberry_recipe-800x300@2x.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                 
               	<div class="table-responsive">
	               	<table class="table table-bordered table-striped table-hover">
	               		<thead>
							<tr>
								<th>Produs</th>
								<th>Categorie</th>
								<th>Subcategorie</th>
							</tr>
						</thead>
						
						<tbody>
							<%
								for (ProductDTO prod : demoBean.getAllProducts()) {
							%>
							<tr>
								<td><%=prod.getName() %></td>
								<td><%=prod.getCategory() %></td>
								<td><%=prod.getSubcategory() %></td>
							</tr>
							<%
								}
							%>
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