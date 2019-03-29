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
	<form method="post" action="ServletPostLand" id="landetails">
		<h4>
			<center>Sale Land</center>
		</h4>
		<table border="0" align="center" width="615px" height="800px">
			<tr>
				<td>Property Type</td>
				<td><select name="propertytype" id="propertytype">
						<option value="0">---Choose---</option>
						<c:forEach var="propertyinfo" items="${PROPERTYINFO}">
							<option value="${propertyinfo.id}">${propertyinfo.name}</option>
						</c:forEach>
				</select></td>
				<td><div id="propertytypechkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="price" id="price"></td>
				<td><div id="pricechkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>BHK</td>
				<td><select name="bhk" id="bhk">
						<option value="0">---Choose---</option>
						<option value="1">1 BHK</option>
						<option value="2">2 BHK</option>
						<option value="3">3 BHK</option>
						<option value="4">4 BHK</option>
				</select></td>
				<td><div id="bhkchkerr" style="color: red"></div></td>
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
				<td><div id="citychkerr" style="color: red"></div></td>
				<td>Locality</td>
				<td><select name="locality" id="locality">
						<option value="0">---Choose---</option>
				</select></td>
				<td><div id="localitychkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Building Name</td>
				<td><input type="text" name="buildingname"
					style="outline: 1px solid #808080c9;" id="buildingname"
					onkeypress="return ((event.keyCode>64&&event.keyCode<91)||(event.keyCode==32)||(event.keyCode>96&&event.keyCode<123))"></td>
				<td><div id="buildingnamechkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Land Size</td>
				<td><input type="number" name="landsize" id="landsize"></td>
				<td><div id="landsizechkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Transaction Type</td>
				<td><select name="transactiontype" id="transactiontype">
						<option value="0">---Choose---</option>
						<option value="New">New</option>
						<option value="Resale">Re sale</option>
				</select></td>
				<td><div id="transactiontypechkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Purchase Type</td>
				<td><select name="purchasetype" id="purchasetype">
						<option value="0">---Choose---</option>
						<option value="Rent">Rent</option>
						<option value="Sale">Sale</option>
				</select></td>
				<td><div id="purchasetypechkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Discount</td>
				<td><input type="number" name="discount" id="discount"></td>
				<td><div id="discountchkerr" style="color: red"></div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Status</td>
				<td><select name="status" id="status">
						<option value="0">---Choose---</option>
						<option value="Ready to Move">Ready to Move</option>
						<option value="Under Construction">Under Construction</option>
				</select></td>
				<td><div id="statuschkerr" style="color: red"></div></td>
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
		<br />
		<button class="btn btn-info" type="submit" name="Enter"
			style="width: 15%">Submit</button>

		<center>${MESSAGE}</center>
	</form>
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
<script src="javascript/land.js"></script>
</html>
