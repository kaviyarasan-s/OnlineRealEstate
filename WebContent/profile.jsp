<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>
<style>
.box {
	display: flex;
	align-items: stretch;
}


</style>
</head>
<body>
	<div>
		<center>
			<h4>
				<b>My profile</b>
			</h4>
		</center>
	</div>
	<div class="box row" style="margin-left: 5%">
		<c:if test="${editname}">

			<form method="post" action="ServletEditProfile">

				<div class="row">
					<b>Name:</b><input type="text" name="name"
						value="${USERDETAILS.name}" class="form-control input-md"
						style="width: 60%; margin-left: 5%;outline: 1px solid #8080806e;">
				</div>
				<div class="row">
					<button type="submit" name="button" value="editname"
						class="btn btn-primary" style="margin-top: 4%">Change</button>
				</div>

			</form>
			<form method="post" action="ServletEditProfile">
				<div class="row">
					<button type="submit" name="button" value="editname"
						class="btn btn-primary">Cancel</button>
				</div>
			</form>
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
	<div class="box" style="margin-top: 2%; margin-left: 6.3%">

		<b>Email :</b> ${USERDETAILS.email}

	</div>
	<div class="box row" style="margin-top: 4%; margin-left: 5%">
		<c:if test="${editphonenumber}">

			<form method="post" action="ServletEditProfile">
				<div class="row">
					<b>Phone number:</b><input type="text" name="phonenumber"
						value="${USERDETAILS.mobilenumber}" class="form-control input-md" style="outline: 1px solid #8080806e;width:50%">
				</div>
				<div class="row">
					<button type="submit" name="button" value="editphonenumber"
						class="btn btn-primary">Change</button>
				</div>
			</form>
			<div class="row">
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
	<div class="box row" style="margin-top: 4%; margin-left: 5%">
		<c:if test="${editpassword}">
			<div class="row">
				<form method="post" action="ServletEditProfile">
					<div class="col-md-6">
						<b>Password :</b> <input type="text" name="password"
							value="${USERDETAILS.password}" class="form-control input-md"
							style="outline: 1px solid #8080806e;">
					</div>
					<div class="row">
						<button type="submit" name="button" value="editpassword"
							class="btn btn-primary" style="margin-top:5%;margin-left:10%">Change</button>
					</div>
				</form>
				<form method="post" action="ServletEditProfile">
					<div class="row">
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


	<!-- <div>
					<a href="ServletHome"><b>Back</b></a>
				</div> -->
	<div style="margin-left:6%">
		<%
			if (request.getAttribute("MESSAGE") != null) {
				out.print(request.getAttribute("MESSAGE"));
			}
		%>
	</div>
</body>
</html>