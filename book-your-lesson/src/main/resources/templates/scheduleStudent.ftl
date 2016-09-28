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
  
  	<h3>[#if studentOBJ??]${studentOBJ.name!''} ${studentOBJ.sirName!''}[#else]Vizitator[/#if] </h3>
  <h4> [#if instructor??]Instructor:  ${instructor.name!''} ${instructor.sirName!''}[#else]No theacher[/#if] </h4>
 

[#assign dayName= ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]]
 [#assign hourList = [8, 10, 12, 14, 16, 18]]
  <table class="table">
  <thead>
     <tr >
    <th >Hour
    <p> </p>
    
    </th>
    [#assign a=0]
 		[#list weekDays as  day]
 			[#assign dayn=dayName[a]]
			 <th>${dayn}  <p>${day}</p></th>
			[#assign a++]
		 [/#list]
  
  	</tr>
  

  
 
  
  
  [#list hourList as hour]
	  [#assign endHour = hour + 2]
  	  <tr>
	  	<td ><strong>${hour} - ${endHour}</strong></td>
	  	
	  	[#list weekDays as day]
	  	
	  	[#assign curentSchedule= 0]
	  	[#assign statut = 'free']
	  	[#assign student= 0]
	  	[#assign teacher= 0]
	  		[#if schedules??]
	  			[#list schedules as schedule]
	  				[#if schedule.startHour == hour]
	  				[#if schedule.date== day]
		  				  				
	  				[#assign statut = schedule.status]
	  				[#assign curentSchedule= schedule.id]
	  				[#assign student= schedule.studentId]
	  				[#assign teacher= schedule.teacherId]
	  				[#break]
	  					[/#if]
	  				[/#if]
	  			[/#list]
	  			[/#if]
	  			
	  			[#if curentSchedule > 0]
	  				[#if student != studentOBJ.id]
	  					[#assign statut = 'notFree']
	  				[/#if]
	  			[/#if]
	  			[#switch statut]
	  			[#case 'pending']
	  			
	  		<td >  <form name="form1" action="/schedule/removeDate" method="POST">
					<input type="hidden" name="startHour" value="${hour}">
					<input type="hidden" name="endHour" value="${endHour}">
					<input type="hidden" name="date" value="${day}">
					<input type="hidden" name="week" value="${week?c}">
					<input type="hidden" name="id" value="${curentSchedule}">
					<input type="hidden" name="studentId" value="${studentOBJ.id}">
					<input type="hidden" name="teacherId" value="${studentOBJ.teacherId}">
					
					<p><input class="btn btn-warning" role="button" type="submit" value="PENDING" ></p>
					 </p></form>  </td>
					 [#break]
	  		[#case 'free']
	  	<td >	<form name="form1" action="/schedule/saveDate" method="POST">
					<input type="hidden" name="startHour" value="${hour}">
					<input type="hidden" name="endHour" value="${endHour}">
					<input type="hidden" name="date" value="${day}">
					<input type="hidden" name="week" value="${week?c}">
					<input type="hidden" name="studentId" value="${studentOBJ.id}">
					<input type="hidden" name="teacherId" value="${studentOBJ.teacherId}">
					<input type="hidden" name="status" value="pending">
					
			<p><input class="btn btn-default" role="button" type="submit" value="Book Lesson" ></p>
</form>  </td>
			[#break]
	  		[#case 'absent']	
	  	<td>	<p><p><input class="btn btn-danger" role="button"  value="ABSENT" ></p></p></td>
	  	  	[#break]
	  	  		 
	  	  	[#case 'notFree']	
	  		<td><p><p><input class="btn" role="text"  value="NOT FREE" readonly></p></p></td>
	  	  	[#break]
	  	  		[#case 'done']	
	  		<td><p>done</p></td>
	  	  	[#break]
	  	  		[#case 'booked']	
	  		<td><p><input class="btn btn-success" role="button" type="submit" value="Booked" ></p></td>
	  		[#break]
	  	  	  [/#switch]
	  [/#list]
	  </tr>
  [/#list]
  
  </tbody>

</table>
<nav aria-label="...">
  <ul class="pager">
    <li><a href="/schedule/previousWeek?week=${week?c}" data-toggle='modal' id='2'a >Previous week</a></li>
    <li><a href="/schedule/thisWeek">This week</a></li>
    <li><a href="/schedule/nextWeek?week=${week?c}">Next week</a></li>
  </ul>
</nav>
<p>Progress: </p>




<div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${done}" aria-valuemin="0" aria-valuemax="100" style="width: ${done}%">
    <span class="sr-only">${done}/30(success)</span>
   ${done}/30(success)
  </div>
</div>

<div class="progress">

  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: ${progress}%">
    <span class="sr-only"> pending: ${progress}</span>
 
    ${progress}
  </div>

 </div>
<div class="progress">
  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${absent}" aria-valuemin="0" aria-valuemax="100" style="width: ${absent}%">
    <span class="sr-only">${absent} Absent (danger)</span>
    Absent: ${absent};
    
  </div>
</div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    <script type="text/javascript">
    
    	jQuery(document).ready(function(){
    	//var test = "{$hourList}";
    	// console.log(test);
    		var date = new Date();
    		var day = date.getDate(),
    			month = date.getMonth(),
    			year = date.getFullYear();
    			
    		var currDate = (day < 10 ? '0' : '') + day + '.' + (month < 10 ? '0' : '') + month + '.' + year;
    		console.log(currDate);
    	});
    </script>
  </body>
</html>
[/#escape]
