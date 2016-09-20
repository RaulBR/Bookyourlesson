[#ftl]
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
<div id="fullscreen_bg" class="fullscreen_bg"/>

<div class="container">

    <form action="/login" method="POST">
		<h1 class="form-signin-heading text-muted">Sign In</h1>
		<input name="name" type="text" class="form-control" placeholder="Name" required="required"/>
		 <input	name="password" type="password" class="form-control" placeholder="Password" required="required"/> 
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Sign In
		</button>
	</form>

</div>
	    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
</body>
</html>


