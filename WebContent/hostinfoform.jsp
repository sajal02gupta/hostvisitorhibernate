<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Host Info</title>
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
	<h1>Hey! Register Yourself</h1>
		<form action="HostServlet" method="post" class="col-md-5">
			<div class="form-group">
				<label for="ptitle">Name </label> <input type="text"
					class="form-control" name="hostname">
			</div>
			<div class="form-group">
				<label for="city">Email</label> <input type="email"
					class="form-control" name="hostemail">
			</div>
			<div class="form-group">
				<label for="pcode"></label>Phone<input type="number"
					class="form-control" name="hostphone">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>