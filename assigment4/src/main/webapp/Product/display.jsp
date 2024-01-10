<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="com.nagarro.model.TShirt"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table class="table" border="1" cellpadding="5">
		<tr>
			<th>S. No</th>
			<th>name</th>
			<th>colour</th>
			<th>size</th>
			<th>genderRecomendation</th>
			<th>price</th>
			<th>rating</th>
		</tr>



		<c:forEach var="tshirt" items="${tshirths}">
			<tr>
				<td><c:out value="${tshirt.id}" /></td>
				<td><c:out value="${tshirt.name}" /></td>
				<td><c:out value="${tshirt.colour}" /></td>
				<td><c:out value="${tshirt.size}" /></td>
				<td><c:out value="${tshirt.genderRecomendation}" /></td>
				<td><c:out value="${tshirt.price}" /></td>
				<td><c:out value="${tshirt.rating}" /></td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>