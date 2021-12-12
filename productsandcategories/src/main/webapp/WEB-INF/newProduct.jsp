<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
	<title>New Product</title>
</head>
<body>

		<h1>New Product</h1>
		
		<p><a href="/">Back To Main Page</a></p>
		
		<form:form class="m-auto w-50 p-3" action="/products/new" method="POST" modelAttribute="product">
	    
	    <p class="m-auto w-50 p-2 d-flex justify-content-between">
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    
	    <p class="m-auto w-50 p-2 d-flex justify-content-between">
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </p>
	    
	    <p class="m-auto w-50 p-2 d-flex justify-content-between">
	        <form:label path="price">Price:</form:label>
	        <form:errors path="price"/>
	        <form:input path="price"/>
	    </p>
	      
	    <input class ="btn btn-success btn-sm d-flex justify-content-sm-end" type="submit" value="Create"/>
	</form:form>    

</body>
</html>