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
    
  </head>
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
 		 
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogIn</font></a>
  		</div>
  	</div>
	</nav>
  <h1> Instructors</h1>
   [#if permision??]
 	<p><a href="/teacher"><input class="btn btn-info" role="button" value="ADD INSTRUCTOR" type="submit"  readonly></a>
 	<a href="/teacher/list"><input class="btn btn-info" role="button" value="LIST ALL INSTRUCTOR" type="submit"  readonly></a></p>
 	[/#if]
 <table class="table">
  <thead>
     <tr >
  
  
    <th>Number</th>
    <th>Name</th>
    <th>Sir Name</th>
    <th>Car</th>
    <th>Category</th>
    <th>Email</th>
   	[#if permision??]
   	<th>Hire date</th>
   	<th>CNP</th>
   	
   	[/#if]
	 	  	 [#assign nr = 0]
	  		[#if teachers??]
	  		[#list teachers as teacher]
	  			 [#assign nr = nr +1 ]	
	  		  <tr>		
	  				<td > ${nr}  </td>		
	  		<td > 		${teacher.name}   </td>
	  		<td >	 ${teacher.sirName} </td>
	  		<td >	<a class="btn btn-primary" href="/vehicle/list?teacherId=${teacher.id}" role="button">Cars</a>
	  		<td >	 ${teacher.category} </td>
	  		<td >	 ${teacher.email} </td>
	  				[#if permision??]
	  		<td >	 ${teacher.hireDate} </td>
	  		<td >	 ${teacher.cnp} </td>
	  		
	  		<td >
	  			 <form name="form1" action="/teacher/edit" method="POST">
	  				 <input type="hidden" name="id" value="${teacher.id}">
	  			<button  type="submit" class="btn btn-info" value="${teacher.id}">EDIT</button>
	  		</form>
	  		</td>
	  		<td >
	  		 <form name="form1" action="/teacher/delete" method="POST">
	  				 <input type="hidden" name="id" value="${teacher.id}">
	  				 	<button  type="submit" class="btn btn-info" value="${teacher.id}">DEL</button>
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
