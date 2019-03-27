<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>
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
.box {
	display: flex;
	align-items: stretch;
}
</style>
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<div>
					<center>
						<h4>
							<b>My profile</b>
						</h4>
					</center>
				</div>
				<div class="box">
					<c:if test="${editname}">
						<div class="col-md-12">
							<form method="post" action="ServletEditProfile">

								<div class="col-md-6">
									<b>Name:</b><input type="text" name="name"
										value="${USERDETAILS.name}" class="form-control input-md"
										style="width: 50%">
								</div>
								<div class="col-md-3">
									<button type="submit" name="button" value="editname"
										class="btn btn-primary">Change</button>
								</div>

							</form>
							<form method="post" action="ServletEditProfile">
								<div class="col-md-3">
									<button type="submit" name="button" value="editname"
										class="btn btn-primary">Cancel</button>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${!editname}">
						<div class="col-md-8">
							<b>Name : </b>${USERDETAILS.name}
						</div>
						<div class="col-md-4">
							<form method="get" action="ServletEditProfile">
								<button type="submit" name="button" value="editname"
									class="btn btn-primary">Edit</button>
							</form>
						</div>
					</c:if>
				</div>
				<div class="box" style="margin-top:2%;margin-left:4%">
					
						<b>Email :</b> ${USERDETAILS.email}
					
				</div>
				<div class="box" style="margin-top:4%">
					<c:if test="${editphonenumber}">

						<form method="post" action="ServletEditProfile">
							<div class="col-md-6">
								<b>Phone number:</b><input type="text" name="phonenumber"
									value="${USERDETAILS.mobilenumber}"
									class="form-control input-md" style="width: 50%">
							</div>
							<div class="col-md-3">
								<button type="submit" name="button" value="editphonenumber"
									class="btn btn-primary">Change</button>
							</div>
						</form>
						<div class="col-md-3">
							<form method="post" action="ServletEditProfile">
								<button type="submit" name="button" value="editphonenumber"
									class="btn btn-primary">Cancel</button>
							</form>
						</div>

					</c:if>
					<c:if test="${!editphonenumber}">

						<div class="col-md-8">
							<b>Phone number :</b> ${USERDETAILS.mobilenumber}
						</div>
						<div class="col-md-4">
							<form method="get" action="ServletEditProfile">
								<button type="submit" name="button" value="editphonenumber"
									class="btn btn-primary">Edit</button>
							</form>
						</div>

					</c:if>

				</div>
				<div class="box" style="margin-top:4%">
					<c:if test="${editpassword}" >
						<div class="col-md-12">
							<form method="post" action="ServletEditProfile">
								<div class="col-md-6">
									<b>Password :</b> <input type="text" name="password"
										value="${USERDETAILS.password}" class="form-control input-md"
										style="width: 50%">
								</div>
								<div class="col-md-3">
									<button type="submit" name="button" value="editpassword"
										class="btn btn-primary">Change</button>
								</div>
							</form>
							<form method="post" action="ServletEditProfile">
								<div class="col-md-3">
									<button type="submit" name="button" value="editpassword"
										class="btn btn-primary">Cancel</button>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${!editpassword}">

						<div class="col-md-8">
							<b>Password :</b> ${USERDETAILS.password}
						</div>
						<div class="col-md-4">
							<form method="get" action="ServletEditProfile">
								<button type="submit" name="button" value="editpassword"
									class="btn btn-primary">Edit</button>
							</form>
						</div>

					</c:if>
				</div>


				<div>
					<a href="ServletHome"><b>Back</b></a>
				</div>
				<div>
					<%
						if (request.getAttribute("MESSAGE") != null) {
							out.print(request.getAttribute("MESSAGE"));
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>