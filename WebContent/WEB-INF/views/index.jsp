<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supports System</title>
<link href="resources/bower_components/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="resources/nutansapp/base.css" rel="stylesheet">
<link rel="shortcut icon" href="resources/nutansapp/Nutans.ico">
</head>
<body>
	<nav class="navbar navbar-default  navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a style="font-size: 17px;color:#ff0000"> <img
				src="resources/nutansapp/nutansrplus.png" width=40 height=40>&nbsp;&nbsp;Supports
				System
			</a>
		</div>
	</div>
	</nav>
	<div style="margin-top: 40px">&nbsp;</div>
	<div class="container">
		<div style="margin-top: 100px">&nbsp;</div>
		<hr>
		<div class="row">
			<div class="col-sm-4">&nbsp;</div>
			<div class="col-sm-4">
				<form method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							placeholder="Username" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							placeholder="Password" />
					</div>
					<div class="form-group">
						<input type="button" value="Login" onclick="validate();"/>
						<div style="text-align: right; float: right; padding-top: 10px;">
							<a style="cursor: pointer;" data-toggle="modal" 
								data-target="#myModal"> Forget Password?</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<hr>
	</div>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Supports System</h4>
				</div>
				<div class="modal-body">
					<input type="email" class="form-control" id="inputEmail"
						placeholder="Email Address">
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-info" value="Reset Password" onclick="resetPassword();">
				</div>
			</div>

		</div>
	</div>
	<script src="resources/bower_components/bootstrap/jquery-1.12.4.js"></script>
	<script src="resources/bower_components/bootstrap/bootstrap.min.js"></script>
	<script src="resources/bower_components/bootstrap/notify.js"></script>
	<script src="resources/nutansapp/common.js"></script>
	<script type="text/javascript">
		function validate()
		{
			$.ajax({
		        type: 'POST',
		        contentType: 'application/json',
		        url: URL + "validate",
		        dataType: "json",
		        data: formToJSON(),
		        success: function(data, textStatus, jqXHR){
		        	localStorage.setItem("user", JSON.stringify(data));
		        	console.log(data);
		        	location.href=data.roleMaster.roleDesc;
		        },
		        error: function(jqXHR, textStatus, errorThrown){
		        	$.notify(jqXHR.responseText, "error");
		        	//alert(jqXHR.responseText);
		        }
		    });
		}
		
		function resetPassword()
		{
			var emailId= $('#inputEmail').val();
			if(emailId==null || emailId=='' || emailId.length==0)
				$.notify("Email should not be empty!!!", "error");
			else
			{
				$.ajax({
			        type: 'POST',
			        contentType: 'application/json',
			        url: URL + "validate",
			        dataType: "json",
			        data: formToJSON(),
			        success: function(data, textStatus, jqXHR){
			        	$.notify("Your password has been reset successfully","success");
			            //location.href="login";
			        },
			        error: function(jqXHR, textStatus, errorThrown){
			        	$.notify(jqXHR.responseText, "error");
			        }
			    });
			}
		}
		function formToJSON() {
		    return JSON.stringify({
		        "userName": $('#userName').val(),
		        "password": $('#password').val()
		        });
		}
	</script>

</body>
</html>