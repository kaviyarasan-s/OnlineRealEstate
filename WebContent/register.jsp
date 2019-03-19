<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div>
		<form method="post" action="ServletEditProfile">
			<div>
				Name:<input type="text" name="name">
			</div>
			<div>
				Email:<input type="text" name="email">
			</div>
			<div>
				Phone number:<input type="number" name="phonenumber">
			</div>
			<div>
				Password:<input type="password" name="password">
			</div>
			<div>
				<button type="submit">Register</button>
			</div>
		</form>
		<div>
			<%
				if (request.getAttribute("message") != null) {
					out.print(request.getAttribute("message"));
				}
			%>
		</div>
		<div>
			<a href="login.jsp">Back</a>
		</div>
	</div>
</body>
</html>