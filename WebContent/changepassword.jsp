<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change new password</title>
</head>
<body>
	<div class="col-md-12">
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
	</div>
</body>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/bootstrap.min.js"></script>
<script src="javascript/jquery.min.js"></script>
</html>