<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="com.mysql.cj.jdbc.Blob"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="com.webserv.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<%
if (session.getAttribute("username") == null)
	response.sendRedirect("login.jsp");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container">
			<div class="text-title">Product Management Tool</div>

			<div class="row">

				Hi
				<%=session.getAttribute("username")%>
				<div class="col">
					<a class="" href="logout" />Logout</a>
				</div>
			</div>
		</div>
	</nav>


	<div class="contaier">

		<div class="add-container">

			<form action="save" method="post" enctype='multipart/form-data'>
				<div>Please enter product details to add to stock</div>
				
				
				<input type="submit" value="Submit" id="button-1" />
				
				<div class=" row fixed-input">
					<label for="title" class="col-sm-2 col-form-label">Title</label>
					<div class="col-sm-10">
						<input type="text" name="title" />
					</div>
				</div>
				<div class="row">
					<label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
					<div class="col-sm-10">
						<input type="text" name="quantity" />
					</div>
				</div>
				<div class="row">
					<label for="size" class="col-sm-2 col-form-label">Size</label>
					<div class="col-sm-10">
						<input type="text" name="size" />
					</div>
				</div>
				<div class=" row">
					<label for="image" class="col-sm-2 col-form-label">Image</label>
					<div class="col-sm-10">
						<input type="file" name="image" />
					</div>
				</div>

			</form>

			
		</div>
		<div align="center">
			<table class="table" border="1" cellpadding="5">
				<tr>
					<th>S. No</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Image</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="product" items="${products}">
					<tr>
						<td><c:out value="${product.id}" /></td>
						<td><c:out value="${product.title}" /></td>
						<td><c:out value="${product.quantity}" /></td>
						<td><c:out value="${product.size}" /></td>
						<td><img src="/Product/src/main/resources/${product.id}/${product.imageLink} " width="100" height="100"></img></td>
						<td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>







</body>
</html>