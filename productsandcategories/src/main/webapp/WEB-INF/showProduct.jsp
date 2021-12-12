<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${product.name}</title>
</head>
<body>

	<h1>${product.name}</h1>
	
	<h3>Categories</h3>
	
	<!-- for loop to display current categories product is already added to -->
	<c:forEach var="category" items="${product.categories}">
	<!-- could use p tag as well but may be too small -->
		<h4>${category.name}</h4>
	</c:forEach>
	
		 
	    <form class="m-auto w-50 p-3" action="/products/${product.id}/addcategory" method="POST">
	    <p class="m-auto w-50 p-2 d-flex justify-content-between">

	    <!--  issues with spring form vs html form  see notes for setup-->    
			<!-- remember to include name for select tag -->
		        <select name="category">
		        <c:forEach var="category" items="${notProduct}">
		        	<option value="${category.id}">${category.name}</option>
		        </c:forEach>
				</select>
	    </p>
		
		<input class ="btn btn-success btn-sm d-flex justify-content-sm-end" type="submit" value="Add"/>
		</form>

	<p><a href="/">Back To Main Page</a></p>
	<p><a href="/products">Back To All Products</a></p>


</body>
</html>