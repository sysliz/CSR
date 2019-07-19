<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Support Team -Dashboard</title>
<link href="resources/bower_components/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<<link
	href="resources/bower_components/bootstrap/dataTables.bootstrap.min.css"
	rel="stylesheet">
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
		<div class="panel panel-info">
			<div class="panel-heading">
				<span class="glyphicon glyphicon glyphicon-tasks"></span>&nbsp;Live Streaming
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-4">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="glyphicon glyphicon-th"></span>&nbsp;Device Fault
							</div>
							<div class="panel-body">
								<div id="container"
									style="min-width: 310px; height: 400px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
					<div class="col-md-8">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="glyphicon glyphicon-hdd"></span>&nbsp;Web Server
							</div>
							<div class="panel-body">
								<div id="map" style="height: 400px; width: 800px;">
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script src="resources/bower_components/bootstrap/jquery-1.12.4.js"></script>
	<script src="resources/bower_components/bootstrap/bootstrap.min.js"></script>
	<script src="resources/bower_components/bootstrap/jquery.dataTables.min.js"></script>
	<script	src="resources/bower_components/bootstrap/dataTables.bootstrap.min.js"></script>
	<script src="resources/charts/highcharts.js"></script>
	<script src="resources/charts/exporting.js"></script>
	<script src="resources/charts/highcharts-more.js"></script>
	<script src="resources/charts/solid-gauge.js"></script>

	<script type="text/javascript">

Highcharts.setOptions({
    global: {
        useUTC: false
    }
});

Highcharts.chart('container', {
    chart: {
        type: 'spline',
        animation: Highcharts.svg, // don't animate in old IE
        marginRight: 10,
        events: {
            load: function () {

                // set up the updating of the chart each second
                var series = this.series[0];
                setInterval(function () {
                    var x = (new Date()).getTime(), // current time
                        y = Math.random();
                    series.addPoint([x, y], true, true);
                }, 1000);
            }
        }
    },
    title: {
        text: 'Server Data'
    },
    xAxis: {
        type: 'datetime',
        tickPixelInterval: 150
    },
    yAxis: {
        title: {
            text: 'Value'
        },
        plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
        }]
    },
    tooltip: {
        formatter: function () {
            return '<b>' + this.series.name + '</b><br/>' +
                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                Highcharts.numberFormat(this.y, 2);
        }
    },
    legend: {
        enabled: false
    },
    exporting: {
        enabled: false
    },
    series: [{
        name: 'Random data',
        data: (function () {
            // generate an array of random data
            var data = [],
                time = (new Date()).getTime(),
                i;

            for (i = -19; i <= 0; i += 1) {
                data.push({
                    x: time + i * 1000,
                    y: Math.random()
                });
            }
            return data;
        }())
    }]
});
		</script>

	<script type="text/javascript">


var gaugeOptions = {

    chart: {
        type: 'solidgauge'
    },

    title: null,

    pane: {
        center: ['50%', '85%'],
        size: '140%',
        startAngle: -90,
        endAngle: 90,
        background: {
            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
            innerRadius: '60%',
            outerRadius: '100%',
            shape: 'arc'
        }
    },

    tooltip: {
        enabled: false
    },

    // the value axis
    yAxis: {
        stops: [
            [0.1, '#55BF3B'], // green
            [0.5, '#DDDF0D'], // yellow
            [0.9, '#DF5353'] // red
        ],
        lineWidth: 0,
        minorTickInterval: null,
        tickAmount: 2,
        title: {
            y: -70
        },
        labels: {
            y: 16
        }
    },

    plotOptions: {
        solidgauge: {
            dataLabels: {
                y: 5,
                borderWidth: 0,
                useHTML: true
            }
        }
    }
};

// The speed gauge
var chartSpeed = Highcharts.chart('container-speed', Highcharts.merge(gaugeOptions, {
    yAxis: {
        min: 0,
        max: 200,
        title: {
            text: 'Speed'
        }
    },

    credits: {
        enabled: false
    },

    series: [{
        name: 'Speed',
        data: [80],
        dataLabels: {
            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                   '<span style="font-size:12px;color:silver">km/h</span></div>'
        },
        tooltip: {
            valueSuffix: ' km/h'
        }
    }]

}));

// The RPM gauge
var chartRpm = Highcharts.chart('container-rpm', Highcharts.merge(gaugeOptions, {
    yAxis: {
        min: 0,
        max: 5,
        title: {
            text: 'RPM'
        }
    },

    series: [{
        name: 'RPM',
        data: [1],
        dataLabels: {
            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y:.1f}</span><br/>' +
                   '<span style="font-size:12px;color:silver">* 1000 / min</span></div>'
        },
        tooltip: {
            valueSuffix: ' revolutions/min'
        }
    }]

}));

// Bring life to the dials
setInterval(function () {
    // Speed
    var point,
        newVal,
        inc;

    if (chartSpeed) {
        point = chartSpeed.series[0].points[0];
        inc = Math.round((Math.random() - 0.5) * 100);
        newVal = point.y + inc;

        if (newVal < 0 || newVal > 200) {
            newVal = point.y - inc;
        }

        point.update(newVal);
    }

    // RPM
    if (chartRpm) {
        point = chartRpm.series[0].points[0];
        inc = Math.random() - 0.5;
        newVal = point.y + inc;

        if (newVal < 0 || newVal > 5) {
            newVal = point.y - inc;
        }

        point.update(newVal);
    }
}, 2000);

		</script>
	    <script>
	    function initMap() {
	        var map = new google.maps.Map(document.getElementById('map'), {
	          zoom: 10,
	          center: {lat: 11.103, lng: 79.6}
	        });

	        setMarkers(map);
	      }

	      // Data for the markers consisting of a name, a LatLng and a zIndex for the
	      // order in which these markers should display on top of each other.
	      var beaches = [
	        ['AVC College', 11.103449, 79.691043],
	        ['Mayiladuthurai', 11.10119, 79.64979]	      ];

	      function setMarkers(map) {
	        // Adds markers to the map.

	        // Marker sizes are expressed as a Size of X,Y where the origin of the image
	        // (0,0) is located in the top left of the image.

	        // Origins, anchor positions and coordinates of the marker increase in the X
	        // direction to the right and in the Y direction down.
	        var image = {
	          url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
	          // This marker is 20 pixels wide by 32 pixels high.
	          size: new google.maps.Size(20, 32),
	          // The origin for this image is (0, 0).
	          origin: new google.maps.Point(0, 0),
	          // The anchor for this image is the base of the flagpole at (0, 32).
	          anchor: new google.maps.Point(0, 32)
	        };
	        // Shapes define the clickable region of the icon. The type defines an HTML
	        // <area> element 'poly' which traces out a polygon as a series of X,Y points.
	        // The final coordinate closes the poly by connecting to the first coordinate.
	        var shape = {
	          coords: [1, 1, 1, 20, 18, 20, 18, 1],
	          type: 'poly'
	        };
	        for (var i = 0; i < beaches.length; i++) {
	          var beach = beaches[i];
	          var marker = new google.maps.Marker({
	            position: {lat: beach[1], lng: beach[2]},
	            map: map,
	            icon: image,
	            shape: shape,
	            title: beach[0],
	            zIndex: beach[3]
	          });
	        }
	      }
	    
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeLt4R8bfLZWaQBzUjEODhgokZsclWABs&callback=initMap">
    </script>
</body>
</html>