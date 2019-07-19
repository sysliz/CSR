<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Support Team -Dashboard</title>
<link href="resources/bower_components/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<link
	href="resources/bower_components/bootstrap/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link href="resources/nutansapp/base.css" rel="stylesheet">
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
		<div class="panel panel-info">
			<div class="panel-heading">
				<span class="glyphicon glyphicon glyphicon-tasks"></span>&nbsp;Overview
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="glyphicon glyphicon-th"></span>&nbsp;Total Customer
								Request
							</div>
							<div class="panel-body">
							<div>
									<div id="totalCustomerOrder"></div>
								</div>
								<a href="messages"><span
									style="font-size: 30px; font-weight: bold;"
									id="totalCustomerReqCount">0</span>&nbsp;click here</a>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="glyphicon glyphicon-user"></span>&nbsp;Pending
								Customer Request
							</div>
							<div class="panel-body">
							<div>
									<div id="totalJobCardGenerated"></div>
								</div>
								<a href="messages"><span
									style="font-size: 30px; font-weight: bold;" id="pendingCount">0</span>&nbsp;click
									here </a>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="glyphicon glyphicon-hdd"></span>&nbsp;Total Device
								Faults Request
							</div>
							<div class="panel-body">
							<div>
									<div id="totalPending"></div>
								</div>
								<a href="faults"><span
									style="font-size: 30px; font-weight: bold;"
									id="totalDeviceFaultCount">0</span>&nbsp;click here </a>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="glyphicon glyphicon-repeat"></span>&nbsp;Pending
								Device faults
							</div>
							<div class="panel-body">
							<div>
									<div id="totalCancelled"></div>
								</div>
								<a href="faults"><span
									style="font-size: 30px; font-weight: bold;"
									id="pendingDeviceFault">0</span>&nbsp;click here </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			
	<script src="resources/bower_components/bootstrap/jquery-1.12.4.js"></script>
	<script src="resources/bower_components/bootstrap/bootstrap.min.js"></script>
	<script
		src="resources/bower_components/bootstrap/jquery.dataTables.min.js"></script>
	<script
		src="resources/bower_components/bootstrap/dataTables.bootstrap.min.js"></script>
	<script src="resources/nutansapp/common.js"></script>
	<script src="resources/charts/highcharts.js"></script>
	<script src="resources/charts/highcharts-more.js"></script>
	<script src="resources/charts/solid-gauge.js"></script>
	<script src="resources/bower_components/bootstrap/notify.js"></script>

	<script type="text/javascript">
		var userdata = JSON.parse(localStorage.getItem("user"));
		$("#userName").text(userdata.firstName + ", " + userdata.lastName);
		load();
		function load() {
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : URL + 'dashboard/get',
				dataType : "json",
				success : function(data, textStatus, jqXHR) {
					console.log(data);
					$('#totalDeviceFaultCount')
							.text(data.totalDeviceFaultCount);
					$('#pendingCount').text(data.pendingCount);
					$('#pendingDeviceFault').text(data.pendingDeviceFault);
					$('#totalCustomerReqCount')
							.text(data.totalCustomerReqCount);
					loadCircle("#totalCustomerOrder",data.totalCustomerReqCount,[data.totalCustomerReqCount],'#F62366');
					loadCircle("#totalJobCardGenerated",data.totalCustomerReqCount,[data.pendingCount],"#9DFF02");
					loadCircle("#totalPending",data.totalDeviceFaultCount,[data.totalDeviceFaultCount],"#0CCDD6");
					loadCircle("#totalCancelled",data.totalDeviceFaultCount,[data.pendingDeviceFault],"#ff0000");

				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.notify(jqXHR.responseText, "error");
				}
			});
		}
		
		loadCircle("#totalCustomerOrder",50,[50],'#F62366');
		loadCircle("#totalJobCardGenerated",50,[25],"#9DFF02");
		loadCircle("#totalPending",50,[20],"#0CCDD6");
		loadCircle("#totalCancelled",50,[5],"#ff0000");

		function loadCircle(id,max,data,color) {
		    var gaugeOptions = {
		        'chart': {
		            'type': 'solidgauge'
		        },
		        'colors': [color],
		        'title': null,

		        'tooltip': {
		            'enabled': true
		        },
		        
		        'pane': {
		          'center': ['50%', '50%'],
		          'size': '150px',
		          'startAngle': 0,
		          'endAngle': 360,
		          'background': {
		            'backgroundColor': '#EEE',
		            'innerRadius': '85%',
		            'outerRadius': '100%',
		            'borderWidth': 0
		          }
		        },

		        'yAxis': {
		          'min': 0,
		          'max': max,
		          'labels': {
		            'enabled': true,
		            'style': {
		                'fontSize': '15px'
		            }
		          },
		          'lineWidth': 0,
		          'minorTickInterval': null,
		          'tickPixelInterval': 400,
		          'tickWidth': 0
		        },

		        'plotOptions': {
		            'solidgauge': {
		                'innerRadius': '85%',
		                'backgroundColor': '#FF0000'
		            }
		        },
		        
		        'series': [{
		            'name': 'Orders',
		            'data': data,
		            'dataLabels': {
		                'enabled': true,
		                'style': {
		                    'fontSize': '25px'
		                }
		            }
		        }]
		    };
		    $(id).highcharts(gaugeOptions);
		}
	</script>

</body>
</html>