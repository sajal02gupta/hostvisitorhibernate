<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View visitors</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home.jsp">innovaccer</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home.jsp">Home</a></li>
			<li><a href="visitorinfoform.jsp">Register visitor</a></li>
			<li><a href="hostinfoform.jsp">Register Host</a></li>
			<li><a href="ViewAllServlet">View all Visitors</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">CheckInTime</th>
					<th scope="col">Checkout</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${list}" var="z">
				<form action="CheckOutServlet" method="post">
				<tr>
				<input type="hidden" name="vid" value="${z.vId}">
				<td>${z.vname}</td>
				<td>${z.vemail}</td>
				<td>${z.vphone}</td>
				<td>${z.checkintime}</td>
				<c:if test="${z.checkouttime eq null}">
					
					<td><input type="submit" class="btn btn-primary btn-block" value="Checkout"></td>
				</c:if>
				<c:if test="${z.checkouttime ne null}">
					<td>${z.checkouttime}</td>
				</c:if>
				</tr>
				</form>
			</c:forEach>
			
			</tbody>
		</table>
		
		
	</div>
</body>
</html>