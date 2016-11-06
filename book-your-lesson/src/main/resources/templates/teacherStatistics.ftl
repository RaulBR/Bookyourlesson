[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
  <head>
   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link href="/css/style.css" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    	<script type="text/javascript" src="./dist/Chart.bundle.js"></script>
  
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="/dist/Chart.bundle.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <style>
    #canvas-holder {
        width: 100%;
        margin-top: 50px;
        text-align: center;
    }
    #chartjs-tooltip {
      opacity: 1;
      position: absolute;
      background: rgba(0, 0, 0, .7);
      color: white;
      border-radius: 3px;
      -webkit-transition: all .1s ease;
      transition: all .1s ease;
      pointer-events: none;
      -webkit-transform: translate(-50%, 0);
      transform: translate(-50%, 0);
    }

    .chartjs-tooltip-key {
      display: inline-block;
      width: 10px;
      height: 10px;
    }
    </style>
  </head>
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacherList"> <font color="white"> Instructors</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogOut</font></a>
  		</div>
  	</div>
	</nav>
 <h1>Teachers </h1>
 
 <h2>Week:[#if week??]${week}[/#if]</h2>
 
 [#if teacherSchedules??]
 [#list  teacherSchedules as key]
 
 
 <ng ng-app="test">
<div class="container" ng-controller="Ctrl">

  <h2>${key.t.name} ${key.t.sirName}</h2>
  
  
  <hr>
  </th>
  <div class="row">
   
    <div class="progress vertical" >
    
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.total}%">
    ${key.total}
  </div>
</div>

 <div class="progress " >
    
  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.done}%">
    ${key.done}
  </div>
</div>

 <div class="progress" >
    
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.booked}%">
    ${key.booked}
  </div>
</div>
<div class="progress" >
    
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.pending}%">
    ${key.pending}
  </div>
</div>

 <div class="progress" >
    
  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax=${key.total}" style="width:${key.absent}%">
    ${key.absent}
  </div>
</div>
    
  
  </div>
  
  
</div>
</ng>  
 [/#list]
 [/#if]
 [#if teacherSchedules??]
 [#list  teacherSchedules as key]
<p>
   <div id="canvas-holder" style="width:50%">
        <canvas id="chart-area" />
    </div>
   
    <script>
  
    var randomColor = function(opacity) {
        return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
    };

    var config = {
        type: 'doughnut',
        data: {
            datasets: [{
                data: [
                
                    ${key.done},
                    ${key.absent},
                    ${key.pending},
                    ${key.booked},
                    ${key.done},
                ],
                backgroundColor: [
                    "#F7464A",
                    "#46BFBD",
                    "#FDB45C",
                    "#949FB1",
                    "#4D5360",
                ],
                label: 'Dataset 1'
            },],
            labels: [
                "Done",
                "Absent",
                "Pending",
                "Booked",
                "NotFree"
            ]
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: ' ${key.t.name} ${key.t.sirName}'
            },
            animation: {
                animateScale: true,
                animateRotate: true
            }
        }
    };

    window.onload = function() {
        var ctx = document.getElementById("chart-area").getContext("2d");
        window.myDoughnut = new Chart(ctx, config);
    };

    $('#randomizeData').click(function() {
        $.each(config.data.datasets, function(i, dataset) {
            dataset.data = dataset.data.map(function() {
                return randomScalingFactor();
            });

            dataset.backgroundColor = dataset.backgroundColor.map(function() {
                return randomColor(0.7);
            });
        });

        window.myDoughnut.update();
    });

    $('#addDataset').click(function() {
        var newDataset = {
            backgroundColor: [],
            data: [],
            label: 'New dataset ' + config.data.datasets.length,
        };

        for (var index = 0; index < config.data.labels.length; ++index) {
            newDataset.data.push(randomScalingFactor());
            newDataset.backgroundColor.push(randomColor(0.7));
        }

        config.data.datasets.push(newDataset);
        window.myDoughnut.update();
    });

    $('#addData').click(function() {
        if (config.data.datasets.length > 0) {
            config.data.labels.push('data #' + config.data.labels.length);	

            $.each(config.data.datasets, function(index, dataset) {
                dataset.data.push(randomScalingFactor());
                dataset.backgroundColor.push(randomColor(0.7));
            });

            window.myDoughnut.update();
        }
    });

    $('#removeDataset').click(function() {
        config.data.datasets.splice(0, 1);
        window.myDoughnut.update();
    });

    $('#removeData').click(function() {
        config.data.labels.splice(-1, 1); // remove the label first

        config.data.datasets.forEach(function(dataset, datasetIndex) {
            dataset.data.pop();
            dataset.backgroundColor.pop();
        });

        window.myDoughnut.update();
    });
    </script>
    </p>
[/#list]
 [/#if]

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
