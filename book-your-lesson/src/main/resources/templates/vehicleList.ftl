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
  <h1> Vehicle list</h1>
  
  <table class="table">
  <thead>
     <tr >
    <th >Brand</th>
    <th>Model</th>
    <th>Fuel</th>
    <th>chassis</th>
    <th>Engine</th>
    <th>license Plate</p></th>
    <th>vignettes</p></th>
    <th>insurance</p></th>
    <th>ITP</p></th>
  </tr>
   
  	  <tr>
	  	<td ></td>
	  	
	  	
	  
	  		[#if vehicles??]
	  			[#list vehicles as vehicles]
	  				<td>${vehicles.brand} </td>
	  				<td> ${vehicles.brand}</td>
	  				<td> </td>
	  				<td> </td>
	  				<td> </td>
	  				<td> </td>
	  				<td> </td>
	  				<td> </td>
	  				<td> </td>
	  				
  [/#list]
  
  </tbody>

</table>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]