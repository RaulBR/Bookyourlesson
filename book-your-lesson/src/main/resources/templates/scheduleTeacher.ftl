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
 
  	<h3>[#if name??]${name!''}[/#if] </h3>
  <h4> [#if teacher??]${teacher.name} ${teacher.sirName} 
  [#assign teacher= teacher.id][#else]No theacher[/#if] </h4>
 
  <table class="table">
  <thead>
     <tr >
    <th >Hour
    <p> </p></th>
    <th>Monday
    <p>${cal.monday!''}</p></th>
    <th>Tuesday
    <p>${cal.tuesday!''}</p></th>
    <th>Wednesday
    <p>${cal.wednesday!''}</p></th>
    <th>Thursday
    <p>${cal.thursday!''}</p></th>
    <th>Friday
    <p>${cal.friday!''}</p></th>
    <th>Saturday
    <p>${cal.saturday!''}</p></th>
    <th>Sunday
    <p>${cal.sunday!''}</p></th>
    
  </tr>
  

  
  [#assign hourList = [8, 10, 12, 14, 16, 18]]
  
  
  [#list hourList as hour]
	  [#assign endHour = hour + 2]
  	  <tr>
	  	<td ><strong>${hour} - ${endHour}</strong></td>
	  	
	  	[#list weekDay as day]
	  	
	  	[#assign curentSchedule= 0]
	  	[#assign statut = 'free']
	  	[#assign student= 1]
	  	[#assign teacher= 2]
	  	[#assign name='']
	  	[#assign sirName='']
	  		[#if schedules??]
	  			[#list schedules as schedule]
	  				[#if schedule.startHour == hour]
	  				[#if schedule.date== day]
	  				[#if students??]
				  		[#list students as student]
				  		[#if student.id == schedule.studentId]
				  		 [#assign name=student.name]
	  						[#assign sirName=student.sirName]
				  			
				  			[#break]
				  			[/#if]
				  			[/#list]
				  					  			
				  			[/#if]
		  					 
	  						[#if schedule.status??]				
	  				[#assign statut = schedule.status]
	  				[#else]
	  				[#assign statut = 'pending']
	  				[/#if]
	  				[#assign curentSchedule= schedule.id]
	  				[#assign student= schedule.studentId]
	  				
	  				[#break]
	  					[/#if]
	  				[/#if]
	  			[/#list]
	  			[/#if]
	  			
	  			
		  			
				  		<td > 
				  		[#if name??]
				  		
				  			<p>${name} ${sirName}</p> 
				  			[/#if]
				  			<form action="/schedule/edit" method="POST">
								<div align="center"">
 									<input type="hidden" name="week" value="${cal.week?c}">
 									<input type="hidden" name="startHour" value="${hour}">
									<input type="hidden" name="endHour" value="${endHour}">
									<input type="hidden" name="date" value="${day}">								
									<input type="hidden" name="id" value="${curentSchedule}">
									<input type="hidden" name="teacherId" value="${teacher}">
									<input type="hidden" name="studentId" value="${student}">
									[#if statut == 'free']
										<p><input class="btn btn-default" role="button" value="free" title="Edit schedule" onclick="showAction(this)"></p>
										
										<select class="form-control sel-schedule-option" style="display: none" id="studentId"  name="studentId" onchange="this.form.submit();"  >
											[#if students??]
											
											[#list students as student]
											<option value="${student.id}" >${student.name} ${student.sirName}</option>
											
											[/#list]
											
											[/#if]
										</select>
									[#else]
										<input type="hidden" name="studentId" value="${student}">
										[#switch statut]
											[#case 'pending']
													<p><input class="btn btn-default" role="button" value="pending" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
												[#break]
												
												[#case 'free']
													<p><input class="btn btn-default" role="button" value="free" title="Edit schedule" onclick="showAction(this)"></p>
												[#break]
												
												[#case 'absent']	
													<p><p><input class="btn btn-danger" role="button" value="absent" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p></p>
												[#break]
												
												[#case 'notFree']
													<p><input class="btn btn-default" role="button" value="notFree" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
												[#break]
												
												[#case 'done']	
													<p><input class="btn btn-success" role="button" value="done" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
												[#break]
												
												[#case 'booked']
													<p><input class="btn btn-primary" role="button" value="booked" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
												[#break]
										[/#switch]
										<select class="form-control sel-schedule-option" style="display: none" id="myselect"   name="status" onchange="this.form.submit();"  >
						         			<option value="free" >Free</option>
						        			<option value="notFree">Not free</option>
						        			<option value="booked"  >Accept</option>
						        			<option value="absent" >Absent</option>
						        			<option value="pending" >Pending</option>
						        			<option value="done">Done</option>
					        			
										</select>
									[/#if]
						</form>
						</td>
		  	  		
	  	  	 
		[/#list]
	  </tr>
  [/#list]
  
  </tbody>

</table>
<nav aria-label="...">
  <ul class="pager">
    <li><a href="/schedule/previousWeek?week=${cal.week?c}" data-toggle='modal' id='2'a >Previous week</a></li>
    <li><a href="/schedule/thisWeek">This week</a></li>
    <li><a href="/schedule/nextWeek?week=${cal.week?c}">Next week</a></li>
  </ul>
</nav>
				         			
				      			
							
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.js"></script>
    <script type="text/javascript">
    	function showAction(btnStatus)
    	{
    		var currentForm = $(btnStatus).parents('form');
    		if ($(btnStatus).val() == 'free') {
    			$(currentForm).attr('action', '/schedule/saveDate');
    		} else {
    			$(currentForm).attr('action', '/schedule/edit');
    		}
    		var selStatus = $(currentForm).find('select.sel-schedule-option');
    		if ($(selStatus).is(':visible')) {
    			$(selStatus).hide();
    			$(btnStatus).attr('title', 'Afisati actiunile disponibile pt aceasta programare');
    		} else {
    			$(selStatus).show();
    			$(selStatus).val($(btnStatus).val());
    			$(btnStatus).attr('title', 'Ascundeti actiunile disponibile pt aceasta programare');
    		}
    	}
    </script>
  </body>
</html>
[/#escape]
