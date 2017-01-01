[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">

  <head>
   <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>bydl</title>
		<!-- Optional theme -->
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
				<link href="/css/style.css" rel="stylesheet">
				
		<!-- Latest compiled and minified JavaScript -->
				<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    			<script type="text/javascript" src="./dist/Chart.bundle.js"></script>
  
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="/dist/Chart.bundle.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  	 <link rel="icon" type="image/png" href="images/snail.png">
  </head>
  
  
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogOut</font></a>
  		</div>
  	</div>
	</nav>
	 [#if teacherSchedules??]
 <h1>Teachers </h1>
 
 


 <h2>Week:[#if week??]${week}[/#if]</h2>
 [#list  teacherSchedules as key]
 
 
 <ng ng-app="test">
<div class="container" ng-controller="Ctrl">

  <h2><a href="/statistics/teacher?teacherId=${key.t.id}">${key.t.name} ${key.t.sirName}</a></h2>
  
  
  <hr>
  </th>
  <div class="row">
   [#if key.total>0]
   Total number
    <div class="progress vertical" >
    
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.total}%">
    ${key.total}
  </div>
</div>
[/#if]
 [#if key.done>0]
 Done 
 <div class="progress " >
    
  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.done}%">
    ${key.done}
  </div>
</div>
[/#if]
 [#if key.booked>0]
 Booked
 <div class="progress" >
    
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.booked}%">
    ${key.booked}
  </div>
</div>
[/#if]
 [#if key.pending>0]
 Pending
<div class="progress" >
    
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax="${key.total}" style="width:${key.pending}%">
    ${key.pending}
  </div>
</div>
[/#if]
 [#if key.absent>0]
 Students were absent
 <div class="progress" >
    
  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow=""
  aria-valuemin="0" aria-valuemax=${key.total}" style="width:${key.absent}%">
    ${key.absent}
  </div>
</div>
    [/#if]

  
  </div>
  
  
</div>
</ng>  
 [/#list]
 [/#if]
 
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
