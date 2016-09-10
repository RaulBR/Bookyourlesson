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
  <h1> Schedule leson</h1>
  	<h3>    Untiliztor: ${name} </h3>
  <h4> name Instructor </h4>
  <p></p>
  <table class="table">
  <thead>
     <tr align="center">
    <th >Hour
    <p> </p></th>
    <th>Monday
    <p>${cal.monday}</p></th>
    <th>Tuesday
    <p>${cal.tuesday}</p></th>
    <th>Wednesday
    <p>${cal.wednesday}</p></th>
    <th>Thursday
    <p>${cal.thursday}</p></th>
    <th>Friday
    <p>${cal.friday}</p></th>
    <th>Saturday
    <p>${cal.saturday}</p></th>
    <th>Sunday
    <p>${cal.sunday}</p></th>
    
  </tr>
  
  [#assign hourList = [8, 10, 12, 14, 16, 18]]
  [#assign dayList = [cal.monday, cal.tuesday, cal.wednesday,cal.thursday, cal.friday, cal.saturday, cal.sunday]]
  [#list hourList as hour]
	  [#assign endHour = hour + 2]
  	  <tr>
	  	<td align="center"><strong>${hour} - ${endHour}</strong></td>
	  	[#list dayList as day]
	  		[#if cal.isFree == true]
	  		
	  			<td align="center"> <p><a href="/schedule/saveDate?starHour=${hour}&endHour=${endHour}&date=${day}&week=${cal.week?c}" class="btn btn-default" role="button">Book Lesson</a> </p></td>
	  		
	  		[#else]
	  		<td align="center">event</td>
	  		
	  		[/#if]
	  [/#list]
	  </tr>
  [/#list]
  
  </tbody>
</table>
<nav aria-label="...">
  <ul class="pager">
    <li><a href="/schedule/previousWeek?week=${cal.week?c}" data-toggle='modal' id='2'a >Previous week</a></li>
    <li><a href="/schedule">This week</a></li>
    <li><a href="/schedule/nextWeek?week=${cal.week?c}">Next week</a></li>
  </ul>
</nav>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
  </body>
</html>
[/#escape]
