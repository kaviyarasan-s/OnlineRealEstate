<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Own property</title>
<style>
div.landinfo {
	padding: 10%;
	height: 500px;
	width: 75%;
	overflow-y: scroll;
}
</style>
</head>
<body>
	<div class="row landinfo">
		<div>
			<c:if test="${LANDDETAILS!=null}">
				<div style="margin-right: 10%; color: red">
					<b>Land details:</b>
				</div>
				<div>
					<c:if test="${MESSAGE!=null }">
						<span>${MESSAGE}</span>
					</c:if>
				</div>
				<c:forEach var="landdetails" items="${LANDDETAILS}">

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
						<div>
							<form method="get" action="ServletEditLandInfo">
								<button type="submit" name="editland" value="${landdetails.id }"
									class="btn btn-primary">Edit</button>
							</form>
						</div>
					</div>

				</c:forEach>
			</c:if>
		</div>
		<c:if test="${LANDDETAILS==null}">
			<div>
				<h5>No results found.</h5>
			</div>
		</c:if>

	</div>
</body>
</html>