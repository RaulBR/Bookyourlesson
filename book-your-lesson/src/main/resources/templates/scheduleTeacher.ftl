[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
   <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>bydl</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

   
    
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <base href="" />
    <link rel="icon" type="image/png" href="/images/negru.png">
    <script type="text/javascript" src="/js/scheduleT.js"></script>
    
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
    <p>  </p>
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
	  	[#assign b=0]
	  	[#list weekDays as day]
	  	[#assign dayn=dayName[b]]
	  	[#assign b++]
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
	  				[#assign curentSchedule= schedule.id];
	  				[#assign student= schedule.studentId]
	  				
	  				[#break]
	  					[/#if]
	  				[/#if]
	  			[/#list]
	  			[/#if]
	  			
	  			
		  			
				  		<td > 
				  			<form method="POST">
								<div align="center">
								[#if curentSchedule>0]	<input type="hidden" name="id" value="${curentSchedule?c}">[/#if]
 									<input type="hidden" name="week" value="${week}">
 									<input type="hidden" name="startHour" value="${hour}">
									<input type="hidden" name="endHour" value="${endHour}">
									<input type="hidden" name="date" value="${day}">									
									<input type="hidden" name="teacherId" value="${teacherOBJ.id}">
									<input type="hidden" name="dayName" value="${dayn}">
									
									
										<div id="namePlaceHolder${dayn}${hour}">
										<p >${name} ${sirName}</p>  
										</div>
										
										[#if statut == 'free']
										
										
										<div id="button${dayn}${hour}">
										<p><input class="btn btn-default" name = "status" class="currentButton" role="button" value="free" title="Edit schedule" onclick="submitButton(this)" readonly></p>
										</div>
										
										
									[#else]
										
										<input type="hidden" name="studentId" value="${existingStudentId}">
										[#switch statut]
											[#case 'pending']
													
														
													<div id="button${dayn}${hour}">
														<p><input class="btn btn-info" name="status" role="button" value="pending" title="Show appointment actions" onclick="submitButton(this)" readonly></p>
													</div>
												[#break]
												
												[#case 'free']
													
													
													<div id="button${dayn}${hour}">
														<p><input class="btn btn-default" name="status" role="button" value="free" title="Show appointment actions" onclick="submitButton(this)" readonly></p>
													</div>
												[#break]
												
												[#case 'absent']	
													
													
													<div id="button${dayn}${hour}">
														<p><input class="btn btn-danger" name="status" role="button" value="absent" title="Show appointment actions" onclick="submitButton(this)" readonly></p>
													</div>
												[#break]
												
												[#case 'notFree']
													
														
													<div id="button${dayn}${hour}">
														<p><input class="btn btn-default" name="status" role="button" value="notFree" title="Show appointment actions" onclick="submitButton(this)" readonly></p>
													</div>
												[#break]
												
												[#case 'done']	
													
														
													<div id="button${dayn}${hour}">
														<p><input class="btn btn-success" role="button" value="done" title="Show appointment actions" onclick="submitButton(this)" readonly></p>
													</div>
												[#break]
												
												[#case 'booked']
													
													
													<div id="button${dayn}${hour}">
														<p><input class="btn btn-primary" name="status" role="button" value="booked" title="Show appointment actions" onclick="submitButton(this)" readonly></p>
													</div>
												[#break]
										[/#switch]
										
									[/#if]
	<div class="modal fade" id="myModalStudents" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="OK"><span aria-hidden="true">&times;</span></button>
		        <h4 >Booking</h4>
		      </div>
		      	<div class="modal-body">
		      	[#if students??]
		      	<center> 
		      	<p>Schedue a student:</p>
		     	   
											<select class="form-control sel-schedule-option" id="studentId"  name="studentId">
											
											
													[#list students as student]
													
														<option value="${student.id}" class="op${student.id}"  >${student.name} ${student.sirName} </option>
											
													[/#list]
											
													
											</select>
											
											<br/>
											<button type="button" class="btn btn-default" >Cancel</button>
											<button class="btn btn-primary" onclick="statusSave(this); return false">Save</button>
											
				</center>							
				[/#if]
		     	 </div>
		     	 <div class="modal-footer">
		     
		        
		      </div>
		    </div>
		  </div>
		</div>	
		<div class="modal fade" id="myModalStatus" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="OK"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Booking</h4>
		      </div>
		      	<div class="modal-body">
		      	
		      	<center> 
		      	<p>Change the schedule status:</p>
		     	   <input type="hidden" >
											<select class="form-control sel-schedule-option" name="addStatus">
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
				</center>							
			
		     	 </div>
		     	 <div class="modal-footer">
		     
		        
		      </div>
		    </div>
		  </div>
		</div>
						</form>
						</td>
		  	  		
	  	  	 
		[/#list]
	
	[#if b==6][#assign b=0][/#if]
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
	
	
					         			
				      			
							
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
     

    
    
    <style>
    .btn{
    width:90%;
    }
    </style>
  </body>
</html>
[/#escape]
