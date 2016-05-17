<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FruitShop - Register</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>


	<div class="container">

		<div class="row">
			<div class="col-md-6 col-md-offset-3">

				<form action="UserCRUDServlet" method="post">

					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" name="username" />
					</div>

					<div class="form-group">
						<label for="password">Password</label> <input type="text"
							class="form-control" name="password" />
					</div>
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" name="name" />
					</div>

					<div class="form-group">
						<label for="first_name">First Name</label> <input type="text"
							class="form-control" name="first_name" />
					</div>

					<div class="form-group">
						<label for="adress">Home address</label> <input type="text"
							class="form-control" name="adress" />
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" name="email" />
					</div>

					<div class="form-group">
						<label for="phone">Phone number</label> <input type="text"
							class="form-control" name="phone" />
					</div>


					<input class="btn btn-success" type="submit" name="register"
						value="Register">
				</form>
			</div>
		</div>
	</div>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>

