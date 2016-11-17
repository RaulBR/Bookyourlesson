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
  <nav class="navbar navbar-dark bg-primary" class="sexy-form">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogOut</font></a>
  		</div>
  	</div>
	</nav>
  <h1> Add vehicles</h1>
  
  	
  [#if errors??][#list errors as error]<format color-"read"><p>${error}</p></format>[/#list][/#if]
  	<form action="/vehicle/save">
  		[#if vehicle??]
  			<input type="hidden" name="id" value="${vehicle.id}" />
  		[/#if]
		<div class="form-group">
			<label for="email">Vehicle Brand</label>
			<input type="text" class="form-control"  name="brand" value="[#if vehicle??]${vehicle.brand}[/#if]">
		</div>
		<div class="form-group">
		    <label for="email">Model</label>
		    <input type="text" class="form-control"  name="carType" value="[#if vehicle??]${vehicle.carType}[/#if]">
		</div>
		<div class="form-group">
		    <label for="email">year</label>
		    <input type="text" class="form-control"  name="year" value="[#if vehicle??]${vehicle.year}[/#if]">
		</div>
		<div class="form-group">
    		<label for="email">Fuel</label>
		    [#assign fuel = ""]
		    [#if vehicle??]
		    	[#assign fuel = vehicle.fuel]
			[/#if]
		    <select class="form-control sel-schedule-option" name="fuel">
				<option value="diesel" [#if fuel == "diesel"]selected[/#if]>Diesel</option>
				<option value="gass" [#if fuel == "gass"]selected[/#if]>Gass</option>
				<option value="gpl" [#if fuel == "gpl"]selected[/#if]>GPL</option>
									        		
			</select>
		</div>
		<div class="form-group">
		    <label for="email">Chassis number</label>
		    <input type="text" class="form-control"  name="chassis" value="[#if vehicle??]${vehicle.chassis}[/#if]">
		</div>
  
		<div class="form-group">
		    <label for="text">licensePlate</label>
		    <input type="text" class="form-control" name="licensePlate" value="[#if vehicle??]${vehicle.licensePlate}[/#if]">
		</div>
		<div class="form-group">
		    <label for="text">engine (cm^3)</label>
		    <input type="text" class="form-control" name="engine" value="[#if vehicle??]${vehicle.engine}[/#if]">
		</div>
 		<div class="form-group">
		    <label for="text">vignettes </label>
		    <input type="date"  class="form-control" name="vignettes" value="[#if vehicle??]${vehicle.vignettes?string('yyyy-MM-dd')}[/#if]">   
		</div>
		<div class="form-group">
		    <label for="text">insurance</label>
		    <input type="date" class="form-control" name="insurance" value="[#if vehicle??]${vehicle.insurance?string('yyyy-MM-dd')}[/#if]">
		</div>
		<div class="form-group">
		    <label for="date">ITP</label>
		    
		    <input type="date" format="dd MM yyyy" class="form-control" name="ITP" value="[#if vehicle??]${vehicle.ITP?string('yyyy-MM-dd')}[/#if]">
		    
		</div>
  
		[#if teachers??]
	  		<div class="form-group">
	  			<label for="text">Teacher</label>
			    [#assign currentTeacher = 0]
			    [#if vehicle??]
			    	[#assign currentTeacher = vehicle.teacherId]
				[/#if]
				<select name="teacherId" class="form-control">
					[#list teachers as teacher]
						<option value="${teacher.id}" [#if currentTeacher == teacher.id]selected[/#if]>${teacher.name} ${teacher.sirName}</option>
					[/#list]
				</select>
	  		</div>
		[#else]
			[#if teacherOBJ??] 
				<input type="hidden" value="${teacherOBJ.id}" name="teacherId">
			[#else]
				[#if vehicle??]
					<input type="hidden" value="${vehicle.teacherId}" name="teacherId">
				[#else]
					Ma-ta ce cauti aici?
				[/#if]
			[/#if]
		[/#if]
	
 		<input class="btn btn-warning" role="button" value="Cancel" onclick="window.location.href='/vehicle/list'" >
		<input class="btn btn-success" role="button" type="submit" value="SAVE" >
	</form>

	<br/>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
