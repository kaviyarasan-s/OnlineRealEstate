<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div class="col-md-12" style="background-color: black">
		<div class="col-md-8">
			<span style="color: red">Chain</span><span style="color: white">.sys</span>
			<span style="color: white">india promotors</span>
		</div>
		<div class="col-md-4">
			<div style="color: white">
				<%
					String email = request.getAttribute("email").toString();
					if (email != null && !email.isEmpty()) {
						out.print(email);
					}
				%>
			</div>
			<div style="color: white">
				<a href="ServletLogout">Sign out</a>
			</div>
		</div>
	</div>
	<form method="post" action="ServletFilterLand">
		<div class="col-md-12">
			<div class="col-md-2">
				<div class="col-md-12">
					<a href="ServletGetProfile">Profile</a>
				</div>
				<div class="col-md-12">
					<a href="ServletPostLand">Sale land</a>
				</div>
				<div class="col-md-12">
					<a href="ServletHome">Buy land</a>
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-12">
					<div class="col-md-4">
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
					</div>
					<div class="col-md-4">
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
					</div>
					<div class="col-md-4">
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
						<div><h4>No results found.</h4></div>
						</c:if>
					</div>

				</div>

			</div>
			<div class="col-md-4">
				<div class="col-md-12">
					<div>Filter type</div>
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
	</form>
</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>