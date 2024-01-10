<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<form action="edit" method="post" enctype='multipart/form-data'>
		<div>Please enter product details to edit to stock</div>
		<div class=" row fixed-input d-none">
			<label for="id" class="col-sm-2 col-form-label">ID: </label>
			<div class="col-sm-10">
				<input type="text" name="id-product" value="${product.id}" />
			</div>
		</div>


		<div class=" row fixed-input">
			<label for="title" class="col-sm-2 col-form-label">Title</label>
			<div class="col-sm-10">
				<input type="text" name="title" value="${product.title}" />
			</div>
		</div>
		<div class="row">
			<label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
			<div class="col-sm-10">
				<input type="text" name="quantity" value="${product.quantity}" />
			</div>
		</div>
		<div class="row">
			<label for="size" class="col-sm-2 col-form-label">Size</label>
			<div class="col-sm-10">
				<input type="text" name="size" value="${product.size}" />
			</div>
		</div>
		<div class=" row">
			<label for="image" class="col-sm-2 col-form-label">Image</label>
			<div class="col-sm-10">
				<input type="file" name="image" value="${product.imageLink}" />
			</div>
		</div>
		<input class="btn btn-info" type="submit" value="Submit" id="button-1" />
		<button class="btn btn-light">Go back</button>
	</form>
</body>
</html>