[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
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
  <h1> Vehicle list</h1>
 
	[#if permision??]
 	<p><a href="/vehicle"><input class="btn btn-info" role="button" value="ADD VEHICLE" type="submit"  readonly></a>
 	<a href="/vehicle/list"><input class="btn btn-info" role="button" value="LIST ALL VEHICLES" type="submit"  readonly></a></p>
 	[#else]
 	 <h4> [#if teacher??]Instructor:  ${teacher.name!''} ${teacher.sirName!''}
 		<p><a href="/register/student"><input class="btn btn-info" role="button" value="Register"   readonly></a></p>
 	</h4>
 [/#if] 
 	
	[/#if]
	
 
  <table class="table">
  <thead>
     <tr >
  
  
    <th>Number</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Year</th>
    <th>Fuel</th>
   
    <th>Engine (cm^3)</th>
    <th>LicensePlate</th>
    
   	[#if permision??]
   	 <th>Chassis</th>
   	 <th> Vignettes</th>
  	<th> Insurance</th>
  		<th> ITP</th>
  	<th> </th>
   
   	<th>Instructor</th>
  	<th>Edit</th>
   	<th> Delete</th>
   [/#if]  	
	 	  [#assign nr = 0]
	  		[#if vehicles??]
	  		[#list vehicles as vehicle]
	  			 [#assign nr = nr +1 ]	
	  		  <tr>		
	  				<td > ${nr}  </td>		
	  		<td > 		${vehicle.brand}  </td>
	  		<td >	 ${vehicle.carType} </td>
	  		<td >	 ${vehicle.year} </td>
	  		<td >	 ${vehicle.fuel} </td>
	  		<td >	 ${vehicle.engine} </td>	
	  		<td >	 ${vehicle.licensePlate} </td>
	  		
	  		
	  	[#if permision??]
	  		<td >	 ${vehicle.chassis} </td>
	  		<td >	 ${vehicle.vignettes} </td>
	  		<td >	 ${vehicle.insurance} </td>
	  		<td >	 ${vehicle.ITP} </td>
	  		<td >
	  		 <form name="form1" action="/vehicle/list" >
	  				 <input type="hidden" name="teacherId" value="${vehicle.teacherId}">
	  				 	<button  type="submit" class="btn btn-info" value="${vehicle.teacherId}">${vehicle.teacherId}</button>
	  		</form>
	  			</td>
	  			<td >
	  		 <form name="form1" action="/statistics/teacher" >
	  				 <input type="hidden" name="teacherId" value="${vehicle.teacherId}">
	  				 	<button  type="submit" class="btn btn-info" value="${vehicle.teacherId}">See Teacher</button>
	  		</form>
	  			</td>
	  		<td >
	  			 <form name="form1" action="/vehicle/edit" method="POST">
	  				 <input type="hidden" name="id" value="${vehicle.id}">
	  			<button  type="submit" class="btn btn-info" value="${vehicle.id}">EDIT</button>
	  		</form>
	  		</td>
	  		<td >
	  		 <form name="form1" action="/vehicle/delete" method="POST">
	  				 <input type="hidden" name="id" value="${vehicle.id}">
	  				 	<button  type="submit" class="btn btn-info" value="${vehicle.id}">DEL</button>
	  		</form>
	  			</td>
	  			[/#if]
	  			[/#list]
	  			[/#if]
	  			
	  			
	  	
	  		
	  	  		
	  	  	  

	  </tr>
 
  
  </tbody>

</table>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
   
    
    
  </body>
</html>
[/#escape]
