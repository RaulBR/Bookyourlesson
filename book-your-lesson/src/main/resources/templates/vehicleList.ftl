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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

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
    <base href="/apx/" />
    
  </head>
  [#escape x as x?html]
  <body>
   <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/register/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/progress"> <font color="white"> Instructors</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogIn</font></a>
  		</div>
  	</div>
	</nav>
  <h1> Vehicle list</h1>
  
  <table class="table">
  <thead>
     <tr >
  
  
    <th>Number</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Fuel</th>
    <th>Chassis</th>
    <th>Engine</th>
    <th>LicensePlate</th>
   	<th> Vignettes</th>
  	<th> Insurance</th>
   	<th> ITP</th>
  	<th>Edit</th>
   	<th> Delete</th>
 
   
  
 
  	
	 	  	 [#assign nr = 0]
	  		[#if vehicles??]
	  		[#list vehicles as vehicle]
	  			 [#assign nr = nr +1 ]	
	  		  <tr>		
	  				<td > ${nr}  </td>		
	  		<td > 		${vehicle.brand}  </td>
	  		<td >	 ${vehicle.carType} </td>
	  		<td >	 ${vehicle.fuel} </td>
	  		<td >	 ${vehicle.chassis} </td>		
	  		<td >	 ${vehicle.engine} </td>	
	  		<td >	 ${vehicle.licensePlate} </td>
	  		<td >	 ${vehicle.vignettes?c} </td>
	  		<td >	 ${vehicle.insurance?c} </td>
	  		<td >	 ${vehicle.ITP?c} </td>
	  		
	  		
	  		 <form name="form1" action="edit">
	  				 <input type="hidden" class="form-control"  name="brand" value="${vehicle.brand}">
					<input type="hidden" class="form-control"  name="carType" value= ${vehicle.carType}"> 
					<input type="hidden" class="form-control"  name="fuel" value="${vehicle.fuel}">
					<input type="hidden" class="form-control"  name="chassis" value=" ${vehicle.chassis}">
					<input type="hidden" class="form-control" name="licensePlate" value=" ${vehicle.licensePlate}">
					<input type="hidden" class="form-control" name="engine" value=" ${vehicle.engine}">
					<input type="hidden" class="form-control" name="vignettes" value="${vehicle.vignettes?c}">
					<input type="hidden" class="form-control" name="insurance" value=" ${vehicle.insurance?c}">
					<input type="hidden" class="form-control" name="ITP" value="${vehicle.ITP?c}">
	  				 <input type="hidden" name="id" value="${vehicle.id}">
	  		<td >	<button  type="submit" class="btn btn-info" value="${vehicle.id}">EDIT</button></td>
	  		</form>
	  		 <form name="form1" action="delete">
	  				 <input type="hidden" class="form-control"  name="brand" value="${vehicle.brand}">
					<input type="hidden" class="form-control"  name="carType" value= ${vehicle.carType}"> 
					<input type="hidden" class="form-control"  name="fuel" value="${vehicle.fuel}">
					<input type="hidden" class="form-control"  name="chassis" value=" ${vehicle.chassis}">
					<input type="hidden" class="form-control" name="licensePlate" value=" ${vehicle.licensePlate}">
					<input type="hidden" class="form-control" name="engine" value=" ${vehicle.engine}">
					<input type="hidden" class="form-control" name="vignettes" value="${vehicle.vignettes?c}">
					<input type="hidden" class="form-control" name="insurance" value=" ${vehicle.insurance?c}">
					<input type="hidden" class="form-control" name="ITP" value="${vehicle.ITP?c}">
	  				 <input type="hidden" name="id" value="${vehicle.id}">
	  		<td >	<button  type="submit" class="btn btn-info" value="${vehicle.id}">DEL</button></td>
	  		</form>
	  			[/#list]
	  			[/#if]
	  			
	  			
	  	
	  		
	  	  		
	  	  	  
	
	  </tr>
 
  
  </tbody>

</table>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
