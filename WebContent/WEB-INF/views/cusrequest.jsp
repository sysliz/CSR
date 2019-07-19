<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Support Team -Customer Request</title>
<link href="resources/bower_components/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<<link
	href="resources/bower_components/bootstrap/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link href="resources/nutansapp/base.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/bower_components/bootstrap/jquery-ui.css">
	
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
				<li class="active"><a href="cusrequest">Customer Request</a></li>
				<li class=""><a href="customer">Customer</a></li>
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
  </div><!-- /.container-fluid -->
</nav>
<div style="padding-top:30px;"></div><hr>
<div class="container-fluid">
	<button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#myModal">Add New Request</button>
	<br>
	<div class="panel-group" ng-show="employeeViewModel.showEmployeeList">
			<div id="collapse1" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="x_content" class="collapse" id="View">
						<div class="row">
							<br>
							<table id="tblRequestData"
								class="table table-striped table-bordered" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<th>Customer Name</th>
										<th>Email</th>
										<th>Contact</th>
										<th>Request</th>
										<th>Description</th>
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
	<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add New Request</h4>
        </div>
        <div class="modal-body">
       		 <div class="modal-body">
       		 	<form class="form-horizontal">
					<div class="form-group">
						<div class="row">
						<div class="col-md-12">
								<label class="col-sm-4 control-label">Customer Name</label>
								  <div class="col-sm-8">
									<select class="form-control" id="sCustomerName">
											<option value="0">Choose</option>
										</select>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
						<div class="col-md-12">
								<label class="col-sm-4 control-label">Request Title</label>
								  <div class="col-sm-8">
									<select class="form-control" id="requestTitle">
										<option>Device is not working</option>
										<option>Application is not working</option>
										<option>Rs-232-Cable is not working</option>
										<option>Watches is not working</option>
										<option>Signal is not working</option>
										<option>432 Collector is not working</option>
										<option>Others</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
						<div class="col-md-12">
								<label class="col-sm-4 control-label">Request Description</label>
								  <div class="col-sm-8">
									<textarea class="form-control" rows="5" id="requestDesc"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
						<div class="col-md-12">
								<label class="col-sm-4 control-label">Status</label>
								  <div class="col-sm-8">
									<input class="form-control" disabled id="status" type="text" value="Pending">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	<input type="button" class="btn btn-info" value="Create" onclick="create();">
        </div>
      </div>
      
    </div>
  </div>
	<script src="resources/bower_components/bootstrap/jquery-1.12.4.js"></script>
	<script src="resources/bower_components/bootstrap/jquery-ui.js"></script>
	
	<script src="resources/bower_components/bootstrap/bootstrap.min.js"></script>
	<script	src="resources/bower_components/bootstrap/jquery.dataTables.min.js"></script>
	<script src="resources/bower_components/bootstrap/dataTables.bootstrap.min.js"></script>
	<script src="resources/bower_components/bootstrap/notify.js"></script>
	<script src="resources/nutansapp/common.js"></script>
	<script type="text/javascript">
	var userdata=JSON.parse(localStorage.getItem("user"));
	$("#userName").text(userdata.firstName + ", " + userdata.lastName);
	loadDatay();
		function loadDatay()
		{
			var customerId=getUrlParameter('customerId'); 
			console.log(customerId);
			if(customerId===null || customerId===undefined)
			{
				customerLoad(0);
				load();
			}
			else
			{
				console.log(customerId);
				customerLoad(customerId);
				loadById(customerId);
			}
		}
		function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;

		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};
		function create()
		{
			$.ajax({
				type : 'POST',
					contentType : 'application/json',
				url : URL + "cusrequest/add",
				dataType : "json",
				data : formToJSON(),
				success : function(data, textStatus, jqXHR) {
					$('#myModal').modal('hide');
					loadData(data);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.notify(jqXHR.responseText, "error");
				}
			});
			
		}	
		function load() {
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : URL + "cusrequest/get",
				dataType : "json",
				success : function(data, textStatus, jqXHR) {
					loadData(data);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.notify(jqXHR.responseText, "error");
				}
			});
		}
		
		function loadById(id) {
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : URL + "cusrequest/get/" + id,
				dataType : "json",
				success : function(data, textStatus, jqXHR) {
					loadData(data);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.notify(jqXHR.responseText, "error");
				}
			});
		}
		function loadData(data)
		{
			$('#tblRequestData').DataTable().destroy();
			$('#tblRequestData').DataTable({
				"columns" : [ {
					"data" : "customer.firstName"
				}, {
					"data" : "customer.email"
				}, {
					"data" : "customer.contact"
				}, {
					"data" : "customerRequestTitle"
				}, {
					"data" : "customerRequestDesc"
				},{
					"data" : "status"
				} ],
				"data" : data

			});
			
		}
		function formToJSON() {
			return JSON.stringify({
				customer :{customerId : $("#sCustomerName").val()},
				customerRequestTitle : $("#requestTitle").val(),
				customerRequestDesc : $("#requestDesc").val(),
				status : $("#status").val()
			});
		}
		function convertMsToDate(msec) {
			var date = new Date(msec);
			return date.toString("dd-MM-yyyy HH:mm:ss");
		}
		
		function loadCustomerData(data,id) {
			var $select = $('#sCustomerName');
			$select.find('option').remove();
			var customerId=parseInt(id);
			if(customerId===0)
			{
				$select.append('<option value="0">Choose</option>');
				if (data) {
					$.each(data, function(key) {
						var customer = data[key];
						$select.append('<option value="' + customer.customerId + '">'
								+ customer.firstName + '</option>');
					});
				}
			}
			else
			{
				if (data) {
					$.each(data, function(key) {
						var customer = data[key];
						if(customer.customerId===customerId)
						{
							$select.append('<option value="' + customer.customerId + '">'
								+ customer.firstName + '</option>');
						}
					});
				}	
			}
			
		}
		
		function customerLoad(Id) {
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : URL + "customer/get",
				dataType : "json",
				success : function(data, textStatus, jqXHR) {
					loadCustomerData(data,Id);
				}
			});
		}
	</script>
</body>
</html>