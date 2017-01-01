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
    <link rel="icon" type="image/png" href="images/snail.png">
  </head>
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
 		   <a class="navbar-brand" class="logout" color="white" href="/schedule"> <font color="white"> Schedule</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogIn</font></a>
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
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
