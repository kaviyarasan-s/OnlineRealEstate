<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Home</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
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
<link rel="stylesheet" type="text/css" href="css/simple-sidebar.css">
<style type="text/css">
.columnalign {
	-webkit-columns: 100px 3; /* Chrome, Safari, Opera */
	-moz-columns: 100px 3; /* Firefox */
	columns: 100px 3;
}

.column {
	float: left;
	width: 50%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}
/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

div.landinfo {
	padding: 10%;
	height: 450px;
	overflow-x: auto;
	text-align: justify;
}

div.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="sidebar-heading">Menu</div>
			<div class="list-group list-group-flush">
				<a href="ServletGetProfile"
					class="list-group-item list-group-item-action bg-light">Profile</a>
				<a href="ServletPostLand"
					class="list-group-item list-group-item-action bg-light">Sale
					land</a> <a href="ServletHome"
					class="list-group-item list-group-item-action bg-light">Buy
					land</a> <a href="ServletGetOwnLand"
					class="list-group-item list-group-item-action bg-light">Own
					land</a>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
			<button class="btn btn-primary" id="menu-toggle">
				<i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
					<li class="nav-item active"><span style="color: red">Chain.</span><span>sys
							india promotors</span></li>
				</ul>
			</div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
					<li class="nav-item active"><span>Welcome </span> <%
 	/* String email = request.getAttribute("email").toString();
 	if (email != null && !email.isEmpty()) {
 		out.print(email);
 	} */
 	HttpSession httpSession = request.getSession(false);
 	String userName = httpSession.getAttribute("userName").toString();
 	if (userName != null && !userName.isEmpty()) {
 		out.print(userName);
 	}
 %></li>
					<li class="nav-item"><a href="ServletLogout"
						style="color: red">&nbsp;&nbsp;Sign out</a></li>
				</ul>
			</div>
			</nav>
			<div>
				<c:if test="${ISPROFILE}">
					<%@ include file="profile.jsp"%>
				</c:if>
				<c:if test="${ISPOSTLAND}">
					<%@ include file="LandDetail.jsp"%>
				</c:if>
				<c:if test="${OWNLAND}">
					<%@ include file="ownland.jsp"%>
				</c:if>
				<c:if test="${ISBUYLAND}">
					<%@ include file="buyland.jsp"%>
				</c:if>
			</div>
			<!-- /#page-content-wrapper -->
		</div>
		<div class="footer"><center>&#169; - 2019 Chain-Sys India Pvt. Ltd</center></div>
	</div>
	<!-- /#wrapper -->
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="javascript/land.js"></script>
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>
</html>