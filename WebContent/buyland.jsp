<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy land</title>
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
</style>
</head>
<body>
	<div>
		<form method="post" action="ServletFilterLand">
			<div class="row">
				<div class="col-md-9">
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
									<%-- <c:if test="${purchase!='Rent'&&purchase=='Sale'}">
											<option value="Rent">Rent</option>
										</c:if> --%>
									<c:if test="${purchase=='Rent'}">
										<option value="Rent" selected>Rent</option>
										<option value="Sale">Buy</option>
									</c:if>
									<%-- <c:if test="${purchase!='Sale'&&purchase=='Rent'}">
												<option value="Sale">Buy</option>
											</c:if> --%>
									<c:if test="${purchase=='Sale'}">
										<option value="Rent">Rent</option>
										<option value="Sale" selected>Buy</option>
									</c:if>
									<c:if test="${purchase==''||purchase==null}">
										<option value="Rent">Rent</option>
										<option value="Sale">Buy</option>
									</c:if>
									<%-- <c:if test="${purchase!='Sale'&&purchase!='Rent'}">
												<option value="Rent">Rent</option>
												<option value="Sale">Buy</option>
											</c:if> --%>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-12" style="margin-top: 2%">
						<button class="btn btn-info">Search</button>
					</div>
					<div class="row landinfo" style="margin-top: 2%">

						<c:if test="${LANDDETAILS!=null}">
							<div style="margin-right: 10%;color:red"><b>Land List:</b></div>
							<div>
								<c:forEach var="landdetails" items="${LANDDETAILS}">
									<div style="margin-bottom: 2%;">
										<div class="column">
											<div>
												<b>Building name:</b>${landdetails.buildingName}</div>
											<div>
												<b>Property type:</b>${landdetails.property.name}</div>
											<div>
												<b>Location name:</b> ${landdetails.location.name}
											</div>
											<div>
												<b>City name: </b>${landdetails.location.city.name}</div>
											<div>
												<b>Land size: </b>${landdetails.size}</div>
											<div>
												<b>BHK: </b>${landdetails.bhk}</div>
											<div>
												<b>Status: </b>${landdetails.status}</div>
											<div>
												<b>Description:</b> ${landdetails.description}
											</div>
										</div>
										<div class="column">
											<div>
												<b>Price: </b>${landdetails.price}</div>
											<div>
												<b>Transaction type:</b> ${landdetails.transactionType}
											</div>
											<div>
												<b>Purchase type:</b> ${landdetails.purchaseType}
											</div>
											<div>
												<b>Discount:</b> ${landdetails.discount}
											</div>
											<div>
												<b>Owner contact details:</b>
												<div style="margin-left: 5%">
													<div>Owner name:${landdetails.user.name}</div>
													<div>Email:${landdetails.user.email}</div>
													<div>Mobile number:${landdetails.user.mobilenumber}</div>
												</div>
											</div>

										</div>
									</div>
								</c:forEach>
							</div>
						</c:if>
						<c:if test="${LANDDETAILS==null}">
							<div>
								<h5>No results found.</h5>
							</div>
						</c:if>

					</div>
				</div>
				<br />
				<div class="col-md-3">
					<div>
						<div>Filter type</div>
						<div>
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
						<div>
							<div>Price</div>
							<div>
								<c:if test="${price!=null&&price!=0 }">
									<input type="number" name="price" class="form-control"
										style="width: 50%" value="${price}" id="landprice">
								</c:if>
								<c:if test="${price==null||price==0 }">
									<input type="number" name="price" class="form-control"
										style="width: 50%" id="landprice">
								</c:if>
							</div>
							<div id="pricechkerr" style="color: red"></div>
						</div>

						<div>
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
						<div style="margin-top: 2%">
							<button class="btn btn-info">Filter</button>
						</div>

					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>