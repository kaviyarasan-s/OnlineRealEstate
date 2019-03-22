<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change new password</title>
</head>
<body style="background-image: url('images/bg-01.jpg');">
	<div class="container">
		<div class="row">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="text-center">
								<h3>
									<i class="fa fa-lock fa-4x"></i>
								</h3>
								<h2 class="text-center">Change password</h2>
								<div class="panel-body">
									<form class="form" method="post" action="ChangePassword">
										<fieldset>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-lock color-blue"></i></span> <input
														id="emailInput" placeholder="Enter new password"
														class="form-control" type="text" name="newpassword"
														oninvalid="setCustomValidity('Please enter a valid password!')"
														onchange="try{setCustomValidity('')}catch(e){}"
														required="">
												</div>
											</div>
											<div class="form-group">
												<input class="btn btn-lg btn-primary btn-block"
													value="change" name="button" type="submit">
											</div>
											<div>
												<a href="forgotpassword.jsp">Back</a>
											</div>
											<div>
												<%
													if (request.getAttribute("MESSAGE") != null) {
														out.print(request.getAttribute("MESSAGE"));
													}
												%>
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="col-md-12">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form method="post" action="ChangePassword">
				<div>
					New password:<input type="text" name="newpassword" required class="form-control" style="width:50%">
				</div>
				<div style="margin-top:1%">
					<button type="submit" name="button" value="change" class="btn btn-info">Change</button>
				</div>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div> -->
</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>