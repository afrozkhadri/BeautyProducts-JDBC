<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Items</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: white;">
	<form:form>
		<div class="container">
			<br> <br>
			<center>
				<u><h2>Beauty Store</h2></u>
			</center>
			<br>
			<table class="table" border='0px'>
				<thead>
					<tr>

						<th>ProductName</th>
						<th>Description</th>
						<th>UnitPrice</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${bpList}" var="blist">

						<tr>

							<td>${blist.name}</td>
							<td>${blist.description}</td>

							<td>${blist.price}</td>
							<td><a href="update/${ blist.id}">UPDATE </a></td>
							<td><a href="delete/${blist.id }">DELETE</a></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<br> <br>
			<center>


				<a href="home">HOME</a>
			</center>
		</div>

	</form:form>
</body>
</html>