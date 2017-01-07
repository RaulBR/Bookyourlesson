[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
  	
    <title>bydl</title>
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
  <h1>Students</h1>
  [#if permision??]
 	<p><a href="/student"><input class="btn btn-info" role="button" value="ADD STUDENT" type="submit"  readonly></a>
 	<a href="/student/list"><input class="btn btn-info" role="button" value="LIST ALL STUDENTS" type="submit"  readonly></a></p>
 	[/#if]
 <table class="table">
  <thead>
     <tr >
  
  
    <th>Number</th>
    <th>Name</th>
    <th>Sirname</th>
    <th>Category</th>
    <th>Papers</th>
    <th>Register Date</th>
   	[#if permision??]
   	<th>Email</th>
   	<th>CNP</th>
   	<th></th>
   	<th>Edit</th>
   	<th>Delete</th>
   	[/#if]
	 	  	 [#assign nr = 0]
	  		[#if students??]
	  		[#list students as student]
	  			 [#assign nr = nr +1 ]	
	  		  <tr>		
	  				<td > ${nr}   </td>		
	  		<td >${student.name}   </td>
	  		<td >${student.sirName} </td>
	  		<td >${student.category}  </td>		
	  		<td> ${student.medPaper?c}</td>
	<td>  	${student.registrationDate}</td>
	
	  		[#if permision??]
	  		<td >	 ${student.email} </td>
	  		<td >	 ${student.cnp} </td>
	  		<td >
	  			 <form name="form1" action="/statistics/student" method="POST">
	  				 <input type="hidden" name="studentId" value="${student.id}">
	  			<button  type="submit" class="btn btn-info" value="${student.id}">Situation</button>
	  		</form>
	  		</td>
	  		<td >
	  			 <form name="form1" action="/student/edit" method="POST">
	  				 <input type="hidden" name="id" value="${student.id}">
	  			<button  type="submit" class="btn btn-info" value="${student.id}">EDIT</button>
	  		</form>
	  		</td>
	  		<td >
	  		 <form name="form1" action="/student/delete" method="POST">
	  				 <input type="hidden" name="id" value="${student.id}">
	  				 	<button  type="submit" class="btn btn-info" value="${student.id}">DEL</button>
	  		</form>
	  			</td>
	  			[/#if]
	  		
	  			[/#list]
	  			[/#if]
	  			 </tr>
 
  
  </tbody>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
 
    
    
  </body>
</html>
[/#escape]
