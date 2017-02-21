
[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
  	
    <title>bydl</title>
	<link rel="icon" type="image/png" href="/images/negru.png">
    
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
	<link href="/js/sch.js" rel="sch">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <script type="text/javascript" src="js/scheduleTeacher.js"></script>
    <![endif]-->
    <base href="" />
  </head>
  [#escape x as x?html]
  <body>
  

  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
   		 <a class="navbar-brand" class="logout" color="white" href="/schedule"> <font color="white">Home</font></a>
   		 <a class="navbar-brand" class="logout" color="white" href="/student/list?teacherId=${teacherOBJ.id}"> <font color="white"> Students</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
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
	  	<td class="btn"  ><p><center><strong >${hour} - ${endHour}</strong></center></p> </td>
	  	
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
							        			<option value="booked">Accept</option>
							        			<option value="absent">Absent</option>
							        			<option value="pending">Pending</option>
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
				         			
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="OK"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Booking info</h4>
		      </div>
		      	<div class="modal-body">
		      	<center>  <p>You can't book a lesson in the past :)</p>
		     	   <p>Contact your teacher for more info</p></center>
		     	 </div>
		     	 <div class="modal-footer">
		     	<center><button type="button" class="btn btn-info" data-dismiss="modal">Ok</button></center>
		        
		      </div>
		    </div>
		  </div>
		</div>
				      			
							
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.js"></script>
    
    <script type="text/javascript">
    
    
    </script>
    
    <style>
    .btn{
    width:90%;
    }
    </style>
  </body>
</html>
[/#escape]
