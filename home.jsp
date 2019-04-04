<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Beauty Store</title>
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

					</tr>

				</c:forEach>

			</tbody>
		</table>
		<br> <br>
		<center>
			<tr>
				<td colspan="2"><a href="addform">Add Items</a></td>

			</tr>
			<tr>
				<td colspan="10"><a href="editform">Edit Items</a></td>
			</tr>
		</center>
	</div>
</body>
</html>