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
    <base href="/apx/" />
    
  </head>
  [#escape x as x?html]
  <body>
  

  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		  <a class="navbar-brand" class="logout" color="white" href="/student/list"> <font color="white"> Students</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/statistics"> <font color="white"> Situation</font></a>
  		  <a class="navbar-brand" class="logout" color="white" href="/schedule"> <font color="white"> Schedule</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogOut</font></a>
  		</div>
  	</div>
	</nav>
  <h1> Schedule leson</h1>
 
  	
  <h3 class="sexy-text"> [#if teacherOBJ??]${teacherOBJ.name} ${teacherOBJ.sirName} 
  [#assign teacher=teacherOBJ.id][#else]No theacher[/#if] </h3>
  
  
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
	  	<td class="btn"><center><strong>${hour} - ${endHour}</strong></center></td>
	  	
	  	[#list weekDays as day]
	  	
	  	[#assign curentSchedule= 0]
	  	[#assign statut = 'free']
	  	
	  	[#assign name='']
	  	[#assign sirName='']
	  		[#if schedules??]
	  			[#list schedules as schedule]
	  				[#if schedule.startHour == hour]
	  				[#if schedule.date?string('dd.MM.yyyy')== day]
	  				[#if students??]
				  		[#list students as student]
				  		[#if student.id == schedule.studentId]
				  		 [#assign name=student.name]
	  						[#assign sirName=student.sirName]
				  			[#assign existingStudentId=student.id]
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
 									<input type="hidden" name="week" value="${week}">
 									<input type="hidden" name="startHour" value="${hour}">
									<input type="hidden" name="endHour" value="${endHour}">
									<input type="hidden" name="date" value="${day}">								
									<input type="hidden" name="id" value="${curentSchedule}">
									<input type="hidden" name="teacherId" value="${teacherOBJ.id}">
									
									[#if statut == 'free']
										<p><input class="btn btn-default" role="button" value="free" title="Edit schedule" onclick="showAction(this)" readonly></p>
										<div class="wrap-schedule-option" style="display: none">
										<input type="hidden" name="status" value="booked">
											<select class="form-control sel-schedule-option" id="studentId"  name="studentId">
												[#if students??]
											
													[#list students as student]
													
														<option value="${student.id}" >${student.name} ${student.sirName} </option>
											
													[/#list]
											
													[/#if]
											</select>
											<br/>
											<button type="button" class="btn btn-default" onclick="statusCancel(this)">Cancel</button>
											<button class="btn btn-primary" onclick="statusSave(this); return false">Save</button>
										</div>
										
									[#else]
										
										<input type="hidden" name="studentId" value="${existingStudentId}">
										[#switch statut]
											[#case 'pending']
													<p><input class="btn btn-info" role="button" value="pending" title="Show appointment actions" onclick="showAction(this)" readonly></p>
												[#break]
												
												[#case 'free']
													<p><input class="btn btn-default" role="button" value="free" title="Show appointment actions" onclick="showAction(this)" readonly></p>
												[#break]
												
												[#case 'absent']	
													<p><p><input class="btn btn-danger" role="button" value="absent" title="Show appointment actions" onclick="showAction(this)" readonly></p></p>
												[#break]
												
												[#case 'notFree']
													<p><input class="btn btn-default" role="button" value="notFree" title="Show appointment actions" onclick="showAction(this)" readonly></p>
												[#break]
												
												[#case 'done']	
													<p><input class="btn btn-success" role="button" value="done" title="Show appointment actions" onclick="showAction(this)" readonly></p>
												[#break]
												
												[#case 'booked']
													<p><input class="btn btn-primary" role="button" value="booked" title="Show appointment actions" onclick="showAction(this)" readonly></p>
												[#break]
										[/#switch]
										<div class="wrap-schedule-option" style="display: none">
											<select class="form-control sel-schedule-option" name="status">
							         			<option value="free" >Free</option>
							        			<option value="notFree">Not free</option>
							        			<option value="booked"  >Accept</option>
							        			<option value="absent" >Absent</option>
							        			<option value="pending" >Pending</option>
							        			<option value="done">Done</option>
											</select>
											<br/>
											<button type="button" class="btn btn-default" onclick="statusCancel(this)">Cancel</button>
											<button class="btn btn-primary" onclick="statusSave(this); return false">Save</button>
										</div>
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
    <li><a href="/schedule/previousWeek?week=${week?c}" data-toggle='modal' id='2'a >Previous week</a></li>
    <li><a href="/schedule/thisWeek">This week</a></li>
    <li><a href="/schedule/nextWeek?week=${week?c}">Next week</a></li>
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
    		var editAction = $(currentForm).find('div.wrap-schedule-option');
    		var selStatus = $(currentForm).find('select.sel-schedule-option');
    		
    		if ($(editAction).is(':visible')) {
    			$(editAction).hide();
    			$(btnStatus).attr('title', 'Show appointment actions');
    		} else {
    			$(editAction).show();
    			$(selStatus).val($(btnStatus).val());
    			$(btnStatus).attr('title', 'Hide appointment actions');
    		}
    	}
    	function statusSave(btnSave)
    	{
    		var currentForm = $(btnSave).parents('form');
    		var btnStatus = $(currentForm).find('input.btn');
    		var selStatus = $(currentForm).find('select.sel-schedule-option');
    		
    		if ($(btnStatus).val() == $(selStatus).val()) {
    			alert('No status changes were made to the appointment.');
    			return false;
    		}
    		
    		if ($(btnStatus).val() == 'free') {
    			// if current status is "Free" any change should go to inserting a schedule
    			$(currentForm).attr('action', '/schedule/saveDate');
    		} else {
	    		if ($(selStatus).val() == 'free') {
	    			// if we are freeing a schedule, it means we are deleting it
	    			if (confirm('Are you sure you want to delete the current appointment?')) {
	    				$(currentForm).attr('action', '/schedule/removeDate');
	    				// $(currentForm).submit();
	    			}
	    		} else {
	    			// any other status change is an edit
    				$(currentForm).attr('action', '/schedule/edit');
    			}
    		}
			$(currentForm).submit();
    	}
    	function statusCancel(btnCancel)
    	{
    		$(btnCancel).parents('div.wrap-schedule-option').hide();
    	}
    </script>
  </body>
</html>
[/#escape]
