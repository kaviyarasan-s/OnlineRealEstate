<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register land details</title>
<style>
.wrap-login100 {
	width: 55%;
}
</style>
</head>
<body>
	<div class="row" style="margin-left: 1%">
		<form method="post" action="ServletPostLand" id="landetails">
			<div style="margin-bottom:10%">
				<h4 style="text-align:center">Sale Land</h4>
			</div>
			
			<div class="column">
				<div>
					<span>Property Type</span> <span><select name="propertytype"
						id="propertytype">
							<option value="0">---Choose---</option>
							<c:forEach var="propertyinfo" items="${PROPERTYINFO}">
								<option value="${propertyinfo.id}">${propertyinfo.name}</option>
							</c:forEach>
					</select></span> <span id="propertytypechkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>
					<span>Price</span> <span><input type="number" name="price"
						id="price"></span> <span id="pricechkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>
					<span>BHK</span> <span><select name="bhk" id="bhk">
							<option value="0">---Choose---</option>
							<option value="1">1 BHK</option>
							<option value="2">2 BHK</option>
							<option value="3">3 BHK</option>
							<option value="4">4 BHK</option>
					</select></span> <span id="bhkchkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>

				<div>
					<span>City</span> <span><select name="city" id="city">
							<option value="0">---Choose---</option>
							<c:forEach var="cityinfo" items="${CITY}">
								<option value="${cityinfo.id}">${cityinfo.name}</option>
							</c:forEach>
					</select></span> <span id="citychkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>
					<span>Locality</span> <span><select name="locality"
						id="locality">
							<option value="0">---Choose---</option>
					</select></span> <span id="localitychkerr" style="color: red"></span>
				</div>

				<span>&nbsp;</span>
				<div>
					<span>Building Name</span> <span><input type="text"
						name="buildingname" style="outline: 1px solid #808080c9;"
						id="buildingname"
						onkeypress="return ((event.keyCode>64&&event.keyCode<91)||(event.keyCode==32)||(event.keyCode>96&&event.keyCode<123))"></span>
					<span id="buildingnamechkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>
					<span>Land Size</span> <span><input type="number"
						name="landsize" id="landsize"><span> sq.ft</span></span> <span></span>
					<span id="landsizechkerr" style="color: red"></span>
				</div>
			</div>
			<div class="column">
				<div>
					<span>Transaction Type</span> <span><select
						name="transactiontype" id="transactiontype">
							<option value="0">---Choose---</option>
							<option value="New">New</option>
							<option value="Resale">Re sale</option>
					</select></span> <span id="transactiontypechkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>
					<span>Purchase Type</span> <span><select name="purchasetype"
						id="purchasetype">
							<option value="0">---Choose---</option>
							<option value="Rent">Rent</option>
							<option value="Sale">Sale</option>
					</select> </span> <span id="purchasetypechkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>
					<span>Discount</span> <span><input type="number"
						name="discount" id="discount"><span> %</span> <span
						id="discountchkerr" style="color: red"></span>
				</div>
				<span>&nbsp;</span>
				<div>

					<span>Status</span> <span><select name="status" id="status">
							<option value="0">---Choose---</option>
							<option value="Ready to Move">Ready to Move</option>
							<option value="Under Construction">Under Construction</option>
					</select> </span> <span id="statuschkerr" style="color: red"></span>

				</div>
				<span>&nbsp;</span>
				<div>
					<span>Description</span> <span><textarea rows="4" cols="33"
							name="description"></textarea> </span>
				</div>

				<span>&nbsp;</span>
				<div>
					<button class="btn btn-info" type="submit" name="Enter"
						style="width: 30%">Submit</button>
				</div>
				<div><span>${MESSAGE}</span></div>
			</div>
		</form>
		
	</div>
</body>
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
																	$('#locality')
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
<script src="javascript/land.js"></script>
</html>
