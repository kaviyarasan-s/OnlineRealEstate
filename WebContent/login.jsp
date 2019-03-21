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
	<div class="col-md-12">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form method="post" action="ServletLogin">
				<div>
					Email:<input type="text" name="email" class="form-control" required
						style="width: 50%">
				</div>
				<div>
					Password:<input type="password" name="password"
						class="form-control" required style="width: 50%">
				</div>
				<div style="margin-top: 1%">
					<button type="submit" class="btn btn-info">Login</button>
				</div>
			</form>
			<div>
				<div><a href="register.jsp">Sign up</a></div>
				<div><a
					href="forgotpassword.jsp">Forgot password</a></div>
			</div>
			<div>
				<%
					if (request.getAttribute("MESSAGE") != null) {
						out.print(request.getAttribute("MESSAGE"));
					}
				%>
			</div>
		</div>
		<div class="col-md-4"></div>

	</div>
</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>