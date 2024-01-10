<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<%
if (session.getAttribute("username") != null)
	response.sendRedirect("index.jsp");
%>
	<div class="card">
		<form action="login" method="post">
			<div class="card-header header-container">Login</div>
			<div class="card-body secondary-color">
				<div class="mb-3 row">
					<label for="username" class="col-sm-2 col-form-label">Username:</label>
					<div class="col-sm-10">
						<input type="text" name="username" />
					</div>
				</div>
				<div class="mb-3 row">
					<label for="username" class="col-sm-2 col-form-label">Password:</label>
					<div class="col-sm-10">
						<input type="password" name="password" />
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 col-form-label"></label>
					<div class="col-sm-10">
						<a href="">Forgotten your password?</a>
					</div>
				</div>
			</div>
			<div class="card-footer primary-color">

				<div class="mb-3 row text-end">
					<label class="col-sm-2 col-form-label"></label>
					<div class="col-sm-10">
						<input type="submit"  value="Login »" id="login-button" />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>