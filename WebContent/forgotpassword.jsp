<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgetPassword</title>
</head>
<body style="background-image: url('images/bg-01.jpg');">

	<div class="container" >
		<div class="row">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="text-center">
								<h3>
									<i class="fa fa-lock fa-4x"></i>
								</h3>
								<h2 class="text-center">Forgot Password?</h2>
								<p>You can reset your password here.</p>
								<div class="panel-body">

									<form class="form" method="post" action="ChangePassword">
										<fieldset>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-envelope color-blue"></i></span> <input
														id="emailInput" placeholder="email address"
														class="form-control" type="email" name="email"
														oninvalid="setCustomValidity('Please enter a valid email address!')"
														onchange="try{setCustomValidity('')}catch(e){}"
														required="">
												</div>
											</div>
											<div class="form-group">
												<input class="btn btn-lg btn-primary btn-block"
													value="reset" name="button" type="submit">
											</div>
											<div>
												<a href="login.jsp">Back</a>
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
</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>