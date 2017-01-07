[#ftl]
<html>
<head>
<!-- Latest compiled and minified CSS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>bydl</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="icon" type="image/png" href="images/negru.png">
 </head>
 
<body>

 <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
   <a class="navbar-brand" class="logout" color="white" href="/logout"><img  src="/images/alb.png" alt="Mountain View" style="width:30px;height:30px;"></a></center>
  		 

 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
 		 
  		</div>
  	</div>
	</nav>
<div id="fullscreen_bg" class="fullscreen_bg"/>


<div class="container">

</br>
</br>
</br>
</br>

</div>
<div class="container">

    <div class="row vertical-offset-100">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Please sign in</h3>
			    	
			 	</div>
			 	[#if error??]<p>Error: ${error}</p>[/#if]
			  	<div class="panel-body">
			    	<form action="/login"  accept-charset="UTF-8" role="form" method="POST">
                    <fieldset>
			    	  	<div class="form-group">
			    		   <input class="form-control" placeholder="Name" name="user" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Password" name="pass" type="password" value="">
			    		</div>
			    		<div class="checkbox">
			    	    	<label>
			    	    		<input name="remember" type="checkbox" value="Remember Me"> Remember Me
			    	    	</label>
			    	    </div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Sign in">
			    		</br>
			    		
			    	</fieldset>
			    	</form>
			    	<form action="/student" method="POST" accept-charset="UTF-8" role="form">
			    	<input class="btn btn-lg btn-success btn-block" type="submit" value="Student Sign up">
			      	</form>
			      	
			      	<form action="/teacher" method="POST" accept-charset="UTF-8" role="form">
			    	<input class="btn btn-lg btn-success btn-block" type="submit" value="Teacher Sign up">
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
<style>
.body{
padding-top:20px;
}
</style>
</body>
</html>


