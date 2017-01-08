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
    <link rel="icon" type="image/png" href="/images/negru.png">
  </head>
  [#escape x as x?html]
  <body>
<div id="result"></div>
<nav class="navbar navbar-dark bg-primary">
 <div class="nav navbar-nav">
    <div class="container">
  <a class="navbar-brand" color="white" href="/logout"> <font color="white"> LogOut</font></a>
  </div>
</nav>

  <h1> Schedule leson</h1>
  
  	<h3>[#if studentOBJ??]${studentOBJ.name!''} ${studentOBJ.sirName!''}[#else]Vizitator[/#if] </h3>
  <h4> [#if instructor??]Instructor:  ${instructor.name!''} ${instructor.sirName!''}[#else]No theacher[/#if] </h4>
 

[#assign dayName= ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]]
 [#assign hourList = [8, 10, 12, 14, 16, 18]]
 <div class="tableContainer"> <table class="table">
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
	  	[#assign student= 0]
	  	[#assign teacher= 0]
	  		[#if schedules??]
	  			[#list schedules as schedule]
	  				[#if schedule.startHour == hour]
	  				[#if schedule.date?string('dd.MM.yyyy')== day]	
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
	  			
	  			
	  		
	  	<td >	<form id="formBut" name="form1" >
	  	
	  	[#if curentSchedule??]<input type="hidden" name="id" value="${curentSchedule}">[/#if]
				<input type="hidden" name="startHour" value="${hour}">
					<input type="hidden" name="endHour" value="${endHour}">
					<input type="hidden" name="date" value="${day}">
					<input type="hidden" name="week" value="${week?c}">
					<input type="hidden" name="studentId" value="${studentOBJ.id}">
					<input type="hidden" name="teacherId" value="${studentOBJ.teacherId}">
					<input type="hidden" id="sts" name="status" value="pending"> 
					
		[#switch statut]
	  			
	  		[#case 'pending']
				
					<div id="sand" >	<p><input id="setButton" class="btn btn-info" role="button" class="btns" name="btn" value="Pending"  onClick="submitButton(this)" readonly /></p>
					</div>			
			[#break]
	  		[#case 'free']
					<div id="sand" >	<p><input  "id="setButton" class="btn btn-default" role="button"class="btns" name="btn" value="Book Lesson" onClick="submitButton(this)" readonly/></p>
					</div>
			[#break]
	  		[#case 'absent']	
	  									<p><input class="btn btn-danger" role="button"  name="btn" value="absent"  class="btns" readonly></p>
	  	  	[#break]
	  	  		 
	  	  	[#case 'notFree']	
	  									<p><input class="btn" role="text"  value="NOT FREE" name="btn"class="btns" readonly></p>
	  	  	[#break]
	  	  		[#case 'done']	
	  									<p><input class="btn btn-success" role="button"   name="btn" value="Done" class="btns" readonly></p>
	  	  	[#break]
	  	  		[#case 'booked']	
	  									<p><input class="btn btn-primary"  role="button" name="btn" value="booked" class="btns" readonly></p>
	  		[#break]
	  	  	  [/#switch]

</form>  </td> 
			
	  [/#list]
	  </tr>
  [/#list]
  
  </tbody>

</table> </div>
<nav aria-label="...">
  <ul class="pager">
    <li><a href="/schedule/previousWeek?week=${week?c}"  >Previous week</a></li>
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

[#if progress??]
<p>Progress: </p>




<div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${done}" aria-valuemin="0" aria-valuemax="100" style="width: ${done}%">
    <span class="sr-only">${done}/30(success)</span>
  Done ${done}%
  </div>
</div>

<div class="progress">

  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: ${progress}%">
    <span class="sr-only"> pending: ${progress}</span>
 
   progress: ${progress}%
  </div>

 </div>
<div class="progress">
  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${absent}" aria-valuemin="0" aria-valuemax="100" style="width: ${absent}%">
    <span class="sr-only">${absent} Absent (danger)</span>
    Absent: ${absent}%
    
  </div>
</div>
[/#if]


  	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    
    <script type="text/javascript">
    
   
    
    	jQuery(document).ready(function(){
    	//var test = "{$hourList}";
    	// console.log(test);
    		var date = new Date();
    		var day = date.getDate(),
    			month = date.getMonth(),
    			year = date.getFullYear();
    			
    		var currDate = (day < 10 ? '0' : '') + day + '.' + (month < 10 ? '0' : '') + month + '.' + year;
    		//console.log(currDate);
    	});
    	
    	
    	 function submitButton(objInput){
    	 $(function(){
  
 var currentButton = $(objInput).parents('div')[0];
 var currentForm = $(objInput).parents('form')[0];


if($(currentForm).find('input[name="btn"]').val()=="Book Lesson"){
$.getJSON("/schedule/saveDated", $(currentForm).serialize() ,
  function(data){
  if(data>0){
  $(currentButton).html("");
  
 	 $(currentForm).find('input[name="id"]').val(data);
  			$(currentButton).html('<p><input id="setButton" class="btn btn-info" role="button"  name="btn" value="Pending"  class="btns" onClick="submitButton(this)" readonly/></p>');
 
 	}else if(data<0){
 	$('#myModal').modal('show');   
 	}
 	else {
 	$(currentButton).html("");
  			$(currentButton).html('<p><input id="setButton" class="btn btn-info" role="button"  name="btn" value="Pending" class="btns"  onClick="submitButton(this)" readonly/></p>');
 		
 	}
 	
  });
}
	

		else if($(currentForm).find('input[name="btn"]').val()=="Pending"){
		
		$.getJSON("/schedule/remove", $(currentForm).serialize() ,
  function(data){
  if(data==1){
  	$(currentButton).html("");
  			$(currentButton).html('<p><input  "id="setButton" class="btn btn-default" role="button" name="btn" value="Book Lesson" class="btns" onClick="submitButton(this)" readonly/></p>');
 		
 
 	}else {
  $(currentButton).html("");
  			$(currentButton).html('<p><input id="setButton" class="btn btn-info" role="button"  name="btn" value="Pending" class="btns"  onClick="submitButton(this)" readonly/></p>');
 
 	}
 	 });
}
 		 


  });
  
    	 
    
    	 };
    	 
    </script>
    <style>
    .btn{
    width:90%;
    }
    </style>
  </body>
</html>
[/#escape]
