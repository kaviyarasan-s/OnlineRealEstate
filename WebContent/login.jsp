<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<form method="post" action="ServletLogin">
			<div>
				User Name:<input type="text" name="username">
			</div>
			<div>
				Password:<input type="password" name="password">
			</div>
			<div>
				<button type="submit">Login</button>
			</div>
			<div>
				<a href="register.jsp">Signup</a> <a href="forgotpassword.jsp">Forget
					password</a>
			</div>

		</form>
	</div>
	<div>
		<%
			if (request.getAttribute("message") != null) {
				out.print(request.getAttribute("message"));
			}
		%>
	</div>
	<div>
		<form method="get" action="ServletRegister">
			<button type="submit">View</button>

		</form>
	</div>
	<div>
		<form method="post" action="ServletFilterLand">
			<button type="submit">Filter</button>

		</form>
	</div>
</body>
</html>