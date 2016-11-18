

[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
     <title>bydl</title>

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
    <div class="container">
  <a class="navbar-brand" color="white" href="/logout"> <font color="white"> LogOut</font></a>
  </div>
</nav>

  <h1> Schedule leson</h1>
  
  	<div class="set-size charts-container">
  <div class="pie-wrapper progress-30">
    <span class="label">30<span class="smaller">%</span></span>
    <div class="pie">
      <div class="left-side half-circle"></div>
      <div class="right-side half-circle"></div>
    </div>
  </div>

  <div class="pie-wrapper progress-60">
    <span class="label">60<span class="smaller">%</span></span>
    <div class="pie">
      <div class="left-side half-circle"></div>
      <div class="right-side half-circle"></div>
    </div>
  </div>

  <div class="pie-wrapper progress-90">
    <span class="label">90<span class="smaller">%</span></span>
    <div class="pie">
      <div class="left-side half-circle"></div>
      <div class="right-side half-circle"></div>
    </div>
  </div>

  <div class="pie-wrapper progress-45 style-2">
    <span class="label">45<span class="smaller">%</span></span>
    <div class="pie">
      <div class="left-side half-circle"></div>
      <div class="right-side half-circle"></div>
    </div>
    <div class="shadow"></div>
  </div>

  <div class="pie-wrapper progress-75 style-2">
    <span class="label">75<span class="smaller">%</span></span>
    <div class="pie">
      <div class="left-side half-circle"></div>
      <div class="right-side half-circle"></div>
    </div>
    <div class="shadow"></div>
  </div>

  <div class="pie-wrapper progress-95 style-2">
    <span class="label">95<span class="smaller">%</span></span>
    <div class="pie">
      <div class="left-side half-circle"></div>
      <div class="right-side half-circle"></div>
    </div>
    <div class="shadow"></div>
  </div>
  
  <div class="pie-wrapper pie-wrapper--solid progress-65">
    <span class="label">65<span class="smaller">%</span></span>
  </div>
  
  <div class="pie-wrapper pie-wrapper--solid progress-25">
    <span class="label">25<span class="smaller">%</span></span>
  </div>
  
  <div class="pie-wrapper pie-wrapper--solid progress-88">
    <span class="label">88<span class="smaller">%</span></span>
  </div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
   
  </body>
</html>
[/#escape]


