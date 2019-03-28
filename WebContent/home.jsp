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
					<li class="nav-item active">
						<%
							String email = request.getAttribute("email").toString();
							if (email != null && !email.isEmpty()) {
								out.print(email);
							}
						%>
					</li>
					<li class="nav-item"><a href="ServletLogout">&nbsp;&nbsp;Sign
							out</a></li>
				</ul>
			</div>
			</nav>
			<div>
				<c:if test="${USERDETAILS!=null}">
					<%@ include file="profile.jsp" %>
				</c:if>	
				<c:if test="${ISPOSTLAND}">
					<%@ include file="LandDetail.jsp" %>
				</c:if>
			</div>
			<c:if test="${ISBUYLAND}">
			<form method="post" action="ServletFilterLand">
				<div class="row">
					<div class="column">
						<div class="columnalign">
							<div class="col-md-12">
								<div>Property Type</div>
								<div>
									<select name="propertytype" required>
										<option value="">---Choose---</option>
										<c:forEach var="propertyinfo" items="${PROPERTYINFO}">
											<c:if test="${proprtype!=propertyinfo.id}">
												<option value="${propertyinfo.id}">${propertyinfo.name}</option>
											</c:if>
											<c:if test="${proprtype==propertyinfo.id}">
												<option value="${propertyinfo.id}" selected>${propertyinfo.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div>City</div>
								<div>
									<select name="city" id="city" required>
										<option value="">---Choose---</option>
										<c:forEach var="cityinfo" items="${CITY}">
											<c:if test="${cityid!=cityinfo.id}">
												<option value="${cityinfo.id}">${cityinfo.name}</option>
											</c:if>
											<c:if test="${cityid==cityinfo.id}">
												<option value="${cityinfo.id}" selected>${cityinfo.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div>Purchase Type</div>
								<div>
									<select name="purchasetype" required>
										<option value="">---Choose---</option>
										<c:if test="${purchase!='Rent'&&purchase=='Sale'}">
											<option value="Rent">Rent</option>
										</c:if>
										<c:if test="${purchase=='Rent'&&purchase!='Sale'}">
											<option value="Rent" selected>Rent</option>
										</c:if>
										<c:if test="${purchase!='Sale'&&purchase=='Rent'}">
											<option value="Sale">Buy</option>
										</c:if>
										<c:if test="${purchase=='Sale'&&purchase!='Rent'}">
											<option value="Sale">Buy</option>
										</c:if>
										<c:if test="${purchase!='Sale'&&purchase!='Rent'}">
											<option value="Rent">Rent</option>
											<option value="Sale">Buy</option>
										</c:if>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-12" style="margin-top: 2%">
							<button class="btn btn-info">Search</button>
						</div>
						<div class="col-md-12" style="margin-top: 2%">
							<c:if test="${LANDDETAILS!=null}">
								<c:forEach var="landdetails" items="${LANDDETAILS}">
									<div class="col-md-6">
										<div>Building name:${landdetails.buildingName}</div>
										<div>Location name: ${landdetails.location.name}</div>
										<div>City name: ${landdetails.location.city.name}</div>
										<div>Land size: ${landdetails.size}</div>
										<div>BHK: ${landdetails.bhk}</div>
										<div>Status: ${landdetails.status}</div>
									</div>
									<div class="col-md-6">
										<div>Description: ${landdetails.description}</div>
										<div>Price: ${landdetails.price}</div>
										<div>Transaction type: ${landdetails.transactionType}</div>
										<div>Purchase type: ${landdetails.purchaseType}</div>
										<div>Discount: ${landdetails.discount}</div>
										<div>
											Owner contact details:
											<div>Owner name:${landdetails.user.name}</div>
											Email:${landdetails.user.email}
										</div>
										<div>Mobile number:${landdetails.user.mobilenumber}</div>
									</div>
								</c:forEach>
							</c:if>
							<c:if test="${LANDDETAILS==null}">
								<div>
									<h5>No results found.</h5>
								</div>
							</c:if>
						</div>
					</div>
					<br />
					<div class="column">
						<div class="col-md-8">
							<div>Filter type</div>
							<div class="col-md-12">
								<div>BHK</div>
								<div>
									<select name="bhk">
										<c:if test="${bhk==1}">
											<option value="0">---Choose---</option>
											<option value="1" selected>1 BHK</option>
											<option value="2">2 BHK</option>
											<option value="3">3 BHK</option>
											<option value="4">4 BHK</option>
										</c:if>
										<c:if test="${bhk==2}">
											<option value="0">---Choose---</option>
											<option value="1">1 BHK</option>
											<option value="2" selected>2 BHK</option>
											<option value="3">3 BHK</option>
											<option value="4">4 BHK</option>
										</c:if>
										<c:if test="${bhk==3}">
											<option value="0">---Choose---</option>
											<option value="1">1 BHK</option>
											<option value="2">2 BHK</option>
											<option value="3" selected>3 BHK</option>
											<option value="4">4 BHK</option>
										</c:if>
										<c:if test="${bhk==4}">
											<option value="0">---Choose---</option>
											<option value="1">1 BHK</option>
											<option value="2">2 BHK</option>
											<option value="3">3 BHK</option>
											<option value="4" selected>4 BHK</option>
										</c:if>
										<c:if test="${bhk==null ||bhk==0}">
											<option value="0">---Choose---</option>
											<option value="1">1 BHK</option>
											<option value="2">2 BHK</option>
											<option value="3">3 BHK</option>
											<option value="4">4 BHK</option>
										</c:if>
									</select>
								</div>
							</div>
							<div class="col-md-12">
								<div>Price</div>
								<div>
									<c:if test="${price!=null&&price!=0 }">
										<input type="text" name="price" class="form-control"
											style="width: 50%" value="${price}">
									</c:if>
									<c:if test="${price==null||price==0 }">
										<input type="text" name="price" class="form-control"
											style="width: 50%">
									</c:if>
								</div>
							</div>
							<div class="col-md-12">
								<div>Transaction Type</div>
								<div>
									<c:if test="${trntype==null||trntype==''}">
										<select name="transactiontype">
											<option value="">---Choose---</option>
											<option value="New">New</option>
											<option value="Resale">Re sale</option>
										</select>
									</c:if>
									<c:if test="${trntype!=null&&trntype!=''}">
										<c:if test="${trntype=='New'}">
											<select name="transactiontype">
												<option value="">---Choose---</option>
												<option value="New" selected>New</option>
												<option value="Resale">Re sale</option>
											</select>
										</c:if>
										<c:if test="${trntype=='Resale'}">
											<select name="transactiontype">
												<option value="">---Choose---</option>
												<option value="New">New</option>
												<option value="Resale" selected>Re sale</option>
											</select>
										</c:if>
									</c:if>
								</div>
							</div>
							<div class="col-md-12" style="margin-top: 2%">
								<button class="btn btn-info">Filter</button>
							</div>

						</div>
					</div>
				</div>
			</form>
			</c:if>
			<!-- /#page-content-wrapper -->
		</div>
	</div>
	<!-- /#wrapper -->
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>
</html>