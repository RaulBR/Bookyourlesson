[#ftl]
[#import "/spring.ftl" as spring /]
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
  <h1> Add vehicles</h1>
  
  <form action="/vehicles/save">
  <div class="form-group">
    <label for="email">Vehicle Brand</label>
    <input type="text" class="form-control"  name="brand">
  </div>
  <div class="form-group">
    <label for="email">Model</label>
    <input type="text" class="form-control"  name="_type">
  </div>
  <div class="form-group">
    <label for="email">Fuel</label>
    <input type="text" class="form-control"  name="fuel">
  </div>
  <div class="form-group">
    <label for="email">Chassis number</label>
    <input type="text" class="form-control"  name="chassis">
  </div>
  
  <div class="form-group">
    <label for="text">licensePlate</label>
    <input type="text" class="form-control" name="licensePlate">
  </div>
  <div class="form-group">
    <label for="text">engine</label>
    <input type="text" class="form-control" name="engine">
  </div>
   <div class="form-group">
    <label for="text">vignettes</label>
    <input type="text" class="form-control" vignettes="engine">
  </div>
   <div class="form-group">
    <label for="text">insurance</label>
    <input type="text" class="form-control" name="insurance">
  </div>
  <div class="form-group">
    <label for="text">ITP</label>
    <input type="text" class="form-control" name="ITP">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]
