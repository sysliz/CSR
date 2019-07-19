<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Support Team -Fault</title>
<link href="resources/bower_components/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/bower_components/bootstrap/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="resources/nutansapp/base.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="resources/nutansapp/Nutans.ico">
</head>
<body>
	<nav class="navbar navbar-inverse  navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"
				style="background-image: url(resources/nutansapp/nutansrplus.png); background-repeat: no-repeat; background-size: 40px auto; padding-left: 50px;">&nbsp;Supports
				System&nbsp;&nbsp;</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="dashboard">Dashboard<span
						class="sr-only">(current)</span></a></li>
				<li class=""><a href="faults">Device Faults</a></li>
				<li class=""><a href="messages">Customer Update</a></li>
				<li class=""><a href="servermonitor">Server Monitor</a></li>
			</ul>
			<!-- <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> <span class="glyphicon glyphicon-user"></span>
						<span id="userName"></span><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div style="padding-top: 30px;"></div>
	<hr>
	<div class="container-fluid">
		<br>
		<div class="panel-group" ng-show="employeeViewModel.showEmployeeList">
			<div id="collapse1" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="x_content" class="collapse" id="View">
						<div class="row">
							<br>
							<table id="tblFaultData"
								class="table table-striped table-bordered" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<th>Customer Name</th>
										<th>Faults</th>
										<th>Faults Date</th>
										<th>Resolved</th>
										<!-- <th>Resolved Date</th> -->
										<th>Resolved By</th>
										<th>Status</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="resources/bower_components/bootstrap/jquery-1.12.4.js"></script>
	<script src="resources/bower_components/bootstrap/bootstrap.min.js"></script>
	<script	src="resources/bower_components/bootstrap/jquery.dataTables.min.js"></script>
	<script src="resources/bower_components/bootstrap/dataTables.bootstrap.min.js"></script>
	<script src="resources/bower_components/bootstrap/notify.js"></script>
	<script src="resources/nutansapp/common.js"></script>
	<script type="text/javascript">
		load();
		function load() {
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : URL + "fault/get",
				dataType : "json",
				data : formToJSON(),
				success : function(data, textStatus, jqXHR) {
					console.log(data);
					console.log(textStatus);
					console.log(jqXHR);
					$('#tblFaultData').DataTable({
						"columns" : [ {
							"data" : "customer.firstName"
						}, {
							"data" : "faultType.faultTypeName"
						}, {
							"data" : "faultCreatedOn",
							render : function(data, type, row) {
								return convertMsToDate(data);
							}
						}, {
							"data" : "resolveType.resolveTypeName"
						}/* , {
							"data" : "resolvedOn",
							render : function(data, type, row) {
								return convertMsToDate(data);
							}
						} */, {
							"data" : "resolvedByUser.firstName"
						},{
							"data" : "faultStatus",
							render : function(data, type, row) {
								var NoIssue="No Issue";
								if(data==="Pending")
									return "<button onclick='updateStatus(\"Resolved\"," + row.customerRequestId + ");' type='button' class='btn btn-success btn-xs'>Resolved</button>&nbsp;<button onclick='updateStatus(\"Replacement\"," + row.customerRequestId + ");' type='button' class='btn btn-danger btn-xs'  data-toggle='modal' data-target='#myModal'>Replacement</button>";
								return "<button type='button' class='btn btn-info btn-xs'  data-toggle='modal' data-target='#myModal'>" + data + "</button>";
							}
						}
						],
						"data" : data

					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.notify(jqXHR.responseText, "error");
				}
			});
		}
		function formToJSON() {
			return JSON.stringify({
				"customerId" : 1,
			});
		}
		function convertMsToDate(msec) {
			var date = new Date(msec);
			return date.toString("dd-MM-yyyy HH:mm:ss");
		}
	</script>
	<script type="text/javascript">
	var userdata=JSON.parse(localStorage.getItem("user"));
	$("#userName").text(userdata.firstName + ", " + userdata.lastName);
	</script>
		
</body>
</html>