<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>
</head>
<body>

	<div class="col-md-12">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div>My profile</div>
			<div class="col-md-12">
				<c:if test="${editname}">
					<div>
						<form method="post" action="ServletEditProfile">
							<div>
								name:<input type="text" name="name" value="${USERDETAILS.name}">
								<button type="submit" name="button" value="editname">Change</button>
							</div>
						</form>
					</div>
				</c:if>
				<c:if test="${!editname}">
					<div class="col-md-12">
						<div class="col-md-8">Name : ${USERDETAILS.name}</div>
						<div class="col-md-4">
							<form method="get" action="ServletEditProfile">
								<button type="submit" name="button" value="editname">Edit</button>
							</form>
						</div>
					</div>
				</c:if>
			</div>
			<div class="col-md-12">
				<div>Email : ${USERDETAILS.email}</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-12">
					<c:if test="${editphonenumber}">
						<div>
							<form method="post" action="ServletEditProfile">
								<div>
									Phone number:<input type="text" name="phonenumber"
										value="${USERDETAILS.mobilenumber}">
									<button type="submit" name="button" value="editphonenumber">Change</button>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${!editphonenumber}">
						<div class="col-md-12">
							<div class="col-md-8">Phone number :
								${USERDETAILS.mobilenumber}</div>
							<div class="col-md-4">
								<form method="get" action="ServletEditProfile">
									<button type="submit" name="button" value="editphonenumber">Edit</button>
								</form>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			<div class="col-md-12" style="margin-top:1%">
				<div class="col-md-12">
					<c:if test="${editpassword}">
						<div>
							<form method="post" action="ServletEditProfile">
								<div>
									Password : <input type="text" name="password"
										value="${USERDETAILS.password}">
									<button type="submit" name="button" value="editpassword">Change</button>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${!editpassword}">
						<div class="col-md-12">
							<div class="col-md-8">Password : ${USERDETAILS.password}</div>
							<div class="col-md-4">
								<form method="get" action="ServletEditProfile">
									<button type="submit" name="button" value="editpassword">Edit</button>
								</form>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			<div class="col-md-12">
				<div>
					<a href="ServletHome">Back</a>
				</div>
			</div>
			<div class="col-md-12">
				<div>
					<%
						if (request.getAttribute("MESSAGE") != null) {
							out.print(request.getAttribute("MESSAGE"));
						}
					%>
				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>

</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>