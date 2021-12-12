<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
	<title>All Products</title>
</head>
<body>

	<h1>All Products</h1>
	
	<p><a href="/">Back To Main Page</a></p>
	
	<table class="table border border-dark table-striped table-hover m-auto w-50 p-3">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">Actions</th>
		    </tr>
		</thead>
			<tbody>
			    <c:forEach var="product" items="${products}">
			    <tr>
					<!-- c:out not needed for each time -->
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td><a href="/products/${product.id}">View Info</a></td>
				</tr>
				</c:forEach>
			</tbody>
	</table>
	

</body>
</html>