<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register land details</title>

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
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post"
					action="ServletPostLand">
					<span class="login100-form-title p-b-49"> Sale Land </span>
					<div class="validate-input"
						data-validate="Property type is required">
						<span class="label-input100">Property Type</span> 
							<select
							name="propertytype" class="wrap-input100">
							<option value="0">---Choose---</option>
							<c:forEach var="propertyinfo" items="${PROPERTYINFO}">
								<option value="${propertyinfo.id}">${propertyinfo.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Price is required">
						<span class="label-input100">Price</span> <input class="input100"
							type="number" name="price" placeholder="Type price">
					</div>
					<div class="validate-input"
						data-validate="Bhk is required">
						<span class="label-input100">BHK</span> <select name="bhk" class="wrap-input100">
							<option value="0">---Choose---</option>
							<option value="1">1 BHK</option>
							<option value="2">2 BHK</option>
							<option value="3">3 BHK</option>
							<option value="4">4 BHK</option>
						</select>
					</div>
					<div class="validate-input"
						data-validate="City is required">
						<span class="label-input100">City</span> <select name="city"
							id="city" class="wrap-input100">
							<option value="0">---Choose---</option>
							<c:forEach var="cityinfo" items="${CITY}">
								<option value="${cityinfo.id}">${cityinfo.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="validate-input"
						data-validate="Locality is required">
						<span class="label-input100">Locality</span><select
							name="locality" id="locality" class="wrap-input100">
							<option value="0">---Choose---</option>
						</select>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Building name is required">
						<span class="label-input100">Building Name</span> <input
							class="input100" type="text" name="buildingname"
							placeholder="Type buildingname">
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Land size is required">
						<span class="label-input100">Land Size</span> <input
							class="input100" type="number" name="landsize"
							placeholder="Type land size">
					</div>
					<div class="validate-input"
						data-validate="Transaction type is required">
						<span class="label-input100">Transaction Type</span> <select
							name="transactiontype" class="wrap-input100">
							<option value="0">---Choose---</option>
							<option value="New">New</option>
							<option value="Resale">Re sale</option>
						</select>
					</div>
					<div class="validate-input"
						data-validate="Purchase type is required">
						<span class="label-input100">Purchase Type</span><select
							name="purchasetype" class="wrap-input100">
							<option value="0">---Choose---</option>
							<option value="Rent">Rent</option>
							<option value="Sale">Sale</option>
						</select>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Discount is required">
						<span class="label-input100">Discount</span> <input
							class="input100" type="number" name="discount"
							placeholder="Type Discount">
					</div>
					<div class="validate-input"
						data-validate="Status is required">
						<span class="label-input100">Status</span><select name="status" class="wrap-input100">
							<option value="0">---Choose---</option>
							<option value="Ready to Move">Ready to Move</option>
							<option value="Under Construction">Under Construction</option>
						</select>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Description is required">
						<span class="label-input100">Description</span>
						<textarea class="input100" rows="4" cols="33" name="description"
							placeholder="Type Description"></textarea>
					</div>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Register Land</button>
						</div>
					</div>
					<div>${MESSAGE}</div>
					<div class="validate-input">
						<a href="ServletHome">Back</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	 
</body>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
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
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/animsition/js/animsition.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<script src="vendor/countdowntime/countdowntime.js"></script>
<script src="js/main.js"></script>
</html>