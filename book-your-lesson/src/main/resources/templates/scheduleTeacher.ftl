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
  
  	<h3>[#if name??]${name!''}[#else]Vizitator[/#if] </h3>
  <h4> [#if instructorName??]${instructorName!''}[#else]No theacher[/#if] </h4>
 
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
		  					 [#assign name='vasi']
	  						[#assign sirName='lica'] 				
	  				[#assign statut = schedule.status]
	  				[#assign curentSchedule= schedule.id]
	  				[#assign student= schedule.studentId]
	  				[#assign teacher= schedule.teacherId]
	  				[#break]
	  					[/#if]
	  				[/#if]
	  			[/#list]
	  			[/#if]
	  			
	  			
		  			
				  		<td > 
				  		[#if name??]
				  		
				  			<p>${name} ${sirName}</p> 
				  			[/#if]
				  			<form action="/schedule/edit" method="GET">
								<div align="center"">
 									<input type="hidden" name="week" value="${cal.week?c}">
 									<input type="hidden" name="startHour" value="${hour}">
									<input type="hidden" name="endHour" value="${endHour}">
									<input type="hidden" name="date" value="${day}">								
									<input type="hidden" name="id" value="${curentSchedule}">
									<input type="hidden" name="studentId" value="${student}">
									<input type="hidden" name="teacherId" value="${teacher}">
						[#switch statut]
							[#case 'pending']
									<p><input class="btn btn-default" role="button" value="pending" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
								[#break]
								
								[#case 'free']
									<p><input class="btn btn-default" role="button" value="free" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
								[#break]
								
								[#case 'absent']	
									<p><p><input class="btn btn-danger" role="button" value="absent" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p></p>
								[#break]
								
								[#case 'notFree']
									<p><input class="btn btn-default" role="button" value="notFree" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
								[#break]
								
								[#case 'done']	
									<p>done</p>
								[#break]
								
								[#case 'booked']
									<p><input class="btn btn-primary" role="button" value="booked" title="Afisati actiunile disponibile pt aceasta programare" onclick="showAction(this)"></p>
								[#break]
						[/#switch]
								<select class="form-control sel-status" style="display: none" id="myselect"   name="status" onchange="this.form.submit();"  >
				         			<option value="free" >Free</option>
				        			<option value="notFree">Not free</option>
				        			<option value="booked"  >Accept</option>
				        			<option value="absent" >Absent</option>
				        			<option value="pending" >Pending</option>
				        			<option value="done">Done</option>
			        			
								</select>
						</form>
						</td>
		  	  		
	  	  	 
		[/#list]
	  </tr>
  [/#list]
  
  </tbody>

</table>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.js"></script>
    
    <script type="text/javascript">
    	function showAction(btnStatus)
    	{
    		var selStatus = $(btnStatus).parents('form').find('select.sel-status');
    		if ($(selStatus).is(':visible')) {
    			$(selStatus).hide();
    			$(btnStatus).attr('title', 'Afisati actiunile disponibile pt aceasta programare');
    		} else {
    			$(selStatus).show();
    			$(selStatus).val($(btnStatus).val());
    			$(btnStatus).attr('title', 'Ascundeti actiunile disponibile pt aceasta programare');
    		}
    	}
    	
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
