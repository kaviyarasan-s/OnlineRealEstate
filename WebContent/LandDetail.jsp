<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register land details</title>
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
<style>
	.wrap-login100
	{
		width:55%;
	}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#city')
								.change(
										function() {
											$('#locality').empty();
											$
													.ajax({
														url : 'ServletPostLand',
														data : {
															city : $('#city')
																	.val()
														},
														success : function(
																responseText) {
															var value = responseText
																	.trim()
																	.split(',');
															$('#locality')
																	.append(
																			"<option value='0'>----Choose---</option>");
															if (value != '') {
																for (var i = 0; i < value.length; i = i + 2) {
																	$(
																			'#locality')
																			.append(
																					"<option value="+value[i]+">"
																							+ value[i + 1]
																							+ "</option>");
																}
															}
														}
													});
										});
					});
</script>
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
		<div class="fixed-top">
		<div class="form-row">
			<div id="buttonDiv" class="md-form">
				<a href="ServletHome" class="btn btn-danger"><span class="glyphicon glyphicon-arrow-left">
				</span> Back</a>
			</div>
		</div>
	</div>
			<div class="wrap-login100 p-l-60 p-r-60 p-t-65 p-b-54">	
	<form method="post" class="login100-form validate-form" action="ServletPostLand">
		<span class="login100-form-title p-b-49"> Sale Land </span>
		<table border="0" align="center" width="615px" height="800px">
			<tr>
				<td>Property Type</td>
				<td><select name="propertytype">
						<option value="0">---Choose---</option>
						<c:forEach var="propertyinfo" items="${PROPERTYINFO}">
							<option value="${propertyinfo.id}">${propertyinfo.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>BHK</td>
				<td><select name="bhk">
						<option value="0">---Choose---</option>
						<option value="1">1 BHK</option>
						<option value="2">2 BHK</option>
						<option value="3">3 BHK</option>
						<option value="4">4 BHK</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>City</td>
				<td><select name="city" id="city">
						<option value="0">---Choose---</option>
						<c:forEach var="cityinfo" items="${CITY}">
							<option value="${cityinfo.id}">${cityinfo.name}</option>
						</c:forEach>
				</select></td>
				<td>Locality</td>
				<td><select name="locality" id="locality">
						<option value="0">---Choose---</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Building Name</td>
				<td><input type="text" name="buildingname"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Land Size</td>
				<td><input type="number" name="landsize"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Transaction Type</td>
				<td><select name="transactiontype">
						<option value="0">---Choose---</option>
						<option value="New">New</option>
						<option value="Resale">Re sale</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Purchase Type</td>
				<td><select name="purchasetype">
						<option value="0">---Choose---</option>
						<option value="Rent">Rent</option>
						<option value="Sale">Sale</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Discount</td>
				<td><input type="number" name="discount"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Status</td>
				<td><select name="status">
						<option value="0">---Choose---</option>
						<option value="Ready to Move">Ready to Move</option>
						<option value="Under Construction">Under Construction</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea rows="4" cols="33" name="description"></textarea>
				</td>
			</tr>
			</table>
			<br/>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
					<button class="login100-form-btn" type="submit" name="Enter">Submit</button>
					</div>
					</div>
					
			<center> ${MESSAGE} </center>
	</form>
	</div>
	</div>
	</div>
</body>
</html>