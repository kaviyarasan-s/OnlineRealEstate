<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
body{
	overflow-x: hidden; 
}
</style>
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post"
					action="ServletRegister">
					<span class="login100-form-title p-b-49"> Register </span>
					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Username is required">
						<span class="label-input100">Name</span> <input class="input100"
							type="text" name="name" placeholder="Type your name" required>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Email is required">
						<span class="label-input100">Email</span> <input class="input100"
							type="text" name="email" placeholder="Type your email" required>
						<span class="focus-input100" data-symbol="&#9993;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" name="password"
							placeholder="Type your password" required> <span
							class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Mobilenumber is required">
						<span class="label-input100">Mobile number</span> <input
							class="input100" type="text" name="phonenumber"
							placeholder="Type your phonenumber" required> <span
							class="focus-input100" data-symbol="&#xf2b6;"></span>
					</div>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Register</button>
						</div>
					</div>

					<div class="container-login100-form-btn ">
						<div>
							<div class="login100-form-bgbtn"></div>
							<a href="login.jsp">Back</a>
						</div>
					</div>
					<div class="flex-col-c p-t-10">
						<span class="txt1"> <%
 	if (request.getAttribute("MESSAGE") != null) {
 		out.print(request.getAttribute("MESSAGE"));
 	}
 %>
						</span>
					</div>

				</form>

			</div>
		</div>
	</div>
</body>

<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/animsition/js/animsition.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<script src="vendor/countdowntime/countdowntime.js"></script>
<script src="js/main.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>