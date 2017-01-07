[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">

  <head>
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
  	
    <title>bydl</title>
	<link rel="icon" type="image/png" href="/images/negru.png">
    
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
	<link href="/js/sch.js" rel="sch">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <base href="" />
  </head>
  
  
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/schedule"> <font color="white">Home</font></a>
 		  <a class="navbar-brand" class="logout" color="white" href="/student/list"> <font color="white"> Students</font></a>
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
