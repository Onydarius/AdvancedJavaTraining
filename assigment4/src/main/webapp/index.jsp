<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
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
			<div class="text-title">Search TShirt Tool</div>

			<div class="row">

				Hi
				<%=session.getAttribute("username")%>
				<div class="col">
					<a class="" href="Logout" />Logout</a>
				</div>
			</div>
		</div>
	</nav>


	<div class="contaier">

		<div class="container">

			<form action="Product/search" method="get">
				
				
				<div class=" row fixed-input">
					<label for="colour" class="col-sm-2 col-form-label">Color</label>
					<div class="col-sm-10">
						<input type="text" name="colour" />
					</div>
				</div>
				<div class="row">
					<label for="size" class="col-sm-2 col-form-label">Size</label>
					<div class="col-sm-10">
						<input type="text" name="size" />
					</div>
				</div>
				<div class="row">
					<label for="gender" class="col-sm-2 col-form-label">Gender</label>
					<div class="col-sm-10">
						<input type="text" name="gender" />
					</div>
				</div>
				<div class="row">
					<label for="output-preference" class="col-sm-2 col-form-label">Output preference (Price, Rating, Price and Rating)</label>
					<div class="col-sm-10">
						<input type="text" name="output-preference" />
					</div>
				</div>
				
				<input type="submit" value="Search" id="button-1" />

			</form>
	</div>







</body>
</html>