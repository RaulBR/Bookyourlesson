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
  		 <a class="navbar-brand" class="logout" color="white" href="/register/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/instructors"> <font color="white"> Instructors</font></a>
 		 
  		</div>
  	</div>
	</nav>
  <h1> Register Teacher </h1>
  
  <form action="/register/teacher/userSave" class="sexy-form" method="POST">
  

   


  </div>
    <div class="form-group">
    <label for="text">Name:</label>
    <input type="text" class="form-control" name="name">
  </div>
   <div class="form-group">
    <label for="text">Sir Name</label>
    <input type="text" class="form-control" name="sirName">
  </div>
  </div>
   <div class="form-group">
    <label for="text">Email</label>
    <input type="email" class="form-control" name="email">
  </div>
    <div class="form-group">
    <label for="text">CNP</label>
    <input type="text" class="form-control" name="cnp">
  </div>
   <div class="form-group">
    <label for="text">Phone Number</label>
    <input type="text" class="form-control" name="phoneNumber">
  </div>
  
   <div class="form-group">
    <label for="text">category</label>
  
   
    <select name="Category"  class="form-control">
     	<option value="B">Category <b>B</b></option>
    	<option value="A">Category <b>A</b></option>
   		<option value="C">Category <b>C</b></option>
  </select>
  </div>
  
   <div class="form-group">
    <label for="text">Medical Papers</label>  
    <select name="medDate"  class="form-control">
    <option value="true"> <b>Yes</b></option>
    <option value="false"> <b>No</b></option>
   
  </select>
  </div>
 
  
 	<div class="form-group" >
    <label for="text">User</label>
    <input type="text" class="form-control" name="user">
  </div>
  <div class="form-group">
    <label for="text">Pasword</label>
    <input type="password" class="form-control" name="pass">
  </div>

  <div class="form-group">
    <label for="text">Repede Password</label>
    <input type="password" class="form-control" name="pass2">
  </div>

 
  <input class="btn btn-success" role="button" type="submit" value="Submit" >
</form>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
