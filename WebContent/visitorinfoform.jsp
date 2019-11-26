<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home.jsp">innovacer</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home.jsp">Home</a></li>
			<li><a href="visitorinfoform.jsp">Register visitor</a></li>
			<li><a href="hostinfoform.jsp">Register Host</a></li>
			<li><a href="viewall.jsp">View all Visitors</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h1>Visitor Information</h1>
		<form action="VisitorServlet" method="post" class="col-md-8">
			
			<div class="form-group">
				<label for="ptitle">Name </label> <input type="text"
					class="form-control" name="vname">
			</div>
			<div class="form-group">
				<label for="city">Email</label> <input type="email"
					class="form-control" name="vemail">
			</div>
			<div class="form-group">
				<label for="pcode"></label>Phone<input type="number"
					class="form-control" name="vphone">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>