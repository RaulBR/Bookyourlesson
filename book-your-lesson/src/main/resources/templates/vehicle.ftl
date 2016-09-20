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
  <h1> Add vehicles</h1>
  
  <form action="/vehicle/save">
  <div class="form-group">
    <label for="email">Vehicle Brand</label>
    <input type="text" class="form-control"  name="brand">
  </div>
  <div class="form-group">
    <label for="email">Model</label>
    <input type="text" class="form-control"  name="carType">
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
    <input type="text" class="form-control" name="vignettes">
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
